package sk.itsovy.dolinsky.binarytree;

/**
 * @author Martin Dolinsky
 */
public class Node {

	private int key;
	private String value;

	private Node left;
	private Node right;

	public Node(int key, String value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void addChild(Node node) {
		if (this.key == node.key) {
			this.value = node.value;
		}
		else if (this.key > node.key) {
			if (this.left == null) {
				this.left = node;
			}
			else {
				left.addChild(node);
			}
		}
		else {
			if (this.right == null) {
				this.right = node;
			}
			else {
				this.right.addChild(node);
			}
		}
	}

	public void inOrder() {
		if (this.left != null) {
			this.left.inOrder();
		}
		System.out.println("(" + this.key + "): " + this.value + " ");
		if (this.right != null) {
			this.right.inOrder();
		}
	}

	public void preOrder() {
		System.out.println("(" + this.key + "): " + this.value + " ");
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println("(" + this.key + "): " + this.value + " ");
	}
}
