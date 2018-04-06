package cpsc;
//This is same as BST so I will only comment on insert function in BinaryTree
public class Node {
		Student s;
		char code;
		 Node left;
		Node right;
		 Node parent;
		 int height;
		
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

			public Node() {
				parent=null;
				left=null;
				right=null;
				height = 1; 
			}
			public Node(Student s1) {
				try {
					s = (Student)s1.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				height=1;
			}
			
			
}