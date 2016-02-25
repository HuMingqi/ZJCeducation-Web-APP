package zjc.edu.dao;
import java.util.List;

import zjc.edu.pojo.Teacher_info; 

public interface Teacher_infoDao {								//因为一开始的设计失误，该接口应作为策略接口而不是仅为教员服务
	public Integer insertTeacher_info(Teacher_info teacher_info);//此处重构让家长复用教员逻辑，接口名不变以作警示
	public Integer insert(Object obj);							//重构1：用于家长/教员注册
	//public List queryInfo(String sql);		突然发现DAO接口一个就够了！！我应该重写一个DAO，让家长/教员/管理员统统实现它！！！
	public void deleteTeacher_info(Teacher_info teacher_info);
	public boolean findTeacher_info(Teacher_info teacher_info);
	public List queryTeacher_info(Teacher_info teacher_info);
	public List query(String hql);
	public boolean updateTeacher_info(String sql);
}
