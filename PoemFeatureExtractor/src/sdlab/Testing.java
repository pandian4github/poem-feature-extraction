package sdlab;

import java.io.*;

public class Testing {
	public static void main(String args[]) throws IOException
	{
		File file = new File("C:\\xampp\\htdocs\\st\\input.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str;
		
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
}
