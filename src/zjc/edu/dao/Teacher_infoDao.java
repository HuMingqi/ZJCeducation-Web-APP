package zjc.edu.dao;
import java.util.List;

import zjc.edu.pojo.Teacher_info; 

public interface Teacher_infoDao {								//��Ϊһ��ʼ�����ʧ�󣬸ýӿ�Ӧ��Ϊ���Խӿڶ����ǽ�Ϊ��Ա����
	public Integer insertTeacher_info(Teacher_info teacher_info);//�˴��ع��üҳ����ý�Ա�߼����ӿ�������������ʾ
	public Integer insert(Object obj);							//�ع�1�����ڼҳ�/��Աע��
	//public List queryInfo(String sql);		ͻȻ����DAO�ӿ�һ���͹��ˣ�����Ӧ����дһ��DAO���üҳ�/��Ա/����Աͳͳʵ����������
	public void deleteTeacher_info(Teacher_info teacher_info);
	public boolean findTeacher_info(Teacher_info teacher_info);
	public List queryTeacher_info(Teacher_info teacher_info);
	public List query(String hql);
	public boolean updateTeacher_info(String sql);
}
