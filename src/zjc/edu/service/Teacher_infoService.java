package zjc.edu.service;
import java.util.List;

import zjc.edu.pojo.Teacher_info;

public interface Teacher_infoService {
	public Integer insertTeacher_info(Teacher_info teacher_info);
	public void deleteTeacher_info(Teacher_info teacher_info);
	public boolean findTeacher_info(Teacher_info teacher_info);
	public List queryTeacher_info(Teacher_info teacher_info);
	public List query(String sql);
	public boolean updateTeacher_info(String sql);
}
