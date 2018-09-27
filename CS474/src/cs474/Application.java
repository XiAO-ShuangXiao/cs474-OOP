package cs474;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.transform.Templates;

import com.csvreader.CsvReader;


public class Application {
	
//	private static final String SAMPLE_CSV_FILE_PATH = "data.csv";
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int inputNumber = 100;
		
		List<String> firstnameList = new ArrayList<String>();
		List<String> lastnameList = new ArrayList<String>();
		List<String> mailList = new ArrayList<String>();
		List<String> roleList = new ArrayList<String>();
		List<String> teachingList = new ArrayList<String>();
		List<String> coursesTakenList = new ArrayList<String>();
		List<String> coursesTakingList = new ArrayList<String>();
		List<String> salaryList = new ArrayList<String>();
		List<String> hourList = new ArrayList<String>();

		while (inputNumber != 0) {
			System.out.println("Please enter 0:exit 1:read 2:add 3:search 4:courses 5:taken 6:salary 7:mail ");
			inputNumber = scan.nextInt();

			switch (inputNumber) {
			case 0:
				break;
			case 1:// read document
				System.out.println("Please enter document name (.csv):");
				String SAMPLE_CSV_FILE_PATH = scan.next();
				try {
					// Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
					CsvReader csvReader = new CsvReader(SAMPLE_CSV_FILE_PATH);

					csvReader.readHeaders(); // Read the first line, set the header fields for the following line
					String[] headers = csvReader.getHeaders(); // Extracts the header (column) titles into an array of
																// Strings

					while (csvReader.readRecord()) {
					// id first last mail role teaching taken taking gpa salary hour
					// 0	   1     2     3   4      5       6     7      8   9     10
						firstnameList.add(csvReader.get(1).toLowerCase());
						lastnameList.add(csvReader.get(2).toLowerCase());
						mailList.add(csvReader.get(3).toLowerCase());
						roleList.add(csvReader.get(4).toLowerCase());
						teachingList.add(csvReader.get(5).toLowerCase());
						coursesTakenList.add(csvReader.get(6).toLowerCase());
						coursesTakingList.add(csvReader.get(7).toLowerCase());
						salaryList.add(csvReader.get(9).toLowerCase());
						hourList.add(csvReader.get(10).toLowerCase());
						

					}
					// System.out.println(firstnameList);
					// System.out.println(coursesTakenList);
//	        			System.out.println(coursesTakenList.get(1));
			        
			        csvReader.close();
			        
			        System.out.println("success!");
			        
			        // Reading Records One by One in a String array
			        //String[] nextRecord ;
			        			   			     
//			        while (csvReader.readRecord()) {
//			            System.out.println(csvReader.get("ColName")); //Returns an empty string for column names that are not found in the file
//			            for(String header : headers) // you don't need to get the strings from headers, get the fields you care about and other columns will be ignored
//			            {	
//			                System.out.println(csvReader.get(header)); // Use.get to get the values for fields that do exist
//			            }
//			        }
			    } catch (FileNotFoundException e) {
			        e.printStackTrace();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
				break;
			case 2://add information
				System.out.println(firstnameList);
				System.out.println(lastnameList);
				System.out.println(roleList);
				System.out.println(coursesTakingList);
				
				Person p = new Person();
				System.out.println("Please enter First Name:");	
				p.setFirstName(scan.next());
				System.out.println("Please enter Last Name:");	
				p.setLastName(scan.next());
				
				String fname = p.getFirstName();
				String lname = p.getLastName();
				if(firstnameList.contains(fname) && lastnameList.contains(lname))
				{
					System.out.println("exist!");
					
				}else {
					firstnameList.add(fname);
					lastnameList.add(lname);
					
					System.out.println("Please enter role:");
					p.setRole(scan.next());
					roleList.add(p.getRole());
					
					System.out.println("Please enter taking courses:");
					scan.nextLine(); //scan.next end with /r so it should be cleared, using this way
					p.setTakingCourses(scan.nextLine());
					coursesTakingList.add(p.getTakingCourses());
				
					System.out.println("Add success!");
				}
			
				break;
			case 3://search
				scan.nextLine();
				System.out.println("Please enter searching name:");
				String serachingName = scan.nextLine().toLowerCase();
				
				int index = 0;
				boolean hasName = false;
				
				if (serachingName.contains(" ")) {
					
					String tem1 = serachingName.substring(0,serachingName.indexOf(" "));
					String tem2 = serachingName.substring(serachingName.lastIndexOf(" ") + 1);
					
					for(String temStr:firstnameList )
					{
						if(temStr.contains(tem1) && lastnameList.get(index).contains(tem2)) {
							hasName = true;
							System.out.println(temStr + " "+ lastnameList.get(index));
						}
						index++;
					}
					if(hasName == false) 
						System.out.println("not existing!!!");	
				}else {
					for(String temStr:firstnameList )
					{
						if(temStr.contains(serachingName)) {
							hasName = true;
							System.out.println(temStr + " "+ lastnameList.get(index));
						}
						index++;
					}
					if(hasName == false) 
						System.out.println("not existing!!!");
				}
				break;
			case 4:
				System.out.println("Please enter name of a course:");
				String courseName = scan.next();
				
				int instrNumber = 0;
				int instrindex = 0;
				for(String temStr:teachingList ) {
					if(temStr.contains(courseName)) {
						if(instrNumber == 0) {
							System.out.println("Instructor:");
							System.out.println(firstnameList.get(instrindex)+" "+lastnameList.get(instrindex));
						}
						if(instrNumber > 0) {
							System.out.println(firstnameList.get(instrindex)+" "+lastnameList.get(instrindex));
						}else {
							System.out.println("TA:");
							
						}
						instrNumber++;
					}
					instrindex++;
				}
				break;
			case 5:
				
				int index5 = 0;
				for(String str:roleList) {
					
					if(str.equals("instructor")) {
						System.out.println("instructor: " +firstnameList.get(index5)+" "+lastnameList.get(index5)+" " + "teaching courses: "+teachingList.get(index5));
					}
					index5++;
				}
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Wrong! Please enter again!");	
			}
		}
		System.out.println("Thank you, Bye!");

	}
	
} 