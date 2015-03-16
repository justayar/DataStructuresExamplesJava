
import java.util.ArrayList;


public class MyHeap implements PQInterface {
	
	private ArrayList<Entry> entryList;
	
	public MyHeap(){
		entryList = new ArrayList<Entry>();
	}
	
	


	public void insert(Entry entry) {
		
		
		
		  entryList.add(entry);
		
		
		  int position=entryList.size()-1;  
		
		  
		  while(position>0){
			  
			  int parent_position=(position-1)/2;
			  
			  Entry position_element=entryList.get(position);
			  
			  Entry parent_element=entryList.get(parent_position);
			  
			   Object x=position_element.getKey();
			   Object y=parent_element.getKey();
			  
			    
			  if(((Comparable) entry.getKey()).compareTo(entryList.get(parent_position).getKey()) <= 0){
				  
				  
			  Entry temp=position_element;
			  
			 entryList.set(position,parent_element);
			 
			 entryList.set(parent_position, temp);
			 
			  position=parent_position;
			 
		     
				  
			  }else{
				  
				  break;
			  }
		  }
	}
	


	public void clear() {
	
		while(!isEmpty()){
			
			removeMin();
		}
	}

	public Entry removeMin() {
	    Entry removedEntry = entryList.get(0);
	    Entry lastEntry = entryList.remove(entryList.size() - 1);
	    percolateDown(0, lastEntry);
	    return removedEntry;
	  }
	
				
	void percolateDown(int k, Entry entry) {
	    if (entryList.isEmpty()) {
	      return;
	    }
	    while (k < entryList.size() / 2) {
	      int child = 2 * k + 1;
	      
	      if (child < entryList.size() - 1 && ((Comparable) entryList.get(child).getKey()).compareTo(entryList.get(child + 1).getKey()) > 0) {
	        child++;
	      }
	      if (((Comparable) entry.getKey()).compareTo(entryList.get(child).getKey()) <= 0) {
	        break;
	      }
	      entryList.set(k, entryList.get(child));
	      k = child;
	    }
	    entryList.set(k, entry);
	  }

	
	public Entry min() {
		
		return entryList.get(0);
	}
	
	public Entry get(int i){
		
		return entryList.get(i);
	}

	
	public int size() {
		
		return entryList.size();
	}

	
	public boolean isEmpty() {
		
		return entryList.size()<=0;
	}

}

