package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import communities.Community;
import communities.Mailbox;
import users.User;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class MainClass extends JFrame {

	private JPanel contentPane;

	public MainClass(final User user) {
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
		
		JButton btnCreateCommunity = new JButton("Create Community");
		btnCreateCommunity.setBounds(102, 5, 173, 23);
		btnCreateCommunity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = new Object[] {};
				JOptionPane jop = new JOptionPane("Please Select a Community type",JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION,null,options, null);
				String[] year={"Mailbox","Forum","ModeratedForum","Twitter","Voting"};
				final JComboBox comboBoxCommunityType = new JComboBox(year);
				jop.add(comboBoxCommunityType);
				JDialog diag = new JDialog();
		        diag.getContentPane().add(jop);
		        diag.pack();
		        diag.setVisible(true);
		        
		        comboBoxCommunityType.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String selected=comboBoxCommunityType.getSelectedItem().toString();

						if(selected.equals("Mailbox"))
						{
							CreateMailboxCommunityInterface gui=new CreateMailboxCommunityInterface(user);
							gui.setVisible(true);
						}
						else if(selected.equals("Forum"))
						{
							
						}
						else if((selected.equals("ModeratedForum")))
						{
							
						}
						else if((selected.equals("Twitter")))
						{
							
						}
						else if((selected.equals("Voting")))
						{
							
						}
						else
						{
							
						}
					}
					
				});
//				CreateCommunity create=new CreateCommunity().
//						create.show()
			}
		});
		panel.setLayout(null);
		panel.add(btnCreateCommunity);
		
		JButton btnShowCommunities = new JButton("Show Communities");
		btnShowCommunities.setBounds(102, 50, 173, 23);
		panel.add(btnShowCommunities);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnMyCommunities = new JButton("My Communities");
		btnMyCommunities.setBounds(134, 5, 135, 40);
		panel_1.add(btnMyCommunities);
		
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