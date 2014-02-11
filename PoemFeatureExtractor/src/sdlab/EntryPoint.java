package sdlab;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.JTextField;

public class EntryPoint extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Keywords keywords;
	private static Idioms idioms;
	private static CompoundWords compoundWords;
	private static StylicForms stylicForms;
	private static NarrativeWords narrativeWords;
	private static Verbs verbs;
	private static Prepositions prepositions;
	private static Adjectives adjectives;
	private static Adverbs adverbs;
	//private static JTextField textField = new JTextField(15);
	private static JTextArea output = new JTextArea(40, 40);	
	private static JTextArea textArea = new JTextArea(40, 40);	
	//private String outputString = "";
	
	public EntryPoint() throws IOException {
		textArea.setEditable(true);
		output.setEditable(true);
		textArea.setName("Input poem");
		output.setName("Poem features");
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		JScrollPane scrollPane2 = new JScrollPane(output);
		
		//Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        //add(textField, c);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);		
        add(scrollPane2, c);
        
        Button b = new Button("Show features");
        add(b);
        b.addActionListener(this);
//		keywords = new Keywords();
//		idioms = new Idioms();
//		compoundWords = new CompoundWords();
//		stylicForms = new StylicForms();
//		verbs = new Verbs();
	}
	
	private static void extractSimiles() {
		int index, cur, i;
		output.append("-----------------------------------\n");
		output.append("              Similes              \n");
		output.append("-----------------------------------\n");
//		outputString = outputString + "-----------------------------------\n"; 
	//	System.out.println("-----------------------------------");
		//System.out.println("              Similes              ");
//		System.out.println("-----------------------------------");
		String symbol = "", simile = "";
		
		// for like keywords
		for(index = 0; index < keywords.likeindices.size(); index++) {
			cur = keywords.likeindices.get(index);
			for(i = cur + 1; i < keywords.keywords.size(); i++)
			{
				String str = keywords.keywords.get(i);
				if(!isVerb(str) && !isAdjective(str) && !isAdverb(str) && !isArticle(str) && !isPreposition(str))
				{
					simile = str;
					break;
				}
			}
			for(i = cur - 1; i >= 0; i--)
			{
				String str = keywords.keywords.get(i);
				if(!isVerb(str) && !isAdjective(str) && !isAdverb(str) && !isArticle(str) && !isPreposition(str))
				{
					symbol = str;
					break;
				}				
			}
			output.append("symbol : " + symbol + " simile : " + simile + "\n");
			//System.out.println("symbol : " + symbol + " simile : " + simile);
		}
		// for as keywords
		for(index = 0; index < keywords.asindices.size(); index++) {
			cur = keywords.asindices.get(index);
			for(i = cur + 1; i < keywords.keywords.size(); i++)
			{
				String str = keywords.keywords.get(i);
				if(!isVerb(str) && !isAdjective(str) && !isAdverb(str) && !isArticle(str) && !isPreposition(str))
				{
					simile = str;
					break;
				}
			}
			for(i = cur - 1; i >= 0; i--)
			{
				String str = keywords.keywords.get(i);
				if(!isVerb(str) && !isAdjective(str) && !isAdverb(str) && !isArticle(str) && !isPreposition(str))
				{
					symbol = str;
					break;
				}				
			}
			output.append("symbol : " + symbol + " simile : " + simile + "\n");
			//System.out.println("symbol : " + symbol + " simile : " + simile);
		}
		output.append("-----------------------------------\n\n");
		//System.out.println("-----------------------------------");
	
	}
	
	private static boolean isPreposition(String str) {
		int i;
		for(i = 0; i < prepositions.prepositions.size(); i++)
		{
			if(str.equalsIgnoreCase(prepositions.prepositions.get(i)))
				return true;
		}
		return false;
	}

	private static boolean isAdjective(String str) {
		int i;
		for(i = 0; i < adjectives.adjectives.size(); i++)
		{
			if(str.equalsIgnoreCase(adjectives.adjectives.get(i)))
				return true;
		}
		return false;
	}

	private static boolean isAdverb(String str) {
		int i;
		for(i = 0; i < adverbs.adverbs.size(); i++)
		{
			if(str.equalsIgnoreCase(adverbs.adverbs.get(i)))
				return true;
		}
		return false;
	}

	private static boolean isArticle(String str) {
		if(str.equalsIgnoreCase("a") || str.equalsIgnoreCase("an") || str.equalsIgnoreCase("the"))
			return true;
		return false;
	}

	private static boolean isVerb(String str) {
		int i;
		for(i = 0; i < verbs.verbs.size(); i++)
		{
			if(str.equalsIgnoreCase(verbs.verbs.get(i)))
				return true;
		}
		return false;
	}

	private static void extractCompoundWords() {
		int index, index2;
		output.append("-----------------------------------\n");
		output.append("           Compound words :        \n" );
		output.append("-----------------------------------\n");
		for(index = 0; index < keywords.keywords.size(); index++) {
			String cur = keywords.keywords.get(index);
			for(index2 = 0; index2 < compoundWords.cwords.size(); index2++) {
				if(cur.equals(compoundWords.cwords.get(index2)))
					output.append(cur + "\n");
			}
		}
		output.append("-----------------------------------\n\n");
	}
	
	public void extractFeatures() throws IOException {
		String input = textArea.getText();

		InputStream in = new ByteArrayInputStream(input.getBytes());
		//File file = new File("C:\\Users\\user\\workspace\\PoemFeatureExtractor\\src\\sdlab\\input.txt");
		//FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str;
		String poem = "";
		
		while((str = br.readLine()) != null ) {
			poem = poem + str;
			poem = poem + '\n';
		}
		keywords = new Keywords();
		idioms = new Idioms();
		compoundWords = new CompoundWords();
		stylicForms = new StylicForms();
		narrativeWords = new NarrativeWords();
		verbs = new Verbs();
		adverbs = new Adverbs();
		adjectives = new Adjectives();
		prepositions = new Prepositions();
		
		//System.out.println(poem);
		keywords.extractKeyWords(poem);
		
		extractSimiles();
		//System.out.println();
		extractCompoundWords();
		//System.out.println();
		extractStylicForms();
		System.out.println();
		extractIdioms();
		System.out.println();
		findPoemType();
		System.out.println();
		//System.out.println(poem);
		br.close();
		
	}
	
	public static void main(String args[]) throws IOException {
		System.setProperty("wordnet.database.dir", "C:\\Program Files (x86)\\WordNet\\2.1\\dict");
		
/*		WordNetDatabase database = WordNetDatabase.getFileInstance(); 
		Synset synsets[] = database.getSynsets("working");
		int i = 0;
		SynsetType type = synsets[i].getType();
		//System.out.println("type : " + SynsetType.NOUN);
		
		if (type.equals(SynsetType.NOUN)) {
		//	System.out.println("NOUN");
		} else if (type.equals(SynsetType.VERB)) {
			//System.out.println("VERB");
		} else {
		}		
*/
		JFrame frame = new JFrame("Poem feature extraction");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		frame.add(new EntryPoint());
		
	}

	private static boolean isInvalid() {
		int index;
		for(index = 0; index < keywords.keywords.size(); index++)
		{
			String str = keywords.keywords.get(index);
			if(isVerb(str) || isAdverb(str) || isAdjective(str) || isPreposition(str))
				return false;
		}
		return true;
	}
	
	private static void findPoemType() {
		int index, index2;
		boolean flag = false;
		output.append("-----------------------------------\n");
		for(index = 0; index < keywords.keywords.size(); index++) {
			for(index2 = 0; index2 < narrativeWords.words.size(); index2++) {
				if(keywords.keywords.get(index).equalsIgnoreCase(narrativeWords.words.get(index2))) {
					flag = true;
				}
			}
		}
		if(keywords.keywords.size() == 1 || isInvalid())
			output.append("Poem type : Invalid poem !\n");
		else
			if(flag) {
				output.append("Poem type : Narrative\n");
			}
			else {
				output.append("Poem type : Descriptive\n");
			}
		output.append("-----------------------------------\n");
	}

	private static void checkCombinationIdioms(int size) {
		int index, index2;
		for(index = 0; index < keywords.keywords.size()-size+1; index++) {
			String str = keywords.keywords.get(index);
			for(index2 = index+1; index2 < index + size; index2++) {
				str = str + " " + keywords.keywords.get(index2);
			}
			for(index2 = 0; index2 < idioms.words.size(); index2++) {
				if(str.equalsIgnoreCase(idioms.words.get(index2))) {
					output.append(str + "\n");
				}
			}
		}	
	}
	
	private static void extractIdioms() {
		output.append("-----------------------------------\n");
		output.append("             Idioms                \n");
		output.append("-----------------------------------\n");
		for(int index = 1; index < 10; index++) {
			checkCombinationIdioms(index);
		}		
		output.append("-----------------------------------\n\n");
	}

	private static void checkCombinationStylicForms(int size) {
		int index, index2;
		for(index = 0; index < keywords.keywords.size()-size+1; index++) {
			String str = keywords.keywords.get(index);
			for(index2 = index+1; index2 < index + size; index2++) {
				str = str + " " + keywords.keywords.get(index2);
			}
			for(index2 = 0; index2 < stylicForms.words.size(); index2++) {
				if(str.equalsIgnoreCase(stylicForms.words.get(index2))) {
					output.append(str + "\n");
				}
			}
		}	
	}
	
	private static void extractStylicForms() {
		output.append("-----------------------------------\n");
		output.append("           Stylic forms            \n");
		output.append("-----------------------------------\n");
		for(int index = 1; index < 10; index++) {
			checkCombinationStylicForms(index);
		}
		output.append("-----------------------------------\n\n");		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			output.setText("");
			extractFeatures();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}