import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class UserControlPage {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTable table_1;
	
	
	

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTable getTable_1() {
		return table_1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserControlPage window = new UserControlPage();
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
	public UserControlPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1178, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		frame.getContentPane().add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 36, 924, 545);
		panel.add(tabbedPane);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("New tab", null, tab1, null);
		tab1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(361, 51, 150, 23);
		tab1.add(btnNewButton_2);
		
		table = new JTable();
		table.setBounds(37, 172, 843, 318);
		tab1.add(table);
		
		textField = new JTextField();
		textField.setBounds(361, 20, 150, 20);
		tab1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buy!");
		btnNewButton_3.setBounds(361, 85, 150, 23);
		tab1.add(btnNewButton_3);
		
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("New tab", null, tab2, null);
		tab2.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Uptate Info");
		btnNewButton_4.setBounds(40, 78, 194, 44);
		tab2.add(btnNewButton_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(40, 148, 194, 44);
		tab2.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 216, 194, 44);
		tab2.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New User Name");
		lblNewLabel.setBounds(40, 133, 77, 14);
		tab2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setBounds(40, 204, 77, 14);
		tab2.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setBounds(441, 65, 454, 198);
		tab2.add(table_1);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy Product");
		btnNewButton.setBounds(27, 133, 170, 55);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Account");
		btnNewButton_1.setBounds(27, 316, 170, 55);
		panel_1.add(btnNewButton_1);
	}

}
