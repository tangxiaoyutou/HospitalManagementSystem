package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

public class PatientDao extends Database {

	public void deletePatientInformation(String name) {
		String sql = "delete from PATIENT where PATIENT_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);

			pStatement.execute();
			// System.out.println(patient.getRoom() + patient.getBed() + patient.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Patient> getAllPatientInformation() {
		List<Patient> patientList = new ArrayList<>();
		try {
			String sql = "select * from PATIENT";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			ResultSet executeQuery = prStatement.executeQuery();
			while (executeQuery.next()) {
				Patient patient = new Patient();
				patient.setName(executeQuery.getString(1));
				patient.setGender(executeQuery.getString(2));
				patient.setDataStart(executeQuery.getString(3));
				patient.setDept(executeQuery.getString(4));
				patient.setState(executeQuery.getString(5));
				patient.setDoc(executeQuery.getString(6));
				patient.setRoom(executeQuery.getString(7));
				patient.setBed(executeQuery.getString(8));
				patientList.add(patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientList;
	}

	public Patient getPatientInformation(String name) {
		Patient patient = null;
		try {
			String sql = "select * from PATIENT where PATIENT_NAME = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, name);
			ResultSet executeQuery = prStatement.executeQuery();
			if (executeQuery.next()) {
				patient = new Patient();
				patient.setName(executeQuery.getString(1));
				patient.setGender(executeQuery.getString(2));
				patient.setDataStart(executeQuery.getString(3));
				patient.setDept(executeQuery.getString(4));
				patient.setState(executeQuery.getString(5));
				patient.setDoc(executeQuery.getString(6));
				patient.setRoom(executeQuery.getString(7));
				patient.setBed(executeQuery.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient;
	}

	public Patient getPatientInformation(String room, String bed) {
		Patient patient = null;
		try {
			String sql = "select * from PATIENT where PATIENT_ROOM = ? and PATIENT_BED = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, room);
			prStatement.setString(2, bed);
			ResultSet executeQuery = prStatement.executeQuery();
			if (executeQuery.next()) {
				patient = new Patient();
				patient.setName(executeQuery.getString(1));
				patient.setGender(executeQuery.getString(2));
				patient.setDataStart(executeQuery.getString(3));
				patient.setDept(executeQuery.getString(4));
				patient.setState(executeQuery.getString(5));
				patient.setDoc(executeQuery.getString(6));
				patient.setRoom(executeQuery.getString(7));
				patient.setBed(executeQuery.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patient;
	}

	public List<Patient> getSomePatientInformation(String name) {
		List<Patient> patientList = new ArrayList<>();
		try {
			String sql = "select * from PATIENT where PATIENT_NAME = ?";
			PreparedStatement prStatement = connection.prepareStatement(sql);
			prStatement.setString(1, name);
			ResultSet executeQuery = prStatement.executeQuery();
			while (executeQuery.next()) {
				Patient patient = new Patient();
				patient.setName(executeQuery.getString(1));
				patient.setGender(executeQuery.getString(2));
				patient.setDataStart(executeQuery.getString(3));
				patient.setDept(executeQuery.getString(4));
				patient.setState(executeQuery.getString(5));
				patient.setDoc(executeQuery.getString(6));
				patient.setRoom(executeQuery.getString(7));
				patient.setBed(executeQuery.getString(8));
				patientList.add(patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientList;
	}

	public void updatePatientRBInformation(Patient patient) {
		String sql = "update PATIENT set PATIENT_ROOM = ?, PATIENT_BED = ? where PATIENT_NAME = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, patient.getRoom());
			pStatement.setString(2, patient.getBed());
			pStatement.setString(3, patient.getName().trim());
			pStatement.execute();
			// System.out.println(patient.getRoom() + patient.getBed() + patient.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOnePatientAllInformation(Patient patient) {
		String sql = "update PATIENT set PATIENT_GENDER = ?,  PATIENT_DATE_START = ?, PATIENT_DEPT = ?, "
				+ "PATIENT_STATE = ?, PATIENT_DOC = ?, PATIENT_ROOM = ?, PATIENT_BED = ? where PATIENT_NAME";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, patient.getGender());
			pStatement.setString(2, patient.getDataStart());
			pStatement.setString(3, patient.getState());
			pStatement.setString(3, patient.getDoc());
			pStatement.setString(3, patient.getRoom());
			pStatement.setString(3, patient.getBed());
			pStatement.execute();
			// System.out.println(patient.getRoom() + patient.getBed() + patient.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gainPatientInformation(Patient p) {
		String sql = "insert into PATIENT(PATIENT_NAME, PATIENT_GENDER, PATIENT_DATE_START, PATIENT_DEPT, PATIENT_STATE, PATIENT_DOC,"
				+ " PATIENT_ROOM, PATIENT_BED) values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, p.getName());
			pStatement.setString(2, p.getGender());
			pStatement.setString(3, p.getDataStart());
			pStatement.setString(4, p.getDept());
			pStatement.setString(5, p.getState());
			pStatement.setString(6, p.getDoc());
			pStatement.setString(7, p.getRoom());
			pStatement.setString(8, p.getBed());
			pStatement.execute();
			// System.out.println(patient.getRoom() + patient.getBed() + patient.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
