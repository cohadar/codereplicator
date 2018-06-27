package cohadar.tools.replicator.handlers;

import cohadar.tools.replicator.actions.Target;
import cohadar.tools.replicator.gui.MainFrame;

public class ActionDispatcher implements Target {
	private MainFrame mainFrame;

	public ActionDispatcher(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void decFont() {
		mainFrame.decFont();
		mainFrame.reFocus();
	}

	@Override
	public void incFont() {
		mainFrame.incFont();
		mainFrame.reFocus();
	}

	@Override
	public void az() {
		mainFrame.az();
		mainFrame.reFocus();
	}

	@Override
	public void range() {
		mainFrame.range();
		mainFrame.reFocus();
	}

	@Override
	public void help() {
		mainFrame.help();
		mainFrame.reFocus();
	}

	@Override
	public void cut() {
		mainFrame.getFocusedOne().cut();
		mainFrame.reFocus();
	}

	@Override
	public void copy() {
		mainFrame.getFocusedOne().copy();
		mainFrame.reFocus();
	}

	@Override
	public void paste() {
		mainFrame.getFocusedOne().paste();
		mainFrame.reFocus();
	}

	@Override
	public void delete() {
		mainFrame.getFocusedOne().delete();
		mainFrame.reFocus();
	}

	@Override
	public void selectAll() {
		mainFrame.getFocusedOne().selectAll();
		mainFrame.reFocus();
	}

	@Override
	public void copyAll() {
		mainFrame.getOutput().copyAll();
		mainFrame.reFocus();
	}

	@Override
	public void copyBlock() {
		mainFrame.getOutput().copyBlock();
		mainFrame.reFocus();
	}
	
	@Override
	public void undo() {
		mainFrame.getFocusedOne().undo();
		mainFrame.reFocus();
	}

	@Override
	public void redo() {
		mainFrame.getFocusedOne().redo();
		mainFrame.reFocus();
	}



}
