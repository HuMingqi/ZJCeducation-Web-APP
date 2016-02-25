package zjc.edu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AnythingDAOCommonImpl implements AnythingDAO {
	protected SessionFactory sf;				//protected ���ⲻ�ɼ������������� ���Լ̳�����ɼ���private �Լ̳����಻�ɼ�
	public void setSf(SessionFactory sf){
		this.sf=sf;
	}
	public SessionFactory getSf(){
		return sf;
	}
	
	@Override
	public Integer insert(Object obj) {
		// TODO Auto-generated method stub
		return null;						//�ɼ̳���ʵ��
	}
	
	@Override
	public List query(String sql) {
		// TODO Auto-generated method stub
		List temp=null;
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();		
		try{						
			System.out.println("Transaction has began.");
			temp=session.createSQLQuery(sql).list();
		}catch(Exception ex){
			System.out.println(ex);			
		}
		tx.commit();
		System.out.println("query parents_info done");
		return temp;
	}

	@Override
	public boolean update(String Sql) {
		// TODO Auto-generated method stub
		boolean bool=false;
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{			
			bool=(session.createSQLQuery(Sql).executeUpdate()>0);
			tx.commit();		
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return bool;
	}
	
}
