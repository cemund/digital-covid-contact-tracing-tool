import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import connectivity.ConnectionClass;

public class CreateAcc extends JFrame implements ActionListener {
	private JLabel lblCreateAcc;
	private JTextField textName;
	private JTextField textAdd;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JTextField textAge;
	private JTextField textContNum;
	private JTextField textEmail;
	private JTextField textCollege;
	private JTextField textCourse;
	private JTextField textUserName;
	private JPasswordField textPass;
	private JPasswordField textConfPass;
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnFaculty;
	private JRadioButton rdbtnStaff;
	private JButton btnCreate;
	private JButton btnBack;
	private JComboBox comboBoxCourse;
	private JComboBox comboBoxCollege;
	private String[] ccisCourses = {"", "BSCS", "BSIT"};
	private String[] csCourses = {"", "BSFT", "BSBIO", "BSCHEM", "BSND"};
	private String[] chkCourses = {"", "BPE", "BSESS"};
	private String[] college = {"", "CCIS", "CS", "CHK"};
	private Font myFont = new Font("Britannic Bold", Font.BOLD, 20);
	private Color myColor = new Color(49, 50, 111);
	private Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
	String userType = "Student";

	CreateAcc() {
		
		this.setIconImage(icon);
		setTitle("Create Account");
		getContentPane().setBackground(new Color(0,194,203));
		
		this.setSize(582, 500);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(137, 178, 163, 20);
		getContentPane().add(textName);
		textName.setColumns(10);
		
		textAdd = new JTextField();
		textAdd.setBounds(137, 214, 163, 20);
		getContentPane().add(textAdd);
		textAdd.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(myFont);
		lblName.setForeground(myColor);
		lblName.setBounds(31, 178, 96, 20);
		getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(myFont);
		lblAddress.setForeground(myColor);
		lblAddress.setBounds(31, 214, 96, 20);
		getContentPane().add(lblAddress);
		
		rdbtnStudent = new JRadioButton("Student", true);
		rdbtnStudent.setFont(myFont);
		rdbtnStudent.setForeground(myColor);
		rdbtnStudent.setBounds(106, 121, 111, 23);
		rdbtnStudent.setOpaque(false);
		rdbtnStudent.setFocusable(false);
		rdbtnStudent.addActionListener(this);
		group.add(rdbtnStudent);
		getContentPane().add(rdbtnStudent);
		
		rdbtnFaculty = new JRadioButton("Faculty");
		rdbtnFaculty.setOpaque(false);
		rdbtnFaculty.setFont(myFont);
		rdbtnFaculty.setForeground(myColor);
		rdbtnFaculty.setBounds(237, 121, 111, 23);
		rdbtnFaculty.setFocusable(false);
		rdbtnFaculty.addActionListener(this);
		group.add(rdbtnFaculty);
		getContentPane().add(rdbtnFaculty);
		
		rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setOpaque(false);
		rdbtnStaff.setFont(myFont);
		rdbtnStaff.setForeground(myColor);
		rdbtnStaff.setBounds(367, 121, 111, 23);
		rdbtnStaff.setFocusable(false);
		rdbtnStaff.addActionListener(this);
		group.add(rdbtnStaff);
		getContentPane().add(rdbtnStaff);
		
		textYear = new JTextField();
		textYear.setToolTipText("Year ex. 2001");
		textYear.setBounds(137, 245, 58, 20);
		getContentPane().add(textYear);
		textYear.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(137, 276, 163, 20);
		getContentPane().add(textAge);
		textAge.setColumns(10);
		
		textContNum = new JTextField();
		textContNum.setBounds(137, 307, 163, 20);
		getContentPane().add(textContNum);
		textContNum.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(137, 338, 163, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textCollege = new JTextField();
		textCollege.setBounds(137, 369, 163, 20);
		//getContentPane().add(textCollege);
		textCollege.setColumns(10);
		
		textCourse = new JTextField();
		textCourse.setBounds(137, 403, 163, 20);
		//getContentPane().add(textCourse);
		textCourse.setColumns(10);
		
		textUserName = new JTextField();
		textUserName.setBounds(368, 214, 163, 20);
		getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setBounds(368, 276, 163, 20);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		textConfPass = new JPasswordField();
		textConfPass.setBounds(368, 341, 163, 20);
		getContentPane().add(textConfPass);
		textConfPass.setColumns(10);
		
		JLabel lblBirth = new JLabel("Birthday");
		lblBirth.setFont(myFont);
		lblBirth.setForeground(myColor);
		lblBirth.setBounds(31, 245, 96, 20);
		getContentPane().add(lblBirth);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(myFont);
		lblAge.setForeground(myColor);
		lblAge.setBounds(31, 276, 96, 20);
		getContentPane().add(lblAge);
		
		JLabel lblContNum = new JLabel("Contact #");
		lblContNum.setFont(myFont);
		lblContNum.setForeground(myColor);
		lblContNum.setBounds(31, 307, 96, 20);
		getContentPane().add(lblContNum);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(myFont);
		lblEmail.setForeground(myColor);
		lblEmail.setBounds(31, 338, 96, 20);
		getContentPane().add(lblEmail);
		
		JLabel lblCollege = new JLabel("College");
		lblCollege.setFont(myFont);
		lblCollege.setForeground(myColor);
		lblCollege.setBounds(31, 369, 96, 20);
		getContentPane().add(lblCollege);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(myFont);
		lblCourse.setForeground(myColor);
		lblCourse.setBounds(31, 403, 96, 20);
		getContentPane().add(lblCourse);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(myFont);
		lblUserName.setForeground(myColor);
		lblUserName.setBounds(368, 178, 125, 20);
		getContentPane().add(lblUserName);
		
		JLabel lblPass = new JLabel("Password\r\n");
		lblPass.setFont(myFont);
		lblPass.setForeground(myColor);
		lblPass.setBounds(368, 245, 152, 20);
		getContentPane().add(lblPass);
		
		JLabel lblConfPass = new JLabel("Confirm Password");
		lblConfPass.setFont(myFont);
		lblConfPass.setForeground(myColor);
		lblConfPass.setBounds(368, 307, 179, 20);
		getContentPane().add(lblConfPass);
		
		btnCreate = new JButton("CREATE");
		btnCreate.setFont(myFont);
		btnCreate.setForeground(Color.white);
		btnCreate.setBackground(myColor);
		btnCreate.setBounds(389, 399, 142, 23);
		btnCreate.setFocusable(false);
		btnCreate.addActionListener(this);
		getContentPane().add(btnCreate);
		
		lblCreateAcc = new JLabel("Create Account");
		lblCreateAcc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAcc.setForeground(Color.WHITE);
		lblCreateAcc.setFont(new Font("Britannic Bold", Font.PLAIN, 55));
		lblCreateAcc.setBounds(10, 41, 556, 46);
		//getContentPane().add(lblCreateAcc);
		
		btnBack = new JButton("<");
		btnBack.setOpaque(false);
		btnBack.setFocusable(false);
		btnBack.setBorderPainted(false);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(myColor);
		btnBack.setFont(myFont);
		btnBack.setBounds(10, 11, 43, 23);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);

		JLabel lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon("title.png");
		lblHeader.setIcon(img);
		lblHeader.setBounds(10, 11, 556, 80);
		this.getContentPane().add(lblHeader);
		
		comboBoxCourse = new JComboBox();
		comboBoxCourse.setBounds(137, 402, 163, 22);
		comboBoxCourse.setBackground(Color.white);
		comboBoxCourse.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		comboBoxCourse.setFocusable(false);
		comboBoxCourse.addActionListener(this);
		getContentPane().add(comboBoxCourse);
		
		comboBoxCollege = new JComboBox(college);
		comboBoxCollege.setBounds(137, 368, 163, 22);
		comboBoxCollege.setBackground(Color.white);
		comboBoxCollege.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		comboBoxCollege.setFocusable(false);
		comboBoxCollege.addActionListener(this);
		getContentPane().add(comboBoxCollege);
		
		textMonth = new JTextField();
		textMonth.setToolTipText("Month ex. 01");
		textMonth.setBounds(204, 245, 43, 20);
		getContentPane().add(textMonth);
		textMonth.setColumns(10);
		
		textDay = new JTextField();
		textDay.setToolTipText("Day ex. 01");
		textDay.setBounds(257, 245, 43, 20);
		getContentPane().add(textDay);
		textDay.setColumns(10);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCreate) {
			// pass and confirm password checker
			if(textPass.getText().equals(textConfPass.getText())) {
				
				// store data to database
				try {
					store();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Invalid", "Error Message", JOptionPane.ERROR_MESSAGE);
				}
					
			}
			else {
				JOptionPane.showMessageDialog(null, "Password does not match", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(e.getSource() == btnBack)
			back();
		else if(e.getSource() == comboBoxCollege) {
			if(comboBoxCollege.getSelectedIndex() == 1) 
				comboBoxCourse.setModel(new DefaultComboBoxModel(ccisCourses));
			else if(comboBoxCollege.getSelectedIndex() == 2)
				comboBoxCourse.setModel(new DefaultComboBoxModel(csCourses));
			else if(comboBoxCollege.getSelectedIndex() == 3)
				comboBoxCourse.setModel(new DefaultComboBoxModel(chkCourses));
			else 
				comboBoxCourse.removeAllItems();
		}
		
		else if(rdbtnStudent.isSelected()) {
			comboBoxCollege.setEnabled(true);
			comboBoxCourse.setEnabled(true);
			userType = "Student";
		}
		else if(rdbtnFaculty.isSelected()) {
			comboBoxCourse.removeAllItems();
			comboBoxCollege.setEnabled(true);
			comboBoxCourse.setEnabled(false);
			userType = "Faculty";
		}
		else if(rdbtnStaff.isSelected()) {
			comboBoxCollege.setSelectedIndex(0);
			comboBoxCourse.removeAllItems();
			comboBoxCollege.setEnabled(false);
			comboBoxCourse.setEnabled(false);
			userType = "Staff";
		}
	}
	
	private void back() {
		this.dispose();
		new HomePage();
	}
	
	private void create() {
		this.dispose();
		new Details();
	}
	
	private void store() throws SQLException {

		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
			
		try {
			//getting userID
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from users_tbl");
			rs.next();
			int userID = rs.getInt(1) + 1;
			//System.out.println(userID);
			
			//name
			String name = textName.getText();
			//System.out.println(name);
				
			//contact
			int contact = Integer.parseInt(textContNum.getText());
			//System.out.println(contact);
			
			//email 
			String email = textEmail.getText();
			//System.out.println(email);
			
			//type
			String type = userType;
			//System.out.println(type);
			
			//college
			String college = String.valueOf(comboBoxCollege.getSelectedItem());
			//System.out.println(college);
			
			//course
			String course = String.valueOf(comboBoxCourse.getSelectedItem());
			//System.out.println(course);
			
			//username
			String username = textUserName.getText();
			//System.out.println(username);
			
			//password
			String password = textPass.getText();
			//System.out.println(password);
			
			//age
			int age = Integer.parseInt(textAge.getText());
			//System.out.println(age);
			
			//Birthdate
			String birthdate = textYear.getText() +"-"+ textMonth.getText() +"-"+ textDay.getText();
			//System.out.println(birthdate);
			
			//address
			String address = textAdd.getText();
			//System.out.println(address);
		
			//insert sa db
			String sql = "INSERT INTO users_tbl VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setInt(1, userID);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, contact);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, type);
			preparedStatement.setString(6, college);
			preparedStatement.setString(7, course);
			preparedStatement.setString(8, username);
			preparedStatement.setString(9, password);
			preparedStatement.setInt(10, age);
			preparedStatement.setDate(11, java.sql.Date.valueOf(birthdate));
			preparedStatement.setString(12, address);
		
			preparedStatement.executeUpdate();
			//System.out.println(rowsAffected);
			JOptionPane.showMessageDialog(null, "Account successfully created", "Information Message", JOptionPane.INFORMATION_MESSAGE);
			create();	
		} catch (SQLIntegrityConstraintViolationException x){
			JOptionPane.showMessageDialog(null, "Duplicated user information or username.\nPlease recheck inputted \nName\nContact\nEmail\nUsername", "Duplicated Data", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException x) {
			JOptionPane.showMessageDialog(null, "Please enter the data values correctly.", "Error Input Values", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException x) {
			JOptionPane.showMessageDialog(null, "Error Date!", "Error Input Values", JOptionPane.ERROR_MESSAGE);
		}
	}
}
