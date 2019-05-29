package spaceExplorer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;

public class GameDays extends JFrame {
	
	public int days;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDays frame = new GameDays();
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
	public GameDays() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSlider slider = new JSlider();
		slider.setBounds(370, 294, 527, 97);
		slider.setMajorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				days = slider.getValue();
			}
		});
		contentPane.setLayout(null);
		slider.setPaintLabels(true);
		slider.setToolTipText("");
		slider.setValue(3);
		slider.setPaintTicks(true);
		slider.setMinimum(3);
		slider.setMaximum(10);
		contentPane.add(slider);
		
		JButton btnNumber = new JButton("OK");
		btnNumber.setBounds(570, 460, 138, 60);
		btnNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameEnvironment GameEnvironment = new GameEnvironment();
				spaceExplorer.GameEnvironment.NumberOfDays = days;
				GameEnvironment.getNumberOfPieces();
//				System.out.println(Images.GameEnvironment.pieces);
				
				JOptionPane.showConfirmDialog(null, "Play time: " + days + " Days");
				CrewSelection CrewSelection = new CrewSelection();
				CrewSelection.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnNumber);
		
		JLabel lblSelectPeriod = new JLabel("Choose Your Play Time");
		lblSelectPeriod.setBounds(370, 186, 527, 60);
		lblSelectPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPeriod.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		contentPane.add(lblSelectPeriod);
		
		JLabel lblDays = new JLabel("Days -");
		lblDays.setBounds(237, 294, 123, 97);
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		contentPane.add(lblDays);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.text);
		separator.setBounds(389, 233, 489, 13);
		contentPane.add(separator);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
//				lblDays.setText("Days: " + slider.getValue());
			}
		});
		
	}
}
