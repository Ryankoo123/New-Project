package spaceExplorer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpaceTravel extends JFrame {
	
	String name_1 = "";
	String name_2 = "";
	String name_3 = "";
	String name_4 = "";
	
	CrewMember[] PilotList = new CrewMember[2];
	JButton[] UsedButton = new JButton[2];

	boolean pilot_1 = false;
	boolean pilot_2 = false;
	
	public CrewMember[] getPilotList() {
		return PilotList;
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceTravel frame = new SpaceTravel();
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
	public SpaceTravel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int CrewListSize = CrewInfo.CrewList.size();


		
		if (0 < CrewListSize && CrewInfo.CrewList.get(0).NumberOfMoves > 0) {
			name_1 = CrewInfo.CrewList.get(0).getName();

		}
		if (1 < CrewListSize && CrewInfo.CrewList.get(1).NumberOfMoves > 0) {
			name_2 = CrewInfo.CrewList.get(1).getName();

		}
		if (2 < CrewListSize && CrewInfo.CrewList.get(2).NumberOfMoves > 0) {
			name_3 = CrewInfo.CrewList.get(2).getName();

		}
		if (3 < CrewListSize && CrewInfo.CrewList.get(3).NumberOfMoves > 0) {
			name_4 = CrewInfo.CrewList.get(3).getName();

		}
		
		JButton button_1 = new JButton(name_1);
		button_1.setBounds(6, 45, 193, 45);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton(name_2);
		button_2.setBounds(6, 90, 193, 45);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton(name_3);
		button_3.setBounds(6, 136, 193, 45);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton(name_4);
		button_4.setBounds(6, 183, 193, 45);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(251, 77, 193, 45);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(251, 164, 193, 45);
		contentPane.add(button_6);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PilotList[0] == null) {
					PilotList[0] = CrewInfo.CrewList.get(0);
					UsedButton[0] = button_1;
					button_5.setText(PilotList[0].getName());
					button_1.setEnabled(false);
				} else if (PilotList[1] == null) {
					PilotList[1] = CrewInfo.CrewList.get(0);
					UsedButton[1] = button_1;
					button_6.setText(PilotList[1].getName());
					button_1.setEnabled(false);}
				}
		});	

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PilotList[0] == null) {
					PilotList[0] = CrewInfo.CrewList.get(1);
					UsedButton[0] = button_2;
					button_5.setText(PilotList[0].getName());
					button_2.setEnabled(false);
				} else if (PilotList[1] == null) {
					PilotList[1] = CrewInfo.CrewList.get(1);
					UsedButton[1] = button_2;
					button_6.setText(PilotList[1].getName());
					button_2.setEnabled(false);}
				}
		});	
				
					
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PilotList[0] == null) {
					PilotList[0] = CrewInfo.CrewList.get(2);
					UsedButton[0] = button_3;
					button_5.setText(PilotList[0].getName());
					button_3.setEnabled(false);
				} else if (PilotList[1] == null) {
					PilotList[1] = CrewInfo.CrewList.get(2);
					UsedButton[1] = button_3;
					button_6.setText(PilotList[1].getName());
					button_3.setEnabled(false);}
				}
		});	
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PilotList[0] == null) {
					PilotList[0] = CrewInfo.CrewList.get(3);
					UsedButton[0] = button_4;
					button_5.setText(PilotList[0].getName());
					button_4.setEnabled(false);
				} else if (PilotList[1] == null) {
					PilotList[1] = CrewInfo.CrewList.get(3);
					UsedButton[1] = button_4;
					button_6.setText(PilotList[1].getName());
					button_4.setEnabled(false);}
				}
		});	
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_5.setText("");
				PilotList[0] = null;
				UsedButton[0].setEnabled(true);
				
			}});
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_6.setText("");
				PilotList[1] = null;
				UsedButton[1].setEnabled(true);
				
			}});
	
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(218, 45, 10, 183);
		contentPane.add(separator);
		
		JButton launchButton = new JButton("Launch Ship");
		launchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PilotList[0] != null && PilotList[1] != null) {
					PilotList[0].NumberOfMoves -= 1;
					PilotList[1].NumberOfMoves -= 1;
					
					GameEnvironment.PilotList = PilotList;
					

					dispose();

				} else { JOptionPane.showMessageDialog(contentPane, "Please select 2 crew members");
				
				}
			}
		});
		launchButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		launchButton.setBounds(235, 232, 209, 40);
		contentPane.add(launchButton);
		
		JLabel lblNewLabel = new JLabel("Select 2 pilots");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(235, 6, 132, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pilot 1:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(251, 49, 90, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPilot = new JLabel("Pilot 2:");
		lblPilot.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPilot.setBounds(251, 136, 90, 29);
		contentPane.add(lblPilot);
		
		JLabel lblNewLabel_2 = new JLabel("Eligible Members");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(6, 6, 193, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Only members with 1+ actions are listed\n");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblNewLabel_3.setBounds(6, 250, 222, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblClickOnThe = new JLabel("Click on the buttons to remove/add,");
		lblClickOnThe.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblClickOnThe.setBounds(16, 230, 212, 22);
		contentPane.add(lblClickOnThe);
	}
		
		
}
