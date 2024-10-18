package calculator;

public class StringCalculator {
	public static int splitAndSum(String[] splitString){
		if (splitString.length >= 1) {
			return calculateSum(splitString);
		}
		return 0;
	}

	private static int calculateSum(String[] splitString){
		int sum = 0;
		for (String s : splitString) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}
