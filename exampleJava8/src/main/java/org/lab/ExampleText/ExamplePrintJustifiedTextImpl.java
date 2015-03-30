package org.lab.ExampleText;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.lab.service.Predicates;
import org.springframework.stereotype.Service;

@Service
public class ExamplePrintJustifiedTextImpl extends Predicates implements ExamplePrintJustifiedText {

	private LinkedHashMap<Integer, List<String>> generateMap(String phrase, int sizeLine) {
		String[] charArray = phrase.split(" ");
		int sumCharInLine = 0;
		LinkedHashMap<Integer, List<String>> listLines = new LinkedHashMap<Integer, List<String>>();

		int numLine = 1;
		boolean changeLine = true;
		for (int i = 0; i < charArray.length; i++) {
			List<String> listWordsInLine;
			sumCharInLine += charArray[i].length();
			if (!changeLine) {
				sumCharInLine++;
			}
			if (sumCharInLine <= sizeLine) {
				changeLine = (sumCharInLine == sizeLine) ? true : false;
				if (listLines.get(numLine) == null) {
					listWordsInLine = new LinkedList<String>();
				} else {
					listWordsInLine = listLines.get(numLine);
				}
				listWordsInLine.add(charArray[i]);
				listLines.put(numLine, listWordsInLine);
			} else {
				changeLine = true;
				numLine++;
				sumCharInLine = charArray[i].length() + 1;
				listWordsInLine = new LinkedList<String>();
				listWordsInLine.add(charArray[i]);
				listLines.put(numLine, listWordsInLine);
			}
		}
		return listLines;
	}

	public void printJustifiedText(String phrase, int sizeLine) {

		LinkedHashMap<Integer, List<String>> listLines = this.generateMap(phrase, sizeLine);

		int numLine = 0;
		for (List<String> listWordsInLine : listLines.values()) {
			numLine++;
			int sumChar = listWordsInLine.stream().mapToInt(word -> word.length()).sum();
			int diferenceChar = sizeLine - sumChar;
			int numSpaces = (listWordsInLine.size() - 1);
			int sizeSpace = 1;
			int modSpaces = 0;
			if (numSpaces != 0) {
				sizeSpace = diferenceChar / numSpaces;
				modSpaces = diferenceChar % numSpaces;
			}
			for (String word : listWordsInLine) {
				System.out.print(word);
				if (numLine != listLines.size()) {
					for (int i = 1; i <= sizeSpace; i++) {
						System.out.print(" ");
					}
					if (modSpaces > 0) {
						System.out.print(" ");
						modSpaces--;
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
