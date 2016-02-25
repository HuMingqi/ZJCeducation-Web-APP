package zjc.edu.dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import zjc.edu.pojo.Teacher_info;

public class Teacher_infoDaoImpl implements Teacher_infoDao {
	private SessionFactory sf;
	private Integer teacherNumber=-1;
	public void setSf(SessionFactory sf){
		this.sf=sf;
	}
	public SessionFactory getSf(){
		return sf;
	}
	public Integer insertTeacher_info(Teacher_info teacher_info){
		//SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//String datestr=sdft.format(new Date());
		teacher_info.setRegister_date(new Date());
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{
			System.out.println("begin transaction");				
			session.save(teacher_info);
			System.out.println("saving teacher_info succeed.");
		
			List teacher_number=session.createQuery("select max(t.number) from Teacher_info as t").list();
			if(teacher_number.size()==1){
				teacherNumber=(Integer) teacher_number.get(0);
			}		
			tx.commit();
			System.out.println("committed");			
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return teacherNumber;
	}
	public void deleteTeacher_info(Teacher_info teacher_info){
	/*	Teacher_info teach=(Teacher_info) sf.getCurrentSession().load(Teacher_info.class, new Integer(teacher_info.getNumber()));
		sf.getCurrentSession().delete(teach);
		*/
	}

	public boolean findTeacher_info(Teacher_info teacher_info){
		String hql="select t.number,t.password from Teacher_info t where t.number="+teacher_info.getNumber()+" and t.password='"+teacher_info.getPassword()+"'";
		boolean bool=false;
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{			
			List loginList=session.createQuery(hql).list();
			if(loginList.size()>0){
				bool= true;
			}else{
				bool=false;
			}	
			tx.commit();			//即使查询，也要提交
		//	session.close();							session was already closed
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return bool;
	}
	
	public List queryTeacher_info(Teacher_info teacher_info){
		List tinfo=null;
		String hql="from Teacher_info t where t.number="+teacher_info.getNumber().toString();//from will return a object defined by Teacher_info
		System.out.println(hql);
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();//获取并开始事务
		try{			
			tinfo=session.createQuery(hql).list();	
			tx.commit();
			System.out.println("commited");
			System.out.println(tinfo);
			//session.close();
			//System.out.println("session close");
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return tinfo;		
	}
	
	public boolean updateTeacher_info(String sql){
		//teacher_info.setNumber(number);		
		boolean bool=false;
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{			
			bool=(session.createQuery(sql).executeUpdate()>0);
			tx.commit();		
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return bool;		
	}
	
	@Override
	public Integer insert(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List query(String hql){ 
		List tinfo=null;		
		System.out.println(hql);
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();//获取并开始事务
		try{			
			tinfo=session.createQuery(hql).list();	
			tx.commit();
			System.out.println("commited");
			System.out.println(tinfo);
			//session.close();
			//System.out.println("session close");
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return tinfo;
	}
		
}
