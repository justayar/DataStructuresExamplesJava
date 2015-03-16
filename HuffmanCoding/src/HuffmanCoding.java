
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class HuffmanCoding {

	private ArrayList<HuffmanEntry> huffEntries ; //This list holds the nodes (parent or child) that you create
	private PQInterface<HuffmanEntry> huffPQ; //This PQ is used used for Huffman coding algorithm

	public HuffmanCoding(PQInterface<HuffmanEntry> huffPQ){
		this.huffPQ = huffPQ;
		
		this.huffEntries=new ArrayList<HuffmanEntry>();
		
	
	}



	public void encoding(){
		int i = 1;
		FileWriter outFile = null;
		BufferedWriter outBuff = null;
		try{
			
			
				
			outFile = new FileWriter("Huffman.txt");
			outBuff = new BufferedWriter(outFile);
			
			
			

			
			for(int a=0;a<huffPQ.size();a++){
			
				outBuff.write("( "+huffPQ.get(a).getKey()+","+huffPQ.get(a).getValue()+" )\n");
				outBuff.newLine();

			}
			
			outBuff.close();




		}catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}


		   
			
		    
			
			 while(huffPQ.size()>1){
				 
				HuffmanEntry child1= huffPQ.removeMin();
				
				HuffmanEntry child2= huffPQ.removeMin();
				
				//System.out.println(child1.getKey()+" "+child1.getValue());
				//System.out.println(child2.getKey()+" "+child2.getValue());
				
				
				
				int key1= child1.getKey();
				
				int key2=child2.getKey();
				
				int sumkey=key1+key2;
				
				
			    HuffmanEntry parent=new HuffmanEntry(child1.getValue()+child2.getValue(),sumkey);
			    
                
                child1.setParent(parent);
				
				child2.setParent(parent);
			    
				parent.setChildL(child1);
				
				parent.setChildR(child2);
				
				
				
				child1.setParentLinkBit(0);
				
                child2.setParentLinkBit(1);
                
                
                
				
				
				
				
			    
				
				huffEntries.add(parent);
				
			    huffEntries.add(child1);
				
			    huffEntries.add(child2);
				
			    huffPQ.insert(parent);
			    
			    i++;
			    
			 }
			 
			 
			
			 
			
	}

	public String getCode(Character c){
		
		int index=1;
		
		String linkBit="";
		
		for(int i=0;i<huffEntries.size();i++){
			
			
			if(huffEntries.get(i).getValue().charAt(0)==c){
				
				index=i;
				break;
			}
		}
		
		
		
		HuffmanEntry x=huffEntries.get(index);
		
	
		
		
		
		while(x.getParent()!=null){
			
			linkBit+=x.getParentLinkBit();
			
			x=x.getParent();
			

			
		  }
	
		
	return linkBit;
	
	}

		
	}


