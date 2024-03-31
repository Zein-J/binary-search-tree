/**
 * Key
 * @author Zein Al Jaradat
 */
public class Key {
	
	private String label;
	private int type;
	
	public Key(String theLabel, int theType) {
		label = theLabel.toLowerCase();
		type = theType;
	}
	
	/*
	 * Gets the label
	 * @return label of the key
	 */
	public String getLabel() {
		return label;
	}
	
	/*
	 * Gets the type
	 * @return type of the key
	 */
	public int getType() {
		return type;
	}
	
	/*
	 * Compares two key objects
	 * @param k Other key to compare with
	 * @return 1 if k is smaller, 0 if equal, -1 if k is bigger
	 */
	public int compareTo(Key k) {
		// Checking if labels are equal
		if (this.label.equals(k.label)) {
			if (this.type > k.type) { // if this type is greater
				return 1;
			} else if (this.type < k.type) { // if this type is smaller
				return -1;
			} else { // if everything is equal
				return 0;
			}
		} else {
			if ((this.label.compareTo(k.label)) > 0) { // if this label is lexicographically after/greater than k label
				return 1;
			} else if ((this.label.compareTo(k.label)) < 0) { // if this label is lexicographically before/less than k label
				return -1;
			} else { // if they're equal, which was already checked so this is unreachable
				return 0;
			}
		}
	}
}
