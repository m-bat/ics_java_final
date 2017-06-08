import java.awt.Component;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;


@SuppressWarnings("serial")
public class Sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	FileWriter fw_reserve;
	BufferedWriter bw_reserve;
	private String str_name, str_password, str_rand;
	private int rand;
	FileReader fr;
	BufferedReader br;
	

	public Sign_up() {
		super("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseInputName = new JLabel("Please Input Your Name");
		lblPleaseInputName.setBounds(47, 36, 182, 16);
		contentPane.add(lblPleaseInputName);
		
		textField = new JTextField();
		textField.setBounds(47, 64, 242, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSetPasswaord = new JLabel("Set Password");
		lblSetPasswaord.setBounds(47, 102, 122, 16);
		contentPane.add(lblSetPasswaord);
		
		textField_1 = new JTextField();
		textField_1.setBounds(47, 130, 216, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str;
				int result = 0;
				try {
					str_name = textField.getText();
					fr = new FileReader("name.txt");
					br = new BufferedReader(fr);
					
					str = br.readLine();
					if (str == null) {
						result = 1;
					}
					br.close();
					fw_reserve = new FileWriter("name.txt", true);
					bw_reserve = new BufferedWriter(fw_reserve);
					if (result == 0 ) {
						bw_reserve.newLine();
					}
					bw_reserve.write(str_name);
					
					bw_reserve.close();
				}catch (FileNotFoundException e1) {
					System.err.println("not found file");
				}catch (IOException e1) {
					System.err.println("No write");
				}
				
				try {
					str_password = textField_1.getText();
					fr = new FileReader("password.txt");
					br = new BufferedReader(fr);
					
					str = br.readLine();
					if (str == null) {
						result = 1;
					}
					br.close();
					fw_reserve = new FileWriter("password.txt", true);
					bw_reserve = new BufferedWriter(fw_reserve);
					
					if (result == 0) {
						bw_reserve.newLine();
					}
					bw_reserve.write(str_password);
					
					bw_reserve.close();
				}catch (FileNotFoundException e1) {
					System.err.println("not found file");
				}catch (IOException e1) {
					System.err.println("No write");
				}
				
				rand = (int)(Math.random()*9999);
				str_rand = String.valueOf(rand);
				
				try {
				fr = new FileReader("id.txt");
				br = new BufferedReader(fr);
				
				while ((str = br.readLine()) != null) {
					if (str.equals(str_rand)) {
						br.close();
						rand = (int)(Math.random()*9999);
						str_rand = String.valueOf(rand);
						fr = new FileReader("id.txt");
						br = new BufferedReader(fr);				
					}
					
				}
				br.close();
				}catch (FileNotFoundException e1) {
					System.err.println("not found file");
				}catch (IOException e1) {
					System.err.println("No write");
				}
				
				try {
					str_password = textField_1.getText();

					fr = new FileReader("id.txt");
					br = new BufferedReader(fr);
					
					str = br.readLine();
					if (str == null) {
						result = 1;
					}
					br.close();
					fw_reserve = new FileWriter("id.txt", true);
					bw_reserve = new BufferedWriter(fw_reserve);
					if (result == 0) {
						bw_reserve.newLine();
					}
					bw_reserve.write(str_rand);
					
					bw_reserve.close();
				}catch (FileNotFoundException e1) {
					System.err.println("not found file");
				}catch (IOException e1) {
					System.err.println("No write");
				}
				
				File newfile = new File(str_rand + ".txt");
				try {
					newfile.createNewFile();
				}catch(IOException e1) {
					System.out.println(e1);
				}
				Completion frame = new Completion(str_rand);
				frame.setVisible(true);
				Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
			}
		});
		btnCreateAccount.setBounds(47, 186, 171, 29);
		contentPane.add(btnCreateAccount);
		
		JButton btnNewButton = new JButton("Back Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
			}
		});
		btnNewButton.setBounds(47, 220, 117, 29);
		contentPane.add(btnNewButton);
	}
}
