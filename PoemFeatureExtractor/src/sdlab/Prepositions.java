package sdlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Prepositions {

	List<String> prepositions;
	int count;
	
	public Prepositions() throws IOException {
		buildPrepositions();
	}
	
	void buildPrepositions() throws IOException {
		prepositions = new ArrayList<String>();

		File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\prepositions.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
		
		while((str = br.readLine()) != null) {
			//for(String spl : str.split("\\s+|;\\s*|,\\s*|\\.\\s*")) {
				prepositions.add(str);
				count++;
			//}
			
		}
		br.close();
	}
	
	public static void main(String args[]) {
		
	}
}
