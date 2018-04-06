package cpsc;
//This is same as BST so I will only comment on insert function in BinaryTree
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import cpsc.Node;

/* This class stores the code for algorithms.  
 * @author Muhammad Hassan
* @version 1.0
* @since Feb 13, 2018
 */
public class cpsc {

	public static void main(String[] args) throws IOException {
		try {
		String inputfile = args[0]+".txt";
		String outputfile = args[1]+".txt";
		String outputfile2 = args[2]+".txt";



		FileInputStream textFile1 = new FileInputStream(inputfile);
		Scanner scan = new Scanner(textFile1);
		BinaryTree bst = new BinaryTree();
		//reading input files and storing
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			//System.out.println(s);
		char code=s.charAt(0);
		int id = Integer.parseInt(s.substring(1, 8));
			String nah=s.substring(8,8+25);
			String name= nah.trim();

			
			String department=s.substring(33,37);
			String program=s.substring(37,40);
			char year=s.charAt(41);
			Node n= new Node();
			Student stu = new Student();
			n.code=code;
			stu.id=id;
			stu.name=name;
			stu.department=department;
			stu.program=program;
			stu.year=year;
			if(code=='I')
				bst.root=bst.insert(bst.getRoot(),stu);
			else
				System.out.println("Wrong code detected. Should be I");
		}
		
		 PrintStream printStream = new PrintStream(new FileOutputStream(outputfile));
		 System.setOut(printStream);
		 System.out.println("\nInorder traversal of binary tree is ");
		 System.out.println(String.format("%-10s  %-7s  %-4s  %-4s %-4s ","Name","  ID","Department","Program","Year"));
		 bst.inOrder(bst.getRoot());
		 PrintStream printStream2 = new PrintStream(new FileOutputStream(outputfile2));
		 System.setOut(printStream2);
		 System.out.println("\nDepthFirst traversal of binary tree is ");
		 System.out.println(String.format("%-10s  %-7s  %-4s  %-4s %-4s ","Name","  ID","Department","Program","Year"));
		 bst.printLevelOrder();
		 
		} catch (FileNotFoundException e) {
			System.out.println("usage");
			e.printStackTrace();
			System.exit(1);
		}
	
	
		
}
}
