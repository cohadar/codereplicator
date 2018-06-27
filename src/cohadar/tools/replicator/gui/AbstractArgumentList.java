package cohadar.tools.replicator.gui;


public abstract class AbstractArgumentList extends AbstractTextTarget {

	public AbstractArgumentList(MainFrame mainFrame) {
		super(mainFrame, 10, 15);
		this.showLineNumbers(true);
	}

}
