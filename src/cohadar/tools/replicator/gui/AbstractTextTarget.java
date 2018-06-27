package cohadar.tools.replicator.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Caret;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import cohadar.swing.text.AbstractSyntaxPane;
import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.handlers.CodeUndoManager;
import cohadar.tools.replicator.handlers.TextTarget;

public abstract class AbstractTextTarget extends AbstractSyntaxPane implements
		TextTarget, CaretListener, FocusListener {
	private final CodeUndoManager undoManager;
	private final MainFrame mainFrame;

	public AbstractTextTarget(MainFrame mainFrame, int rows, int columns) {
		super(rows, columns);
		this.mainFrame = mainFrame;
		this.setTabSize(4);
		this.addCaretListener(this);
		this.addFocusListener(this);
		this.undoManager = new CodeUndoManager(this.getDocument());
	}

	public void delete() {
		this.replaceSelection(null);
	}

	@Override
	public void undo() {
		try {
			undoManager.undo();
		} catch (CannotUndoException ex) {
			System.err.println("Unable to undo: " + ex);
			ex.printStackTrace();
		}
		undoManager.updateUndoRedo();
	}

	@Override
	public void redo() {
		try {
			undoManager.redo();
		} catch (CannotRedoException ex) {
			System.err.println("Unable to redo: " + ex);
			ex.printStackTrace();
		}
		undoManager.updateUndoRedo();
	}

	private void caretUpdate(boolean noSelection) {
		if (noSelection) {
			Actions.CUT.setEnabled(false);
			Actions.COPY.setEnabled(false);
			Actions.DELETE.setEnabled(false);
		} else {
			Actions.CUT.setEnabled(true);
			Actions.COPY.setEnabled(true);
			Actions.DELETE.setEnabled(true);
		}
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		caretUpdate(e.getDot() == e.getMark());
	}

	@Override
	public void focusGained(FocusEvent e) {
		mainFrame.setFocusedOne(this);
		undoManager.updateUndoRedo();
		Caret c = this.getCaret();
		caretUpdate(c.getDot() == c.getMark());
	}

	@Override
	public void focusLost(FocusEvent e) {
		//
	}
}
