package calculator;

public class StringCalculator {

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
