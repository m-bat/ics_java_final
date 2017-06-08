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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@SuppressWarnings("serial")
public class AdministratorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	FileReader fr_password;
	BufferedReader br_password;
	String str;

	public AdministratorLogin() {
		super("Administrator Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseInputAdministrator = new JLabel("Please input Administrator password");
		lblPleaseInputAdministrator.setBounds(98, 46, 250, 16);
		contentPane.add(lblPleaseInputAdministrator);
		
		textField = new JTextField();
		textField.setBounds(98, 81, 250, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = textField.getText();
				try {
					fr_password = new FileReader("Administrator_password.txt");
					br_password = new BufferedReader(fr_password);
					if ((str = br_password.readLine()) != null)
						if (str.equals(password)) {
							Administrator frame = new Administrator();
							frame.setVisible(true);
							Component c = (Component)e.getSource();
				    		Window w = SwingUtilities.getWindowAncestor(c);
				    		w.dispose();
						}
						else {
							textField.setText("");
						}
					br_password.close();
				}catch (FileNotFoundException e1) {
					System.err.println("not found file");
				}catch (IOException e1) {
					System.err.println("No read");
				}
			}
		});
		btnLogin.setBounds(162, 116, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnBackPage = new JButton("Back Page");
		btnBackPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
			}
		});
		btnBackPage.setBounds(162, 157, 117, 29);
		contentPane.add(btnBackPage);
		
		
	}
}
