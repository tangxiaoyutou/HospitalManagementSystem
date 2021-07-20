package view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import model.User;
import util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterPassword extends JInternalFrame {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { AlterPassword frame = new
	 * AlterPassword(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public AlterPassword() {
		setTitle("修改密码");
		setClosable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMaximizable(true);
		setBounds(100, 100, 880, 500);
		
		JLabel lblNewLabel = new JLabel("输入新密码：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("再次输入新密码：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		passwordField_1 = new JPasswordField();
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyACtion(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAction(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(329, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addComponent(lblNewLabel_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(50)
									.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(159)
							.addComponent(btnNewButton_1)))
					.addContainerGap(289, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void verifyACtion(ActionEvent e) {
		// TODO Auto-generated method stub
		User user = ViewFunctionSelection.user;
		String password1 = String.valueOf(passwordField.getPassword());
		String password2 = String.valueOf(passwordField_1.getPassword());
		if(StringUtil.isEmpty(password1) || StringUtil.isEmpty(password2)) {
			JOptionPane.showMessageDialog(this, "请两次输入相同的密码");
		} else if(password1.equals(password2) ) {
			user.setPassword(password2);
			(new UserDao()).updatePassword(user);
			JOptionPane.showMessageDialog(this, "密码修改成功");
			resetAction(e);
		} else {
			JOptionPane.showMessageDialog(this, "俩次密码输入不一致");
		}
	}

	protected void resetAction(ActionEvent e) {
		// TODO Auto-generated method stub
		passwordField.setText("");
		passwordField_1.setText("");
	}
}
