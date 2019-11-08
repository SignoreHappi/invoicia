package four;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FailToCreate {

	JFrame frame;
	
	private static int A = 100;

	private static int B = 100;

	private static int C = 412;

	private static int D =163;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FailToCreate window = new FailToCreate(A, B, C, D);
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
	public FailToCreate(int a, int b, int c, int d) {
		initialize();
		A = a;
		B = b;
		C = c;
		D = d;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FailToCreate.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		frame.setTitle("WARNING");
		frame.setBounds(A, B, C, D);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 102));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOne = new JLabel("Failed to create multiple directories.");
		lblOne.setForeground(new Color(255, 255, 255));
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblOne.setVerticalAlignment(SwingConstants.TOP);
		lblOne.setBounds(0, 11, 402, 22);
		panel.add(lblOne);
		
		JButton btnDecline = new JButton("CONTINUE");
		btnDecline.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			frame.dispose();	
			}
		});
		btnDecline.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		btnDecline.setBounds(228, 77, 168, 44);
		panel.add(btnDecline);
		
		JButton btnTryAgain = new JButton("TRY AGAIN");
		btnTryAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				install();
				frame.dispose();
				File files = new File("D:\\Invoice Gamma");
				if (!files.exists()) {
				
					try {
						FailToCreate fail = new FailToCreate(100, 100, 412, 163);
						fail.frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
				}
			}
		});
		btnTryAgain.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		btnTryAgain.setBounds(10, 77, 168, 44);
		panel.add(btnTryAgain);
	}
	
	
	private static void install() {
		String vear = "20";
		String cust = "Kids In Dance";

		for (int j = 1; j < 5; j++) {
			for (int i = 1; i < 7 ; i++) {

				File files = new File("D:\\Invoice Gamma\\"+cust+"\\"+vear);
				if (!files.exists()) {
					if (files.mkdirs()) {
					}
				}

				switch (i){
				case 1: vear = "20"; break;
				case 2: vear = "21"; break;
				case 3: vear = "22"; break;
				case 4: vear = "23"; break;
				case 5: vear = "24"; break;
//				case 6: vear = "25"; break;
//				case 7: vear = "26"; break;
				}
			}
			
			switch (j){
//			case 0: cust = "01"; break;
			case 1: cust = "Evolve Dance Centre"; break;
			case 2: cust = "Maple Dance Acadamy"; break;
			case 3: cust = "CB Dance Academy"; break;
			case 4: cust = "The Eight Count"; break;
//			case 5: cust = "06"; break;
			}
		}
	}//install()

}
