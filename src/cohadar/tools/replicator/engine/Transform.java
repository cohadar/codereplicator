package cohadar.tools.replicator.engine;

public class Transform {
	public static final int UPPER = 1;
	public static final int LOWER = 2;
	public static final int PASCAL = 3;
	public static final int CAMEL = 4;
	private final int type;
	private final String separator;

	public Transform(int type, String separator) {
		this.type = type;
		this.separator = separator;
	}
	
	public static Transform create(String match, final String separator) {
		if (match == null) {
			throw new IllegalArgumentException();
		}
		if (separator != null) {
			if (!match.contains(separator)) {
				throw new IllegalArgumentException();
			}
		}

		Transform ret = null;
		boolean hasSeparator = Text.isNotEmpty(separator);
		boolean firstUp = Character.isUpperCase(match.charAt(0));

		if (hasSeparator) {
			if (firstUp) {
				ret = new Transform(Transform.UPPER, separator);
			} else {
				ret = new Transform(Transform.LOWER, separator);
			}
		} else {
			if (firstUp) {
				boolean allUp = match.equals(match.toUpperCase());
				if (allUp) {
					ret = new Transform(Transform.UPPER, separator);
				} else {
					ret = new Transform(Transform.PASCAL, separator);
				}
			} else {
				boolean allDown = match.equals(match.toLowerCase());
				if (allDown) {
					ret = new Transform(Transform.LOWER, separator);
				} else {
					ret = new Transform(Transform.CAMEL, separator);
				}
			}
		}

		return ret;
	}


	public String apply(String argument) {
		if (Text.isEmpty(argument)) {
			return argument;
		}
		switch (type) {
		case UPPER:
			return upper(argument);
		case LOWER:
			return lower(argument);
		case PASCAL:
			return pascal(argument);
		case CAMEL:
			return camel(argument);
		default:
			throw new IllegalStateException();
		}
	}

	// we assume arguments are in c_lower case
	private String camel(String argument) {
		String[] parts = Text.literalSplit(argument, Text.UNDERSCORE);
		for (int i = 0; i < parts.length; i++) {
			StringBuilder temp = new StringBuilder(parts[i].toLowerCase());
			if (i != 0) {
				if (temp.length() > 0) {
					char firstChar = Character.toUpperCase(temp.charAt(0));
					temp.setCharAt(0, firstChar);
				}
			}
			parts[i] = temp.toString();
		}
		return Text.merge(parts, "");
	}

	private String pascal(String argument) {
		String[] parts = Text.literalSplit(argument, Text.UNDERSCORE);
		for (int i = 0; i < parts.length; i++) {
			StringBuilder temp = new StringBuilder(parts[i].toLowerCase());
			if (temp.length() > 0) {
				char firstChar = Character.toUpperCase(temp.charAt(0));
				temp.setCharAt(0, firstChar);
			}
			parts[i] = temp.toString();
		}
		return Text.merge(parts, "");
	}

	private String lower(String argument) {
		if (Text.isEmpty(separator)) {
			return argument.toLowerCase().replace(Text.UNDERSCORE, "");
		} else {
			String[] parts = Text.literalSplit(argument, Text.UNDERSCORE);
			for (int i = 0; i < parts.length; i++) {
				parts[i] = parts[i].toLowerCase();
			}
			return Text.merge(parts, separator);
		}
	}

	private String upper(String argument) {
		if (Text.isEmpty(separator)) {
			return argument.toUpperCase().replace(Text.UNDERSCORE, "");
		} else {
			String[] parts = Text.literalSplit(argument, Text.UNDERSCORE);
			for (int i = 0; i < parts.length; i++) {
				parts[i] = parts[i].toUpperCase();
			}
			return Text.merge(parts, separator);
		}
	}
}
