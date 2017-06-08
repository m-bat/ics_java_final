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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ConcertMenu extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	DefaultListModel<String> model = new DefaultListModel<String>();
	DefaultListModel<Object> model1 = new DefaultListModel<Object>();
	FileReader fr_concert, fr_artist, fr_date, fr_price, fr_place, fr_capacity, fr_id, fr;
	BufferedReader br_concert, br_artist, br_date, br_price, br_place, br_capacity, br_id, br;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr1;
	BufferedReader br1;
	private JTextField textField_4;
	private JTextField textField_5;
	
	void CalledOff(String str_delete) {
		try {
		fw = new FileWriter("calledoff.txt", true);
		bw= new BufferedWriter(fw);
		bw.write(str_delete);
		bw.newLine();	
		bw.close();
		
		}catch (FileNotFoundException e) {
    		System.err.println("not found file");
    	}catch (IOException e) {
    		System.err.println("No write");
    	}
		finally {
		}
	}
	
	
	void Delete(String str_delete, int index) {
		String tmp;
		String str1;
		String[] file = {"concert_name.txt", "artist.txt", "date.txt", "price.txt", "place.txt", "capacity.txt"};
	    ArrayList<String> list1 = new ArrayList<>();
	    for (int j = 0; j < file.length; j++) {
	    	try {
	    		fr = new FileReader(file[j]);
	    		br= new BufferedReader(fr);
			
	    		while ((str1 = br.readLine()) != null)  {
				list1.add(str1);
	    		}
			
	    		br.close();
	    	
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
	    			if (i != model.size() - 1) {
	    				if (!((index == (list1.size() - 1)) && i + 1 == index))
	    					bw.newLine();			
	    			}
	    		}
	    		bw.close();
	    	}catch (FileNotFoundException e) {
	    		System.err.println("not found file");
	    	}catch (IOException e) {
	    		System.err.println("No write");
	    	}
	    	list1.clear();
	    }
	}


	public ConcertMenu() {
		super("Concert Edit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String str, str_name, str_artist, str_date, str_price, str_capacity, str_place;
		try {
			fr_concert = new FileReader("concert_name.txt");
			br_concert = new BufferedReader(fr_concert);
			fr_artist = new FileReader("artist.txt");
			br_artist = new BufferedReader(fr_artist);
			fr_date = new FileReader("date.txt");
			br_date = new BufferedReader(fr_date);
			fr_price = new FileReader("price.txt");
			br_price = new BufferedReader(fr_price);
			fr_place = new FileReader("place.txt");
			br_place = new BufferedReader(fr_place);
			fr_capacity = new FileReader("capacity.txt");
			br_capacity = new BufferedReader(fr_capacity);
			
			while ((str_name = br_concert.readLine()) != null) {
				str_artist = br_artist.readLine();
				str_date = br_date.readLine();
				str_price = br_price.readLine();
				str_place = br_place.readLine();
				str_capacity = br_capacity.readLine();
				
				str = str_name + " " + str_artist + " " + str_date + " " + str_place + " " + str_price + " " + str_capacity;
				
				model.addElement(str);
			}
			br_concert.close();
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
	    sp.setBounds(6, 45, 258, 153);
	    contentPane.add(sp);
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(100, 80));
	    
	    JLabel lblAllConcert = new JLabel("All Concert");
	    lblAllConcert.setBounds(6, 16, 141, 16);
	    contentPane.add(lblAllConcert);
	    
	    JButton btnDelete = new JButton("Delete");
	    btnDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int index = list.getSelectedIndex();
	    		String str_delete;
				if (index != -1) {
					 str_delete = (String) model.get(index);
					 Delete(str_delete, index);
					 model.remove(index);
					 CalledOff(str_delete);
				} else {
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	    btnDelete.setBounds(0, 210, 117, 29);
	    contentPane.add(btnDelete);
	    
	    JButton btnBackPage = new JButton("Back Page");
	    btnBackPage.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    	}
	    });
	    btnBackPage.setBounds(147, 210, 117, 29);
	    contentPane.add(btnBackPage);
	    
	    JLabel lblAddConcert = new JLabel("<Add Concert>");
	    lblAddConcert.setBounds(291, 6, 127, 16);
	    contentPane.add(lblAddConcert);
	    
	    JLabel lblConcertName = new JLabel("Concert Name");
	    lblConcertName.setBounds(291, 27, 104, 16);
	    contentPane.add(lblConcertName);
	    
	    textField = new JTextField();
	    textField.setBounds(291, 45, 130, 20);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    JLabel lblArtist = new JLabel("Artist");
	    lblArtist.setBounds(291, 69, 61, 16);
	    contentPane.add(lblArtist);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(291, 83, 130, 20);
	    contentPane.add(textField_1);
	    textField_1.setColumns(10);
	    
	    JLabel lblDate = new JLabel("Date");
	    lblDate.setBounds(291, 110, 61, 16);
	    contentPane.add(lblDate);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(291, 130, 130, 20);
	    contentPane.add(textField_2);
	    textField_2.setColumns(10);
	    
	    JLabel lblPrice = new JLabel("Price");
	    lblPrice.setBounds(291, 158, 61, 16);
	    contentPane.add(lblPrice);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(291, 172, 130, 20);
	    contentPane.add(textField_3);
	    textField_3.setColumns(10);
	    
	    JLabel lblPlace = new JLabel("Place");
	    lblPlace.setBounds(291, 197, 61, 16);
	    contentPane.add(lblPlace);
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(291, 210, 130, 20);
	    contentPane.add(textField_4);
	    textField_4.setColumns(10);
	    
	    JLabel lblCapacity = new JLabel("Capacity");
	    lblCapacity.setBounds(291, 242, 61, 16);
	    contentPane.add(lblCapacity);
	    
	    textField_5 = new JTextField();
	    textField_5.setBounds(291, 256, 130, 20);
	    contentPane.add(textField_5);
	    textField_5.setColumns(10);
	    
	    
	    
	    
	    JButton btnAdd = new JButton("Add");
	    btnAdd.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	String str;
			int result = 0;
	    	try {
				fr1 = new FileReader("concert_name.txt");
				br1 = new BufferedReader(fr1);

				if ((str = br1.readLine()) == null) {
					result = 1;
				}

				br1.close();
				
	    		str = textField.getText();
	    		fw = new FileWriter("concert_name.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
				str = textField_1.getText();
	    		fw = new FileWriter("artist.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
				str = textField_2.getText();
	    		fw = new FileWriter("date.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
				str = textField_3.getText();
	    		fw = new FileWriter("price.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
				str = textField_4.getText();
	    		fw = new FileWriter("place.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
				str = textField_5.getText();
	    		fw = new FileWriter("capacity.txt", true);
				bw = new BufferedWriter(fw);
				if (result == 0)
					bw.newLine();
				bw.write(str);
				bw.close();
				
			}catch (FileNotFoundException e1) {
				System.err.println("not found file");
			}catch (IOException e1) {
				System.err.println("No write");
			}

	    		
	    	}
	    });
	    btnAdd.setBounds(351, 294, 75, 29);
	    contentPane.add(btnAdd);
	    
	    JButton btnUpdate = new JButton("Update");
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    		ConcertMenu frame = new ConcertMenu();
				frame.setVisible(true);
	    	}
	    });
	    btnUpdate.setBounds(176, 11, 88, 29);
	    contentPane.add(btnUpdate);
	    
	 
	    
	}

}
