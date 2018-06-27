package cohadar.tools.replicator.actions;

import javax.swing.Action;

import cohadar.tools.replicator.actions.c.AzAction;
import cohadar.tools.replicator.actions.c.CopyAction;
import cohadar.tools.replicator.actions.c.CopyAllAction;
import cohadar.tools.replicator.actions.c.CopyBlockAction;
import cohadar.tools.replicator.actions.c.CutAction;
import cohadar.tools.replicator.actions.c.DecFontAction;
import cohadar.tools.replicator.actions.c.DeleteAction;
import cohadar.tools.replicator.actions.c.HelpAction;
import cohadar.tools.replicator.actions.c.IncFontAction;
import cohadar.tools.replicator.actions.c.PasteAction;
import cohadar.tools.replicator.actions.c.RangeAction;
import cohadar.tools.replicator.actions.c.RedoAction;
import cohadar.tools.replicator.actions.c.SelectAllAction;
import cohadar.tools.replicator.actions.c.UndoAction;

public class Actions {
	public static final Action DEC_FONT = new DecFontAction();
	public static final Action INC_FONT = new IncFontAction();
	public static final Action AZ = new AzAction();
	public static final Action RANGE = new RangeAction();
	public static final Action HELP = new HelpAction();
	public static final Action CUT = new CutAction();
	public static final Action COPY = new CopyAction();
	public static final Action PASTE = new PasteAction();
	public static final Action DELETE = new DeleteAction();
	public static final Action SELECT_ALL = new SelectAllAction();
	public static final Action COPY_ALL = new CopyAllAction();
	public static final Action COPY_BLOCK = new CopyBlockAction();
	public static final Action UNDO = new UndoAction();
	public static final Action REDO = new RedoAction();

	private static Target target;

	public static void setTarget(Target target) {
		Actions.target = target;
	}
	
	public static Target getTarget() {
		return Actions.target;
	}
}
