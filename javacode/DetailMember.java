import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class DetailMember extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	DefaultListModel<String> model = new DefaultListModel<String>();
	FileReader fr_id;
	BufferedReader br_id;
	FileWriter fw;
	BufferedWriter bw;
	
	
	
	void Delete(String str_delete) {
		int index = 0, k = 0, j = 0;
		String tmp;
		String str1;
		String[] file = {"id.txt", "name.txt", "password.txt"};
		File f = new File(str_delete + ".txt");
		f.delete();
	    ArrayList<String> list1 = new ArrayList<>();
	    	try {
	    		for (j = 0; j < file.length; j++) {
	    			fr_id = new FileReader(file[j]);
	    			br_id= new BufferedReader(fr_id);
			
	    			while ((str1 = br_id.readLine()) != null)  {
	    				list1.add(str1);
	    				if (j == 0) {
	    					if(str1.equals(str_delete)) {
	    						index = k;
	    					}
	    					k++;
	    				}
	    			}
			
	    			br_id.close();
	    		
	    			
	    	
	    			File newdir = new File(file[j]);
	    			newdir.delete();
	    			File newfile = new File(file[j]);
	    			newfile.createNewFile();
	    			fw = new FileWriter(file[j]);
	    			bw= new BufferedWriter(fw);
			
	    			for (int i = 0 ; i < list1.size() ; i++){
	    				tmp = list1.get(i);
	    				if (i == index)
	    					continue;
	    				bw.write(tmp);
	    				if (i != (list1.size() - 1)) {
	    					if (!((index == (list1.size() - 1)) && i + 1 == index))
	    					bw.newLine();
	    				}
	    			}
	    			bw.close();
	    			list1.clear();
	    			}
	    		}catch (FileNotFoundException e) {
	    			System.err.println("not found file");
	    		}catch (IOException e) {
	    			System.err.println("No write");
	    		}
	    	
	}


	public DetailMember(String str_id) {
		super("Mamber Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

		String str;
		try {
			fr_id = new FileReader(str_id + ".txt");
			br_id = new BufferedReader(fr_id);
			while ((str = br_id.readLine()) != null) {
				model.addElement(str);
			}
			br_id.close();
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
		 contentPane.setLayout(null);
		 contentPane.add(p);	
		 JScrollPane sp = new JScrollPane();
		 sp.setBounds(70, 64, 306, 124);
		 contentPane.add(sp);
		 sp.getViewport().setView(list);
		 sp.setPreferredSize(new Dimension(100, 80));
		 
		 JLabel lblNewLabel = new JLabel(str_id + " : reserved concert");
		 lblNewLabel.setBounds(70, 17, 190, 16);
		 contentPane.add(lblNewLabel);
		 
		 JButton btnBackPage = new JButton("Back Page");
		 btnBackPage.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
		 	}
		 });
		 btnBackPage.setBounds(80, 200, 117, 29);
		 contentPane.add(btnBackPage);
		 
		 JButton btnNewButton = new JButton("Delete");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
					 Delete(str_id);
					 Component c = (Component)e.getSource();
					 Window w = SwingUtilities.getWindowAncestor(c);
					 w.dispose();
		 	}
		 });
		 btnNewButton.setBounds(250, 200, 117, 29);
		 contentPane.add(btnNewButton);
		 
		 JLabel lblConcertNameArtist = new JLabel("Concert Name   Artist  Date  Place  Cpacity  Price");
		 lblConcertNameArtist.setBounds(70, 45, 328, 16);
		 contentPane.add(lblConcertNameArtist);
		 
		 
	}

}
