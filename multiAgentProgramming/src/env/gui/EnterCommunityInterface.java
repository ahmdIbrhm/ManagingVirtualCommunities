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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnterCommunityInterface extends JFrame {

	private JPanel contentPane;
	AbstractButton btnEnter;
	JComboBox comboBox;
	private JButton btnClose;
	public AbstractButton btnLeave;
	public EnterCommunityInterface(String name) {
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox(CommunitiesManager.getUserCommunities(name).toArray());
		comboBox.setBounds(66, 61, 99, 20);
		contentPane.add(comboBox);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(264, 42, 89, 23);
		contentPane.add(btnEnter);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 148, 287, 102);
		contentPane.add(textPane);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(335, 227, 89, 23);
		contentPane.add(btnClose);
		
		btnLeave = new JButton("Leave");
		btnLeave.setBounds(264, 76, 89, 23);
		contentPane.add(btnLeave);
	}

}
