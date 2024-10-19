package calculator;

public class StringCalculator {
	private static final String ORIGINAL_SPLITTER_REGEX = ",|:";
	private static final int SPLITTER_FIND_START_INDEX = 2;

	public static Positive splitAndSum(String input) {
		String[] splitString = splitWithOriginalSplitter(input);
		if (splitString.length > 1) {
			return calculateSum(toInts(splitString));
		}
		return calculateSum(toInts(splitWithCustomSplitter(input)));
	}

	private static String[] splitWithOriginalSplitter(String input) {
		return input.split(ORIGINAL_SPLITTER_REGEX);
	}

	private static String[] splitWithCustomSplitter(String input){
		final int splitterFindEndIndex = input.indexOf("\\n");
		final String customSplitter = input.substring(SPLITTER_FIND_START_INDEX, splitterFindEndIndex);
		final String inputSubString = input.substring(splitterFindEndIndex + 2);
		return inputSubString.split(customSplitter);
	}

	private static Positive calculateSum(Positive[] positives) {
		Positive zero = Positive.zero();
		for (Positive positive : positives) {
			zero.add(positive);
		}
		return zero;
	}

	private static Positive[] toInts(String[] splitString) {
		Positive[] positives = new Positive[splitString.length];
		for ( int i = 0; i < splitString.length ; i++) {
			Positive positive = Positive.inputPositive(splitString[i]);
			positives[i] = positive;
		}
		return positives;
	}
}
