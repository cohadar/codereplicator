package cohadar.tools.replicator;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cohadar.tools.replicator.actions.Actions;
import cohadar.tools.replicator.gui.MainFrame;
import cohadar.tools.replicator.gui.popups.GenericPopupMenu;
import cohadar.tools.replicator.gui.popups.OutputPopupMenu;
import cohadar.tools.replicator.handlers.ActionDispatcher;
import cohadar.tools.replicator.handlers.PeriodicTimer;
import cohadar.tools.replicator.handlers.PopupListener;

public class Main {

	private static MainFrame mainFrame;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				linkActionsWithTargets();
				loadTemplate();
			}
		});
	}

	static void createAndShowGUI() {
		new Resources();
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}

	static void linkActionsWithTargets() {
		mainFrame.getList1().addMouseListener(
				new PopupListener(new GenericPopupMenu(mainFrame.getList1())));
		mainFrame.getList2().addMouseListener(
				new PopupListener(new GenericPopupMenu(mainFrame.getList2())));
		mainFrame.getInput().addMouseListener(
				new PopupListener(new GenericPopupMenu(mainFrame.getInput())));
		mainFrame.getOutput().addMouseListener(
				new PopupListener(new OutputPopupMenu(mainFrame.getOutput())));

		new PeriodicTimer(mainFrame);

		Actions.setTarget(new ActionDispatcher(mainFrame));
	}

	static void loadTemplate() {
		mainFrame.getList1().setText(Resources.TEXT_LIST1);
		mainFrame.getList2().setText(Resources.TEXT_LIST2);
		mainFrame.getInput().setText(Resources.TEXT_INPUT);
	}

}
