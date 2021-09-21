package com.lt.DAO;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;

public interface CourseDAO {
	/**
	 * Add Course using SQL commands
	 * 
	 * @param course
	 */
	public void insertCourse(Course course);

	/**
	 * Delete Course using SQL commands
	 * 
	 * @param courseCode
	 * @throws CourseNotFoundException
	 */
	public void deleteCourse(int courseId) throws CourseNotFoundException;

}
