package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import communities.Community;
import communities.Mailbox;
import users.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateMailboxCommunityInterface extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldCommunityId;
	public AbstractButton btnConfirm;
	public final JList<String> list;
	public final JSpinner spinner;
	public final JSlider slider;

	public CreateMailboxCommunityInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaximumNumberOf = new JLabel("Maximum Number of Messages:");
		lblMaximumNumberOf.setBounds(10, 143, 208, 27);
		contentPane.add(lblMaximumNumberOf);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(265, 146, 59, 20);
		spinner.setEditor(new JSpinner.DefaultEditor(spinner));
		contentPane.add(spinner);
		
		JLabel lblTimeAfterEach = new JLabel("Time after each message is deleted: (mins)");
		lblTimeAfterEach.setBounds(10, 181, 208, 33);
		contentPane.add(lblTimeAfterEach);
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(1);
		slider.setBounds(228, 177, 200, 44);
		contentPane.add(slider);
		
		JLabel lblCommunityId = new JLabel("Community Id:");
		lblCommunityId.setBounds(10, 22, 150, 27);
		contentPane.add(lblCommunityId);
		
		textFieldCommunityId = new JTextField();
		textFieldCommunityId.setBounds(228, 25, 144, 20);
		contentPane.add(textFieldCommunityId);
		textFieldCommunityId.setColumns(10);
		
		JLabel lblTopics = new JLabel("Topics: ");
		lblTopics.setBounds(10, 60, 134, 33);
		contentPane.add(lblTopics);
		
		list = new JList<String>();
		list.setModel(new AbstractListModel() {
			String[] values = SignUp.globalInterests;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(228, 67, 142, 54);
		contentPane.add(scrollPane);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(228, 225, 89, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(88, 225, 89, 23);
		contentPane.add(btnCancel);
	}
}
