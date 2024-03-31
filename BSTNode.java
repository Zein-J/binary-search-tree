/**
 * BSTNode
 * @author Zein Al Jaradat
 */
public class BSTNode {
	
	private Record disk;
	private BSTNode leftChild;
	private BSTNode rightChild;
	private BSTNode parent;
	
	private BSTNode(BSTNode p) {
		disk = null;
		leftChild = null;
		rightChild = null;
		parent = p;
	}
	
	public BSTNode(Record item) {
		disk = item;
		leftChild = new BSTNode(this);
		rightChild = new BSTNode(this);
		parent = null;
	}
	
	/*
	 * Gets the record
	 * @return disk record of the node
	 */
	public Record getRecord() {
		return disk;
	}
	
	/*
	 * Sets the record
	 * @param d record item to be set to
	 */
	public void setRecord(Record d) {
		disk = d;
	}
	
	/*
	 * Gets the left child of the node
	 * @return leftChild
	 */
	public BSTNode getLeftChild() {
		return leftChild;
	}
	
	/*
	 * Gets the right child of the node
	 * @return rightChild
	 */
	public BSTNode getRightChild() {
		return rightChild;
	}
	
	/*
	 * Gets the parent of the node
	 * @return parent
	 */
	public BSTNode getParent() {
		return parent;
	}
	
	/*
	 * Sets the parent of the node
	 * @param u BSTNode to be set to parent
	 */
	public void setParent(BSTNode u) {
		parent = u;
	}
	
	/*
	 * Sets the left child of the node
	 * @param u BSTNode to be set to leftChild
	 */
	public void setLeftChild(BSTNode u) {
		leftChild = u;
	}
	
	/*
	 * Sets the right child of the node
	 * @param u BSTNode to be set to rightChild
	 */
	public void setRightChild(BSTNode u) {
		rightChild = u;
	}
	
	/*
	 * Checks if the node is a leaf or not
	 * @return true if leaf node, false if not
	 */
	public boolean isLeaf() {
		if ((leftChild == null) && (rightChild == null)) {
			return true;
		}
		return false;
	}
}
