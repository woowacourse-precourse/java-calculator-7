package calculator;

public class Application {

	public static void main(String[] args) {
		String input = "";
		input = IOManager.getInput();
		IOManager.printOutput(Calculator.calculate(input));
	}
}
