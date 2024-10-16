package calculator;

public class Application {
    public static void main(String[] args) {
        final View view = new View();
        view.printInstruction();

        String inputString = Input.readLine();
        Classifier classifier = new Classifier(inputString);
        Adder adder = new Adder(classifier);

        view.printResult(adder.toString());
    }
}
