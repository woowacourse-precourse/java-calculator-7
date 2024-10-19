package calculator;

public class Application {
    public static void main(String[] args) {

        String input = InputOutputManager.inputMessage();
        String delimiters = CustomDelimiter.parseDelimiters(input);
        String parseString = ParsingString.parsingString(input, delimiters);

        Calculator calculator = new Calculator();
        InputOutputManager.outputMessage(calculator.add(parseString, delimiters));
    }
}

// Main 문 리펙토링
// 이스케이프가 필요한 구분자 추가 구현