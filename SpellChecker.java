import java.util.*;
import java.io.*;

public class SpellChecker{
	private BagInterface<String> correctWords;

	public SpellChecker() {
		correctWords = new DoublyLinkedBag();
	}

	public boolean setDictionary(File correctWordFile) {
		boolean done = true;
		try{
			FileReader read = new FileReader(correctWordFile);
			BufferedReader buff = new BufferedReader(read);
			String line;
			while((line = buff.readLine()) != null) {
				correctWords.add(line);
			}
			buff.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found for setDictionary");
		} catch(IOException ex) {
			System.out.println("Error resulted in IO Exception in setDictionary");
		}
		
		return done;
	}
	
	public boolean checkSpelling(String word) {
		return correctWords.contains(word);
	}
	
	public int count() {
		return correctWords.getCurrentSize();
	}
}
