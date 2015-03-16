
package ExpressionTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Eval_Expression {
	
	
	static String text;	
	
		public static void main(String [] args)
		{
				
			MyStack<String> mystack = new MyStack<String>();
					
			try {
				
				// a loop to read the expressions from the file: input.txt
				// and check their correctness based on the Check_Expr method 
				BufferedReader rd = new BufferedReader(new FileReader("Input.txt"));
				int counter=1;
				while(true){
				
				text = rd.readLine();
				if(text==null)break;
			     if (Check_Expr(text)){
					MyBT mytree = new MyBT();
				    mytree= buildExpr(text);
				   
				    if(mytree.root==null){
				    	
				     if(counter==1){
				    
				     System.out.println("The first expression has missing operand");
				     
				     }else if(counter==2){
				    	 
				     System.out.println("The second expression has missing operand");
				    	 
				     }else{
				    	 
				     System.out.println("The "+counter+"th expression has missing operand");
				     }
				     
				    }else{
				    	
				    float result=evalExpr(mytree);
				    
				  
					System.out.println("Value of Expression: " + result);
					
					// Finally do the traversals and print them
					
					
					System.out.print("Preorder traversal:: ");
					mytree.preorder();
					System.out.println();
					System.out.print("Inorder traversal: " );
					mytree.inorder();
					System.out.println();
					System.out.print("Postorder traversal: ");
					mytree.postorder();
					System.out.println();
				    }
				    }else{
				    	if(counter==1){
				    	
				    	System.out.println("The first expression has missing paranthesis");
				    	
				        }else if(counter==2){
				        	
				        
					    System.out.println("The second expression has missing paranthesis");
					    
				        }else{
				        	
				         System.out.println("The "+counter+"th expression has missing paranthesis");
				         
				        }
				    	
				    }
				counter++;
				  
				}
				rd.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
			
			// If there are errors just print an error message
			// else create the binary tree of the expression
			
		

		}
		
	
		public static boolean Check_Expr(String expr){
			
			
			// Check if the expression is correct in terms of
			// parentheses and operands
			// Hint: you can use the ParenMatch(X,n) method in your textbook to check the parentheses
			// and feel free to change the parameters of Check_Expr to suit your own error checking algorithm
			
			MyStack<Character> mystack=new MyStack<Character>();
			char ch;

			for(int i=0;i<expr.length();i++){

				ch=expr.charAt(i);

				if( ch=='(' || ch=='{'){

					mystack.push(ch);

				}else if(ch==')'){

					if(mystack.isEmpty()){
					

						return false;

					}else if(mystack.top()=='('){

						mystack.pop();

					}else{

						return false;
					}

				}else if(ch=='}'){
					if(mystack.isEmpty()){
						
						
						return false;

					}else if(mystack.top()=='{'){

						mystack.pop();

					}else{

						return false;
					}
				}

			}

			return mystack.isEmpty();
		}
		
		
		
		// Builds the binary expression tree using a stack
		public static MyBT buildExpr(String text){
			
			MyStack<MyBT> mystack = new MyStack<MyBT>();
			
			MyBT missingtree=new MyBT();
			
			
			boolean missing_operand=false;
		    
			for (int i = 0; i < text.length(); ++i) {	
				char c = text.charAt(i);
				MyBT mytree = new MyBT();
				
				// Your code comes here to build the binary expression tree
				
				
				
				if(c==')'){
					
					if(mystack.size()>=3){
					
				    MyBT E2=mystack.pop();
				    mytree=mystack.pop();
				    MyBT E1=mystack.pop();
				    
				    mytree.attach(mytree.root, E1, E2);
				   	    
				    mystack.push(mytree);
				    
					}else{
						
						missing_operand=true;
						break;
					}
				
				
				}else if(c=='(' || c==' '){
					
					//do nothing
				}else if(c=='-' || c=='+' || c=='*' || c=='/'){
					
				
				BTNode node=new BTNode(c+"",null,null);
				mytree.root=node;
				
				mystack.push(mytree);
				
				}else{
				
					
				if(mystack.isEmpty()){
					BTNode node=new BTNode(c+"",null,null);
					mytree.root=node;
					
					mystack.push(mytree);
					
				}else {
					String prev_element=mystack.top().root.element;
					
					if(prev_element.charAt(0)==')' || prev_element.charAt(0)=='+' ||prev_element.charAt(0)=='-'|| prev_element.charAt(0)=='*' || prev_element.charAt(0)=='/'){
				
					BTNode node=new BTNode(c+"",null,null);
					mytree.root=node;
					
					mystack.push(mytree);
					
				   }else{
				
					mystack.pop();
					BTNode node=new BTNode(prev_element+c,null,null);
                    mytree.root=node;
					
					mystack.push(mytree);
				  }
					
				}
					
			}
				
		}
			
			if(missing_operand==true){
				return missingtree;
				
			}else{
		
			return mystack.pop();	//After building the tree there is just one item in the stack which is the binary expression tree
			}
		}
		
		
		
		// Calculate the result of the arithmetic expression
		public static float evalExpr(MyBT tree){

              float result = 0; 
              
            
            
            	if(tree.isInternal(tree.root)){
				
				if(tree.root.element.charAt(0)=='+' || tree.root.element.charAt(0)=='-' || tree.root.element.charAt(0)=='*' || tree.root.element.charAt(0)=='/'){
					
					float x=0;
					float y=0;
					if(tree.hasLeft(tree.root)){

						x=evalExpr(tree.root.left);
				
					}
					if(tree.hasRight(tree.root)){

						y=evalExpr(tree.root.right);

					}

					if(tree.root.element.equals("-")){

						result= x - y;

					}else if(tree.root.element.equals("+")){

						result= x+y;

					}else if(tree.root.element.equals("*")){

						result= x*y;

					}else if(tree.root.element.equals("/")){

						result= x/y;
					}
				 
				}

			  }else{
				  
				result=Float.valueOf(tree.root.element);
				
			  
			
            }
		
            return result;
		}
}
			
