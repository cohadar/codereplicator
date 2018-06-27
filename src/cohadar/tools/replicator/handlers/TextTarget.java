package cohadar.tools.replicator.handlers;

import java.awt.Color;

public interface TextTarget {
	void cut();
	void copy();
	void paste();
	void delete();
	void selectAll();
	void undo();
	void redo();
}
