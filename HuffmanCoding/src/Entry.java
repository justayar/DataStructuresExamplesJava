
public interface Entry<K,V> extends Comparable<K>{ 

	K getKey(); 

	V getValue(); 
	
	void setKey(K key);
	
	void setValue(V Value);

}
