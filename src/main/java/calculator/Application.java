package calculator;

import calculator.Controller.StringProcessorController;
import calculator.Service.CustomDelimiterExtractor;
import calculator.Service.DelimiterExtractor;
import calculator.Service.InputReader;
import calculator.Service.SumCalculator;
import calculator.View.StringCalculatorView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // InputReader 객체 생성
        InputReader inputReader = new InputReader();

        // DelimiterExtractor 객체 생성
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        // CustomDelimiterExtractor 객체 생성
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();

        // SumCalculator 객체 생성
        SumCalculator sumCalculator = new SumCalculator();

        // StringCalculatorView 객체 생성
        StringCalculatorView stringCalculatorView = new StringCalculatorView();

        // StringProcessorController에 의존성 주입
        StringProcessorController stringProcessorController = new StringProcessorController(inputReader,
                delimiterExtractor, customDelimiterExtractor, sumCalculator, stringCalculatorView);

        // 프로세스 시작
        stringProcessorController.process();
    }
}
