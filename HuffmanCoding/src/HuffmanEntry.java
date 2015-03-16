

public class HuffmanEntry implements Entry<Integer, String> {
	
	private String c;
	private Integer freq;
	
	private HuffmanEntry childR;
	private HuffmanEntry childL;
	private HuffmanEntry parent;
	
	private int linkBit;	
	
	
	public HuffmanEntry(String c, Integer freq){
		this.c = c;
		this.freq = freq;
	}

	
	public HuffmanEntry getChildR() {
		return childR;
	}
	
	
	
	public void setChildR(HuffmanEntry childR) {
		this.childR = childR;
	}


	public HuffmanEntry getChildL() {
		return childL;
	}


	public void setChildL(HuffmanEntry childL) {
		this.childL = childL;
	}


	public HuffmanEntry getParent() {
		return parent;
	}


	public void setParent(HuffmanEntry parent) {
		this.parent = parent;
	}


	public int getParentLinkBit() {
		return linkBit;
	}


	public void setParentLinkBit(int parentLinkBit) {
		this.linkBit = parentLinkBit;
	}



	public int compareTo(Integer o) {
		if(freq>o){
			
			return 1;
			
		}else if(freq<o){
			
			return -1;
		}else{
			
		}
		return 0;
	}



	public Integer getKey() {
	
		return freq;
	}



	public String getValue() {
	
		return c;
	}


	
	public void setKey(Integer key) {
		
		freq=key;
		
	}


	
	public void setValue(String Value) {
	
		c=Value;
		
	}


}

