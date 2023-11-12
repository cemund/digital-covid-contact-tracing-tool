import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HomePage extends JFrame implements ActionListener{
	private JTextField textUserName;
	private JPasswordField textUserPass;
	
	Font flabel = new Font("Britannic Bold", Font.BOLD, 20);
	Color cbtn = new Color(49,50,111);
	
	private JButton btnLogin;
	private JButton btnCreateAcc;
	
	HomePage() {
		setTitle("Contact Tracing Digital Tool");
		getContentPane().setBackground(new Color(0,194,203));
		
		this.setSize(500, 500);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Britannic Bold", Font.PLAIN, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 25, 464, 115);
		//getContentPane().add(lblTitle);
		
		textUserName = new JTextField();
		textUserName.setBounds(157, 182, 171, 30);
		getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		textUserPass = new JPasswordField();
		textUserPass.setBounds(157, 260, 171, 30);
		getContentPane().add(textUserPass);
		textUserPass.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(flabel);
		lblUserName.setForeground(cbtn);
		lblUserName.setBounds(157, 157, 171, 14);
		getContentPane().add(lblUserName);
		
		JLabel lblUserPass = new JLabel("Password");
		lblUserPass.setFont(flabel);
		lblUserPass.setForeground(cbtn);
		lblUserPass.setBounds(157, 235, 171, 14);
		getContentPane().add(lblUserPass);
		
		btnLogin = new JButton("Log in");
		btnLogin.setBackground(cbtn);
		btnLogin.setForeground(Color.white);
		btnLogin.setFont(flabel);
		btnLogin.setBounds(157, 313, 171, 42);
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);
		
		btnCreateAcc = new JButton("Create New Account");
		btnCreateAcc.setOpaque(true);
		btnCreateAcc.setBackground(new Color(0,194,203));
		btnCreateAcc.setBorderPainted(false);
		btnCreateAcc.setForeground(cbtn);
		btnCreateAcc.setFont(flabel);
		btnCreateAcc.setBounds(124, 389, 236, 23);
		btnCreateAcc.setFocusable(false);
		btnCreateAcc.addActionListener(this);
		getContentPane().add(btnCreateAcc);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon img = new ImageIcon("title.png");
		lblHeader.setIcon(img);
		lblHeader.setBounds(10, 31, 474, 80);
		this.getContentPane().add(lblHeader);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// log in
		if(e.getSource() == btnLogin) {
			
			String username = textUserName.getText();
			String pass = textUserPass.getText();
			
			// check if no input
			if((username.equals("") && pass.equals("")) || (username.equals("") || pass.equals(""))) {
				JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				// locate input data to the database
				// if located then details, else error
				
				this.dispose();
				new Details();
			}
		}
		
		// create
		else if(e.getSource() == btnCreateAcc) {
			this.dispose();
			new CreateAcc();
		}		
	}
}
