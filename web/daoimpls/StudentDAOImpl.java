package com.grade.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.grade.web.pool.Constants;
import com.grade.web.daos.StudentDAO;
import com.grade.web.domain.StudentBean;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public void Information(StudentBean param) {
		try {
			File file = new File(Constants.FILE_PATH + "student0905.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s,%s,%s"
						,param.getName(),param.getSsn(),param.getClassNum()));
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public StudentBean login(StudentBean param) {
		try {
			File file = new File(Constants.FILE_PATH + "student0905.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = reader.readLine();
			reader.close();
			String[] info = new String[3];
			info = msg.split(",");
			param.setName(info[0]);
			param.setSsn(info[1]);
			param.setClassNum(info[2]);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return param;
	}

}
