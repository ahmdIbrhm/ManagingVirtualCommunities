package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import communities.Voting;
import users.User;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VotingGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> topics; 
	private ArrayList<String> answers; 
	private Map<String, ArrayList<String>> map;
	private User user;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VotingGUI frame = new VotingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VotingGUI(final User user) {
		this.user=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 269);
		setTitle("Voting community");
		topics=new ArrayList<String>();
		answers=new ArrayList<String>();
		map=new HashMap<String, ArrayList<String>>();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4, 1));
		setContentPane(contentPane);
		String[] Topics={"Quetion1","Quetion2","Quetion3","Quetion4","Quetion5"};
		JLabel nameLab = new JLabel("Name");
		final JTextField name=new JTextField();
		JPanel panName=new JPanel();
		JPanel panExit=new JPanel();
		panName.setLayout(new FlowLayout());
		JLabel topicsLab = new JLabel("Topics");
		final JComboBox comboBox = new JComboBox(Topics);
		JPanel panTopics=new JPanel();
		JPanel panRes=new JPanel();
		panRes.setLayout(new FlowLayout());
		panTopics.setLayout(new FlowLayout());
		panTopics.add(topicsLab);
		panTopics.add(comboBox);
		JLabel responseLab = new JLabel("Response");
		final JTextField response=new JTextField();
		name.setPreferredSize(new Dimension(200, 24));
		response.setPreferredSize(new Dimension(200, 24));
		JButton nextResponse=new JButton();
		nextResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				answers.add(response.getText());
				response.setText("");
			}
		});
		JButton nextQuestion=new JButton("Next Topic");
		nextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topics.add(comboBox.getSelectedItem().toString());
				map.put(comboBox.getSelectedItem().toString(),answers);
				response.setText("");
			}
		});
		JButton save=new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Voting voting= new Voting( name.getText(), user, topics, map);
				System.out.println(voting.toString());
				JOptionPane jop = new JOptionPane("The Community has been added",JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION,null, null);
				JDialog diag = new JDialog();
		        diag.getContentPane().add(jop);
		        diag.pack();
		        diag.setVisible(true);
			}
		});
		JButton back=new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		nextResponse.setText("Next");
		panRes.add(responseLab);
		panRes.add(response);
		panRes.add(nextResponse);
		panName.add(nameLab);
		panName.add(name);
		panExit.add(nextQuestion);
		panExit.add(save);
		panExit.add(back);
		
		contentPane.add(panName);
		contentPane.add(panTopics);
		contentPane.add(panRes);
		contentPane.add(panExit);
		pack();
		
	}

}
