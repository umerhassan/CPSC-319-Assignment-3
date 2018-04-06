package cpsc;
//This is same as BST so I will only comment on insert function in BinaryTree
public class Student implements Cloneable {
	
		int id;
		String name;
		String department;
		String program;
		char year;
		
			public Object clone() throws CloneNotSupportedException {
			return super.clone();
			}
			
			
}
