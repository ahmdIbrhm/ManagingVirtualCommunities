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
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	public static String [] globalInterests= {"Football","Basketball","Tennis","VolleyBall"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		final JList<String> list = new JList<String>();
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
		
		JLabel lblAssitant = new JLabel("Assitant: ");
		lblAssitant.setBounds(47, 182, 92, 14);
		contentPane.add(lblAssitant);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VersatileEgocentric", "Copy And Paste", "Other"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(150, 179, 128, 20);
		contentPane.add(comboBox);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				int [] interestsIndexes=list.getSelectedIndices();
				String [] interests=new String [interestsIndexes.length];
				for(int i=0;i<interests.length;i++)
				{
					interests[i]=globalInterests[interestsIndexes[i]];
				}
				User user=new User(name,interests);
				MainClass mainClass=new MainClass(user);
				mainClass.setVisible(true);
			}
		});
		btnSignUp.setBounds(303, 227, 89, 23);
		contentPane.add(btnSignUp);
		
		
	}
}
