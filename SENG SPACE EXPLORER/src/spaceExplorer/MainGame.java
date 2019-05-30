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
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Rectangle;

public class MainGame extends JFrame {

	private JPanel contentPane;
	private String MemberName;
	public LinkedList<JButton> btnFoodList = new LinkedList<JButton>();				
	public LinkedList<JButton> btnMedList = new LinkedList<JButton>();
	public LinkedList<JLabel> lblItemCountList = new LinkedList<JLabel>();			//food item count list
	public LinkedList<JLabel> lblItemCountList2 = new LinkedList<JLabel>();			//Med item count list
	public LinkedList<JButton> storeBuyFood = new LinkedList<JButton>();
	public LinkedList<JButton> storeBuyMed = new LinkedList<JButton>();
	public LinkedList<JButton> storeItems = new LinkedList<JButton>();
	public JButton[] ButtonList = new JButton[4];
	
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
		setBounds(new Rectangle(0, 0, 0, 2000));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 0, 2000));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setSize(334, 491);
		JScrollPane scroller = new JScrollPane(panel_4);
		scroller.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(47, 79, 79), null));
		scroller.setVisible(false);
		scroller.setBounds(902, 96, 334, 491);
		contentPane.add(scroller);
		
		JButton lblStoreitems = new JButton("");
		lblStoreitems.setToolTipText("CHICKEN (DECREASE HUNGER BY 25%)");
		lblStoreitems.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStoreitems.setContentAreaFilled(false);
		lblStoreitems.setPreferredSize(new Dimension(2, 2));
		lblStoreitems.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		lblStoreitems.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreitems.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Chicken.png")));
		
		JButton label_3 = new JButton("");
		label_3.setToolTipText("BURGER (DECREASE HUNGER BY 15%)");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setContentAreaFilled(false);
		label_3.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/burger.png")));
		label_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_4 = new JButton("");
		label_4.setToolTipText("BREAD (DECREASE HUNGER BY 10%)");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setContentAreaFilled(false);
		label_4.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Bread.png")));
		label_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblChicken = new JLabel("Chicken");
		lblChicken.setVerticalAlignment(SwingConstants.BOTTOM);
		lblChicken.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicken.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel label_12 = new JLabel("Nutrition  -  25%");
		label_12.setHorizontalTextPosition(SwingConstants.LEADING);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setVerticalAlignment(SwingConstants.BOTTOM);
		label_12.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurger.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblNutrition = new JLabel("Nutrition  -  15%");
		lblNutrition.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNutrition.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrition.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton label_5 = new JButton("");
		label_5.setToolTipText("ICE CREAM (DECREASE HUNGER BY 5%)\r\n");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.setContentAreaFilled(false);
		label_5.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/ice cream.png")));
		label_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_6 = new JButton("");
		label_6.setToolTipText("TEA (DECREASE HUNGER BY 3%)");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setContentAreaFilled(false);
		label_6.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/tea.png")));
		label_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_7 = new JButton("");
		label_7.setToolTipText("TOFFEE (DECREASE HUNGER BY 2%)");
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.setContentAreaFilled(false);
		label_7.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorer/Toffee.png")));
		label_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 102, 0), new Color(204, 255, 0)));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_8 = new JButton("");
		label_8.setToolTipText("SYRING: +60HP (Cures Plague)");
		label_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_8.setContentAreaFilled(false);
		label_8.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/syring.png")));
		label_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_9 = new JButton("");
		label_9.setToolTipText("PAINKILLERS: +20HP");
		label_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_9.setContentAreaFilled(false);
		label_9.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Painkillers1.png")));
		label_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton label_10 = new JButton("");
		label_10.setToolTipText("BANDAGE: +10HP");
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setContentAreaFilled(false);
		label_10.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/Bandage1.png")));
		label_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 0, 0), new Color(255, 51, 102)));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnBuy = new JButton("Buy  $30");
		btnBuy.setForeground(new Color(0, 100, 0));
		btnBuy.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuy.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy);
		
		JButton btnSell = new JButton("Sell  $22");
		btnSell.setForeground(Color.DARK_GRAY);
		btnSell.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell.setContentAreaFilled(false);
		
		JButton btnBuy_1 = new JButton("Buy  $23");
		btnBuy_1.setForeground(new Color(0, 100, 0));
		btnBuy_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_1.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy_1);
		
		JButton btnSell_1 = new JButton("Sell  $17");
		btnSell_1.setForeground(Color.DARK_GRAY);
		btnSell_1.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_1.setContentAreaFilled(false);
		
		JLabel lblBread = new JLabel("Bread");
		lblBread.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBread.setHorizontalAlignment(SwingConstants.CENTER);
		lblBread.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblNutrition_1 = new JLabel("Nutrition  -  10%");
		lblNutrition_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNutrition_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrition_1.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_2 = new JButton("Buy  $18");
		btnBuy_2.setForeground(new Color(0, 100, 0));
		btnBuy_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_2.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy_2);
		
		JButton btnSell_2 = new JButton("Sell  $12");
		btnSell_2.setForeground(Color.DARK_GRAY);
		btnSell_2.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_2.setContentAreaFilled(false);
		
		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIceCream.setHorizontalAlignment(SwingConstants.CENTER);
		lblIceCream.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblNutrition_2 = new JLabel("Nutrition  -  5%");
		lblNutrition_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNutrition_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrition_2.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_3 = new JButton("Buy  $10");
		btnBuy_3.setForeground(new Color(0, 100, 0));
		btnBuy_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_3.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy_3);
		
		JButton btnSell_3 = new JButton("Sell  $7");
		btnSell_3.setForeground(Color.DARK_GRAY);
		btnSell_3.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_3.setContentAreaFilled(false);
		
		JLabel lblTea = new JLabel("Tea");
		lblTea.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTea.setHorizontalAlignment(SwingConstants.CENTER);
		lblTea.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblNutrition_3 = new JLabel("Nutrition  -  4%");
		lblNutrition_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNutrition_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrition_3.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_4 = new JButton("Buy  $8");
		btnBuy_4.setForeground(new Color(0, 100, 0));
		btnBuy_4.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_4.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy_4);
		
		JButton btnSell_4 = new JButton("Sell  $5");
		btnSell_4.setForeground(Color.DARK_GRAY);
		btnSell_4.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_4.setContentAreaFilled(false);
		
		JLabel lblToffee = new JLabel("Toffee");
		lblToffee.setVerticalAlignment(SwingConstants.BOTTOM);
		lblToffee.setHorizontalAlignment(SwingConstants.CENTER);
		lblToffee.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblNutrition_4 = new JLabel("Nutrition  -  2%");
		lblNutrition_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNutrition_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutrition_4.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_5 = new JButton("Buy  $5");
		btnBuy_5.setForeground(new Color(0, 100, 0));
		btnBuy_5.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_5.setContentAreaFilled(false);
		storeBuyFood.add(btnBuy_5);
		
		JButton btnSell_5 = new JButton("Sell  $2");
		btnSell_5.setForeground(Color.DARK_GRAY);
		btnSell_5.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_5.setContentAreaFilled(false);
		
		JLabel lblSyringe = new JLabel("Syringe");
		lblSyringe.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSyringe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSyringe.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblCuresPlague = new JLabel("Cures Plague +60HP");
		lblCuresPlague.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCuresPlague.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuresPlague.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_6 = new JButton("Buy  $40");
		btnBuy_6.setForeground(new Color(0, 100, 0));
		btnBuy_6.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_6.setContentAreaFilled(false);
		storeBuyMed.add(btnBuy_6);
		
		JButton btnSell_6 = new JButton("Sell  $30");
		btnSell_6.setForeground(Color.DARK_GRAY);
		btnSell_6.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_6.setContentAreaFilled(false);
		
		JLabel lblPainkillers = new JLabel("Painkillers");
		lblPainkillers.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPainkillers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPainkillers.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblhp = new JLabel("+ 20HP");
		lblhp.setVerticalAlignment(SwingConstants.BOTTOM);
		lblhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblhp.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_7 = new JButton("Buy  $25");
		btnBuy_7.setForeground(new Color(0, 100, 0));
		btnBuy_7.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_7.setContentAreaFilled(false);
		storeBuyMed.add(btnBuy_7);
		
		JButton btnSell_7 = new JButton("Sell  $15");
		btnSell_7.setForeground(Color.DARK_GRAY);
		btnSell_7.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_7.setContentAreaFilled(false);
		
		JLabel lblBandage = new JLabel("Bandage");
		lblBandage.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBandage.setHorizontalAlignment(SwingConstants.CENTER);
		lblBandage.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JLabel lblhp_1 = new JLabel("+ 10HP");
		lblhp_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblhp_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblhp_1.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		
		JButton btnBuy_8 = new JButton("Buy  $5");
		btnBuy_8.setForeground(new Color(0, 100, 0));
		btnBuy_8.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnBuy_8.setContentAreaFilled(false);
		storeBuyMed.add(btnBuy_8);
		
		JButton btnSell_8 = new JButton("Sell  $3");
		btnSell_8.setForeground(Color.DARK_GRAY);
		btnSell_8.setFont(new Font("Agency FB", Font.BOLD, 14));
		btnSell_8.setContentAreaFilled(false);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblStoreitems, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChicken, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBurger, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutrition, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBuy_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(18)
									.addComponent(lblBread, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNutrition_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
							.addGap(6))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIceCream, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutrition_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTea, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutrition_3, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblToffee, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutrition_4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_5, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_5, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSyringe, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCuresPlague, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_6, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_6, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPainkillers, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblhp, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_7, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_7, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBandage, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblhp_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addComponent(btnBuy_8, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnSell_8, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStoreitems, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblChicken, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(label_12)
							.addGap(25)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(7)
							.addComponent(lblBurger, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNutrition, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(7)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(11)
							.addComponent(lblBread, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNutrition_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(7)
							.addComponent(lblIceCream, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNutrition_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblTea, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNutrition_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(7)
							.addComponent(lblToffee, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblNutrition_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(7)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblSyringe, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblCuresPlague, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblPainkillers, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblhp, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblBandage, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblhp_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy_8, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSell_8, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))))
		);
		panel_4.setLayout(gl_panel_4);
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
		lblShipStatus.setBounds(154, 308, 268, 39);
		lblShipStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipStatus.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		contentPane.add(lblShipStatus);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(136, 341, 304, 25);
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
		btnUseItem.setBounds(65, 104, 177, 40);
		panel.add(btnUseItem);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.setEnabled(false);
		btnSleep.setBounds(65, 248, 177, 40);
		panel.add(btnSleep);
		
		JButton btnRepairShip = new JButton("Repair ship");
		btnRepairShip.setEnabled(false);
		btnRepairShip.setBounds(65, 176, 177, 40);
		panel.add(btnRepairShip);

		JButton btnLoot = new JButton("Loot");
		btnLoot.setBorder(UIManager.getBorder("Button.border"));
		btnLoot.setBackground(UIManager.getColor("Button.background"));
		btnLoot.setEnabled(false);
		btnLoot.setBounds(65, 32, 177, 40);
		panel.add(btnLoot);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(27, 461, 548, 202);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(902, 96, 334, 491);
		contentPane.add(panel_3);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.DARK_GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		
		JButton btnExplorePlanet = new JButton("Explore Planets");
		btnExplorePlanet.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnExplorePlanet.setBounds(54, 389, 225, 51);
		panel_3.add(btnExplorePlanet);
		btnExplorePlanet.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Planet:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		lblNewLabel.setBounds(90, 27, 154, 51);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/planetRed.png")));
		lblNewLabel_1.setBounds(24, 78, 286, 300);
		panel_3.add(lblNewLabel_1);
		btnExplorePlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planet planet = new Planet();
				planet.setVisible(true);
				
			}
		});
		
		JLabel lblMoney = new JLabel("Money: $" + GameEnvironment.money);
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		lblMoney.setBounds(27, 395, 207, 39);
		contentPane.add(lblMoney);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(MainGame.class.getResource("/spaceExplorerImages/character 3.png")));
		label.setVisible(false);
		
		/**
		 * GUI action
		 */
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Actions");
		tglbtnNewToggleButton.setBackground(UIManager.getColor("Button.background"));
		tglbtnNewToggleButton.setBorder(UIManager.getBorder("Button.border"));
		tglbtnNewToggleButton.setEnabled(false);
		tglbtnNewToggleButton.setBounds(650, 290, 177, 40);
		contentPane.add(tglbtnNewToggleButton);
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
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(221, 107, 79, 75);
		panel_1.add(label_1);
		
		JButton label_2 = new JButton("");
		label_2.setContentAreaFilled(false);
		label_2.setBorder(UIManager.getBorder("Button.border"));
		label_2.setHorizontalTextPosition(SwingConstants.LEFT);
		label_2.setVisible(false);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setBounds(371, 107, 79, 75);
		panel_1.add(label_2);
		
		JButton lblMeditems = new JButton("");
		lblMeditems.setContentAreaFilled(false);
		lblMeditems.setBorder(UIManager.getBorder("Button.border"));
		lblMeditems.setVisible(false);
		lblMeditems.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMeditems.setBounds(71, 107, 79, 75);
		panel_1.add(lblMeditems);
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
		crewinfo.addFoodItem(Food.CHICKEN);
		crewinfo.addFoodItem(Food.BURGER);
		crewinfo.addFoodItem(Food.BREAD);
		crewinfo.addFoodItem(Food.ICECREAM);
		crewinfo.addFoodItem(Food.TEA);
		crewinfo.addFoodItem(Food.TOFFEE);
		
		//Adding Medicine to game
		crewinfo.addMedicalItem(Medicine.MEDICINE1);
		crewinfo.addMedicalItem(Medicine.MEDICINE2);
		crewinfo.addMedicalItem(Medicine.MEDICINE3);
			
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
		
		//Food items in store
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.CHICKEN);
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.BURGER);
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.BREAD);
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.ICECREAM);
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.TEA);
		gameEnvironment.addStoreItemFood(spaceExplorer.Food.TOFFEE);
		
		//Med items in store
		gameEnvironment.addStoreItemMeds(spaceExplorer.Medicine.MEDICINE1);
		gameEnvironment.addStoreItemMeds(spaceExplorer.Medicine.MEDICINE2);
		gameEnvironment.addStoreItemMeds(spaceExplorer.Medicine.MEDICINE3);
		
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
		 * Action button switch
		 * 
		 */

		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnNewToggleButton.isSelected()) {					//ENABLE action buttons
					btnUseItem.setEnabled(true);
					btnSleep.setEnabled(true);
					btnRepairShip.setEnabled(true);
					btnLoot.setEnabled(true);
					panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 204, 153), null));
				} else {
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
		
		/*
		 * 
		 * setting actions
		 * 
		 */		
		JLabel lblShipPieces = new JLabel("Transporter Parts: " + GameEnvironment.pieces);
		lblShipPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipPieces.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		lblShipPieces.setBounds(281, 395, 268, 39);
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
				btnExplorePlanet.setEnabled(true);
				CrewMember s = CrewInfo.CrewList.get(0);
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
					btnExplorePlanet.setEnabled(true);
					CrewMember j = CrewInfo.CrewList.get(1);
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
					btnExplorePlanet.setEnabled(true);
					CrewMember k = CrewInfo.CrewList.get(2);
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
					btnExplorePlanet.setEnabled(true);
					CrewMember k = CrewInfo.CrewList.get(3);
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
		

		btnLoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
						
						//ADDING ITEMS TO THE INVENTORY
						lblInventory.setVisible(true);
						btnInventoryChange.setVisible(true);
						btnInventoryChange.setText("Healing Items");
						panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 204, 153), null));
						
						for (FoodItem i: CrewInfo.FoodList) {						//FOOD BUTTON ICONS
							btnFoodList.get(CrewInfo.FoodList.indexOf(i)).setVisible(true);
							btnFoodList.get(CrewInfo.FoodList.indexOf(i)).setIcon(new ImageIcon(MainGame.class.getResource(i.imageIcon)));
							btnFoodList.get(CrewInfo.FoodList.indexOf(i)).setName(i.name);
							lblItemCountList.get(CrewInfo.FoodList.indexOf(i)).setVisible(true);
							lblItemCountList.get(CrewInfo.FoodList.indexOf(i)).setText("X " + i.foodCount);
						}
					}
					
					//Disable actions after number of moves == 0
					if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
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
															
					for (MedicalItem i: CrewInfo.MedicalList) {						//FOOD BUTTON ICONS
						btnMedList.get(CrewInfo.MedicalList.indexOf(i)).setVisible(true);
						btnMedList.get(CrewInfo.MedicalList.indexOf(i)).setIcon(new ImageIcon(MainGame.class.getResource(i.medimg)));
						lblItemCountList2.get(CrewInfo.MedicalList.indexOf(i)).setVisible(true);
						lblItemCountList2.get(CrewInfo.MedicalList.indexOf(i)).setText("X " + i.medCount);
						
					}
					
				} else {
					btnInventoryChange.setText("Healing Items");
					
					int j = 0;
					for (FoodItem i: CrewInfo.FoodList) {						//FOOD BUTTON ICONS
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
				
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
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
				
				if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
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
					if (CrewInfo.FoodList.get(btnFoodList.indexOf(i)).foodCount != 0 && CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
						
						CrewInfo.FoodList.get(btnFoodList.indexOf(i)).foodCount -= 1;
						CrewInfo.CrewList.get(GameEnvironment.currentplayer).feed(CrewInfo.FoodList.get(btnFoodList.indexOf(i)).getNutrition());		//Use food item
						progressBar_3.setValue(CrewInfo.CrewList.get(GameEnvironment.currentplayer).getHunger());
						progressBar_3.revalidate();
						progressBar_3.repaint();
						
						btnUseItem.setEnabled(false);
						btnUseItem.setSelected(false);
						btnSleep.setEnabled(false);
						btnRepairShip.setEnabled(false);
						btnLoot.setEnabled(false);
						tglbtnNewToggleButton.setSelected(false);
						tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
						if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
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
					if (CrewInfo.MedicalList.get(btnMedList.indexOf(i)).medCount != 0 && CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves > 0) {
						CrewInfo.MedicalList.get(btnMedList.indexOf(i)).medCount -= 1;
						CrewInfo.CrewList.get(GameEnvironment.currentplayer).consumeMedicalItem(CrewInfo.MedicalList.get(btnMedList.indexOf(i)));		//Use food item
						progressBar_1.setValue(CrewInfo.CrewList.get(GameEnvironment.currentplayer).getHealth());
						progressBar_1.revalidate();
						progressBar_1.repaint();
						
						btnUseItem.setEnabled(false);
						btnUseItem.setSelected(false);
						btnSleep.setEnabled(false);
						btnRepairShip.setEnabled(false);
						btnLoot.setEnabled(false);
						tglbtnNewToggleButton.setSelected(false);
						tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
						if (CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves <= 0) {
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
					scroller.setVisible(true);
					panel_3.setVisible(false);
				} else {
					scroller.setVisible(false);
					panel_3.setVisible(true);
				}
			}
		});
		
		/**
		 * 
		 * Buying from store
		 * 
		 */
		for (JButton i: storeBuyFood) {
			i.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FoodItem foodItem = new FoodItem(GameEnvironment.storeFoodList.get(storeBuyFood.indexOf(i)));
						for (FoodItem j: CrewInfo.FoodList) {
							if (j.name == foodItem.name) {
								if (GameEnvironment.money >= j.getPrice()) {
									GameEnvironment.money -= j.price;
									lblMoney.setText("Money: $" + GameEnvironment.money);
									lblMoney.revalidate();
									lblMoney.repaint();
									
									CrewInfo.FoodList.get(CrewInfo.FoodList.indexOf(j)).foodCount += 1;
									lblItemCountList.get(CrewInfo.FoodList.indexOf(j)).setText("X " + j.foodCount);
									for (JLabel lbl: lblItemCountList) {
										lbl.revalidate();
										lbl.repaint();
									}
								} else {
									JOptionPane.showMessageDialog(contentPane, "Not enough money to buy this item");
								}
							}
						}
				}
			});
		}
		
		for (JButton i: storeBuyMed) {
			i.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MedicalItem medicalItem = new MedicalItem(GameEnvironment.storeMedicalList.get(storeBuyMed.indexOf(i)));
						for (MedicalItem j: CrewInfo.MedicalList) {
							if (j.name == medicalItem.name) {
								if (GameEnvironment.money >= j.getPrice()) {
									GameEnvironment.money -= j.getPrice();
									lblMoney.setText("Money: $" + GameEnvironment.money);
									lblMoney.revalidate();
									lblMoney.repaint();
									
									CrewInfo.MedicalList.get(CrewInfo.MedicalList.indexOf(j)).medCount += 1;
									lblItemCountList2.get(CrewInfo.MedicalList.indexOf(j)).setText("X " + j.medCount);
									for (JLabel lbl: lblItemCountList2) {
										lbl.revalidate();
										lbl.repaint();
									}
								} else {
									JOptionPane.showMessageDialog(contentPane, "Not enough money to buy this item");
								}
							}
						}
				}
			});
		}
		
		
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
						
						if (i.hasPlague) {
							plagueSign.setVisible(true);;
						} 
						
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
				
				for (CrewMember i:CrewInfo.CrewList) {
					if (i.isDead()) {
						ButtonList[0] = Member_1;
						
						
					}
					
				}
				
				btnNewButton_1.revalidate();
				btnNewButton_1.repaint();
				tglbtnNewToggleButton.setText("Actions    X " + CrewInfo.CrewList.get(GameEnvironment.currentplayer).NumberOfMoves);
				tglbtnNewToggleButton.revalidate();
				tglbtnNewToggleButton.repaint();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
