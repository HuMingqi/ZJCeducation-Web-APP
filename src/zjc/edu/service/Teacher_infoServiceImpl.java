package zjc.edu.service;
import java.util.List;

import zjc.edu.pojo.Teacher_info;
import zjc.edu.dao.Teacher_applyDaoImpl;
import zjc.edu.dao.Teacher_infoDao;

public class Teacher_infoServiceImpl implements Teacher_infoService{
	private Teacher_infoDao teacher_infoDao;
	
	public Teacher_infoDao getTeacher_infoDao() {
		return teacher_infoDao;
	}

	public void setTeacher_infoDao(Teacher_infoDao teacher_infoDao) {
		this.teacher_infoDao = teacher_infoDao;
	}
	
	public Integer insertTeacher_info(Teacher_info teacher_info) {
		// TODO Auto-generated method stub
		return teacher_infoDao.insertTeacher_info(teacher_info);		
	}
	
	public void deleteTeacher_info(Teacher_info teacher_info) {
		// TODO Auto-generated method stub
		teacher_infoDao.deleteTeacher_info(teacher_info);
	}
	public boolean findTeacher_info(Teacher_info teacher_info){
		return teacher_infoDao.findTeacher_info(teacher_info);
	}
	
	public List queryTeacher_info(Teacher_info teacher_info){
		return teacher_infoDao.queryTeacher_info(teacher_info);
	}
	
	public List query(String hql){
		return teacher_infoDao.query(hql);
	}
	@Override
	public boolean updateTeacher_info(String sql) {
		// TODO Auto-generated method stub
		return teacher_infoDao.updateTeacher_info(sql);		
	}	
	
}
