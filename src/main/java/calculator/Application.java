package calculator;

public class Application {


    public static void main(String[] args) {
		StringController stringController = new StringController();
		Positive positive = stringController.start();
		positive.printResult();
    }
}
