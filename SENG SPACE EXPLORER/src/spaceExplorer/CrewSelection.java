package spaceExplorer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.border.SoftBevelBorder;

import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;


public class CrewSelection extends JFrame {

	private JPanel contentPane;
	public spaceExplorer.Type charType;
	private boolean remove = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewSelection frame = new CrewSelection();
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
	public CrewSelection() {
		
		//Create class first to modify its components throughout
		CrewInfo crewinfo = new CrewInfo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCharacter = new JButton("MECHANIC");
		btnCharacter.setBounds(246, 111, 126, 46);
		
		JButton btnCharacter_1 = new JButton("LIFELINE");
		btnCharacter_1.setBounds(378, 111, 126, 46);
		
		JButton btnCharacter_2 = new JButton("SKINNY");
		btnCharacter_2.setBounds(510, 111, 126, 46);
		
		JButton btnCharacter_3 = new JButton("OPERATOR");
		btnCharacter_3.setBounds(642, 111, 126, 46);
		
		JButton btnCharacter_4 = new JButton("FIGHTER");
		btnCharacter_4.setBounds(774, 111, 126, 46);
		
		JButton btnCharacter_5 = new JButton("TRACKER");
		btnCharacter_5.setBounds(906, 111, 126, 46);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(245, 251, 347, 41);
		
		JLabel lblCharacter = new JLabel("Character :");
		lblCharacter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCharacter.setBounds(131, 251, 116, 41);
		
		JLabel lblAbility = new JLabel("Ability      :");
		lblAbility.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbility.setBounds(131, 300, 104, 25);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(245, 300, 347, 25);
		
		JButton btnAdd = new JButton("ADD >");
		btnAdd.setBounds(831, 322, 126, 46);
		
		JButton btnReset = new JButton("< REMOVE");
		btnReset.setBounds(831, 375, 126, 46);
		
		JLabel lblSelectCharacter = new JLabel("Choose your team");
		lblSelectCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCharacter.setBounds(489, 54, 289, 46);
		lblSelectCharacter.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		
		JButton btnNewButton = new JButton("Start Adventure");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		btnNewButton.setBounds(494, 569, 277, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Set ship name
				String shipName = JOptionPane.showInputDialog("Name your Spaceship");
				crewinfo.setShipName(shipName);
				
				//next frame
				setVisible(false);
				MainGame Maingame = new MainGame();
				Maingame.setVisible(true);
			}
		});
		
		JLabel lblYourTeam = new JLabel("Your team\r\n");
		lblYourTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourTeam.setBounds(940, 205, 232, 46);
		lblYourTeam.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		
		JLabel lblCharacterInfo = new JLabel("Character Info");
		lblCharacterInfo.setBounds(141, 213, 232, 30);
		lblCharacterInfo.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		
		JPanel panel = new JPanel();
		panel.setBounds(984, 241, 152, 60);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(984, 308, 152, 60);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(984, 374, 152, 60);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.setLayout(null);
		contentPane.add(lblSelectCharacter);
		contentPane.add(btnCharacter);
		contentPane.add(btnCharacter_1);
		contentPane.add(btnCharacter_2);
		contentPane.add(btnCharacter_3);
		contentPane.add(btnCharacter_4);
		contentPane.add(btnCharacter_5);
		contentPane.add(lblCharacterInfo);
		contentPane.add(lblYourTeam);
		contentPane.add(lblNewLabel);
		contentPane.add(lblAbility);
		contentPane.add(lblCharacter);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnAdd);
		contentPane.add(btnReset);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.add(panel_1);
		contentPane.add(panel_2);
		contentPane.add(btnNewButton);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(494, 193, 277, 365);
		contentPane.add(lblImage);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.activeCaptionText);
		separator.setForeground(SystemColor.desktop);
		separator.setBounds(196, 175, 875, 13);
		contentPane.add(separator);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(984, 440, 152, 60);
		contentPane.add(panel_3);
		
		//character info		
		btnCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE1;
				crewMember.setType(charType);
				
				
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
				lblNewLabel_1.setText(crewMember.ability);
			}
		});
		
		btnCharacter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter_1.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE2;
				crewMember.setType(charType);
				lblNewLabel_1.setText(crewMember.ability);
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
			}
		});
		
		btnCharacter_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter_2.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE3;
				crewMember.setType(charType);
				lblNewLabel_1.setText(crewMember.ability);
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
			}
		});
		
		btnCharacter_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter_3.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE4;
				crewMember.setType(charType);
				lblNewLabel_1.setText(crewMember.ability);
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
			}
		});
		
		btnCharacter_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter_4.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE5;
				crewMember.setType(charType);
				lblNewLabel_1.setText(crewMember.ability);
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
			}
		});
		
		btnCharacter_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(btnCharacter_5.getText());
				CrewMember crewMember = new CrewMember();
				charType = spaceExplorer.Type.TYPE6;
				crewMember.setType(charType);
				lblNewLabel_1.setText(crewMember.ability);
				lblImage.setIcon(new ImageIcon(CrewSelection.class.getResource(crewMember.characterimg)));
			}
		});
		
		//adding members
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String charName = JOptionPane.showInputDialog("Name your character");
				crewinfo.addMember(charType, charName);			
				
				int j = 0;
				if (remove) {
					j = 0;
					remove = false;
				}
				
				if (crewinfo.CrewList.size() <= 4) {					//add member icon
					for (CrewMember i : crewinfo.getCrewList()) {
						JButton bttn = new JButton(i.name);
						bttn.setBounds(992, 250 + j, 132, 38);			//956, 355, 132, 38
						contentPane.add(bttn);
						bttn.repaint();
						j += 65;
						
					}	
				}			
			}
		});
		
		//REMOVING MEMBERS
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewinfo.CrewList.size() != 0) {
					while (crewinfo.CrewList.size() > 0) {
						crewinfo.CrewList.remove(0);	
					}
					remove = true;
					revalidate();
					repaint();
				}
			}
		});
	
	}
}
