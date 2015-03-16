package cayar_lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RPNCompute {

	
    public static int rpnCompute(String tokens) throws Exception{
		
    	ArrayStack st=new ArrayStack();

    	int index=0; // to get each character in string

    	int result=0; // holds the result of the expression,if it is in correct rpn format

        boolean incorrectformat=false; // checks whether it is in correct form

    	while(index<tokens.length()){

    		char ch=tokens.charAt(index);

    		if(Character.isDigit(ch)){ // if it is an operand

    			int numericValue = Character.getNumericValue(ch);

    			st.push((char) numericValue);


    		}else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){ // if it is an operator

 
    		  if(st.size()<2){
    			  
    			incorrectformat=true;
    			  
    			  break;
    			  
    		  }else{

    			int  first =(int)st.pop();

    			int  second=(int)st.pop();

    			int executedvalue=0;

    			if(ch=='+'){

    				executedvalue=first+second;

    			}else if(ch=='-'){

    				executedvalue=first-second;

    			}else if(ch=='*'){

    				executedvalue=first*second;

    			}else if(ch=='/'){

    				executedvalue=first/second;
    			}


    			char c=(char) executedvalue;



    			st.push(c);

    		  }

    		}else{

    			// do nothing
    		}

    		index++;

    	}



    	if(st.size()==1 && incorrectformat==false){

    		result=(int) st.pop();
    		
    		return result;

    		

    	}else{

            throw new Exception();


    	}

		
	}
	
	public static void main(String args[]) throws IOException{
		
		
		BufferedReader buffer;
		
		
		try {
			
			buffer = new BufferedReader(new FileReader("input"));
			
	        
	        
	        while (true) {
	        	
	            String text = buffer.readLine();
				if (text == null) break;
				
				try {
				
					System.out.println("The result of notation<"+text+"> is: "+rpnCompute(text));
						
					
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Incorrect rpn format,so the result cannot computed");
				}
				
	        }
	
		} catch (FileNotFoundException e) {
			
			System.out.println("Cannot read the file.");
		}
		
		

		
	}
}
