package com.kh.app.student.model.service;

import java.util.List;
import java.util.Map;

import com.kh.app.student.model.dto.Student;

public interface StudentService {

	int insertStudent(Student student);

	int insertStudentMap(Map<String, Object> map);

	int getTotalCount();

	Student selectOneStudent(int no);

	int updateStudent(Student student);

	int deleteStudent(int no);

	Map<String, Object> selectOneStudentMap(int no);

	List<Student> selectStudentList();

	List<Map<String, Object>> selectStudentMapList();
	
}
