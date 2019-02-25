package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(75, 32, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(150, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Interests: ");
		lblNewLabel.setBounds(75, 71, 64, 14);
		contentPane.add(lblNewLabel);
		
		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Football", "Basketball", "Tennis", "Volleyball"};
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
		lblAssitant.setBounds(75, 182, 46, 14);
		contentPane.add(lblAssitant);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VersatileEgocentric", "Copy And Paste", "Other"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(150, 179, 128, 20);
		contentPane.add(comboBox);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainClass mainClass=new MainClass();
				mainClass.setVisible(true);
			}
		});
		btnSignUp.setBounds(303, 227, 89, 23);
		contentPane.add(btnSignUp);
		
		
	}
}
