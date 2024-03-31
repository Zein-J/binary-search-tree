/**
 * BSTDictionary
 * @author Zein Al Jaradat
 */
public class BSTDictionary implements BSTDictionaryADT {
	
	private BinarySearchTree tree;
	
	public BSTDictionary() {
		tree = new BinarySearchTree();
	}
	
	/*
	 * Gets the record with the corresponding key in the dictionary
	 * @param k desired record key
	 * @return record
	 */
	public Record get(Key k) {
		BSTNode result = tree.get(tree.getRoot(), k);
		if (result == null) {
			return null;
		} else {
			return result.getRecord();
		}
	}
	
	/*
	 * Inserts a new record into the dictionary
	 * @param d record to be inserted
	 */
	public void put(Record d) throws DictionaryException {
		tree.insert(tree.getRoot(), d);
	}
	
	/*
	 * Removes an existing record with the given key from the dictionary
	 * @param k key to be removed
	 */
	public void remove(Key k) throws DictionaryException {
		tree.remove(tree.getRoot(), k);
	}
	
	/*
	 * Gets the successor of the given key in the dictionary
	 * @param k given key
	 * @return successor record, null if it doesn't exist
	 */
	public Record successor(Key k) {
		BSTNode result = tree.successor(tree.getRoot(), k);
		if (result == null) {
			return null;
		} else {
			return result.getRecord();
		}
	}
	
	/*
	 * Gets the predecessor of the given key in the dictionary
	 * @param k given key
	 * @return predecessor record, null if it doesn't exist
	 */
	public Record predecessor(Key k) {
		BSTNode result = tree.predecessor(tree.getRoot(), k);
		if (result == null) {
			return null;
		} else {
			return result.getRecord();
		}
	}
	
	/*
	 * Gets the record with the smallest key in the dictionary
	 * @return smallest record
	 */
	public Record smallest() {
		BSTNode result = tree.smallest(tree.getRoot());
		if (result == null) {
			return null;
		} else {
			return result.getRecord();
		}
	}
	
	/*
	 * Gets the record with the largest key in the dictionary
	 * @return largest record
	 */
	public Record largest() {
		BSTNode result = tree.largest(tree.getRoot());
		if (result == null) {
			return null;
		} else {
			return result.getRecord();
		}
	}
}
