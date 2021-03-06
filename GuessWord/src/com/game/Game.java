package com.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private String[] wordList = { "book", "pen", "student", "wow", "english", "computer" };
	private String constructedWord = "";
	private String randomWord = "";
	private final static int MAXLIVES = 10;

	public static void main(String[] args) {
		Game game = new Game();
		int lives = MAXLIVES;
		try (Scanner scanner = new Scanner(System.in)) {
			char inputLetter;
			String randomWord = game.getRandomWord();
			while (lives > 0) {
				System.out.println("Guess the word!. You have " + lives + " tries.");
				String constructWord = null;
				inputLetter = scanner.nextLine().charAt(0);

				char[] letterToBeGuessed = game.lettersToBeGuessed(constructWord, randomWord);
				constructWord = game.constructWord(inputLetter);
				if (constructWord.equals(randomWord)) {
					game.printLogs("Congratulations..!");
					game = new Game();
					randomWord = game.getRandomWord();
					lives = MAXLIVES;
				} else {
					boolean contains = false;
					for (char c : letterToBeGuessed) {
						if (c == inputLetter) {
							contains = true;
							break;
						}
					}
					if (!contains) {
						lives--;
					}

				}

			}
			game.printLogs("The Game is over");
		} catch (Exception e) {
			System.out.println("Input error, Please try again");
		}

	}

	public String constructWord(char letter) {
		char[] randomWordArray = randomWord.toCharArray();
		char[] constructedWordArray = constructedWord.toCharArray();
		for (int i = 0; i < randomWordArray.length; i++) {
			char c = randomWordArray[i];
			if (letter == c) {
				constructedWordArray[i] = c;
			}
		}

		constructedWord = String.valueOf(constructedWordArray);
		System.out.println(constructedWord);
		return constructedWord;
	}

	public String getRandomWord() {
		Random rand = new Random();
		int randNum = rand.nextInt(wordList.length);
		randomWord = wordList[randNum];
		for (int i = 0; i < randomWord.length(); i++) {
			constructedWord = constructedWord + "*";
		}
		return randomWord;
	}

	public char[] lettersToBeGuessed(String construct, String actual) {
		char[] charLeft = {};
		if (construct != null) {
			for (int i = 0; i < actual.length(); i++) {
				if (construct.charAt(i) == '*') {
					charLeft[i] = actual.toCharArray()[i];
				}
			}
			return charLeft;
		} else {
			return actual.toCharArray();
		}
	}

	public void printLogs(String message) {
		System.out.println("");
		System.out.println("**********************************");
		System.out.println("  " + message + "  ");
		System.out.println("**********************************");
		System.out.println("");
	}
}
