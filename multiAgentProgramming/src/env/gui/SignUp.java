package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import users.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	public JPanel contentPane;
	public static String [] globalInterests= {"Football","Basketball","Tennis","VolleyBall"};
	public static String [] globalAgentTypes={"VersatileEgocentric", "Copy And Paste", "Other"};
	
	public JButton btnSignUp;
	public JTextField textFieldName;
	public final JList<String> list;
	
	public SignUp(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(name);
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(75, 32, 46, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(150, 32, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Interests: ");
		lblNewLabel.setBounds(75, 71, 64, 14);
		contentPane.add(lblNewLabel);
		
		list = new JList<String>();
		list.setModel(new AbstractListModel() {
			String[] values = globalInterests;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBounds(150, 70, 86, 79);
		contentPane.add(list);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(286, 173, 89, 23);
		contentPane.add(btnSignUp);
		
		
	}
}
