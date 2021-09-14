package com.lt.business;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Grade;

public class GradesImplService extends Grade implements GradesInterface {

	Grade grade;
	List<Grade> list = new ArrayList<>();

	@Override
	public List<Grade> uploadGrades() {
		System.out.println("Uploading Grade ");
		System.out.println("Adding List of Grades");
		list.add(new Grade(101, "A"));
		list.add(new Grade(102, "B"));
		list.add(new Grade(103, "A"));
		list.add(new Grade(104, "A"));
		list.add(new Grade(105, "C"));
		list.add(new Grade(106, "B"));
		System.out.println("Print the List of Grade Detail size : - > " + list);
		return list;
	}

//	@Override
//	public void displayGrades(List<Grade> list2) {
//		System.out.println("Displaying Grade Details ");
//		uploadGrades();
//		System.out.println("Print the List of Grade Details : - > " + list);
//	}

}
