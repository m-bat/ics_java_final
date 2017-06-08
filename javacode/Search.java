import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Search extends JFrame {

	private JPanel contentPane;
	String str;
	DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> list;
	private String str_reserve;

	public Search(int a[], int j, int id) {
		super("Search Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		for (int i = 0; i < j; i++) {
			AllDataCall data = new AllDataCall(a[i]);
			str = data.call();
			model.addElement(str);
		}
		list = new JList<String>(model);
	    JPanel p = new JPanel();
	    p.setBounds(250, 210, -12, -111);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    list.setBounds( 100, 100, 100, 100);
	    contentPane.add(p);	
	    p.setLayout(null);
	    JScrollPane sp = new JScrollPane();
	    p.add(sp);
	    sp.setBounds(0, 60, 434, 98);
	    sp.getViewport().setView(list);
	    sp.setPreferredSize(new Dimension(100, 80));
	    
	    JButton btnReserve = new JButton("Reserve");
	    btnReserve.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int index = list.getSelectedIndex();
				if (index != -1) {
					AllConcertMenu a = new AllConcertMenu(id);
					 str_reserve = (String) model.get(index);
					 a.Reserve(str_reserve);
				} else {
					JOptionPane.showMessageDialog(list, "None selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	    btnReserve.setBounds(27, 170, 117, 29);
	    p.add(btnReserve);
	    
	    JButton btnBackPage = new JButton("Back Page");
	    btnBackPage.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Component c = (Component)e.getSource();
	    		Window w = SwingUtilities.getWindowAncestor(c);
	    		w.dispose();
	    	}
	    });
	    btnBackPage.setBounds(305, 170, 117, 29);
	    p.add(btnBackPage);
	    
	}

}
