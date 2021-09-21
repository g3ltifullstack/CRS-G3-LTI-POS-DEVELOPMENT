package com.lt.bean;

public class GradeCard {
	private long gradeCardId;
	private long studentId;
	private String gradeName;

    /**
	 * @return gradeCardId
	 */
	public long getGradeCardId() {
		return gradeCardId;
	}
    /**
	 * @param gradeCardId
	 */
	public void setGradeCardId(long gradeCardId) {
		this.gradeCardId = gradeCardId;
	}
    /**
	 * @return studentId
	 */
	public long getStudentId() {
		return studentId;
	}
    /**
	 * @param studentId
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
    /**
	 * @return gradeName
	 */
	public String getGradeName() {
		return gradeName;
	}
    /**
	 * @param gradeName
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
