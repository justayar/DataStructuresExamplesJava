
package ExpressionTree;

public class MyBT{
	
	protected BTNode root;	//The root of the binary tree
	protected int size;		//The size of the tree
	
	public MyBT(){
		root=null;
		size=0;
	}
	
	
	
	//There is no need to use all the methods listed here, just implement those you need
	//We put them to make sure we prepared whatever you need in your codes
	
	

	// Returns the left subtree of node v
	public MyBT left(BTNode v) {
		
		return v.left;
	}

	// Returns the right subtree of node v
	public MyBT right(BTNode v) {
	
		return v.right;
	}

	// Checks whether the node v has left subtree
	public boolean hasLeft(BTNode v) {

		return v.left!=null;
	}

	// Checks whether the node v has right subtree
	public boolean hasRight(BTNode v) {

		return v.right!=null;
	}

	// Returns the size of the tree
	public int size() {		
		return size;
	}

	// Checks whether the tree is empty
	public boolean isEmpty() {	
		return size==0;
	}

	// Returns the root of the tree
	public BTNode root() {
		return root;
	}

	
	// Checks whether the node v is an internal node
	public boolean isInternal(BTNode v) {
		return (hasLeft(v) || hasRight(v));
	}

	// Checks whether the node v is an external node
	public boolean isExternal(BTNode v) {
		return false;
	}

	// Checks whether the node v is the root
	public boolean isRoot(BTNode v) {
		return (v==root());
	}
	
	
	// Creates a new node of the binary tree
	protected BTNode createNode(String element, MyBT left, MyBT right){
		size+=1;
		return new BTNode(element, left,right);
	}
	
	
	//Attaches two binary trees to make a new one
	public static void attach(BTNode v, MyBT t1, MyBT t2){
		v.setLeft(t1);
		v.setRight(t2);
	}

		
	
	//Does the preorder traversal of the tree
	public void preorder(){
		 if(root==null) return;
		 
		   System.out.print(root.element);
			
			if(root.left!=null){
			
			root.left.preorder();
			}
			
			if(root.right!=null){
		    root.right.preorder();
			}
			
		
	}
	
	
	// Does the inorder traversal of the tree
	

	public void inorder(){
		
		if(root==null) return;
		
		if(root.left!=null){
		
		root.left.inorder();
		}
		System.out.print(root.element);
		if(root.right!=null){
	    root.right.inorder();
		}
		
	}
	

	// Does the postorder traversal of the tree
	public void postorder(){
        if(root==null) return;
		
		if(root.left!=null){
		
		root.left.postorder();
		}
		
		if(root.right!=null){
	    root.right.postorder();
		}
		System.out.print(root.element);
	}
}
