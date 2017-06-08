import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AllDataCall {
	private String str, str_name, str_price, str_date, str_artist, str_capacity, str_place;
	FileReader fr_name, fr_id;
	BufferedReader br_name, br_id;
	int i = 0;
	AllDataCall(int index) {
		try {
			fr_id = new FileReader("concert_name.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_name = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		try {
			i = 0;
			fr_id = new FileReader("artist.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_artist = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		try {
			i = 0;
			fr_id = new FileReader("date.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_date = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		try {
			i = 0;
			fr_id = new FileReader("price.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_price = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		try {
			i = 0;
			fr_id = new FileReader("place.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_place = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		try {
			i = 0;
			fr_id = new FileReader("capacity.txt");
			br_id = new BufferedReader(fr_id);
			while ((str_capacity = br_id.readLine()) != null) {
				if (i == index)
					break;
				i++;
			}
			br_id.close();
		}catch (FileNotFoundException e) {
			System.err.println("not found file");
		}catch (IOException e) {
			System.err.println("No read");
		}
		
		str = str_name + " " + str_artist + " " + str_date + " " + str_place + " " + str_price + " " + str_capacity;
	}
	
	String call() {
		return this.str;
	}

}
