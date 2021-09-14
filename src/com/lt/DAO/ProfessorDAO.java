package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Professor;

public class ProfessorDAO {
	public static List<Professor> professorDetails = new ArrayList<>();
	static {
		professorDetails.add(new Professor(101, "Biswarup", "cse"));
		professorDetails.add(new Professor(102, "Akshay", "cse"));
		professorDetails.add(new Professor(103, "Akhilesh", "cse"));
		professorDetails.add(new Professor(104, "Nikita", "cse"));
		professorDetails.add(new Professor(105, "Bhabani", "mechanical"));
		professorDetails.add(new Professor(106, "Srinivas", "mca"));
	}

	public List<Professor> createProfessor(Professor professor) {
		professorDetails.add(professor);
		System.out.println(professorDetails);
		return professorDetails;

	}

}
