/**
 * Record
 * @author Zein Al Jaradat
 */
public class Record {
	
	private Key theKey;
	private String data;
	
	public Record(Key k, String theData) {
		theKey = k;
		data = theData;
	}
	
	/*
	 * Gets the key
	 * @return key of the record
	 */
	public Key getKey() {
		return theKey;
	}
	
	/*
	 * Gets the data item
	 * @return data of the record
	 */
	public String getDataItem() {
		return data;
	}
}
