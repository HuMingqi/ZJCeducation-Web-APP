package zjc.edu.service;

import java.util.List;

import zjc.edu.pojo.*;


public interface ParentsService {				//ͨ�÷��񣬹���Ա/��Ա/�ҳ� ����ʵ����
	public Integer addRecord(Parents_info parents_info);		//ע��
	public Integer addApply(Parents_apply parents_apply);
	public boolean checkExist(String sql);
	public boolean editPersonalInfo(String sql);
	public boolean setApplyState(String sql);
	public Parents_info getPersonalInfo(String sql);
	public List<ParentsAppTable> queryPBy(String sql); 
}
