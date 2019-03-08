package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import servers.CommunitiesManager;
import users.User;
import utils.Message;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterMailboxInterface extends JFrame {

	public  JPanel contentPane;
	public String communityId;
	public AbstractButton btnSendMessage;
	public JComboBox comboBox;
	public JTextArea textArea;
	public JTextPane textPane;
	private JButton btnClose;
	public EnterMailboxInterface(String userName,String communityId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox((removeFromList(CommunitiesManager.getCommunity(communityId).getMembers(),userName)).toArray());
		comboBox.setBounds(72, 21, 91, 20);
		contentPane.add(comboBox);
		
		btnSendMessage = new JButton("Send Message");
		btnSendMessage.setBounds(301, 96, 123, 23);
		contentPane.add(btnSendMessage);
		
		textArea = new JTextArea();
		textArea.setBounds(173, 11, 251, 74);
		contentPane.add(textArea);
		
		JLabel lblReciever = new JLabel("Reciever:");
		lblReciever.setBounds(10, 24, 46, 14);
		contentPane.add(lblReciever);
		
		JLabel lblMyMessages = new JLabel("My Messages:");
		lblMyMessages.setBounds(10, 148, 91, 14);
		contentPane.add(lblMyMessages);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 173, 414, 77);
		contentPane.add(textPane);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(301, 130, 123, 23);
		contentPane.add(btnClose);
	}
	public ArrayList<User> removeFromList(ArrayList<User> list,String name)
	{
		ArrayList<User> listWithoutCurrentUser=new ArrayList<User>();
		for(int i=0;i<list.size();i++)
		{
			if(!list.get(i).getName().equals(name))
			{
				listWithoutCurrentUser.add(list.get(i));
			}
		}
		return listWithoutCurrentUser;
	}
}
