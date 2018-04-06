package cpsc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
	Provides data fields and methods to create a Binary Tree 

	@author Muhammad Umer Hassan
	@version 1.0
	@since Feb 13 2018


*/
public class BinaryTree {
	
	private Node root;
	
	/**
	 * Constructor for BinaryTree
	 */
	public BinaryTree() {
		setRoot(null);
	}

	
	/**
	 * Inserting into a binary tree. First it goes to proper place using while loop modifying pointer of current, and eventually of parent. Then it inserts a leaf node at parent 
	 * or it inserts a node at root if the tree is empty initially.
	 * @param s1 Student passed from cpsc.java
	 */
	public void insert(Student s1) { // This code is modified from the code presented in CPSC 319 Lectures. 
		Node current= getRoot(),parent = null;
		   while(current!=null) {
			   parent = current;
			   if(s1.name.compareToIgnoreCase(current.s.name)>0) {
				   current = current.right; 
			   }
			   else
				   current=current.left;
		   }
		   
		   if(getRoot()==null)
			   setRoot(new Node (s1,parent,null,null));
		   else if (s1.name.compareToIgnoreCase(parent.s.name)>0)
			   parent.right=new Node(s1,parent,null,null);
		   else
			   parent.left = new Node(s1,parent,null,null);
		
	}
	
	/**
	 * This is called from cpsc.java and it deletes a required data by calling deleteRec method and then modifys the root node. 
	 * @param s1 Student 
	 */
	void deleteKey(Student s1) // THe code below this is modified from https://www.geeksforgeeks.org/java/
    {
        root = deleteRec(root,s1);
    }
 
    
    /**
     *  A recursive function to delete the record in BST 
     * @param root root of BST
     * @param s1 Student 
     * @return Node, root left or root right or root
     */
    Node deleteRec(Node root, Student s1)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (s1.name.compareToIgnoreCase(root.s.name)<0)
            root.left = deleteRec(root.left, s1);
        else if (s1.name.compareToIgnoreCase(root.s.name)>0)
            root.right = deleteRec(root.right, s1);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
        	
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.s.name = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.s);
        }
        return root;
    }
 
	/**
	 * Finds minimum value in the node provided. This is based on student's last name
	 * @param root
	 * @return returns the minimum last name of student.
	 */
	String minValue(Node root)
    {
        String minv = root.s.name;
        while (root.left != null)
        {
            minv = root.left.s.name;
            root = root.left;
        }
        return minv;
    }


	   
	    /**
	     * Prints the node inorder recursively.
	     * @param node
	     */
	    void printInorder(Node node) {
	    	
	        if (node == null)
	            return;
	 
	        /* first recur on left child */
	        printInorder(node.left);
	 
	        /* then print the data of node */
	        System.out.println(String.format("%-10s  %-7s     %-4s       %-4s   %-4s " ,node.s.name ,node.s.id, node.s.department,node.s.program,node.s.year )); //"content"   " Name: " + +" ID: " + node.s.id + " Dep: " + node.s.department + " Program: " + node.s.program + " Year: "+ node.s.year);
	 
	        /* now recur on right child */
	        printInorder(node.right);
	    }
	 
	
	 
	    /**
	     * This is called from cpsc.java and it prints tree inorder recursively.
	     * @param outputfile
	     * @throws IOException
	     */
	    void printInorder(String outputfile) throws IOException    { 
	    	
	    	printInorder(getRoot());  
	    	
	    }
	   

	  
		/**
		 * Typical getter
		 * @return root
		 */
		public Node getRoot() {
			return root;
		}
		
		/**
		 * Typical setter
		 * @param root
		 */
		public void setRoot(Node root) {
			this.root = root;
		}
		
		
		/**
		 * This prints tree in BreathFirst order, starting from top and going down printing each level one by one by calling printGivenLevel.
		 * @param outputfile name of output file 
		 */
		void printLevelOrder(String outputfile)
	    {
	        int h = height(root);
	        int i;
	        for (i=1; i<=h; i++)
	            printGivenLevel(root, i);
	    }
	 
	    /* Compute the "height" of a tree -- the number of
	    nodes along the longest path from the root node
	    down to the farthest leaf node.*/
	    int height(Node root)
	    {
	        if (root == null)
	           return 0;
	        else
	        {
	            /* compute  height of each subtree */
	            int lheight = height(root.left);
	            int rheight = height(root.right);
	             
	            /* use the larger one */
	            if (lheight > rheight)
	                return(lheight+1);
	            else return(rheight+1); 
	        }
	    }
	 
	    /**
	     * This prints  the one level in BreathFirst order  left to right.
	     * @param root
	     * @param level the level to be printed. 
	     */
	    void printGivenLevel (Node root ,int level)
	    {
	        if (root == null)
	            return;
	        if (level == 1)
		        System.out.println(String.format("%-10s  %-7s     %-4s       %-4s   %-4s " ,root.s.name ,root.s.id, root.s.department,root.s.program,root.s.year )); //"content"   " Name: " + +" ID: " + node.s.id + " Dep: " + node.s.department + " Program: " + node.s.program + " Year: "+ node.s.year);
	        else if (level > 1)
	        {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
 }
}
	
	

