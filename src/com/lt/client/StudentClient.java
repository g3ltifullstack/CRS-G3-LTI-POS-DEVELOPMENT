package com.lt.client;


import java.util.Date;
import java.util.Scanner;

import com.lt.bean.Student;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.NotificationImplService;
import com.lt.business.NotificationInterface;
import com.lt.business.PaymentImplService;
import com.lt.business.PaymentInterface;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.client.StudentClient;



public class StudentClient {
	//initializing the scanner
		Scanner sc= new Scanner(System.in); 
		

		// studentClient landing page
		public void studentClientPage(Student student) {
			

			// initializing the instance courseOperation to carry out course operations 
			CourseInterface courseOperation= new CourseImplService();
			// initializing the instance studentOperation to carry out student operations 
			StudentInterface studentOperation= new StudentImplService();

			// begin variable listing
			int choice;
			int courseId;
			

			//student client landing page contents
			
			while(true) {

				// declaration of menu for student
				System.out.println("Choose an option");
				System.out.println("1. View All Courses");  
				System.out.println("2. Add a course");
				System.out.println("3. Drop a course");
				System.out.println("4. View Selected Courses");
				System.out.println("5. Pay Fee");
				System.out.println("6. View receipt");//prof
				System.out.println("7. Logout");
				choice= sc.nextInt();

				switch(choice) {
				// display all available courses for a particular student
				case 1:
					courseOperation.displayCourses(student);
					continue;
				case 2:
					
					System.out.println("Enter CourseID of the Course to be added");
				    courseId= sc.nextInt();
					studentOperation.addCourse(courseId, student);
					
					continue;

			//	 drop a course by student
				case 3:
			
					System.out.println("Enter CourseID of the Course to be dropped");
					courseId= sc.nextInt();
					studentOperation.dropCourse(courseId, student);
					continue;
					
					// display all the courses that student has selected.
				case 4:
					studentOperation.displaySelectedCourses(student);
					continue;
					// submit registration
				case 5:
					PaymentInterface pymt=new PaymentImplService();
					pymt.payment(student);
					
				case 6:
					PaymentInterface pymt1=new PaymentImplService();
					pymt1.viewreceipt(student);
				}
	
				break;
			}

}
		}

		
