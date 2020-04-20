package sk.itsovy.dolinsky.binarytree;

/**
 * @author Martin Dolinsky
 */
public class BinaryTree {

	private Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	public void addNode(Node node) {
		if (node == null) {
			return;
		}
		root.addChild(node);
	}

	public void printInOrder() {
		if (root != null) {
			root.inOrder();
		}
	}

	public void printPreOrder() {
		if (root != null) {
			root.preOrder();
		}
	}

	public void printPostOrder() {
		if (root != null) {
			root.postOrder();
		}
	}

}
