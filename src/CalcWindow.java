import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CalcWindow {

	private JFrame frame;
	private JTextField inputAddressField;
	private JTextField inputMaskField;
	private JTextField txtMask;
	private JTextField txtNetworkAddress;
	private JTextField txtBroadcastAddress;

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
		btnNewButton.setBounds(10, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		String[] comboBoxChoices = { "Subnet Address", "Regular Address"};
		JComboBox comboBox = new JComboBox(comboBoxChoices);
		comboBox.setBounds(10, 11, 146, 20);
		frame.getContentPane().add(comboBox);
		
		JTextArea networkAddressField = new JTextArea();
		networkAddressField.setEditable(false);
		networkAddressField.setBounds(125, 109, 140, 20);
		frame.getContentPane().add(networkAddressField);
		
		JTextArea broadcastAddressField = new JTextArea();
		broadcastAddressField.setEditable(false);
		broadcastAddressField.setBounds(125, 140, 140, 20);
		frame.getContentPane().add(broadcastAddressField);
		
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	}
}
