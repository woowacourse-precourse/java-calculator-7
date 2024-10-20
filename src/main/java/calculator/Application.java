package calculator;

import calculator.io.reader.Input;
import calculator.io.reader.util.SeparatorExtractor;
import calculator.io.writer.Output;
import calculator.io.writer.SystemOut;
import calculator.io.reader.ReadConsoleLine;
import calculator.operation.Calculator;
import calculator.operation.basic.Sum;

import java.util.List;

public class Application {

    private final Calculator calculator;
    private final Input input;
    private final SeparatorExtractor separatorExtractor;
    private final Output output;

    public Application(Calculator calculator, Input input, SeparatorExtractor separatorExtractor, Output output) {
        this.calculator = calculator;
        this.input = input;
        this.separatorExtractor = separatorExtractor;
        this.output = output;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 의존성 주입을 통해 인스턴스를 생성
        Calculator calculator = new Sum();
        Input input = new ReadConsoleLine();
        Output output = new SystemOut();
        SeparatorExtractor separatorExtractor = new SeparatorExtractor();
        Application app = new Application(calculator, input, separatorExtractor, output); // Application 객체 생성

        // Application 인스턴스를 통해 메서드 호출
        app.run();
    }

    public void run() {
        String inputString = input.inputString();
        String numberPart = input.validateInput(inputString);
        List<String> separators = separatorExtractor.extractSeparator(inputString);
        List<String> numbers = calculator.extractNumber(numberPart, separators);
        Integer totalSum = calculator.calculate(numbers);
        output.outputString(totalSum);
    }
}