/**
 * BinarySearchTree
 * @author Zein Al Jaradat
 */
public class BinarySearchTree {
	
	private BSTNode root;
	
	public BinarySearchTree() {
		root = new BSTNode(null);
	}
	
	/*
	 * Gets the root BSTNode
	 * @return root of the BST
	 */
	public BSTNode getRoot() {
		return root;
	}
	
	/*
	 * Gets the BSTNode with the corresponding key in the BST
	 * @param r root node, k desired record key
	 * @return BSTNode with the desired key, null if it doesn't exist
	 */
	public BSTNode get(BSTNode r, Key k) {
		if (getLeaf(r, k).isLeaf()) {
			return null;
		} else {
			return getLeaf(r, k);
		}
	}
	
	/*
	 * Gets the BSTNode with the corresponding key in the BST
	 * If it doesn't exist, it returns the leaf node where it should be
	 * @param r root node, k desired record key
	 * @return BSTNode with the desired key, the leaf node where it should be
	 */
	private BSTNode getLeaf(BSTNode r, Key k) {
		if (r.isLeaf()) {
			return r;
		} else {
			Key thisKey = r.getRecord().getKey();
			if (thisKey.compareTo(k) == 0) { // if thisKey = k
				return r;
			} else if (thisKey.compareTo(k) > 0) { // if thisKey > k
				return getLeaf(r.getLeftChild(), k);
			} else {
				return getLeaf(r.getRightChild(), k);
			}
		}
	}
	
	/*
	 * Inserts a new record into the BST
	 * @param r root node, d record to be inserted
	 */
	public void insert(BSTNode r, Record d) throws DictionaryException {
		if (root.getRecord() == null) { // if root record is null, set new record in the root node
			root.setRecord(d);
			return; // and exit, since the record is inserted in an empty tree, theres no reason to check further
		}
		BSTNode positionNode = getLeaf(r, d.getKey());
		if (!positionNode.isLeaf()) { // if not a leaf node
			throw new DictionaryException("Record with the same key already exists");
		} else {
			positionNode.setRecord(d);
			positionNode.setLeftChild(makeLeaf(positionNode));
			positionNode.setRightChild(makeLeaf(positionNode));
		}
	}
	
	/*
	 * Makes a new leaf node
	 * @param parent BSTNode for the parent
	 * @return leaf BSTNode
	 */
	private BSTNode makeLeaf(BSTNode parent) {
		BSTNode leaf = new BSTNode(null);
		leaf.setLeftChild(null);
		leaf.setRightChild(null);
		leaf.setParent(parent);
		return leaf;
	}
	
	/*
	 * Removes an existing record with the given key from the BST
	 * @param r root node, k key to be removed
	 */
	public void remove(BSTNode r, Key k) throws DictionaryException {
		BSTNode pos = getLeaf(r, k);
		if (pos.isLeaf()) { // if node is leaf
			throw new DictionaryException("No record with this key found");
		} else {
			if ((!pos.getLeftChild().isLeaf()) && (!pos.getRightChild().isLeaf())) {
				// if node to be removed has two children
				BSTNode less = predecessor(r, k);
				pos.setRecord(less.getRecord());
				remove(pos.getLeftChild(), less.getRecord().getKey());
			} else if (!pos.getLeftChild().isLeaf()) {
				// if one left child
				BSTNode temp = pos;
				pos = pos.getLeftChild();
				pos.setParent(temp.getParent());
				// maintaining BST properties
				if (pos.getRecord().getKey().compareTo(temp.getParent().getRecord().getKey()) < 0) {
					temp.getParent().setRightChild(pos);
				} else {
					temp.getParent().setLeftChild(pos);
				}
				temp = null;
			} else if (!pos.getRightChild().isLeaf()) {
				// if one right child
				BSTNode temp = pos;
				pos = pos.getRightChild();
				pos.setParent(temp.getParent());
				// maintaining BST properties
				if (pos.getRecord().getKey().compareTo(temp.getParent().getRecord().getKey()) < 0) {
					temp.getParent().setRightChild(pos);
				} else {
					temp.getParent().setLeftChild(pos);
				}
				temp = null;
			} else {
				// if removing record in the root
				if (pos.getParent() == null) {
					pos.setRecord(null);
				} else {
					// if no children
					pos.setRecord(null);
					pos.setLeftChild(null);
					pos.setRightChild(null);
				}
			}
		}
	}
	
	/*
	 * Gets the successor of the given key in the BST
	 * @param r root node, k given key
	 * @return successor BSTNode, null if it doesn't exist
	 */
	public BSTNode successor(BSTNode r, Key k) {
		BSTNode currentNode = getLeaf(r, k);
		if (!currentNode.getRightChild().isLeaf()) { // if currentNode right child is an internal node
			return smallest(currentNode.getRightChild());
		} else {
			currentNode = currentNode.getParent();
			while ((currentNode != null) && (currentNode.getRecord().getKey().compareTo(k) < 0)) {
				currentNode = currentNode.getParent();
			}
			return currentNode;
		}
	}
	
	/*
	 * Gets the predecessor of the given key in the BST
	 * @param r root node, k given key
	 * @return predecessor BSTNode, null if it doesn't exist
	 */
	public BSTNode predecessor(BSTNode r, Key k) {
		BSTNode currentNode = getLeaf(r, k);
		if (!currentNode.getLeftChild().isLeaf()) { // if currentNode is an internal node
			return largest(currentNode.getLeftChild());
		} else {
			currentNode = currentNode.getParent();
			while ((currentNode != null) && (currentNode.getRecord().getKey().compareTo(k) > 0)) {
				currentNode = currentNode.getParent();
			}
			return currentNode;
		}
	}
	
	/*
	 * Gets the node with the smallest key in the BST
	 * @param r root node
	 * @return smallest BSTNode
	 */
	public BSTNode smallest(BSTNode r) {
		if (root.getRecord() == null) { // if root record is null
			return null; // exit, there is no smallest key if there is no keys
		} else {
			BSTNode currentNode = r;
			while (!currentNode.isLeaf()) { // while is not leaf
				currentNode = currentNode.getLeftChild();
			}
			return currentNode.getParent();
		}
	}
	
	/*
	 * Gets the node with the largest key in the BST
	 * @param r root node
	 * @return largest BSTNode
	 */
	public BSTNode largest(BSTNode r) {
		if (root.getRecord() == null) { // if root record is null
			return null; // exit, there is no largest key if there is no keys
		} else {
			BSTNode currentNode = r;
			while (!currentNode.isLeaf()) { // while is not leaf
				currentNode = currentNode.getRightChild();
			}
			return currentNode.getParent();
		}
	}
}
