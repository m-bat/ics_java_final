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
public class Detail extends JFrame {

	private JPanel contentPane;
	private String str;


	public Detail(int index, int id) {
		super("Concert Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AllDataCall alldata = new AllDataCall(index);
		str = alldata.call();
		
		
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 88, 644, 67);
		contentPane.add(lblNewLabel);
		
		JButton btnBackpage = new JButton("BackPage");
		btnBackpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
			}
		});
		btnBackpage.setBounds(23, 154, 117, 29);
		contentPane.add(btnBackpage);
		
		JLabel lblConcertNameSinger = new JLabel("Concert Name   Artist  Date  Place  Price  Capacity ");
		lblConcertNameSinger.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 13));
		lblConcertNameSinger.setBounds(32, 60, 355, 16);
		contentPane.add(lblConcertNameSinger);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AllConcertMenu a = new AllConcertMenu(id);
				a.Reserve(str);
			}
		});
		btnReserve.setBounds(181, 154, 117, 29);
		contentPane.add(btnReserve);
		
	}

}
