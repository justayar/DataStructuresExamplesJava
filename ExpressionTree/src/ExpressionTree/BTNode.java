
package ExpressionTree;

public class BTNode {
	
	String element;	//elements of the binary tree
	MyBT left, right;	//pointers to the left and right subtrees
	
	public BTNode(String element, MyBT left, MyBT right){
		setElement(element);
		setLeft(left);
		setRight(right);
	}
	
	//Sets the element of a new BTNode
	public void setElement(String elem){
		element=elem;
	}
	
	//Sets the left subtree
	public void setLeft(MyBT leftTree){
		left=leftTree;
	}
	
	//Sets the right subtree
	public void setRight(MyBT rightTree){
		right=rightTree;
	}

	
	
}
