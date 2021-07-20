package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import dao.UserDao;
import model.Patient;
import model.User;
import util.StringUtil;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffAllInformation extends JInternalFrame {
	private JTextField nameTextField;
	private JTable table;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { StaffInformation frame = new
	 * StaffInformation(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */

	public StaffAllInformation() {
		setTitle("员工信息查询");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 923, 526);
		JLabel lblNewLabel = new JLabel("员工姓名：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));

		nameTextField = new JTextField();
		nameTextField.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referAction(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton_1 = new JButton("重置表格");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGap(140)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGap(149)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 878, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(23, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(46)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton).addComponent(btnNewButton_1))
				.addGap(48).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(84, Short.MAX_VALUE)));

		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5458\u5DE5\u53F7", "\u59D3\u540D", "部门", "\u5B66\u5386",
						"\u804C\u52A1", "\u6027\u522B", "\u751F\u65E5", "\u7C4D\u8D2F", "\u56FD\u7C4D", "\u6C11\u65CF",
						"\u8EAB\u4EFD\u8BC1\u53F7", "\u5A5A\u59FB\u72B6\u51B5", "\u5065\u5EB7\u72B6\u51B5",
						"\u53C2\u52A0\u5DE5\u4F5C\u65F6\u95F4", "\u5458\u5DE5\u72B6\u6001", "\u5BB6\u5EAD\u4F4F\u5740",
						"\u8054\u7CFB\u7535\u8BDD", "eMail", "\u5DE5\u4F5C\u5C97\u4F4D\u4EE3\u53F7" }) {

			Class[] columnTypes = new Class[] { String.class, String.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

		});
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTable();
	}

	protected void resetTable(ActionEvent e) {
		// TODO Auto-generated method stub
		setTable();
	}

	protected void referAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameString = nameTextField.getText().toString();
		if (StringUtil.isEmpty(nameString)) {
			JOptionPane.showMessageDialog(this, "输入的姓名为空");
			return;
		}
		List<User> userList = (new UserDao()).getSomeUserInformation(nameString);
		if (userList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "此人不是公司成员");
			nameTextField.setText("");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		for (User user : userList) {
			Vector<String> vector = new Vector<>();
			vector.add(user.getId());
			vector.add(user.getName());
			vector.add((new UserDao()).referDeptNameDept(user.getDeptId()));
			vector.add(user.getDuty());
			vector.add(user.getEduBaXl());
			vector.add(user.getGender());
			vector.add(user.getBirthdayString());
			vector.add(user.getHomeAddressString());
			vector.add(user.getCountryString());
			vector.add(user.getNationString());
			vector.add(user.getCitizenId());
			vector.add(user.getMarriage());
			vector.add(user.getHealthString());
			vector.add(user.getStartWorkString());
			vector.add(user.getStateString());
			vector.add(user.getHomeAddressString());
			vector.add(user.getTeleNoString());
			vector.add(user.geteMailString());
			vector.add(user.getJobIdString());
			dft.addRow(vector);
		}
		nameTextField.setText("");

	}

	private void setTable() {
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		List<User> userList = (new UserDao()).getAllUserInformation();
		for (User user : userList) {
			Vector<String> vector = new Vector<>();
			vector.add(user.getId());
			vector.add(user.getName());
			vector.add((new UserDao()).referDeptNameDept(user.getDeptId()));
			vector.add(user.getDuty());
			vector.add(user.getEduBaXl());
			vector.add(user.getGender());
			vector.add(user.getBirthdayString());
			vector.add(user.getHomeAddressString());
			vector.add(user.getCountryString());
			vector.add(user.getNationString());
			vector.add(user.getCitizenId());
			vector.add(user.getMarriage());
			vector.add(user.getHealthString());
			vector.add(user.getStartWorkString());
			vector.add(user.getStateString());
			vector.add(user.getHomeAddressString());
			vector.add(user.getTeleNoString());
			vector.add(user.geteMailString());
			vector.add(user.getJobIdString());
			dft.addRow(vector);
		}
	}
}
