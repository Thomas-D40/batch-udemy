package com.infybuzz.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.infybuzz.model.StudentCsv;
import com.infybuzz.model.StudentJDBC;
import com.infybuzz.model.StudentJson;

@Component
public class FirstItemProcessor implements ItemProcessor<StudentCsv, StudentJson> {

	@Override
	public StudentJson process(StudentCsv studentCsv) throws Exception {
		System.out.println("Inside Item Processor");
		
		if (studentCsv.getId() == 5) {
			throw new NullPointerException();
		}
		
		StudentJson studentJson = new StudentJson();
		studentJson.setId(studentCsv.getId());
		studentJson.setFirstName(studentCsv.getFirstName());
		studentJson.setLastName(studentCsv.getLastName());
		studentJson.setEmail(studentCsv.getEmail());
		
		return studentJson;
	}

}
