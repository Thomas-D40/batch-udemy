package com.infybuzz.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.infybuzz.model.StudentCsv;
import com.infybuzz.model.StudentJDBC;
import com.infybuzz.model.StudentJson;
import com.infybuzz.postgresql.entity.Student;

@Component
public class FirstItemProcessor implements ItemProcessor<Student, com.infybuzz.mysql.entity.Student> {

	@Override
	public com.infybuzz.mysql.entity.Student process(Student postgreStudent) throws Exception {
		System.out.println(postgreStudent.getId());
		
		com.infybuzz.mysql.entity.Student mysqlStudent = new com.infybuzz.mysql.entity.Student();
		mysqlStudent.setId(postgreStudent.getId());
		mysqlStudent.setFirstName(postgreStudent.getFirstName());
		mysqlStudent.setLastName(postgreStudent.getLastName());
		mysqlStudent.setEmail(postgreStudent.getEmail());
		mysqlStudent.setDeptId(postgreStudent.getDeptId());
		mysqlStudent.setIsActive(postgreStudent.getIsActive() != null ? Boolean.valueOf(postgreStudent.getIsActive()): false);
//		if (postgreStudent.getIsActive() == "true") {
//			mysqlStudent.setIsActive(true);
//		}
//		if (postgreStudent.getIsActive() == "false") {
//			mysqlStudent.setIsActive(false);
//		}
		
		return mysqlStudent;
	}

}
