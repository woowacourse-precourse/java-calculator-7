package calculator;

public class Application {
	public static void main(String[] args) {

		IOController ioController = new IOController();
		Parser parser = new Parser();
		Calculator calculator = new Calculator();

		Executor executor = new Executor(ioController, parser, calculator);

		executor.executeApplication();
	}
}
