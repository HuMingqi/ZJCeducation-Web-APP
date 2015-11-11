package zjc.edu.dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import zjc.edu.pojo.Manager;

public class ManagerDAOImpl implements ManagerDAO {	
	private SessionFactory sf;
	
	@Override
	public boolean findManagerDAO(Manager manager) {
		// TODO Auto-generated method stub
		String hql="select name,password from Manager where name='"+manager.getName()+"' and password='"+manager.getPassword()+"'";
		boolean bool=false;
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{			
			List loginList=session.createQuery(hql).list();
			if(loginList.size()==1){
				bool= true;
			}else{
				bool=false;
			}	
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return bool;
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf= sf;
	}
	
}
