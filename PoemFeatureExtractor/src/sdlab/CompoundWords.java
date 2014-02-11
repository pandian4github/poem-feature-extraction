package sdlab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompoundWords {
	List<String> cwords;
	int count;
	
	public CompoundWords() throws IOException {
		buildCompoundWords();
	}
	
	void buildCompoundWords() throws IOException {
		
		cwords = new ArrayList<String>();
		
	//	System.out.println("inside buildcom");
		File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\compoundwords.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
		
		while((str = br.readLine()) != null) {
			for(String spl : str.split("\\s+|;\\s*|,\\s*|\\.\\s*")) {
				cwords.add(spl);
				count++;
			}
		}
		br.close();
	}
	
	public static void main(String args[]) {
		
	}

}
