package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cartago.tools.GUIArtifact;
import communities.Community;
import communities.Mailbox;
import users.User;

import javafx.geometry.VPos;
import servers.CommunitiesManager;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class MainInterface extends JFrame{
	private JPanel contentPane;
	public AbstractButton btnCreateMailbox;
	public AbstractButton btnCreateVoting; 
	public AbstractButton btnCreateForum;
	public AbstractButton btnShowCommunities;
	public AbstractButton btnEnterCommunity;
	public AbstractButton btnOwnedCommunities;

	public MainInterface(String name) {
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 434, 214);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Communities", null, panel, null);
		
		btnCreateMailbox= new JButton("Create Mailbox");
		btnCreateMailbox.setBounds(102, 5, 173, 23);
		panel.setLayout(null);
		panel.add(btnCreateMailbox);
		
		btnShowCommunities = new JButton("Show Communities");
		btnShowCommunities.setBounds(102, 152, 173, 23);
		panel.add(btnShowCommunities);
		
		btnCreateVoting= new JButton("Create Voting");
		btnCreateVoting.setBounds(102, 50, 173, 23);
		panel.add(btnCreateVoting);
		
		btnCreateForum = new JButton("Create Forum");
		btnCreateForum.setBounds(102, 99, 171, 23);
		panel.add(btnCreateForum);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnEnterCommunity = new JButton("Enter Community");
		btnEnterCommunity.setBounds(100, 5, 169, 23);
		panel_1.add(btnEnterCommunity);
		
		btnOwnedCommunities = new JButton("Owned Communities");
		btnOwnedCommunities.setBounds(100, 44, 169, 23);
		panel_1.add(btnOwnedCommunities);
		
		JButton btnChangeInterests = new JButton("Change Interests");
		btnChangeInterests.setBounds(100, 85, 169, 23);
		panel_1.add(btnChangeInterests);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Connection", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnConnectToServer = new JButton("Connect to server");
		btnConnectToServer.setBounds(10, 34, 182, 35);
		panel_2.add(btnConnectToServer);
		
		JButton btnNewButton = new JButton("Disconnect from server");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(225, 34, 182, 35);
		panel_2.add(btnNewButton);
		
		

	}
}
