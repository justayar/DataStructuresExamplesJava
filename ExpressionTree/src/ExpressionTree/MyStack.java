
package ExpressionTree;

import java.util.EmptyStackException;

public class MyStack<S> {
	

	int topOfStack; // The pointer to the top item
	private S[] arr;
	private static final int DEFAULT_CAPACITY = 100;

	public MyStack()
	{
		arr = (S[]) new Object[DEFAULT_CAPACITY];
		topOfStack = -1;
	}

	//Returns the top item in the stack
	public S top() {
		if(isEmpty()){
			throw new EmptyStackException();
			
		}else{
			
			return arr[topOfStack];
		}
	}

	//Returns the size of the stack
	public int size() {
		
		return topOfStack+1;
	}


	//Insert an item on top the stack
	public void push(S x) {
		
		if(topOfStack==arr.length-1){
			
			S copy_array[]=(S[]) new Object[2*arr.length];
			
			for(int i=0;i<arr.length;i++){
				
				copy_array[i]=arr[i];
			}
			
			arr=copy_array;
		}
			
			arr[++topOfStack]=x;
			
		
			
		
		
	}

	//Removes the item on top of the stack
	public S pop() {
	if(isEmpty()){
		throw new EmptyStackException();
		
	}else{
		
		return arr[topOfStack--];
	}
		
		
	
	}

	//Check if the stack is empty
	public boolean isEmpty() {
		
		return topOfStack==-1;
	}

}
