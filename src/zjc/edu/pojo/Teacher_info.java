package zjc.edu.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher_info {
	private Integer number;
	private String nickname;
	private String name;
	private String id_number;
	private String identity;
	private String gender;
	private Date birth_date;
	private String address;
	private String school;
	private String major;
	private String background;
	private String phone;
	private String email;
	private String qq;
	private String password;
	private Date register_date;

	public Teacher_info(){}
	
	public void setNumber(Integer number){
		this.number=number;
	}
	public Integer getNumber(){
		return number;
	}	
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	public String getNickname(){
		return nickname;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId_number(String id_number){
		this.id_number=id_number;
	}
	public String getId_number(){
		return id_number;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setBirth_date(Date birth_date){
		this.birth_date=birth_date;
	}
	public void setBirth_date(String birth_date){
		SimpleDateFormat dfmt=new SimpleDateFormat("yyyy/MM/dd");
		try {
			this.birth_date=dfmt.parse(birth_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getBirth_date(){
		return birth_date;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setSchool(String school){
		this.school=school;
	}
	public String getSchool(){
		return school;
	}
	public void setMajor(String major){
		this.major=major;
	}
	public String getMajor(){
		return major;
	}
	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setQq(String qq){
		this.qq=qq;
	}
	public String getQq(){
		return qq;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setRegister_date(Date register_date){
		this.register_date=register_date;
	}
	public Date getRegister_date(){
		return register_date;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}
