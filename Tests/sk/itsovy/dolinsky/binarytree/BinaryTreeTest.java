package sk.itsovy.dolinsky.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Martin Dolinsky
 */
class BinaryTreeTest {
	BinaryTree binaryTree;
	BinaryTree myTree;
	Node n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17;

	@BeforeEach
	void setUp() {
		binaryTree = new BinaryTree(new Node(41, "HTTP protocol"));
		n1 = new Node(20, "JavaScript");
		binaryTree.addNode(n1);

		n2 = new Node(30, "HTML 5");
		binaryTree.addNode(n2);

		n3 = new Node(55, "MySQL server");
		binaryTree.addNode(n3);

		n4 = new Node(72, "Jazyk C");
		binaryTree.addNode(n4);

		n5 = new Node(8, "Java SE");
		binaryTree.addNode(n5);

		n6 = new Node(48, "SMTP");
		binaryTree.addNode(n6);

		n7 = new Node(21, "C#");
		binaryTree.addNode(n7);

		n8 = new Node(52, "PHP");
		binaryTree.addNode(n8);

		n9 = new Node(36, "Linux BASH");
		binaryTree.addNode(n9);

		n10 = new Node(44, "Node JS");
		binaryTree.addNode(n10);

		n11 = new Node(80, "CSS 3");
		binaryTree.addNode(n11);

		n12 = new Node(34, "Pascal");
		binaryTree.addNode(n12);

		n13 = new Node(74, "Python");
		binaryTree.addNode(n13);

		n14 = new Node(51, "Arduino");
		binaryTree.addNode(n14);

		n15 = new Node(81, "Javascript");
		binaryTree.addNode(n15);

		n16 = new Node(11, "Android");
		binaryTree.addNode(n16);

		myTree = new BinaryTree(null);
	}

	@Test
	void getValue() {
		assertEquals("HTTP protocol", binaryTree.getValue(41));
		assertEquals("JavaScript", binaryTree.getValue(20));
		assertEquals("HTML 5", binaryTree.getValue(30));
		assertEquals("MySQL server", binaryTree.getValue(55));
		assertEquals("Jazyk C", binaryTree.getValue(72));
		assertEquals("Java SE", binaryTree.getValue(8));
		assertEquals("SMTP", binaryTree.getValue(48));
		assertEquals("C#", binaryTree.getValue(21));
		assertEquals("PHP", binaryTree.getValue(52));
		assertEquals("Linux BASH", binaryTree.getValue(36));
		assertEquals("Node JS", binaryTree.getValue(44));
		assertEquals("CSS 3", binaryTree.getValue(80));
		assertEquals("Pascal", binaryTree.getValue(34));
		assertEquals("Python", binaryTree.getValue(74));
		assertEquals("Arduino", binaryTree.getValue(51));
		assertEquals("Javascript", binaryTree.getValue(81));
		assertEquals("Android", binaryTree.getValue(11));

		assertNotEquals("HTTP Protocol", binaryTree.getValue(41));
		assertNotEquals(" Android", binaryTree.getValue(11));
		assertNotEquals("Arduino ", binaryTree.getValue(51));

		assertNull(binaryTree.getValue(99));
		assertNull(binaryTree.getValue(0));
		assertNull(binaryTree.getValue(-1));
	}

	@Test
	void containsKey() {
		assertTrue(binaryTree.containsKey(41));
		assertTrue(binaryTree.containsKey(20));
		assertTrue(binaryTree.containsKey(30));
		assertTrue(binaryTree.containsKey(55));
		assertTrue(binaryTree.containsKey(72));
		assertTrue(binaryTree.containsKey(8));
		assertTrue(binaryTree.containsKey(48));
		assertTrue(binaryTree.containsKey(21));
		assertTrue(binaryTree.containsKey(52));
		assertTrue(binaryTree.containsKey(36));
		assertTrue(binaryTree.containsKey(44));
		assertTrue(binaryTree.containsKey(80));
		assertTrue(binaryTree.containsKey(34));
		assertTrue(binaryTree.containsKey(74));
		assertTrue(binaryTree.containsKey(51));
		assertTrue(binaryTree.containsKey(81));
		assertTrue(binaryTree.containsKey(11));

		assertFalse(binaryTree.containsKey(99));
		assertFalse(myTree.containsKey(8));
	}

	@Test
	void remove() {
		assertTrue(binaryTree.containsKey(11));
		binaryTree.remove(n16);
		assertFalse(binaryTree.containsKey(11));


	}

	@Test
	void getListOfLeafs() {
		//11 21 34 44 51 74 81
		List<Node> list = new ArrayList<>();
		list.add(n16);
		list.add(n7);
		list.add(n12);
		list.add(n10);
		list.add(n14);
		list.add(n13);
		list.add(n15);
		assertEquals(list, binaryTree.getListOfLeafs());

		List<Node> nodes = new ArrayList<>();
		nodes.add(n16);
		nodes.add(n7);
		nodes.add(n12);
		nodes.add(n10);
		nodes.add(n14);
		nodes.add(n13);
		nodes.add(n15);
		nodes.add(n2);
		assertNotEquals(nodes, binaryTree.getListOfLeafs());

	}

	@Test
	void getHeight() {
		assertEquals(-1, myTree.getHeight());
		assertEquals(4, binaryTree.getHeight());

		assertNotEquals(2, myTree.getHeight());
		assertNotEquals(5, binaryTree.getHeight());
	}

	@Test
	void getParrent() {
		assertEquals(n1.getKey(), binaryTree.getParrent(n2).getKey());
		assertEquals(n3.getKey(), binaryTree.getParrent(n4).getKey());
		assertEquals(n1.getKey(), binaryTree.getParrent(n5).getKey());
		assertEquals(n3.getKey(), binaryTree.getParrent(n6).getKey());
		assertEquals(n2.getKey(), binaryTree.getParrent(n7).getKey());
		assertEquals(n6.getKey(), binaryTree.getParrent(n8).getKey());
		assertEquals(n2.getKey(), binaryTree.getParrent(n9).getKey());
		assertEquals(n6.getKey(), binaryTree.getParrent(n10).getKey());
		assertEquals(n4.getKey(), binaryTree.getParrent(n11).getKey());
		assertEquals(n9.getKey(), binaryTree.getParrent(n12).getKey());
		assertEquals(n11.getKey(), binaryTree.getParrent(n13).getKey());
		assertEquals(n8.getKey(), binaryTree.getParrent(n14).getKey());
		assertEquals(n11.getKey(), binaryTree.getParrent(n15).getKey());
		assertEquals(n5.getKey(), binaryTree.getParrent(n16).getKey());

		assertNull(binaryTree.getParrent(n17));
	}

	@Test
	void getMinRightNode() {
		assertEquals(n7.getKey(), binaryTree.getMinRightNode(n1).getKey());
		assertEquals(n12.getKey(), binaryTree.getMinRightNode(n2).getKey());
		assertEquals(n4.getKey(), binaryTree.getMinRightNode(n3).getKey());
		assertEquals(n13.getKey(), binaryTree.getMinRightNode(n4).getKey());
		assertEquals(n16.getKey(), binaryTree.getMinRightNode(n5).getKey());
		assertEquals(n14.getKey(), binaryTree.getMinRightNode(n6).getKey());
		assertEquals(n15.getKey(), binaryTree.getMinRightNode(n11).getKey());

		assertNotEquals(n7.getKey(), binaryTree.getMinRightNode(n11).getKey());
		assertNotEquals(n5.getKey(), binaryTree.getMinRightNode(n6).getKey());
		assertNotEquals(n3.getKey(), binaryTree.getMinRightNode(n4).getKey());

		assertNull(binaryTree.getMinRightNode(n7));
		assertNull(binaryTree.getMinRightNode(n8));
		assertNull(binaryTree.getMinRightNode(n9));
		assertNull(binaryTree.getMinRightNode(n10));
		assertNull(binaryTree.getMinRightNode(n12));
		assertNull(binaryTree.getMinRightNode(n13));
		assertNull(binaryTree.getMinRightNode(n14));
		assertNull(binaryTree.getMinRightNode(n15));
		assertNull(binaryTree.getMinRightNode(n16));
	}
}
