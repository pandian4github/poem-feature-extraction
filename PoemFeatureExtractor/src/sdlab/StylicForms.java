package sdlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StylicForms {
	List<String> words;
	int count;

	public StylicForms() throws IOException {
		buildStylicForms();
	}
	
	private void buildStylicForms() throws IOException {
		words = new ArrayList<String>();

		File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\stylicforms.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
	
		while((str = br.readLine()) != null) {
			words.add(str);
			count++;
		}
		br.close();
	}
}