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
import javax.swing.JSpinner;

public class Tutorial extends Invoice{
	
	
	private String MOne, MTwo, MThree, MFour, MFive, MSix, BGo = "CONTINUE", BBack = "BACK";
	private int page;

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutorial window = new Tutorial();
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
	public Tutorial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Tutorial.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		frame.setResizable(false);
		frame.setTitle("TUTORIAL");
		frame.setBounds(100, 100, 522, 297);
		//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 102));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblOne = new JLabel(MOne);
		lblOne.setForeground(new Color(0, 51, 255));
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblOne.setVerticalAlignment(SwingConstants.TOP);
		lblOne.setBounds(10, 11, 486, 22);
		panel.add(lblOne);

		JLabel lblTwo = new JLabel(MTwo);
		lblTwo.setForeground(new Color(0, 51, 255));
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblTwo.setBounds(10, 54, 486, 22);
		panel.add(lblTwo);
		// all changed settings and installed software prior to accepting and reinstalling the Directory.
		JLabel lblThree = new JLabel(MThree);
		lblThree.setForeground(new Color(0, 51, 255));
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setVerticalAlignment(SwingConstants.TOP);
		lblThree.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblThree.setBounds(10, 74, 486, 22);
		panel.add(lblThree);

		JLabel lblFour = new JLabel(MFour);
		lblFour.setForeground(new Color(0, 51, 255));
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblFour.setVerticalAlignment(SwingConstants.TOP);
		lblFour.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblFour.setBounds(10, 94, 486, 22);
		panel.add(lblFour);

		JLabel lblFive = new JLabel(MFive);
		lblFive.setForeground(new Color(0, 51, 255));
		lblFive.setVerticalAlignment(SwingConstants.TOP);
		lblFive.setHorizontalAlignment(SwingConstants.CENTER);
		lblFive.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblFive.setBounds(10, 114, 486, 22);
		panel.add(lblFive);

		JLabel lblSix = new JLabel(MSix);
		lblSix.setForeground(new Color(0, 51, 255));
		lblSix.setVerticalAlignment(SwingConstants.TOP);
		lblSix.setHorizontalAlignment(SwingConstants.CENTER);
		lblSix.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblSix.setBounds(10, 134, 486, 22);
		panel.add(lblSix);

		JButton btnGo = new JButton(BGo);
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page++;
				switch (page) {
				case 1: One(); break;
				case 2: Two(); break;
				}
			}
		});
		btnGo.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		btnGo.setBounds(338, 213, 168, 44);
		panel.add(btnGo);

		JButton btnBack = new JButton(BBack);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnBack.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		btnBack.setBounds(10, 213, 168, 44);
		panel.add(btnBack);
		
		JSpinner spnPage = new JSpinner();
		spnPage.setFont(new Font("Algerian", Font.PLAIN, 20));
		spnPage.setBounds(273, 213, 55, 44);
		panel.add(spnPage);
		
		JLabel lblPage = new JLabel("PAGE No.");
		lblPage.setFont(new Font("Algerian", Font.PLAIN, 20));
		lblPage.setBounds(183, 212, 96, 44);
		panel.add(lblPage);
	}

	private void One() {
		Settings.setVisible(false);
		System.out.println(page);
	}
	private void Two() {

	}
}













