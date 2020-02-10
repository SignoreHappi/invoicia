package four;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import javax.swing.text.MaskFormatter;





import database.DBConnect;
import database.Database;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.Choice;
import java.awt.List;
import java.awt.Point;
import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;

public class Invoice {

	NumberFormat money = NumberFormat.getCurrencyInstance();


	public static JRadioButton rdbGroup = new JRadioButton("Group");
	public static JRadioButton rdbSolo = new JRadioButton("Solo, Duet, Trio");

	private JFrame frame;
	//	private JTable table;

	protected JTextField txtStudio;
	public JTextField txtOwner;
	public JTextField txtPhone;
	public JTextField txtAddress;
	public JTextField txtEmail;
	//	protected JComboBox txtMC1;
	public JTextField txtMM1;
	public JTextField txtMM2;
	//	public JComboBox txtMC2;
	public JTextField txtMM3;
	//	public JComboBox txtMC3;
	public JTextField txtMM4;
	//	public JComboBox txtMC4;
	public JTextField txtMM5;
	//	public JComboBox txtMC5;
	public JTextField txtMM6;
	//	public JComboBox txtMC6;
	public JTextField txtMM7;
	//	public JComboBox txtMC7;
	public JTextField txtMM8;
	//	public JComboBox txtMC8;
	public JTextField txtMM9;
	//	public JComboBox txtMC9;
	public JTextField txtMM10;
	//	public JComboBox txtMC10;


	protected JPanel PInvoice;
	private JPanel pnlRhinestones;
	protected JPanel Settings;

	private JPanel pnlOverWrite;
	private JPanel pnlConsole;
	private JPanel pnlFile;

	private static JLabel lblRhynestones;
	private static JLabel lbsMaterial;
	private static JLabel lbsBottom;
	private static JLabel lbsCPC;
	private static JLabel lbsRhinestone;
	private static JLabel lbsHours;
	private static JLabel lbsTotal;
	private static JLabel lbsSubtotal;
	public static JLabel lbsDeposit;
	public JLabel lblLine;

	public static JSpinner spnHH = new JSpinner();
	public static JSpinner spnK = new JSpinner();
	public static JSpinner spnGroup;
	public static JSpinner spnSolo;
	public static JSpinner spnHourly;

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

	public static JSpinner spnDeposit;

	public static JComboBox cmbStudio;
	public JComboBox spnMaterialType;

	private String ma[] = new String [10];
	private String me[] = new String [10];
	private String oa[] = new String [4];
	private String oe[] = new String [4];
	private String ra[] = new String [4];
	private String rt[] = new String [4];
	private String rs[] = new String [4];

	public int years;

	public static JLabel lblCommand11;
	public static JLabel lblCommand10;
	public static JLabel lblCommand9;
	public static JLabel lblCommand8;
	public static JLabel lblCommand7;
	public static JLabel lblCommand6;
	public static JLabel lblCommand5;
	public static JLabel lblCommand4;
	public static JLabel lblCommand3;
	public static JLabel lblCommand2;
	public static JLabel lblCommand1;

	public static JLabel lblMCommand12;
	public static JLabel lblMCommand11;
	public static JLabel lblMCommand10;
	public static JLabel lblMCommand9;
	public static JLabel lblMCommand8;
	public static JLabel lblMCommand7;
	public static JLabel lblMCommand6;
	public static JLabel lblMCommand5;
	public static JLabel lblMCommand4;
	public static JLabel lblMCommand3;
	public static JLabel lblMCommand2;
	public static JLabel lblMCommand1;

	public static JLabel lblCCommand12;
	public static JLabel lblCCommand11;
	public static JLabel lblCCommand10;
	public static JLabel lblCCommand9;
	public static JLabel lblCCommand8;
	public static JLabel lblCCommand7;
	public static JLabel lblCCommand6;
	public static JLabel lblCCommand5;
	public static JLabel lblCCommand4;
	public static JLabel lblCCommand3;
	public static JLabel lblCCommand2;
	public static JLabel lblCCommand1;

	public static JLabel lblMaterialName0;
	public static JLabel lblMaterialName1;
	public static JLabel lblMaterialName2;
	public static JLabel lblMaterialName3;
	public static JLabel lblMaterialName4;
	public static  JLabel lblMaterialName8;
	public static  JLabel lblMaterialName7;
	public static  JLabel lblMaterialName6;
	public static  JLabel lblMaterialName5;
	public static  JLabel lblMaterialName9;

	public static  JLabel lblMaterialAmount0;
	public static  JLabel lblMaterialAmount1;
	public static  JLabel lblMaterialAmount2;
	public static  JLabel lblMaterialAmount3;
	public static  JLabel lblMaterialAmount4;
	public static  JLabel lblMaterialAmount8;
	public static  JLabel lblMaterialAmount5;
	public static  JLabel lblMaterialAmount6;
	public static  JLabel lblMaterialAmount7;
	public static  JLabel lblMaterialAmount9;

	public static  JLabel lblX0;
	public static  JLabel lblX1;
	public static  JLabel lblX2;
	public static  JLabel lblX3;
	public static  JLabel lblX4;
	public static  JLabel lblX5;
	public static  JLabel lblX6;
	public static  JLabel lblX7;
	public static  JLabel lblX8;
	public static  JLabel lblX9;

	//	private double tax = 0.13;
	private int hourly = 30, Evolve = 50;
	//	private String FS, FY, FC;


	public static JLabel lblInvoiceNumberR = new JLabel("** - ** - ***");
	public static JLabel lblStudioNameR  = new JLabel("Xxxx Xxxx");
	public static JLabel lblCostumeNameR  = new JLabel("Xxxx Xxxx");
	public static JLabel lblInvoiceOrQuote  = new JLabel("INVOICE or QUOTE");

	//	private String com = "";


	//	private int a, c;


	private static int line = 0;
	//	private double b;
	//	private String s;


	public int customer, dateGiven, monthGiven, year, costume, dateDone, monthDone, check;

	public static BufferedImage dancer, icon;
	private JTextField txtName;
	private JTextField txtCost;
	//	private JTable table_1;


	public static DefaultTableModel materialTable;
	public static Connection connect;
	public static JTextField txtSearchMaterial;
	public static String materialSearch = null;
	public static JTable tableMaterial;


	public static DefaultTableModel clientsTable;
	public static JTable tableClients;
	public static DefaultTableModel rows;
	public static JTable testTable;

	public static DefaultTableModel homeMaterialTbl;	
	public static JTable homeMaterialJTbl;
	public static String clientsSearch = null;

	public static String searching = null;

	public static String[][] selectedMaterials = new String [3][10];
	public static int[][] yearsInvoices = new int [2][20];

	public static int result = 0;

	public static JButton btnAddMaterial;

	public static JFrame updateTable;
	public static JTextField txtCostumeName;

	public static JComboBox cmbStudioName;
	public static JComboBox cmbYear;
	public static JComboBox cmbInvoiceId;

	private JFormattedTextField ftfSearch;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy  HH:mm:ss"); 

	private Date date = new Date();
	private LocalDateTime now = LocalDateTime.now(); 

	public static JButton btnCreate;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws SQLException, InterruptedException, IOException {

		//		Database.ExportDB();

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
		Database.StartInvoice();
	}

	private int Close() {

//		Database.CreateDate(dtf.format(now) + "");

		return 1;
	}

	private void Clear() {
		txtStudio.setText(null);
		txtOwner.setText(null);

		// R E C E I P T//
		lblStudioNameR.setText("Xxxx Xxxx");
		lblInvoiceNumberR.setText("** - ** - ***");
		lblCostumeNameR.setText("Xxxx Xxxx");
		lblInvoiceOrQuote.setText("INVOICE or QUOTE");
		//-------------------------------------------
		lbsMaterial.setText("$ 0.00");
		lbsHours.setText("$ 0.00");
		lbsRhinestone.setText("$ 0.00");
		lbsDeposit.setText("$ 0.00");
		lbsSubtotal.setText("$ 0.00");
		lbsTotal.setText("$ 0.00");
		lbsCPC.setText("$ 0.00");
		lbsBottom.setText("$ 0.00");

		// S T U D I O//
		cmbStudio.setSelectedIndex(0);
		txtCostumeName.setText(null);

		// 	H O U R S  /  G R O U P S//
		spnHH.setValue("0");
		spnK.setValue("0");
		rdbGroup.setSelected(true);
		rdbSolo.setSelected(false);

		// R H I N E S T O N E S//
		spnRT4.setValue("AB");
		spnRT3.setValue("AB");
		spnRT2.setValue("AB");
		spnRT1.setValue("AB");

		spnRA4.setValue("0");
		spnRA3.setValue("0");
		spnRA2.setValue("0");
		spnRA1.setValue("0");

		spnRS4.setValue("20");
		spnRS3.setValue("20");
		spnRS2.setValue("20");
		spnRS1.setValue("20");

		// D E P O S I T//
		spnDeposit.setValue("0");

		// F I L E   S E A R C H//
		ftfSearch.setText(null);
		cmbStudioName.setSelectedIndex(0);

		// C O M M A N D//
		lblCommand1.setText("-");
		lblCommand2.setText("-");
		lblCommand3.setText("-");
		lblCommand4.setText("-");
		lblCommand5.setText("-");
		lblCommand6.setText("-");
		lblCommand7.setText("-");
		lblCommand8.setText("-");
		lblCommand9.setText("-");
		lblCommand10.setText("-");
		lblCommand11.setText("-");



		// M A T E R I A L S//
		for(int i = 0; i < selectedMaterials.length; i++) {
			selectedMaterials[i][i] = null;
		}

		lblMaterialName0.setText("");
		lblMaterialName1.setText("");
		lblMaterialName2.setText("");
		lblMaterialName3.setText("");
		lblMaterialName4.setText("");
		lblMaterialName5.setText("");
		lblMaterialName6.setText("");
		lblMaterialName7.setText("");
		lblMaterialName8.setText("");
		lblMaterialName9.setText("");

		lblMaterialAmount0.setText("");
		lblMaterialAmount1.setText("");
		lblMaterialAmount2.setText("");
		lblMaterialAmount3.setText("");
		lblMaterialAmount4.setText("");
		lblMaterialAmount5.setText("");
		lblMaterialAmount6.setText("");
		lblMaterialAmount7.setText("");
		lblMaterialAmount8.setText("");
		lblMaterialAmount9.setText("");


		lblX0.setVisible(false);
		lblX1.setVisible(false);
		lblX2.setVisible(false);
		lblX3.setVisible(false);
		lblX4.setVisible(false);
		lblX5.setVisible(false);
		lblX6.setVisible(false);
		lblX7.setVisible(false);
		lblX8.setVisible(false);
		lblX9.setVisible(false);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {



		int HpWidth = 1366, HpHeight = 768;



		////		inventoryScreen = ImageLoader.loadImage("/textures/Iventory.png");
		//		dancer = loadImage("/images/Canada-Leaf-Free-PNG-Image.png");

		//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Invoice.class.getResource("/images/KIDLogo.png")));
		frame.setDefaultCloseOperation(Close());
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		//		frame.setBounds(0, 5, screenSize.width, screenSize.height - 50);	// Screen Auto Detect
		frame.setBounds(0, 5, HpWidth, HpHeight);							// Screen HP Computer


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

		JPanel pnlMaterial = new JPanel();
		pnlMaterial.setBackground(new Color(250, 128, 114));
		pnlMaterial.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlMaterial.setBounds(10, 310, 550, 358);
		PInvoice.add(pnlMaterial);
		pnlMaterial.setLayout(null);


		homeMaterialTbl = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {return false;}
		};
		homeMaterialTbl.addColumn("Material Name");
		homeMaterialTbl.addColumn("Material Type");
		homeMaterialTbl.addColumn("Material Price");


		btnAddMaterial = new JButton("Add Material");
		btnAddMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnAddMaterial.isEnabled()) {
					int row = homeMaterialJTbl.getSelectedRow();
					String name = homeMaterialJTbl.getValueAt(row, 0).toString();
					String type = homeMaterialJTbl.getValueAt(row, 1).toString();
					if(selectedMaterials[0][9] != null){
						JOptionPane.showMessageDialog(null, "Maximum of 10 materials!",  "Error!", JOptionPane.ERROR_MESSAGE);

					}else {

						String amount = JOptionPane.showInputDialog(null, "How much of " + name + " " + type + " do you want to use?");
						if(amount != null) {							
							try {
								double intAmount = Double.parseDouble(amount);
								int count = 0;
								if(intAmount == 999) {
									lblMaterialName0.setText(1 + ".    " + "Assorted Lycra");
									lblMaterialAmount0.setText("101");
									lblMaterialName1.setText(2 + ".    " + "Assorted Lycra");
									lblMaterialAmount1.setText("101");
									lblMaterialName2.setText(3 + ".    " + "Assorted Lycra");
									lblMaterialAmount2.setText("101");
									lblMaterialName3.setText(4 + ".    " + "Assorted Lycra");
									lblMaterialAmount3.setText("101");
									lblMaterialName4.setText(5 + ".    " + "Assorted Lycra");
									lblMaterialAmount4.setText("101");
									lblMaterialName5.setText(6 + ".    " + "Assorted Lycra");
									lblMaterialAmount5.setText("101");
									lblMaterialName6.setText(7 + ".    " + "Assorted Lycra");
									lblMaterialAmount6.setText("101");
									lblMaterialName7.setText(8 + ".    " + "Assorted Lycra");
									lblMaterialAmount7.setText("101");

									lblX0.setText(" X");
									lblX1.setText(" X");
									lblX2.setText(" X");
									lblX3.setText(" X");
									lblX4.setText(" X");
									lblX5.setText(" X");
									lblX6.setText(" X");
									lblX7.setText(" X");

									for(count = 0; count < 8; count++) {
										//								if(selectedMaterials[0][count] == null) {
										selectedMaterials[0][count] = "Assorted" + "." + "Lycra";
										selectedMaterials[1][count] = "101";
										selectedMaterials[2][count] = "10";
										//								}

									}
									count = 7;
								}else {
									for(count = 0; count < 10; count++) {
										if(selectedMaterials[0][count] == null) {
											selectedMaterials[0][count] = name + "." + type;
											selectedMaterials[1][count] = amount;
											selectedMaterials[2][count] = null;
											switch(count) {
											case 0:
												lblMaterialName0.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount0.setText(amount);
												lblX0.setText(" X");

												break;
											case 1:
												lblMaterialName1.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount1.setText(amount);
												lblX1.setText(" X");
												break;
											case 2:
												lblMaterialName2.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount2.setText(amount);
												lblX2.setText(" X");
												break;
											case 3:
												lblMaterialName3.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount3.setText(amount);
												lblX3.setText(" X");
												break;
											case 4:
												lblMaterialName4.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount4.setText(amount);
												lblX4.setText(" X");
												break;
											case 5:
												lblMaterialName5.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount5.setText(amount);
												lblX5.setText(" X");
												break;
											case 6:
												lblMaterialName6.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount6.setText(amount);
												lblX6.setText(" X");
												break;
											case 7:
												lblMaterialName7.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount7.setText(amount);
												lblX7.setText(" X");
												break;
											case 8:
												lblMaterialName8.setText(count+1 + ".    " + name + " " + type);
												lblMaterialAmount8.setText(amount);
												lblX8.setText(" X");
												break;
											case 9:
												lblMaterialName9.setText(count+1 + ".  " + name + " " + type);
												lblMaterialAmount9.setText(amount);
												lblX9.setText(" X");
												break;
											}

											break;
										}

									}

								}

								btnCreate.setEnabled(true);
							}catch (NumberFormatException ex){
								JOptionPane.showMessageDialog(null, "Give me a number!",  "Error!", JOptionPane.ERROR_MESSAGE);
							}
						}


					}


				}
			}
		});
		btnAddMaterial.setEnabled(false);
		btnAddMaterial.setBounds(351, 46, 133, 23);
		pnlMaterial.add(btnAddMaterial);

		homeMaterialJTbl = new JTable(homeMaterialTbl);
		JScrollPane homeMaterialScroll = new JScrollPane(homeMaterialJTbl);
		homeMaterialScroll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.equals(KeyEvent.VK_ADD)) {
					System.out.println("Enter");
				}
			}
		});
		homeMaterialScroll.setLocation(20,46);
		pnlMaterial.add(homeMaterialScroll);
		homeMaterialScroll.setSize(297,302);


		homeMaterialJTbl.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = homeMaterialJTbl.rowAtPoint(evt.getPoint());
				//		        System.out.println(row);
				btnAddMaterial.setEnabled(true);
			}
		});




		JLabel lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterial.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaterial.setBounds(10, 11, 250, 24);
		pnlMaterial.add(lblMaterial);

		lblMaterialName0 = new JLabel("");
		lblMaterialName0.setBounds(345, 79, 179, 13);
		pnlMaterial.add(lblMaterialName0);

		lblMaterialName1 = new JLabel("");
		lblMaterialName1.setBounds(345, 102, 179, 13);
		pnlMaterial.add(lblMaterialName1);

		lblMaterialName2 = new JLabel("");
		lblMaterialName2.setBounds(345, 125, 179, 13);
		pnlMaterial.add(lblMaterialName2);

		lblMaterialName3 = new JLabel("");
		lblMaterialName3.setBounds(345, 148, 179, 13);
		pnlMaterial.add(lblMaterialName3);

		lblMaterialName4 = new JLabel("");
		lblMaterialName4.setBounds(345, 171, 179, 13);
		pnlMaterial.add(lblMaterialName4);

		lblMaterialName8 = new JLabel("");
		lblMaterialName8.setBounds(345, 263, 179, 13);
		pnlMaterial.add(lblMaterialName8);

		lblMaterialName7 = new JLabel("");
		lblMaterialName7.setBounds(345, 240, 179, 13);
		pnlMaterial.add(lblMaterialName7);

		lblMaterialName6 = new JLabel("");
		lblMaterialName6.setBounds(345, 217, 179, 13);
		pnlMaterial.add(lblMaterialName6);

		lblMaterialName5 = new JLabel("");
		lblMaterialName5.setBounds(345, 194, 179, 13);
		pnlMaterial.add(lblMaterialName5);

		lblMaterialName9 = new JLabel("");
		lblMaterialName9.setBounds(345, 286, 179, 13);
		pnlMaterial.add(lblMaterialName9);

		lblMaterialAmount0 = new JLabel("");
		lblMaterialAmount0.setBounds(523, 79, 27, 13);
		pnlMaterial.add(lblMaterialAmount0);

		lblMaterialAmount1 = new JLabel("");
		lblMaterialAmount1.setBounds(523, 102, 27, 13);
		pnlMaterial.add(lblMaterialAmount1);

		lblMaterialAmount2 = new JLabel("");
		lblMaterialAmount2.setBounds(523, 125, 27, 13);
		pnlMaterial.add(lblMaterialAmount2);

		lblMaterialAmount3 = new JLabel("");
		lblMaterialAmount3.setBounds(523, 148, 27, 13);
		pnlMaterial.add(lblMaterialAmount3);

		lblMaterialAmount4 = new JLabel("");
		lblMaterialAmount4.setBounds(523, 171, 27, 13);
		pnlMaterial.add(lblMaterialAmount4);

		lblMaterialAmount8 = new JLabel("");
		lblMaterialAmount8.setBounds(523, 263, 27, 13);
		pnlMaterial.add(lblMaterialAmount8);

		lblMaterialAmount5 = new JLabel("");
		lblMaterialAmount5.setBounds(523, 194, 27, 13);
		pnlMaterial.add(lblMaterialAmount5);

		lblMaterialAmount6 = new JLabel("");
		lblMaterialAmount6.setBounds(523, 217, 27, 13);
		pnlMaterial.add(lblMaterialAmount6);

		lblMaterialAmount7 = new JLabel("");
		lblMaterialAmount7.setBounds(523, 240, 27, 13);
		pnlMaterial.add(lblMaterialAmount7);

		lblMaterialAmount9 = new JLabel("");
		lblMaterialAmount9.setBounds(523, 286, 27, 13);
		pnlMaterial.add(lblMaterialAmount9);

		JButton btnDelete = new JButton("Delete Material");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(351, 325, 133, 23);
		pnlMaterial.add(btnDelete);
		btnDelete.setVisible(false);

		lblX0 = new JLabel("");
		lblX0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(0);			}
		});
		lblX0.setToolTipText("Delete material");
		lblX0.setForeground(Color.WHITE);
		lblX0.setBounds(327, 78, 12, 14);
		pnlMaterial.add(lblX0);
		lblX0.setCursor(new Cursor(Cursor.HAND_CURSOR));



		lblX1 = new JLabel("");
		lblX1.setToolTipText("Delete material");
		lblX1.setForeground(Color.WHITE);
		lblX1.setBounds(327, 101, 12, 14);
		pnlMaterial.add(lblX1);
		lblX1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblX1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(1);			}
		});


		lblX2 = new JLabel("");
		lblX2.setToolTipText("Delete material");
		lblX2.setForeground(Color.WHITE);
		lblX2.setBounds(327, 126, 12, 14);
		pnlMaterial.add(lblX2);
		lblX2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(2);			}
		});


		lblX3 = new JLabel("");
		lblX3.setToolTipText("Delete material");
		lblX3.setForeground(Color.WHITE);
		lblX3.setBounds(327, 149, 12, 14);
		pnlMaterial.add(lblX3);
		lblX3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(3);			}
		});


		lblX4 = new JLabel("");
		lblX4.setToolTipText("Delete material");
		lblX4.setForeground(Color.WHITE);
		lblX4.setBounds(327, 172, 12, 14);
		pnlMaterial.add(lblX4);
		lblX4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(4);			}
		});


		lblX5 = new JLabel("");
		lblX5.setToolTipText("Delete material");
		lblX5.setForeground(Color.WHITE);
		lblX5.setBounds(327, 195, 12, 14);
		pnlMaterial.add(lblX5);
		lblX5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(5);			}
		});


		lblX6 = new JLabel("");
		lblX6.setToolTipText("Delete material");
		lblX6.setForeground(Color.WHITE);
		lblX6.setBounds(327, 216, 12, 14);
		pnlMaterial.add(lblX6);
		lblX6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(6);			}
		});

		lblX7 = new JLabel("");
		lblX7.setToolTipText("Delete material");
		lblX7.setForeground(Color.WHITE);
		lblX7.setBounds(327, 239, 12, 14);
		pnlMaterial.add(lblX7);
		lblX7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(7);			}
		});


		lblX8 = new JLabel("");
		lblX8.setToolTipText("Delete material");
		lblX8.setForeground(Color.WHITE);
		lblX8.setBounds(327, 263, 12, 14);
		pnlMaterial.add(lblX8);
		lblX8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(8);			}
		});



		lblX9 = new JLabel("");
		lblX9.setToolTipText("Delete material");
		lblX9.setForeground(Color.WHITE);
		lblX9.setBounds(327, 286, 12, 14);
		pnlMaterial.add(lblX9);
		lblX9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblX9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteSelectedMaterial(9);
			}
		});

		//		txtMC1 = new JComboBox();
		//		txtMC1.setBounds(10, 46, 86, 20);
		//		panel_5.add(txtMC1);
		//
		//		txtMM1 = new JTextField();
		//		txtMM1.setColumns(10);
		//		txtMM1.setBounds(174, 46, 86, 20);
		//		panel_5.add(txtMM1);
		//
		//		txtMM2 = new JTextField();
		//		txtMM2.setColumns(10);
		//		txtMM2.setBounds(174, 77, 86, 20);
		//		panel_5.add(txtMM2);
		//
		//		txtMC2 = new JComboBox();
		//		txtMC2.setBounds(10, 77, 86, 20);
		//		panel_5.add(txtMC2);
		//
		//		txtMM3 = new JTextField();
		//		txtMM3.setColumns(10);
		//		txtMM3.setBounds(174, 108, 86, 20);
		//		panel_5.add(txtMM3);
		//
		//		txtMC3 = new JComboBox();
		//		txtMC3.setBounds(10, 108, 86, 20);
		//		panel_5.add(txtMC3);
		//
		//		txtMM4 = new JTextField();
		//		txtMM4.setColumns(10);
		//		txtMM4.setBounds(174, 139, 86, 20);
		//		panel_5.add(txtMM4);
		//
		//		txtMC4 = new JComboBox();
		//		txtMC4.setBounds(10, 139, 86, 20);
		//		panel_5.add(txtMC4);
		//
		//		txtMM5 = new JTextField();
		//		txtMM5.setColumns(10);
		//		txtMM5.setBounds(174, 170, 86, 20);
		//		panel_5.add(txtMM5);
		//
		//		txtMC5 = new JComboBox();
		//		txtMC5.setBounds(10, 170, 86, 20);
		//		panel_5.add(txtMC5);
		//
		//		txtMM6 = new JTextField();
		//		txtMM6.setColumns(10);
		//		txtMM6.setBounds(174, 201, 86, 20);
		//		panel_5.add(txtMM6);
		//
		//		txtMC6 = new JComboBox();
		//		txtMC6.setBounds(10, 201, 86, 20);
		//		panel_5.add(txtMC6);
		//
		//		txtMM7 = new JTextField();
		//		txtMM7.setColumns(10);
		//		txtMM7.setBounds(174, 232, 86, 20);
		//		panel_5.add(txtMM7);
		//
		//		txtMC7 = new JComboBox();
		//		txtMC7.setBounds(10, 232, 86, 20);
		//		panel_5.add(txtMC7);
		//
		//		txtMM8 = new JTextField();
		//		txtMM8.setColumns(10);
		//		txtMM8.setBounds(174, 263, 86, 20);
		//		panel_5.add(txtMM8);
		//
		//		txtMC8 = new JComboBox();
		//		txtMC8.setBounds(10, 263, 86, 20);
		//		panel_5.add(txtMC8);
		//
		//		txtMM9 = new JTextField();
		//		txtMM9.setColumns(10);
		//		txtMM9.setBounds(174, 294, 86, 20);
		//		panel_5.add(txtMM9);
		//
		//		txtMC9 = new JComboBox();
		//		txtMC9.setBounds(10, 294, 86, 20);
		//		panel_5.add(txtMC9);
		//
		//		txtMM10 = new JTextField();
		//		txtMM10.setColumns(10);
		//		txtMM10.setBounds(174, 325, 86, 20);
		//		panel_5.add(txtMM10);
		//
		//		txtMC10 = new JComboBox();
		//		txtMC10.setBounds(10, 325, 86, 20);
		//		panel_5.add(txtMC10);
		//
		//		JLabel lblMcm10 = new JLabel("Cost | Meters");
		//		lblMcm10.setBounds(96, 328, 78, 14);
		//		panel_5.add(lblMcm10);
		//		lblMcm10.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm10.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm9 = new JLabel("Cost | Meters");
		//		lblMcm9.setBounds(96, 297, 78, 14);
		//		panel_5.add(lblMcm9);
		//		lblMcm9.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm8 = new JLabel("Cost | Meters");
		//		lblMcm8.setBounds(96, 266, 78, 14);
		//		panel_5.add(lblMcm8);
		//		lblMcm8.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm7 = new JLabel("Cost | Meters");
		//		lblMcm7.setBounds(96, 235, 78, 14);
		//		panel_5.add(lblMcm7);
		//		lblMcm7.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm6 = new JLabel("Cost | Meters");
		//		lblMcm6.setBounds(96, 204, 78, 14);
		//		panel_5.add(lblMcm6);
		//		lblMcm6.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm5 = new JLabel("Cost | Meters");
		//		lblMcm5.setBounds(96, 173, 78, 14);
		//		panel_5.add(lblMcm5);
		//		lblMcm5.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm4 = new JLabel("Cost | Meters");
		//		lblMcm4.setBounds(96, 142, 78, 14);
		//		panel_5.add(lblMcm4);
		//		lblMcm4.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm3 = new JLabel("Cost | Meters");
		//		lblMcm3.setBounds(96, 111, 78, 14);
		//		panel_5.add(lblMcm3);
		//		lblMcm3.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm2 = new JLabel("Cost | Meters");
		//		lblMcm2.setBounds(96, 80, 78, 14);
		//		panel_5.add(lblMcm2);
		//		lblMcm2.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//
		//		JLabel lblMcm1 = new JLabel("Cost | Meters");
		//		lblMcm1.setBounds(96, 49, 78, 14);
		//		panel_5.add(lblMcm1);
		//		lblMcm1.setHorizontalAlignment(SwingConstants.CENTER);
		//		lblMcm1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		pnlRhinestones = new JPanel();
		pnlRhinestones.setLayout(null);
		pnlRhinestones.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlRhinestones.setBackground(new Color(255, 204, 102));
		pnlRhinestones.setBounds(290, 11, 270, 170);
		PInvoice.add(pnlRhinestones);

		lblRhynestones = new JLabel("RHINESTONES");
		lblRhynestones.setHorizontalAlignment(SwingConstants.CENTER);
		lblRhynestones.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRhynestones.setBounds(10, 11, 250, 24);
		pnlRhinestones.add(lblRhynestones);

		JSpinner spnRT4 = new JSpinner();
		spnRT4.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT4.setBounds(10, 139, 83, 20);
		pnlRhinestones.add(spnRT4);

		JSpinner spnRT3 = new JSpinner();
		spnRT3.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT3.setBounds(10, 108, 83, 20);
		pnlRhinestones.add(spnRT3);

		JSpinner spnRT2 = new JSpinner();
		spnRT2.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT2.setBounds(10, 77, 83, 20);
		pnlRhinestones.add(spnRT2);

		JSpinner spnRT1 = new JSpinner();
		spnRT1.setModel(new SpinnerListModel(new String[] {"AB", "CRYSTAL"}));
		spnRT1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRT1.setBounds(10, 46, 83, 20);
		pnlRhinestones.add(spnRT1);

		JSpinner spnRA1 = new JSpinner();
		spnRA1.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA1.setBounds(177, 46, 83, 20);
		pnlRhinestones.add(spnRA1);

		JSpinner spnRA2 = new JSpinner();
		spnRA2.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA2.setBounds(177, 78, 83, 20);
		pnlRhinestones.add(spnRA2);

		JSpinner spnRA3 = new JSpinner();
		spnRA3.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA3.setBounds(177, 109, 83, 20);
		pnlRhinestones.add(spnRA3);

		JSpinner spnRA4 = new JSpinner();
		spnRA4.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(50)));
		spnRA4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRA4.setBounds(177, 140, 83, 20);
		pnlRhinestones.add(spnRA4);

		JSpinner spnRS1 = new JSpinner();
		spnRS1.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS1.setBounds(103, 46, 64, 20);
		pnlRhinestones.add(spnRS1);

		JSpinner spnRS2 = new JSpinner();
		spnRS2.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS2.setBounds(103, 78, 64, 20);
		pnlRhinestones.add(spnRS2);

		JSpinner spnRS3 = new JSpinner();
		spnRS3.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS3.setBounds(103, 109, 64, 20);
		pnlRhinestones.add(spnRS3);

		JSpinner spnRS4 = new JSpinner();
		spnRS4.setModel(new SpinnerListModel(new String[] {"20", "30", "34", "40"}));
		spnRS4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnRS4.setBounds(103, 140, 64, 20);
		pnlRhinestones.add(spnRS4);

		JPanel pnlStudio = new JPanel();
		pnlStudio.setLayout(null);
		pnlStudio.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlStudio.setBackground(new Color(255, 255, 102));
		pnlStudio.setBounds(10, 11, 270, 143);
		PInvoice.add(pnlStudio);

		JLabel lblStudio = new JLabel("STUDIO");
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblStudio.setBounds(10, 11, 250, 24);
		pnlStudio.add(lblStudio);

		JLabel lblCostumeNo = new JLabel("Studio");
		lblCostumeNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostumeNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCostumeNo.setBounds(10, 58, 59, 14);
		pnlStudio.add(lblCostumeNo);

		cmbStudio = new JComboBox();
		cmbStudio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//		cmbStudio.setModel(new DefaultComboBoxModel(new String[] {"Kids In Dance", "Evolve Dance Centre", "Maple Dance Acadamy", "CB Dance Acadamy", "The Eight Count"}));
		cmbStudio.setBounds(79, 55, 181, 20);
		cmbStudio.setMaximumRowCount(20);
		pnlStudio.add(cmbStudio);

		txtCostumeName = new JTextField();
		txtCostumeName.setText(null);
		txtCostumeName.setColumns(10);
		txtCostumeName.setBounds(118, 93, 142, 20);
		pnlStudio.add(txtCostumeName);

		JLabel lblCostumeName = new JLabel("Costume Name");
		lblCostumeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostumeName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCostumeName.setBounds(10, 92, 98, 20);
		pnlStudio.add(lblCostumeName);

		JPanel pnlHours = new JPanel();
		pnlHours.setLayout(null);
		pnlHours.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlHours.setBackground(new Color(153, 255, 255));
		pnlHours.setBounds(12, 165, 268, 134);
		PInvoice.add(pnlHours);

		JLabel lblHours = new JLabel("HOURS / GROUPS");
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHours.setBounds(10, 11, 248, 24);
		pnlHours.add(lblHours);

		JLabel lblHours_1 = new JLabel("Hours");
		lblHours_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblHours_1.setBounds(10, 48, 122, 14);
		pnlHours.add(lblHours_1);

		//		JSpinner spnHH = new JSpinner();
		spnHH.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spnHH.setBounds(142, 46, 116, 20);
		pnlHours.add(spnHH);
		spnHH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnK.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//				System.out.println(cmbStudio.getSelectedItem());
				if(cmbStudio.getSelectedItem().equals("Evolve Dance Centre")) {
					spnDeposit.setValue((int)spnK.getValue() * Evolve);
				}
			}
		});


		//		JSpinner spnK = new JSpinner();
		spnK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnK.setBounds(142, 77, 116, 20);
		pnlHours.add(spnK);

		JLabel label = new JLabel("Kids");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(10, 79, 122, 14);
		pnlHours.add(label);
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
		rdbSolo.setBounds(10, 104, 101, 23);
		pnlHours.add(rdbSolo);
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
		rdbGroup.setBounds(157, 104, 101, 23);
		pnlHours.add(rdbGroup);

		pnlFile = new JPanel();
		pnlFile.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlFile.setBackground(new Color(204, 204, 204));
		pnlFile.setBounds(982, 11, 270, 348);
		PInvoice.add(pnlFile);
		pnlFile.setLayout(null);

		JLabel lblFileSearch = new JLabel("FILE SEARCH  /  LOGIN");
		lblFileSearch.setBounds(10, 7, 250, 24);
		lblFileSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlFile.add(lblFileSearch);

		JButton btnClear = new JButton("RESET");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clear();
			}
		});
		btnClear.setBounds(10, 184, 120, 30);
		pnlFile.add(btnClear);

		JButton button_2 = new JButton("?2");
		button_2.setBounds(140, 225, 120, 30);
		pnlFile.add(button_2);



		JButton btnPrintout = new JButton("Printout 1");
		btnPrintout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {


			}
		});
		btnPrintout.setBounds(10, 266, 120, 30);
		pnlFile.add(btnPrintout);







		// -------------------------------------------------------------------------  I N F O R M A T I O N ----------------------


		JButton btnInformation = new JButton("Information");
		btnInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output("?", "Version Incoive Gamma");
				output("?", "Last Operated:     " + dtf.format(now));
				output("?", "Last Modified:     Dec/19");
				output("?", "- -/End of Information/- - -");
				output("","");
			}
		});
		btnInformation.setBounds(140, 265, 120, 30);
		pnlFile.add(btnInformation);










		ftfSearch = new JFormattedTextField(createFormatter("##-##-###"));
		ftfSearch.setBounds(140, 42, 120, 24);
		pnlFile.add(ftfSearch);

		JLabel lblSearchByNumber = new JLabel("Search by Number");
		lblSearchByNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSearchByNumber.setBounds(10, 47, 120, 14);
		pnlFile.add(lblSearchByNumber);

		cmbStudioName = new JComboBox();
		//		cmbStudioName.setModel(new DefaultComboBoxModel(new String[] {"Kids In Dance", "Evolve Dance Centre", "Maple Dance Acadamy", "CB Dance Acadamy", "The Eight Count"}));
		//		cmbStudioName.setSelectedIndex(0);
		cmbStudioName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cmbStudioName.setBounds(10, 77, 250, 24);
		pnlFile.add(cmbStudioName);
		cmbStudioName.setEditable(false);

		cmbStudioName.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//		        System.out.println(cmbStudioName.getSelectedItem());
				int studioId = cmbStudioName.getSelectedIndex();
				cmbYear.removeAllItems();
				Database.LoadYear(studioId);

			}
		});

		cmbYear = new JComboBox();

		cmbYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cmbYear.setBounds(10, 112, 250, 24);
		pnlFile.add(cmbYear);
		cmbYear.setEditable(false);
		cmbYear.addItem("Select the year");


		cmbInvoiceId = new JComboBox();
		cmbInvoiceId.setEnabled(false);
		cmbInvoiceId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cmbInvoiceId.setBounds(10, 147, 250, 24);
		pnlFile.add(cmbInvoiceId);
		cmbInvoiceId.setEditable(false);

		cmbYear.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//		        System.out.println(cmbYear.getSelectedItem());
				cmbInvoiceId.setEnabled(true);
				//				System.out.println("Studio Name: " + cmbStudioName.getSelectedItem());
				//				Database.LoadYear(cmbStudioName.getSelectedIndex());
				//				String year = cmbYear.getSelectedItem() + "";
				Database.GetCreatedInvoices(cmbStudioName.getSelectedIndex(), cmbYear.getSelectedItem()+"");
			}
		});
		Database.LoadYear(cmbStudioName.getSelectedIndex());


		JButton button = new JButton("?2");
		button.setBounds(10, 306, 120, 30);
		pnlFile.add(button);

		JButton button_4 = new JButton("?2");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddOverWrite(true);
			}
		});
		button_4.setBounds(140, 306, 120, 30);
		pnlFile.add(button_4);

		JButton button_5 = new JButton("?2");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mathe.InvoiceNumber();
			}
		});
		button_5.setBounds(10, 225, 120, 30);
		pnlFile.add(button_5);

		JButton btnRetrieve = new JButton("RETRIEVE");
		btnRetrieve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.RetrieveInvoice(cmbStudioName.getSelectedIndex()+"", cmbYear.getSelectedItem()+"", cmbInvoiceId.getSelectedItem()+"");
			}
		});

		btnRetrieve.setBounds(140, 184, 120, 30);
		pnlFile.add(btnRetrieve);

		JPanel pnlRecipt = new JPanel();
		pnlRecipt.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlRecipt.setBackground(new Color(255, 255, 204));
		pnlRecipt.setBounds(570, 11, 402, 415);
		PInvoice.add(pnlRecipt);
		pnlRecipt.setLayout(null);

		JLabel lblRecipt = new JLabel("RECEIPT");
		lblRecipt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRecipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipt.setBounds(10, 11, 380, 27);
		pnlRecipt.add(lblRecipt);

		JLabel lblMaterial_1 = new JLabel("Material");
		lblMaterial_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaterial_1.setBounds(10, 133, 90, 17);
		pnlRecipt.add(lblMaterial_1);

		JLabel lblHours_2 = new JLabel("Hours");
		lblHours_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHours_2.setBounds(10, 161, 90, 17);
		pnlRecipt.add(lblHours_2);

		JLabel lblRhinestone = new JLabel("Rhinestone");
		lblRhinestone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRhinestone.setBounds(10, 189, 90, 17);
		pnlRecipt.add(lblRhinestone);

		JLabel lblDeposit_1 = new JLabel("Deposit");
		lblDeposit_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeposit_1.setBounds(10, 216, 90, 17);
		pnlRecipt.add(lblDeposit_1);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtotal.setBounds(10, 244, 90, 17);
		pnlRecipt.add(lblSubtotal);



		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(10, 300, 90, 17);
		pnlRecipt.add(lblTotal);

		JLabel lblCostPerCostume = new JLabel("Cost per Costume");
		lblCostPerCostume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostPerCostume.setBounds(10, 328, 122, 17);
		pnlRecipt.add(lblCostPerCostume);

		JLabel lblStudioName_1 = new JLabel("Studio Name");
		lblStudioName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudioName_1.setBounds(10, 49, 90, 17);
		pnlRecipt.add(lblStudioName_1);

		JLabel lblCostume = new JLabel("Invoice No.");
		lblCostume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostume.setBounds(155, 49, 105, 17);
		pnlRecipt.add(lblCostume);

		//		lblStudioX.setText("Xxxx Xxxx");
		lblStudioNameR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudioNameR.setBounds(10, 77, 90, 17);
		pnlRecipt.add(lblStudioNameR);

		lblInvoiceNumberR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceNumberR.setBounds(155, 77, 105, 17);
		pnlRecipt.add(lblInvoiceNumberR);

		JLabel lblFileType = new JLabel("File Type");
		lblFileType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFileType.setBounds(10, 105, 90, 17);
		pnlRecipt.add(lblFileType);

		lbsTotal = new JLabel("$ 0.00");
		lbsTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsTotal.setBounds(170, 300, 90, 17);
		pnlRecipt.add(lbsTotal);

		JLabel label_9 = new JLabel("% 13");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(170, 272, 90, 17);
		pnlRecipt.add(label_9);

		lbsDeposit = new JLabel("$ 0.00");
		lbsDeposit.setForeground(new Color(255, 0, 0));
		lbsDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsDeposit.setBounds(170, 216, 90, 17);
		pnlRecipt.add(lbsDeposit);

		lbsSubtotal = new JLabel("$ 0.00");
		lbsSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsSubtotal.setBounds(170, 244, 90, 17);
		pnlRecipt.add(lbsSubtotal);

		lbsRhinestone = new JLabel("$ 0.00");
		lbsRhinestone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsRhinestone.setBounds(170, 189, 90, 17);
		pnlRecipt.add(lbsRhinestone);

		lbsMaterial = new JLabel("$ 0.00");
		lbsMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsMaterial.setBounds(170, 133, 90, 17);
		pnlRecipt.add(lbsMaterial);

		lbsHours = new JLabel("$ 0.00");
		lbsHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsHours.setBounds(170, 161, 90, 17);
		pnlRecipt.add(lbsHours);

		lblInvoiceOrQuote = new JLabel("INVOICE or QUOTE ");
		lblInvoiceOrQuote.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInvoiceOrQuote.setBounds(138, 105, 136, 17);
		pnlRecipt.add(lblInvoiceOrQuote);

		JLabel lblAmountOwing = new JLabel("Amount Owing");
		lblAmountOwing.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountOwing.setBounds(10, 385, 122, 26);
		pnlRecipt.add(lblAmountOwing);

		lbsBottom = new JLabel("$ 0.00");
		lbsBottom.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbsBottom.setBounds(138, 385, 122, 27);
		pnlRecipt.add(lbsBottom);

		JLabel lblTotal_1 = new JLabel("Tax");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal_1.setBounds(10, 272, 90, 17);
		pnlRecipt.add(lblTotal_1);

		lbsCPC = new JLabel("$ 0.00");
		lbsCPC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbsCPC.setBounds(170, 328, 90, 17);
		pnlRecipt.add(lbsCPC);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName_1.setBounds(285, 49, 105, 17);
		pnlRecipt.add(lblName_1);

		lblCostumeNameR = new JLabel("Xxxx Xxxx");
		lblCostumeNameR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCostumeNameR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostumeNameR.setBounds(270, 77, 122, 17);
		pnlRecipt.add(lblCostumeNameR);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		separator.setBounds(10, 128, 382, 4);
		pnlRecipt.add(separator);


		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.setBounds(270, 133, 120, 30);
		pnlRecipt.add(btnCalculate);
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output("Material", "Loading Materials...");
				Database.getPrices();
				output("Material", "Calculating...");
				Mathe math = new Mathe();
			}
		});



		btnCreate = new JButton("SAVE");
		btnCreate.setEnabled(false);
		btnCreate.setBounds(270, 176, 120, 30);
		pnlRecipt.add(btnCreate);



		btnCreate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("A");
				if(txtCostumeName.getText().length()<1) {
					System.out.println("AAA");
					txtCostumeName.setBorder(new LineBorder(Color.red,1));
					JOptionPane.showMessageDialog(null, "Write a name for the Costume!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//					//"Kids In Dance", "Evolve Dance Centre", "Maple Dance Acadamy", "CB Dance Acadamy", "The Eight Count"
					//
					//					int studio_id = 0;
					//					String studio_name = cmbStudio.getSelectedItem().toString();
					//					switch(studio_name){
					//					case "Kids In Dance":
					//						studio_id = 0;
					//						break;
					//					case "Evolve Dance Centre":
					//						studio_id = 1;
					//						break;
					//					case "Maple Dance Acadamy":
					//						studio_id = 2;
					//						break;
					//					case "CB Dance Acadamy":
					//						studio_id = 3;
					//						break;
					//					case "The Eight Count":
					//						studio_id = 4;
					//						break;
					//					}
//					System.out.println("B");
//					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM");  
//					LocalDateTime now = LocalDateTime.now();  
//
//					String date = dtf.format(now);
//
//					String month = date.substring(3, 5);
//					String year = date.substring(0, 2);
					String invcName = txtCostumeName.getText();
//					System.out.println("C");
//					int iMonth = Integer.parseInt(month);
//					int iYear = 0;
//					if(iMonth >= 7) {
//						iYear = Integer.parseInt(year);
//						iYear++;
//						year = String.valueOf(iYear);
//					}
					
					int year = Integer.parseInt(Mathe.InvoiceNumber().substring(3, 5));
					
					
					System.out.println("D");
					result = 0;
					int studio_id = cmbStudio.getSelectedIndex();

					int invoice_id = Database.HasInvoice(studio_id);
					System.out.println(invoice_id);
					if(invoice_id == 0) {
						Database.CreateNewInvoice(studio_id, year, invcName);
						System.out.println("D1");
					}else {
						Database.CreateInvoice(studio_id, invoice_id, year, invcName);
						System.out.println("D2");
					}
					System.out.println("E");

					//					if(result == 1) {
					//						output("Invoice:", "saved");
					//					}else if(result == 2) {
					//						output("Invoice:", "something went wrong");
					//					}
				}

			}
		});

		pnlConsole = new JPanel();
		pnlConsole.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlConsole.setBackground(Color.DARK_GRAY);
		pnlConsole.setBounds(570, 434, 402, 234);
		PInvoice.add(pnlConsole);
		pnlConsole.setLayout(null);

		lblCommand1 = new JLabel("|");
		lblCommand1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand1.setForeground(new Color(51, 153, 0));
		lblCommand1.setBounds(10, 211, 382, 14);
		pnlConsole.add(lblCommand1);

		lblCommand2 = new JLabel("_");
		lblCommand2.setForeground(new Color(51, 153, 0));
		lblCommand2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand2.setBounds(10, 191, 382, 14);
		pnlConsole.add(lblCommand2);

		lblCommand3 = new JLabel("_");
		lblCommand3.setForeground(new Color(51, 153, 0));
		lblCommand3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand3.setBounds(10, 171, 382, 14);
		pnlConsole.add(lblCommand3);

		lblCommand4 = new JLabel("_");
		lblCommand4.setForeground(new Color(51, 153, 0));
		lblCommand4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand4.setBounds(10, 151, 382, 14);
		pnlConsole.add(lblCommand4);

		lblCommand5 = new JLabel("_");
		lblCommand5.setForeground(new Color(51, 153, 0));
		lblCommand5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand5.setBounds(10, 131, 382, 14);
		pnlConsole.add(lblCommand5);

		lblCommand6 = new JLabel("_");
		lblCommand6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand6.setForeground(new Color(51, 153, 0));
		lblCommand6.setBounds(10, 111, 382, 14);
		pnlConsole.add(lblCommand6);

		lblCommand7 = new JLabel("_");
		lblCommand7.setForeground(new Color(51, 153, 0));
		lblCommand7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand7.setBounds(10, 91, 382, 14);
		pnlConsole.add(lblCommand7);

		lblCommand8 = new JLabel("_");
		lblCommand8.setBounds(10, 71, 382, 14);
		pnlConsole.add(lblCommand8);
		lblCommand8.setForeground(new Color(51, 153, 0));
		lblCommand8.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblCommand9 = new JLabel("_");
		lblCommand9.setForeground(new Color(51, 153, 0));
		lblCommand9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand9.setBounds(10, 51, 382, 14);
		pnlConsole.add(lblCommand9);

		lblCommand10 = new JLabel("_");
		lblCommand10.setForeground(new Color(51, 153, 0));
		lblCommand10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand10.setBounds(10, 31, 382, 14);
		pnlConsole.add(lblCommand10);

		lblCommand11 = new JLabel("_");
		lblCommand11.setForeground(new Color(51, 153, 0));
		lblCommand11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCommand11.setBounds(10, 11, 382, 14);
		pnlConsole.add(lblCommand11);

		JPanel pnlDeposit = new JPanel();
		pnlDeposit.setLayout(null);
		pnlDeposit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlDeposit.setBackground(new Color(204, 255, 153));
		pnlDeposit.setBounds(290, 192, 268, 107);
		PInvoice.add(pnlDeposit);

		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDeposit.setBounds(10, 11, 248, 24);
		pnlDeposit.add(lblDeposit);

		JLabel lblDepositAmmount_1 = new JLabel("Deposit Ammount");
		lblDepositAmmount_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositAmmount_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDepositAmmount_1.setBounds(10, 48, 153, 14);
		pnlDeposit.add(lblDepositAmmount_1);

		spnDeposit = new JSpinner();
		spnDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spnDeposit.setBounds(173, 46, 85, 20);
		pnlDeposit.add(spnDeposit);

		pnlOverWrite = new JPanel();
		pnlOverWrite.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlOverWrite.setBackground(new Color(204, 204, 255));
		pnlOverWrite.setBounds(982, 11, 270, 217);
		pnlOverWrite.setVisible(false);
		PInvoice.add(pnlOverWrite);





		JPanel Clients = new JPanel();
		Clients.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("Clients", new ImageIcon(Invoice.class.getResource("/images/icon-client.png")), Clients, null);
		Clients.setLayout(null);

		txtStudio = new JTextField();
		txtStudio.setBounds(130, 482, 225, 20);
		Clients.add(txtStudio);
		txtStudio.setColumns(10);

		txtOwner = new JTextField();
		txtOwner.setBounds(130, 512, 225, 20);
		Clients.add(txtOwner);
		txtOwner.setColumns(10);


		txtPhone = new JFormattedTextField(createFormatter("(###) ### - ####"));
		txtPhone.setToolTipText("(000) 000-0000");
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPhone.setText("");
			}
		});
		txtPhone.setBounds(130, 542, 225, 20);
		Clients.add(txtPhone);


		//		txtPhone = new JTextField();
		//		txtPhone.setToolTipText("Phone Number eg 1234567890 [123 456 7890]");
		//		txtPhone.setHorizontalAlignment(SwingConstants.CENTER);
		//		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//		txtPhone.addFocusListener(new FocusAdapter() {
		//			@Override
		//			public void focusGained(FocusEvent arg0) {
		//				txtPhone.setText("");
		//			}
		//		});
		//		txtPhone.setBounds(130, 542, 225, 20);
		//		
		//		txtPhone.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtAddress.setText("");
			}
		});
		txtAddress.setToolTipText("# street, city province, country, postal-code");
		txtAddress.setBounds(130, 572, 225, 20);
		Clients.add(txtAddress);
		txtAddress.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(130, 602, 225, 20);
		Clients.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblStudioName = new JLabel("Studio Name");
		lblStudioName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudioName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStudioName.setBounds(10, 480, 110, 20);
		Clients.add(lblStudioName);

		JLabel lblOwnerName = new JLabel("Owner Name\r\n");
		lblOwnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOwnerName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOwnerName.setBounds(10, 510, 110, 20);
		Clients.add(lblOwnerName);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 543, 110, 20);
		Clients.add(lblPhoneNumber);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(10, 570, 110, 20);
		Clients.add(lblAddress);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmailAddress.setBounds(10, 600, 110, 20);
		Clients.add(lblEmailAddress);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.CreateClient(txtStudio.getText(), txtOwner.getText(), txtAddress.getText(), txtPhone.getText(), txtEmail.getText());

				while(clientsTable.getRowCount() > 0) {
					clientsTable.removeRow(clientsTable.getRowCount());
					System.out.println(clientsTable.getRowCount() + "*" );
				}

				Database.LoadClients();
				cOutput("","Client " + txtStudio.getText() + " added to Client's Table");
				txtEmail.setText("");
				txtAddress.setText("");
				txtOwner.setText("");
				txtPhone.setText("");
				txtStudio.setText("");
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSubmit.setBounds(78, 644, 110, 33);
		Clients.add(btnSubmit);
		//   a
		//		TableColumn id, name, email;
		//		id = new TableColumn(0);
		//		id.setHeaderValue("Studio ID"); // set column name
		//		id.setMinWidth(30);
		//		id.setMaxWidth(30);
		//		id.setPreferredWidth(30);		
		//		
		//		name = new TableColumn(1);
		//		name.setHeaderValue("Studio ID"); // set column name
		//		name.setPreferredWidth(100); //set column width 
		//
		//		DefaultTableColumnModel headers = new DefaultTableColumnModel();
		//		headers.addColumn(id);
		//		headers.addColumn(name);
		//
		//		
		//		DefaultTableModel rows = new DefaultTableModel(0,2);
		//		
		//		Object[] v1 = {"Lisa","Reid" };
		//		Object[] v2 = {"Cherry","Spada"}; 
		//		
		//		rows.addRow(v1);
		//		rows.addRow(v2); 
		//		
		//		JTable testTable;
		//		testTable = new JTable(rows);
		//		
		//		JScrollPane scrollTest = new JScrollPane(testTable);
		//		
		//		Clients.add(scrollTest);
		//
		//		scrollTest.setSize(500,300);
		//		scrollTest.setVisible(true); 

		clientsTable = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};



		TableColumn id, name, costumes, bill, owner, address, phone, email;
		id = new TableColumn(0);
		id.setHeaderValue("Studio ID");
		id.setMinWidth(70);
		id.setMaxWidth(70);
		id.setPreferredWidth(70);		

		name = new TableColumn(1);
		name.setHeaderValue("Studio Name");
		name.setPreferredWidth(150); 
		name.setMinWidth(150);
		name.setMaxWidth(150);

		costumes = new TableColumn(2);
		costumes.setHeaderValue("Total Costumes");
		costumes.setMinWidth(100);
		costumes.setMaxWidth(100);
		costumes.setPreferredWidth(100);	

		bill = new TableColumn(3);
		bill.setHeaderValue("Studio Bill");
		bill.setMinWidth(80);
		bill.setMaxWidth(80);
		bill.setPreferredWidth(80);

		owner = new TableColumn(4);
		owner.setHeaderValue("Studio Owner");
		owner.setMinWidth(120);
		owner.setMaxWidth(120);
		owner.setPreferredWidth(120);

		address = new TableColumn(5);
		address.setHeaderValue("Studio Address");
		address.setMinWidth(320);
		address.setMaxWidth(320);
		address.setPreferredWidth(320);

		phone = new TableColumn(6);
		phone.setHeaderValue("Phone Number");
		phone.setMinWidth(120);
		phone.setMaxWidth(120);
		phone.setPreferredWidth(120);

		email = new TableColumn(7);
		email.setHeaderValue("Studio Email");
		//		email.setMinWidth(50);
		//		email.setMaxWidth(50);
		//		email.setPreferredWidth(50);

		DefaultTableColumnModel headers = new DefaultTableColumnModel();
		headers.addColumn(id);
		headers.addColumn(name);
		headers.addColumn(costumes);
		headers.addColumn(bill);
		headers.addColumn(owner);
		headers.addColumn(address);
		headers.addColumn(phone);
		headers.addColumn(email);


		rows = new DefaultTableModel(0,8);




		testTable = new JTable(rows, headers);

		JScrollPane scrollTest = new JScrollPane(testTable);
		scrollTest.setLocation(10, 10);

		Clients.add(scrollTest);

		scrollTest.setSize(1327,402);

		JPanel pnlClntConsole = new JPanel();
		pnlClntConsole.setLayout(null);
		pnlClntConsole.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlClntConsole.setBackground(Color.DARK_GRAY);
		pnlClntConsole.setBounds(394, 422, 550, 255);
		Clients.add(pnlClntConsole);

		lblCCommand1 = new JLabel("|");
		lblCCommand1.setForeground(new Color(51, 153, 0));
		lblCCommand1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand1.setBounds(10, 230, 530, 14);
		pnlClntConsole.add(lblCCommand1);

		lblCCommand2 = new JLabel("_");
		lblCCommand2.setForeground(new Color(51, 153, 0));
		lblCCommand2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand2.setBounds(10, 210, 530, 14);
		pnlClntConsole.add(lblCCommand2);

		lblCCommand3 = new JLabel("_");
		lblCCommand3.setForeground(new Color(51, 153, 0));
		lblCCommand3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand3.setBounds(10, 190, 530, 14);
		pnlClntConsole.add(lblCCommand3);

		lblCCommand4 = new JLabel("_");
		lblCCommand4.setForeground(new Color(51, 153, 0));
		lblCCommand4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand4.setBounds(10, 170, 530, 14);
		pnlClntConsole.add(lblCCommand4);

		lblCCommand5 = new JLabel("_");
		lblCCommand5.setForeground(new Color(51, 153, 0));
		lblCCommand5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand5.setBounds(10, 150, 530, 14);
		pnlClntConsole.add(lblCCommand5);

		lblCCommand6 = new JLabel("_");
		lblCCommand6.setForeground(new Color(51, 153, 0));
		lblCCommand6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand6.setBounds(10, 130, 530, 14);
		pnlClntConsole.add(lblCCommand6);

		lblCCommand7 = new JLabel("_");
		lblCCommand7.setForeground(new Color(51, 153, 0));
		lblCCommand7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand7.setBounds(10, 110, 530, 14);
		pnlClntConsole.add(lblCCommand7);

		lblCCommand8 = new JLabel("_");
		lblCCommand8.setForeground(new Color(51, 153, 0));
		lblCCommand8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand8.setBounds(10, 90, 530, 14);
		pnlClntConsole.add(lblCCommand8);

		lblCCommand9 = new JLabel("_");
		lblCCommand9.setForeground(new Color(51, 153, 0));
		lblCCommand9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand9.setBounds(10, 70, 530, 14);
		pnlClntConsole.add(lblCCommand9);

		lblCCommand10 = new JLabel("_");
		lblCCommand10.setForeground(new Color(51, 153, 0));
		lblCCommand10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand10.setBounds(10, 50, 530, 14);
		pnlClntConsole.add(lblCCommand10);

		lblCCommand11 = new JLabel("_");
		lblCCommand11.setForeground(new Color(51, 153, 0));
		lblCCommand11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand11.setBounds(10, 30, 530, 14);
		pnlClntConsole.add(lblCCommand11);

		lblCCommand12 = new JLabel("_");
		lblCCommand12.setForeground(new Color(51, 153, 0));
		lblCCommand12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCCommand12.setBounds(10, 11, 530, 14);
		pnlClntConsole.add(lblCCommand12);
		scrollTest.setVisible(true); 

		Database.LoadClients();

		//		clientsTable = new DefaultTableModel(){public boolean isCellEditable(int row, int column) {return false;}};		
		//		clientsTable.addColumn("Studio ID");
		//		clientsTable.addColumn("Studio Name");
		//		clientsTable.addColumn("Total Costumes");
		//		clientsTable.addColumn("Total Bill");
		//		clientsTable.addColumn("Studio Owner");
		//		clientsTable.addColumn("Studio Address");
		//		clientsTable.addColumn("Phone Number");
		//		clientsTable.addColumn("Email Address");
		//		tableClients = new JTable(clientsTable); 
		//
		//		
		//		JScrollPane scrollPane_1 = new JScrollPane(tableClients);
		//		scrollPane_1.setBounds(10, 10, 1327, 392);
		//		Clients.add(scrollPane_1);
		//		Database.LoadClients();



		JPanel Material = new JPanel();       
		Material.setBackground(new Color(255, 204, 255));
		tabbedPane.addTab("Material", new ImageIcon(Invoice.class.getResource("/images/icon-fabric.png")), Material, null);
		Material.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBackground(new Color(255, 255, 153));
		panel_4.setBounds(785, 46, 271, 172);
		Material.add(panel_4);
		panel_4.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(125, 11, 136, 20);
		panel_4.add(txtName);
		txtName.setColumns(10);

		txtCost = new JTextField();
		txtCost.setText("");
		txtCost.setBounds(125, 56, 136, 20);
		panel_4.add(txtCost);
		txtCost.setColumns(10);

		JLabel lblName = new JLabel("Material Name :");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblName.setBounds(10, 14, 155, 14);
		panel_4.add(lblName);

		JLabel lblCost = new JLabel("Material Cost:");
		lblCost.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCost.setBounds(10, 59, 155, 17);
		panel_4.add(lblCost);

		JButton btnMaterial = new JButton("S U B M I T");
		//		JButton btnMaterial = new JButton("B R O K E N");
		btnMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean success;
				//				System.out.println("Hello");
				success = Database.CreateMaterial(txtName.getText(), txtCost.getText(), spnMaterialType.getSelectedItem().toString());
				txtName.setText("");
				txtCost.setText("");
				Database.LoadMaterials(false);

			}
		});
		//		btnMaterial.setVisible(false);
		btnMaterial.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnMaterial.setBounds(67, 129, 134, 32);
		panel_4.add(btnMaterial);

		JLabel lblMaterialType = new JLabel("Material Type :");
		lblMaterialType.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaterialType.setBounds(10, 101, 155, 17);
		panel_4.add(lblMaterialType);

		spnMaterialType = new JComboBox();
		spnMaterialType.setMaximumRowCount(30);
		spnMaterialType.setModel(new DefaultComboBoxModel(new String[] {"Chiffon", "Cosmo", "Cracked Ice", "Fringe", "Georgette", "Hologram", "Lace", "Lycra", "Mesh", "Mystique", "Organdy", "Print", "Sequin", "Supplex", "Toulle", "Trim", "Velvet", "Unknown"}));
		spnMaterialType.setBounds(125, 98, 136, 20);
		panel_4.add(spnMaterialType);





		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_11.setBackground(Color.DARK_GRAY);
		//		panel_11.setBounds(846, 328, 550, 255);

		panel_11.setBounds(785, 419, 550, 255);
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
		panel_14.setBounds(10, 10, 765, 664);
		Material.add(panel_14);




		materialTable = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column) {return false;}
		};

		materialTable.addColumn("Material Id");
		materialTable.addColumn("Material Name");
		materialTable.addColumn("Material Type");
		materialTable.addColumn("Material Cost");



		panel_14.setLayout(null);

		tableMaterial = new JTable(materialTable); 



		tableMaterial.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				int row = tableMaterial.rowAtPoint(me.getPoint());

				if(me.getClickCount() > 1) {
					//					System.out.println("Double Clicked");

					UpdateMaterial.Initialize(tableMaterial.getValueAt(row, 0)+"");
				}

				//				int column = materialTable.get;
				//				System.out.println(column);

			}
		});

		JScrollPane scrollPane = new JScrollPane(tableMaterial);
		scrollPane.setLocation(10, 11);
		panel_14.add(scrollPane);
		scrollPane.setSize(745, 606);
		tableMaterial.setSize(600, 800);

		txtSearchMaterial = new JTextField();
		txtSearchMaterial.setForeground(Color.GRAY);
		txtSearchMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchMaterial.setBounds(276, 627, 213, 28);
		panel_14.add(txtSearchMaterial);
		txtSearchMaterial.setColumns(10);

		Database.LoadMaterials(false);

		JButton btnUpdateTable = new JButton("Search Material");
		btnUpdateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdateTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.SearchMaterial(txtSearchMaterial.getText());
			}
		});

		btnUpdateTable.setBounds(499, 626, 123, 28);
		panel_14.add(btnUpdateTable);

		JButton button_7 = new JButton("Reset Table");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.LoadMaterials(false);
			}
		});
		button_7.setBounds(632, 626, 123, 28);
		panel_14.add(button_7);

		JButton btnSortBy = new JButton("Sort by Type");
		btnSortBy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.LoadMaterials(true);
			}
		});
		btnSortBy.setBounds(10, 626, 123, 28);
		panel_14.add(btnSortBy);

		JButton btnSortByMaterial = new JButton("Sort by Material");
		btnSortByMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.LoadMaterials(false);

			}
		});
		btnSortByMaterial.setBounds(143, 626, 123, 28);
		panel_14.add(btnSortByMaterial);

		//		txtSearchMaterial.addKeyListener(new KeyAdapter() {
		//			//@Override
		//			public void keyTyped(KeyEvent arg0) {
		//			}
		//			public void keyPressed(KeyEvent arg0) {
		//				Database.SearchMaterial(arg0, materialSearch);
		//			}
		//		});







		JPanel Rhinestones = new JPanel();
		tabbedPane.addTab("Rhinestones", new ImageIcon(Invoice.class.getResource("/images/Rhinestone icon.png")), Rhinestones, null);

		Settings = new JPanel();
		Settings.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("Settings", new ImageIcon(Invoice.class.getResource("/images/Settings icon.png")), Settings, null);
		Settings.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(new Color(204, 255, 255));
		panel_2.setBounds(10, 11, 242, 461);
		Settings.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblHourlyRate = new JLabel("Hourly Rate");
		lblHourlyRate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHourlyRate.setBounds(10, 11, 76, 14);
		panel_2.add(lblHourlyRate);

		spnHourly = new JSpinner();
		spnHourly.setValue(hourly);
		spnHourly.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hourly = (int) spnHourly.getValue();
				//				System.out.println(hourly);
			}
		});
		spnHourly.setBounds(142, 9, 90, 20);
		panel_2.add(spnHourly);

		spnGroup = new JSpinner();
		spnGroup.setBounds(142, 40, 90, 20);
		panel_2.add(spnGroup);

		JLabel lblGroupRate = new JLabel("Group Rate");
		lblGroupRate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGroupRate.setBounds(10, 42, 76, 14);
		panel_2.add(lblGroupRate);

		spnSolo = new JSpinner();
		spnSolo.setBounds(142, 71, 90, 20);
		panel_2.add(spnSolo);

		JLabel lblSoloRate = new JLabel("Solo Rate");
		lblSoloRate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSoloRate.setBounds(10, 74, 76, 14);
		panel_2.add(lblSoloRate);


		frame.setLocationRelativeTo(null);
	}			// --------------------------------------------------------------------------------------------------- end of Jframe


	protected String GetMaterialName(String name) {
		int i = name.indexOf(".");
		String type = name.substring(i+1);
		name = name.substring(0, i);

		return name + " " + type;

	}


	protected void DeleteSelectedMaterial(int item) {
		if(selectedMaterials[0][item+1] != null) {
			for(int i = item; i< 10; i++) {
				//				System.out.println("Original Array: " + selectedMaterials[0][i]);
				if(selectedMaterials[0][i+1] != null) {
					selectedMaterials[0][i] = selectedMaterials[0][i+1];
					String materialName = GetMaterialName(selectedMaterials[0][i]);
					selectedMaterials[1][i] = selectedMaterials[1][i+1];
					//					System.out.println("Changed Array: " + selectedMaterials[0][i]);
					switch(i) {
					case 0:
						lblMaterialName0.setText("1.    " + materialName);
						lblMaterialAmount0.setText(selectedMaterials[1][0]);

						break;
					case 1: 
						lblMaterialName1.setText("2.    " + materialName);
						lblMaterialAmount1.setText(selectedMaterials[1][1]);

						break;
					case 2: 
						lblMaterialName2.setText("3.    " + materialName);
						lblMaterialAmount2.setText(selectedMaterials[1][2]);

						break;
					case 3: 
						lblMaterialName3.setText("4.    " + materialName);
						lblMaterialAmount3.setText(selectedMaterials[1][3]);

						break;
					case 4: 
						lblMaterialName4.setText("5.    " + materialName);
						lblMaterialAmount4.setText(selectedMaterials[1][4]);

						break;
					case 5: 
						lblMaterialName5.setText("6.    " + materialName);
						lblMaterialAmount5.setText(selectedMaterials[1][5]);

						break;
					case 6: 
						lblMaterialName6.setText("7.    " + materialName);
						lblMaterialAmount6.setText(selectedMaterials[1][6]);

						break;
					case 7: 
						lblMaterialName7.setText("8.    " + materialName);
						lblMaterialAmount7.setText(selectedMaterials[1][7]);

						break;
					case 8: 
						lblMaterialName8.setText("9.    " + materialName);
						lblMaterialAmount8.setText(selectedMaterials[1][8]);

						break;
					case 9: 
						lblMaterialName0.setText("");

						break;

					}
				}else {
					selectedMaterials[0][i] = null;
					selectedMaterials[1][i] = null;
					switch(i) {
					case 0:
						lblMaterialName0.setText("");
						lblMaterialAmount0.setText("");
						lblX0.setText("");
						break;
					case 1: 
						lblMaterialName1.setText("");
						lblMaterialAmount1.setText("");
						lblX1.setText("");
						break;
					case 2: 
						lblMaterialName2.setText("");
						lblMaterialAmount2.setText("");
						lblX2.setText("");
						break;
					case 3: 
						lblMaterialName3.setText("");
						lblMaterialAmount3.setText("");
						lblX3.setText("");
						break;
					case 4: 
						lblMaterialName4.setText("");
						lblMaterialAmount4.setText("");
						lblX4.setText("");
						break;
					case 5: 
						lblMaterialName5.setText("");
						lblMaterialAmount5.setText("");
						lblX5.setText("");
						break;
					case 6: 
						lblMaterialName6.setText("");
						lblMaterialAmount6.setText("");
						lblX6.setText("");
						break;
					case 7: 
						lblMaterialName7.setText("");
						lblMaterialAmount7.setText("");
						lblX7.setText("");
						break;
					case 8: 
						lblMaterialName8.setText("");
						lblMaterialAmount8.setText("");
						lblX8.setText("");
						break;
					case 9: 
						lblMaterialName9.setText("");
						lblMaterialAmount9.setText("");
						lblX9.setText("");
						break;

					}
					break;
				}

			}
		}else {
			selectedMaterials[0][item] = null;
			selectedMaterials[1][item] = null;
			switch(item) {
			case 0:
				lblMaterialName0.setText("");
				lblMaterialAmount0.setText("");
				lblX0.setText("");
				break;
			case 1: 
				lblMaterialName1.setText("");
				lblMaterialAmount1.setText("");
				lblX1.setText("");
				break;
			case 2: 
				lblMaterialName2.setText("");
				lblMaterialAmount2.setText("");
				lblX2.setText("");
				break;
			case 3: 
				lblMaterialName3.setText("");
				lblMaterialAmount3.setText("");
				lblX3.setText("");
				break;
			case 4: 
				lblMaterialName4.setText("");
				lblMaterialAmount4.setText("");
				lblX4.setText("");
				break;
			case 5: 
				lblMaterialName5.setText("");
				lblMaterialAmount5.setText("");
				lblX5.setText("");
				break;
			case 6: 
				lblMaterialName6.setText("");
				lblMaterialAmount6.setText("");
				lblX6.setText("");
				break;
			case 7: 
				lblMaterialName7.setText("");
				lblMaterialAmount7.setText("");
				lblX7.setText("");
				break;
			case 8: 
				lblMaterialName8.setText("");
				lblMaterialAmount8.setText("");
				lblX8.setText("");
				break;
			case 9: 
				lblMaterialName9.setText("");
				lblMaterialAmount9.setText("");
				lblX9.setText("");
				break;

			}
		}
	}




	public void AddOverWrite(boolean over) {
		if(over) {
			pnlFile.setBounds(982, 238, pnlFile.getWidth(), pnlFile.getHeight());
			pnlOverWrite.setVisible(true);
		}else {
			pnlFile.setBounds(982, 11, pnlFile.getWidth(), pnlFile.getHeight());
			pnlOverWrite.setVisible(false);
		}
	}






	public void  UpdateTable(int row) {
		System.out.println("You DoubleClicked row " + row);
		updateTable = new JFrame("FrameDemo");
		updateTable.setBounds(0, 0, 166, 47);
		//		Material.add(updateTable);
		updateTable.setForeground(Color.YELLOW);
		updateTable.setTitle("Update Material");

		//5. Show it.
		updateTable.setVisible(true);
	}


	public static void writeMatOutput(String first, String second) {
		mOutput(first, second);
	}

	public static void writeOutput(String first, String second) {
		output(first, second);
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

		//		ma[0] = txtMC1.getText();
		//		ma[1] = txtMC2.getText();
		//		ma[2] = txtMC3.getText();
		//		ma[3] = txtMC4.getText();
		//		ma[4] = txtMC5.getText();
		//		ma[5] = txtMC6.getText();
		//		ma[6] = txtMC7.getText();
		//		ma[7] = txtMC8.getText();
		//		ma[8] = txtMC9.getText();
		//		ma[9] = txtMC10.getText();

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
	//	private void Filli() {
	//
	//		txtMC1.setText(ma[0]);
	//		output("0","ma(0)" + txtMM1.getText());
	//		txtMM1.setText(me[0]);
	//		txtMC2.setText(ma[1]);
	//		txtMM2.setText(me[1]);
	//		txtMC3.setText(ma[2]);
	//		txtMM3.setText(me[2]);
	//		txtMC4.setText(ma[3]);
	//		txtMM4.setText(me[3]);
	//		txtMC5.setText(ma[4]);
	//		txtMM5.setText(me[4]);
	//		txtMC6.setText(ma[5]);
	//		txtMM6.setText(me[5]);
	//		txtMC7.setText(ma[6]);
	//		txtMM7.setText(me[6]);
	//		txtMC8.setText(ma[7]);
	//		txtMM8.setText(me[7]);
	//		txtMC9.setText(ma[8]);
	//		txtMM9.setText(me[8]);
	//		txtMC10.setText(ma[9]);
	//		txtMM10.setText(me[9]);
	//	}

	public static void output(String catagory, String text) {
		text = "{" + catagory + "}- " + text;

		switch(line) {
		case 0: lblCommand11.setText(text);break;
		case 1: lblCommand10.setText(text);break;
		case 2: lblCommand9.setText(text);break;
		case 3: lblCommand8.setText(text);break;
		case 4: lblCommand8.setText(text);break;
		case 5: lblCommand7.setText(text);break;
		case 6: lblCommand6.setText(text);break;
		case 7: lblCommand5.setText(text);break;
		case 8: lblCommand4.setText(text);break;
		case 9: lblCommand3.setText(text);break;
		case 10: lblCommand2.setText(text);break;
		case 11: lblCommand1.setText(text);break;
		}

		line++;

		if(line >= 13) {
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

	public static void mOutput(String catagory, String text) {
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

	public static void cOutput(String catagory, String text) {
		text = "{" + catagory + "}- " + text;

		switch(line) {
		case 0: lblCCommand12.setText(text);break;
		case 1: lblCCommand11.setText(text);break;
		case 2: lblCCommand10.setText(text);break;
		case 3: lblCCommand9.setText(text);break;
		case 4: lblCCommand8.setText(text);break;
		case 5: lblCCommand8.setText(text);break;
		case 6: lblCCommand7.setText(text);break;
		case 7: lblCCommand6.setText(text);break;
		case 8: lblCCommand5.setText(text);break;
		case 9: lblCCommand4.setText(text);break;
		case 10: lblCCommand3.setText(text);break;
		case 11: lblCCommand2.setText(text);break;
		case 12: lblCCommand1.setText(text);break;
		}

		line++;

		if(line >= 14) {
			lblCCommand12.setText(lblCCommand11.getText());
			lblCCommand11.setText(lblCCommand10.getText());
			lblCCommand10.setText(lblCCommand9.getText());
			lblCCommand9.setText(lblCCommand8.getText());
			lblCCommand8.setText(lblCCommand7.getText());
			lblCCommand7.setText(lblCCommand6.getText());
			lblCCommand6.setText(lblCCommand5.getText());
			lblCCommand5.setText(lblCCommand4.getText());
			lblCCommand4.setText(lblCCommand3.getText());
			lblCCommand3.setText(lblCCommand2.getText());
			lblCCommand2.setText(lblCCommand1.getText());
			lblCCommand1.setText(text);
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

	//	public static BufferedImage loadImage(String path) {
	//		try {
	//			return ImageIO.read(ImageLoader.class.getResource(path));
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//			System.exit(1);
	//		}
	//		return null;
	//	}
















	//-----------------------------------------------------------------------------------------------// W R I T E //-------------------------------------------------------


	//	public void write() {
	//
	//		String fille = "C:\\Users\\Embit User\\Desktop\\KID\\Testing\\024.xlsx"; 
	//
	//		//Read the spreadsheet that needs to be updated
	//		FileInputStream fsIP;
	//		try {
	//
	//			fsIP = new FileInputStream(new File(fille));  
	//			//Access the workbook                 
	//			XSSFWorkbook wb = new XSSFWorkbook(fsIP);
	//			//Access the worksheet, so that we can update / modify it. 
	//			XSSFSheet worksheet = wb.getSheetAt(0); 
	//			// declare a Cell object
	//
	//
	//			Cell cell = null; 
	//
	//			cell = worksheet.getRow(10).getCell(2);      // Access the second cell in second row to update the value
	//			cell.setCellValue("PT Lyrical Group Cake");     // Get current cell value value and overwrite the value
	//
	//			cell = worksheet.getRow(10).getCell(2);   
	//			cell.setCellValue("PT Lyrical Group Cake");
	//
	//
	//			// Get current cell value value and overwrite the value
	//
	//			//Close the InputStream  
	//			fsIP.close(); 
	//
	//
	//			//Open FileOutputStream to write updates
	//			FileOutputStream output_file =new FileOutputStream(new File(fille));  
	//			//write changes
	//			wb.write(output_file);
	//
	//
	//			//close the stream
	//			output_file.close();
	//
	//		} catch (FileNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//	}






	public JLabel getLbsMaterial() {
		return lbsMaterial;
	}
	public void setLbsMaterial(JLabel lbsMaterial) {
		this.lbsMaterial = lbsMaterial;
	}
	public static void setLblsMaterialText(String text) {
		lbsMaterial.setText(text);
	}


	public JLabel getLbsBottom() {
		return lbsBottom;
	}
	public void setLbsBottom(JLabel lbsBottom) {
		this.lbsBottom = lbsBottom;
	}
	public static void setLblsBottomText(String text) {
		lbsBottom.setText(text);
	}


	public JLabel getLbsCPC() {
		return lbsCPC;
	}
	public void setLbsCPC(JLabel lbsCPC) {
		this.lbsCPC = lbsCPC;
	}
	public static void setLblsCPCText(String text) {
		lbsCPC.setText(text);
	}


	public JLabel getLbsRhinestone() {
		return lbsRhinestone;
	}
	public void setLbsRhinestone(JLabel lbsRhinestone) {
		this.lbsRhinestone = lbsRhinestone;
	}
	public static void setLblsRhinestoneText(String text) {
		lbsRhinestone.setText(text);
	}

	public JLabel getLbsHours() {
		return lbsHours;
	}
	public void setLbsHours(JLabel lbsHours) {
		this.lbsHours = lbsHours;
	}
	public static void setLblsHoursText(String text) {
		lbsHours.setText(text);
	}


	public JLabel getLbsTotal() {
		return lbsTotal;
	}
	public void setLbsTotal(JLabel lbsTotal) {
		this.lbsTotal = lbsTotal;
	}
	public static void setLblsTotalText(String text) {
		lbsTotal.setText(text);
	}


	public JLabel getLbsSubtotal() {
		return lbsSubtotal;
	}
	public void setLbsSubtotal(JLabel lbsSubtotal) {
		this.lbsSubtotal = lbsSubtotal;
	}
	public static void setLblsSubtotalText(String text) {
		lbsSubtotal.setText(text);
	}

	public JLabel getLbsDeposit() {
		return lbsDeposit;
	}
	public void setLbsDeposit(JLabel lbsDeposit) {
		this.lbsDeposit = lbsDeposit;
	}
	public static void setLblsDepositText(String text) {
		lbsDeposit.setText(text);
	}

	public JSpinner getSpnHH() {
		return spnHH;
	}
	public void setSpnHH(JSpinner spnHH) {
		this.spnHH = spnHH;
	}
	public static Object getSpnHHValue() {
		return (spnHH.getValue());
	}

	public JSpinner getSpnK() {
		return spnK;
	}
	public void setSpnK(JSpinner spnK) {
		this.spnK = spnK;
	}
	public static double getSpnKValue() {
		return Double.parseDouble((String) spnK.getValue());
	}

	public JRadioButton getRdbGroup() {		
		return rdbGroup;
	}
	public void setRdbGroup(JRadioButton rdbGroup) {
		this.rdbGroup = rdbGroup;
	}
	public static boolean getRdbGroupBool() {
		return rdbGroup.isSelected();
	}

	public JRadioButton getRdbSolo() {
		return rdbSolo;
	}
	public void setRdbSolo(JRadioButton rdbSolo) {
		this.rdbSolo = rdbSolo;
	}
	public static boolean getRdbSoloBool() {
		return rdbSolo.isSelected();
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
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("C")){
							strCurrentLine = br.readLine();
							lblInvoiceNumberR.setText(lblInvoiceNumberR.getText() + strCurrentLine);
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("Y")){
							strCurrentLine = br.readLine();
							lblInvoiceNumberR.setText(lblInvoiceNumberR.getText() + strCurrentLine + " - ");
							years = Integer.parseInt(strCurrentLine);
							strCurrentLine = br.readLine();


						}else if(strCurrentLine.equals("S")){
							strCurrentLine = br.readLine();
							lblInvoiceNumberR.setText(strCurrentLine + " - ");
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
							//							Filli();


							ol = 1000;
						}else {
							//						System.out.println(strCurrentLine);
						}
					}
					lblInvoiceNumberR.setText(x.substring(0, 2) + " - " + x.substring(3, 5) + " - " + x.substring(6));
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

			//			//Material
			//			content += "M\n";
			//			content += txtMC1.getText() + "\n" + txtMM1.getText() + "\n-\n";
			//			content += txtMC2.getText() + "\n" + txtMM2.getText() + "\n-\n";
			//			content += txtMC3.getText() + "\n" + txtMM3.getText() + "\n-\n";
			//			content += txtMC4.getText() + "\n" + txtMM4.getText() + "\n-\n";
			//			content += txtMC5.getText() + "\n" + txtMM5.getText() + "\n-\n";
			//			content += txtMC6.getText() + "\n" + txtMM6.getText() + "\n-\n";
			//			content += txtMC7.getText() + "\n" + txtMM7.getText() + "\n-\n";
			//			content += txtMC8.getText() + "\n" + txtMM8.getText() + "\n";
			//			content += "/\n";


			//Rhinestones
			content += "R\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n-\n";
			content += spnRT1.getValue() + "\n" + spnRS1.getValue() + "\n" + spnRA1.getValue() + "\n";
			content += "/\n";


			content += "G\n" + spnK.getValue() + "\n/\n";
			content += "H\n" + spnHH.getValue() + "\n/\n";
			//			content += "D\n" + Double.valueOf(txtDD.getText()) + "\n/\n";

			content += "e";

			bw.write(content);

			// no need to close it.
			//bw.close();

			//			System.out.println("Done");

			//			message = "File n. " + a + " Saved";
			//			txtCommand.setText(txtCommand.getText() + message + "\n");

		} catch (IOException e) {  e.printStackTrace();  }



		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Embit User\\eclipse-workspace\\kiad\\src\\kiada\\Saves.txt"))) {



		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


