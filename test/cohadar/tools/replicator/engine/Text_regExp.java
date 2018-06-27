package cohadar.tools.replicator.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import cohadar.tools.replicator.engine.Text;

/**
 * Test making of regular expression from first argument in a list. Argument is
 * assumed to be in C-lower notation: one_two_three
 * */
public class Text_regExp {
	static String one = "one";
	static String two = "two";
	static String three = "three";
	static String four = "four";

	static String U = "_";

	static String a01 = one;
	static String a02 = one + U + two;
	static String a03 = one + U + two + U + three;
	static String a04 = one + U + two + U + three + U + four;

	static int MIN_SEPARATOR_LENGTH = 0;
	static int MAX_SEPARATOR_LENGTH = 5;
	static String sep1 = "(.{0,5}?)";
	static String sepN = "\\1";

	static String r01 = one;
	static String r02 = one + sep1 + two;
	static String r03 = one + sep1 + two + sepN + three;
	static String r04 = one + sep1 + two + sepN + three + sepN + four;

	String res = null;

	@Test
	public void testIllegals() {
		try {
			Text.regExp(null, 1);
			fail();
		} catch (IllegalArgumentException e) {
			// OK
		}

		try {
			Text.regExp("", 1);
			fail();
		} catch (IllegalArgumentException e) {
			// OK
		}

		try {
			Text.regExp("oneTwoThree", 1);
			fail();
		} catch (IllegalArgumentException e) {
			// OK
		}

		try {
			Text.regExp("one_two_three", -1);
			fail();
		} catch (IllegalArgumentException e) {
			// OK
		}
	}

	@Test
	public void test01() {
		res = Text.regExp(a01, MAX_SEPARATOR_LENGTH);
		assertEquals(r01, res);
	}
	
	@Test
	public void test02() {
		res = Text.regExp(a02, MAX_SEPARATOR_LENGTH);
		assertEquals(r02, res);
	}
	
	@Test
	public void test03() {
		res = Text.regExp(a03, MAX_SEPARATOR_LENGTH);
		assertEquals(r03, res);
	}
	
	@Test
	public void test04() {
		res = Text.regExp(a04, MAX_SEPARATOR_LENGTH);
		assertEquals(r04, res);
	}
}
