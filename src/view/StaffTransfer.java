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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.UserDao;
import model.User;
import util.PermissionUtil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffTransfer extends JInternalFrame {
	private JTextField tranNameTextField;
	private JTable table;
	private JComboBox tranDeptComboBox;
	private JComboBox tranDutyComboBox_1;
	private JTextField alterIdTextField;
	private JTextField alterNameTextField_1;
	private JTextField alterBirthdayextField_2;
	private JTextField alterHometownTextField_3;
	private JTextField alterCIDextField_6;
	private JTextField alterAddresssTextField_7;
	private JTextField alterTeleTextField_8;
	private JTextField alterEmailTextField_9;
	private JTextField deleteNameTextField_10;
	private JComboBox alterGenderComboBox;
	private JComboBox alterDeptComboBox_1;
	private JComboBox alterDutyComboBox_2;
	private JComboBox alterXLComboBox_3;
	private JComboBox alterStateomboBox_6;
	private JComboBox alterHealthComboBox_5;
	private JComboBox alterMarrigeComboBox_4;
	private JComboBox alterCountryComboBox_7;
	private JComboBox alterNationComboBox_8;
	private JTextField alterStartWorktextField;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { StaffTransfer frame = new
	 * StaffTransfer(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public StaffTransfer() {
		setTitle("????????????");
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 887, 486);

		JLabel lblNewLabel = new JLabel("?????????");
		lblNewLabel.setFont(new Font("????????????", Font.PLAIN, 16));

		tranNameTextField = new JTextField();
		tranNameTextField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_1 = new JLabel("?????????");
		lblNewLabel_1.setFont(new Font("????????????", Font.PLAIN, 16));

		tranDeptComboBox = new JComboBox();
		tranDeptComboBox.setModel(new DefaultComboBoxModel(new String[] { "?????????", "?????????", "?????????", "?????????" }));
		tranDeptComboBox.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("?????????");
		lblNewLabel_2.setFont(new Font("????????????", Font.PLAIN, 16));

		tranDutyComboBox_1 = new JComboBox();
		tranDutyComboBox_1.setModel(new DefaultComboBoxModel(new String[] { "??????", "?????????", "??????", "??????" }));
		tranDutyComboBox_1.setFont(new Font("????????????", Font.PLAIN, 16));

		JButton btnNewButton = new JButton("????????????");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyTranACtion(e);
			}
		});
		btnNewButton.setFont(new Font("????????????", Font.PLAIN, 16));

		JButton btnNewButton_1 = new JButton("????????????");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(e);
			}
		});
		btnNewButton_1.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("????????????");
		lblNewLabel_3.setFont(new Font("????????????", Font.PLAIN, 16));

		alterIdTextField = new JTextField();
		alterIdTextField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("?????????");
		lblNewLabel_4.setFont(new Font("????????????", Font.PLAIN, 16));

		alterNameTextField_1 = new JTextField();
		alterNameTextField_1.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("?????????");
		lblNewLabel_5.setFont(new Font("????????????", Font.PLAIN, 16));

		alterGenderComboBox = new JComboBox();
		alterGenderComboBox.setFont(new Font("????????????", Font.PLAIN, 16));
		alterGenderComboBox.setModel(new DefaultComboBoxModel(new String[] { "???", "???" }));

		JLabel lblNewLabel_6 = new JLabel("?????????");
		lblNewLabel_6.setFont(new Font("????????????", Font.PLAIN, 16));

		alterDeptComboBox_1 = new JComboBox();
		alterDeptComboBox_1.setFont(new Font("????????????", Font.PLAIN, 16));
		alterDeptComboBox_1.setModel(new DefaultComboBoxModel(new String[] { "?????????", "?????????", "?????????", "?????????" }));

		JLabel lblNewLabel_7 = new JLabel("?????????");
		lblNewLabel_7.setFont(new Font("????????????", Font.PLAIN, 16));

		alterDutyComboBox_2 = new JComboBox();
		alterDutyComboBox_2.setModel(new DefaultComboBoxModel(new String[] { "??????", "?????????", "??????", "??????" }));
		alterDutyComboBox_2.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_8 = new JLabel("?????????");
		lblNewLabel_8.setFont(new Font("????????????", Font.PLAIN, 16));

		alterXLComboBox_3 = new JComboBox();
		alterXLComboBox_3.setFont(new Font("????????????", Font.PLAIN, 16));
		alterXLComboBox_3.setModel(
				new DefaultComboBoxModel(new String[] { "?????????", "??????", "?????????", "??????", "??????", "??????", "??????", "??????", "??????" }));

		JLabel lblNewLabel_9 = new JLabel("?????????");
		lblNewLabel_9.setFont(new Font("????????????", Font.PLAIN, 16));

		alterBirthdayextField_2 = new JTextField();
		alterBirthdayextField_2.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("?????????");
		lblNewLabel_10.setFont(new Font("????????????", Font.PLAIN, 16));

		alterHometownTextField_3 = new JTextField();
		alterHometownTextField_3.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("?????????");
		lblNewLabel_11.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_12 = new JLabel("?????????");
		lblNewLabel_12.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_13 = new JLabel("???????????????");
		lblNewLabel_13.setFont(new Font("????????????", Font.PLAIN, 16));

		alterCIDextField_6 = new JTextField();
		alterCIDextField_6.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("???????????????");
		lblNewLabel_14.setFont(new Font("????????????", Font.PLAIN, 16));

		alterMarrigeComboBox_4 = new JComboBox();
		alterMarrigeComboBox_4.setFont(new Font("????????????", Font.PLAIN, 16));
		alterMarrigeComboBox_4.setModel(new DefaultComboBoxModel(new String[] { "??????", "??????" }));

		JLabel lblNewLabel_15 = new JLabel("???????????????");
		lblNewLabel_15.setFont(new Font("????????????", Font.PLAIN, 16));

		alterHealthComboBox_5 = new JComboBox();
		alterHealthComboBox_5.setModel(new DefaultComboBoxModel(new String[] { "??????", "??????", "??????" }));
		alterHealthComboBox_5.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_16 = new JLabel("???????????????");
		lblNewLabel_16.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_17 = new JLabel("??????????????????????????????");
		lblNewLabel_17.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_18 = new JLabel("???????????????");
		lblNewLabel_18.setFont(new Font("????????????", Font.PLAIN, 16));

		alterStateomboBox_6 = new JComboBox();
		alterStateomboBox_6.setModel(new DefaultComboBoxModel(new String[] { "??????", "??????" }));
		alterStateomboBox_6.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_19 = new JLabel("???????????????");
		lblNewLabel_19.setFont(new Font("????????????", Font.PLAIN, 16));

		alterAddresssTextField_7 = new JTextField();
		alterAddresssTextField_7.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("???????????????");
		lblNewLabel_20.setFont(new Font("????????????", Font.PLAIN, 16));

		alterTeleTextField_8 = new JTextField();
		alterTeleTextField_8.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("eMail???");
		lblNewLabel_21.setFont(new Font("????????????", Font.PLAIN, 16));

		alterEmailTextField_9 = new JTextField();
		alterEmailTextField_9.setColumns(10);

		JButton btnNewButton_2 = new JButton("??????");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifyAlterAction(e);
			}
		});
		btnNewButton_2.setFont(new Font("????????????", Font.PLAIN, 16));

		JButton btnNewButton_3 = new JButton("??????");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAction(e);
			}
		});
		btnNewButton_3.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_22 = new JLabel("???????????????");
		lblNewLabel_22.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_23 = new JLabel("?????????");
		lblNewLabel_23.setFont(new Font("????????????", Font.PLAIN, 16));

		deleteNameTextField_10 = new JTextField();
		deleteNameTextField_10.setColumns(10);

		JButton btnNewButton_4 = new JButton("??????");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction(e);
			}
		});
		btnNewButton_4.setFont(new Font("????????????", Font.PLAIN, 16));

		alterCountryComboBox_7 = new JComboBox();
		alterCountryComboBox_7.setFont(new Font("????????????", Font.PLAIN, 16));
		alterCountryComboBox_7.setModel(new DefaultComboBoxModel(
				new String[] { "??????", "??????", "??????", "??????", "??????", "??????", "??????", "????????????", "?????????", "??????", "??????" }));

		alterNationComboBox_8 = new JComboBox();
		alterNationComboBox_8.setModel(new DefaultComboBoxModel(new String[] { "???", "??????" }));
		alterNationComboBox_8.setFont(new Font("????????????", Font.PLAIN, 16));

		JLabel lblNewLabel_24 = new JLabel("?????????????????????");
		lblNewLabel_24.setFont(new Font("????????????", Font.PLAIN, 16));

		alterStartWorktextField = new JTextField();
		alterStartWorktextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout
														.createSequentialGroup().addContainerGap()
														.addGroup(groupLayout
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(lblNewLabel_3, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblNewLabel, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(alterIdTextField,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(tranNameTextField,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(groupLayout
														.createSequentialGroup().addGap(2).addComponent(lblNewLabel_16,
																GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 52,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(alterNameTextField_1, GroupLayout.PREFERRED_SIZE,
																81, GroupLayout.PREFERRED_SIZE)
														.addGap(32).addComponent(lblNewLabel_5)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(alterGenderComboBox, GroupLayout.PREFERRED_SIZE,
																69, GroupLayout.PREFERRED_SIZE)
														.addGap(29).addComponent(lblNewLabel_6))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblNewLabel_1)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(tranDeptComboBox, GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 57,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(
																tranDutyComboBox_1, GroupLayout.PREFERRED_SIZE, 90,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(10)
														.addComponent(alterDeptComboBox_1, GroupLayout.PREFERRED_SIZE,
																74, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addGap(4).addComponent(alterDutyComboBox_2,
																GroupLayout.PREFERRED_SIZE, 69,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(
														groupLayout.createSequentialGroup().addGap(20).addComponent(
																btnNewButton, GroupLayout.PREFERRED_SIZE, 97,
																GroupLayout.PREFERRED_SIZE))))
										.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(
												groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
														.createSequentialGroup().addGap(1)
														.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 52,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(alterXLComboBox_3, GroupLayout.PREFERRED_SIZE, 79,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(alterBirthdayextField_2,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(11)
														.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(alterHometownTextField_3,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(alterCountryComboBox_7,
																GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addGap(29)
														.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 58,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(alterNationComboBox_8, GroupLayout.PREFERRED_SIZE,
																64, GroupLayout.PREFERRED_SIZE))
														.addGroup(Alignment.TRAILING,
																groupLayout.createSequentialGroup().addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(btnNewButton_2,
																				GroupLayout.PREFERRED_SIZE, 97,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(lblNewLabel_13)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(alterCIDextField_6,
																						GroupLayout.PREFERRED_SIZE, 108,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblNewLabel_14)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(alterMarrigeComboBox_4,
																						GroupLayout.PREFERRED_SIZE, 70,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblNewLabel_15)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(alterHealthComboBox_5,
																						GroupLayout.PREFERRED_SIZE, 74,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(lblNewLabel_18,
																						GroupLayout.PREFERRED_SIZE, 88,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(alterStateomboBox_6,
																						GroupLayout.PREFERRED_SIZE, 73,
																						GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(btnNewButton_3,
																				GroupLayout.PREFERRED_SIZE, 97,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(34))))
										.addGroup(groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(lblNewLabel_19, GroupLayout.PREFERRED_SIZE, 81,
														GroupLayout.PREFERRED_SIZE)
												.addGap(3)
												.addComponent(alterAddresssTextField_7, GroupLayout.PREFERRED_SIZE, 108,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblNewLabel_20)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(alterTeleTextField_8, GroupLayout.PREFERRED_SIZE, 106,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNewLabel_21, GroupLayout.PREFERRED_SIZE, 58,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(alterEmailTextField_9, GroupLayout.PREFERRED_SIZE, 100,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblNewLabel_24, GroupLayout.PREFERRED_SIZE, 126,
														GroupLayout.PREFERRED_SIZE)
												.addGap(9).addComponent(alterStartWorktextField,
														GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
								.addGap(33))
						.addGroup(groupLayout.createSequentialGroup().addGap(3)
								.addComponent(lblNewLabel_22, GroupLayout.PREFERRED_SIZE, 107,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(773, Short.MAX_VALUE))
						.addGroup(groupLayout
								.createSequentialGroup().addGap(3)
								.addComponent(lblNewLabel_17, GroupLayout.PREFERRED_SIZE, 190,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(690, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(15)
								.addComponent(lblNewLabel_23, GroupLayout.PREFERRED_SIZE, 58,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(deleteNameTextField_10, GroupLayout.PREFERRED_SIZE, 113,
										GroupLayout.PREFERRED_SIZE)
								.addGap(89)
								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(507, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(32)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 703, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(33, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(11)
						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(tranNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tranDeptComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(tranDutyComboBox_1, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addGap(2)
						.addComponent(lblNewLabel_17, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(9)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(3)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(alterIdTextField, GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_4)
												.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 18,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(alterGenderComboBox, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(alterNameTextField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_6)
												.addComponent(alterDeptComboBox_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_7)
												.addComponent(alterDutyComboBox_2, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_8)
								.addComponent(alterXLComboBox_3, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9)
								.addComponent(alterBirthdayextField_2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10)
								.addComponent(alterHometownTextField_3, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_11).addComponent(lblNewLabel_12)
								.addComponent(alterCountryComboBox_7, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(
										alterNationComboBox_8, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addGap(18).addGroup(groupLayout
										.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_13)
										.addComponent(alterCIDextField_6, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(alterMarrigeComboBox_4, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_15)
										.addComponent(alterHealthComboBox_5, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_18)
										.addComponent(alterStateomboBox_6, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(11)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(alterAddresssTextField_7, GroupLayout.PREFERRED_SIZE, 22,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_20)
												.addComponent(alterTeleTextField_8, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_21)
												.addComponent(alterEmailTextField_9, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_19, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_24, GroupLayout.PREFERRED_SIZE, 24,
														GroupLayout.PREFERRED_SIZE))
										.addGap(11))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(alterStartWorktextField, GroupLayout.PREFERRED_SIZE, 21,
														GroupLayout.PREFERRED_SIZE)
												.addGap(13)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_22, GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2).addComponent(btnNewButton_3))
						.addGap(7)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_23)
								.addComponent(deleteNameTextField_10, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_4))
						.addGap(16)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
						.addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5458\u5DE5\u53F7", "\u59D3\u540D",
				"\u6027\u522B", "\u90E8\u95E8", "\u804C\u52A1", "\u8054\u7CFB\u7535\u8BDD", "eMail" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("????????????", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setTable();
	}

	protected void deleteAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameString = deleteNameTextField_10.getText().toString();
		User user = ViewFunctionSelection.user;
		User u = (new UserDao()).getOneUserInformation(nameString);
		if (StringUtil.isEmpty(nameString) || u == null) {
			JOptionPane.showMessageDialog(this, "????????????????????????????????????????????????");
			return;
		}
		if (PermissionUtil.isHavePermission(user.getDuty().trim(), u.getDuty().trim())
				&& ("?????????".equals(user.getDuty().trim()) || "??????".equals(user.getDuty().trim()))
				&& PermissionUtil.isHavePermission(user.getDuty().trim(), "??????")) {
			if ("??????".equals(u.getDuty().trim())) {
				(new UserDao()).updateDeptManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
			} else if ("?????????".equals(u.getDuty().trim())) {
				(new UserDao()).updateDeptViceManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
			}
			(new UserDao()).deleteUser(nameString);
			JOptionPane.showMessageDialog(this, "????????????");
			resetTable(e);
			deleteNameTextField_10.setText("");
			return ;
		}
		JOptionPane.showMessageDialog(this, "??????????????????");
		deleteNameTextField_10.setText("");
	}

	protected void verifyAlterAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String idString = alterIdTextField.getText().toString();
		String nameString = alterNameTextField_1.getText().toString();
		String birthdayString = alterBirthdayextField_2.getText().toString();
		String hometown = alterHometownTextField_3.getText().toString();
		String cIdString = alterCIDextField_6.getText().toString();
		String addressString = alterAddresssTextField_7.getText().toString();
		String teleString = alterTeleTextField_8.getText().toString();
		String eMailString = alterEmailTextField_9.getText().toString();
		String genderString = (String) alterGenderComboBox.getSelectedItem();
		String deptString = (String) alterDeptComboBox_1.getSelectedItem();
		String dutyString = (String) alterDutyComboBox_2.getSelectedItem();
		String xlString = (String) alterXLComboBox_3.getSelectedItem();
		String stateString = (String) alterStateomboBox_6.getSelectedItem();
		String healthString = (String) alterHealthComboBox_5.getSelectedItem();
		String marrigeString = (String) alterMarrigeComboBox_4.getSelectedItem();
		String countryString = (String) alterCountryComboBox_7.getSelectedItem();
		String nationString = (String) alterNationComboBox_8.getSelectedItem();
		String startWorkString = alterStartWorktextField.getText().toString();

		User user = ViewFunctionSelection.user;
		//???????????????
		User userNow = new User(idString, nameString, birthdayString, hometown, cIdString, addressString, teleString,
				eMailString, genderString, (new UserDao()).referDeptIdDept(deptString), dutyString, xlString,
				stateString, healthString, countryString, nationString, marrigeString, startWorkString);

		if (StringUtil.isEmpty(idString) || StringUtil.isEmpty(nameString)) {
			JOptionPane.showMessageDialog(this, "???????????????????????????????????????");
			return;
		}
		//????????????id??????????????????
		User u = (new UserDao()).getUserInformation(idString);
		if (u == null) { // ????????????
			if (PermissionUtil.isHavePermission(user.getDuty().trim(), dutyString)
					&& ("?????????".equals(user.getDuty().trim()) || "??????".equals(user.getDuty().trim()))
					&& PermissionUtil.isHavePermission(user.getDuty().trim(), "??????")) {
				if ("??????".equals(dutyString)
						&& StringUtil.isEmpty(((new UserDao()).referDeptManagerDept(deptString))) == false) {
					JOptionPane.showMessageDialog(this, "???????????????????????????????????????????????????");
					return;
				} else if ("?????????".equals(dutyString)
						&& StringUtil.isEmpty(((new UserDao()).referDeptViceManagerDept(deptString))) == false) {
					JOptionPane.showMessageDialog(this, "??????????????????????????????????????????????????????");
					return;
				} else if ("??????".equals(dutyString)) {
					(new UserDao()).updateDeptManagerDept(userNow.getId(), deptString);
				} else if ("?????????".equals(dutyString)) {
					(new UserDao()).updateDeptViceManagerDept(userNow.getId(), deptString);
				}
				(new UserDao()).insertUserInformation(userNow);
				JOptionPane.showMessageDialog(this, "??????????????????");
				resetTable(e);
				return;
			}
		} else if(u.getName().trim().equals(nameString) == false) {
			JOptionPane.showMessageDialog(this, "???????????????????????????");
			return;
		} else if((u.getDeptId().trim().equals(userNow.getDeptId().trim())
								&& u.getDuty().trim().equals(userNow.getDuty().trim())) == false){ // ??????????????????,?????????????????????
			if (PermissionUtil.isHavePermission(user.getDuty().trim(), u.getDuty().trim())
					&& PermissionUtil.isHavePermission(user.getDuty().trim(), dutyString)
					&& ("?????????".equals(user.getDuty().trim()) || "??????".equals(user.getDuty().trim()))
					&& PermissionUtil.isHavePermission(user.getDuty().trim(), "??????")) {
				if ("??????".equals(dutyString)
						&& StringUtil.isEmpty(((new UserDao()).referDeptManagerDept(deptString))) == false) {
					JOptionPane.showMessageDialog(this, "???????????????????????????????????????????????????");
					return;
				} else if ("?????????".equals(dutyString)
						&& StringUtil.isEmpty(((new UserDao()).referDeptViceManagerDept(deptString))) == false) {
					JOptionPane.showMessageDialog(this, "??????????????????????????????????????????????????????");
					return;
				} else if ("??????".equals(dutyString)) {
					(new UserDao()).updateDeptManagerDept(u.getId().trim(), deptString);
				} else if ("?????????".equals(dutyString)) {
					(new UserDao()).updateDeptViceManagerDept(u.getId().trim(), deptString);
				}
				if ("??????".equals(u.getDuty().trim())) {
					(new UserDao()).updateDeptManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
				} else if ("?????????".equals(u.getDuty().trim())) {
					(new UserDao()).updateDeptViceManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
				}
				u.setDeptId((new UserDao()).referDeptIdDept(deptString));
				u.setJobIdString((new UserDao()).referJobIdDept(dutyString));
				u.setDuty(dutyString);
				// System.out.println(user.getDuty());
				(new UserDao()).updateUserInformation(u);
				JOptionPane.showMessageDialog(this, "??????????????????");
				resetTable(e);
				return;
			}
		}
		else { //????????????????????????
			if (PermissionUtil.isHavePermission(user.getDuty().trim(), u.getDuty().trim())
					&& PermissionUtil.isHavePermission(user.getDuty().trim(), dutyString)
					&& ("?????????".equals(user.getDuty().trim()) || "??????".equals(user.getDuty().trim()))
					&& PermissionUtil.isHavePermission(user.getDuty().trim(), "??????")) {
				(new UserDao()).updateUserInformation(userNow);
				JOptionPane.showMessageDialog(this, "??????????????????");
				resetTable(e);
				resetAction(e);
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "?????????????????????????????????");
		resetTable(e);
	}

	protected void resetAction(ActionEvent e) {
		// TODO Auto-generated method stub
		alterIdTextField.setText("");
		alterStartWorktextField.setText("");
		alterNameTextField_1.setText("");
		alterBirthdayextField_2.setText("");
		alterHometownTextField_3.setText("");
		alterCIDextField_6.setText("");
		alterAddresssTextField_7.setText("");
		alterTeleTextField_8.setText("");
		alterEmailTextField_9.setText("");
		alterGenderComboBox.setSelectedIndex(0);
		alterDeptComboBox_1.setSelectedIndex(0);
		alterDutyComboBox_2.setSelectedIndex(0);
		alterXLComboBox_3.setSelectedIndex(0);
		alterStateomboBox_6.setSelectedIndex(0);
		alterHealthComboBox_5.setSelectedIndex(0);
		alterMarrigeComboBox_4.setSelectedIndex(0);
		alterCountryComboBox_7.setSelectedIndex(0);
		alterNationComboBox_8.setSelectedIndex(0);
	}

	protected void resetTable(ActionEvent e) {
		// TODO Auto-generated method stub
		setTable();
	}

	private void setTable() {
		// TODO Auto-generated method stub
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
			vector.add(user.getTeleNoString());
			vector.add(user.geteMailString());
			dft.addRow(vector);
		}
	}

	protected void verifyTranACtion(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameString = tranNameTextField.getText().toString();
		String deptString = (String) tranDeptComboBox.getSelectedItem();
		String dutyString = (String) tranDutyComboBox_1.getSelectedItem();
		User user = ViewFunctionSelection.user;
		if (StringUtil.isEmpty(nameString)) {
			JOptionPane.showMessageDialog(this, "?????????????????????");
			return;
		}
		User u = (new UserDao()).getOneUserInformation(nameString);
		if (u == null) {
			JOptionPane.showMessageDialog(this, "???????????????????????????");
			tranNameTextField.setText("");
			return;
		}
		// System.out.println(user.getDuty() + u.getDuty());
		if (PermissionUtil.isHavePermission(user.getDuty().trim(), u.getDuty().trim())
				&& PermissionUtil.isHavePermission(user.getDuty().trim(), dutyString)
				&& ("?????????".equals(user.getDuty().trim()) || "??????".equals(user.getDuty().trim()))
				&& PermissionUtil.isHavePermission(user.getDuty().trim(), "??????")) {
			if ("??????".equals(dutyString)
					&& StringUtil.isEmpty(((new UserDao()).referDeptManagerDept(deptString))) == false) {
				JOptionPane.showMessageDialog(this, "???????????????????????????????????????????????????");
				return;
			} else if ("?????????".equals(dutyString)
					&& StringUtil.isEmpty(((new UserDao()).referDeptViceManagerDept(deptString))) == false) {
				JOptionPane.showMessageDialog(this, "??????????????????????????????????????????????????????");
				return;
			} else if ("??????".equals(dutyString)) {
				(new UserDao()).updateDeptManagerDept(u.getId().trim(), deptString);
			} else if ("?????????".equals(dutyString)) {
				(new UserDao()).updateDeptViceManagerDept(u.getId().trim(), deptString);
			}
			if ("??????".equals(u.getDuty().trim())) {
				(new UserDao()).updateDeptManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
			} else if ("?????????".equals(u.getDuty().trim())) {
				(new UserDao()).updateDeptViceManagerDept(null, (new UserDao()).referDeptNameDept(u.getDeptId()));
			}
			u.setDeptId((new UserDao()).referDeptIdDept(deptString));
			u.setJobIdString((new UserDao()).referJobIdDept(dutyString));
			u.setDuty(dutyString);
			// System.out.println(user.getDuty());
			(new UserDao()).updateUserDeptDutyJobInformation(u);
			JOptionPane.showMessageDialog(this, "??????????????????");
			resetTable(e);
			return;
		}
		JOptionPane.showMessageDialog(this, "?????????????????????????????????");
		tranNameTextField.setText("");
		/*
		 * System.out.println(PermissionUtil.isHavePermission(user.getDuty().trim(),
		 * u.getDuty().trim()));
		 * System.out.println(PermissionUtil.isHavePermission(user.getDuty().trim(),
		 * dutyString)); System.out.println(("?????????".equals(deptString) ||
		 * "??????".equals(dutyString)));
		 * System.out.println(PermissionUtil.isHavePermission(user.getDuty().trim(),
		 * "??????"));
		 */
	}
}
