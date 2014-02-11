package sdlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Adverbs {

	List<String> adverbs;
	int count;
	
	public Adverbs() throws IOException {
		buildadverbs();
	}
	
	void buildadverbs() throws IOException {
		adverbs = new ArrayList<String>();

		File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\adverbs.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
		
		while((str = br.readLine()) != null) {
			for(String spl : str.split("\\s+|;\\s*|,\\s*|\\.\\s*")) {
				adverbs.add(spl);
				count++;
			}
			
		}
		br.close();
	}
	
	public static void main(String args[]) {
		
	}
}
