package cohadar.tools.replicator.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Text_merge {
	static String[] partsNull = null;
	static String[] parts0 = {};
	static String[] parts1 = { "one" };
	static String[] parts2 = { "one", "two" };
	static String[] parts3 = { "one", "two", "three" };

	static String separatorNull = "";
	static String separator0 = "";
	static String separator1 = "_";
	static String separator2 = "@#";

	static String res1N = "one";
	static String res10 = "one";
	static String res11 = "one";
	static String res12 = "one";

	static String res2N = "onetwo";
	static String res20 = "onetwo";
	static String res21 = "one" + separator1 + "two";
	static String res22 = "one" + separator2 + "two";

	static String res3N = "onetwothree";
	static String res30 = "onetwothree";
	static String res31 = "one" + separator1 + "two" + separator1 + "three";
	static String res32 = "one" + separator2 + "two" + separator2 + "three";

	String res = null;

	@Test
	public void testPartsNull() {
		try {
			res = Text.merge(partsNull, separatorNull);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(partsNull, separator0);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(partsNull, separator1);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(partsNull, separator2);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testParts0() {
		try {
			res = Text.merge(parts0, separatorNull);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(parts0, separator0);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(parts0, separator1);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			res = Text.merge(parts0, separator2);
			fail("exception not thrown");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testParts1() {
		res = Text.merge(parts1, separatorNull);
		assertEquals(res1N, res);

		res = Text.merge(parts1, separator0);
		assertEquals(res10, res);

		res = Text.merge(parts1, separator1);
		assertEquals(res11, res);

		res = Text.merge(parts1, separator2);
		assertEquals(res12, res);
	}

	@Test
	public void testParts2() {
		res = Text.merge(parts2, separatorNull);
		assertEquals(res2N, res);

		res = Text.merge(parts2, separator0);
		assertEquals(res20, res);

		res = Text.merge(parts2, separator1);
		assertEquals(res21, res);

		res = Text.merge(parts2, separator2);
		assertEquals(res22, res);
	}

	@Test
	public void testParts3() {
		res = Text.merge(parts3, separatorNull);
		assertEquals(res3N, res);

		res = Text.merge(parts3, separator0);
		assertEquals(res30, res);

		res = Text.merge(parts3, separator1);
		assertEquals(res31, res);

		res = Text.merge(parts3, separator2);
		assertEquals(res32, res);
	}
}
