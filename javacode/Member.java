import java.io.*;
import java.util.*;

public class Member {
	private ArrayList<String> id = new ArrayList<String>();
	private ArrayList<String> password = new ArrayList<String>();
	FileReader fr_id, fr_password;
	BufferedReader br_id, br_password;
	String str;
	Member(){
		try {
			fr_id = new FileReader("id.txt");
			br_id = new BufferedReader(fr_id);
			while ((str = br_id.readLine()) != null) {
				id.add(str);
			}
			fr_password = new FileReader("password.txt");
			br_password = new BufferedReader(fr_password);
			while ((str = br_password.readLine()) != null) {
				password.add(str);
			}
			br_id.close();
			br_password.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
	}
	
	int Decision(int id, String password) {
		int tmp;
		for (int i = 0 ; i < this.id.size() ; i++){
			tmp = Integer.parseInt(this.id.get(i));
			if (tmp == id) {
				if (password.equals(this.password.get(i)))
					return i;
				else
					return -1;
			}
		}
		return -1;
	}
	
	String getID(int i) {
		return id.get(i);
	}
}

