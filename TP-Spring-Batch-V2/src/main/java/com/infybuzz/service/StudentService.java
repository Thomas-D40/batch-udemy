package com.infybuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infybuzz.model.StudentResponse;

@Service
public class StudentService {
	
	public List<StudentResponse> restCallToGetStudents() {
		RestTemplate restTemplate = new RestTemplate();
		
		StudentResponse[] studentResponses =  restTemplate.getForObject("http://localhost:8081/api/v1/students", StudentResponse[].class);
		
		List<StudentResponse> list = new ArrayList<>();
		
		for(StudentResponse sr: studentResponses) {
			list.add(sr);
		}
		
		return list;
	}

}
