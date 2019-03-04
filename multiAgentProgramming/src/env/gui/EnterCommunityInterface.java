package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import servers.CommunitiesManager;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class EnterCommunityInterface extends JFrame {

	private JPanel contentPane;
	AbstractButton btnEnter;
	JComboBox comboBox;
	
	public EnterCommunityInterface(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(CommunitiesManager.getUserCommunities(name).toArray());
		comboBox.setBounds(66, 61, 99, 20);
		contentPane.add(comboBox);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(264, 60, 89, 23);
		contentPane.add(btnEnter);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(66, 148, 287, 102);
		contentPane.add(textPane);
	}

}
