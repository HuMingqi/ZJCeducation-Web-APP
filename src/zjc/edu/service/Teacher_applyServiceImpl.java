package zjc.edu.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zjc.edu.dao.Teacher_applyDAO;
import zjc.edu.pojo.TeacherAppTable;
import zjc.edu.pojo.Teacher_apply;

public class Teacher_applyServiceImpl implements Teacher_applyService {
	private Teacher_applyDAO teacher_applyDAO;
	public Teacher_applyDAO getTeacher_applyDAO(){
		return teacher_applyDAO;
	}
	public void setTeacher_applyDao(Teacher_applyDAO teacher_applyDAO){
		this.teacher_applyDAO=teacher_applyDAO;
	}
	public boolean insertTeacher_apply(Teacher_apply teacher_apply) {			
		return 	teacher_applyDAO.insertTeacher_apply(teacher_apply);	
	}
	@Override
	public List<TeacherAppTable> readRange(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return teacher_applyDAO.readRange(d1, d2);		
	}
	@Override
	public List<TeacherAppTable> queryTBy(String sql) {		
		List<TeacherAppTable> tList=new ArrayList<TeacherAppTable>();
		//SimpleDateFormat dfmt=new SimpleDateFormat("yyyy-MM-dd");  //mm is wrong
		List temp=teacher_applyDAO.queryApply(sql);
		if(temp==null)System.out.println("temp is null");
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
					System.out.println(i);
				}
			}
			table.setNumber((Integer) rec[0]);				
			table.setName(rec[2].toString()); 	
			System.out.println(table.getName());					
			table.setGender(rec[4].toString());
			table.setBirth_date((Date)rec[5]);
			table.setAddress(rec[6].toString());
			table.setSchool(rec[7].toString());
			table.setMajor(rec[8].toString());
			table.setPhone(rec[9].toString());
			table.setEmail(rec[10].toString());
			table.setQq(rec[11].toString());
			System.out.println(table.getQq());
			table.setIdentity(rec[14].toString());
			System.out.println(table.getIdentity());
			table.setBackground(rec[15].toString());
			System.out.println(table.getBackground());
			table.setSubject(rec[16].toString());
			System.out.println(table.getSubject());
			table.setGrade(rec[17].toString());
			System.out.println(table.getGrade());
			table.setTeach_time(rec[18].toString());
			System.out.println(table.getTeach_time());
			table.setSelf_introduction(rec[19].toString());
			System.out.println(table.getSelf_introduction());
			table.setApply_date(rec[20].toString());
			System.out.println(table.getApply_date());
			table.setState(rec[21].toString());						//真相是 自然连接新表的 模式 共同列+表一+表二，重合的属性值被删但列保留！！
			System.out.println(table.getState());
			table.setCount((Integer)rec[22]);
			tList.add(table);
		}
		System.out.println("return List<TeacherAppTable>");
		return tList;
	}
	@Override
	public boolean setState(String sql) {
		// TODO Auto-generated method stub
		return teacher_applyDAO.update(sql);	
	}	
}
