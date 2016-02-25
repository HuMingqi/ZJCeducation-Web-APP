package zjc.edu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import zjc.edu.pojo.*;

public class ParentsInfoDAOExtComm extends AnythingDAOCommonImpl {	
	@Override
	public Integer insert(Object obj) {
		// TODO Auto-generated method stub
		Integer parentsNumber=-1;
		Parents_info parents_info=(Parents_info)obj;
		//SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");
		//parents_info.setRegister_date(sdft.format(new Date()));
		Session session=sf.getCurrentSession();		//³¬ÀàµÄsf
		Transaction tx=session.beginTransaction();
		try{
			System.out.println("begin transaction");				
			session.save(parents_info);
			System.out.println("saving parents_info succeed.");		
			List parents_number=session.createQuery("select max(t.number) from Parents_info as t").list();
			if(parents_number.size()==1){
				parentsNumber=(Integer) parents_number.get(0);
			}		
			tx.commit();
			System.out.println("committed");			
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return parentsNumber;		
	}	
}
