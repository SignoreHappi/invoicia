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

public class Warning {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning window = new Warning();
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
	public Warning() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Warning.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		frame.setResizable(false);
		frame.setTitle("WARNING");
		frame.setBounds(100, 100, 522, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 102));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblOne = new JLabel("Are you sure you wish to re-install your Directory?");
		lblOne.setForeground(new Color(255, 255, 255));
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblOne.setVerticalAlignment(SwingConstants.TOP);
		lblOne.setBounds(10, 11, 486, 22);
		panel.add(lblOne);
		
		JLabel lblTwo = new JLabel("This may result in the loss of previously changed settings");
		lblTwo.setForeground(new Color(255, 255, 255));
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setVerticalAlignment(SwingConstants.TOP);
		lblTwo.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblTwo.setBounds(10, 54, 486, 22);
		panel.add(lblTwo);
		// all changed settings and installed software prior to accepting and reinstalling the Directory.
		JLabel lblInstalledSoftwareIf = new JLabel("and Installed software. If continued these settings will");
		lblInstalledSoftwareIf.setForeground(new Color(255, 255, 255));
		lblInstalledSoftwareIf.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstalledSoftwareIf.setVerticalAlignment(SwingConstants.TOP);
		lblInstalledSoftwareIf.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblInstalledSoftwareIf.setBounds(10, 74, 486, 22);
		panel.add(lblInstalledSoftwareIf);
		
		JLabel lblToDefaultAnd = new JLabel(" be reset back to default and or factory settings. Please");
		lblToDefaultAnd.setForeground(new Color(255, 255, 255));
		lblToDefaultAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblToDefaultAnd.setVerticalAlignment(SwingConstants.TOP);
		lblToDefaultAnd.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblToDefaultAnd.setBounds(10, 94, 486, 22);
		panel.add(lblToDefaultAnd);
		
		JLabel lblAllChangedSettings = new JLabel("take note of any and all changed settings and installed\r\n");
		lblAllChangedSettings.setForeground(new Color(255, 255, 255));
		lblAllChangedSettings.setVerticalAlignment(SwingConstants.TOP);
		lblAllChangedSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllChangedSettings.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblAllChangedSettings.setBounds(10, 114, 486, 22);
		panel.add(lblAllChangedSettings);
		
		JLabel lblAndReinstallingThe = new JLabel(" software prior to accepting and reinstalling the Directory");
		lblAndReinstallingThe.setForeground(new Color(255, 255, 255));
		lblAndReinstallingThe.setVerticalAlignment(SwingConstants.TOP);
		lblAndReinstallingThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndReinstallingThe.setFont(new Font("Monospaced", Font.BOLD, 14));
		lblAndReinstallingThe.setBounds(10, 134, 486, 22);
		panel.add(lblAndReinstallingThe);
		
		JButton btnDecline = new JButton("IGNORE");
		btnDecline.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			frame.dispose();	
			}
		});
		btnDecline.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		btnDecline.setBounds(338, 213, 168, 44);
		panel.add(btnDecline);
		
		JButton button = new JButton("ACCEPT");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				install();
				frame.dispose();
			}
		});
		button.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 16));
		button.setBounds(10, 213, 168, 44);
		panel.add(button);
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
