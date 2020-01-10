package four;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import database.Database;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateMaterial {
	static JFrame frame;
	public static int row;
	
	public static JLabel productCurrentName;
	public static JLabel productCurrentPrice;
	public static JLabel productCurrentType;
	private static JTextField txtNewName;
	private static JTextField txtNewPrice;
	private static String name, type, price;
	private static JComboBox cmbNewType;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void Initialize(String row) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(580, 500);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblCurrentName = new JLabel("Current Name:..........................................");
		lblCurrentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentName.setBounds(80, 52, 184, 15);
		frame.getContentPane().add(lblCurrentName);
		
		JLabel lblCurrentType = new JLabel("Current Type:..................................");
		lblCurrentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentType.setBounds(80, 88, 184, 19);
		frame.getContentPane().add(lblCurrentType);
		
		JLabel lblCurrentPrice = new JLabel("Current Price:.........................................");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentPrice.setBounds(80, 128, 184, 15);
		frame.getContentPane().add(lblCurrentPrice);
		
		productCurrentName = new JLabel("");
		productCurrentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productCurrentName.setBounds(274, 54, 170, 15);
		frame.getContentPane().add(productCurrentName);
		
		productCurrentPrice = new JLabel("");
		productCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productCurrentPrice.setBounds(274, 130, 170, 15);
		frame.getContentPane().add(productCurrentPrice);
		
		productCurrentType = new JLabel("");
		productCurrentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productCurrentType.setBounds(274, 93, 170, 15);
		frame.getContentPane().add(productCurrentType);
		frame.setVisible(true);
		
		
		String info = Database.LoadMatInfo(row);
		
		int index1 = info.indexOf(".");
		name = info.substring(0, index1);
		int index2 = info.indexOf("$");
		type = info.substring(index1+1,index2);
		price = info.substring(index2);
		
		productCurrentName.setText(name);
		productCurrentPrice.setText(price);
		productCurrentType.setText(type);
		
		JLabel newName = new JLabel("New Name:..........................................");
		newName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newName.setBounds(80, 234, 184, 15);
		frame.getContentPane().add(newName);
		
		JLabel newType = new JLabel("New Type:..................................");
		newType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newType.setBounds(80, 270, 184, 19);
		frame.getContentPane().add(newType);
		
		JLabel newPrice = new JLabel("New Price:.........................................");
		newPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newPrice.setBounds(80, 310, 184, 15);
		frame.getContentPane().add(newPrice);
		
		txtNewName = new JTextField();
		txtNewName.setBounds(274, 234, 170, 19);
		frame.getContentPane().add(txtNewName);
		txtNewName.setColumns(10);
		
		txtNewPrice = new JTextField();
		txtNewPrice.setBounds(274, 310, 170, 19);
		frame.getContentPane().add(txtNewPrice);
		txtNewPrice.setColumns(10);
		
		cmbNewType = new JComboBox();
		cmbNewType.setModel(new DefaultComboBoxModel(new String[] {"----Current----", "Chiffon", "Cosmo", "Cracked Ice", "Fring", "Georgette", "Hologram", "Lace", "Lycra", "Mesh", "Mystique", "Organdy", "Sequin", "Trim", "Velvet"}));
		cmbNewType.setBounds(274, 271, 170, 21);
		frame.getContentPane().add(cmbNewType);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean accept = true;
				
				name = txtNewName.getText();					
				type = cmbNewType.getSelectedItem()+"";				
				price = txtNewPrice.getText();
				
				if(name.equals("")) {
					name = productCurrentName.getText();
				}
				if(type.equals("----Current----")) {
					type = productCurrentType.getText();
				}
				if(price.equals("")) {
					price = productCurrentPrice.getText();
				}else {
					try {
						double cost = Double.parseDouble(price);
					} catch (NumberFormatException e1) {
						accept = false;
						JOptionPane.showMessageDialog(null,  "Put a number into \"New Price\"", "Error",JOptionPane.ERROR_MESSAGE);
						txtNewPrice.setText("");
						txtNewPrice.setBorder(new LineBorder(Color.red,1));

					}
				}
				if(name == null && type == null && price == null) {
					
				}
				
				
				if(accept) {
					String sentence = name + "." + type + "$" + price;
					int success = Database.UpdateMaterial(sentence, row);
					
					
					if(success == 0) {
						frame.dispose();
					}
				}
			}
		});
		btnSave.setBounds(210, 385, 80, 21);
		frame.getContentPane().add(btnSave);
		
		JLabel lblleaveTheField = new JLabel("*Leave the field empty if you doesn't want to change it");
		lblleaveTheField.setBounds(118, 335, 338, 13);
		frame.getContentPane().add(lblleaveTheField);
		
		
		
	}
}
