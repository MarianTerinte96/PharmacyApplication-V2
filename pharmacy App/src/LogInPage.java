import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;
import javax.swing.JPasswordField;

public class LogInPage {

	private static JFrame frame;
	private JTextField userTxt;
	private JPasswordField passwordField;
	private static String userName;
	private static String password;
	
	
	

	public static JFrame getFrame() {
		return frame;
	}

	public JTextField getUserTxt() {
		return userTxt;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public static void setFrame(JFrame frame) {
		LogInPage.frame = frame;
	}

	public void setUserTxt(JTextField userTxt) {
		this.userTxt = userTxt;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInPage window = new LogInPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 919, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String userName = userTxt.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				LogInPage.userName = userName;
				LogInPage.password = password;
				logIn(userName,password);
			
			}	
		});
		

		userTxt = new JTextField();
		userTxt.setColumns(10);
		
		JLabel lblFirstName = new JLabel("User Name");
		
		JLabel lblLastName = new JLabel("User Password");
		
		JLabel lblNewLabel = new JLabel("Please sign in!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(282, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(userTxt, Alignment.LEADING)
									.addComponent(btnLogIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
									.addComponent(passwordField, Alignment.LEADING)))
							.addGap(301))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(userTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(btnLogIn)
					.addGap(144))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	
	private static void logIn(String userName, String password) {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
			
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM useri where userName = ? and userPassword = ? ");
			stmt.setString(1,userName);
			stmt.setString(2,password);
			
			
			
			ResultSet res = stmt.executeQuery();
			//int activecheck = 0;
			
			if(res.next()) {
				
				//int active = res.getInt("activeSession");
				String type = res.getString("userType");
				if(type.equalsIgnoreCase("admin") || type.equalsIgnoreCase("Admin")) {
					JOptionPane.showMessageDialog(null, "Log in successful");
					
					PreparedStatement statement = (PreparedStatement) con.prepareStatement("update useri set activeSession = 1 where userName = '" + userName + "' ");
					
					statement.executeUpdate();
					
					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date date = new Date(System.currentTimeMillis());
					
					FileWriter myWriter = new FileWriter("C:\\Users\\Marian Prime\\Desktop\\Java\\FarmacyApp\\User input\\UserLogIndata.txt",true);
					myWriter.write("Admin " + userName + " has logged in at :" + formatter.format(date) + "\r");
					
					myWriter.close();
					AdminControlsPage adminpage = new AdminControlsPage();
					adminpage.getFrame().setVisible(true);
					frame.setVisible(false);
					
					
					
				
				}
				else if(type.equalsIgnoreCase("user")) {
					JOptionPane.showMessageDialog(null, "Log in successful");
					FileWriter myWriter = new FileWriter("C:\\Users\\Marian Prime\\Desktop\\Java\\FarmacyApp\\User input\\UserLogIndata.txt", true);
					
					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
					Date date = new Date(System.currentTimeMillis());
					
					myWriter.write("User " + userName + " has logged in at :" + formatter.format(date) + "\r");
					myWriter.close();
					UserControlPage userPage = new UserControlPage();
					userPage.getFrame().setVisible(true);
					frame.setVisible(false);
					
				}
				 
			}
			
			else {
				
				JOptionPane.showMessageDialog(null,"Log in failed, try again");
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Log in failed, please try again!");
			
		}
		
	}
}
