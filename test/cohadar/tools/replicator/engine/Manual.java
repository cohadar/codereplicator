package cohadar.tools.replicator.engine;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manual {
	// "one(.{0,5}?)two\\1three";
		static String regEx = "aa.*?bb";
		static String str = "xx  one:::two   xx";

		public static void main(String[] args) {
			regEx = Text.regExp("one_two", 5);
			
			char[] marker = new char[str.length()];
			Arrays.fill(marker, ' ');

			Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(str);

			while (m.find()) {
				Arrays.fill(marker, m.start(), m.end(), '^');
				System.out.println(m.groupCount());
				System.out.println(m.group(1));
			}

			System.out.println(str);
			System.out.println(new String(marker));
		}
}
