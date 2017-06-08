import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AllConcertMenu extends JFrame {

	private JPanel contentPane;
	private JList<String> list;
	DefaultListModel<String> model = new DefaultListModel<String>();
	FileReader fr_concert, fr_artist, fr_date, fr_price, fr_place, fr_capacity;
	BufferedReader br_concert, br_artist, br_date, br_price, br_place, br_capacity;
	FileReader fr_reserve;
	BufferedReader br_reserve;
	FileWriter fw_reserve;
	BufferedWriter bw_reserve;
	private String str_reserve, str1;
	private int id;
	private JTextField textField;
	private JTextField textField_1;
	
	void Reserve(String str_reserve) {
		int result = 0, line = 0;
		Member m = new Member();	
		str1 = m.getID(id);
		String file = null;
		try {
			String tmp1;
			file = str1 + ".txt";
			
			fr_reserve = new FileReader(file);
			br_reserve = new BufferedReader(fr_reserve);
			
			while ((tmp1 = br_reserve.readLine()) != null) {
				line = 1;
				if (tmp1.equals(str_reserve)) {
					br_reserve.close();
					result = 1;
					break;
				}
			}
			}catch (FileNotFoundException e) {
				System.err.println("not found file");
			}catch (IOException e) {
				System.err.println("No read");
			}
			
			if (result == 0) {
				try {
					fw_reserve = new FileWriter(file, true);
					bw_reserve = new BufferedWriter(fw_reserve);
					if (line == 1) {
						bw_reserve.newLine();
					}
					bw_reserve.write(str_reserve);
					bw_reserve.close();
				}catch (FileNotFoundException e) {
					System.err.println("not found file");
				}catch (IOException e) {
					System.err.println("No read");
				}
			if (result == 1) {
				JOptionPane.showMessageDialog(list, "This consert is reserved", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
				
			}

	}
	
	
	public AllConcertMenu(int id) {
		super("Reserve Concert");
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("All Concert");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 6, 190, 26);
		contentPane.add(lblNewLabel);
		
		String str, str_name, str_artist, str_date, str_price, str_place, str_capacity;
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
	    contentPane.add(p);	
	    JScrollPane sp = new JScrollPane();
	    sp.setBounds(23, 34, 236, 141);
	    contentPane.add(sp);
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(100, 80));
	    
	    JButton btnReserve = new JButton("Reserve");
	    btnReserve.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index != -1) {
					 str_reserve = (String) model.get(index);
					 Reserve(str_reserve);
				} else {
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
	    });
	    btnReserve.setBounds(23, 187, 117, 29);
	    contentPane.add(btnReserve);
	    
	    JButton btnBackpage = new JButton("BackPage");
	    btnBackpage.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    	}
	    });
	    btnBackpage.setBounds(153, 230, 117, 29);
	    contentPane.add(btnBackpage);
	    
	    JButton btnDetail = new JButton("Detail");
	    btnDetail.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index == -1){
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Detail frame2 = new Detail(index, id);
					frame2.setVisible(true);
				}
			}
		});
	    btnDetail.setBounds(166, 187, 91, 29);
	    contentPane.add(btnDetail);
	    
	    textField = new JTextField();
	    textField.setBounds(299, 34, 130, 26);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    JButton btnSearch = new JButton("Search");
	    btnSearch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		FileReader fr_id;
	    		BufferedReader br_id;
	    		String str_name;
	    		int i = 0, j = 0;
	    		String artist = textField.getText();
	    		int a[] = new int[100];
	    		try {
	    			fr_id = new FileReader("artist.txt");
	    			br_id = new BufferedReader(fr_id);
	    			while ((str_name = br_id.readLine()) != null) {
	    				if (str_name.equalsIgnoreCase(artist)) {
	    					a[j] = i;
	    					j++;
	    				}
	    				i++;
	    			}
	    			br_id.close();
	    		}catch (FileNotFoundException e1) {
	    			System.err.println("not found file");
	    		}catch (IOException e1) {
	    			System.err.println("No read");
	    		}
	    		Search frame = new Search(a, j, id);
	    		frame.setVisible(true);
	    		
	    	}
	    });
	    btnSearch.setBounds(299, 70, 104, 29);
	    contentPane.add(btnSearch);
	    
	    JLabel lblArtistSearch = new JLabel("Artist search");
	    lblArtistSearch.setBounds(299, 6, 91, 16);
	    contentPane.add(lblArtistSearch);
	    
	    JButton btnNewButton = new JButton("Search");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		FileReader fr_id;
	    		BufferedReader br_id;
	    		String str_name;
	    		int i = 0, j = 0;
	    		String place = textField_1.getText();
	    		int a[] = new int[100];
	    		try {
	    			fr_id = new FileReader("place.txt");
	    			br_id = new BufferedReader(fr_id);
	    			while ((str_name = br_id.readLine()) != null) {
	    				if (str_name.equalsIgnoreCase(place)) {
	    					a[j] = i;
	    					j++;
	    				}
	    				i++;
	    			}
	    			br_id.close();
	    		}catch (FileNotFoundException e1) {
	    			System.err.println("not found file");
	    		}catch (IOException e1) {
	    			System.err.println("No read");
	    		}
	    		Search frame = new Search(a, j, id);
	    		frame.setVisible(true);
	    		
	    	}
	    });
		btnNewButton.setBounds(299, 167, 104, 29);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(299, 139, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlaceSearch = new JLabel("Place search");
		lblPlaceSearch.setBounds(299, 111, 104, 16);
		contentPane.add(lblPlaceSearch);
	}

}
