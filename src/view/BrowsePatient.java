package view;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import model.Patient;
import util.StringUtil;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BrowsePatient extends JInternalFrame {
	private JTable table;
	private JTextField referTextField;
	private JTextField RoomTextField;
	private JTextField BedTextField_1;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { BrowsePatient frame = new
	 * BrowsePatient(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public BrowsePatient() {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("查询病人信息");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 817, 568);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("输入姓名：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		referTextField = new JTextField();
		referTextField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referAction(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("重置表格");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetName(e);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("输入房间号：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("输入床号：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		RoomTextField = new JTextField();
		RoomTextField.setColumns(10);

		BedTextField_1 = new JTextField();
		BedTextField_1.setColumns(10);

		JButton btnNewButton_3 = new JButton("查询");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyAction(e);
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton btnNewButton_4 = new JButton("重置");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRBValue(e);
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(BedTextField_1)
						.addComponent(RoomTextField)
						.addComponent(referTextField, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(43))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(referTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(RoomTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_3)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addComponent(BedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(41))
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u59D3\u540D", "\u6027\u522B", "\u5165\u9662\u65F6\u95F4", "\u6240\u5C5E\u79D1\u5BA4",
						"\u8EAB\u4F53\u72B6\u51B5", "\u4E3B\u6CBB\u533B\u751F", "\u623F\u95F4\u53F7",
						"\u5E8A\u4F4D\u53F7" }));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTable();
	}

	protected void resetName(ActionEvent e) {
		// TODO Auto-generated method stub
		referTextField.setText("");
	}

	protected void resetRBValue(ActionEvent e) {
		// TODO Auto-generated method stub
		RoomTextField.setText("");
		BedTextField_1.setText("");

	}

	protected void verifyAction(ActionEvent e) {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(RoomTextField.getText().toString())
				|| StringUtil.isEmpty(BedTextField_1.getText().toString()))
			JOptionPane.showMessageDialog(this, "房间号或床号为空");
		Patient patient = (new PatientDao()).getPatientInformation(RoomTextField.getText().toString(),
				BedTextField_1.getText().toString());
		if (patient == null) {
			JOptionPane.showMessageDialog(this, "此床位无人");
			return;
		}
		setOneTable(patient);
	}

	private void setOneTable(Patient p) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		Vector<String> vector = new Vector<>();
		vector.add(p.getName());
		vector.add(p.getGender());
		vector.add(p.getDataStart());
		vector.add(p.getDept());
		vector.add(p.getState());
		vector.add(p.getDoc());
		vector.add(p.getRoom());
		vector.add(p.getBed());
		dft.addRow(vector);
	}

	protected void resetTable(ActionEvent e) {
		// TODO Auto-generated method stub
		setTable();
	}

	protected void referAction(ActionEvent e) {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(referTextField.getText().toString())) {
			JOptionPane.showMessageDialog(this, "输入的姓名为空");
			return;
		}
		List<Patient> patientList;
		patientList = (new PatientDao()).getSomePatientInformation(referTextField.getText().toString());
		if (patientList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "输入的病人姓名不存在");
			return;
		}
		setSomebodyTable(patientList);
	}

	private void setSomebodyTable(List<Patient> patientList) {
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		for (Patient p : patientList) {
			Vector<String> vector = new Vector<>();
			vector.add(p.getName());
			vector.add(p.getGender());
			vector.add(p.getDataStart());
			vector.add(p.getDept());
			vector.add(p.getState());
			vector.add(p.getDoc());
			vector.add(p.getRoom());
			vector.add(p.getBed());
			dft.addRow(vector);
		}
	}

	private void setTable() {
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		List<Patient> patientList = (new PatientDao()).getAllPatientInformation();
		for (Patient p : patientList) {
			Vector<String> vector = new Vector<>();
			vector.add(p.getName());
			vector.add(p.getGender());
			vector.add(p.getDataStart());
			vector.add(p.getDept());
			vector.add(p.getState());
			vector.add(p.getDoc());
			vector.add(p.getRoom());
			vector.add(p.getBed());
			dft.addRow(vector);
		}
	}
}
