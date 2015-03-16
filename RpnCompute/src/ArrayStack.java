package cayar_lab1;

import java.util.EmptyStackException;

public class ArrayStack {
	


	private static final int capacity=7;
	private char arr[]=new char[capacity];
	private int top=-1;


	public boolean isEmpty(){

		return top==-1;
	}

	public void push(char a) throws Exception{

		if(top==capacity-1){ // checks array is full or not


			System.out.println("The stack is full");

		}else{

			top++;

			arr[top]=a;
		}
	}

	public char pop(){

		char poppedvalue;

		if(isEmpty()){

			System.out.println("Stack is empty");
			
			return 0;
			
		}else{
			poppedvalue=arr[top];
			
			top--;

			return poppedvalue;
			
		}
		
	}

	public int size(){

		return top+1;
	}
	
	


}

