package zjc.edu.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zjc.edu.pojo.Parents_apply;
import zjc.edu.pojo.Parents_info;

public class ParentsApplyDAOExtComm extends AnythingDAOCommonImpl {
	public Integer insert(Object obj) {
		// TODO Auto-generated method stub		
		Integer flag=0;
		Parents_apply parents_apply=(Parents_apply)obj;	
		Session session=sf.getCurrentSession();		//³¬ÀàµÄsf
		Transaction tx=session.beginTransaction();
		try{
			System.out.println("begin transaction");				
			session.save(parents_apply);
			System.out.println("saving parents_info succeed.");							
			tx.commit();
			flag=1;
			System.out.println("committed");			
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return flag;		
	}	
}
