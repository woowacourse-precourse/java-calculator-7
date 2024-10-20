package calculator;

public class StringSplitter {

	private static final String ORIGINAL_SPLITTER_REGEX = ",|:";
	private static final int SPLITTER_FIND_START_INDEX = 2;
	
	public static String[] splitWithOriginalSplitter(String input) {
		return input.split(ORIGINAL_SPLITTER_REGEX);
	}

	public static String[] splitWithCustomSplitter(String input){
		final int splitterFindEndIndex = input.indexOf("\\n");
		final String customSplitter = input.substring(SPLITTER_FIND_START_INDEX, splitterFindEndIndex);
		final String inputSubString = input.substring(splitterFindEndIndex + 2);
		return inputSubString.split(customSplitter);
	}
}
