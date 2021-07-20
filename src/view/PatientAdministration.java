package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import model.Patient;
import model.User;
import util.StringUtil;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientAdministration extends JInternalFrame {

	private JTable table;
	private JTextField tranNameTextField;
	private JTextField tranRoomTextField;
	private JTextField goOutNameTextField;
	private JTextField gainNameTextField_1;
	private JTextField gainDocTextField_4;
	private JTextField tranBedTextField_2;
	private JTextField gainStartTimeTextField_2;
	private JTextField gainRoomTextField_3;
	private JTextField gainBedTextField_5;
	private JComboBox<String> gainGendarComboBox_1;
	private JComboBox<String> gainStateComboBox_1;
	private JComboBox<String> gainDeptcomboBox;
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
	public PatientAdministration() {
		setResizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("病人管理");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 861, 627);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);

		JLabel lblNewLabel = new JLabel("输入姓名：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		tranNameTextField = new JTextField();
		tranNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		tranNameTextField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("转入的房间号：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("转入的床号：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		tranRoomTextField = new JTextField();
		tranRoomTextField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		tranRoomTextField.setColumns(10);

		JButton btnNewButton_4 = new JButton("重置");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetRRBValue(e);
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("转移病房功能：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyTranAction(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("病人出院：");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		goOutNameTextField = new JTextField();
		goOutNameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		goOutNameTextField.setColumns(10);

		JButton btnNewButton_2 = new JButton("确认");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyDeleteAction(e);
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_6 = new JLabel("病人增加或修改：");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel lblNewLabel_7 = new JLabel("输入姓名：");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainNameTextField_1 = new JTextField();
		gainNameTextField_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		gainNameTextField_1.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("入院时间：");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JLabel lblNewLabel_10 = new JLabel("性别：");
		lblNewLabel_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainGendarComboBox_1 = new JComboBox<String>();
		gainGendarComboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] { "男", "女" }));
		gainGendarComboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_11 = new JLabel("身体状况：");
		lblNewLabel_11.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainStateComboBox_1 = new JComboBox<String>();
		gainStateComboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		gainStateComboBox_1
				.setModel(new DefaultComboBoxModel<String>(new String[] { "良好", "一般", "较差", "重病", "病危", "已死亡" }));

		JLabel lblNewLabel_12 = new JLabel("主治医生：");
		lblNewLabel_12.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainDocTextField_4 = new JTextField();
		gainDocTextField_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		gainDocTextField_4.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("出院病人姓名：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		tranBedTextField_2 = new JTextField();
		tranBedTextField_2.setColumns(10);

		gainStartTimeTextField_2 = new JTextField();
		gainStartTimeTextField_2.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("所属科室：");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainDeptcomboBox = new JComboBox<String>();
		gainDeptcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		gainDeptcomboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "外科", "内科", "妇科", "脑科", "儿科" }));

		JLabel lblNewLabel_13 = new JLabel("房间号：");
		lblNewLabel_13.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainRoomTextField_3 = new JTextField();
		gainRoomTextField_3.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("床位号：");
		lblNewLabel_14.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		gainBedTextField_5 = new JTextField();
		gainBedTextField_5.setColumns(10);

		JButton btnNewButton_1 = new JButton("重置表格");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JButton btnNewButton_3 = new JButton("确定");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyGainAction(e);
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		JButton btnNewButton_5 = new JButton("重置");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGainAction(e);
			}
		});
		btnNewButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblNewLabel_11, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel_7, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
								.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 82,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(gainNameTextField_1, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(gainStateComboBox_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(
												goOutNameTextField, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_12)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(gainDocTextField_4, GroupLayout.PREFERRED_SIZE,
																93, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 80,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(gainRoomTextField_3, GroupLayout.PREFERRED_SIZE,
																76, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 69,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(gainBedTextField_5))
												.addGroup(groupLayout.createSequentialGroup().addGap(8)
														.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(gainGendarComboBox_1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 86,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(gainStartTimeTextField_2,
																GroupLayout.PREFERRED_SIZE, 117,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 88,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(gainDeptcomboBox, GroupLayout.PREFERRED_SIZE, 84,
																GroupLayout.PREFERRED_SIZE))))
										.addGroup(groupLayout.createSequentialGroup().addGap(91).addComponent(
												btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addGap(12).addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
										.addComponent(tranNameTextField, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tranRoomTextField, GroupLayout.PREFERRED_SIZE, 115,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tranBedTextField_2, GroupLayout.PREFERRED_SIZE, 104,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(78)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(78, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(15)
				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tranNameTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tranRoomTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(tranBedTextField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(38).addComponent(lblNewLabel_5).addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(goOutNameTextField, GroupLayout.PREFERRED_SIZE, 21,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2)))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_4).addComponent(btnNewButton))))
				.addGap(32).addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainNameTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10)
						.addComponent(gainGendarComboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainStartTimeTextField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainDeptcomboBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainStateComboBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainDocTextField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainRoomTextField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(gainBedTextField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE).addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout
										.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 191,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_5)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNewButton_1).addGap(82)))));

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u59D3\u540D", "\u6027\u522B", "\u5165\u9662\u65F6\u95F4", "\u6240\u5C5E\u79D1\u5BA4",
						"\u8EAB\u4F53\u72B6\u51B5", "\u4E3B\u6CBB\u533B\u751F", "\u623F\u95F4\u53F7",
						"\u5E8A\u4F4D\u53F7" }));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTable();
	}

	protected void verifyGainAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = gainNameTextField_1.getText().toString();
		String roomString = gainRoomTextField_3.getText().toString();
		String docString = gainDocTextField_4.getText().toString();
		String bedString = gainBedTextField_5.getText().toString();
		String startTimeString = gainStartTimeTextField_2.getText().toString();
		String genderString = (String) gainGendarComboBox_1.getSelectedItem();
		String deptString = (String) gainDeptcomboBox.getSelectedItem();
		String stateString = (String) gainStateComboBox_1.getSelectedItem();
		if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "输入的用户名为空");
			return;
		}
		if ((new PatientDao()).getPatientInformation(roomString, bedString) == null) {
			Patient  patient = new Patient(name, genderString, startTimeString, deptString,
					stateString, docString, roomString, bedString);
			if ((new PatientDao()).getPatientInformation(patient.getName()) == null) {
				(new PatientDao()).gainPatientInformation(patient);
			} else {
				(new PatientDao()).updateOnePatientAllInformation(patient);
			}
			setTable();
			return;
		}
		JOptionPane.showMessageDialog(this, "该床位上已有人，请重新修改");
		gainBedTextField_5.setText("");
		gainRoomTextField_3.setText("");
	}

	protected void resetGainAction(ActionEvent e) {
		// TODO Auto-generated method stub
		gainBedTextField_5.setText("");
		gainDocTextField_4.setText("");
		gainNameTextField_1.setText("");
		gainRoomTextField_3.setText("");
		gainStartTimeTextField_2.setText("");
		gainGendarComboBox_1.setSelectedIndex(0);
		gainStateComboBox_1.setSelectedIndex(0);
		gainDeptcomboBox.setSelectedIndex(0);
	}

	protected void verifyDeleteAction(ActionEvent e) {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(goOutNameTextField.getText().toString())) {
			JOptionPane.showMessageDialog(this, "输入的用户名为空");
			return;
		}
		if ((new PatientDao()).getPatientInformation(goOutNameTextField.getText().toString()) == null) {
			JOptionPane.showMessageDialog(this, "您输入的用户名不存在");
			return;
		}
		(new PatientDao()).deletePatientInformation(goOutNameTextField.getText().toString());
		resetTable(e);
		goOutNameTextField.setText("");
	}

	protected void resetTable(ActionEvent e) {
		// TODO Auto-generated method stub
		setTable();
	}

	protected void verifyTranAction(ActionEvent e) {
		// TODO Auto-generated method stub
		if (StringUtil.isEmpty(tranNameTextField.getText().toString())) {
			JOptionPane.showMessageDialog(this, "输入的姓名为空");
			return;
		}
		if (StringUtil.isEmpty(tranRoomTextField.getText().toString())
				|| StringUtil.isEmpty(tranBedTextField_2.getText().toString())) {
			JOptionPane.showMessageDialog(this, "输入的房间号或床位号为空");
			return;
		}
		// System.out.println(user + "+++" + user.getDuty());
		// if (PermissionUtil.isHavePermission(user.getDuty().trim(), "副主任")) {

		Patient patient = (new PatientDao()).getPatientInformation(tranNameTextField.getText().toString());
		if (patient == null) {
			JOptionPane.showMessageDialog(this, "该病人不存在");
			resetRRBValue(e);
		} else {
			Patient patient2 = (new PatientDao()).getPatientInformation(tranRoomTextField.getText().toString(),
					tranBedTextField_2.getText().toString());
			if (patient2 == null) {
				patient.setRoom(tranRoomTextField.getText().toString());
				patient.setBed(tranBedTextField_2.getText().toString());
				(new PatientDao()).updatePatientRBInformation(patient);
				setTable();
				resetRRBValue(e);
				JOptionPane.showMessageDialog(this, "移入该病房成功");
			} else {
				JOptionPane.showMessageDialog(this, "您要移入的床位上已经有人了");
				resetRRBValue(e);
			}
		}
		/*
		 * return; } JOptionPane.showMessageDialog(this, "您没有权限进行此项操作");
		 * resetRRBValue(e);
		 */
	}

	protected void resetRRBValue(ActionEvent e) {
		// TODO Auto-generated method stub
		tranRoomTextField.setText("");
		tranBedTextField_2.setText("");
		tranNameTextField.setText("");

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
