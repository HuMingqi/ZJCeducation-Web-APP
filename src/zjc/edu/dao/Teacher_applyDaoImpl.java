package zjc.edu.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import zjc.edu.pojo.TeacherAppTable;
import zjc.edu.pojo.Teacher_apply;

public class Teacher_applyDaoImpl implements Teacher_applyDAO {
	private SessionFactory sf;	
	public void setSf(SessionFactory sf){
		this.sf=sf;
	}
	public SessionFactory getSf(){
		return sf;
	}
	public boolean insertTeacher_apply(Teacher_apply teacher_apply) {			
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{						
			System.out.println("Transaction has began.");			
			session.save(teacher_apply);
			System.out.println("saving teacher_apply succeed.");
			
			tx.commit();
			System.out.println("committed");	
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return true;
	}
	
	@Override
	public List<TeacherAppTable> readRange(Date d1, Date d2) {
		// TODO Auto-generated method stub
		List<TeacherAppTable> list=new ArrayList<TeacherAppTable>();//List 是接口
		SimpleDateFormat dfmt=new SimpleDateFormat("yyyy-MM-dd");  //mm is wrong
		String sd1=dfmt.format(d1);  
		String sd2=dfmt.format(d2);  
		String sql="select * from teacher_info natural join (select * from teacher_apply where '"+sd1+"'<= apply_date and apply_date<='"+sd2+"') applyalias;";
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		try{						
			System.out.println("Transaction has began.");
			List temp=session.createSQLQuery(sql).list();
			System.out.println("temp:"+temp.toString());
			
			//TeacherAppTable table=new TeacherAppTable();   真心不能放循环外啊啊啊
			for(Object meta:temp){
				Object[] rec=(Object[])meta;
				TeacherAppTable table=new TeacherAppTable();
				/*if(rec[2]!=null){
					System.out.println("not null");
					System.out.println(rec[2].toString());//		rec[2] is null ref because 	the word in table is NULL!!!								
					}				
				System.out.println("2 null");
				for(Object word:rec){					
					System.out.println(word.toString());
				}
				for(Object word:rec){					//range for遇到空引用即停
					if(word==null){
						word=new String("null");
					}
				}*/
				for(int i=0;i<rec.length;++i){
					if(rec[i]==null){
						rec[i]=new String("NULL");
					}
				}
				table.setNumber((Integer) rec[0]);				//连接点在0处，然后按序表一属性，表二属性（数据库表序）
				table.setName(rec[2].toString()); 	
				System.out.println(table.getName());				
				table.setGender(rec[4].toString());
				table.setBirth_date(dfmt.parse(rec[5].toString()));
				table.setAddress(rec[6].toString());
				table.setSchool(rec[7].toString());
				table.setMajor(rec[8].toString());
				table.setPhone(rec[9].toString());
				table.setEmail(rec[10].toString());
				table.setQq(rec[11].toString());
				table.setIdentity(rec[14].toString());
				table.setBackground(rec[15].toString());
				table.setSubject(rec[16].toString());
				table.setGrade(rec[17].toString());
				table.setTeach_time(rec[18].toString());
				table.setSelf_introduction(rec[19].toString());
				table.setApply_date(rec[20].toString());
				table.setState(rec[21].toString());
				table.setCount((Integer)rec[22]);
				list.add(table);
			}
		
			tx.commit();
			System.out.println("committed");	
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);
		}
		return list;		//返回类型不能是list，否则宽化！！！
	}	
	
	public List queryApply(String sql){
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
		System.out.println("query applys done");
		return temp;
	}
	
	@Override
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		Session session=sf.getCurrentSession();		
		Transaction tx=session.beginTransaction();
		int rows=0;
		try{						
			System.out.println("Transaction has began.");
			rows=session.createSQLQuery(sql).executeUpdate();
		}catch(Exception ex){
			tx.rollback();
			System.out.println(ex);			
		}
		tx.commit();
		System.out.println("query applys done");
		if(rows>=0){
			return true;
		}else{
			return false;
		}				
	}
}
