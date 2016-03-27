import java.util.*;
import java.io.*;

public class Program4 {
	public static void main(String[] args) {
		SpellChecker checker = new SpellChecker();
		Scanner keyScan = new Scanner(System.in);
		
		keyScan.next();
		System.out.print("Enter name of dictionary file: ");
		String fileName = keyScan.next();
		
		try{	
			File dictionary = new File(fileName);

			if(checker.setDictionary(dictionary)) {
				System.out.println("Dictionary was set properly");
			} else {
				System.out.println("Dictionary wasn't set properly");
			}

			System.out.print("Enter name of file to be read: ");
			String readName = keyScan.next();
			File words = new File(readName);
			
			String line;
			FileReader read = new FileReader(words);
			BufferedReader buff = new BufferedReader(read);
			String content = new String();
			while((line = buff.readLine()) != null) {
				if(!checker.checkSpelling(line)) {
					content = content + line + "\n";
				}
			}
			System.out.print("Enter name of file to output to: ");
			String outName = keyScan.next();

			File out = new File(outName);
			if(!out.exists()) {
				out.createNewFile();
			}
			FileWriter fw = new FileWriter(out.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			
			buff.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		} catch(IOException ex) {
			System.out.println("IO Exception occured.");
		}
		
		keyScan.close();
	}
}
