package com.infybuzz.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.infybuzz.model.StudentCsv;
import com.infybuzz.model.StudentJson;
import com.infybuzz.model.StudentResponse;
import com.infybuzz.model.StudentXML;
import com.infybuzz.model.StudentJDBC;

@Component
public class FirstItemWriter implements ItemWriter<StudentJDBC> {

	@Override
	public void write(List<? extends StudentJDBC> items) throws Exception {
		System.out.println("Inside Item Writer");
		items.stream().forEach(System.out::println);
	}

}
