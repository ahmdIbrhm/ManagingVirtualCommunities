package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import servers.CommunitiesManager;
import users.User;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class ShowCommunitiesInterface extends JFrame {

	public JPanel contentPane;
	public AbstractButton btnJoinCommunity;
	public JComboBox comboBox;

	public ShowCommunitiesInterface(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(49, 150, 320, 100);
		contentPane.add(textPane);
		
		comboBox = new JComboBox(CommunitiesManager.getUnjoinedCommunities(name).toArray());
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String commmunityId=comboBox.getSelectedItem().toString();
				for(int i=0;i<CommunitiesManager.communities.size();i++)
				{
					if(CommunitiesManager.communities.get(i).getCommunityId().equals(commmunityId))
					{
						textPane.setText(CommunitiesManager.communities.get(i).toString());
					}
				}
			}
		});
		comboBox.setBounds(60, 52, 99, 20);
		contentPane.add(comboBox);
		
		btnJoinCommunity = new JButton("Join");
		btnJoinCommunity.setBounds(280, 51, 89, 23);
		contentPane.add(btnJoinCommunity);
	}
}
