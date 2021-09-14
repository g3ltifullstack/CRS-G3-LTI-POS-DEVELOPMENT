package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Student;

public class StudentDAO {
	public static List<Student> studentDetails = new ArrayList<>();
	static {
		studentDetails.add(new Student(101, "Biswarup", "m", 101, 1, "cse"));
		studentDetails.add(new Student(102, "Akshay", "m", 102, 2, "cse"));
		studentDetails.add(new Student(103, "Akhilesh", "m", 103, 3, "cse"));
		studentDetails.add(new Student(104, "Nikita", "f", 104, 4, "cse"));
		studentDetails.add(new Student(105, "Bhabani", "m", 105, 5, "mechanical"));
		studentDetails.add(new Student(106, "Srinivas", "m", 106, 6, "mca"));
	}

	public List<Student> signUpStudent(Student student) {
		studentDetails.add(student);
		System.out.println(studentDetails);
		return studentDetails;

	}

}
