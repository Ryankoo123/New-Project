package spaceExplorer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.ranges.Range;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSplitPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class MainGame extends JFrame {

	private JPanel contentPane;
	private String MemberName;
	public LinkedList<JButton> btnFoodList = new LinkedList<JButton>();				
	public LinkedList<JButton> btnMedList = new LinkedList<JButton>();
	public LinkedList<JLabel> lblItemCountList = new LinkedList<JLabel>();			//food item count list
	public LinkedList<JLabel> lblItemCountList2 = new LinkedList<JLabel>();			//Med item count list
	public JButton[] ButtonList = new JButton[4];
	public ArrayList<Food> food = new ArrayList<Food>(Arrays.asList(Food.values()));
	public ArrayList<Medicine> medicine = new ArrayList<Medicine>(Arrays.asList(Medicine.values()));
	public int index_1 = 0;
	public int index_2 = 1;
	public int index_3;
	public int index_4;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame frame = new MainGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrew = new JLabel("Crew Members");
		lblCrew.setBounds(27, 53, 237, 25);
		lblCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCrew);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(280, 78, 16, 219);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		JLabel lblCharacterInfo = new JLabel("Member Status");
		lblCharacterInfo.setBounds(312, 53, 237, 25);
		lblCharacterInfo.setToolTipText("");
		lblCharacterInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacterInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCharacterInfo);
		
		JButton Member_1 = new JButton("");
		Member_1.setBounds(27, 107, 237, 40);
		Member_1.setToolTipText("Click to see info.");
		contentPane.add(Member_1);
		ButtonList[0] = Member_1;
		
		JButton Member_2 = new JButton("");
		Member_2.setBounds(27, 152, 237, 40);
		Member_2.setToolTipText("Click to see info.");
		contentPane.add(Member_2);
		ButtonList[1] = Member_2;

		
		JButton Member_3 = new JButton("");
		Member_3.setBounds(27, 198, 237, 40);
		Member_3.setToolTipText("Click to see info.");
		contentPane.add(Member_3);		
		ButtonList[2] = Member_3;

		
		JButton Member_4 = new JButton("");
		Member_4.setToolTipText("Click to see info.");
		Member_4.setBounds(27, 244, 237, 40);
		contentPane.add(Member_4);
		ButtonList[3] = Member_4;

		
		JLabel lblShipStatus = new JLabel("");
		lblShipStatus.setBounds(154, 290, 268, 39);
		lblShipStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipStatus.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		contentPane.add(lblShipStatus);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(138, 320, 304, 25);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		progressBar.setToolTipText("Ship status.");
		progressBar.setForeground(new Color(144, 238, 144));
		progressBar.setBackground(Color.WHITE);
		contentPane.add(progressBar);
		
		JLabel lblHealth = new JLabel("HEALTH");
		lblHealth.setBounds(293, 134, 117, 25);
		contentPane.add(lblHealth);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setName("");
		progressBar_1.setBounds(378, 134, 171, 25);
		progressBar_1.setToolTipText("");
		progressBar_1.setForeground(new Color(127, 255, 0));
		progressBar_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		progressBar_1.setBackground(UIManager.getColor("text"));
		contentPane.add(progressBar_1);
		
		JLabel lblTiredness = new JLabel("TIREDNESS");
		lblTiredness.setBounds(293, 180, 84, 25);
		contentPane.add(lblTiredness);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setToolTipText("");
		progressBar_2.setForeground(new Color(255, 215, 0));
		progressBar_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		progressBar_2.setBackground(UIManager.getColor("window"));
		progressBar_2.setBounds(378, 180, 171, 25);
		contentPane.add(progressBar_2);
		
		JLabel lblHunger = new JLabel("HUNGER");
		lblHunger.setBounds(293, 226, 84, 25);
		contentPane.add(lblHunger);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setToolTipText("");
		progressBar_3.setForeground(new Color(255, 215, 0));
		progressBar_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		progressBar_3.setBackground(UIManager.getColor("window"));
		progressBar_3.setBounds(378, 226, 171, 25);
		contentPane.add(progressBar_3);
		
		JButton btnNewButton_1 = new JButton("Day");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 28));
		btnNewButton_1.setBounds(902, 610, 334, 53);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(585, 341, 307, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JToggleButton btnUseItem = new JToggleButton("Inventory");
		btnUseItem.setEnabled(false);
		btnUseItem.setBounds(22, 104, 262, 40);
		panel.add(btnUseItem);
		
		JButton btnSleep = new JButton("Sleep");
	
		btnSleep.setEnabled(false);
		btnSleep.setBounds(22, 248, 262, 40);
		panel.add(btnSleep);
		
		JButton btnRepairShip = new JButton("Repair ship");
		btnRepairShip.setEnabled(false);
		btnRepairShip.setBounds(22, 176, 262, 40);
		panel.add(btnRepairShip);

		
		
		JToggleButton btnLoot = new JToggleButton("Loot Planet");
		btnLoot.setEnabled(false);
		btnLoot.setBounds(22, 32, 262, 40);
		panel.add(btnLoot);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(1, 461, 548, 202);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setVisible(false);
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblInventory.setBounds(187, 0, 148, 49);
		panel_1.add(lblInventory);
		
		JButton button_3 = new JButton("");
		button_3.setVisible(false);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setContentAreaFilled(false);
		button_3.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Bread.png")));
		button_3.setBounds(20, 108, 63, 60);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setVisible(false);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setContentAreaFilled(false);
		button_4.setBounds(103, 108, 63, 60);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setVisible(false);
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.setContentAreaFilled(false);
		button_5.setBounds(186, 108, 63, 60);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setVisible(false);
		button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_6.setContentAreaFilled(false);
		button_6.setBounds(269, 108, 63, 60);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setVisible(false);
		button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_7.setContentAreaFilled(false);
		button_7.setBounds(352, 108, 63, 60);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setHorizontalTextPosition(SwingConstants.CENTER);
		button_8.setVisible(false);
		button_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_8.setContentAreaFilled(false);
		button_8.setBounds(435, 108, 63, 60);
		panel_1.add(button_8);
		
		JButton btnInventoryChange = new JButton("");
		btnInventoryChange.setVisible(false);
		btnInventoryChange.setBounds(192, 60, 138, 29);
		panel_1.add(btnInventoryChange);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(902, 96, 334, 491);
		contentPane.add(panel_3);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		
		JButton btnExplorePlanet = new JButton("Travel To New Planet");
		btnExplorePlanet.setBounds(53, 389, 225, 51);
		panel_3.add(btnExplorePlanet);
		
		JLabel PlanetLabel = new JLabel("Current Planet:");
		PlanetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PlanetLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		PlanetLabel.setBounds(6, 27, 322, 51);
		panel_3.add(PlanetLabel);
		
		/*
		 * Initiating PlanetInfo, and adding the order of the planets
		 * 
		 */
		
		PlanetInfo PlanetInfo = new PlanetInfo();
		Planet PlanetRed = new Planet("Planet Red", "/spaceExplorerImages/planetRed.png");	
		Planet PlanetBlue = new Planet("Planet Blue", "/spaceExplorerImages/planetBlue.png"); 
		Planet PlanetCyan = new Planet("Planet Cyan", "/spaceExplorerImages/planetCyan.png"); 
		Planet PlanetDarkBlue = new Planet("Planet DarkBlue", "/spaceExplorerImages/planetDarkBlue.png"); 
		Planet PlanetGray = new Planet("Planet Gray", "/spaceExplorerImages/planetGray.png"); 
		Planet PlanetGreen = new Planet("Planet Green", "/spaceExplorerImages/planetGreen.png"); 
		Planet PlanetLime = new Planet("Planet Lime", "/spaceExplorerImages/planetLime.png"); 
		Planet PlanetPurple = new Planet("Planet Purple", "/spaceExplorerImages/planetPurple.png");
		Planet PlanetYellow = new Planet("Planet Yellow", "/spaceExplorerImages/planetYellow.png");
		
		PlanetInfo.PlanetList[0] = PlanetRed;
		PlanetInfo.PlanetList[1] = PlanetBlue;
		PlanetInfo.PlanetList[2] = PlanetCyan;
		PlanetInfo.PlanetList[3] = PlanetDarkBlue;
		PlanetInfo.PlanetList[4] = PlanetGray;
		PlanetInfo.PlanetList[5] = PlanetGreen;
		PlanetInfo.PlanetList[6] = PlanetLime;
		PlanetInfo.PlanetList[7] = PlanetPurple;
		PlanetInfo.PlanetList[8] = PlanetYellow;
		
		
		

		
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 204), new Color(51, 51, 255)));
		panel_2.setBounds(902, 96, 334, 491);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton lblStoreitems = new JButton("");
		lblStoreitems.setToolTipText("DECREASE HUNGER BY 25%");
		lblStoreitems.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStoreitems.setContentAreaFilled(false);
		lblStoreitems.setBounds(25, 20, 79, 66);
		panel_2.add(lblStoreitems);
		lblStoreitems.setPreferredSize(new Dimension(2, 2));
		lblStoreitems.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		lblStoreitems.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreitems.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Chicken.png")));
		
		JButton label_3 = new JButton("");
		label_3.setToolTipText("DECREASE HUNGER BY 15%");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setContentAreaFilled(false);
		label_3.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/burger.png")));
		label_3.setBounds(128, 20, 79, 66);
		label_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_3);
		
		JButton label_4 = new JButton("");
		label_4.setToolTipText("DECREASE HUNGER BY 10%");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setContentAreaFilled(false);
		label_4.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Bread.png")));
		label_4.setBounds(231, 20, 79, 66);
		label_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_4);
		
		JButton label_5 = new JButton("");
		label_5.setToolTipText("DECREASE HUNGER BY 5%");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.setContentAreaFilled(false);
		label_5.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/ice cream.png")));
		label_5.setBounds(25, 170, 79, 66);
		label_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_5);
		
		JButton label_6 = new JButton("");
		label_6.setToolTipText("DECREASE HUNGER BY 3%");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setContentAreaFilled(false);
		label_6.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/tea.png")));
		label_6.setBounds(128, 170, 79, 66);
		label_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_6);
		
		JButton label_7 = new JButton("");
		label_7.setToolTipText("DECREASE HUNGER BY 2%");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.setContentAreaFilled(false);
		label_7.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Toffee.png")));
		label_7.setBounds(231, 170, 79, 66);
		label_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_7);
		
		JButton label_8 = new JButton("");
		label_8.setToolTipText("+60HP (Cures Plague)");
		label_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_8.setContentAreaFilled(false);
		label_8.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/syring.png")));
		label_8.setBounds(25, 320, 79, 89);
		label_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_8);
		
		JButton label_9 = new JButton("");
		label_9.setToolTipText("+20HP");
		label_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_9.setContentAreaFilled(false);
		label_9.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Painkillers1.png")));
		label_9.setBounds(128, 320, 79, 89);
		label_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_9);
		
		JButton label_10 = new JButton("");
		label_10.setToolTipText("+10HP");
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setContentAreaFilled(false);
		label_10.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Bandage1.png")));
		label_10.setBounds(231, 320, 79, 89);
		label_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_10);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setContentAreaFilled(false);
		btnBuy.setBounds(25, 97, 79, 23);
		panel_2.add(btnBuy);
		
		JButton button_9 = new JButton("Buy");
		button_9.setContentAreaFilled(false);
		button_9.setBounds(128, 97, 79, 23);
		panel_2.add(button_9);
		
		JButton button_10 = new JButton("Buy");
		button_10.setContentAreaFilled(false);
		button_10.setBounds(231, 97, 79, 23);
		panel_2.add(button_10);
		
		JButton button_11 = new JButton("Buy");
		button_11.setContentAreaFilled(false);
		button_11.setBounds(25, 247, 79, 23);
		panel_2.add(button_11);
		
		JButton button_12 = new JButton("Buy");
		button_12.setContentAreaFilled(false);
		button_12.setBounds(128, 247, 79, 23);
		panel_2.add(button_12);
		
		JButton button_13 = new JButton("Buy");
		button_13.setContentAreaFilled(false);
		button_13.setBounds(231, 247, 79, 23);
		panel_2.add(button_13);
		
		JButton button_14 = new JButton("Buy");
		button_14.setContentAreaFilled(false);
		button_14.setBounds(231, 423, 79, 23);
		panel_2.add(button_14);
		
		JButton button_15 = new JButton("Buy");
		button_15.setContentAreaFilled(false);
		button_15.setBounds(128, 423, 79, 23);
		panel_2.add(button_15);
		
		JButton button_16 = new JButton("Buy");
		button_16.setContentAreaFilled(false);
		button_16.setBounds(25, 423, 79, 23);
		panel_2.add(button_16);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setContentAreaFilled(false);
		btnSell.setBounds(25, 131, 79, 23);
		panel_2.add(btnSell);
		
		JButton button_17 = new JButton("Sell");
		button_17.setContentAreaFilled(false);
		button_17.setBounds(128, 131, 79, 23);
		panel_2.add(button_17);
		
		JButton button_18 = new JButton("Sell");
		button_18.setContentAreaFilled(false);
		button_18.setBounds(231, 131, 79, 23);
		panel_2.add(button_18);
		
		JButton button_19 = new JButton("Sell");
		button_19.setContentAreaFilled(false);
		button_19.setBounds(25, 281, 79, 23);
		panel_2.add(button_19);
		
		JButton button_20 = new JButton("Sell");
		button_20.setContentAreaFilled(false);
		button_20.setBounds(128, 281, 79, 23);
		panel_2.add(button_20);
		
		JButton button_21 = new JButton("Sell");
		button_21.setContentAreaFilled(false);
		button_21.setBounds(231, 281, 79, 23);
		panel_2.add(button_21);
		
		JButton button_22 = new JButton("Sell");
		button_22.setContentAreaFilled(false);
		button_22.setBounds(25, 457, 79, 23);
		panel_2.add(button_22);
		
		JButton button_23 = new JButton("Sell");
		button_23.setContentAreaFilled(false);
		button_23.setBounds(128, 457, 79, 23);
		panel_2.add(button_23);
		
		JButton button_24 = new JButton("Sell");
		button_24.setContentAreaFilled(false);
		button_24.setBounds(231, 457, 79, 23);
		panel_2.add(button_24);
		
		JLabel lblMoney = new JLabel("Money: $" + GameEnvironment.money);
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		lblMoney.setBounds(27, 357, 207, 39);
		contentPane.add(lblMoney);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/character 3.png")));
		label.setVisible(false);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Actions");
		tglbtnNewToggleButton.setBackground(UIManager.getColor("Button.background"));
		tglbtnNewToggleButton.setBorder(UIManager.getBorder("Button.border"));
		tglbtnNewToggleButton.setEnabled(false);
		tglbtnNewToggleButton.setBounds(650, 290, 177, 40);
		contentPane.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton.isSelected()) {						//ENABLE btnEat  btnSleep  btnRepairShip  btnLoot  btnExplorePlanet
//					System.out.println("A");
					btnUseItem.setEnabled(true);
					btnSleep.setEnabled(true);
					btnRepairShip.setEnabled(true);
					btnLoot.setEnabled(true);
					panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 204, 153), null));
				} else {
//					System.out.println("B");
					btnUseItem.setEnabled(false);
					btnUseItem.setSelected(false);
					btnSleep.setEnabled(false);
					btnRepairShip.setEnabled(false);
					btnLoot.setEnabled(false);

					panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
					panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
					
					for (JButton i: btnFoodList) {
						i.setVisible(false);
					}
					
					for (JButton i: btnMedList) {
						i.setVisible(false);
					}
					
					for (JLabel i: lblItemCountList) {
						i.setVisible(false);
					}
					
					for (JLabel i: lblItemCountList2) {
						i.setVisible(false);
					}
					
					btnInventoryChange.setVisible(false);
					lblInventory.setVisible(false);
				}
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(585, 21, 280, 217);
		contentPane.add(label);
		
		JLabel lblMembername = new JLabel("");
		lblMembername.setFont(new Font("Agency FB", Font.BOLD, 25));
		lblMembername.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembername.setBounds(626, 244, 224, 40);
		contentPane.add(lblMembername);
		
		JButton label_1 = new JButton("");
		label_1.setContentAreaFilled(false);
		label_1.setBorder(UIManager.getBorder("Button.border"));
		label_1.setVisible(false);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		label_1.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/syring.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(221, 107, 79, 75);
		panel_1.add(label_1);
		
		JButton label_2 = new JButton("");
		label_2.setContentAreaFilled(false);
		label_2.setBorder(UIManager.getBorder("Button.border"));
		label_2.setHorizontalTextPosition(SwingConstants.LEFT);
		label_2.setVisible(false);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		label_2.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Painkillers1.png")));
		label_2.setBounds(371, 107, 79, 75);
		panel_1.add(label_2);
		
		JButton lblMeditems = new JButton("");
		lblMeditems.setContentAreaFilled(false);
		lblMeditems.setBorder(UIManager.getBorder("Button.border"));
		lblMeditems.setVisible(false);
		lblMeditems.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMeditems.setBounds(71, 107, 79, 75);
		panel_1.add(lblMeditems);
//		ImageIcon img = lblMeditems.getIcon();
//		lblMeditems.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Bandage1.png")));
		lblMeditems.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblX = new JLabel("");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX.setBounds(20, 171, 63, 20);
		panel_1.add(lblX);
		
		JLabel lblX_1 = new JLabel("");
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX_1.setBounds(103, 171, 63, 20);
		panel_1.add(lblX_1);
		
		JLabel lblX_2 = new JLabel("");
		lblX_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_2.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX_2.setBounds(186, 171, 63, 20);
		panel_1.add(lblX_2);
		
		JLabel lblX_3 = new JLabel("");
		lblX_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_3.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX_3.setBounds(269, 171, 63, 20);
		panel_1.add(lblX_3);
		
		JLabel lblX_4 = new JLabel("");
		lblX_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_4.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX_4.setBounds(352, 171, 63, 20);
		panel_1.add(lblX_4);
		
		JLabel lblX_5 = new JLabel("");
		lblX_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_5.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblX_5.setBounds(435, 171, 63, 20);
		panel_1.add(lblX_5);
		
		
		JToggleButton btnSpaceStore = new JToggleButton("Space Outpost");
		btnSpaceStore.setEnabled(false);
		btnSpaceStore.setFont(new Font("Agency FB", Font.BOLD, 28));
		btnSpaceStore.setBounds(902, 21, 334, 53);
		contentPane.add(btnSpaceStore);
		
		JLabel plagueSign = new JLabel("Infected with space plague");
		plagueSign.setVisible(false);
		plagueSign.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		plagueSign.setBounds(293, 97, 202, 25);
		
		JLabel lblX_6 = new JLabel("");
		lblX_6.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblX_6.setBounds(160, 137, 63, 45);
		panel_1.add(lblX_6);
		
		JLabel lblX_7 = new JLabel("");
		lblX_7.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblX_7.setBounds(310, 138, 63, 43);
		panel_1.add(lblX_7);
		
		JLabel lblX_8 = new JLabel("");
		lblX_8.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblX_8.setBounds(459, 138, 63, 43);
		panel_1.add(lblX_8);
		
		
		
		
		/*
		 * ship name and ship health bar
		 * 
		 */
		lblShipStatus.setText(CrewInfo.ShipName + " Health");
		progressBar.setValue((int) Math.round(CrewInfo.ShipHealth));
		
		
		/*
		 * 
		 * setting up game environment
		 * 
		 */	
		randomEvent randomEvent = new randomEvent();

		CrewInfo crewinfo = new CrewInfo();
		crewinfo.addMember(spaceExplorer.Type.TYPE1, "MECHANIC");
		crewinfo.addMember(spaceExplorer.Type.TYPE2, "LIFELINE");
		crewinfo.addMember(spaceExplorer.Type.TYPE3, "SKINNY");
		crewinfo.addMember(spaceExplorer.Type.TYPE4, "TRACKER");
		
		if (GameEnvironment.NumberOfDays == 0) {						//default number of days for testing
			GameEnvironment.NumberOfDays = 5;
		}
		
		if (GameEnvironment.pieces == 0) {								//default pieces
			GameEnvironment.pieces = 3;
		}
		
		if (GameEnvironment.money == 0) {								//default Money
			GameEnvironment.money = 100;
			lblMoney.setText("Money: $" + GameEnvironment.money);
		}
		
		
		//Adding food to game
		crewinfo.addFoodItem(Food.BREAD);
		crewinfo.addFoodItem(Food.TEA);
		
		//Adding Medicine to game
		crewinfo.addMedicalItem(Medicine.MEDICINE3);
		crewinfo.addMedicalItem(Medicine.MEDICINE2);
			
		//adding inventory buttons to a list
		//food items
		btnFoodList.add(button_3);
		btnFoodList.add(button_4);
		btnFoodList.add(button_5);
		btnFoodList.add(button_6);
		btnFoodList.add(button_7);
		btnFoodList.add(button_8);
		
		//med items
		btnMedList.add(lblMeditems);
		btnMedList.add(label_1);
		btnMedList.add(label_2);
		
		//Item count for food
		lblItemCountList.add(lblX);
		lblItemCountList.add(lblX_1);
		lblItemCountList.add(lblX_2);
		lblItemCountList.add(lblX_3);
		lblItemCountList.add(lblX_4);
		lblItemCountList.add(lblX_5);
		
		//Item count for meds
		lblItemCountList2.add(lblX_6);
		lblItemCountList2.add(lblX_7);
		lblItemCountList2.add(lblX_8);
		
		for (JLabel i: lblItemCountList) {
			i.setVisible(false);
		}
		
		for (JLabel i: lblItemCountList2) {
			i.setVisible(false);
		}
		
		
		/*
		 * 
		 * adding crew member to buttons
		 * 
		 */
		int crewNum = 0;
		for (CrewMember i : crewinfo.getCrewList() ) {
			MemberName = i.getName();
			if (i.easterEgg) {
				i.ability = "SKINNY FOR A REASON";
			}
			
			if (crewNum == 0) {
				Member_1.setText(MemberName);
				Member_1.setToolTipText("Ability: " + i.ability);
//				if (i.NumberOfMoves == 0) {
//					btnNewButton.setEnabled(false);
//					btnNewButton.revalidate();
//					btnNewButton.repaint();
//				}
				
				
			}
			
			if (crewNum == 1) {
				Member_2.setText(MemberName);
				Member_2.setToolTipText("Ability: " + i.ability);
				
			}
			
			if (crewNum == 2) {
				Member_3.setText(MemberName);			
				Member_3.setToolTipText("Ability: " + i.ability);
				
			}
			
			if (crewNum == 3) {
				Member_4.setText(MemberName);
				Member_4.setToolTipText("Ability: " + i.ability);
				
			}
			
			crewNum += 1;
		}
		
		/*
		 * 
		 * setting actions
		 * 
		 */		
		JLabel lblShipPieces = new JLabel("Transporter Parts: " + GameEnvironment.pieces);
		lblShipPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipPieces.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		lblShipPieces.setBounds(280, 357, 268, 39);
		contentPane.add(lblShipPieces); 
				
		
		/*
		 * 
		 * Member info
		 * 
		 */
		Member_1.addActionListener(new ActionListener() {					//set progress bars
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setEnabled(true);
				btnSpaceStore.setEnabled(true);
				CrewMember s = crewinfo.CrewList.get(0);
				plagueSign.setVisible(s.hasPlague);
				progressBar_1.setValue(s.health);
				progressBar_1.setStringPainted(true);
				
				progressBar_2.setValue(s.tiredness);
				progressBar_2.setStringPainted(true);
				
				progressBar_3.setValue(s.hunger);
				progressBar_3.setStringPainted(true);
								
				label.setVisible(true);
				label.setIcon(new ImageIcon(MainGame.class.getResource(s.characterimg)));
				lblMembername.setText(s.name);
				tglbtnNewToggleButton.setText("Actions    X " + s.NumberOfMoves);
				if (s.NumberOfMoves > 0) {
					tglbtnNewToggleButton.setEnabled(true);
				} else {
					tglbtnNewToggleButton.setEnabled(false);
				}
				
				GameEnvironment.currentplayer = 0;
			}
		});
		
		if (crewNum >= 2) {
			Member_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton_1.setEnabled(true);
					btnSpaceStore.setEnabled(true);
					CrewMember j = crewinfo.CrewList.get(1);
					plagueSign.setVisible(j.hasPlague);
					progressBar_1.setValue(j.health);
					progressBar_1.setStringPainted(true);
					progressBar_1.repaint();
					
					progressBar_2.setValue(j.tiredness);
					progressBar_2.setStringPainted(true);
					progressBar_2.repaint();
					
					progressBar_3.setValue(j.hunger);
					progressBar_3.setStringPainted(true);
					progressBar_3.repaint();
					
					
					label.setVisible(true);
					label.setIcon(new ImageIcon(MainGame.class.getResource(j.characterimg)));
					lblMembername.setText(j.name);
					tglbtnNewToggleButton.setText("Actions    X " + j.NumberOfMoves);
					if (j.NumberOfMoves > 0) {
						tglbtnNewToggleButton.setEnabled(true);
					} else {
						tglbtnNewToggleButton.setEnabled(false);
					}
					
					GameEnvironment.currentplayer = 1;
				}
			});
		}
		
		if (crewNum >= 3) {
			Member_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton_1.setEnabled(true);
					btnSpaceStore.setEnabled(true);
					CrewMember k = crewinfo.CrewList.get(2);
					plagueSign.setVisible(k.hasPlague);

					progressBar_1.setValue(k.health);
					progressBar_1.setStringPainted(true);
					
					progressBar_2.setValue(k.tiredness);
					progressBar_2.setStringPainted(true);
					
					progressBar_3.setValue(k.hunger);
					progressBar_3.setStringPainted(true);
					
					
					label.setVisible(true);
					label.setIcon(new ImageIcon(MainGame.class.getResource(k.characterimg)));
					lblMembername.setText(k.name);
					tglbtnNewToggleButton.setText("Actions    X " + k.NumberOfMoves);
					if (k.NumberOfMoves > 0) {
						tglbtnNewToggleButton.setEnabled(true);
					} else {
						tglbtnNewToggleButton.setEnabled(false);
					}
					
					GameEnvironment.currentplayer = 2;
				}
			});
		}
		
		if (crewNum >= 4) {
			Member_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton_1.setEnabled(true);
					btnSpaceStore.setEnabled(true);
					CrewMember k = crewinfo.CrewList.get(3);
					plagueSign.setVisible(k.hasPlague);

					progressBar_1.setValue(k.health);
					progressBar_1.setStringPainted(true);
					
					progressBar_2.setValue(k.tiredness);
					progressBar_2.setStringPainted(true);
					
					progressBar_3.setValue(k.hunger);
					progressBar_3.setStringPainted(true);
					

					
					
					label.setVisible(true);
					label.setIcon(new ImageIcon(MainGame.class.getResource(k.characterimg)));
					lblMembername.setText(k.name);
					tglbtnNewToggleButton.setText("Actions    X " + k.NumberOfMoves);
					if (k.NumberOfMoves > 0) {
						tglbtnNewToggleButton.setEnabled(true);
					} else {
						tglbtnNewToggleButton.setEnabled(false);
					}
					
					GameEnvironment.currentplayer = 3;
				}
			});
		}
		
		
		
		JLabel SpaceTerrain = new JLabel(""); //Label for exploring planet
		SpaceTerrain.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Terrain.png")));
		SpaceTerrain.setBounds(0, 0, 427, 264);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(64, 420, 427, 254);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(SpaceTerrain);
		panel_4.setVisible(false);
		
		
		JButton RandomItem = new JButton(""); 
		RandomItem.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Chicken.png")));

		SpaceTerrain.add(RandomItem);

		RandomItem.setBounds(16, 189, 79, 59);
		RandomItem.setOpaque(false);
		RandomItem.setContentAreaFilled(false);
		RandomItem.setBorderPainted(false);
		
		JButton RandomItem_1 = new JButton("");
		RandomItem_1.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/burger.png")));


		RandomItem_1.setOpaque(false);
		RandomItem_1.setContentAreaFilled(false);
		RandomItem_1.setBorderPainted(false);
		RandomItem_1.setBounds(107, 167, 79, 59);
		SpaceTerrain.add(RandomItem_1);
		
		
		JButton RandomItem_2 = new JButton("");

		RandomItem_2.setOpaque(false);
		RandomItem_2.setContentAreaFilled(false);
		RandomItem_2.setBorderPainted(false);
		RandomItem_2.setBounds(207, 189, 79, 59);
		SpaceTerrain.add(RandomItem_2);
		
		
		JButton RandomItem_3 = new JButton("");

		RandomItem_3.setOpaque(false);
		RandomItem_3.setContentAreaFilled(false);
		RandomItem_3.setBorderPainted(false);
		RandomItem_3.setBounds(319, 150, 79, 59);
		SpaceTerrain.add(RandomItem_3);
		
		
		JButton RandomItem_4 = new JButton("");		
		RandomItem_4.setOpaque(false);
		RandomItem_4.setContentAreaFilled(false);
		RandomItem_4.setBorderPainted(false);
		RandomItem_4.setBounds(187, 87, 73, 68);
		SpaceTerrain.add(RandomItem_4);
		
		
		
		
		RandomItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {

					RandomItem.setIcon(new ImageIcon(MainGame.class.getResource("")));
					FoodItem a = new FoodItem(food.get(index_1));
					CrewInfo.FoodList.add(a);
					CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves --;
					tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
						tglbtnNewToggleButton.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "The selected crew member ran out of actions!");
				}
			}
		});
		
		
		RandomItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomItem_1.setIcon(new ImageIcon(MainGame.class.getResource("")));
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
					FoodItem b = new FoodItem(food.get(index_2));
					CrewInfo.FoodList.add(b);
					CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves --;
					tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
						tglbtnNewToggleButton.setEnabled(false);
										}
				} else {
					JOptionPane.showMessageDialog(contentPane, "The selected crew member ran out of actions!");
				}
			}
		});
		
		
		
		RandomItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {

					RandomItem_2.setIcon(new ImageIcon(MainGame.class.getResource("")));
					MedicalItem c = new MedicalItem(medicine.get(index_3));
					CrewInfo.MedicalList.add(c);
					CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves --;
					tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
						tglbtnNewToggleButton.setEnabled(false);
						}
				} else {
					JOptionPane.showMessageDialog(contentPane, "The selected crew member ran out of actions!");
				}
			}
		});
		

		RandomItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {

					RandomItem_3.setIcon(new ImageIcon(MainGame.class.getResource("")));
					FoodItem d = new FoodItem(food.get(index_4));
					CrewInfo.FoodList.add(d);
					CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves --;
					tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
						tglbtnNewToggleButton.setEnabled(false);
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "The selected crew member ran out of actions!");
				}

			}
		});
		
		

		RandomItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
					RandomItem_4.setIcon(new ImageIcon(MainGame.class.getResource("")));
					CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves --;
					GameEnvironment.pieces --;

					tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
					lblShipPieces.setText("Transporter Parts: " + GameEnvironment.pieces);
					
					if (GameEnvironment.pieces == 0) {
						setVisible(false);
						GameWon GameWon = new GameWon();
						GameWon.setVisible(true);
					}

					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
						tglbtnNewToggleButton.setEnabled(false);
					} 

				} else {
					JOptionPane.showMessageDialog(contentPane, "The selected crew member ran out of actions!");
				}


			}
		});
		
		
		
		btnLoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnLoot.isSelected()) {
					panel_1.setVisible(false);
					panel_4.setVisible(true);
					btnSleep.setEnabled(false);
					btnUseItem.setEnabled(false);
					btnRepairShip.setEnabled(false);
					
				} else {
					panel_1.setVisible(true);
					panel_4.setVisible(false);
					btnSleep.setEnabled(true);
					btnUseItem.setEnabled(true);
					btnRepairShip.setEnabled(true);
				}

				
				
			}
		});
		JLabel planetImage = new JLabel("");
		planetImage.setHorizontalAlignment(SwingConstants.RIGHT);
		PlanetLabel.setText("Current Planet: " + PlanetInfo.CurrentPlanet().PlanetName);
		planetImage.setIcon(new ImageIcon(MainGame.class.getResource(PlanetInfo.CurrentPlanet().PlanetImageLink)));
		planetImage.setBounds(25, 78, 281, 300);
		panel_3.add(planetImage);

		

		btnExplorePlanet.addActionListener(new ActionListener() {  // when player clicks travel to new planet button
			public void actionPerformed(ActionEvent e) {
				SpaceTravel spaceship = new SpaceTravel();
				spaceship.setVisible(false);
				spaceship.setVisible(true);
				spaceship.addWindowListener(new java.awt.event.WindowAdapter() {
			        @Override
			        public void windowClosed(java.awt.event.WindowEvent windowEvent) { //Checks if spaceTravel was closed
			        	if (!Arrays.asList(GameEnvironment.PilotList).contains(null)) {
			        		PlanetInfo.TravelToNewPlanet();
				    		planetImage.setIcon(new ImageIcon(MainGame.class.getResource(PlanetInfo.CurrentPlanet().PlanetImageLink)));
			        		PlanetLabel.setText("Current Planet: " + PlanetInfo.CurrentPlanet().PlanetName);
			        		tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
							if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves == 0) {
								tglbtnNewToggleButton.setEnabled(false);
							}
			        		
	
			        		
			        		int index_1 = randomEvent.randomFoodItemIndex();
			        		if (index_1 >= 0) {
			        			FoodItem e = new FoodItem(food.get(index_1));
			        			RandomItem.setIcon(new ImageIcon(MainGame.class.getResource(e.imageIcon)));
			        		}

			        		
			        		
			        		int index_2 = randomEvent.randomFoodItemIndex();
			        		if (index_2 >= 0) {
			        			FoodItem f = new FoodItem(food.get(index_2));
			        			RandomItem_1.setIcon(new ImageIcon(MainGame.class.getResource(f.imageIcon)));
			        		}

			        		
			        		
			        		
			        		int index_3 = randomEvent.randomMedicalItemIndex();
			        		if (index_3 >= 0) {
			        			MedicalItem g = new MedicalItem(medicine.get(index_3));
			        			RandomItem_2.setIcon(new ImageIcon(MainGame.class.getResource(g.medimg)));		
			        			}

			        		
			        		
			        		int index_4 = randomEvent.randomFoodItemIndex();
			        		if (index_4 >= 0) {
			        			FoodItem h = new FoodItem(food.get(index_4));
			        			RandomItem_3.setIcon(new ImageIcon(MainGame.class.getResource(h.imageIcon)));		
			        			}

			        		
			        		
			        		if (randomEvent.hasShipPart()) {
			        			RandomItem_4.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/parts.png")));		

			        		}		
			        		

			        	}
			        }
			    });
			}
			});
			
					
				

		
		


				
				
		
		
		
		



		/*
		 * 
		 * USE ITEMS FROM THE INVENTORY
		 * 
		 */
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnUseItem.isSelected()) {
					if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
						
						//ADDING ITEMS TO THE INVENTORY
						lblInventory.setVisible(true);
						btnInventoryChange.setVisible(true);
						btnInventoryChange.setText("Healing Items");
						panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 204, 153), null));
						
						for (FoodItem i: crewinfo.FoodList) {						//FOOD BUTTON ICONS
							btnFoodList.get(crewinfo.FoodList.indexOf(i)).setVisible(true);
							btnFoodList.get(crewinfo.FoodList.indexOf(i)).setIcon(new ImageIcon(MainGame.class.getResource(i.imageIcon)));
							btnFoodList.get(crewinfo.FoodList.indexOf(i)).setName(i.name);
							lblItemCountList.get(crewinfo.FoodList.indexOf(i)).setVisible(true);
							lblItemCountList.get(crewinfo.FoodList.indexOf(i)).setText("X " + i.foodCount);
						}
					}
					
					//Disable actions after number of moves == 0
					if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
						btnUseItem.setEnabled(false);
						btnUseItem.setSelected(false);
						btnSleep.setEnabled(false);
						btnRepairShip.setEnabled(false);
						btnLoot.setEnabled(false);
						tglbtnNewToggleButton.setSelected(false);
						tglbtnNewToggleButton.setEnabled(false);
					}
					tglbtnNewToggleButton.revalidate();
					tglbtnNewToggleButton.repaint();
					
					
				} else {													//WHEN BUTTON NOT SELECTED
					for (JButton i: btnFoodList) {
						i.setVisible(false);
					}
					for (JButton j: btnMedList) {
						j.setVisible(false);
					}
					for (JLabel s: lblItemCountList) {
						s.setVisible(false);
					}
					
					for (JLabel s: lblItemCountList2) {
						s.setVisible(false);
					}
					
					btnInventoryChange.setText("Space Food");
					btnInventoryChange.setVisible(false);
					btnInventoryChange.revalidate();
					lblInventory.setVisible(false);
					panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				}

			}
		});
		
		
		/*
		 * 
		 * Inventory switch food and medicine button
		 * 
		 */
		btnInventoryChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnInventoryChange.getText() == "Healing Items") {
					btnInventoryChange.setText("Space Food");
					
					for (JButton i: btnFoodList) {								//food buttons
						i.setVisible(false);
					}
					for (JLabel i: lblItemCountList) {
						i.setVisible(false);
					}
															
					for (MedicalItem i: crewinfo.MedicalList) {						//FOOD BUTTON ICONS
						btnMedList.get(crewinfo.MedicalList.indexOf(i)).setVisible(true);
						btnMedList.get(crewinfo.MedicalList.indexOf(i)).setIcon(new ImageIcon(MainGame.class.getResource(i.medimg)));
						lblItemCountList2.get(crewinfo.MedicalList.indexOf(i)).setVisible(true);
						lblItemCountList2.get(crewinfo.MedicalList.indexOf(i)).setText("X " + i.medCount);
						
					}
					
				} else {
					btnInventoryChange.setText("Healing Items");
					
					int j = 0;
					for (FoodItem i: crewinfo.FoodList) {						//FOOD BUTTON ICONS
						btnFoodList.get(j).setVisible(true);
						btnFoodList.get(j).setIcon(new ImageIcon(MainGame.class.getResource(i.imageIcon)));
						j += 1;
					}
					
					for (JButton i: btnMedList) {
						i.setVisible(false);
					}
					for (JLabel i: lblItemCountList) {
						i.setVisible(true);
					}
					
					for (JLabel i: lblItemCountList2) {
						i.setVisible(false);
					}
				}
			}
		});
		
		/*
		 * Sleep
		 */
		
		
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewInfo.CrewList.get(GameEnvironment.currentplayer).sleep();
				progressBar_2.setValue(CrewInfo.CrewList.get(GameEnvironment.currentplayer).tiredness);
				progressBar_2.revalidate();
				progressBar_2.repaint();
				tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
					tglbtnNewToggleButton.setEnabled(true);
				} else {
					tglbtnNewToggleButton.setEnabled(false);
				}
				
				if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
					btnUseItem.setEnabled(false);
					btnUseItem.setSelected(false);
					btnSleep.setEnabled(false);
					btnRepairShip.setEnabled(false);
					btnLoot.setEnabled(false);
					tglbtnNewToggleButton.setSelected(false);
					tglbtnNewToggleButton.setEnabled(false);
				}
				tglbtnNewToggleButton.revalidate();
				tglbtnNewToggleButton.repaint();
				
			}
		});
		
		/*
		 * repairs the ship
		 */
		
		
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CrewInfo.ShipHealth += CrewInfo.CrewList.get(GameEnvironment.currentplayer).repair;
				CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves -= 1;
				if (CrewInfo.ShipHealth > 100) {
					CrewInfo.ShipHealth = 100;
				}
				progressBar.setValue((int) Math.round(CrewInfo.ShipHealth));
				progressBar.revalidate();
				progressBar.repaint();
				tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
					tglbtnNewToggleButton.setEnabled(true);
				} else {
					tglbtnNewToggleButton.setEnabled(false);
				}
				
				if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
					btnUseItem.setEnabled(false);
					btnUseItem.setSelected(false);
					btnSleep.setEnabled(false);
					btnRepairShip.setEnabled(false);
					btnLoot.setEnabled(false);
					tglbtnNewToggleButton.setSelected(false);
					tglbtnNewToggleButton.setEnabled(false);
				}
				tglbtnNewToggleButton.revalidate();
				tglbtnNewToggleButton.repaint();
				
			}
		});
		
		
		
		/*
		 * 
		 * Consuming food when item clicked
		 * 
		 */
		for (JButton i : btnFoodList) {
			i.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (crewinfo.FoodList.get(btnFoodList.indexOf(i)).foodCount != 0 && crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
						
						crewinfo.FoodList.get(btnFoodList.indexOf(i)).foodCount -= 1;
						crewinfo.CrewList.get(GameEnvironment.currentplayer).feed(crewinfo.FoodList.get(btnFoodList.indexOf(i)).getNutrition());		//Use food item
						progressBar_3.setValue(crewinfo.CrewList.get(GameEnvironment.currentplayer).getHunger());
						progressBar_3.revalidate();
						progressBar_3.repaint();
						
						btnUseItem.setEnabled(false);
						btnUseItem.setSelected(false);
						btnSleep.setEnabled(false);
						btnRepairShip.setEnabled(false);
						btnLoot.setEnabled(false);
						tglbtnNewToggleButton.setSelected(false);
						tglbtnNewToggleButton.setText("Actions    X " + crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
						if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
							tglbtnNewToggleButton.setEnabled(false);
						}
						lblInventory.setVisible(false);
						btnInventoryChange.setVisible(false);
						tglbtnNewToggleButton.revalidate();
						tglbtnNewToggleButton.repaint();
						panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
						panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
						
						for (JButton i: btnFoodList) {
							i.setVisible(false);
						}
						
						for (JLabel i: lblItemCountList) {
							i.setVisible(false);
						}
					}
				}
			});
		}

		
		/*
		 * 
		 * Consuming medicine when clicked
		 * 
		 */
		for (JButton i : btnMedList) {
			i.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (crewinfo.MedicalList.get(btnMedList.indexOf(i)).medCount != 0 && crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
//						System.out.println(crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves + "A");
//						crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves -= 1;
//						System.out.println(crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves + "B");

						crewinfo.MedicalList.get(btnMedList.indexOf(i)).medCount -= 1;
						crewinfo.CrewList.get(GameEnvironment.currentplayer).consumeMedicalItem(crewinfo.MedicalList.get(btnMedList.indexOf(i)));		//Use food item
						progressBar_1.setValue(crewinfo.CrewList.get(GameEnvironment.currentplayer).getHealth());
						progressBar_1.revalidate();
						progressBar_1.repaint();
						
						btnUseItem.setEnabled(false);
						btnUseItem.setSelected(false);
						btnSleep.setEnabled(false);
						btnRepairShip.setEnabled(false);
						btnLoot.setEnabled(false);
						tglbtnNewToggleButton.setSelected(false);
						tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
						if (crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
							tglbtnNewToggleButton.setEnabled(false);
						}
						lblInventory.setVisible(false);
						btnInventoryChange.setVisible(false);
						tglbtnNewToggleButton.revalidate();
						tglbtnNewToggleButton.repaint();
						panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
						panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
						
						for (JButton i: btnMedList) {
							i.setVisible(false);
						}
						
						for (JLabel i: lblItemCountList2) {
							i.setVisible(false);
						}
						
					}
				}
			});
		}


		
//		System.out.println();
		
		
		
		
		/*
		 * 
		 * SPACE OUTPOST
		 * 
		 */

		btnSpaceStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnSpaceStore.isSelected()) {
					panel_2.setVisible(true);
					panel_3.setVisible(false);
				} else {
					panel_2.setVisible(false);
					panel_3.setVisible(true);
				}
			}
		});
		
		
		
		
		/*
		 * 
		 * Next day
		 * 
		 */
		btnNewButton_1.setText(GameEnvironment.NumberOfDays + " Days Remaining");
		
		contentPane.add(plagueSign);
		

		
	
		/**
		 * Action moving to next day
		 * 
		 */
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (GameEnvironment.NumberOfDays != 0) { //Next day
					
					if (randomEvent.alienPirates()) {
						JOptionPane.showMessageDialog(contentPane, "Uh oh! There seems to be alien pirates around!");
					}
					if (randomEvent.spacePlague()) {
						JOptionPane.showMessageDialog(contentPane, "Looks like some of your crew members caught the plague!");
					}
					CrewInfo.ShipHealth -= 10; //Ship health decays 10 every day
					progressBar.setValue((int) Math.round(CrewInfo.ShipHealth));
					

					
					for (CrewMember i : crewinfo.getCrewList()) {
						
						//decrease health over time 
						i.health -= i.getHealthDecrease();
						i.tiredness += i.tirednessDecrease;
						i.hunger += i.hungerDecrease;
						
						progressBar_1.setValue(i.health);
						progressBar_2.setValue(i.tiredness);
						progressBar_3.setValue(i.hunger);
						
				
						
						//reset number of moves
						i.NumberOfMoves = 2;
						for (JButton j: btnFoodList) {
							j.setEnabled(true);
							j.revalidate();
							j.repaint();
						}
						
					}
				} else if (GameEnvironment.NumberOfDays == 0) {				//Game finishing
					GameOver gameover = new GameOver();
					gameover.setVisible(true);
					setVisible(false);
				}
				
				GameEnvironment.NumberOfDays -= 1;							//Decrease number of days
				if (GameEnvironment.NumberOfDays > 1) {
					btnNewButton_1.setText(" " + GameEnvironment.NumberOfDays + " Days Remaining ");
				} else if(GameEnvironment.NumberOfDays == 1) {
					btnNewButton_1.setText(" " + GameEnvironment.NumberOfDays + " Day Remaining ");
				} else {
					btnNewButton_1.setText(" Finish ");
				}
				
				

				int indexCount = 0;
				for (CrewMember i:CrewInfo.CrewList) {  //Checks if any crew members have died


					if (i.isDead()) {
						ButtonList[indexCount].setText(i.name + " has died!");
						ButtonList[indexCount].setEnabled(false);
					}
					indexCount ++;
				}
				
				int deadCrewMembers = 0;  //Checks if all players are dead
				for (CrewMember i:CrewInfo.CrewList) {
					if (i.isDead()) {
						deadCrewMembers ++;
					}
				}
				
				if (deadCrewMembers == CrewInfo.CrewList.size()) { //If all players are dead, game over
					GameOver gameover = new GameOver();
					gameover.setVisible(true);
					setVisible(false);
				}
				
					
					
				
				
				btnNewButton_1.revalidate();
				btnNewButton_1.repaint();
				tglbtnNewToggleButton.setText("Actions    X " + crewinfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
				tglbtnNewToggleButton.revalidate();
				tglbtnNewToggleButton.repaint();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
