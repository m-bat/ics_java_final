import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MyPage extends JFrame {

	private JPanel contentPane;
	private JList<String> list, list1;
	private ArrayList<String> name = new ArrayList<String>();
	FileReader fr_name, fr_id;
	BufferedReader br_name, br_id;
	FileWriter fw_reserve;
	BufferedWriter bw_reserve;
	private String str, str_delete;
	DefaultListModel<String> model = new DefaultListModel<String>();
	DefaultListModel<String> model1 = new DefaultListModel<String>();
	private int id;
	
	 public DefaultListModel<String> get() {
	    	return model1;
	    }
	
	void Delete(String str_delete) {
		String tmp;
		Member m = new Member();	
		str = m.getID(id);
		String file;
		try {
			file = str + ".txt";
			File newdir = new File(file);
			newdir.delete();
			File newfile = new File(file);
			newfile.createNewFile();
			fw_reserve = new FileWriter(file);
			bw_reserve = new BufferedWriter(fw_reserve);
			
			for (int i = 0 ; i < model.size() ; i++){
			      tmp = (String)model.get(i);
				if (tmp.equals(str_delete))
					continue;
				bw_reserve.write(tmp);
				if (i != model.size() - 1)
					bw_reserve.newLine();
			}
			bw_reserve.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No write");
		}
	}
	
	int getID() {
		return id;
	}
	
	public MyPage() {
	}
	
	public MyPage(int i) {
		super("Mypage");
		id = i;
		try {
			fr_name = new FileReader("name.txt");
			br_name = new BufferedReader(fr_name);
			while ((str = br_name.readLine()) != null) {
				name.add(str);
			}
			br_name.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		contentPane = new JPanel();
		str = name.get(i);
		JLabel lbName = new JLabel("Wellcom!  " + str);
		lbName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lbName.setBounds(18, 19, 270, 20);
		contentPane.add(lbName);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 378);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAllConcertList = new JButton("All Concert List");
		btnAllConcertList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllConcertMenu frame1 = new AllConcertMenu(id);
				frame1.setVisible(true);
			}
		});
		btnAllConcertList.setBounds(9, 47, 141, 29);
		contentPane.add(btnAllConcertList);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index != -1) {
					 str_delete = (String) model.get(index);
					 Delete(str_delete);
					 model.remove(index);
				} else {
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(18, 206, 80, 29);
		contentPane.add(btnDelete);
		

		String str;
		Member m = new Member();	
		str = m.getID(i);
		try {
			fr_id = new FileReader(str + ".txt");
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
	    contentPane.add(p);	
	    JScrollPane sp = new JScrollPane();
	    sp.setBounds(18, 74, 414, 120);
	    contentPane.add(sp);
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(100, 80));
	    
	    String str1;
	    try {
			fr_id = new FileReader("calledoff.txt");
			br_id = new BufferedReader(fr_id);
			while ((str1 = br_id.readLine()) != null) {
				model1.addElement(str1);
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
	    
	    list1 = new JList<String>(model1);
	    JPanel p1 = new JPanel();
	    p.setBounds(20, 100, -12, -11);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    list.setBounds( 10, 10, 100, 100);
	    contentPane.add(p1);	
	    JScrollPane sp1 = new JScrollPane();
	    sp1.setBounds(18, 292, 414, 58);
	    contentPane.add(sp1);
	    sp1.getViewport().setView(list1);
	    sp1.setPreferredSize(new Dimension(200, 80));
	    
	   
	    JButton btnBackpage = new JButton("Quit");
	    btnBackpage.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    	}
	    });
	    btnBackpage.setBounds(111, 206, 117, 29);
	    contentPane.add(btnBackpage);
	    
	    JButton btnUpdate = new JButton("Update");
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    		MyPage frame = new MyPage(id);
				frame.setVisible(true);
	    	}
	    });
	    btnUpdate.setBounds(162, 47, 79, 29);
	    contentPane.add(btnUpdate);
	    
	    JLabel lbInfo = new JLabel("<Information>");
	    lbInfo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
	    lbInfo.setBounds(18, 258, 194, 16);
	    contentPane.add(lbInfo);
	    
	    JLabel lblTheseConcertWas = new JLabel("These concert was called off");
	    lblTheseConcertWas.setBounds(18, 275, 194, 16);
	    contentPane.add(lblTheseConcertWas);
	}
}
