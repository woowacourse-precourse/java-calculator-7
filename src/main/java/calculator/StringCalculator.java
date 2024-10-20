package calculator;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

	public static Positive input(){
		try {
			String inputString = Console.readLine();
			return splitAndSum(inputString);
		} catch (NoSuchElementException e) {
			return Positive.zero();
		}
	}

	public static Positive splitAndSum(String input) {
		if (input.contains(",") || input.contains("|")) {
			String[] splitString = StringSplitter.splitWithOriginalSplitter(input);
			return calculateSum(toInts(splitString));
		}
		String[] splitString = StringSplitter.splitWithCustomSplitter(input);
		return calculateSum(toInts(splitString));
	}

	public static Positive calculateSum(Positive[] positives) {
		Positive zero = Positive.zero();
		for (Positive positive : positives) {
			zero.add(positive);
		}
		return zero;
	}

	public static Positive[] toInts(String[] splitString) {
		Positive[] positives = new Positive[splitString.length];
		for ( int i = 0; i < splitString.length ; i++) {
			Positive positive = Positive.inputPositive(splitString[i]);
			positives[i] = positive;
		}
		return positives;
	}
}
