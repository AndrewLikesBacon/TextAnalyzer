import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class textAnalyzer {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> words = new HashMap<>();
		
		File textFile = new File("C:\\Users\\Andrew\\eclipse-workspace\\Text Analyzer\\src\\poem.txt");
		
		try {
			
			Scanner scan = new Scanner(textFile);
			
			while (scan.hasNext()) {
				String word = scan.next();
				
				//remove non-letters
				for (int i=0; i<word.length(); i++) {
					
					if (word.charAt(i) < 'A' || word.charAt(i) > 'z') {
						word = word.substring(0,i) + word.substring(i+1);
						i--;
					}
					
				}
				
				//make words lower case and puts them in the hash map or adds one to frequency if it is already there
				if (word.length() > 0) {
					
					word = word.toLowerCase();
					
					if (words.containsKey(word)) {
						words.put(word, words.get(word) + 1);
					} else {
						words.put(word, 1);
					}
				}
			}
			
			//sorts the hash map in descending order
			Map<String, Integer> descendingWords = words.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),(entry1, entry2) -> entry2, LinkedHashMap::new));
			
			System.out.println(descendingWords);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}
}
