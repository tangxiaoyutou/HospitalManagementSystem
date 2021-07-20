package model;

import dao.UserDao;

public class User {
	private String id;
	private String password;
	private String name;
	private String deptId;
	private String duty;
	private String eduBaXl;
	private String gender;
	private String birthdayString;
	private String homeString;
	private String countryString;
	private String nationString;
	private String citizenId;
	private String marriage;
	private String healthString;
	private String startWorkString;
	private String stateString;
	private String homeAddressString;
	private String teleNoString;
	private String eMailString;
	private String jobIdString;

	public User(String idString, String nameString, String birthdayString2, String hometown, String cIdString,
			String addressString, String teleString, String eMailString2, String genderString, String referDeptIdDept,
			String dutyString, String xlString, String stateString2, String healthString2, String countryString2,
			String nationString2, String marrigeString, String startWorkString2) {
		this.id = idString;
		this.name = nameString;
		this.deptId = referDeptIdDept;
		this.duty = dutyString;
		this.eduBaXl = xlString;
		this.gender = genderString;
		this.birthdayString = birthdayString2;
		this.homeString = hometown;
		this.countryString = countryString2;
		this.nationString = nationString2;
		this.citizenId = cIdString;
		this.marriage = marrigeString;
		this.healthString = healthString2;
		this.startWorkString = startWorkString2;
		this.stateString = stateString2;
		this.homeAddressString = addressString;
		this.teleNoString = teleString;
		this.eMailString = eMailString2;
		this.jobIdString = (new UserDao()).referJobIdDept(dutyString);
		
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getHealthString() {
		return healthString;
	}

	public void setHealthString(String healthString) {
		this.healthString = healthString;
	}

	public String getStartWorkString() {
		return startWorkString;
	}

	public void setStartWorkString(String startWorkString) {
		this.startWorkString = startWorkString;
	}

	public String getStateString() {
		return stateString;
	}

	public void setStateString(String stateString) {
		this.stateString = stateString;
	}

	public String getHomeAddressString() {
		return homeAddressString;
	}

	public void setHomeAddressString(String homeAddressString) {
		this.homeAddressString = homeAddressString;
	}

	public String getTeleNoString() {
		return teleNoString;
	}

	public void setTeleNoString(String teleNoString) {
		this.teleNoString = teleNoString;
	}

	public String geteMailString() {
		return eMailString;
	}

	public void seteMailString(String eMailString) {
		this.eMailString = eMailString;
	}

	public String getJobIdString() {
		return jobIdString;
	}

	public void setJobIdString(String jobIdString) {
		this.jobIdString = jobIdString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getEduBaXl() {
		return eduBaXl;
	}

	public void setEduBaXl(String eduBaXl) {
		this.eduBaXl = eduBaXl;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
	}

	public String getHomeString() {
		return homeString;
	}

	public void setHomeString(String homeString) {
		this.homeString = homeString;
	}

	public String getCountryString() {
		return countryString;
	}

	public void setCountryString(String countryString) {
		this.countryString = countryString;
	}

	public String getNationString() {
		return nationString;
	}

	public void setNationString(String nationString) {
		this.nationString = nationString;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public boolean equals(User ad) {
		if (this.id.equals(ad.id) && this.password.equals(ad.password) && this.citizenId.equals(ad.citizenId))
			return true;
		return false;
	}

	public String toString() {
		return id + "+" + password ;
	}
}
