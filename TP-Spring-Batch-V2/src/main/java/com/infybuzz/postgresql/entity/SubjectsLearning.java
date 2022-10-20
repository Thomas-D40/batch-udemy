package com.infybuzz.postgresql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects_learning")
public class SubjectsLearning {
	
	
	@Id
	private Long id;
	
	@Column(name = "sub_name")
	private String subName;
	
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "marks_obtained")
	private Long marksObtained;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Long marksObtained) {
		this.marksObtained = marksObtained;
	}
	
	

}
