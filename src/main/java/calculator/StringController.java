package calculator;

import static calculator.StringCalculator.*;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class StringController {

	private String input = null;
	public Positive start() {
		try {
			input = Console.readLine();
		} catch (NoSuchElementException e) {
			return Positive.zero();
		}

		if (input.contains(",") || input.contains("|")) {
			String[] splitString = StringSplitter.splitWithOriginalSplitter(input);
			return StringCalculator.calculateSum(toInts(splitString));
		}

		String[] splitString = StringSplitter.splitWithCustomSplitter(input);
		return calculateSum(toInts(splitString));
	}
}
