import java.awt.BorderLayout;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
	    JFrame frame = new JFrame("Top Menu");
	    Menu app = new Menu();
	    Component contents = app.createComponents();
	    frame.getContentPane().add(contents, BorderLayout.CENTER);
	    FileWriter fw;
		BufferedWriter bw;
	    
	    File newfile1 = new File("id.txt");
	    File newfile2 = new File("name.txt");
	    File newfile3 = new File("password.txt");
	    File newfile4 = new File("calledoff.txt");
	    File newfile5 = new File("Administrator_password.txt");
	    File newfile6 = new File("concert_name.txt");
	    File newfile7 = new File("artist.txt");
	    File newfile8 = new File("date.txt");
	    File newfile9 = new File("place.txt");
	    File newfile10 = new File("capacity.txt");
	    File newfile11 = new File("price.txt");
	    
	    try{
	        newfile1.createNewFile();
	        newfile2.createNewFile();
	        newfile3.createNewFile();
	        newfile4.createNewFile();
	        newfile5.createNewFile();
	        newfile6.createNewFile();
	        newfile7.createNewFile();
	        newfile8.createNewFile();
	        newfile9.createNewFile();
	        newfile10.createNewFile();
	        newfile11.createNewFile();
	    }catch(IOException e){
	        System.out.println(e);
	    }
	    
	    try {
			fw = new FileWriter("Administrator_password.txt");
			bw = new BufferedWriter(fw);
			bw.write("administrator");
			bw.close();
			
			
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No write");
		}

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
}
