package cohadar.tools.replicator.engine;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cohadar.tools.replicator.engine.Text;

public class Text_parseLines {

	@Test
	public void testParsingNull() {
		List<String> args = Text.parseLines(null);
		assertEquals(0, args.size());
	}

	@Test
	public void testParsing0() {
		List<String> args = Text.parseLines("");
		assertEquals(0, args.size());
	}

	@Test
	public void testParsing1() {
		List<String> args = Text.parseLines("one\n");
		assertEquals(1, args.size());
		assertEquals("one", args.get(0));
	}
	
	@Test
	public void testParsing3() {
		List<String> args = Text.parseLines("one\ntwo\nthree");
		assertEquals(3, args.size());
		assertEquals("one", args.get(0));
		assertEquals("two", args.get(1));
		assertEquals("three", args.get(2));
	}
	
	@Test
	public void testParsingSpace() {
		List<String> args = Text.parseLines("one\ntwo\n\nthree");
		assertEquals(4, args.size());
		assertEquals("one", args.get(0));
		assertEquals("two", args.get(1));
		assertEquals("", args.get(2));
		assertEquals("three", args.get(3));
	}

}
