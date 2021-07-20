package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.UserDao;
import model.User;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffInformation extends JInternalFrame {
	private JTextField nameTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffInformation frame = new StaffInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffInformation() {
		setTitle("员工信息查询");
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 932, 443);
		
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
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("重置表格");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(115)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5458\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u90E8\u95E8", "\u804C\u52A1", "\u8054\u7CFB\u7535\u8BDD", "eMail"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
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
		if(StringUtil.isEmpty(nameString)) {
			JOptionPane.showMessageDialog(this, "输入的姓名为空");
			return ;
		}
		List<User> userList = (new UserDao()).getSomeUserInformation(nameString);
		if(userList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "此人不是公司成员");
			nameTextField.setText("");
			return ;
		}
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		for (User user : userList) {
			Vector<String> vector = new Vector<>();
			vector.add(user.getId());
			vector.add(user.getName());
			vector.add(user.getGender());
			vector.add((new UserDao()).referDeptNameDept(user.getDeptId()));
			vector.add(user.getDuty());
			vector.add(user.getBirthdayString());
			vector.add(user.getTeleNoString());
			vector.add(user.geteMailString());
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
			vector.add(user.getGender());
			vector.add((new UserDao()).referDeptNameDept(user.getDeptId()));
			vector.add(user.getDuty());
			vector.add(user.getBirthdayString());
			vector.add(user.getTeleNoString());
			vector.add(user.geteMailString());
			dft.addRow(vector);
		}
	}
}
