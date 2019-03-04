package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import servers.CommunitiesManager;
import utils.Message;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class EnterMailboxInterface extends JFrame {

	public  JPanel contentPane;
	public String communityId;
	public AbstractButton btnSendMessage;
	public JComboBox comboBox;
	public JTextArea textArea;
	public JTextPane textPane;
	public EnterMailboxInterface(String userName,String communityId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox(CommunitiesManager.getCommunity(communityId).getMembers().toArray());
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
		textPane.setText(fromArrayListToString(CommunitiesManager.getMessagesForUserInMailbox(communityId, userName)));
		textPane.setBounds(10, 173, 414, 77);
		contentPane.add(textPane);
	}
	public String fromArrayListToString(ArrayList<Message> list)
	{
		String string="";
		for(int i=0;i<list.size();i++)
		{
			Message messageObject=list.get(i);
			String messageString="From: "+messageObject.getUserFrom();
			messageString+="\n Message: "+messageObject.getMessage();
			messageString+="\n--------------------------------------";
			string+=messageString;
		}
		return string;
	}
}
