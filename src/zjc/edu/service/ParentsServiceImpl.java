package zjc.edu.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zjc.edu.dao.AnythingDAO;
import zjc.edu.pojo.ParentsAppTable;
import zjc.edu.pojo.Parents_apply;
import zjc.edu.pojo.Parents_info;
import zjc.edu.pojo.TeacherAppTable;

public class ParentsServiceImpl implements ParentsService {
	private AnythingDAO parentsInfoDao,parentsApplyDao;
	
	public AnythingDAO getParentsInfoDao() {
		return parentsInfoDao;
	}

	public void setParentsInfoDao(AnythingDAO parentsInfoDao) {
		this.parentsInfoDao = parentsInfoDao;
	}
	
	public AnythingDAO getParentsApplyDao() {
		return parentsApplyDao;
	}

	public void setParentsApplyDao(AnythingDAO parentsApplyDao) {
		this.parentsApplyDao = parentsApplyDao;
	}
		
	
	public Integer addApply(Parents_apply obj){
		return parentsApplyDao.insert(obj);
	}
	
	@Override
	public Integer addRecord(Parents_info parents_info) {
		// TODO Auto-generated method stub
		return parentsInfoDao.insert(parents_info);
	}

	@Override
	public boolean checkExist(String sql) {
		// TODO Auto-generated method stub
		List li=parentsInfoDao.query(sql);
		if(li==null)return false;
		return li.size()!=0?true:false;
	}

	@Override
	public boolean editPersonalInfo(String sql) {
		// TODO Auto-generated method stub
		return parentsInfoDao.update(sql); 
	}
	
	public boolean setApplyState(String sql){
		return parentsApplyDao.update(sql);
	}
	
	public Parents_info getPersonalInfo(String sql){		//返回类型是接口方法的子类型也是可以得
		List li=parentsInfoDao.query(sql);		
		if(li==null) return null;		
		if(!li.isEmpty()){
			Object[] info=(Object[])li.get(0);			
			SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");	
			String sd=sdft.format((Date)info[10]);			
			Parents_info parents_info=new Parents_info();
			parents_info.setNickname((String)info[1]);
			parents_info.setNumber((Integer)info[0]);
			parents_info.setName((String)info[2]);
			parents_info.setGender((String)info[4]);			
			parents_info.setAddress((String)info[5]);
			parents_info.setPhone((String)info[6]);
			parents_info.setQq((String)info[8]);
			parents_info.setEmail((String)info[7]);
			parents_info.setRegister_date(sd);		//10是Date类型，因为是createSqlQuery
			return parents_info;
		}else{
			return null;
		}
	}	

	@Override
	public List<ParentsAppTable> queryPBy(String sql) {			//查询家长申请
		// TODO Auto-generated method stub
		List<ParentsAppTable> pList=new ArrayList<ParentsAppTable>();
		//SimpleDateFormat dfmt=new SimpleDateFormat("yyyy-MM-dd");  //mm is wrong
		List temp=parentsApplyDao.query(sql);
		for(Object meta:temp){
			Object[] rec=(Object[])meta;
			ParentsAppTable table=new ParentsAppTable();
			for(int i=0;i<rec.length;++i){
				if(rec[i]==null){
					rec[i]=new String("NULL");
				}
			}
			table.setNumber((Integer) rec[0]);				
			table.setName(rec[2].toString()); 	
			System.out.println(table.getName());
			table.setId_number(rec[3].toString());
			table.setGender(rec[4].toString());
			table.setAddress(rec[5].toString());
			table.setPhone(rec[6].toString());
			table.setEmail(rec[7].toString());
			table.setQq(rec[8].toString());
			table.setChildName(rec[11].toString());
			table.setChildGender(rec[12].toString());
			table.setSubject(rec[14].toString());
			table.setGrade(rec[13].toString());
			table.setTeacherGender(rec[15].toString());
			table.setTeach_time(rec[16].toString());
			table.setRequest(rec[17].toString());
			table.setApply_date(rec[18].toString());
			table.setCount((Integer)rec[19]);
			table.setState(rec[20].toString());
			pList.add(table);
		}						
		return pList;
	}
	
	
}
