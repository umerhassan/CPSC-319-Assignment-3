package cpsc;

/* This class stores the code for a single Student.  
 * @author Muhammad Hassan
* @version 1.0
* @since Feb 13, 2018
 */
public class Student implements Cloneable {
	
		int id;
		String name;
		String department;
		String program;
		char year;
		
		
			/* (non-Javadoc)
			 * This is clone method for copying object Student. 
			 * @see java.lang.Object#clone()
			 */
			public Object clone() throws CloneNotSupportedException {
			return super.clone();
			}
			
			
}
