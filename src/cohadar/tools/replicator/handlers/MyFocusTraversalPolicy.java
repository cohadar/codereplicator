package cohadar.tools.replicator.handlers;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

import cohadar.tools.replicator.gui.MainFrame;

public class MyFocusTraversalPolicy extends FocusTraversalPolicy {

	Component order[];
	private final MainFrame mainFrame;

	public MyFocusTraversalPolicy(MainFrame mainFrame, Component... order) {
		this.mainFrame = mainFrame;
		this.order = order;
	}

	private int incIndex(int index) {
		return (index + 1) % order.length;
	}

	private int decIndex(int index) {
		return (index - 1 + order.length) % order.length;
	}

	public Component getComponentAfter(Container focusCycleRoot,
			Component aComponent) {
		for (int i = 0; i < order.length; i++) {
			if (aComponent == order[i])
				return order[incIndex(i)];
		}
		return null;
	}

	public Component getComponentBefore(Container focusCycleRoot,
			Component aComponent) {
		for (int i = 0; i < order.length; i++) {
			if (aComponent == order[i])
				return order[decIndex(i)];
		}
		return null;
	}

	public Component getDefaultComponent(Container focusCycleRoot) {
		return mainFrame.getFocusedOne();
	}

	public Component getLastComponent(Container focusCycleRoot) {
		return order[order.length - 1];
	}

	public Component getFirstComponent(Container focusCycleRoot) {
		return order[0];
	}
}