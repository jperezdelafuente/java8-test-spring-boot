package org.lab.ExampleText;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.lab.service.Predicates;
import org.springframework.stereotype.Component;

@Component
public class ExamplePrintJustifiedTextImpl extends Predicates implements ExamplePrintJustifiedText {

	private LinkedHashMap<Integer, List<String>> generateMap(String phrase, int sizeLine) {
		String[] charArray = phrase.split(" ");

		LinkedHashMap<Integer, List<String>> mapLines = new LinkedHashMap<Integer, List<String>>();

		int numLine = 1;
		int sumCharInLine = 0;
		boolean changeLine = true;

		for (int i = 0; i < charArray.length; i++) {
			List<String> listWordsInLine;
			String word = charArray[i];
			sumCharInLine += word.length();
			if (!changeLine) {
				sumCharInLine++;
			}
			if (sumCharInLine <= sizeLine) {
				changeLine = (sumCharInLine == sizeLine) ? true : false;
				if (mapLines.get(numLine) == null) {
					listWordsInLine = new LinkedList<String>();
				} else {
					listWordsInLine = mapLines.get(numLine);
				}
			} else {
				changeLine = true;
				numLine++;
				sumCharInLine = word.length() + 1;
				listWordsInLine = new LinkedList<String>();
			}
			listWordsInLine.add(word);
			mapLines.put(numLine, listWordsInLine);
		}

		return mapLines;
	}

	private void printWhiteSpace(int num) {
		for (int i = 1; i <= num; i++) {
			System.out.print(" ");
		}
	}

	private void printWord(String word) {
		System.out.print(word);
	}

	private void printNewLine() {
		System.out.println("");
	}

	public int printJustifiedText(String phrase, int sizeLine) {

		LinkedHashMap<Integer, List<String>> mapLines = this.generateMap(phrase, sizeLine);

		int numLine = 0;

		for (List<String> listWordsInLine : mapLines.values()) {
			numLine++;
			int sumChar = listWordsInLine.stream().mapToInt(word -> word.length()).sum();
			int differenceChar = sizeLine - sumChar;
			int numWhiteSpaces = (listWordsInLine.size() - 1);
			int sizeWhiteSpace = 1;
			int modWhiteSpaces = 0;
			if (numWhiteSpaces != 0) {
				sizeWhiteSpace = differenceChar / numWhiteSpaces;
				modWhiteSpaces = differenceChar % numWhiteSpaces;
			}
			for (String word : listWordsInLine) {
				this.printWord(word);
				if (numLine != mapLines.size()) {
					printWhiteSpace(sizeWhiteSpace);
					if (modWhiteSpaces > 0) {
						this.printWhiteSpace(1);
						modWhiteSpaces--;
					}
				} else {
					this.printWhiteSpace(1);
				}
			}
			this.printNewLine();
		}

		return mapLines.size();
	}
}
