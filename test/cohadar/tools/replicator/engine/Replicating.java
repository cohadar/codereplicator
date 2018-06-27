package cohadar.tools.replicator.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Replicating {
	private CompositeReplicator replicator = new CompositeReplicator();

	// ===============================
	// verbatim
	// ===============================

	static String s001 = "one mississippi";

	static String r002 = "one mississippi\ntwo mississippi\n";
	static String r0022 = "one mississippi\ntwo amazon\n";
	static String r003m = "one mississippi\n volga\ntwo amazon\n";

	static String[] l001 = { "one" };
	static String[] l002 = { "one", "two" };
	static String[] k002 = { "mississippi", "amazon" };

	static String[] l003m = { "one", "", "two" };
	static String[] k003 = { "mississippi", "volga", "amazon" };

	// ===============================
	// case inference
	// ===============================
	static String[] l004 = { "one_ring", "two_rings" };

	// cameCase
	static String s004 = "oneRing";
	static String r004 = "oneRing\ntwoRings\n";

	// PascalCase
	static String s005 = "oneRing";
	static String r005 = "oneRing\ntwoRings\n";

	// UPPER_CASE
	static String s006 = "ONE.RING";
	static String r006 = "ONE.RING\nTWO.RINGS\n";

	// lower_case
	static String s007 = "one-ring";
	static String r007 = "one-ring\ntwo-rings\n";

	// long@#$separator
	static String s008 = "one@#$ring";
	static String r008 = "one@#$ring\ntwo@#$rings\n";

	// three separators
	static String[] l005 = { "the_one_ring", "some_two_rings" };
	static String s009 = "the##one##ring";
	static String r009 = "the##one##ring\nsome##two##rings\n";

	// all in one
	static String s0010 = "one_ring oneRing OneRing ONE_RING ONE!!RING";
	static String r0010 = "one_ring oneRing OneRing ONE_RING ONE!!RING\ntwo_rings twoRings TwoRings TWO_RINGS TWO!!RINGS\n";

	@Test
	public void test1() {
		replicator.setSmartList(l001);
		replicator.setVerbatimList(null);
		replicator.setInput(s001);
		assertEquals(s001, replicator.replicate());

		replicator.setSmartList(null);
		replicator.setVerbatimList(l001);
		replicator.setInput(s001);
		assertEquals(s001, replicator.replicate());
	}

	@Test
	public void test2() {
		replicator.setSmartList(l002);
		replicator.setVerbatimList(null);
		replicator.setInput(s001);
		assertEquals(r002, replicator.replicate());

		replicator.setSmartList(null);
		replicator.setVerbatimList(l002);
		replicator.setInput(s001);
		assertEquals(r002, replicator.replicate());
	}

	@Test
	public void test22() {
		replicator.setSmartList(l002);
		replicator.setVerbatimList(k002);
		replicator.setInput(s001);
		assertEquals(r0022, replicator.replicate());

		replicator.setSmartList(k002);
		replicator.setVerbatimList(l002);
		replicator.setInput(s001);
		assertEquals(r0022, replicator.replicate());
	}

	@Test
	public void test3m() {
		replicator.setSmartList(l003m);
		replicator.setVerbatimList(k003);
		replicator.setInput(s001);
		assertEquals(r003m, replicator.replicate());
	}

	@Test
	public void test4() {
		replicator.setSmartList(l004);
		replicator.setVerbatimList(null);
		replicator.setInput(s004);
		assertEquals(r004, replicator.replicate());
	}
	@Test
	public void test5() {
		replicator.setSmartList(l004);
		replicator.setVerbatimList(null);
		replicator.setInput(s005);
		assertEquals(r005, replicator.replicate());
	}
	@Test
	public void test6() {
		replicator.setSmartList(l004);
		replicator.setVerbatimList(null);
		replicator.setInput(s006);
		assertEquals(r006, replicator.replicate());
	}
	@Test
	public void test7() {
		replicator.setSmartList(l004);
		replicator.setVerbatimList(null);
		replicator.setInput(s007);
		assertEquals(r007, replicator.replicate());
	}
	@Test
	public void test8() {
		replicator.setSmartList(l004);
		replicator.setVerbatimList(null);
		replicator.setInput(s008);
		assertEquals(r008, replicator.replicate());
	}

	@Test
	public void test9() {
		replicator.setSmartList(l005);
		replicator.setVerbatimList(null);
		replicator.setInput(s009);
		assertEquals(r009, replicator.replicate());
	}
	
	@Test
	public void test10() {
		replicator.setSmartList(l004); // l004, not an error 
		replicator.setVerbatimList(null);
		replicator.setInput(s0010);
		assertEquals(r0010, replicator.replicate());
	}
	
	/*

	@Test
	public void test9() {
		String res = replicator.replicate(s009, l005, null);
		assertEquals(r009, res);
	}

	@Test
	public void test10() {
		String res = replicator.replicate(s0010, l004, null);
		assertEquals(r0010, res);
	}
	*/
}
