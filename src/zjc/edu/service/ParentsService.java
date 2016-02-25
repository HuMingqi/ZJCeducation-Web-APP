package zjc.edu.service;

import java.util.List;

import zjc.edu.pojo.*;


public interface ParentsService {				//通用服务，管理员/教员/家长 首先实现它
	public Integer addRecord(Parents_info parents_info);		//注册
	public Integer addApply(Parents_apply parents_apply);
	public boolean checkExist(String sql);
	public boolean editPersonalInfo(String sql);
	public boolean setApplyState(String sql);
	public Parents_info getPersonalInfo(String sql);
	public List<ParentsAppTable> queryPBy(String sql); 
}
