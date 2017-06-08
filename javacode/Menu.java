import javax.swing.*; 

import java.awt.*;
import java.awt.event.*;

public class Menu {
  private JLabel label;

  class ButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	Sign_up frame2 = new Sign_up();
		frame2.setVisible(true);
    }
  }
  class ButtonAction1 implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	Login frame1 = new Login();
			frame1.setVisible(true);
	    }
	  }
  class ButtonAction2 implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	AdministratorLogin frame3 = new AdministratorLogin();
			frame3.setVisible(true);
	    }
	  }	
  

  public Component createComponents() {
    label = new JLabel("let's creat new account");
    JButton button = new JButton("Sign up");
    JButton button1= new JButton("login");
    JButton button2=new JButton("Administrator");
    
    ButtonAction buttonListener = new ButtonAction();
    ButtonAction1 buttonListener1 = new ButtonAction1();
    ButtonAction2 buttonListener2 = new ButtonAction2();
    
    button.addActionListener( buttonListener );
    button1.addActionListener( buttonListener1 );
    button2.addActionListener( buttonListener2 );

    JPanel pane = new JPanel();
    pane.setBorder(BorderFactory.createEmptyBorder( 30, 30, 10, 30 ));
    pane.setLayout(new GridLayout(0, 2));
    pane.add(button2);
    pane.add(button1);
    pane.add(button);
    pane.add(label);

    return pane;
  }
}
