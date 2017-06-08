import javax.swing.*;

import java.awt.Component;
import java.awt.Window;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;


@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBackpage;

	public Login() {
		super("Member Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
				String id_str = textField.getText();
				String password = textField_1.getText();
				Member m = new Member();
				int id = Integer.parseInt(id_str);
				if ((i = m.Decision(id, password)) != -1) {
					Component c = (Component)e.getSource();
		    		Window w = SwingUtilities.getWindowAncestor(c);
		    		w.dispose();
					MyPage frame = new MyPage(i);
					frame.setVisible(true);
				}
				else {
					textField.setText("");
					textField_1.setText("");
				}
			}
		});
		btnLogin.setBounds(165, 185, 117, 29);
		contentPane.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(122, 81, 197, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(123, 61, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblPassward = new JLabel("Passward");
		lblPassward.setBounds(122, 119, 61, 16);
		contentPane.add(lblPassward);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 147, 197, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnBackpage = new JButton("BackPage");
		btnBackpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
			}
		});
		btnBackpage.setBounds(165, 224, 117, 29);
		contentPane.add(btnBackpage);
	}
}
