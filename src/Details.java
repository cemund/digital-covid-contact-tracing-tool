import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Details extends JFrame implements ActionListener  {
	
	String[] locations = {""
			,"NFS Bldg."
			, "Lagoon"
			, "PE Bldg."
			, "Clinic"
			, "Admin"
			, "CCIS Office"
			, "CS Office"
			, "N3"
			, "S3"
			, "E3"
			, "W3"
			, "N4"
			, "S4"
			, "E4"
			, "W4"
			, "N5"
			, "S5"
			, "E5"
			, "W5"
			, "N6"
			, "S6"
			, "E6"
			, "W6" };
	
	JFrame frame = new JFrame("Details");
	
	DefaultTableModel model = new DefaultTableModel();
	
	JTable table = new JTable();

	JTextField textFieldDate = new JTextField();
	JTextField textFieldLocation = new JTextField();
	JTextField textFieldTimeIn = new JTextField();
	JTextField textFieldTimeOut = new JTextField();

	JButton btnPositive = new JButton("I tested positive");
	JButton btnAdd = new JButton("Add");
	JButton btnLogOut = new JButton("Log out");
	
	JComboBox comboBoxLocation;
	
	Font txtFont = new Font("Britannic Bold", Font.BOLD, 23);
			
		public Details() {
			initComponents();
		}
			
		private void initComponents() {
			Object[] columns = {"Day","Time In","Time Out","Location"};
			
			frame.getContentPane().setBackground(new Color(0,194,203));
			frame.getContentPane().setForeground(Color.white);
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
			frame.setBounds(100,100,900,600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setLocationRelativeTo(null);
			
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			table.setBackground(Color.white);
			table.setForeground(new Color(49,50,111));
			table.setSelectionBackground(Color.gray);
			table.setGridColor(new Color(49,50,111));
			table.setSelectionForeground(Color.white);
			table.setFont(new Font("Britannic Bold", Font.BOLD, 16));
			table.setRowHeight(25);
			table.setAutoCreateRowSorter(true);
			
			JScrollPane sp = new JScrollPane(table);
			sp.setForeground(new Color(13,37,39));
			sp.setBackground(new Color(13,37,39));
			sp.setBounds(33,102,818,308);
			
			frame.getContentPane().add(sp);
			
			//Labels 
			
			JLabel lblDay = new JLabel("Day");
			lblDay.setFont(txtFont);
			lblDay.setForeground(new Color(49,50,111));
			lblDay.setBounds(109, 425, 58, 24);
			frame.getContentPane().add(lblDay);
			textFieldDate.setFont(new Font("Britannica Bold", Font.BOLD, 16));
			textFieldDate.setBounds(207, 423, 189, 26);
			frame.getContentPane().add(textFieldDate);
			textFieldDate.setColumns(10);
			
			JLabel lblLocation = new JLabel("Location");
			lblLocation.setFont(txtFont);
			lblLocation.setForeground(new Color(49,50,111));
			lblLocation.setBounds(109, 460, 94, 24);
			frame.getContentPane().add(lblLocation);
			textFieldLocation.setFont(new Font("Britannica Bold", Font.BOLD, 16));
			textFieldLocation.setColumns(10);
			textFieldLocation.setBounds(207, 458, 189, 26);
			//frame.getContentPane().add(textFieldLocation);
			
			comboBoxLocation = new JComboBox(locations);
			comboBoxLocation.setBounds(207, 458, 189, 26);
			comboBoxLocation.setFocusable(false);
			comboBoxLocation.setBackground(Color.white);
			comboBoxLocation.setFont(new Font("Britannica Bold", Font.BOLD, 16));
			frame.getContentPane().add(comboBoxLocation);
			
			JLabel lblTimeIn = new JLabel("Time In");
			lblTimeIn.setFont(txtFont);
			lblTimeIn.setForeground(new Color(49,50,111));
			lblTimeIn.setBounds(457, 425, 100, 24);
			frame.getContentPane().add(lblTimeIn);
			textFieldTimeIn.setFont(new Font("Britannica Bold", Font.BOLD, 16));
			textFieldTimeIn.setColumns(10);
			textFieldTimeIn.setBounds(583, 421, 189, 26);
			frame.getContentPane().add(textFieldTimeIn);
			
			JLabel lblTimeOut = new JLabel("Time Out");
			lblTimeOut.setFont(txtFont);
			lblTimeOut.setForeground(new Color(49,50,111));
			lblTimeOut.setBounds(457, 460, 100, 24);
			frame.getContentPane().add(lblTimeOut);
			textFieldTimeOut.setFont(new Font("Britannica Bold", Font.BOLD, 16));
			textFieldTimeOut.setColumns(10);
			textFieldTimeOut.setBounds(583, 458, 189, 26);
			frame.getContentPane().add(textFieldTimeOut);
			
			btnPositive.setFont(txtFont);
			btnPositive.setBackground(new Color(49,50,111));
			btnPositive.setForeground(Color.white);
			btnPositive.setFocusable(false);
			btnPositive.setBounds(457, 497, 218, 48);
			btnPositive.addActionListener(this);
			frame.getContentPane().add(btnPositive);
			
			btnAdd.setFont(txtFont);
			btnAdd.setBackground(new Color(49,50,111));
			btnAdd.setForeground(Color.white);
			btnAdd.setBounds(678, 497, 94, 48);
			btnAdd.setFocusable(false);
			frame.getContentPane().add(btnAdd);
			btnAdd.addActionListener(this);
			
			btnLogOut.setFont(new Font("Britannic Bold", Font.BOLD, 12));
			btnLogOut.setBackground(new Color(49,50,111));
			btnLogOut.setForeground(Color.white);
			btnLogOut.setBounds(762, 11, 89, 23);
			btnLogOut.setFocusable(false);
			frame.getContentPane().add(btnLogOut);
			btnLogOut.addActionListener(this);
			
			JLabel lblHeader = new JLabel("");
			ImageIcon img = new ImageIcon("header.png");
			lblHeader.setIcon(img);
			lblHeader.setBounds(33, 11, 818, 80);
			frame.getContentPane().add(lblHeader);
			
			//Object[] row = new Object[4];
			frame.setVisible(true);
			}

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAdd) {
					
					Object[] row = new Object[4];
					
					row[0] = textFieldDate.getText();
					row[1] = textFieldTimeIn.getText();
					row[2] = textFieldTimeOut.getText();
					row[3] = comboBoxLocation.getSelectedItem();
					
					int i = JOptionPane.showConfirmDialog (
							null, 
							"Day: " + row[0] + "\nLoc:" + row[3] + "\nIn:" + row[1] + "\nOut:" + row[2], 
							"Confirmation Message", 
							JOptionPane.OK_CANCEL_OPTION);
					
					if(i == 0) {
						model.addRow(row);
						
						textFieldDate.setText("");
						textFieldTimeIn.setText("");
						textFieldTimeOut.setText("");
						comboBoxLocation.setSelectedIndex(0);
						}
				}
				else if(e.getSource() == btnLogOut) {
					frame.dispose();
					new HomePage();
				}
				else if(e.getSource() == btnPositive) {
					int i = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirmation Message", JOptionPane.YES_NO_OPTION);
					if(i == 0) {
						// gawin yung algo ng positive
						System.out.println("positive!");
					}
				}
			}
	}

