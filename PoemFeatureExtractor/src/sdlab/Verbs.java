package sdlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Verbs {

	List<String> verbs;
	int count;
	
	public Verbs() throws IOException {
		buildVerbs();
	}
	
	void buildVerbs() throws IOException {
		verbs = new ArrayList<String>();

		File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\verbs.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
		
		while((str = br.readLine()) != null) {
			for(String spl : str.split("\\s+|;\\s*|,\\s*|\\.\\s*")) {
				verbs.add(spl);
				count++;
			}
			
		}
		br.close();
	}
	
	public static void main(String args[]) {
		
	}
}
