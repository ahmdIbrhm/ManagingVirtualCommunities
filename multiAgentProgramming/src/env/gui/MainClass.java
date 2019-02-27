package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.geometry.VPos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
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
	public MainClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel label1 = new JLabel("label");
		label1.setBounds(144, 138, 161, 48);
		contentPane.add(label1);
		
		JButton btnCreateCommunity = new JButton("Create Community");
		btnCreateCommunity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = new Object[] {};
				JOptionPane jop = new JOptionPane("Please Select a Community type",JOptionPane.QUESTION_MESSAGE,JOptionPane.DEFAULT_OPTION,null,options, null);
				String[] year={"Mailbox","Forum","ModeratedForum","Twitter","Voting"};
				final JComboBox comboBoxCommunityType = new JComboBox(year);
				jop.add(comboBoxCommunityType);
				JDialog diag = new JDialog();
		        diag.getContentPane().add(jop);
		        diag.pack();
		        diag.setVisible(true);
		        
		        comboBoxCommunityType.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String selected=comboBoxCommunityType.getSelectedItem().toString();
						label1.setText(selected);
						if(selected.equals("Mailbox"))
						{
							
						}
						else if(selected.equals("Forum"))
						{
							
						}
						else if((selected.equals("ModeratedForum")))
						{
							
						}
						else if((selected.equals("Twitter")))
						{
							
						}
						else if((selected.equals("Voting")))
						{
							VotingGUI vote=new VotingGUI();
							vote.setVisible(true);
							
						}
						else
						{
							
						}
					}
					
				});
//				CreateCommunity create=new CreateCommunity().
//						create.show()
			}
		});
		btnCreateCommunity.setBounds(29, 104, 173, 23);
		contentPane.add(btnCreateCommunity);
		

	}
}
