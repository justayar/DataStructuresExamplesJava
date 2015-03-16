import java.util.ArrayList;
import java.util.Comparator;


public class MyPQ implements PQInterface{
	
	private ArrayList<Entry> entryList;
	
	public MyPQ() {		
		entryList = new ArrayList<Entry>();		
	}
	
	
	
	public void insert(Entry entry){
		
	  
		  if(!entryList.isEmpty()){
			
			
			int index=0;
			for(int i=0;i<entryList.size();i++){

			   Object x=entryList.get(i).getKey();
			   
			   Object y=entry.getKey();
				  
			  
			  
				if(((Comparable) x).compareTo(y)>=0){

					index=i;
				
					
					
					break;
			
				}else{
					index++;
				}
				
				
			}
			entryList.add(index, entry);
			

		
		
			
		}else{
			
			entryList.add(entry);
			
		}
		
		
		
	   }


	public void clear() {
		
		while(!isEmpty()){
			
			removeMin();
		}
	}


	
	public Entry removeMin() {  
		
		Entry key=min();
		
		entryList.set(0,null);
		
		for(int i=1;i<entryList.size();i++){
			
			Entry key2=entryList.get(i);
			
			entryList.set(i-1,key2);
			
			
		}
		
		entryList.remove(entryList.size()-1);
		
		
		return key;
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
		
		if(entryList.size()<=0){
			
			return true;
		}else{
			
			return false;
		}
	}
	
	
	public void print(){
		
		if(entryList.isEmpty()){
			System.out.println("The queue is empty");
		}
		
		for(int i=0;i<entryList.size();i++){
			
			System.out.println(entryList.get(i));
		}  
	}


	
}

