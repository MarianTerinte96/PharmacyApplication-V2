import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.sql.Connection;
import java.sql.*;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ListSelectionModel;

public class AdminControlsPage {

	private JFrame frmApp;
	private JTextField textField;
	private static JTable prodTBL;
	private static JTable userTable;
	private JTextField textField_1;
	private static JTable productTable;
	private JTextField searchTXT;
	private JTextField txtProductName;
	private JTextField txtQuantity;
	private JTextField removeTXT;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JTextField txtPrice;
	private JTable table_1;
	private JTextField textField_2;
	private static JLabel welcomeLbl;
	private JTextField usrNameTXT;
	private JPasswordField passwordField;
	private JTextField usrTypeTXT;
	private JTextField textField_9;
	private JTextField usrEmail;
	private JTextField userAddress;
	private static JTable tableUser1;

	public JPanel getTab1() {
		return tab1;
	}

	public JLabel getWelcomeLbl() {
		return welcomeLbl;
	}

	public void setWelcomeLbl(JLabel welcomeLbl) {
		this.welcomeLbl = welcomeLbl;
	}

	public void setTab1(JPanel tab1) {
		this.tab1 = tab1;
	}

	public JPanel getTab2() {
		return tab2;
	}

	public void setTab2(JPanel tab2) {
		this.tab2 = tab2;
	}

	public JPanel getTab3() {
		return tab3;
	}

	public void setTab3(JPanel tab3) {
		this.tab3 = tab3;
	}

	public JFrame getFrame() {
		return frmApp;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTable getTable() {
		return prodTBL;
	}

	public JTable getTable_1() {
		return userTable;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}



	public JTable getTable_2() {
		return productTable;
	}

	public JTextField getTextField_4() {
		return searchTXT;
	}

	public JTextField getTextField_5() {
		return txtProductName;
	}

	public JTextField getTextField_6() {
		return txtQuantity;
	}

	public JTextField getTextField_7() {
		return removeTXT;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlsPage window = new AdminControlsPage();
					window.frmApp.setVisible(true);
					//welcomeLabel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public AdminControlsPage() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
		welcomeLabel();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frmApp = new JFrame();
		frmApp.setResizable(false);
		frmApp.setTitle("App");
		frmApp.setBounds(100, 100, 1022, 513);
		frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setForeground(new Color(112, 128, 144));
		splitPane.setBorder(null);
		splitPane.setBackground(new Color(112, 128, 144));
		splitPane.setResizeWeight(0.3);
		frmApp.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		splitPane.setRightComponent(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(112, 128, 144));
		panel_2.setBackground(new Color(112, 128, 144));
		panel_2.setBounds(0, 0, 699, 32);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 5, 699, 467);
		panel.add(tabbedPane);

		JPanel BuyProducts = new JPanel();
		tabbedPane.addTab("New tab", null, BuyProducts, null);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textField.getText();
				
				getMarketProduct(name);
			}
		});
		btnNewButton_2.setBounds(248, 86, 220, 30);

		textField = new JTextField();
		textField.setBounds(248, 57, 220, 20);
		textField.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(-10316, -10062, 0, 0);
		BuyProducts.setLayout(null);
		BuyProducts.add(btnNewButton_2);
		BuyProducts.add(textField);
		BuyProducts.add(label);

		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(248, 21, 220, 25);
		BuyProducts.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Results");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(54, 182, 86, 14);
		BuyProducts.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Add to cart!");
		btnNewButton_3.setBounds(248, 126, 220, 30);
		BuyProducts.add(btnNewButton_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(54, 203, 640, 225);
		BuyProducts.add(scrollPane_2);
		
				prodTBL = new JTable();
				scrollPane_2.setViewportView(prodTBL);

		JPanel Products = new JPanel();
		tabbedPane.addTab("New tab", null, Products, null);
		Products.setLayout(null);

		JButton searchBTN = new JButton("Search Product");
		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = searchTXT.getText();
				searchProducts(name);

			}
		});
		searchBTN.setBounds(245, 71, 181, 23);
		Products.add(searchBTN);

		searchTXT = new JTextField();
		searchTXT.setBounds(245, 40, 181, 20);
		Products.add(searchTXT);
		searchTXT.setColumns(10);

		txtProductName = new JTextField();
		txtProductName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtProductName.setText("");
			}
		});
		txtProductName.setBounds(41, 88, 123, 20);
		Products.add(txtProductName);
		txtProductName.setColumns(10);

		JButton addBTN = new JButton("Add");

		addBTN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String name = txtProductName.getText();
				double price = Double.parseDouble(txtPrice.getText());
				int quantity = Integer.parseInt(txtQuantity.getText());

				addProducts(name, price, quantity);

				txtQuantity.setText("");
				txtProductName.setText("");
				txtPrice.setText("");
			}
		});

		addBTN.setBounds(42, 207, 122, 23);
		Products.add(addBTN);

		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtQuantity.setText("");
			}
		});
		txtQuantity.setBounds(42, 176, 123, 20);
		Products.add(txtQuantity);
		txtQuantity.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Product Name");
		lblNewLabel_5.setBounds(41, 75, 112, 14);
		Products.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setBounds(41, 161, 72, 14);
		Products.add(lblNewLabel_6);

		removeTXT = new JTextField();
		removeTXT.setBounds(494, 120, 123, 20);
		Products.add(removeTXT);
		removeTXT.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Product Name");
		lblNewLabel_7.setBounds(494, 104, 123, 14);
		Products.add(lblNewLabel_7);

		JButton removeBTN = new JButton("Remove");
		removeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = removeTXT.getText();
				removeProduct(name);

			}
		});
		removeBTN.setBounds(494, 161, 123, 23);
		Products.add(removeBTN);

		JLabel lblNewLabel_8 = new JLabel("Products");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(309, 220, 81, 14);
		Products.add(lblNewLabel_8);

		txtPrice = new JTextField();
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPrice.setText("");
			}
		});
		txtPrice.setBounds(42, 134, 123, 20);
		Products.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Price");
		lblNewLabel_9.setBounds(41, 119, 46, 14);
		Products.add(lblNewLabel_9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		scrollPane.setBounds(10, 247, 694, 181);
		Products.add(scrollPane);

		productTable = new JTable();
		productTable.setEditingColumn(0);
		productTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		productTable.setColumnSelectionAllowed(true);
		productTable.setCellSelectionEnabled(true);
		productTable.setGridColor(Color.BLACK);
		productTable.setForeground(Color.WHITE);
		productTable.setBackground(new Color(112, 128, 144));
		scrollPane.setViewportView(productTable);

		JPanel Users = new JPanel();
		tabbedPane.addTab("New tab", null, Users, null);
		Users.setLayout(null);

		JButton btnNewButton_4 = new JButton("Search User");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_1.getText();
				
				searchUser(name);
				
			}
			
		});
		
		btnNewButton_4.setBounds(215, 11, 227, 23);
		Users.add(btnNewButton_4);

		textField_1 = new JTextField();
		textField_1.setBounds(215, 46, 227, 20);
		Users.add(textField_1);
		textField_1.setColumns(10);

		JButton addUserBtn = new JButton("Add Users");
		addUserBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		  addUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * String name = userNameTxt.getText();
				 * 
				 * @SuppressWarnings("deprecation") String password = userPassTxT.getText();
				 * 
				 * @SuppressWarnings("deprecation") String userTy = userType.getText();
				 * 
				 * 
				 * if(userTy.equals("admin")||userTy.equals("Admin")||userTy.equals("user")||
				 * userTy.equals("User")) {
				 * 
				 * addUser(name, password, userTy); } else {
				 * 
				 * JOptionPane.showMessageDialog(null, "Wrong user type"); }
				 * 
				 * userNameTxt.setText(""); userPassTxT.setText(""); userType.setText("");
				 */
				
				fillTable();
				tabbedPane.setSelectedIndex(4);
				
				
		  }});
		 

		addUserBtn.setBounds(52, 236, 175, 37);
		Users.add(addUserBtn);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(52, 77, 585, 122);
		Users.add(scrollPane_1);

		userTable = new JTable();
		scrollPane_1.setViewportView(userTable);
		
		JButton btnRemoveUsers = new JButton("Remove Users");
		btnRemoveUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnRemoveUsers.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemoveUsers.setBounds(469, 236, 168, 37);
		Users.add(btnRemoveUsers);
		
		JPanel Account = new JPanel();
		tabbedPane.addTab("New tab", null, Account, null);
		Account.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 47, 674, 154);
		Account.add(scrollPane_3);
		
		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		
		JLabel lblNewLabel_10 = new JLabel("My Orders");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(283, 11, 99, 25);
		Account.add(lblNewLabel_10);
		
		JButton btnBuy = new JButton("Buy!");
		btnBuy.setBounds(10, 212, 89, 23);
		Account.add(btnBuy);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.setBounds(509, 278, 89, 23);
		Account.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(509, 245, 149, 20);
		Account.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Product to remove");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setBounds(509, 221, 149, 14);
		Account.add(lblNewLabel_11);
		
		JPanel AddUsersPanel = new JPanel();
		AddUsersPanel.setLayout(null);
		tabbedPane.addTab("New tab", null, AddUsersPanel, null);
		
		JButton addUserBtn_1 = new JButton("Add User");
		addUserBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName = usrNameTXT.getText();
				String userPassword =String.valueOf(passwordField.getPassword());
				String userType = usrTypeTXT.getText();
				String userEmail = usrEmail.getText();
				String userAddr = userAddress.getText();
				
				addUser(userName, userPassword, userType, userEmail, userAddr);
				
				usrNameTXT.setText("");
				passwordField.setText("");
				usrTypeTXT.setText("");
				usrEmail.setText("");
				userAddress.setText("");
				
				fillTable();
				
			}
		});
		addUserBtn_1.setBounds(250, 42, 187, 23);
		AddUsersPanel.add(addUserBtn_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("User Name");
		lblNewLabel_2_1.setBounds(58, 76, 110, 14);
		AddUsersPanel.add(lblNewLabel_2_1);
		
		usrNameTXT = new JTextField();
		usrNameTXT.setColumns(10);
		usrNameTXT.setBounds(58, 93, 177, 20);
		AddUsersPanel.add(usrNameTXT);
		
		JLabel lblNewLabel_4_2 = new JLabel("User Password");
		lblNewLabel_4_2.setBounds(58, 124, 110, 14);
		AddUsersPanel.add(lblNewLabel_4_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(58, 141, 177, 20);
		AddUsersPanel.add(passwordField);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(70, 252, 585, 122);
		AddUsersPanel.add(scrollPane_1_1);
		
		tableUser1 = new JTable();
		scrollPane_1_1.setViewportView(tableUser1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("User Type");
		lblNewLabel_4_1_1.setBounds(58, 172, 110, 14);
		AddUsersPanel.add(lblNewLabel_4_1_1);
		
		usrTypeTXT = new JTextField();
		usrTypeTXT.setColumns(10);
		usrTypeTXT.setBounds(58, 187, 177, 20);
		AddUsersPanel.add(usrTypeTXT);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					fillTable();
				}
		});
		btnNewButton_1.setBounds(260, 220, 177, 23);
		AddUsersPanel.add(btnNewButton_1);
		
		usrEmail = new JTextField();
		usrEmail.setBounds(455, 93, 177, 20);
		AddUsersPanel.add(usrEmail);
		usrEmail.setColumns(10);
		
		userAddress = new JTextField();
		userAddress.setBounds(455, 141, 177, 20);
		AddUsersPanel.add(userAddress);
		userAddress.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address");
		lblNewLabel_2.setBounds(455, 76, 74, 14);
		AddUsersPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User address");
		lblNewLabel_3.setBounds(455, 124, 74, 14);
		AddUsersPanel.add(lblNewLabel_3);
		
		JPanel RemoveUsersPanel = new JPanel();
		RemoveUsersPanel.setLayout(null);
		tabbedPane.addTab("New tab", null, RemoveUsersPanel, null);
		
		JButton removeUserBtn_1_1 = new JButton("Remove User");
		removeUserBtn_1_1.setBackground(new Color(112, 128, 144));
		removeUserBtn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		removeUserBtn_1_1.setBounds(196, 102, 255, 23);
		RemoveUsersPanel.add(removeUserBtn_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("User Name");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(253, 46, 110, 14);
		RemoveUsersPanel.add(lblNewLabel_3_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(196, 71, 255, 20);
		RemoveUsersPanel.add(textField_9);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBackground(new Color(112, 128, 144));
		scrollPane_1_1_1.setBounds(31, 227, 576, 107);
		RemoveUsersPanel.add(scrollPane_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(112, 128, 144));
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(null);

		JButton usersBTN = new JButton("Manage Users");
		usersBTN.setFont(new Font("Arial", Font.BOLD, 13));
		usersBTN.setBorder(null);
		usersBTN.setBackground(new Color(112, 128, 144));
		usersBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
				fillUsersTable();
			}
		});
		usersBTN.setBounds(59, 188, 199, 34);
		panel_1.add(usersBTN);

		JButton btnBrowseProducts = new JButton("Browse Products");
		btnBrowseProducts.setBorderPainted(false);
		btnBrowseProducts.setBorder(null);
		btnBrowseProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnBrowseProducts.setIcon(null);
		btnBrowseProducts.setForeground(new Color(0, 0, 0));
		btnBrowseProducts.setFont(new Font("Arial", Font.BOLD, 13));
		btnBrowseProducts.setBackground(new Color(112, 128, 144));
		btnBrowseProducts.setBounds(59, 59, 199, 34);
		panel_1.add(btnBrowseProducts);

		JButton btnNewButton_1_1 = new JButton("Manage Products");
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setBackground(new Color(112, 128, 144));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				fillProductTable();
			}
		});
		btnNewButton_1_1.setBounds(59, 124, 199, 34);
		panel_1.add(btnNewButton_1_1);
		
		JButton myAccount = new JButton("My Account");
		myAccount.setFont(new Font("Arial", Font.BOLD, 13));
		myAccount.setBackground(new Color(112, 128, 144));
		myAccount.setBorder(null);
		myAccount.setBounds(59, 248, 199, 34);
		panel_1.add(myAccount);
		
		JButton myOrdersBtn = new JButton("My orders");
		myOrdersBtn.setFont(new Font("Arial", Font.BOLD, 13));
		myOrdersBtn.setBackground(new Color(112, 128, 144));
		myOrdersBtn.setBorder(null);
		myOrdersBtn.setBounds(59, 311, 199, 34);
		panel_1.add(myOrdersBtn);
		
		JLabel welcomeLbl = new JLabel("");
		
		welcomeLbl.setLabelFor(panel_1);
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setBounds(59, 26, 165, 23);
		panel_1.add(welcomeLbl);
		welcomeLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		welcomeLbl.setForeground(Color.WHITE);
	}

	public static void addProducts(String name, double price, int quantity) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			// Statement stmt=con.createStatement();

			String query = "insert into produse (numeProdus , pret, cantitateStock)" + "values (?, ?, ?)"; // facem
																											// query cu
																											// insert
																											// statement

			// facem un mysql insert preparedstatement

			PreparedStatement prepStmt = con.prepareStatement(query);

			prepStmt.setString(1, name);
			prepStmt.setDouble(2, price);
			prepStmt.setInt(3, quantity);

			// acum executam statementul

			prepStmt.execute();

			// inchidem conexiunea

			con.close();
			JOptionPane.showMessageDialog(null, " data has been added ");
		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Aplication error! Please check database connection");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void searchProducts(String name) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			System.out.println("name is " + name);
			if (name.isEmpty()) {

				PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM produse");

				DefaultTableModel table1 = new DefaultTableModel();
				table1.addColumn("Product name");
				table1.addColumn("Product Price");
				table1.addColumn("Quantity");
				table1.addColumn("Information");

				ResultSet result2 = stmt2.executeQuery();
				while (result2.next()) {

					System.out.println(result2.getInt(1) + " " + result2.getString("numeProdus") + " "
							+ result2.getString("informatii"));

					Object[] row1 = new Object[4];
					row1[0] = result2.getString("numeProdus");
					row1[1] = result2.getDouble("pret");
					row1[2] = result2.getInt("cantitateStock");
					row1[3] = result2.getString("informatii");

					table1.addRow(row1);

					productTable.setModel(table1);

				}

			} else {
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM produse where numeProdus = ?");

				stmt.setString(1, name);

				DefaultTableModel table = new DefaultTableModel();
				table.addColumn("Product name");
				table.addColumn("Product Price");
				table.addColumn("Quantity");
				table.addColumn("Information");

				ResultSet result = stmt.executeQuery();

				if (result.next()) {

					System.out.println(result.getInt(1) + " " + result.getString("numeProdus") + " "
							+ result.getString("informatii"));

					Object[] row = new Object[4];
					row[0] = result.getString("numeProdus");
					row[1] = result.getDouble("pret");
					row[2] = result.getInt("cantitateStock");
					row[3] = result.getString("informatii");

					table.addRow(row);
				} else {
					JOptionPane.showMessageDialog(null, "Name not found", "Error", 1);
				}

				productTable.setModel(table);

			}
		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Aplication error! Please check database connection ");
		}

	}

	public static void fillProductTable() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM produse");

			DefaultTableModel table = new DefaultTableModel();
			table.addColumn("Product name");
			table.addColumn("Product Price");
			table.addColumn("Quantity");
			table.addColumn("Information");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				System.out.println(
						result.getInt(1) + " " + result.getString("numeProdus") + " " + result.getString("informatii"));

				Object[] row = new Object[4];
				row[0] = result.getString("numeProdus");
				row[1] = result.getDouble("pret");
				row[2] = result.getInt("cantitateStock");
				row[3] = result.getString("informatii");

				table.addRow(row);
			}
			/*
			 * else { JOptionPane.showMessageDialog(null, "Database Table error!",
			 * "Table Error", 1); }
			 */

			productTable.setModel(table);
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, " Database Table error! ");

		}

	}

	public static void removeProduct(String name) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			PreparedStatement stmt = con.prepareStatement("DELETE FROM produse WHERE numeProdus = ?");
			stmt.setString(1, name);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Information removed");

		}

		catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error!!");

		}
	}

	public static void fillUsersTable() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM useri");

			DefaultTableModel tbl = new DefaultTableModel();
			tbl.addColumn("User Name");
			tbl.addColumn("User Password");
			tbl.addColumn("User Type");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				System.out
						.println(result.getInt(1) + result.getString("userName") + " " + result.getString("userType"));

				Object[] row = new Object[4];

				row[0] = result.getString("userName");
				row[1] = result.getString("userPassword");
				row[2] = result.getString("userType");

				tbl.addRow(row);

			}

			userTable.setModel(tbl);
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error");

		}

	}
	
	public static void fillTable() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM useri");

			DefaultTableModel tbl = new DefaultTableModel();
			tbl.addColumn("User Name");
			tbl.addColumn("User Password");
			tbl.addColumn("User Type");
			tbl.addColumn("User Address");
			tbl.addColumn("User Email");

			ResultSet result = stmt.executeQuery();

			while (result.next()) {

				System.out
						.println(result.getInt(1) + result.getString("userName") + " " + result.getString("userEmail"));

				Object[] row = new Object[6];

				row[0] = result.getString("userName");
				row[1] = result.getString("userPassword");
				row[2] = result.getString("userType");
				row[3] = result.getString("userAddress");
				row[4] = result.getString("userEmail");

				tbl.addRow(row);

			}

			tableUser1.setModel(tbl);
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error");

		}
		
		
	}
	
	
	

	public static void addUser(String name, String password, String userType, String userAddress, String userEmail) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");

			PreparedStatement stmt = con
					.prepareStatement("insert into useri (userName, userPassword, userType, userAddress, userEmail)" + "values(?, ?, ?, ?, ?)");

			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, userType);
			stmt.setString(4, userAddress);
			stmt.setString(5, userEmail);

			stmt.execute();

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error");

		}
	}
	
	public static void removeUser(String name) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
			
			PreparedStatement statement = con.prepareStatement("DELETE FROM useri WHERE userName = ? ");
			statement.setString(1, name);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, (name + " has been removed ") );
	
		}
		catch(Exception e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "DATABASE ERROR!");
		}
	}
	
	public static void searchUser(String name) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
		
			
			if(name.isEmpty()) {
				PreparedStatement stmt = con.prepareStatement("select * from useri ");
			
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("User Name");
				table.addColumn("User Password");
				table.addColumn("User Type");
				
				ResultSet res = stmt.executeQuery();
				
				while(res.next()) {
					
					Object[] row = new Object[4];
					
					row[0] = res.getString("userName");
					row[1] = res.getString("userPassword");
					row[2] = res.getString("userType");
				
					table.addRow(row);
					
				}
				userTable.setModel(table);
				
			}
			else {
			PreparedStatement stmt = con.prepareStatement("select * from useri where userName = ?");
			stmt.setString(1, name);
			
			DefaultTableModel table = new DefaultTableModel();
			
			table.addColumn("User Name");
			table.addColumn("User Password");
			table.addColumn("User Type");
			
			
			ResultSet res = stmt.executeQuery();
			
			
			if(res.next()) {
				
				Object[] row = new Object[4];
				
				row[0] = res.getString("userName");
				row[1] = res.getString("userPassword");
				row[2] = res.getString("userType");
				
				
				table.addRow(row);
				
				
			}
			userTable.setModel(table);
			con.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error");
		}
	
	}
	
	public static void getMarketProduct(String name){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM produse where numeProdus = ?");
			stmt.setString(1, name);
			
			DefaultTableModel table = new DefaultTableModel();
			
			table.addColumn(" Product Name ");
			table.addColumn(" Product Price ");
			table.addColumn(" Stock Units ");
			table.addColumn(" Information ");
			
			ResultSet res = stmt.executeQuery();
			
			if(res.next()){
				
				Object[] row = new Object[4];
				
				row[0] = res.getString("numeProdus");
				row[1] = res.getDouble("pret");
				row[2] = res.getInt("cantitateStock");
				row[3] = res.getString("informatii");
				
				
				table.addRow(row);
			}
			prodTBL.setModel(table);
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Error");
			
		}
	}
	
	public static void welcomeLabel() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacydb", "root", "root");
			
			String query = "Select * from useri where activeSession = 1";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet res = stmt.executeQuery();
			
					if(res.next()) {
						System.out.println(res.getString("userName"));
						welcomeLbl = new JLabel("");
						System.out.println("test test");
						welcomeLbl.setText("Welcome " + res.getString("userName"));
						welcomeLbl.setVisible(true);
					}
			
			con.close();
			
		   }
		catch(Exception e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database connection error");
			
		}
		
	}
}
