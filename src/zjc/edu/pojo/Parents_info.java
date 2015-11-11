package zjc.edu.pojo;

public class Parents_info {
	private Integer number;
	private String nickname;
	private String name;
	private String id_number;	
	private String gender;	
	private String address;	
	private String phone;
	private String email;
	private String qq;
	private String password;
	private String register_date;		//以string映射数据库date类型完全可以
	
	public Parents_info(){}
	
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
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
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
	public void setRegister_date(String register_date){
		this.register_date=register_date;
	}
	public String getRegister_date(){
		return register_date;
	}
}
