package zjc.edu.service;

import zjc.edu.dao.ManagerDAO;
import zjc.edu.pojo.Manager;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDAO managerDAO; 
	@Override
	public boolean findManager(Manager manager) {
		// TODO Auto-generated method stub		
		if(managerDAO.findManagerDAO(manager)){
			return true;
		}else{
		return false;
		}
	}
	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}
	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

}
