package com.grade.web.daoimpls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.grade.web.daos.StudentDAO;
import com.grade.web.domain.StudentBean;

public class StudentDAOImpl implements StudentDAO {
	public static final String FILE_PATH = String.format(
			"C:%sUsers%suser%seclipse-jee%sjee-grade%sWebContent%sresources%stxt%s", File.separator, File.separator,
			File.separator, File.separator, File.separator, File.separator, File.separator, File.separator);

	@Override
	public void Information(StudentBean param) {
		try {
			File file = new File(FILE_PATH + "grade.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s님의 학번은%s이고 총점은%s점 평균은 %s점입니다."
						,param.getName(),param.getClassNum(),param.getTotatlScore(),param.getAverage()));
			writer.newLine();
			writer.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
