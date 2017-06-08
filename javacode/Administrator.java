import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class Administrator extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	DefaultListModel<String> model = new DefaultListModel<String>();
	FileReader fr_id, fr_name, fr_concert;
	BufferedReader br_id, br_name, br_concert;

	public Administrator() {
		super("Administrator Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String str_id, str_name, str;
		try {
			fr_id = new FileReader("id.txt");
			br_id = new BufferedReader(fr_id);
			fr_name = new FileReader("name.txt");
			br_name = new BufferedReader(fr_name);
			while ((str_id = br_id.readLine()) != null) {
				str_name = br_name.readLine();
				str = str_id + " " + str_name;
				model.addElement(str);
			}
			br_id.close();
			br_name.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		
		 list = new JList<String>(model);
		 JPanel p = new JPanel();
		 p.setBounds(250, 210, -12, -111);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 list.setBounds( 100, 100, 100, 100);
		 contentPane.setLayout(null);
		 contentPane.add(p);	
		 JScrollPane sp = new JScrollPane();
		 sp.setBounds(6, 78, 272, 125);
		 contentPane.add(sp);
		 sp.getViewport().setView(list);
		 sp.setPreferredSize(new Dimension(100, 80));
		 
		 JLabel lblWelcomeAdministratorPage = new JLabel("Welcome Administrator Page");
		 lblWelcomeAdministratorPage.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		 lblWelcomeAdministratorPage.setBounds(6, 6, 252, 19);
		 contentPane.add(lblWelcomeAdministratorPage);
		 
		 JButton btnBackPage = new JButton("Quit");
		 btnBackPage.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
		 	}
		 });
		 btnBackPage.setBounds(161, 211, 117, 29);
		 contentPane.add(btnBackPage);
		 
		 JButton btnDetail = new JButton("Detail");
		 btnDetail.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int index = list.getSelectedIndex();
		 		
				if (index == -1){
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int i = 0;
					String str_id = null;
					try {
						fr_id = new FileReader("id.txt");
						br_id = new BufferedReader(fr_id);
						while ((str_id = br_id.readLine()) != null) {
							if (i == index) {
								break;
							}
							i++;
						}
						br_id.close();
					}catch (FileNotFoundException e1) {
						System.err.println("not found file");
					}catch (IOException e1) {
						System.err.println("No read");
					}
					
					DetailMember frame = new DetailMember(str_id);
					frame.setVisible(true);
				}
		 	}
		 });
		 btnDetail.setBounds(6, 210, 117, 29);
		 contentPane.add(btnDetail);
		 
		 JLabel lblAllMember = new JLabel("All Member");
		 lblAllMember.setBounds(6, 50, 80, 16);
		 contentPane.add(lblAllMember);
		 
		 JLabel lblConsertEdit = new JLabel("Consert Edit");
		 lblConsertEdit.setBounds(315, 50, 86, 16);
		 contentPane.add(lblConsertEdit);
		 
		 JButton btnMenuPage = new JButton("Menu Page");
		 btnMenuPage.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ConcertMenu frame1 = new ConcertMenu();
		 		frame1.setVisible(true);		
		 	}
		 });
		 btnMenuPage.setBounds(306, 78, 117, 29);
		 contentPane.add(btnMenuPage);
		 
		 JButton btnUpdate = new JButton("Update");
		 btnUpdate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 Component c = (Component)e.getSource();
				 Window w = SwingUtilities.getWindowAncestor(c);
				 w.dispose();
				 Administrator frame1 = new Administrator();
				 frame1.setVisible(true);
		 	}
		 });
		 btnUpdate.setBounds(198, 45, 80, 29);
		 contentPane.add(btnUpdate);
	}

}
