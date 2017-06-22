import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CalcWindow {

	private JFrame frame;
	private JTextField inputAddressField;
	private JTextField inputMaskField;
	private JTextField txtMask;
	private JTextField txtNetworkAddress;
	private JTextField txtBroadcastAddress;
	private String subnetMask;
	private String inputAddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtCidr;
	private JTextField txtAmountOfHosts;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtAddress;
	private String aboutProgram = "Description: Simple Subnet calculator. \nTakes IP address and subnet mask as an input and provides you with \n" +
								  "infromation about subnet address, broadcast address, CIDR and maximum amount of hosts. \n"+
								  "Author: Kacper Koryluk \n" +
								  "Date: 22.06.2017 \n";
								  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcWindow window = new CalcWindow();
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
	public CalcWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputAddressField = new JTextField();
		inputAddressField.setBounds(166, 11, 136, 20);
		frame.getContentPane().add(inputAddressField);
		inputAddressField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				subnetMask=inputMaskField.getText().trim();
				inputAddress=inputAddressField.getText().trim();
				
				try
				{
				textField.setText(Methods.calculateSubnetAddress(inputAddress, subnetMask));
				textField_1.setText(Methods.calculateBroadcastAddress(Methods.calculateSubnetAddress(inputAddress, subnetMask), subnetMask));
				textField_2.setText("/"+Methods.getCIDR(subnetMask));
				textField_3.setText(Methods.amountOfHosts(Methods.getCIDR(subnetMask)));
				}catch(Exception e)
				{
					textField.setText("Invalid input!");
					textField_1.setText("Invalid input!");
					textField_2.setText("Invalid input!");
					textField_3.setText("Invalid input!");
				}
				
			}
		});
		btnNewButton.setBounds(10, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		inputMaskField = new JTextField();
		inputMaskField.setColumns(10);
		inputMaskField.setBounds(166, 40, 136, 20);
		frame.getContentPane().add(inputMaskField);
		
		txtMask = new JTextField();
		txtMask.setHorizontalAlignment(SwingConstants.LEFT);
		txtMask.setEditable(false);
		txtMask.setText("Subnet Mask");
		txtMask.setBounds(10, 40, 146, 20);
		frame.getContentPane().add(txtMask);
		txtMask.setColumns(10);
		
		txtNetworkAddress = new JTextField();
		txtNetworkAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtNetworkAddress.setForeground(Color.BLACK);
		txtNetworkAddress.setText("Network Address");
		txtNetworkAddress.setEditable(false);
		txtNetworkAddress.setBounds(10, 109, 109, 20);
		frame.getContentPane().add(txtNetworkAddress);
		txtNetworkAddress.setColumns(10);
		
		txtBroadcastAddress = new JTextField();
		txtBroadcastAddress.setForeground(Color.BLACK);
		txtBroadcastAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtBroadcastAddress.setText("Broadcast Address");
		txtBroadcastAddress.setEditable(false);
		txtBroadcastAddress.setColumns(10);
		txtBroadcastAddress.setBounds(10, 137, 109, 20);
		frame.getContentPane().add(txtBroadcastAddress);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(129, 109, 173, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.BLACK);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(129, 137, 173, 20);
		frame.getContentPane().add(textField_1);
		
		txtCidr = new JTextField();
		txtCidr.setText("CIDR");
		txtCidr.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidr.setForeground(Color.BLACK);
		txtCidr.setEditable(false);
		txtCidr.setColumns(10);
		txtCidr.setBounds(10, 168, 109, 20);
		frame.getContentPane().add(txtCidr);
		
		txtAmountOfHosts = new JTextField();
		txtAmountOfHosts.setText("Amount of hosts");
		txtAmountOfHosts.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmountOfHosts.setForeground(Color.BLACK);
		txtAmountOfHosts.setEditable(false);
		txtAmountOfHosts.setColumns(10);
		txtAmountOfHosts.setBounds(10, 199, 109, 20);
		frame.getContentPane().add(txtAmountOfHosts);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.BLACK);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(129, 168, 173, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.BLACK);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(129, 199, 173, 20);
		frame.getContentPane().add(textField_3);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setHorizontalAlignment(SwingConstants.LEFT);
		txtAddress.setEditable(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(10, 11, 146, 20);
		frame.getContentPane().add(txtAddress);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, aboutProgram);
			}
		});
		mnHelp.add(mntmAbout);
	}
}
