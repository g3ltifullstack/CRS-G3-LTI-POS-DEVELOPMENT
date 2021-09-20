package com.lt.DAO;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;

public interface CourseDAO {
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId) throws CourseNotFoundException;

}
