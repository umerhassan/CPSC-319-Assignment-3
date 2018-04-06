package cpsc;
/* This class stores the code for a single node.  
 * @author Muhammad Hassan
* @version 1.0
* @since Feb 13, 2018
 */
public class Node {
		Student s;
		char code;
		 Node left;
		Node right;
		 Node parent;
		
		/**
		 * Constructor for class Node
		 * @param s1 Student passed
		 * @param p parent pointer passed
		 * @param l left pointer passed
		 * @param r right pointer passed.
		 */
		public Node(Student s1,Node p,Node l, Node r) {
			try {
				s = (Student)s1.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parent=p;
			left=l;
			right=r;
		}

			/**
			 * Kindof like a default constructor for Node.
			 */
			public Node() {
				parent=null;
				left=null;
				right=null;
			}
			
			
}