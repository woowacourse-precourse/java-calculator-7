package calculator;

public class StringCalculator {
	private static final String ORIGINAL_SPLITTER_REGEX = ",|:";
	public static int splitAndSum(String input){
		String[] splitString = input.split(ORIGINAL_SPLITTER_REGEX);
		if (splitString.length > 1) {
			return calculateSum(splitString);
		}
		return calculateSum(splitWithCustomSplitter(input));
	}

	private static String[] splitWithCustomSplitter(String input){
		int splitterFindStartIndex = input.indexOf("\\n");
		String customSplitter = input.substring(2, splitterFindStartIndex);
		String inputSubString = input.substring(splitterFindStartIndex + 2);
		return inputSubString.split(customSplitter);
	}

	private static int calculateSum(String[] splitString){
		int sum = 0;
		for (String s : splitString) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}
