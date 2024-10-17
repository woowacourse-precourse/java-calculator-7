package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final View view = new View();
        view.printInstruction();

        String inputString = Input.readLine();
        Delimiters delimiters = new Delimiters(List.of(":",","), inputString);
        Classifier classifier = new Classifier(inputString, delimiters);
        Adder adder = new Adder(classifier);

        view.printResult(adder.toString());
    }
}
