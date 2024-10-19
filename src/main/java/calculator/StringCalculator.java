package calculator;

public class StringCalculator {
	private static final String ORIGINAL_SPLITTER_REGEX = ",|:";
	private static final int SPLITTER_FIND_START_INDEX = 2;

	public static int splitAndSum(String input) {
		String[] splitString = splitWithOriginalSplitter(input);
		if (splitString.length > 1) {
			return calculateSum(splitString);
		}
		return calculateSum(splitWithCustomSplitter(input));
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

	private static void validateSplitNumber(final int splitNum){
		if (splitNum <= 0) {
			throw new IllegalArgumentException();
		}
	}

	private static int calculateSum(String[] splitString) {
		int sum = 0;
		for (String s : splitString) {
			final int splitNum = Integer.parseInt(s);
			validateSplitNumber(splitNum);
			sum += splitNum;
		}
		return sum;
	}

	private static Positive[] toInts(String[] splitString) {
		Positive[] positives = new Positive[splitString.length];
		for ( int i = 0; i < splitString.length ; i++) {
			final int splitNum = Integer.parseInt(splitString[i]);
			Positive positive = new Positive(splitNum);
			positives[i] = positive;
		}
		return positives;
	}
}
