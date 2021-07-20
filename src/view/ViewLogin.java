package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UserDao;
import model.*;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import util.StringUtil;
import util.UserUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin<getDefaultToolkit> {

	private JFrame frame;
	private JTextField userIDtextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();

		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLogin.class.getResource("/image/image1.jpg")));
		getFrame().setFont(new Font("微软雅黑", Font.BOLD, 14));
		getFrame().setBounds(100, 100, 882, 564);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("医院管理系统");
		lblNewLabel.setIcon(new ImageIcon(ViewLogin.class.getResource("/image/医院.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(getFrame());
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));

		JLabel lblNewLabel_1 = new JLabel("用户ID：");
		lblNewLabel_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/image/姓名 用户名 昵称.png")));
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel("密   码：");
		lblNewLabel_2.setIcon(new ImageIcon(ViewLogin.class.getResource("/image/密码.png")));
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));

		userIDtextField = new JTextField();
		userIDtextField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		userIDtextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("\u5FAE\u8F6F\u96C5\u9ED1", passwordField.getFont().getStyle(), 12));

		JButton loginbtnNewButton = new JButton("登录");
		loginbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAction(e);
			}
		});
		loginbtnNewButton.setIcon(new ImageIcon(ViewLogin.class.getResource("/image/登录.png")));
		loginbtnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JButton resetbtnNewButton_1 = new JButton("重置");
		resetbtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetbtnNewButton_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/image/重置.png")));
		resetbtnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("tips.首次登录用户密码为12345");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(getFrame().getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap(242, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127,
												Short.MAX_VALUE))
								.addComponent(loginbtnNewButton))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(84).addComponent(resetbtnNewButton_1,
												GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(59)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 158,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(userIDtextField, GroupLayout.PREFERRED_SIZE, 158,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(224))
						.addGroup(groupLayout.createSequentialGroup().addGap(183).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(58, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(514, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(48).addComponent(lblNewLabel).addGap(58)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(userIDtextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(32)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(65)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetbtnNewButton_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(loginbtnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
				.addGap(91).addComponent(lblNewLabel_3).addContainerGap(66, Short.MAX_VALUE)));
		getFrame().getContentPane().setLayout(groupLayout);
	}

	protected void loginAction(ActionEvent e) {
		// TODO Auto-generated method stub
		// hms 登陆操作
		String userId = userIDtextField.getText().toString();
		String passWord = String.valueOf(passwordField.getPassword());
		if (StringUtil.isEmpty(userId) || StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(getFrame(), "用户ID或密码为空！");
			return;
		}
		User user = (new UserDao()).getUserInformation(userId);
		if ((new UserDao()).isHavePassword(userId) == false) {
			user.setPassword("12345");
			(new UserDao()).insertUsersIdPssword(user);
		}
		if (UserUtil.isUser(userId, passWord)) {
			// 跳转页面
			JOptionPane.showMessageDialog(getFrame(),
					"密码正确，登录成功，欢迎" + StringUtil.changeNull((new UserDao()).referDeptNameDept(user.getDeptId()))
							+ user.getName().trim() + user.getDuty().trim());
			ViewFunctionSelection fram = new ViewFunctionSelection(UserUtil.beUser(userId, passWord), frame);
			fram.setVisible(true);
			frame.setVisible(false);
			return;
		}
		JOptionPane.showMessageDialog(getFrame(), "用户ID或密码输入错误，请重新输入！");
		resetValue(e);
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		userIDtextField.setText("");
		passwordField.setText("");
	}
}
