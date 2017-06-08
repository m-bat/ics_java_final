import java.awt.Component;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Completion extends JFrame {

	private JPanel contentPane;

	public Completion(String str_id) {
		super("Create Account!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Id is " + str_id);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 16));
		lblNewLabel.setBounds(81, 82, 219, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLetsLogin = new JLabel("Let's Login!");
		lblLetsLogin.setBounds(81, 126, 119, 16);
		contentPane.add(lblLetsLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnLogin.setBounds(69, 154, 117, 29);
		contentPane.add(btnLogin);
		
	}
}
