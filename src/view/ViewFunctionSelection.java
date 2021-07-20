package view;

import javax.swing.JFrame;
import dao.UserDao;
import model.User;
import util.PermissionUtil;

import java.awt.Font;
import java.awt.Frame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class ViewFunctionSelection extends JFrame {

	/**
	 * Launch the application.
	 */
	public static User user;
	public Frame fram;
	private JDesktopPane JDesktopPane;
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { User user = new User(); Frame f = new
	 * ViewLogin().getFrame(); ViewFunctionSelection frame = new
	 * ViewFunctionSelection(user, f); frame.setVisible(true); } catch (Exception e)
	 * { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */

	public ViewFunctionSelection(User u, Frame fram) {
		setTitle("医院管理系统");

		setBackground(UIManager.getColor("CheckBox.background"));
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		user = u;
		this.fram = fram;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 603);
		UserDao userDao = new UserDao();
		// System.out.println(user);
//		if (user != null && user.getId() != 0) {
		user = userDao.referUserPersonalInformation(u);
		// System.out.println("vf:"+this.user.getDuty() + ".." +user.getDuty());
		getContentPane().setLayout(new BorderLayout(0, 0));

		JDesktopPane = new JDesktopPane();

		getContentPane().add(JDesktopPane, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("重新登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartlogin(e);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GroupLayout gl_JDesktopPane = new GroupLayout(JDesktopPane);
		gl_JDesktopPane.setHorizontalGroup(gl_JDesktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_JDesktopPane.createSequentialGroup().addContainerGap(680, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGap(69)));
		gl_JDesktopPane
				.setVerticalGroup(gl_JDesktopPane.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_JDesktopPane.createSequentialGroup().addGap(299)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(325, Short.MAX_VALUE)));
		JDesktopPane.setLayout(gl_JDesktopPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Menu.selectionForeground"));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("住院部");
		mnNewMenu.setBackground(UIManager.getColor("Menu.selectionForeground"));
		mnNewMenu.setIcon(new ImageIcon(ViewFunctionSelection.class.getResource("/image/住院部.png")));
		mnNewMenu.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("病人查询");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browsePatientAction(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("病人管理");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPatientAdmindtrationView(e);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("员工管理");
		mnNewMenu_1.setBackground(UIManager.getColor("Menu.selectionForeground"));
		mnNewMenu_1.setIcon(new ImageIcon(ViewFunctionSelection.class.getResource("/image/员工管理.png")));
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("员工浏览详细");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browseStaffInformation(e);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem = new JMenuItem("人事调动");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tranAction(e);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("员工浏览简略");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browsePatientSomeInformation(e);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnNewMenu_2 = new JMenu("门诊部");
		mnNewMenu_2.setBackground(UIManager.getColor("Menu.selectionForeground"));
		mnNewMenu_2.setIcon(new ImageIcon(ViewFunctionSelection.class.getResource("/image/门诊部.png")));
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);

		JMenu mnNewMenu_3 = new JMenu("物资管理");
		mnNewMenu_3.setBackground(UIManager.getColor("Menu.selectionForeground"));
		mnNewMenu_3.setIcon(new ImageIcon(ViewFunctionSelection.class.getResource("/image/img_仪器管理.png")));
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);

		JMenu mnNewMenu_4 = new JMenu("");
		menuBar.add(mnNewMenu_4);

		JMenu mnNewMenu_5 = new JMenu("设置");
		mnNewMenu_5.setIcon(new ImageIcon(ViewFunctionSelection.class.getResource("/image/系统设置.png")));
		mnNewMenu_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("修改密码");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterPassword(e);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		mnNewMenu_5.add(mntmNewMenuItem_4);
	}

	protected void alterPassword(ActionEvent e) {
		// TODO Auto-generated method stub
		AlterPassword aPassword = new AlterPassword();
		aPassword.setVisible(true);
		JDesktopPane.add(aPassword);
	}

	protected void browsePatientSomeInformation(ActionEvent e) {
		// TODO Auto-generated method stub
		StaffInformation sInformation = new StaffInformation();
		sInformation.setVisible(true);
		JDesktopPane.add(sInformation);
	}

	protected void tranAction(ActionEvent e) {
		// TODO Auto-generated method stub
		StaffTransfer sTransfer = new StaffTransfer();
		sTransfer.setVisible(true);
		JDesktopPane.add(sTransfer);
	}

	protected void browseStaffInformation(ActionEvent e) {
		// TODO Auto-generated method stub
		if (("人事部".equals(user.getDuty().trim()) || "院长".equals(user.getDuty().trim()))
				&& PermissionUtil.isHavePermission(user.getDuty().trim(), "医生")) {
			StaffAllInformation staffInformation = new StaffAllInformation();
			staffInformation.setVisible(true);
			JDesktopPane.add(staffInformation);
		} else {
			JOptionPane.showMessageDialog(this, "您的权限不够");
		}
	}

	protected void openPatientAdmindtrationView(ActionEvent e) {
		// TODO Auto-generated method stub
		PatientAdministration patientAdministration = new PatientAdministration();
		patientAdministration.setVisible(true);
		JDesktopPane.add(patientAdministration);
	}

	protected void restartlogin(ActionEvent e) {
		// TODO Auto-generated method stub
		fram.setVisible(true);
		dispose();
	}

	protected void browsePatientAction(ActionEvent e) {
		// TODO Auto-generated method stub
		BrowsePatient browsePatient = new BrowsePatient();
		browsePatient.setVisible(true);
		JDesktopPane.add(browsePatient);
	}
}
