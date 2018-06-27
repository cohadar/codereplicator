package cohadar.tools.replicator.handlers;

import javax.swing.undo.CannotUndoException;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEdit;

// Guy that designed CompoundEdit should be shot as an example.
public class MyCompoundEdit extends CompoundEdit {

	public MyCompoundEdit(UndoableEdit anEdit) {
		super.addEdit(anEdit);
	}

	private boolean used = false;

	// Use this in undoManager to break inProgress CompoundEdit
	public boolean hasBeenUsed() {
		return used;
	}

	@Override
	public void undo() throws CannotUndoException {
		super.undo();
		used = true;
	}

	// Use this in undoManager instead of addEdit
	public void appendEdit(UndoableEdit anEdit) {
		super.addEdit(anEdit);
	}

	@Override
	public boolean addEdit(UndoableEdit anEdit) {
		return false;
	}

	@Override
	public boolean replaceEdit(UndoableEdit anEdit) {
		return false;
	}

	@Override
	public boolean isSignificant() {
		return true;
	}

	@Override
	public boolean isInProgress() {
		return false;
	}
}
