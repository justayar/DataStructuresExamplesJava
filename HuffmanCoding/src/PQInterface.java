
public interface PQInterface<E extends Entry> {
	
	
	void insert(E entry);  
	
	void clear();
	
	E get(int i);
	
	E removeMin(); 
	
	E min();
	
	int size(); 
	
	boolean isEmpty(); 

}

