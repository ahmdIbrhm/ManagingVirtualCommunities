package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import servers.CommunitiesManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OwnedCommunitiesInterface extends JFrame {

	private JPanel contentPane;
	public JComboBox comboBox;
	public AbstractButton btnDelete;
	private JButton btnClose;
	
	public OwnedCommunitiesInterface(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox((CommunitiesManager.getOwnedCommunities(name)).toArray());
		comboBox.setBounds(32, 55, 110, 20);
		contentPane.add(comboBox);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(216, 54, 134, 23);
		contentPane.add(btnDelete);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(216, 103, 134, 23);
		contentPane.add(btnClose);
		
	}

}
