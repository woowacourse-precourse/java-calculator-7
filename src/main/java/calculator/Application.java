package calculator;

public class Application {
    public static void main(String[] args) {
        Input.print();
        String input = Input.input();
        Parser parser = new Parser(input);
        String[] splitInput = parser.split();
        Validate.validate(splitInput);
        Char2Num char2Num = new Char2Num();
        char2Num.convert(splitInput);
        Summation summation = new Summation(char2Num.numbers);
        summation.sum();
        Output.print(summation.sum);
    }
}
