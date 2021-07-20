package model;

public class Patient {
	private String name;
	private String gender;
	private String dataStart;
	private String dept;
	private String state;
	private String doc;
	private String room;
	private String bed;
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public Patient(String name2, String genderString, String startTimeString, String deptString, String stateString,
			String docString, String roomString, String bedString) {
		// TODO Auto-generated constructor stub
		name = name2;
		gender = genderString;
		dataStart = startTimeString;
		dept = deptString;
		state = stateString;
		doc = docString;
		room = roomString;
		bed = bedString;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataStart() {
		return dataStart;
	}
	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString() {
		return getName() + getGender() + getDept() + "入院时间" + getDataStart() + "主治医师" + getDoc();
	}
	
}
