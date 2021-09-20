package com.lt.client;

import java.util.Scanner;

import com.lt.client.AdminClient;
import com.lt.client.ProfessorClient;
import com.lt.client.StudentClient;
import com.lt.business.UserInterface;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;

public class UserClient {
public static void main(String[] args) {
		
		//initializing the scanner
		Scanner sc= new Scanner(System.in); 

		// initializing the instance courseOperation to carry out user operations 
	
		UserInterface userOperation= new UserImplService();
		StudentInterface studentOperation=new StudentImplService();
		//intialising user
		User user=new User();
		Student student = new Student();
        
		//user login landing page
		while(true) {
			System.out.println("*******WELCOME TO COURSE MANAGEMENT SYSTEM***********");
			System.out.println("Select any Option");
			System.out.println("1.Signup");
			System.out.println("2.Login");
			int option=sc.nextInt();
			
			switch(option) {
			
			case 1:
			// signup page
			System.out.println("Enter userName");
			String userName = sc.next();
			
			System.out.println("Enter password");
			String passWord = sc.next();
			
			System.out.println("Enter Gender");
			String gender = sc.next();
			
			System.out.println("enter phonenumber:");
			long phno=sc.nextLong();
			
			System.out.println("enter semester:");
			int sem=sc.nextInt();
			
			System.out.println("enter branch:");
			String branch=sc.next();
			
			System.out.println("enter user role: 101 for Student, 102 for Professor, 103 for Admin ");
			int role=sc.nextInt();
			
		
		    userOperation.createUser(userName,passWord,role);
		    
		    student.setName(userName);
		    student.setPhoneNumber(phno);
		    student.setBranch(branch);
		    student.setGender(gender);
		    student.setSemester(sem);
		    studentOperation.createStudent(student);
		    
	        
		    
	        continue;
			    
			
			
			
			case 2:
			// fetching input for user credentials
			System.out.println("Enter your credentials");
			System.out.println("Enter UserName");                          
			String username= sc.next();
			System.out.println("Enter password");
			String password= sc.next();
			
			try{
				
				// validating the user credentials
				User checkedUser= userOperation.validateUser(username, password);
				int profile= checkedUser.getRoleId();
				int userId1= checkedUser.getUserId();
				

				
				
				switch(profile) {
				// if user is a student
				case 101:
					
					// fetching student object from student table
			       Student student1 = userOperation.fetchStudent(userId1);
			      
					//
					StudentClient studentClient= new StudentClient();
					
					
					// redirecting to student client landing page
					studentClient.studentClientPage(student1);
					
	//				continue;
                    break;

				//if user is a professor
//				case 2:
//					//fetching professor object from professor table
//					Professor professor= userOperation.fetchProfessor(userId);
//					ProfessorClient professorClient= new ProfessorClient();
//					//redirecting to professor client landing page
//					professorClient.professorClientPage(professor);
//					continue;
//
//				//if user is an admin
//				case 3:
//					// fetching admin object from admin table
//					Admin admin= userOperation.fetchAdmin(userId);
//					AdminClient adminClient= new AdminClient();
//					// redirecting to admin client landing page
//					adminClient.adminClientPage(admin);
//					continue;
//				}
//	
				}}
			// catching the InvalidLoginException in catch block
			catch(Exception e){}
		//	continue;
//				Object logger;
//				logger.error(e.getMessage());				
				continue;		
			
			}
			break;
			
		}}}



