package calculator;

public class OperatorParser {
    String[] parseOperator(String input){
        input = input.split("//")[1];
        String[] parts = input.split("\\\\n");
        return parts;
    }
}
