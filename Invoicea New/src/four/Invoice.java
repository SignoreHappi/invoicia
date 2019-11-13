package four;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.*;
import javax.swing.text.MaskFormatter;

import database.DBConnect;
import database.Database;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.Choice;
import java.awt.List;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;

public class Invoice {

	NumberFormat money = NumberFormat.getCurrencyInstance();


	public JRadioButton rdbGroup = new JRadioButton("Group");
	public JRadioButton rdbSolo = new JRadioButton("Solo, Duet, Trio");

	private JFrame frame;
	private JTable table;

	protected JTextField txtStudio;
	public JTextField txtOwner;
	public JTextField txtPhone;
	public JTextField txtAddress;
	public JTextField txtEmail;
	protected JTextField txtMC1;
	public JTextField txtMM1;
	public JTextField txtMM2;
	public JTextField txtMC2;
	public JTextField txtMM3;
	public JTextField txtMC3;
	public JTextField txtMM4;
	public JTextField txtMC4;
	public JTextField txtMM5;
	public JTextField txtMC5;
	public JTextField txtMM6;
	public JTextField txtMC6;
	public JTextField txtMM7;
	public JTextField txtMC7;
	public JTextField txtMM8;
	public JTextField txtMC8;
	public JTextField txtMM9;
	public JTextField txtMC9;
	public JTextField txtMM10;
	public JTextField txtMC10;


	protected JPanel PInvoice;
	private JPanel panel_6;
	private JPanel panel_7;
	protected JPanel Settings;

	private JLabel lblOther;
	private JLabel lblRhynestones;

	public JTextField txtOC1;
	public JTextField txtOM1;
	public JTextField txtOM2;
	public JTextField txtOC2;
	public JTextField txtOM3;
	public JTextField txtOC3;
	public JTextField txtOM4;
	public JTextField txtOC4;

	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	private JLabel lbsMaterial;
	private JLabel lbsBottom;
	private JLabel lbsCPC;
	private JLabel lbsRhinestone;
	private JLabel lbsHours;
	private JLabel lbsOther;
	private JLabel lbsTotal;
	private JLabel lbsSubtotal;
	private JLabel lbsDeposit;

	public JTextField txtDD;
	public JSpinner spnHH = new JSpinner();
	public JSpinner spnK = new JSpinner();
	public JTextField txtFS;
	public JLabel lblLine;

	public JSpinner spnRT1;
	public JSpinner spnRT2;
	public JSpinner spnRT3;
	public JSpinner spnRT4;

	public JSpinner spnRS1;
	public JSpinner spnRS2;
	public JSpinner spnRS3;
	public JSpinner spnRS4;

	public JSpinner spnRA1;
	public JSpinner spnRA2;
	public JSpinner spnRA3;
	public JSpinner spnRA4;

	public JComboBox spnSS;
	public JComboBox spnMaterialType;

	private String ma[] = new String [10];
	private String me[] = new String [10];
	private String oa[] = new String [4];
	private String oe[] = new String [4];
	private String ra[] = new String [4];
	private String rt[] = new String [4];
	private String rs[] = new String [4];
	public int years;

	public JLabel lblCommand12;
	public JLabel lblCommand11;
	public JLabel lblCommand10;
	public JLabel lblCommand9;
	public JLabel lblCommand8;
	public JLabel lblCommand7;
	public JLabel lblCommand6;
	public JLabel lblCommand5;
	public JLabel lblCommand4;
	public JLabel lblCommand3;
	public JLabel lblCommand2;
	public JLabel lblCommand1;

	public JLabel lblMCommand12;
	public JLabel lblMCommand11;
	public JLabel lblMCommand10;
	public JLabel lblMCommand9;
	public JLabel lblMCommand8;
	public JLabel lblMCommand7;
	public JLabel lblMCommand6;
	public JLabel lblMCommand5;
	public JLabel lblMCommand4;
	public JLabel lblMCommand3;
	public JLabel lblMCommand2;
	public JLabel lblMCommand1;

	private final double TAX = 0.13;
	private String FS, FY, FC;


	public JLabel lblCostumeX = new JLabel("** - ** - ***");
	public JLabel lblStudioX  = new JLabel("Xxxx Xxxx");

	private String com = "";


	private int a, c, line = 0;
	private double b;
	private String s;


	public int customer, dateGiven, monthGiven, year, costume, dateDone, monthDone, check;

	public static BufferedImage dancer, icon;
	private JTextField txtName;
	private JTextField txtCost;
	private JTable table_1;


	public static DefaultTableModel materialTable;
	public static Connection connect;
	public static JTextField txtSearchMaterial;
	public static String materialSearch = null;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		//		Database.LoadMaterials();

		try {
			Invoice window = new Invoice();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}




	private MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}

	/**
	 * Create the application.
	 */
	public Invoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//		inventoryScreen = ImageLoader.loadImage("/textures/Inventory.png");
		dancer = ImageLoader.loadImage("/images/Canada-Leaf-Free-PNG-Image.png");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Invoice.class.getResource("/images/KIDLogo.png")));
		frame.setBounds(0, 5, screenSize.width, screenSize.height - 50);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));


		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				DBConnect.CloseDatabase();
			}
		});


		//		System.out.println(screenSize.width);
		//		System.out.println(screenSize.height);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//		tabbedPane.setBounds(0, 0, 1274, 945);
		frame.getContentPane().add(tabbedPane);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 18));

		PInvoice = new JPanel();
		PInvoice.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("Invoice", new ImageIcon(Invoice.class.getResource("/images/Invoice icon.png")), PInvoice, null);
		PInvoice.setLayout(null);

		PInvoice.show();

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(250, 128, 114));
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(10, 11, 270, 381);
		PInvoice.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaterial.setBounds(10, 11, 250, 24);
		panel_5.add(lblMaterial);

		txtMC1 = new JTextField();
		txtMC1.setBounds(10, 46, 86, 20);
		panel_5.add(txtMC1);
		txtMC1.setColumns(10);

		txtMM1 = new JTextField();
		txtMM1.setColumns(10);
		txtMM1.setBounds(174, 46, 86, 20);
		panel_5.add(txtMM1);

		txtMM2 = new JTextField();
		txtMM2.setColumns(10);
		txtMM2.setBounds(174, 77, 86, 20);
		panel_5.add(txtMM2);

		txtMC2 = new JTextField();
		txtMC2.setColumns(10);
		txtMC2.setBounds(10, 77, 86, 20);
		panel_5.add(txtMC2);

		txtMM3 = new JTextField();
		txtMM3.setColumns(10);
		txtMM3.setBounds(174, 108, 86, 20);
		panel_5.add(txtMM3);

		txtMC3 = new JTextField();
		txtMC3.setColumns(10);
		txtMC3.setBounds(10, 108, 86, 20);
		panel_5.add(txtMC3);

		txtMM4 = new JTextField();
		txtMM4.setColumns(10);
		txtMM4.setBounds(174, 139, 86, 20);
		panel_5.add(txtMM4);

		txtMC4 = new JTextField();
		txtMC4.setColumns(10);
		txtMC4.setBounds(10, 139, 86, 20);
		panel_5.add(txtMC4);

		txtMM5 = new JTextField();
		txtMM5.setColumns(10);
		txtMM5.setBounds(174, 170, 86, 20);
		panel_5.add(txtMM5);

		txtMC5 = new JTextField();
		txtMC5.setColumns(10);
		txtMC5.setBounds(10, 170, 86, 20);
		panel_5.add(txtMC5);

		txtMM6 = new JTextField();
		txtMM6.setColumns(10);
		txtMM6.setBounds(174, 201, 86, 20);
		panel_5.add(txtMM6);

		txtMC6 = new JTextField();
		txtMC6.setColumns(10);
		txtMC6.setBounds(10, 201, 86, 20);
		panel_5.add(txtMC6);

		txtMM7 = new JTextField();
		txtMM7.setColumns(10);
		txtMM7.setBounds(174, 232, 86, 20);
		panel_5.add(txtMM7);

		txtMC7 = new JTextField();
		txtMC7.setColumns(10);
		txtMC7.setBounds(10, 232, 86, 20);
		panel_5.add(txtMC7);

		txtMM8 = new JTextField();
		txtMM8.setColumns(10);
		txtMM8.setBounds(174, 263, 86, 20);
		panel_5.add(txtMM8);

		txtMC8 = new JTextField();
		txtMC8.setColumns(10);
		txtMC8.setBounds(10, 263, 86, 20);
		panel_5.add(txtMC8);

		txtMM9 = new JTextField();
		txtMM9.setColumns(10);
		txtMM9.setBounds(174, 294, 86, 20);
		panel_5.add(txtMM9);

		txtMC9 = new JTextField();
		txtMC9.setColumns(10);
		txtMC9.setBounds(10, 294, 86, 20);
		panel_5.add(txtMC9);

		txtMM10 = new JTextField();
		txtMM10.setColumns(10);
		txtMM10.setBounds(174, 325, 86, 20);
		panel_5.add(txtMM10);

		txtMC10 = new JTextField();
		txtMC10.setColumns(10);
		txtMC10.setBounds(10, 325, 86, 20);
		panel_5.add(txtMC10);

		JLabel lblMcm10 = new JLabel("Cost | Meters");
		lblMcm10.setBounds(96, 328, 78, 14);
		panel_5.add(lblMcm10);
		lblMcm10.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm10.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm9 = new JLabel("Cost | Meters");
		lblMcm9.setBounds(96, 297, 78, 14);
		panel_5.add(lblMcm9);
		lblMcm9.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm9.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm8 = new JLabel("Cost | Meters");
		lblMcm8.setBounds(96, 266, 78, 14);
		panel_5.add(lblMcm8);
		lblMcm8.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm8.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm7 = new JLabel("Cost | Meters");
		lblMcm7.setBounds(96, 235, 78, 14);
		panel_5.add(lblMcm7);
		lblMcm7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm7.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm6 = new JLabel("Cost | Meters");
		lblMcm6.setBounds(96, 204, 78, 14);
		panel_5.add(lblMcm6);
		lblMcm6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm6.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm5 = new JLabel("Cost | Meters");
		lblMcm5.setBounds(96, 173, 78, 14);
		panel_5.add(lblMcm5);
		lblMcm5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm5.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm4 = new JLabel("Cost | Meters");
		lblMcm4.setBounds(96, 142, 78, 14);
		panel_5.add(lblMcm4);
		lblMcm4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm4.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm3 = new JLabel("Cost | Meters");
		lblMcm3.setBounds(96, 111, 78, 14);
		panel_5.add(lblMcm3);
		lblMcm3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm3.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm2 = new JLabel("Cost | Meters");
		lblMcm2.setBounds(96, 80, 78, 14);
		panel_5.add(lblMcm2);
		lblMcm2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm2.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblMcm1 = new JLabel("Cost | Meters");
		lblMcm1.setBounds(96, 49, 78, 14);
		panel_5.add(lblMcm1);
		lblMcm1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMcm1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(255, 204, 102));
		panel_6.setBounds(570, 11, 270, 194);
		PInvoice.add(panel_6);

		lblRhynestones = new JLabel("RHINESTONES");
		lblRhynestones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRhynestones.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRhynestones.setBounds(10, 11, 250, 24);
		panel_6.add(lblRhynestones);

		JSpinner spnRT4 = new JSpinner();
		spnRT4.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT4.setBounds(10, 139, 83, 20);
		panel_6.add(spnRT4);

		JSpinner spnRT3 = new JSpinner();
		spnRT3.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT3.setBounds(10, 108, 83, 20);
		panel_6.add(spnRT3);

		JSpinner spnRT2 = new JSpinner();
		spnRT2.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT2.setBounds(10, 77, 83, 20);
		panel_6.add(spnRT2);

		JSpinner spnRT1 = new JSpinner();
		spnRT1.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT1.setBounds(10, 46, 83, 20);
		panel_6.add(spnRT1);

		JSpinner spnRA1 = new JSpinner();
		spnRA1.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA1.setBounds(177, 46, 83, 20);
		panel_6.add(spnRA1);

		JSpinner spnRA2 = new JSpinner();
		spnRA2.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA2.setBounds(177, 78, 83, 20);
		panel_6.add(spnRA2);

		JSpinner spnRA3 = new JSpinner();
		spnRA3.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA3.setBounds(177, 109, 83, 20);
		panel_6.add(spnRA3);

		JSpinner spnRA4 = new JSpinner();
		spnRA4.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA4.setBounds(177, 140, 83, 20);
		panel_6.add(spnRA4);

		JSpinner spnRS1 = new JSpinner();
		spnRS1.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS1.setBounds(103, 46, 64, 20);
		panel_6.add(spnRS1);

		JSpinner spnRS2 = new JSpinner();
		spnRS2.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS2.setBounds(103, 78, 64, 20);
		panel_6.add(spnRS2);

		JSpinner spnRS3 = new JSpinner();
		spnRS3.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS3.setBounds(103, 109, 64, 20);
		panel_6.add(spnRS3);

		JSpinner spnRS4 = new JSpinner();
		spnRS4.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS4.setBounds(103, 140, 64, 20);
		panel_6.add(spnRS4);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setBackground(new Color(153, 153, 51));
		panel_7.setBounds(290, 216, 270, 176);
		PInvoice.add(panel_7);

		lblOther = new JLabel("OTHER\r\n");
		lblOther.setHorizontalAlignment(SwingConstants.CENTER);
		lblOther.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOther.setBounds(10, 11, 250, 24);
		panel_7.add(lblOther);

		txtOC1 = new JTextField();
		txtOC1.setColumns(10);
		txtOC1.setBounds(10, 46, 86, 20);
		panel_7.add(txtOC1);

		txtOM1 = new JTextField();
		txtOM1.setColumns(10);
		txtOM1.setBounds(174, 46, 86, 20);
		panel_7.add(txtOM1);

		txtOM2 = new JTextField();
		txtOM2.setColumns(10);
		txtOM2.setBounds(174, 77, 86, 20);
		panel_7.add(txtOM2);

		txtOC2 = new JTextField();
		txtOC2.setColumns(10);
		txtOC2.setBounds(10, 77, 86, 20);
		panel_7.add(txtOC2);

		txtOM3 = new JTextField();
		txtOM3.setColumns(10);
		txtOM3.setBounds(174, 108, 86, 20);
		panel_7.add(txtOM3);

		txtOC3 = new JTextField();
		txtOC3.setColumns(10);
		txtOC3.setBounds(10, 108, 86, 20);
		panel_7.add(txtOC3);

		txtOM4 = new JTextField();
		txtOM4.setColumns(10);
		txtOM4.setBounds(174, 139, 86, 20);
		panel_7.add(txtOM4);

		txtOC4 = new JTextField();
		txtOC4.setColumns(10);
		txtOC4.setBounds(10, 139, 86, 20);
		panel_7.add(txtOC4);

		label_5 = new JLabel("Cost | Meters");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_5.setBounds(96, 142, 78, 14);
		panel_7.add(label_5);

		label_6 = new JLabel("Cost | Meters");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_6.setBounds(96, 111, 78, 14);
		panel_7.add(label_6);

		label_7 = new JLabel("Cost | Meters");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_7.setBounds(96, 80, 78, 14);
		panel_7.add(label_7);

		label_8 = new JLabel("Cost | Meters");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_8.setBounds(96, 49, 78, 14);
		panel_7.add(label_8);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_8.setBackground(new Color(153, 255, 153));
		panel_8.setBounds(570, 571, 270, 87);
		PInvoice.add(panel_8);

		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDeposit.setBounds(10, 11, 250, 24);
		panel_8.add(lblDeposit);

		JLabel lblDepositAmmount = new JLabel("Deposit Ammount");
		lblDepositAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositAmmount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDepositAmmount.setBounds(10, 46, 109, 20);
		panel_8.add(lblDepositAmmount);

		txtDD = new JTextField();
		txtDD.setBounds(151, 46, 109, 20);
		panel_8.add(txtDD);
		txtDD.setColumns(10);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_10.setBackground(new Color(255, 255, 102));
		panel_10.setBounds(570, 473, 270, 87);
		PInvoice.add(panel_10);

		JLabel lblStudio = new JLabel("STUDIO");
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStudio.setBounds(10, 11, 250, 24);
		panel_10.add(lblStudio);

		JLabel lblCostumeNo = new JLabel("Studio");
		lblCostumeNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostumeNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCostumeNo.setBounds(10, 48, 59, 14);
		panel_10.add(lblCostumeNo);

		spnSS = new JComboBox();
		spnSS.setModel(new DefaultComboBoxModel(new String[] {"Kids In Dance", "Evolve Dance Centre", "Maple Dance Acadamy", "CB Dance Acadamy", "The Eight Count"}));
		spnSS.setBounds(79, 46, 181, 20);
		panel_10.add(spnSS);


		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_12.setBackground(new Color(153, 255, 255));
		panel_12.setBounds(290, 11, 268, 194);
		PInvoice.add(panel_12);

		JLabel lblHours = new JLabel("HOURS");
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHours.setBounds(10, 11, 109, 24);
		panel_12.add(lblHours);

		JLabel lblHours_1 = new JLabel("Hours");
		lblHours_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHours_1.setBounds(10, 59, 122, 14);
		panel_12.add(lblHours_1);

		//		JSpinner spnHH = new JSpinner();
		spnHH.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spnHH.setBounds(142, 57, 83, 20);
		panel_12.add(spnHH);
		spnHH.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		//		JSpinner spnK = new JSpinner();
		spnK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnK.setBounds(142, 95, 83, 20);
		panel_12.add(spnK);

		JLabel label = new JLabel("Kids");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(10, 98, 122, 14);
		panel_12.add(label);
		rdbSolo.setBackground(new Color(153, 255, 255));


		rdbSolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbSolo.isSelected()) {
					rdbGroup.setSelected(false);
					output("IV","Solo selected");
				}else {
					rdbGroup.setSelected(true);
					output("IV","Group selected");
				}
			}

		});
		rdbSolo.setBounds(36, 125, 189, 23);
		panel_12.add(rdbSolo);
		rdbGroup.setBackground(new Color(153, 255, 255));


		rdbGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbGroup.isSelected()) {
					rdbSolo.setSelected(false);
					output("IV","Group selected");
				}else {
					rdbSolo.setSelected(true);
					output("IV","Solo selected");
				}
			}
		});
		rdbGroup.setSelected(true);
		rdbGroup.setBounds(36, 151, 189, 23);
		panel_12.add(rdbGroup);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_9.setBackground(new Color(204, 204, 204));
		panel_9.setBounds(570, 216, 270, 246);
		PInvoice.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblFileSearch = new JLabel("FILE SEARCH  /  LOGIN");
		lblFileSearch.setBounds(10, 7, 250, 24);
		lblFileSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_9.add(lblFileSearch);

		txtFS = new JTextField();
		txtFS.setEnabled(false);
		txtFS.setEditable(false);
		txtFS.setVisible(false);
		txtFS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyPressed(KeyEvent enter) {
				if(enter.getKeyCode() == KeyEvent.VK_ENTER) {
					if(txtFS.getText().equals("6054")) {
						output("III","Welcome Admin");
					}else if(txtFS.getText().equals("4444")) {
						output("III", "Welcome User");
					}else if(txtFS.getText().equals("1234")) {
						output("III", "Welcome User");
					}else if(txtFS.getText().length() == 9){
						try {
							reada(txtFS.getText());
							output("II", "Read Complete");
						}catch(FileNotFoundException e) {
							output("IX", "User; File Could Not Be Found");
						} catch (IOException e) {
							output("IX", "User; Please enter a correct file number or sequence");
						} catch(IndexOutOfBoundsException e) {
							output("IX", "User; Please enter a correct file number or sequence");
						} 
					}else {
						output("IX", "User; Please enter a correct file number or sequence");
						output("IX", "User; Example :   ##-##-###");
					}
				}
			}
		});
		txtFS.setBounds(140, 41, 120, 22);
		panel_9.add(txtFS);
		txtFS.setColumns(10);

		JButton btnClear = new JButton("RESET");
		btnClear.setBounds(10, 73, 120, 30);
		panel_9.add(btnClear);

		JButton btnSave = new JButton("Create");
		btnSave.setBounds(140, 73, 120, 30);
		panel_9.add(btnSave);
		btnSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//"Kids In Dance", "Evolve Dance Centre", "Maple Dance Acadamy", "CB Dance Acadamy", "The Eight Count"
				int studio_id = 0;
				String studio_name = spnSS.getSelectedItem().toString();
				switch(studio_name){
				case "Kids In Dance":
					studio_id = 0;
					break;
				case "Evolve Dance Centre":
					studio_id = 1;
					break;
				case "Maple Dance Acadamy":
					studio_id = 2;
					break;
				case "CB Dance Acadamy":
					studio_id = 3;
					break;
				case "The Eight Count":
					studio_id = 4;
					break;
				}
				output("Studio ID", " "+ studio_id );
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM");  
				LocalDateTime now = LocalDateTime.now();  

				String date = dtf.format(now);

				String month = date.substring(3, 5);
				String year = date.substring(0, 2);


				int iMonth = Integer.parseInt(month);
				int iYear = 0;
				if(iMonth >= 7) {
					iYear = Integer.parseInt(year);
					iYear++;
					year = String.valueOf(iYear);
				}


				output("Month", " "+ month);
				output("Year", " "+ iYear);

				int invoice_id = Database.HasInvoice(studio_id);
				if(invoice_id == 0) {
					Database.CreateNewInvoice(studio_id, iYear);
				}else {
					Database.CreateInvoice(studio_id, invoice_id, iYear);
				}
			}
		});

		JButton button_2 = new JButton("?2");
		button_2.setBounds(140, 114, 120, 30);
		panel_9.add(button_2);

		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.EditInvoice(txtFS.getText());
			}
		});
		btnSave_1.setBounds(10, 114, 120, 30);
		panel_9.add(btnSave_1);



		JButton btnPrintout = new JButton("Printout 1");
		btnPrintout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					output("V", "- -/Printout 1/- - -");
					Fill();
					for(int i = 0; i < 10; i++) {
						if(!ma[i].isEmpty()) {
							output("V", ma[i] + " * " + me[i] + " = " + Double.parseDouble(ma[i]) * Double.parseDouble(me[i]));
						}
					}
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					//					e.printStackTrace();
					output("IX", "Null");
				}

			}
		});
		btnPrintout.setBounds(10, 155, 120, 30);
		panel_9.add(btnPrintout);

		JButton btnPrintout_1 = new JButton("Printout 2");
		btnPrintout_1.setBounds(10, 196, 120, 30);
		panel_9.add(btnPrintout_1);

		JButton btnPrintout_2 = new JButton("Printout 3");
		btnPrintout_2.setBounds(140, 155, 120, 30);
		panel_9.add(btnPrintout_2);

		JButton btnInformation = new JButton("Information");
		btnInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output("?", "Version Incoive Gamma");
				output("?", "D://Invoice Gamma//");
				output("?", "Last Modified:     Oct/19");
				output("?", "- -/End of Information/- - -");
			}
		});
		btnInformation.setBounds(140, 196, 120, 30);
		panel_9.add(btnInformation);



		JFormattedTextField ftfSearch = new JFormattedTextField(createFormatter("##-##-###"));
		ftfSearch.setBounds(10, 41, 120, 24);
		panel_9.add(ftfSearch);

		JFormattedTextField ftfLogin = new JFormattedTextField(createFormatter("####"));
		ftfLogin.setBounds(140, 43, 120, 24);
		panel_9.add(ftfLogin);
		ftfLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyPressed(KeyEvent enter) {
				if(enter.getKeyCode() == KeyEvent.VK_ENTER) {
					if(ftfLogin.getText().equals("6054")) {
						output("III","Welcome Admin");
					}else if(ftfLogin.getText().equals("4444")) {
						output("III", "Welcome User");
					}else if(ftfLogin.getText().equals("1234")) {
						output("III", "Welcome User");
					}else if(ftfLogin.getText().length() == 9){
						try {
							reada(ftfLogin.getText());
							output("II", "Read Complete");
						}catch(FileNotFoundException e) {
							output("IX", "User; File Could Not Be Found");
						} catch (IOException e) {
							output("IX", "User; Please enter a correct file number or sequence");
						} catch(IndexOutOfBoundsException e) {
							output("IX", "User; Please enter a correct file number or sequence");
						} 
					}else {
						output("IX", "User; Please enter a correct file number or sequence");
						output("IX", "User; Example :   ##-##-###");
					}
				}
			}
		});

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(204, 255, 102));
		panel_13.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_13.setBounds(850, 535, 270, 123);
		PInvoice.add(panel_13);
		panel_13.setLayout(null);

		JLabel lblSubmit = new JLabel("SUBMIT");
		lblSubmit.setBounds(10, 11, 243, 24);
		lblSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_13.add(lblSubmit);

		JButton btnQuoteTax = new JButton("QUOTE TAX");
		btnQuoteTax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnQuoteTax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output("I","Starting Invoice Taxed");
			}
		});
		btnQuoteTax.setBounds(10, 82, 120, 30);
		panel_13.add(btnQuoteTax);

		JButton btnQuote = new JButton("QUOTE");
		btnQuote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output("I","Starting Quote");
				Fill();
				material();
			}
		});
		btnQuote.setBounds(10, 45, 120, 30);
		panel_13.add(btnQuote);

		JButton btnInvoice = new JButton("INVOICE");
		btnInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output("I","Starting Invoice");
			}
		});
		btnInvoice.setBounds(140, 45, 120, 30);
		panel_13.add(btnInvoice);

		JButton btnInvoiceTax = new JButton("INVOICE TAX");
		btnInvoiceTax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output("I","Starting Invoice");
			}
		});
		btnInvoiceTax.setBounds(140, 82, 120, 30);
		panel_13.add(btnInvoiceTax);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(850, 11, 270, 513);
		PInvoice.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRecipt = new JLabel("RECIPT");
		lblRecipt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRecipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipt.setBounds(10, 11, 250, 27);
		panel_1.add(lblRecipt);

		JLabel lblMaterial_1 = new JLabel("Material");
		lblMaterial_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaterial_1.setBounds(10, 133, 90, 17);
		panel_1.add(lblMaterial_1);

		JLabel lblHours_2 = new JLabel("Hours");
		lblHours_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHours_2.setBounds(10, 161, 90, 17);
		panel_1.add(lblHours_2);

		JLabel lblRhinestone = new JLabel("Rhinestone");
		lblRhinestone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRhinestone.setBounds(10, 189, 90, 17);
		panel_1.add(lblRhinestone);

		JLabel lblOther_1 = new JLabel("Other");
		lblOther_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOther_1.setBounds(10, 217, 90, 17);
		panel_1.add(lblOther_1);

		JLabel lblDeposit_1 = new JLabel("Deposit");
		lblDeposit_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeposit_1.setBounds(10, 245, 90, 17);
		panel_1.add(lblDeposit_1);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtotal.setBounds(10, 273, 90, 17);
		panel_1.add(lblSubtotal);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(10, 329, 90, 17);
		panel_1.add(lblTotal);

		JLabel lblCostPerCostume = new JLabel("Cost per Costume");
		lblCostPerCostume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostPerCostume.setBounds(10, 357, 122, 17);
		panel_1.add(lblCostPerCostume);

		JLabel lblStudioName_1 = new JLabel("Studio Name");
		lblStudioName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudioName_1.setBounds(10, 49, 90, 17);
		panel_1.add(lblStudioName_1);

		JLabel lblCostume = new JLabel("Costumes");
		lblCostume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostume.setBounds(155, 49, 105, 17);
		panel_1.add(lblCostume);

		//		lblStudioX.setText("Xxxx Xxxx");
		lblStudioX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudioX.setBounds(10, 77, 90, 17);
		panel_1.add(lblStudioX);

		lblCostumeX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostumeX.setBounds(155, 77, 105, 17);
		panel_1.add(lblCostumeX);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 153, 0));
		separator.setBounds(10, 100, 250, 4);
		separator.setSize(250, 4);
		panel_1.add(separator);

		JLabel lblFileType = new JLabel("File Type");
		lblFileType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFileType.setBounds(10, 105, 90, 17);
		panel_1.add(lblFileType);

		lbsTotal = new JLabel("$ 0.00");
		lbsTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsTotal.setBounds(170, 329, 90, 17);
		panel_1.add(lbsTotal);

		JLabel label_9 = new JLabel("% 13");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(170, 301, 90, 17);
		panel_1.add(label_9);

		lbsDeposit = new JLabel("$ 0.00");
		lbsDeposit.setForeground(new Color(255, 0, 0));
		lbsDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsDeposit.setBounds(170, 245, 90, 17);
		panel_1.add(lbsDeposit);

		lbsSubtotal = new JLabel("$ 0.00");
		lbsSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsSubtotal.setBounds(170, 273, 90, 17);
		panel_1.add(lbsSubtotal);

		lbsRhinestone = new JLabel("$ 0.00");
		lbsRhinestone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsRhinestone.setBounds(170, 189, 90, 17);
		panel_1.add(lbsRhinestone);

		lbsOther = new JLabel("$ 0.00");
		lbsOther.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsOther.setBounds(170, 217, 90, 17);
		panel_1.add(lbsOther);

		lbsMaterial = new JLabel("$ 0.00");
		lbsMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsMaterial.setBounds(170, 133, 90, 17);
		panel_1.add(lbsMaterial);

		lbsHours = new JLabel("$ 0.00");
		lbsHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsHours.setBounds(170, 161, 90, 17);
		panel_1.add(lbsHours);

		JLabel lblInvoiceOrQuote = new JLabel("INVOICE or QUOTE ");
		lblInvoiceOrQuote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceOrQuote.setBounds(138, 105, 122, 17);
		panel_1.add(lblInvoiceOrQuote);

		JLabel lblAmountOwing = new JLabel("Amount Owing");
		lblAmountOwing.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountOwing.setBounds(10, 475, 122, 26);
		panel_1.add(lblAmountOwing);

		lbsBottom = new JLabel("$ 0.00");
		lbsBottom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsBottom.setBounds(138, 475, 122, 27);
		panel_1.add(lbsBottom);

		JLabel lblTotal_1 = new JLabel("Tax");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal_1.setBounds(10, 301, 90, 17);
		panel_1.add(lblTotal_1);

		lbsCPC = new JLabel("$ 0.00");
		lbsCPC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsCPC.setBounds(170, 357, 90, 17);
		panel_1.add(lbsCPC);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 403, 550, 255);
		PInvoice.add(panel_3);
		panel_3.setLayout(null);

		lblCommand1 = new JLabel("|");
		lblCommand1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand1.setForeground(new Color(51, 153, 0));
		lblCommand1.setBounds(10, 230, 530, 14);
		panel_3.add(lblCommand1);

		lblCommand2 = new JLabel("_");
		lblCommand2.setForeground(new Color(51, 153, 0));
		lblCommand2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand2.setBounds(10, 210, 530, 14);
		panel_3.add(lblCommand2);

		lblCommand3 = new JLabel("_");
		lblCommand3.setForeground(new Color(51, 153, 0));
		lblCommand3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand3.setBounds(10, 190, 530, 14);
		panel_3.add(lblCommand3);

		lblCommand4 = new JLabel("_");
		lblCommand4.setForeground(new Color(51, 153, 0));
		lblCommand4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand4.setBounds(10, 170, 530, 14);
		panel_3.add(lblCommand4);

		lblCommand5 = new JLabel("_");
		lblCommand5.setForeground(new Color(51, 153, 0));
		lblCommand5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand5.setBounds(10, 150, 530, 14);
		panel_3.add(lblCommand5);

		lblCommand6 = new JLabel("_");
		lblCommand6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand6.setForeground(new Color(51, 153, 0));
		lblCommand6.setBounds(10, 130, 530, 14);
		panel_3.add(lblCommand6);

		lblCommand7 = new JLabel("_");
		lblCommand7.setForeground(new Color(51, 153, 0));
		lblCommand7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand7.setBounds(10, 110, 530, 14);
		panel_3.add(lblCommand7);

		lblCommand8 = new JLabel("_");
		lblCommand8.setBounds(10, 90, 530, 14);
		panel_3.add(lblCommand8);
		lblCommand8.setForeground(new Color(51, 153, 0));
		lblCommand8.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblCommand9 = new JLabel("_");
		lblCommand9.setForeground(new Color(51, 153, 0));
		lblCommand9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand9.setBounds(10, 70, 530, 14);
		panel_3.add(lblCommand9);

		lblCommand10 = new JLabel("_");
		lblCommand10.setForeground(new Color(51, 153, 0));
		lblCommand10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand10.setBounds(10, 50, 530, 14);
		panel_3.add(lblCommand10);

		lblCommand11 = new JLabel("_");
		lblCommand11.setForeground(new Color(51, 153, 0));
		lblCommand11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand11.setBounds(10, 30, 530, 14);
		panel_3.add(lblCommand11);

		lblCommand12 = new JLabel("_");
		lblCommand12.setForeground(new Color(51, 153, 0));
		lblCommand12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand12.setBounds(10, 10, 530, 14);
		panel_3.add(lblCommand12);

		JButton btnTestCommand = new JButton("test - command");
		btnTestCommand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				output("0","Salut");
			}
		});
		btnTestCommand.setBounds(646, 667, 118, 23);
		PInvoice.add(btnTestCommand);

		JPanel Clients = new JPanel();
		Clients.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("Clients", new ImageIcon(Invoice.class.getResource("/images/icon-client.png")), Clients, null);
		Clients.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table.setBackground(new Color(255, 228, 196));
		table.setBounds(0, 11, screenSize.width - 10, 561);
		DefaultTableModel d = new DefaultTableModel();
		d.addColumn("ONE");
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Name", "№ Costumes", "Total Bill", "Owner", "Address", "Phone Number", "Email Address"},
					{"Kids In Dance", "0", "0", "Corinne Moore", "100 Penn Dr. Toronto ON, CANADA   L6S 3B3 Unit 5 ", "(416) 571-4863", "corinne.moore@kidsindance.com"},
					{"Evolve Dance Centre", "0", "0", "Katie Martin", null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
						"", "No. Costumes", "Total Bill", "Owner", "Address", "Phone Number", "Email Address"
				}
				));
		//		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		//		table.getColumnModel().getColumn(1).setPreferredWidth(78);
		table.getColumnModel().getColumn(4).setPreferredWidth(280);
		//		table.getColumnModel().getColumn(5).setPreferredWidth(1);
		table.getColumnModel().getColumn(6).setPreferredWidth(261);
		Clients.add(table);

		txtStudio = new JTextField();
		txtStudio.setBounds(130, 626, 225, 20);
		Clients.add(txtStudio);
		txtStudio.setColumns(10);

		txtOwner = new JTextField();
		txtOwner.setBounds(130, 657, 225, 20);
		Clients.add(txtOwner);
		txtOwner.setColumns(10);




		txtPhone = new JTextField();
		txtPhone.setToolTipText("Phone Number eg 1234567890 [123 456 7890]");
		txtPhone.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPhone.setText("");
			}
		});
		txtPhone.setBounds(130, 688, 225, 20);
		Clients.add(txtPhone);
		txtPhone.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtAddress.setText("");
			}
		});
		txtAddress.setToolTipText("# street, city province, country, postal-code");
		txtAddress.setBounds(130, 719, 225, 20);
		Clients.add(txtAddress);
		txtAddress.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(130, 750, 225, 20);
		Clients.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblStudioName = new JLabel("Studio Name");
		lblStudioName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudioName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStudioName.setBounds(10, 626, 110, 20);
		Clients.add(lblStudioName);

		JLabel lblOwnerName = new JLabel("Owner Name\r\n");
		lblOwnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOwnerName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOwnerName.setBounds(10, 657, 110, 20);
		Clients.add(lblOwnerName);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 688, 110, 20);
		Clients.add(lblPhoneNumber);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(10, 719, 110, 20);
		Clients.add(lblAddress);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmailAddress.setBounds(10, 750, 110, 20);
		Clients.add(lblEmailAddress);

		JLabel lblLineNumber = new JLabel("Line Number");
		lblLineNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLineNumber.setBounds(10, 595, 110, 20);
		Clients.add(lblLineNumber);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSubmit.setBounds(245, 795, 110, 33);
		Clients.add(btnSubmit);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(283, 583, 29, 20);
		Clients.add(spinner_1);

		JPanel Material = new JPanel();       
		Material.setBackground(new Color(255, 204, 255));
		tabbedPane.addTab("Material", new ImageIcon(Invoice.class.getResource("/images/icon-fabric.png")), Material, null);
		Material.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(255, 255, 153));
		panel_4.setBounds(1126, 189, 271, 172);
		Material.add(panel_4);
		panel_4.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(175, 11, 86, 20);
		panel_4.add(txtName);
		txtName.setColumns(10);

		txtCost = new JTextField();
		txtCost.setText("");
		txtCost.setBounds(175, 56, 86, 20);
		panel_4.add(txtCost);
		txtCost.setColumns(10);

		JLabel lblName = new JLabel("Material Name :");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblName.setBounds(10, 14, 155, 14);
		panel_4.add(lblName);

		JLabel lblCost = new JLabel("Material Cost per Meter :");
		lblCost.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCost.setBounds(10, 59, 155, 17);
		panel_4.add(lblCost);

		JButton btnMaterial = new JButton("S U B M I T");
		btnMaterial.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnMaterial.setBounds(67, 129, 134, 32);
		panel_4.add(btnMaterial);

		JLabel lblMaterialType = new JLabel("Material Type :");
		lblMaterialType.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaterialType.setBounds(10, 101, 155, 17);
		panel_4.add(lblMaterialType);

		spnMaterialType = new JComboBox();
		spnMaterialType.setModel(new DefaultComboBoxModel(new String[] {"Velvet", "Mesh", "Lycra", "Toulle", "Hologram", "Cracked Ice", "Mystique",
				"Organdy", "Fringe", "Supplex", "Trim", "Cosmo", "Print", "Chiffon", "Sequin", "Georgette", "Unknown"}));
		spnMaterialType.setBounds(175, 98, 86, 20);
		panel_4.add(spnMaterialType);

		btnMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean success;
				success = Database.CreateMaterial(txtName.getText(), txtCost.getText(), spnMaterialType.getSelectedItem().toString());
				txtName.setText("");
				txtCost.setText("");
				if(success) {
					mOutput("Material", "Added");
				}else {
					mOutput("Material", "Something went wrong");
				}
				Database.LoadMaterials();

			}
		});



		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_11.setBackground(Color.DARK_GRAY);
		//		panel_11.setBounds(846, 328, 550, 255);

		panel_11.setBounds(screenSize.width - 580, screenSize.height - 395, 550, 255);
		Material.add(panel_11);

		lblMCommand1 = new JLabel("|");
		lblMCommand1.setForeground(new Color(51, 153, 0));
		lblMCommand1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand1.setBounds(10, 230, 530, 14);
		panel_11.add(lblMCommand1);

		lblMCommand2 = new JLabel("_");
		lblMCommand2.setForeground(new Color(51, 153, 0));
		lblMCommand2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand2.setBounds(10, 210, 530, 14);
		panel_11.add(lblMCommand2);

		lblMCommand3 = new JLabel("_");
		lblMCommand3.setForeground(new Color(51, 153, 0));
		lblMCommand3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand3.setBounds(10, 190, 530, 14);
		panel_11.add(lblMCommand3);

		lblMCommand4 = new JLabel("_");
		lblMCommand4.setForeground(new Color(51, 153, 0));
		lblMCommand4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand4.setBounds(10, 170, 530, 14);
		panel_11.add(lblMCommand4);

		lblMCommand5 = new JLabel("_");
		lblMCommand5.setForeground(new Color(51, 153, 0));
		lblMCommand5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand5.setBounds(10, 150, 530, 14);
		panel_11.add(lblMCommand5);

		lblMCommand6 = new JLabel("_");
		lblMCommand6.setForeground(new Color(51, 153, 0));
		lblMCommand6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand6.setBounds(10, 130, 530, 14);
		panel_11.add(lblMCommand6);

		lblMCommand7 = new JLabel("_");
		lblMCommand7.setForeground(new Color(51, 153, 0));
		lblMCommand7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand7.setBounds(10, 110, 530, 14);
		panel_11.add(lblMCommand7);

		lblMCommand8 = new JLabel("_");
		lblMCommand8.setForeground(new Color(51, 153, 0));
		lblMCommand8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand8.setBounds(10, 90, 530, 14);
		panel_11.add(lblMCommand8);

		lblMCommand9 = new JLabel("_");
		lblMCommand9.setForeground(new Color(51, 153, 0));
		lblMCommand9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand9.setBounds(10, 70, 530, 14);
		panel_11.add(lblMCommand9);

		lblMCommand10 = new JLabel("_");
		lblMCommand10.setForeground(new Color(51, 153, 0));
		lblMCommand10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand10.setBounds(10, 50, 530, 14);
		panel_11.add(lblMCommand10);

		lblMCommand11 = new JLabel("_");
		lblMCommand11.setForeground(new Color(51, 153, 0));
		lblMCommand11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand11.setBounds(10, 30, 530, 14);
		panel_11.add(lblMCommand11);

		lblMCommand12 = new JLabel("_");
		lblMCommand12.setForeground(new Color(51, 153, 0));
		lblMCommand12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMCommand12.setBounds(10, 11, 530, 14);
		panel_11.add(lblMCommand12);

		JPanel panel_14 = new JPanel();
		panel_14.setBounds(75, 46, 630, 664);
		Material.add(panel_14);




		materialTable= new DefaultTableModel(); 
		JTable tableMaterial= new JTable(materialTable); 
		materialTable.addColumn("Material Id");
		materialTable.addColumn("Material Name");
		materialTable.addColumn("Material Type");
		materialTable.addColumn("Material Cost");


		JPanel materialTablePanel = new JPanel();
		materialTablePanel.setBounds(84, 5, 462, 412);

		materialTablePanel.add(new JScrollPane(tableMaterial));
		materialTablePanel.setVisible(true);
		panel_14.setLayout(null);
		tableMaterial.setSize(600, 800);
		panel_14.add(materialTablePanel);

		txtSearchMaterial = new JTextField();
		txtSearchMaterial.setBounds(254, 475, 96, 19);
		panel_14.add(txtSearchMaterial);
		txtSearchMaterial.setColumns(10);


		JButton btnUpdateTable = new JButton("Update Table");
		btnUpdateTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.LoadMaterials();
			}
		});
		btnUpdateTable.setBounds(265, 515, 155, 41);
		panel_14.add(btnUpdateTable);

		txtSearchMaterial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyPressed(KeyEvent enter) {
				Database.SearchMaterial(enter, materialSearch);
			}
		});

		Database.LoadMaterials();






		JPanel Rhynestones = new JPanel();
		tabbedPane.addTab("Rhynestones", new ImageIcon(Invoice.class.getResource("/images/Rhinestone icon.png")), Rhynestones, null);

		Settings = new JPanel();
		tabbedPane.addTab("Settings", new ImageIcon(Invoice.class.getResource("/images/Settings icon.png")), Settings, null);
		Settings.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(10, 11, 181, 52);
		Settings.add(panel);
		panel.setLayout(null);

		JButton btnDirectoryUpdate = new JButton("Directory Update");
		btnDirectoryUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					Warning WarnUpdate = new Warning();
					WarnUpdate.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDirectoryUpdate.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnDirectoryUpdate.setBounds(10, 11, 161, 29);
		panel.add(btnDirectoryUpdate);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 204, 153));
		panel_2.setBounds(10, 74, 181, 52);
		Settings.add(panel_2);

		JButton button = new JButton("Tutorial");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Tutorial tutorial = new Tutorial();
					tutorial.frame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		button.setBounds(10, 11, 161, 29);
		panel_2.add(button);

	}

	private void math() {

	}

	private void Number() {
		Date date = new Date();

		if(dateGiven == 0) {
			dateGiven = date.getDate();
			monthGiven = date.getMonth();
			year = date.getYear();
			//			customer = (int) spnSS.getValue();
		}
		//customer, costume, dateDone, monthDone, check

	}

	protected void Fill() {

		ma[0] = txtMC1.getText();
		ma[1] = txtMC2.getText();
		ma[2] = txtMC3.getText();
		ma[3] = txtMC4.getText();
		ma[4] = txtMC5.getText();
		ma[5] = txtMC6.getText();
		ma[6] = txtMC7.getText();
		ma[7] = txtMC8.getText();
		ma[8] = txtMC9.getText();
		ma[9] = txtMC10.getText();

		me[0] = txtMM1.getText();
		me[1] = txtMM2.getText();
		me[2] = txtMM3.getText();
		me[3] = txtMM4.getText();
		me[4] = txtMM5.getText();
		me[5] = txtMM6.getText();
		me[6] = txtMM7.getText();
		me[7] = txtMM8.getText();
		me[8] = txtMM9.getText();
		me[9] = txtMM10.getText();

		//		output("0",ma + "");
	}
	private void Filli() {

		txtMC1.setText(ma[0]);
		output("0","ma(0)" + txtMM1.getText());
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

		txtOC1.setText(oa[0]);
		txtOM1.setText(oe[0]);
		txtOC2.setText(oa[1]);
		txtOM2.setText(oe[1]);
		txtOC3.setText(oa[2]);
		txtOM3.setText(oe[2]);
		txtOC4.setText(oa[3]);
		txtOM4.setText(oe[3]);
	}

	public void output(String catagory, String text) {
		text = "{" + catagory + "}- " + text;

		switch(line) {
		case 0: lblCommand12.setText(text);break;
		case 1: lblCommand11.setText(text);break;
		case 2: lblCommand10.setText(text);break;
		case 3: lblCommand9.setText(text);break;
		case 4: lblCommand8.setText(text);break;
		case 5: lblCommand8.setText(text);break;
		case 6: lblCommand7.setText(text);break;
		case 7: lblCommand6.setText(text);break;
		case 8: lblCommand5.setText(text);break;
		case 9: lblCommand4.setText(text);break;
		case 10: lblCommand3.setText(text);break;
		case 11: lblCommand2.setText(text);break;
		case 12: lblCommand1.setText(text);break;
		}

		line++;

		if(line >= 14) {
			lblCommand12.setText(lblCommand11.getText());
			lblCommand11.setText(lblCommand10.getText());
			lblCommand10.setText(lblCommand9.getText());
			lblCommand9.setText(lblCommand8.getText());
			lblCommand8.setText(lblCommand7.getText());
			lblCommand7.setText(lblCommand6.getText());
			lblCommand6.setText(lblCommand5.getText());
			lblCommand5.setText(lblCommand4.getText());
			lblCommand4.setText(lblCommand3.getText());
			lblCommand3.setText(lblCommand2.getText());
			lblCommand2.setText(lblCommand1.getText());
			lblCommand1.setText(text);
		}
	}

	public void mOutput(String catagory, String text) {
		text = "{" + catagory + "}- " + text;

		switch(line) {
		case 0: lblMCommand12.setText(text);break;
		case 1: lblMCommand11.setText(text);break;
		case 2: lblMCommand10.setText(text);break;
		case 3: lblMCommand9.setText(text);break;
		case 4: lblMCommand8.setText(text);break;
		case 5: lblMCommand8.setText(text);break;
		case 6: lblMCommand7.setText(text);break;
		case 7: lblMCommand6.setText(text);break;
		case 8: lblMCommand5.setText(text);break;
		case 9: lblMCommand4.setText(text);break;
		case 10: lblMCommand3.setText(text);break;
		case 11: lblMCommand2.setText(text);break;
		case 12: lblMCommand1.setText(text);break;
		}

		line++;

		if(line >= 14) {
			lblMCommand12.setText(lblMCommand11.getText());
			lblMCommand11.setText(lblMCommand10.getText());
			lblMCommand10.setText(lblMCommand9.getText());
			lblMCommand9.setText(lblMCommand8.getText());
			lblMCommand8.setText(lblMCommand7.getText());
			lblMCommand7.setText(lblMCommand6.getText());
			lblMCommand6.setText(lblMCommand5.getText());
			lblMCommand5.setText(lblMCommand4.getText());
			lblMCommand4.setText(lblMCommand3.getText());
			lblMCommand3.setText(lblMCommand2.getText());
			lblMCommand2.setText(lblMCommand1.getText());
			lblMCommand1.setText(text);
		}
	}

	public void material(){
		double answer = 0;
		for(int i = 0; i < 10; i++) {
			if(!ma[i].isEmpty()) {
				answer = answer + Double.parseDouble(ma[i]) * Double.parseDouble(me[i]);
			}
		}
		lbsMaterial.setText("" + money.format(answer));
	}
































	//-----------------------------------------------------------------------------------------------// R E A D A //-------------------------------------------------------


	public void reada(String x) throws IOException {
		boolean reality = true;
		int ol = 0;
		String studio = "";
		int G; // G = (0 or 1)

		switch(x.substring(0, 2)) {
		case "00": studio = "Kids In Dance"; break;
		case "01": studio = "Evolve Dance Centre";break;
		case "02": studio = "Maple Dance Acadamy";break;
		case "03": studio = "CB Dance Acadamy";break;
		case "04": studio = "The Eight Count";break;
		case "05": studio = "";break;
		case "06": studio = "";break;
		case "07": studio = "";break;
		case "08": studio = "";break;
		case "09": studio = "";break;
		default  : studio = "Kids In Dance"; break;
		}




		if(x.substring(3,5).equals("19")) {

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
					rt[t] = "";
					rs[t] = "";
				}
				for(int t = 0; t < 4; t++) {
					oa[t] = "";
					oe[t] = "";
				}

				try {
					BufferedReader br = new BufferedReader(new FileReader("C:\\Invoiceia Alpha\\" + x.substring(0, 2) + "\\" + x.substring(3, 5) + "\\" + x +".txt"));
					String strCurrentLine = "";
					//				txtFile.setForeground(Color.BLACK);
					//				txtCommand.setForeground(Color.GREEN);

					//				message = "Opening File n. " + x;
					//				txtCommand.setText(txtCommand.getText()  + message + "\n");


					//				(strCurrentLine != "-" || strCurrentLine != "e" || strCurrentLine != "/" || strCurrentLine != "+")  		 || strCurrentLine.equals("null")
					for(int i = 0; i < 1000; i++) {
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
									System.out.println(ma[m] + "*17");
									strCurrentLine = br.readLine();
									me[m] = (strCurrentLine);
									System.out.println(me[m] + "*177");
								}else {
									ma[m] = (strCurrentLine);
									System.out.println(ma[m] + "*16");
									strCurrentLine = br.readLine();
									me[m] = (strCurrentLine);
									System.out.println(me[m] + "*166");
								}
							}

						}else if(strCurrentLine.equals("R")){
							if(years == 19) {
								System.out.println(strCurrentLine + "*19");
							}else {
								System.out.println(years);
								for(int m = 0; m < 100; m++) {
									strCurrentLine = br.readLine();
									if(strCurrentLine.equals("/")) {
										m = 10000;
									}else if(strCurrentLine.equals("-")) {
										strCurrentLine = br.readLine();
										rt[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*1");
										strCurrentLine = br.readLine();
										rs[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*2");
										strCurrentLine = br.readLine();
										ra[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*3");
									}else {
										rt[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*4");
										strCurrentLine = br.readLine();
										rs[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*5");
										strCurrentLine = br.readLine();
										ra[m] = (strCurrentLine);
										System.out.println(strCurrentLine + "*9");
									}
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
							spnK.setValue(Double.parseDouble(strCurrentLine));
							//							output("", (strCurrentLine));
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("D")){
							strCurrentLine = br.readLine();
							txtDD.setText(strCurrentLine);
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("C")){
							strCurrentLine = br.readLine();
							lblCostumeX.setText(lblCostumeX.getText() + strCurrentLine);
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("Y")){
							strCurrentLine = br.readLine();
							lblCostumeX.setText(lblCostumeX.getText() + strCurrentLine + " - ");
							years = Integer.parseInt(strCurrentLine);
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("S")){
							strCurrentLine = br.readLine();
							lblCostumeX.setText(strCurrentLine + " - ");
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("H")){
							strCurrentLine = br.readLine();
							spnHH.setValue(Double.parseDouble(strCurrentLine));
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("e")){
							i = 100 * 100;
							System.out.println("MAMAM");

							if(ma[0].isEmpty()) {ma[0] = "0";}
							if(ma[1].isEmpty()) {ma[1] = "0";}
							if(ma[2].isEmpty()) {ma[2] = "0";}
							if(ma[3].isEmpty()) {ma[3] = "0";}
							if(ma[4].isEmpty()) {ma[4] = "0";}
							if(ma[5].isEmpty()) {ma[5] = "0";}
							if(ma[6].isEmpty()) {ma[6] = "0";}
							if(ma[7].isEmpty()) {ma[7] = "0";}
							if(ma[8].isEmpty()) {ma[8] = "0";}
							if(ma[9].isEmpty())	 {ma[9] = "0";}

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
							if(oa[3].isEmpty()) {oa[3] = "0";}

							if(rt[0].isEmpty()) {rt[0] = "0";}
							if(rt[1].isEmpty()) {rt[1] = "0";}
							if(rt[2].isEmpty()) {rt[2] = "0";}
							if(rt[3].isEmpty()) {rt[3] = "0";}

							if(rs[0].isEmpty()) {rs[0] = "0";}
							if(rs[1].isEmpty()) {rs[1] = "0";}
							if(rs[2].isEmpty()) {rs[2] = "0";}
							if(rs[3].isEmpty()) {rs[3] = "0";}

							if(oe[0].isEmpty()) {oe[0] = "0";}
							if(oe[1].isEmpty()) {oe[1] = "0";}
							if(oe[2].isEmpty()) {oe[2] = "0";}

							//							output("0","end");
							Filli();


							ol = 1000;
						}else {
							//						System.out.println(strCurrentLine);
						}
					}
					lblCostumeX.setText(x.substring(0, 2) + " - " + x.substring(3, 5) + " - " + x.substring(6));
					output("II", "Read Successful");

					//			
					//				message = "File Opened";
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					//					txtFS.setForeground(Color.RED);	
					output("IX", "User; File Could Not Be Found");
					reality = false;
					//				txtCommand.setForeground(Color.RED);
					//				message = "File Failed To Open";

				}
			}

			//			txtCommand.setText(txtCommand.getText() + message + "\n");


		}else {

		}
	}


	//-----------------------------------------------------------------------------------------------// S A V E //-------------------------------------------------------
	public void Save(String x){

		String studio = "";
		int G; // G = (0 or 1)

		switch(x.substring(0, 2)) {
		case "00": studio = "Kids In Dance"; break;
		case "01": studio = "Evolve Dance Centre";break;
		case "02": studio = "Maple Dance Acadamy";break;
		case "03": studio = "CB Dance Acadamy";break;
		case "04": studio = "The Eight Count";break;
		case "05": studio = "";break;
		case "06": studio = "";break;
		case "07": studio = "";break;
		case "08": studio = "";break;
		case "09": studio = "";break;
		default  : studio = "Kids In Dance"; break;
		}

		String a = x.substring(0,2) + "-" + x.substring(5,7) + "-" + x.substring(10);
		final String FILENAME = "D:\\Invoice Gamma\\" + studio + "\\" + x.substring(5,7) + "\\"+ a +".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			//			message = "Saving File n. " + a;
			//			txtCommand.setText(txtCommand.getText() + message + "\n");

			String content;
			content = "S\n" + x.substring(0, 2) + "\n/\n";
			content += "Y\n" + x.substring(5, 7) + "\n/\n";
			content += "C\n" + x.substring(10) + "\n/\n";

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
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n";
			content += "/\n";

			//Other
			content += "O\n";
			content += txtOC1.getText() + "\n" + txtOM1.getText() + "\n-\n";
			content += txtOC2.getText() + "\n" + txtOM2.getText() + "\n-\n";
			content += txtOC3.getText() + "\n" + txtOM3.getText() + "\n";
			content += "/\n";

			content += "G\n" + spnK.getValue() + "\n/\n";
			content += "H\n" + spnHH.getValue() + "\n/\n";
			content += "D\n" + Double.valueOf(txtDD.getText()) + "\n/\n";

			content += "e";

			bw.write(content);

			// no need to close it.
			//bw.close();

			//			System.out.println("Done");

			//			message = "File n. " + a + " Saved";
			//			txtCommand.setText(txtCommand.getText() + message + "\n");

		} catch (IOException e) {  e.printStackTrace();  }



		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Embit User\\eclipse-workspace\\kiad\\src\\kiada\\Saves.txt"))) {



		} catch (IOException e) {  e.printStackTrace();  }
	}
}
