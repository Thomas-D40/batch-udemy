package com.infybuzz.listener;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import org.springframework.batch.core.SkipListener;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;

import com.infybuzz.model.StudentCsv;
import com.infybuzz.model.StudentJson;

@Component
public class SkipListenerImpl implements SkipListener<StudentCsv, StudentJson>{

	@Override
	public void onSkipInRead(Throwable t) {
		if (t instanceof FlatFileParseException) {
			createFile("C:\\Users\\Tom\\Documents\\Spring-batch-workspace\\TP_Batch_Udemy\\TP-Spring-Batch-V2\\ChunkJob\\FIrst Chunk Step\\Reader\\SkipInRead.txt",
					((FlatFileParseException)t).getInput());
		}
		
	}

	@Override
	public void onSkipInWrite(StudentJson studentJson, Throwable t) {
		createFile("C:\\Users\\Tom\\Documents\\Spring-batch-workspace\\TP_Batch_Udemy\\TP-Spring-Batch-V2\\ChunkJob\\FIrst Chunk Step\\Writer\\SkipInWrite.txt",
				studentJson.toString());		
		
	}

	@Override
	public void onSkipInProcess(StudentCsv studentCsv, Throwable t) {
		createFile("C:\\Users\\Tom\\Documents\\Spring-batch-workspace\\TP_Batch_Udemy\\TP-Spring-Batch-V2\\ChunkJob\\FIrst Chunk Step\\Processor\\SkipInProcess.txt",
				studentCsv.toString());
	}
	
	public void createFile(String filePath, String data) {
		try (FileWriter fileWriter = new FileWriter(new File(filePath), true)) {
			fileWriter.write(data + "," + new Date() + "\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
