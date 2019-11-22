package four;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class UpdateMaterial {
	static JFrame frame;
	public static int row;
	
	public static JLabel productCurrentName;
	public static JLabel productCurrentPrice;
	public static JLabel productCurrentType;
	
	public static void main(String[] args) {
		
		try {
			UpdateMaterial window = new UpdateMaterial(row);
			window.frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UpdateMaterial(int id) {
		row = id;
		Initialize();
		
		productCurrentName.setText("aa");
		productCurrentType.setText("");
		productCurrentPrice.setText("CCCCC");
	}
	
	public static void Initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(576, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentName = new JLabel("Current Name:");
		lblCurrentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentName.setBounds(43, 75, 101, 13);
		frame.getContentPane().add(lblCurrentName);
		
		JLabel lblCurrentType = new JLabel("Current Type:");
		lblCurrentType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentType.setBounds(43, 111, 101, 19);
		frame.getContentPane().add(lblCurrentType);
		
		JLabel lblCurrentPrice = new JLabel("Current Price:");
		lblCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentPrice.setBounds(43, 165, 101, 13);
		frame.getContentPane().add(lblCurrentPrice);
		
		productCurrentName = new JLabel("");
		productCurrentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		productCurrentName.setBounds(237, 77, 101, 13);
		frame.getContentPane().add(productCurrentName);
		
		productCurrentPrice = new JLabel("");
		productCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		productCurrentPrice.setBounds(237, 167, 101, 13);
		frame.getContentPane().add(productCurrentPrice);
		
		productCurrentType = new JLabel("");
		productCurrentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		productCurrentType.setBounds(237, 116, 101, 13);
		frame.getContentPane().add(productCurrentType);
		frame.setVisible(true);
		
	}
}
