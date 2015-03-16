import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class TestHuffman {

	static String text;
	
	static int size; //holds the size of list
	static ArrayList<String> list=new ArrayList<String>(); // list for unique characters
	static ArrayList<String>  bitsList=new ArrayList<String>(); //list for classsicEncoding bits for each character
	
	

	public static void main(String[] args) {
		
		
		
		PQInterface<HuffmanEntry> myHeap = new MyHeap();
		PQInterface<HuffmanEntry> myPQ = new MyPQ();
		
		  // adding each character in a list for then calculating their frequencies
	 
		try {
		BufferedReader rd=new BufferedReader(new FileReader("input.txt"));
		
			String x="";
		while(true){
			
	         x+=rd.readLine();
			
			
			
			if(text==null)
				break;
			  
			
		}
		
		  text=x;
		    
		  String s=text.charAt(0)+"";
		
		  list.add(s);
		  
		  for(int i=1;i<text.length();i++){  
			  
			  String str=text.charAt(i)+"";
			  
			  boolean exist=false;
			   
			  for(int j=0;j<list.size();j++){
				  
			 
			 
			  
			  if(str.equals(list.get(j))){
				  
				  	exist= true;
				  	break;
				  	
				  }
			  
			
		  }
			  
			  if(exist==false){
				  list.add(str);
				
			  }
		  
		  }
		  
		  size=list.size();
		  
			
	      
		  
		  for(int a=0;a<list.size();a++){
		
			  HuffmanEntry entry=new HuffmanEntry(list.get(a),findFrequency(list.get(a)));
			  
			   myHeap.insert(entry);
			   
			   myPQ.insert(entry);
			   
			
			   
		  }
		  
		  
		  for(int i=0;i<myHeap.size();i++){
			 
			  
			  System.out.println(myHeap.get(i).getValue()+" =  "+myHeap.get(i).getKey());
			  
			  System.out.println(myPQ.get(i).getValue()+" =  "+myPQ.get(i).getKey());
		  }
		  
		
		  
		
	} catch (IOException ex) {
		System.err.println("Error: " + ex.getMessage());
	}
		

		HuffmanCoding code1 = new HuffmanCoding(myHeap);
		HuffmanCoding code2 = new HuffmanCoding(myPQ);

		code1.encoding();
		code2.encoding();
		
		
		

		try
		{
			FileWriter outFile = new FileWriter("coding.txt");
			BufferedWriter outBuff = new BufferedWriter(outFile);
			outBuff.write("Huffman Coding:");
			String huffCodedTxt="";
			
		
			outBuff.newLine();
			for(int i=0;i<list.size();i++){
				
			
				
				outBuff.write(list.get(i).charAt(0)+" = "+code2.getCode(list.get(i).charAt(0))+"");
				outBuff.newLine();
		
			}
			
			 for(int e=0;e<text.length();e++){
				 
				 
				 huffCodedTxt+=code2.getCode(text.charAt(e));
				 
			 }
			
		
			 

			outBuff.newLine();
			outBuff.write(huffCodedTxt);
			outBuff.newLine();
			outBuff.write("The size of the coded text is " + huffCodedTxt.length());
			
			
			
			
   		    String classicCodedTxt = classicEncoding();
            
   		

			outBuff.newLine();
			// write the classic code version (classicCodedTxt) to coding.txt		
   		    
   		    outBuff.newLine();
			outBuff.write("Classic Coding:");
			
			   outBuff.newLine();
			for(int i=0;i<list.size();i++){
				
				outBuff.write(list.get(i).charAt(0)+" = "+bitsList.get(i));
				outBuff.newLine();
				
			}
			
			outBuff.newLine();
			outBuff.write(classicCodedTxt);
			outBuff.newLine();
			outBuff.write("The size of the coded text is " + classicCodedTxt.length());
			outBuff.close();
			
			
		}


		catch (IOException e)
		{
			System.err.println("Error: " + e.getMessage());
		}


		//compare if code1 and code2 find the same codes for each character.
		


	}
	
	

	public static int findFrequency(String c){
		
		int freq=0;
		
		for(int i=0;i<text.length();i++){
			
			String str=text.charAt(i)+"";
			
			if(str.equals(c)){
				
				freq++;
				
			}
		}
		
		
		
		return freq;
		
	}

	public static String classicEncoding(){
		
		String txt="";
		
		
		
	    int count=0;
	
	   for(int a=0;a< (int)Math.pow(2.0,Math.ceil(Math.log(size)));a++){
		   
	

		   String str=	randomBits();

		   boolean involving=false; // checks bitsList involves two same bits 

		   for(int k=0;k<bitsList.size();k++){

			   if(str.equals(bitsList.get(k))){

				   involving =true;

				   break;
			   }

		   }	   

			if(involving){
				
				
				a--;
			
				
			}else{
				
				bitsList.add(str);
				
				count++;
			}
			  
			
			 
			 if(count==8){
				 
				 break;
			 }
			
			
	    }
	   
	  
	   
	   for(int b=0;b<text.length();b++){
		   
		   String s=""+text.charAt(b);
		   
		   int index=0;
		   
	       for(int d=0;d<list.size();d++){ 
	    	   
	    	   if(s.equals(list.get(d))){
	    		   index=d;
	    		   break;
	    	   }
	    	   
	    	   
	       }
	       
      
	       txt+=bitsList.get(index);
	       
	      
	   }
	
	   
	   return txt;
	}
	
	  public static  String randomBits(){
		  
		  
		
		int dimension=(int) Math.ceil(Math.log(size));
		
		String x="";
		
		
		Random rnd=new Random();
		
		for(int i=0;i<dimension;i++){
			
			x+=rnd.nextInt(2);
			
			}
			
		   return x;
		  }
		
	  
	}
 
   
	


