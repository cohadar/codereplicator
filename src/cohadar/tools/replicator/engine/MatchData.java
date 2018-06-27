package cohadar.tools.replicator.engine;

/*
 * remembers matches of first list inside template
 * */
public class MatchData {
	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public Transform getTransform(){
		return transform;
	}

	private final int start;
	private final int end;
	private final Transform transform;

	public MatchData(int start, int end, String match, String separator) {
		this.start = start;
		this.end = end;
		this.transform = Transform.create(match, separator);
	}

}
