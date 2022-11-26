import java.util.Scanner;
import java.io.*;

public class GradingProgram
{
	public static void main(String args[])
	{  
	
	
	File file = new File("data.txt");
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null)
            {
                contents.append(text)
                    .append(System.getProperty(
                        "line.separator"));
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } 
        
        // show file contents here
        System.out.println(contents.toString());
	
	
	 System.out.println("\n");
	    System.out.println("============== A JAVA GRADING PROGRAM ===============\n");
		Scanner student = new Scanner(System.in);
		System.out.println("Enter Your Course Work Marks for Java Programing:");
		int Cjava = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Java Programming Course work Marks = "+Cjava);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println("Enter Your Final Exams Marks for Java Programing:");
		int Ejava = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Java Programming Final Exam Marks = "+Ejava);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		int Fjava = Cjava + Ejava;
		System.out.println("YOU SCORED "+Fjava +" MARKS IN JAVA PROGRAMMING");
		System.out.println("================================================================================\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Total Marks In Java Programming = "+Fjava);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println("Enter Your Course Work Marks for website development:");
		int Cweb = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Website Development Course work Marks = "+Cweb);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		System.out.println("Enter Your Final Exams Marks for website development:");
		int Eweb = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Website Development Final Exam Marks = "+Eweb);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		int Fweb = Cweb + Eweb;
		System.out.println("YOU SCORED "+Fweb +" MARKS IN WEBSITE DEVELOPMENT");
		System.out.println("===============================================================================\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Total Marks In web Website Development = "+Fweb);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println("Enter Your Course Work Marks for system analysis:");
		int Canalysis = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("System Analysis Course Work Marks = "+Canalysis);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		System.out.println("Enter Your Final Exams Marks for system analysis:");
		int Eanalysis = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("System Analysis Final Exam Marks = "+Eanalysis);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		int Fanalysis = Canalysis + Eanalysis;
		System.out.println("YOU SCORED "+Fanalysis +" MARKS IN SYSTEM ANAYLSIS");
		System.out.println("===============================================================================\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Total Marks In System Analysis = "+Fanalysis);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
		System.out.println("Enter Your Course Work Marks for systemm security:");
		int Csecurity = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("System Security Course Work Marks = "+Csecurity);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		System.out.println("Enter Your Final Exams Marks for system security:");
		int Esecurity = student.nextInt();
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("System Security Final Exam Marks = "+Esecurity);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		int Fsecurity = Csecurity + Esecurity;
		System.out.println("YOU SCORED "+Fsecurity +" MARKS IN SYSTEM SECURITY");
		System.out.println("==============================================================================\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Total Marks In System Security = "+Fsecurity);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
		int total = Fjava + Fweb + Fanalysis + Fsecurity;
		System.out.println("YOUR OVERALL MARKS IN ALL THE COURSE UNITS IS: "+total);
		System.out.println("==============================================================================\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("GRAND TOTAL IN ALL COURSE UNITS = "+total);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
		
		double average = total / 4;
		System.out.println("YOUR AVERAGE MARKS IS: "+average);
		System.out.println("============================================================================\n\n");
		try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("Student Average Marks = "+average);
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
	    	if(total<100)
		{
			System.out.println("YOUR GPA IS 0.01 AND YOU FAILED\n");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("YOUR GPA IS 0.01 AND YOU FAILED\n");
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
	     	else if(total <=200)
		{
			System.out.println("YOUR GPA IS 0.02 AND YOUR GRADE IS C\n");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("YOUR GPA IS 0.02 AND YOUR GRADE IS C\n");
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
			else if(total <=300)
		{
			System.out.println("YOUR GPA IS 3.0 AND YOUR GRADE IS B\n");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("YOUR GPA IS 3.0 AND YOUR GRADE IS B\n");
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
			else if(total <=400)
		{
			System.out.println("YOUR GPA IS 4.0 AND YOUR GRADE IS A\n");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("YOUR GPA IS 4.0 AND YOUR GRADE IS A\n");
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
			else if(total >400)
		{
			System.out.println("COURSE WORK SHOULD NOT EXCEED 30 AND FINAL EXAM SHOULD NOT EXCEED 70\n");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("COURSE WORK SHOULD NOT EXCEED 30 AND FINAL EXAM SHOULD NOT EXCEED 70\n");
            writer.write("\r\n");   // write new line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
	     	else
		{
			System.out.println("SOME THING WENT WRONG. DOUBLE CHECK YOUR INPUTS");
			try {
            FileWriter writer = new FileWriter("MyFile.txt", true);
            writer.write("\r\n");   // write new line
            writer.write("SOME THING WENT WRONG. DOUBLE CHECK YOUR INPUTS");
            writer.write("\r\n");   // write new line
            writer.write("\r\n");
            writer.write("\r\n");
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
		
		
	}
}