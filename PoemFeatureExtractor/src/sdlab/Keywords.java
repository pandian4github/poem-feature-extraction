package sdlab;

import java.util.ArrayList;
import java.util.List;

public class Keywords {
	
	public List<String> keywords;
	public List<Integer> likeindices;
	public List<Integer> asindices;
	
	public Keywords() {
		keywords = new ArrayList<String>();
		likeindices = new ArrayList<Integer>();
		asindices = new ArrayList<Integer>();
	}
	
	public void extractKeyWords(String poem) {
		//System.out.println(poem);
		String delimiters = "\\s+|;\\s*|,\\s*|\\.\\s*";
		for(String ret : poem.split(delimiters)) {
			keywords.add(ret);
			if(ret.equals("like")) {
				likeindices.add(keywords.size()-1);
			}
			if(ret.equals("as")) {
				asindices.add(keywords.size()-1);
			}
		}
		//for(int index = 0; index < keywords.size(); index++) {
		//	System.out.println(keywords.get(index));
		//}
	}
}
