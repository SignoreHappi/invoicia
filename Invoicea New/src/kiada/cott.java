//package kiada;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//
//public class Costume {
//
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Costume window = new Costume();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public Costume() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1000, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//
//}

package kiada;

import java.io.*;
import java.net.URL;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.VetoableChangeListener;
import javax.swing.JTextPane;

public class cott {
	
	public static void main(String [] args) {
		cott.main();
	}

	private JFrame frmCorisCostumeDesginer;								//Thick Lining = $5.50/meter
	//Thin Lining  = $4.00/meter

	protected double tax = 1.13;
	double taxn = 1.13;
	private boolean esta = false;
	private JButton btnEsta = new JButton("Estimate");
	protected static double solo;
	protected static double group;
	private boolean clear = false;
	
	private int lineN = 0;

	private JTextField txtMC1 = new JTextField();
	private JTextField txtMC2 = new JTextField();
	private JTextField txtMC3 = new JTextField();
	private JTextField txtMC4 = new JTextField();
	private JTextField txtMC5 = new JTextField();
	private JTextField txtMC6 = new JTextField();
	private JTextField txtMC7 = new JTextField();
	private JTextField txtMC8 = new JTextField();
	private JTextField txtMC9 = new JTextField();
	private JTextField txtMC10 = new JTextField();

	private JTextField txtMM1 = new JTextField();
	private JTextField txtMM2 = new JTextField();
	private JTextField txtMM3 = new JTextField();
	private JTextField txtMM4 = new JTextField();
	private JTextField txtMM5 = new JTextField();
	private JTextField txtMM6 = new JTextField();
	private JTextField txtMM7 = new JTextField();
	private JTextField txtMM8 = new JTextField();
	private JTextField txtMM9 = new JTextField();
	private JTextField txtMM10 = new JTextField();


	private JSpinner sprc1 = new JSpinner();
	private JSpinner sprc2 = new JSpinner();
	private JSpinner sprc3 = new JSpinner();
	private JSpinner sprc4 = new JSpinner();
	private JSpinner sprm1 = new JSpinner();
	private JSpinner sprm2 = new JSpinner();
	private JSpinner sprm3 = new JSpinner();
	private JSpinner sprm4 = new JSpinner();

	private JTextField txtOC1 = new JTextField();
	private JTextField txtOC2 = new JTextField();
	private JTextField txtOC3 = new JTextField();
	private JSpinner spom1 = new JSpinner();
	private JSpinner spom2 = new JSpinner();
	private JSpinner spom3 = new JSpinner();

	private JLabel lblCal = new JLabel(" - - - - ");
	private JSpinner spc1 = new JSpinner();
	private JSpinner spc2 = new JSpinner();
	private JButton btnCal = new JButton("Enter");
	private final JPanel PHours = new JPanel();
	private final JLabel lblHours = new JLabel("Hours");
	private JButton btnSO = new JButton("Start Over");
	private JButton btnEnter = new JButton("Calculate");
	private JSpinner spDep = new JSpinner();

	private JTextField txtCN;
	private JTextField txtSN;
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblKids = new JLabel("Kids");
	private final JSpinner spK = new JSpinner();

	private String message;
	private int count = 0;

	private JButton btnSave = new JButton("Save");
	private double mex = 0;
	private int rex = 0;
	private int oex = 0;
	private double hour = 0;

	private final JPanel PTicket = new JPanel();
	private final JLabel lblCostume = new JLabel("Costume #.");
	private final JLabel lblClient = new JLabel("Client.");
	private final JLabel lblMaterialCost = new JLabel("Material Cost.");
	private final JLabel lblLabourCost_1 = new JLabel("Labour Cost.");
	private final JLabel lblSubtotal = new JLabel("Subtotal.");
	private final JLabel lblTax = new JLabel("Tax.");
	private final JLabel lblCostPerCostume_1 = new JLabel("Cost Per Costume.");
	private final JLabel lblTotal = new JLabel("Total.");

	private JLabel RCN = new JLabel("00-00-000");
	private JLabel RCTN = new JLabel("00-**-***");
	private JLabel RMC = new JLabel("$");
	private JLabel RLC = new JLabel("$");
	private JLabel RST = new JLabel("$");
	private JLabel RTX = new JLabel("$");
	private JLabel RT = new JLabel("$");
	private JLabel RCPC = new JLabel("$");
	private JCheckBox chkTax = new JCheckBox("Tax Exempt");
	private final JLabel lblNewLabel = new JLabel("- - - - - - - - - - - - - - - - - - - - - - -");
	private final JLabel lblDeposit_1 = new JLabel("Deposit.");
	private JLabel RD = new JLabel("-$");
	private JLabel lblRec = new JLabel("Receipt.");
	private JTextField txtFile;
	private JLabel lblBD = new JLabel("$");


	private final JTextPane txtCommand = new JTextPane();
	private final JTextPane txtH = new JTextPane();

	private String [] ma = new String [10];
	private String [] me = new String [10];

	private String [] ra = new String [4];
	private String [] re = new String [4];

	private String [] oa = new String [3];
	private String [] oe = new String [3];
	private final JButton btnPrevious = new JButton("Previous");
	private final JButton btnNext = new JButton("Next");

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cott window = new cott();
					window.frmCorisCostumeDesginer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cott() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmCorisCostumeDesginer = new JFrame();
		frmCorisCostumeDesginer.getContentPane().setBackground(Color.DARK_GRAY);
		frmCorisCostumeDesginer.setBackground(Color.WHITE);
		frmCorisCostumeDesginer.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
//				MAINT.main(null);
			}
		});

//		try {
//			URL resource = frmCorisCostumeDesginer.getClass().getResource("/CCP Alpha.jpg");
//			BufferedImage image = ImageIO.read(resource);
//			frmCorisCostumeDesginer.setIconImage(image);
//		} catch (IOException e) {  e.printStackTrace();  }



		//		frmCorisCostumeDesginer.add(thisImage);
		frmCorisCostumeDesginer.setTitle("Cori's Costume Desginer");
		frmCorisCostumeDesginer.setResizable(false);
		frmCorisCostumeDesginer.setBounds(100, 100, 820, 527);
		frmCorisCostumeDesginer.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmCorisCostumeDesginer.getContentPane().setLayout(null);

		JPanel PMaterial = new JPanel();
		PMaterial.setBackground(new Color(255, 204, 204));
		PMaterial.setBounds(139, 11, 126, 367);
		frmCorisCostumeDesginer.getContentPane().add(PMaterial);
		PMaterial.setLayout(null);

		JLabel lblMaterial = new JLabel("Material");
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaterial.setBounds(0, 0, 126, 27);
		PMaterial.add(lblMaterial);
		txtMC1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtMC1.setText(null);
			}
		});
		txtMC1.setText("0");
		txtMC1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC1.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC1.setBounds(10, 26, 60, 20);
		PMaterial.add(txtMC1);
		txtMC2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC2.setText(null);
			}
		});
		txtMC2.setText("0");
		txtMC2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC2.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC2.setBounds(10, 57, 60, 20);
		PMaterial.add(txtMC2);
		txtMC3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC3.setText(null);
			}
		});
		txtMC3.setText("0");
		txtMC3.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC3.setFont(new Font("Times New Roman", Font.BOLD, 14));// 

		txtMC3.setBounds(10, 88, 60, 20);
		PMaterial.add(txtMC3);
		txtMC4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC4.setText(null);
			}
		});
		txtMC4.setText("0");
		txtMC4.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC4.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC4.setBounds(10, 120, 60, 20);
		PMaterial.add(txtMC4);
		txtMC5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC5.setText(null);
			}
		});
		txtMC5.setText("0");
		txtMC5.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC5.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC5.setBounds(10, 150, 60, 20);
		PMaterial.add(txtMC5);
		txtMC6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC6.setText(null);
			}
		});
		txtMC6.setText("0");
		txtMC6.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC6.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC6.setBounds(10, 182, 60, 20);
		PMaterial.add(txtMC6);
		txtMC7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC7.setText(null);
			}
		});
		txtMC7.setText("0");
		txtMC7.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC7.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC7.setBounds(10, 212, 60, 20);
		PMaterial.add(txtMC7);
		txtMC8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMC8.setText(null);
			}
		});
		txtMC8.setText("0");
		txtMC8.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC8.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtMC8.setBounds(10, 244, 60, 20);
		PMaterial.add(txtMC8);

		txtMM1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtMM1.setText(null);
			}
		});
		txtMM1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM1.setText("0");
		txtMM1.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM1.setBounds(80, 26, 36, 20);
		txtMM1.setColumns(10);
		PMaterial.add(txtMM1);

		txtMM2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM2.setText(null);
			}
		});
		txtMM2.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM2.setText("0");
		txtMM2.setColumns(10);
		txtMM2.setBounds(80, 57, 36, 20);
		PMaterial.add(txtMM2);

		txtMM3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM3.setText(null);
			}
		});
		txtMM3.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM3.setText("0");
		txtMM3.setColumns(10);
		txtMM3.setBounds(80, 88, 36, 20);
		PMaterial.add(txtMM3);

		txtMM4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM4.setText(null);
			}
		});
		txtMM4.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM4.setText("0");
		txtMM4.setColumns(10);
		txtMM4.setBounds(80, 120, 36, 20);
		PMaterial.add(txtMM4);

		txtMM5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM5.setText(null);
			}
		});
		txtMM5.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM5.setText("0");
		txtMM5.setColumns(10);
		txtMM5.setBounds(80, 150, 36, 20);
		PMaterial.add(txtMM5);

		txtMM6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM6.setText(null);
			}
		});
		txtMM6.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM6.setText("0");
		txtMM6.setColumns(10);
		txtMM6.setBounds(80, 181, 36, 20);
		PMaterial.add(txtMM6);

		txtMM7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM7.setText(null);
			}
		});
		txtMM7.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM7.setText("0");
		txtMM7.setColumns(10);
		txtMM7.setBounds(80, 212, 36, 20);
		PMaterial.add(txtMM7);

		txtMM8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMM8.setText(null);
			}
		});
		txtMM8.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM8.setText("0");
		txtMM8.setColumns(10);
		txtMM8.setBounds(80, 244, 36, 20);
		PMaterial.add(txtMM8);

		txtMC9 = new JTextField();
		txtMC9.setText("0");
		txtMC9.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMC9.setBounds(10, 275, 60, 20);
		PMaterial.add(txtMC9);

		txtMM9 = new JTextField();
		txtMM9.setText("0");
		txtMM9.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM9.setColumns(10);
		txtMM9.setBounds(80, 275, 36, 20);
		PMaterial.add(txtMM9);

		txtMM10 = new JTextField();
		txtMM10.setText("0");
		txtMM10.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMM10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMM10.setColumns(10);
		txtMM10.setBounds(80, 306, 36, 20);
		PMaterial.add(txtMM10);

		txtMC10 = new JTextField();
		txtMC10.setText("0");
		txtMC10.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMC10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtMC10.setBounds(10, 306, 60, 20);
		PMaterial.add(txtMC10);


		JPanel PRhynestones = new JPanel();
		PRhynestones.setBackground(new Color(204, 204, 255));
		PRhynestones.setBounds(275, 11, 126, 182);
		frmCorisCostumeDesginer.getContentPane().add(PRhynestones);
		PRhynestones.setLayout(null);

		JLabel lblRhynestones = new JLabel("Rhynestones");
		lblRhynestones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRhynestones.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRhynestones.setBounds(0, 11, 126, 27);
		PRhynestones.add(lblRhynestones);
		sprc1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprc1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprc1.setBounds(10, 49, 60, 20);
		PRhynestones.add(sprc1);
		sprc2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprc2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprc2.setBounds(10, 80, 60, 20);
		PRhynestones.add(sprc2);
		sprc3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprc3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprc3.setBounds(10, 111, 60, 20);
		PRhynestones.add(sprc3);
		sprc4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprc4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprc4.setBounds(10, 143, 60, 20);
		PRhynestones.add(sprc4);
		sprm1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprm1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprm1.setBounds(86, 49, 29, 20);
		PRhynestones.add(sprm1);
		sprm2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprm2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprm2.setBounds(86, 80, 29, 20);
		PRhynestones.add(sprm2);
		sprm3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprm3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprm3.setBounds(86, 111, 29, 20);
		PRhynestones.add(sprm3);
		sprm4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		sprm4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		sprm4.setBounds(86, 142, 29, 20);
		PRhynestones.add(sprm4);

		JPanel POther = new JPanel();
		POther.setBackground(new Color(255, 255, 153));
		POther.setBounds(275, 204, 126, 174);
		frmCorisCostumeDesginer.getContentPane().add(POther);
		POther.setLayout(null);

		JLabel lblOther = new JLabel("Other");
		lblOther.setBounds(0, 11, 126, 27);
		lblOther.setHorizontalAlignment(SwingConstants.CENTER);
		lblOther.setFont(new Font("Times New Roman", Font.BOLD, 20));
		POther.add(lblOther);
		txtOC1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOC1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtOC1.setText(null);
			}
		});
		txtOC1.setText("0");
		txtOC1.setFont(new Font("Times New Roman", Font.BOLD, 14));


		txtOC1.setBounds(10, 49, 60, 20);
		POther.add(txtOC1);
		txtOC2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOC2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtOC2.setText(null);
			}
		});
		txtOC2.setText("0");
		txtOC2.setFont(new Font("Times New Roman", Font.BOLD, 14));


		txtOC2.setBounds(10, 80, 60, 20);
		POther.add(txtOC2);
		txtOC3.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOC3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtOC3.setText(null);
			}
		});
		txtOC3.setText("0");
		txtOC3.setFont(new Font("Times New Roman", Font.BOLD, 14));


		txtOC3.setBounds(10, 111, 60, 20);
		POther.add(txtOC3);
		spom1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spom1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		spom1.setBounds(86, 49, 29, 20);
		POther.add(spom1);
		spom2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spom2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		spom2.setBounds(86, 80, 29, 20);
		POther.add(spom2);
		spom3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spom3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		spom3.setBounds(86, 111, 29, 20);
		POther.add(spom3);

		JPanel PMeter = new JPanel();
		PMeter.setBackground(new Color(204, 153, 255));
		PMeter.setBounds(10, 11, 118, 166);
		frmCorisCostumeDesginer.getContentPane().add(PMeter);
		PMeter.setLayout(null);

		JLabel lblMeter = new JLabel("Meter Cal");
		lblMeter.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMeter.setBounds(0, 11, 118, 27);
		PMeter.add(lblMeter);


		lblCal.setBackground(new Color(0, 0, 0));
		lblCal.setForeground(new Color(153, 255, 0));
		lblCal.setFont(new Font("Minecraftia", Font.PLAIN, 18));
		lblCal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCal.setBounds(10, 38, 98, 27);
		PMeter.add(lblCal);
		spc1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spc1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		spc1.setBounds(20, 64, 76, 23);
		PMeter.add(spc1);
		spc2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spc2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));


		spc2.setBounds(20, 98, 76, 23);
		PMeter.add(spc2);
		btnCal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cal();
			}
		});


		btnCal.setBounds(10, 132, 98, 23);
		PMeter.add(btnCal);
		PHours.setBackground(new Color(204, 255, 255));
		PHours.setBounds(10, 188, 118, 113);

		frmCorisCostumeDesginer.getContentPane().add(PHours);
		PHours.setLayout(null);
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHours.setBounds(0, 7, 118, 27);

		PHours.add(lblHours);
		txtH.setBounds(10, 45, 98, 20);

		PHours.add(txtH);
		btnEsta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEsta.setForeground(Color.GREEN);
			}
		});
		
		
		btnEsta.setBounds(10, 76, 99, 26);
		btnEsta.setForeground(Color.BLACK);
		PHours.add(btnEsta);

		JPanel POtre = new JPanel();
		POtre.setBackground(new Color(204, 204, 153));
		POtre.setBounds(411, 290, 148, 174);
		frmCorisCostumeDesginer.getContentPane().add(POtre);
		POtre.setLayout(null);
		spDep.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spDep.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

		spDep.setBounds(10, 119, 126, 26);
		POtre.add(spDep);

		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDeposit.setBounds(10, 11, 126, 27);
		POtre.add(lblDeposit);

		txtCN = new JTextField();
		txtCN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCN.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCN.getText().equals("")) {
					txtCN.setText("Costume Number");
				}
			}
		});
		txtCN.setHorizontalAlignment(SwingConstants.CENTER);
		txtCN.setText("Costume Number");
		txtCN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtCN.setBounds(10, 84, 126, 24);
		POtre.add(txtCN);
		txtCN.setColumns(10);

		txtSN = new JTextField();
		txtSN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSN.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSN.getText().equals("")) {
					txtSN.setText("Studio Number");
				}
			}
		});
		txtSN.setText("Studio Number");
		txtSN.setHorizontalAlignment(SwingConstants.CENTER);
		txtSN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtSN.setColumns(10);
		txtSN.setBounds(10, 49, 126, 24);
		POtre.add(txtSN);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Empty();
				if(clear != true) {
				Mathe();
				}
			}
		});

		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEnter.setBounds(411, 100, 148, 41);
		frmCorisCostumeDesginer.getContentPane().add(btnEnter);

		btnSO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clear();

			}
		});
		btnSO.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSO.setBounds(411, 48, 148, 41);
		frmCorisCostumeDesginer.getContentPane().add(btnSO);
		panel_1.setBackground(new Color(255, 153, 204));
		panel_1.setBounds(10, 312, 118, 66);

		frmCorisCostumeDesginer.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		lblKids.setHorizontalAlignment(SwingConstants.CENTER);
		lblKids.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblKids.setBounds(0, 0, 118, 27);

		panel_1.add(lblKids);
		spK.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spK.setBounds(10, 34, 98, 21);

		panel_1.add(spK);
		PTicket.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		PTicket.setBackground(new Color(255, 255, 204));
		PTicket.setBounds(569, 12, 235, 452);

		frmCorisCostumeDesginer.getContentPane().add(PTicket);
		PTicket.setLayout(null);


		lblRec.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRec.setBounds(10, 11, 123, 20);
		PTicket.add(lblRec);
		lblCostume.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCostume.setBounds(10, 42, 123, 20);

		PTicket.add(lblCostume);
		lblClient.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblClient.setBounds(10, 73, 123, 20);

		PTicket.add(lblClient);
		lblMaterialCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaterialCost.setBounds(10, 104, 123, 20);

		PTicket.add(lblMaterialCost);
		lblLabourCost_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLabourCost_1.setBounds(10, 135, 123, 20);

		PTicket.add(lblLabourCost_1);
		lblSubtotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSubtotal.setBounds(10, 166, 123, 20);

		PTicket.add(lblSubtotal);
		lblTax.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTax.setBounds(10, 197, 123, 20);

		PTicket.add(lblTax);
		lblCostPerCostume_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCostPerCostume_1.setBounds(10, 290, 123, 20);

		PTicket.add(lblCostPerCostume_1);
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotal.setBounds(10, 228, 123, 20);

		PTicket.add(lblTotal);


		chkTax.setBackground(new Color(255, 255, 204));
		chkTax.setBounds(6, 422, 110, 23);
		PTicket.add(chkTax);


		RCN.setHorizontalAlignment(SwingConstants.TRAILING);
		RCN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RCN.setBounds(91, 42, 134, 20);
		PTicket.add(RCN);


		RCTN.setHorizontalAlignment(SwingConstants.TRAILING);
		RCTN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RCTN.setBounds(91, 73, 134, 20);
		PTicket.add(RCTN);

		RMC.setHorizontalAlignment(SwingConstants.TRAILING);
		RMC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RMC.setBounds(108, 104, 117, 20);
		PTicket.add(RMC);

		RLC.setHorizontalAlignment(SwingConstants.TRAILING);
		RLC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RLC.setBounds(108, 135, 117, 20);
		PTicket.add(RLC);

		RST.setHorizontalAlignment(SwingConstants.TRAILING);
		RST.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RST.setBounds(108, 166, 117, 20);
		PTicket.add(RST);

		RTX.setHorizontalAlignment(SwingConstants.TRAILING);
		RTX.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RTX.setBounds(108, 197, 117, 20);
		PTicket.add(RTX);

		RT.setHorizontalAlignment(SwingConstants.TRAILING);
		RT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RT.setBounds(108, 228, 117, 20);
		PTicket.add(RT);

		RCPC.setHorizontalAlignment(SwingConstants.TRAILING);
		RCPC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RCPC.setBounds(131, 290, 94, 20);
		PTicket.add(RCPC);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 92, 235, 14);

		PTicket.add(lblNewLabel);
		lblDeposit_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeposit_1.setBounds(10, 259, 123, 20);

		PTicket.add(lblDeposit_1);
		RD.setForeground(Color.RED);
		RD.setHorizontalAlignment(SwingConstants.TRAILING);
		RD.setFont(new Font("Times New Roman", Font.BOLD, 14));
		RD.setBounds(108, 259, 117, 20);

		PTicket.add(RD);

		JLabel lblBalanceDue = new JLabel("Balance Due.");
		lblBalanceDue.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBalanceDue.setBounds(10, 383, 139, 32);
		PTicket.add(lblBalanceDue);
		lblBD.setForeground(Color.DARK_GRAY);


		lblBD.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBD.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBD.setBounds(108, 403, 117, 43);
		PTicket.add(lblBD);



		txtFile = new JTextField();
		txtFile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyPressed(KeyEvent enter) {
				if(enter.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						reada(txtFile.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		txtFile.addVetoableChangeListener(new VetoableChangeListener() {
			public void vetoableChange(PropertyChangeEvent arg0) {
				if(txtFile.getText().length() == 9) {

					try {
						reada(txtFile.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txtFile.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		txtFile.setToolTipText("<html>Input File Number : <br/> <br/> Studio Number - Year - File No. <br/>  <br/>\r\nSN-YY-XXX <html>");
		txtFile.setBounds(421, 259, 126, 20);
		frmCorisCostumeDesginer.getContentPane().add(txtFile);
		txtFile.setColumns(10);

		JLabel lblFileNumber = new JLabel("File Number");
		lblFileNumber.setBackground(Color.WHITE);
		lblFileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileNumber.setBounds(421, 234, 126, 28);
		frmCorisCostumeDesginer.getContentPane().add(lblFileNumber);


		btnSave.setEnabled(false);
		btnSave.hide();
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Save(RCN.getText());
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSave.setBounds(411, 152, 148, 41);
		frmCorisCostumeDesginer.getContentPane().add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(411, 11, 148, 26);
		frmCorisCostumeDesginer.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("Print Report");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmCorisCostumeDesginer.setBounds(100,100,1153,527);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(411, 200, 148, 33);
		frmCorisCostumeDesginer.getContentPane().add(btnNewButton);

		JLabel lblback = new JLabel();
		lblback.setIcon(new ImageIcon("C:\\Users\\Embit User\\Pictures\\KidsInDance\\KID background.png"));
		lblback.setBounds(-12, 0, 826, 488);
		frmCorisCostumeDesginer.getContentPane().add(lblback);
		txtCommand.setBounds(814, 0, 333, 434);
		frmCorisCostumeDesginer.getContentPane().add(txtCommand);
		txtCommand.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		txtCommand.setForeground(new Color(50, 205, 50));
		txtCommand.setBackground(Color.DARK_GRAY);
		txtCommand.setEditable(false);
		btnPrevious.setBounds(813, 434, 164, 41);
		
		frmCorisCostumeDesginer.getContentPane().add(btnPrevious);
		btnNext.setBounds(983, 434, 164, 41);
		
		frmCorisCostumeDesginer.getContentPane().add(btnNext);

		JMenuBar menuBar = new JMenuBar();
		frmCorisCostumeDesginer.setJMenuBar(menuBar);

		JMenu mnuFile = new JMenu("File");
		menuBar.add(mnuFile);

		JMenuItem mnuFile_Close = new JMenuItem("Close");
		mnuFile_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnuFile.add(mnuFile_Close);




//		frmCorisCostumeDesginer.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{PMaterial, txtMC1, txtMC2, txtMC3, txtMC4, txtMC5, txtMC6, txtMC7, txtMC8, PRhynestones, sprc1, sprm1, sprc2, sprm2, sprc3, sprm3, sprc4, sprm4, POther, txtOC1, spom1, txtOC2, spom2, txtOC3, spom3, frmCorisCostumeDesginer.getContentPane(), spc1, lblMaterial, lblRhynestones, lblOther, PMeter, lblMeter, lblCal, spc2, btnCal}));
	}


	public void setTax(double a) {
		taxn = a + 1;
	}

	public void setSolo(double a) {
		solo = a;
	}

	public void setGroup(double a) {
		group = a;
	}

	public void Mathe() {
		
		txtCommand.setText(null);
			
		hour = 0;
		btnSave.setEnabled(true);
		btnSave.show();
		Material();
		Rhy();
		Oth();
		Labour();
		//		double bonus = (5 * (int)spK.getValue()) * 2;
		double total = (mex + mex + rex + oex + hour);

		String client = "Default";
		switch(txtSN.getText()) {
		case "01": client = "Evolve Dance Centre"; break;
		case "02": client = "CB Dance"; break;
		case "03": client = "The Eight Count"; break;
		case "04": client = "Not Deturmined"; break;
		case "05": client = "Not Deturmined"; break;
		case "06": client = "Not Deturmined"; break;
		default: client = "Not Deturmined"; break;
		}



		// Receipt

		if(btnEsta.getForeground().equals(Color.GREEN)) {
			tax = 1;
			RTX.setText("$ 0.00");
			//			RCPC.setText("$ 0.00");
		}else {
			tax = taxn;
		}

		double tottal = total * tax - (int)spDep.getValue();
		double totttal = total * tax;
		double cpca = (totttal / (int)spK.getValue());

		RCN.setText(txtSN.getText() + " - " + txtCN.getText());
		RCTN.setText(client);
		RMC.setText("$ " + (mex + mex + rex + oex));
		RLC.setText("$ " + hour);
		RST.setText("$ " + Math.round(total));
		RTX.setText("$ " + Math.round(total * 0.13));
		RT.setText("$ " + Math.round(totttal));
		RCPC.setText("$ " +  Math.round(cpca));
		RD.setText("-$ " + spDep.getValue());
		lblBD.setText("$ " + Math.round(tottal));



	}
	
	public void Empty() {
//		txtCommand.setText("hello");
		if(txtMC1.getText().equals("")  || txtMC1.getText().equals(" ")  || txtMC1.getText().equals(null))  {txtMC1.setText("0");}
		if(txtMC2.getText().equals("")  || txtMC2.getText().equals(" ")  || txtMC2.getText().equals(null))  {txtMC2.setText("0");}
		if(txtMC3.getText().equals("")  || txtMC3.getText().equals(" ")  || txtMC3.getText().equals(null))  {txtMC3.setText("0");}
		if(txtMC4.getText().equals("")  || txtMC4.getText().equals(" ")  || txtMC4.getText().equals(null))  {txtMC4.setText("0");}
		if(txtMC5.getText().equals("")  || txtMC5.getText().equals(" ")  || txtMC5.getText().equals(null))  {txtMC5.setText("0");}
		if(txtMC6.getText().equals("")  || txtMC6.getText().equals(" ")  || txtMC6.getText().equals(null))  {txtMC6.setText("0");}
		if(txtMC7.getText().equals("")  || txtMC7.getText().equals(" ")  || txtMC7.getText().equals(null))  {txtMC7.setText("0");}
		if(txtMC8.getText().equals("")  || txtMC8.getText().equals(" ")  || txtMC8.getText().equals(null))  {txtMC8.setText("0");}
		if(txtMC9.getText().equals("")  || txtMC9.getText().equals(" ")  || txtMC9.getText().equals(null))  {txtMC9.setText("0");}
		if(txtMC10.getText().equals("") || txtMC10.getText().equals(" ") || txtMC10.getText().equals(null)) {txtMC10.setText("0");}
		
		if(txtMM1.getText().equals("")  || txtMM1.getText().equals(" ")  || txtMM1.getText().equals(null))  {txtMM1.setText("0");}
		if(txtMM2.getText().equals("")  || txtMM2.getText().equals(" ")  || txtMM2.getText().equals(null))  {txtMM2.setText("0");}
		if(txtMM3.getText().equals("")  || txtMM3.getText().equals(" ")  || txtMM3.getText().equals(null))  {txtMM3.setText("0");}
		if(txtMM4.getText().equals("")  || txtMM4.getText().equals(" ")  || txtMM4.getText().equals(null))  {txtMM4.setText("0");}
		if(txtMM5.getText().equals("")  || txtMM5.getText().equals(" ")  || txtMM5.getText().equals(null))  {txtMM5.setText("0");}
		if(txtMM6.getText().equals("")  || txtMM6.getText().equals(" ")  || txtMM6.getText().equals(null))  {txtMM6.setText("0");}
		if(txtMM7.getText().equals("")  || txtMM7.getText().equals(" ")  || txtMM7.getText().equals(null))  {txtMM7.setText("0");}
		if(txtMC8.getText().equals("")  || txtMM8.getText().equals(" ")  || txtMM8.getText().equals(null))  {txtMM8.setText("0");}
		if(txtMM9.getText().equals("")  || txtMM9.getText().equals(" ")  || txtMM9.getText().equals(null))  {txtMM9.setText("0");}
		if(txtMM10.getText().equals("") || txtMM10.getText().equals(" ") || txtMM10.getText().equals(null)) {txtMM10.setText("0");}
		
		if(txtH.getText().equals("")  || txtH.getText().equals(" ")  || txtH.getText().equals(null)) {
		clear = true;
		RCN.setText(""); 		RCTN.setText("");		RMC.setText("$ ");
		RLC.setText("$ "); 	RST.setText("$ ");		RTX.setText("$ ");
		RT.setText("$ ");		RCPC.setText("$ ");	RD.setText("-$ ");
		
		txtCommand.setForeground(Color.RED);
		message = "No. of <HOURS> is undefined ";
		txtCommand.setText(txtCommand.getText()  + message + "\n");
		}
		
		if(spK.getValue().equals(0)) {
			clear = true;
			RCN.setText(""); 		RCTN.setText("");		RMC.setText("$ ");
			RLC.setText("$ "); 	RST.setText("$ ");		RTX.setText("$ ");
			RT.setText("$ ");		RCPC.setText("$ ");	RD.setText("-$ ");
			
			txtCommand.setForeground(Color.RED);
			message = "No. of <KIDS> is undefined ";
			txtCommand.setText(txtCommand.getText()  + message + "\n");
			}
	}

	public double Material() {
		double mate [] = new double [10];

		double c1 = (Double.parseDouble(txtMC1.getText()));
		double c2 = (Double.parseDouble(txtMC2.getText()));
		double c3 = (Double.parseDouble(txtMC3.getText()));
		double c4 = (Double.parseDouble(txtMC4.getText()));
		double c5 = (Double.parseDouble(txtMC5.getText()));
		double c6 = (Double.parseDouble(txtMC6.getText()));
		double c7 = (Double.parseDouble(txtMC7.getText()));
		double c8 = (Double.parseDouble(txtMC8.getText()));
		double c9 = (Double.parseDouble(txtMC9.getText()));
		double c10 = (Double.parseDouble(txtMC10.getText()));

		double m1 = (Double.parseDouble(txtMM1.getText()));
		double m2 = (Double.parseDouble(txtMM2.getText()));
		double m3 = (Double.parseDouble(txtMM3.getText()));
		double m4 = (Double.parseDouble(txtMM4.getText()));
		double m5 = (Double.parseDouble(txtMM5.getText()));
		double m6 = (Double.parseDouble(txtMM6.getText()));
		double m7 = (Double.parseDouble(txtMM7.getText()));
		double m8 = (Double.parseDouble(txtMM8.getText()));
		double m9 = (Double.parseDouble(txtMM9.getText()));
		double m10 = (Double.parseDouble(txtMM10.getText()));

		mate[0] = m1 * c1;
		mate[1] = m2 * c2;
		mate[2] = m3 * c3;
		mate[3] = m4 * c4;
		mate[4] = m5 * c5;
		mate[5] = m6 * c6;
		mate[6] = m7 * c7;
		mate[7] = m8 * c8;
		mate[8] = m9 * c9;
		mate[9] = m10 * c10;


		mex = mate[0] + mate[1] + mate[2] + mate[3] + mate[4] + mate[5] + mate[6] + mate[7] + mate[8] + mate [9] + 5;

		return mex;

	}

	public int Rhy() {

		int rhy [] = new int [4];


		rhy[0] = (int)sprc1.getValue() * (int)sprm1.getValue();
		rhy[1] = (int)sprc2.getValue() * (int)sprm2.getValue();
		rhy[2] = (int)sprc3.getValue() * (int)sprm3.getValue();
		rhy[3] = (int)sprc4.getValue() * (int)sprm4.getValue();

		rex =  rhy[0] + rhy[1] + rhy[2] + rhy[3];

		return rex;
	}

	public int Oth() {

		int oth [] = new int [3];

		int c1 = (int)(Integer.valueOf(txtOC1.getText()));
		int c2 = (int)(Integer.valueOf(txtOC1.getText()));
		int c3 = (int)(Integer.valueOf(txtOC1.getText()));

		int o1 = (int)spom1.getValue();
		int o2 = (int)spom2.getValue();
		int o3 = (int)spom3.getValue();

		oth[0] = c1 * o1;
		oth[1] = c2 * o2;
		oth[2] = c3 * o3;

		oex =  oth[0] + oth[1] + oth[2];

		return oex;
	}

	public void Cal() {
		double first = (int)spc1.getValue();
		double firsti = (int)spc2.getValue();
		double call = first / firsti;
		lblCal.setText("$ " + call);
	}//cal

	public double Labour() {

				solo = 2.33;
				group = 1.75;

		if(esta == true) {
			//			lblRec.setText("0" + hour);

			message = "Estamate";
			txtCommand.setText(txtCommand.getText() + message + "\n");

			if((int)spK.getValue() < 4) {
				hour = solo;
				//				lblRec.setText("1 " + hour);
			}else if((int)spK.getValue() > 3) {
				hour = (int)spK.getValue() * group;
				//				lblRec.setText("2 " + hour);
			}

			hour = hour * 30;
			txtH.setText(Double.toString(hour/30));

		}else {
			hour = Double.parseDouble(txtH.getText()) * 30;

		}
		return hour;

	}//labour

	public void clear() {
		
		frmCorisCostumeDesginer.setBounds(100,100,820,527);
		
		clear = false;
		
		spK.setValue(0);

		txtH.setText("0");
		btnEsta.setForeground(Color.BLACK);
		esta = false;

		txtMC1.setText("0");
		txtMC2.setText("0");
		txtMC3.setText("0");
		txtMC4.setText("0");
		txtMC5.setText("0");
		txtMC6.setText("0");
		txtMC7.setText("0");
		txtMC8.setText("0");

		txtMM1.setText("0");
		txtMM2.setText("0");
		txtMM3.setText("0");
		txtMM4.setText("0");
		txtMM5.setText("0");
		txtMM6.setText("0");
		txtMM7.setText("0");
		txtMM8.setText("0");

		sprm1.setValue(0);
		sprm2.setValue(0);
		sprm3.setValue(0);
		sprm4.setValue(0);

		sprc1.setValue(0);
		sprc2.setValue(0);
		sprc3.setValue(0);
		sprc4.setValue(0);

		spom1.setValue(0);
		spom2.setValue(0);
		spom3.setValue(0);

		txtOC1.setText("0");
		txtOC2.setText("0");
		txtOC3.setText("0");


		RCN.setText("");
		RCTN.setText("");
		RMC.setText("$ ");
		RLC.setText("$ ");
		RST.setText("$ ");
		RTX.setText("$ ");
		RT.setText("$ ");
		RCPC.setText("$ ");
		RD.setText("-$ ");
		txtSN.setText("Studio Number");
		txtCN.setText("Costume Number");
		spDep.setValue(0);
		lblBD.setText("$ ");

		tax = 1.13;
	}

	public void report() {
		String brk = "<br/>";
		txtCommand.setText(lineN + "" + brk);
	}


	/**
	 * @param x
	 * @throws IOException
	 */
	public void reada(String x) throws IOException {
		boolean reality = true;
		int ol = 0;

		if(x.isEmpty()) {
			reality = false;
		}

		while(reality == true && ol == 0) {
			for(int t = 0; t < 10; t++) {
				ma[t] = "";
				me[t] = "";
			}
			for(int t = 0; t < 4; t++) {
				ra[t] = "";
				re[t] = "";
			}
			for(int t = 0; t < 3; t++) {
				oa[t] = "";
				oe[t] = "";
			}

			try {
				BufferedReader br = new BufferedReader(new FileReader("C:\\Invoiceia Alpha\\" + x.substring(0, 2) + "\\" + x.substring(3, 5) + "\\" + x +".txt"));
				String strCurrentLine = "";
				txtFile.setForeground(Color.BLACK);
				txtCommand.setForeground(Color.GREEN);

				message = "Opening File n. " + x;
				txtCommand.setText(txtCommand.getText()  + message + "\n");


				//				(strCurrentLine != "-" || strCurrentLine != "e" || strCurrentLine != "/" || strCurrentLine != "+")  		 || strCurrentLine.equals("null")
				for(int i = 0; i < 100; i++) {
					strCurrentLine = br.readLine();
					if(strCurrentLine.equals("-")|| strCurrentLine.equals("/")) {

					}else if(strCurrentLine.equals("M")){

						for(int m = 0; m < 100; m++) {
							strCurrentLine = br.readLine();
							if(strCurrentLine.equals("/")) {
								m = 10000;
							}else if(strCurrentLine.equals("-")) {
								strCurrentLine = br.readLine();
								ma[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								me[m] = (strCurrentLine);
							}else {
								ma[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								me[m] = (strCurrentLine);
							}
						}

					}else if(strCurrentLine.equals("R")){

						for(int m = 0; m < 100; m++) {
							strCurrentLine = br.readLine();
							if(strCurrentLine.equals("/")) {
								m = 10000;
							}else if(strCurrentLine.equals("-")) {
								strCurrentLine = br.readLine();
								ra[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								re[m] = (strCurrentLine);
							}else {
								ra[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								re[m] = (strCurrentLine);
							}
						}

					}else if(strCurrentLine.equals("O")){

						for(int m = 0; m < 100; m++) {
							strCurrentLine = br.readLine();
							if(strCurrentLine.equals("/")) {
								m = 10000;
							}else if(strCurrentLine.equals("-")) {
								strCurrentLine = br.readLine();
								oa[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								oe[m] = (strCurrentLine);
							}else {
								oa[m] = (strCurrentLine);
								strCurrentLine = br.readLine();
								oe[m] = (strCurrentLine);
							}
						}

					}else if(strCurrentLine.equals("K")){
						strCurrentLine = br.readLine();
						spK.setValue(Integer.parseInt(strCurrentLine));
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("D")){
						strCurrentLine = br.readLine();
						spDep.setValue(Integer.parseInt(strCurrentLine));
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("C")){
						strCurrentLine = br.readLine();
						txtCN.setText(strCurrentLine);
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("S")){
						strCurrentLine = br.readLine();
						txtSN.setText(strCurrentLine);
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("Y")){
						strCurrentLine = br.readLine();
						txtCN.setText(strCurrentLine +" - "+ txtCN.getText());
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("H")){
						strCurrentLine = br.readLine();
						txtH.setText(strCurrentLine);
						strCurrentLine = br.readLine();


					}else if(strCurrentLine.equals("e")){
						i = 100 * 100;

						if(ma[0].isEmpty()) {ma[0] = "0";}
						if(ma[1].isEmpty()) {ma[1] = "0";}
						if(ma[2].isEmpty()) {ma[2] = "0";}
						if(ma[3].isEmpty()) {ma[3] = "0";}
						if(ma[4].isEmpty()) {ma[4] = "0";}
						if(ma[5].isEmpty()) {ma[5] = "0";}
						if(ma[6].isEmpty()) {ma[6] = "0";}
						if(ma[7].isEmpty()) {ma[7] = "0";}
						if(ma[8].isEmpty())	{ma[8] = "0";}
						if(ma[9].isEmpty())	{ma[9] = "0";}

						if(me[0].isEmpty()) {me[0] = "0";}
						if(me[1].isEmpty()) {me[1] = "0";}
						if(me[2].isEmpty()) {me[2] = "0";}
						if(me[3].isEmpty()) {me[3] = "0";}
						if(me[4].isEmpty()) {me[4] = "0";}
						if(me[5].isEmpty()) {me[5] = "0";}
						if(me[6].isEmpty()) {me[6] = "0";}
						if(me[7].isEmpty()) {me[7] = "0";}
						if(me[8].isEmpty()) {me[8] = "0";}
						if(me[9].isEmpty()) {me[9] = "0";}

						if(ra[0].isEmpty()) {ra[0] = "0";}
						if(ra[1].isEmpty()) {ra[1] = "0";}
						if(ra[2].isEmpty()) {ra[2] = "0";}
						if(ra[3].isEmpty()) {ra[3] = "0";}

						if(oa[0].isEmpty()) {oa[0] = "0";}
						if(oa[1].isEmpty()) {oa[1] = "0";}
						if(oa[2].isEmpty()) {oa[2] = "0";}

						if(re[0].isEmpty()) {re[0] = "0";}
						if(re[1].isEmpty()) {re[1] = "0";}
						if(re[2].isEmpty()) {re[2] = "0";}
						if(re[3].isEmpty()) {re[3] = "0";}

						if(oe[0].isEmpty()) {oe[0] = "0";}
						if(oe[1].isEmpty()) {oe[1] = "0";}
						if(oe[2].isEmpty()) {oe[2] = "0";}


						txtMC1.setText(ma[0]);
						txtMM1.setText(me[0]);
						txtMC2.setText(ma[1]);
						txtMM2.setText(me[1]);
						txtMC3.setText(ma[2]);
						txtMM3.setText(me[2]);
						txtMC4.setText(ma[3]);
						txtMM4.setText(me[3]);
						txtMC5.setText(ma[4]);
						txtMM5.setText(me[4]);
						txtMC6.setText(ma[5]);
						txtMM6.setText(me[5]);
						txtMC7.setText(ma[6]);
						txtMM7.setText(me[6]);
						txtMC8.setText(ma[7]);
						txtMM8.setText(me[7]);
						txtMC9.setText(ma[8]);
						txtMM9.setText(me[8]);
						txtMC10.setText(ma[9]);
						txtMM10.setText(me[9]);

						sprc1.setValue(Integer.parseInt(ra[0]));
						sprm1.setValue(Integer.parseInt(re[0]));
						sprc1.setValue(Integer.parseInt(ra[1]));
						sprm1.setValue(Integer.parseInt(re[1]));
						sprc1.setValue(Integer.parseInt(ra[2]));
						sprm1.setValue(Integer.parseInt(re[2]));
						sprc1.setValue(Integer.parseInt(ra[3]));
						sprm1.setValue(Integer.parseInt(re[3]));

						txtOC1.setText(oa[0]);
						spom1.setValue(Integer.parseInt(oe[0]));
						txtOC1.setText(oa[1]);
						spom1.setValue(Integer.parseInt(oe[1]));
						txtOC1.setText(oa[2]);
						spom1.setValue(Integer.parseInt(oe[2]));

						ol = 1000;
					}else {
						//						System.out.println(strCurrentLine);
					}
				}
				//			
				message = "File Opened";
			} catch (FileNotFoundException e) {
				//				e.printStackTrace();
				txtFile.setForeground(Color.RED);	
				reality = false;
				txtCommand.setForeground(Color.RED);
				message = "File Failed To Open";

			}

			txtCommand.setText(txtCommand.getText() + message + "\n");
		}
	}
	
	public void Save(String x){

		String a = x.substring(0,2) + "-" + x.substring(5,7) + "-" + x.substring(10);
		final String FILENAME = "C:\\Invoiceia Alpha\\" + x.substring(0,2) + "\\" + x.substring(5,7) + "\\"+ a +".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			message = "Saving File n. " + a;
			txtCommand.setText(txtCommand.getText() + message + "\n");

			String content;
			content = "S\n" + x.substring(0, 2) + "\n/\n";
			content += "C\n" + x.substring(10) + "\n/\n";
			content += "Y\n" + x.substring(5, 7) + "\n/\n";

			//Material
			content += "M\n";
			content += txtMC1.getText() + "\n" + txtMM1.getText() + "\n-\n";
			content += txtMC2.getText() + "\n" + txtMM2.getText() + "\n-\n";
			content += txtMC3.getText() + "\n" + txtMM3.getText() + "\n-\n";
			content += txtMC4.getText() + "\n" + txtMM4.getText() + "\n-\n";
			content += txtMC5.getText() + "\n" + txtMM5.getText() + "\n-\n";
			content += txtMC6.getText() + "\n" + txtMM6.getText() + "\n-\n";
			content += txtMC7.getText() + "\n" + txtMM7.getText() + "\n-\n";
			content += txtMC8.getText() + "\n" + txtMM8.getText() + "\n";
			content += "/\n";


			//Rhinestones
			content += "R\n";
			content += sprc1.getValue() + "\n" + sprm1.getValue() + "\n-\n";
			content += sprc2.getValue() + "\n" + sprm2.getValue() + "\n-\n";
			content += sprc3.getValue() + "\n" + sprm3.getValue() + "\n-\n";
			content += sprc4.getValue() + "\n" + sprm4.getValue() + "\n";
			content += "/\n";

			//Other
			content += "O\n";
			content += txtOC1.getText() + "\n" + spom1.getValue() + "\n-\n";
			content += txtOC2.getText() + "\n" + spom2.getValue() + "\n-\n";
			content += txtOC3.getText() + "\n" + spom3.getValue() + "\n";
			content += "/\n";

			content += "K\n" + spK.getValue() + "\n/\n";
			content += "H\n" + Double.parseDouble(txtH.getText()) + "\n/\n";
			content += "D\n" + spDep.getValue() + "\n/\n";
			content += "e";

			bw.write(content);

			// no need to close it.
			//bw.close();

			//			System.out.println("Done");

			message = "File n. " + a + " Saved";
			txtCommand.setText(txtCommand.getText() + message + "\n");

		} catch (IOException e) {  e.printStackTrace();  }



		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Embit User\\eclipse-workspace\\kiad\\src\\kiada\\Saves.txt"))) {



		} catch (IOException e) {  e.printStackTrace();  }
	}
}
