package cpsc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
	Provides data fields and methods to create a AVL Tree

	@author Muhammad Umer Hassan
	@version 1.0
	@since Feb 13 2018


*/
public class BinaryTree {

	private int sizeM;
	Node root;
	
	/**
	 * Constructor for BinaryTree
	 */
	public BinaryTree() {
		sizeM=0;
		setRoot(null);
	}


	// A utility function to get height of the tree
    int height(Node N)
    {
        if (N == null)
             return 0;
         return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    Node leftRotate(Node x)
    {
        Node y = x.right; 
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, Student stu)
    {
        /* 1.  Perform the normal BST rotation */
        if (node == null)
            return (new Node(stu));
 
        if ((stu.name.compareToIgnoreCase(node.s.name)<0))//)key < node.key)
            node.left = insert(node.left, stu);
        else if ((stu.name.compareToIgnoreCase(node.s.name)>0))//key > node.key)
            node.right = insert(node.right, stu);
        else // Equal keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
           node to check whether this node became
           Wunbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && (stu.name.compareToIgnoreCase(node.left.s.name)<0))//key < node.left.key)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && (stu.name.compareToIgnoreCase(node.right.s.name)>0))//key > node.right.key)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && (stu.name.compareToIgnoreCase(node.left.s.name)>0))//key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && (stu.name.compareToIgnoreCase(node.right.s.name)<0))//key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
		
		//BreadthFirst
		void printLevelOrder()
	    {
	        int h = height(root);
	        int i;
	        for (i=1; i<=h; i++)
	            printGivenLevel(root, i);
	    }
	 
	 
	    /* Print nodes at the given level */
	    void printGivenLevel (Node root ,int level)
	    {
	        if (root == null)
	            return;
	        if (level == 1)
	        	 System.out.println(String.format("%-10s  %-7s     %-4s       %-4s   %-4s " ,root.s.name ,root.s.id, root.s.department,root.s.program,root.s.year ));
	        else if (level > 1)
	        {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
	    }
	    void inOrder(Node node)
	    {
	        if (node != null)
	        {
	            
	            inOrder(node.left);
	            System.out.println(String.format("%-10s  %-7s     %-4s       %-4s   %-4s " ,node.s.name ,node.s.id, node.s.department,node.s.program,node.s.year ));
	            inOrder(node.right);
	        }
	    }
}
	
	

