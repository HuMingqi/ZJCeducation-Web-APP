package zjc.edu.service;

import java.util.Date;
import java.util.List;

import zjc.edu.pojo.TeacherAppTable;
import zjc.edu.pojo.Teacher_apply;

public interface Teacher_applyService {	
	public boolean insertTeacher_apply(Teacher_apply teacher_apply);
	public List<TeacherAppTable> readRange(Date d1,Date d2);
	public List<TeacherAppTable> queryTBy(String sql); 
	public boolean setState(String sql);
}
