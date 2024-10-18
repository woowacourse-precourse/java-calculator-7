package calculator;

import calculator.operator.Adder;
import calculator.operator.Operator;

import java.util.List;

/**
 * - 객체 생성의 책임을 담당
 * - 기본 구분자 지정
 */
public class AppConfig {
    private final static List<String> DEFAULT_DELIMITERS = List.of(":",",");
    private static AppConfig INSTANCE;

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppConfig();
        }
        return INSTANCE;
    }

    public Classifier classifier(String input){
        return new Classifier(input, delimiters(input));
    }

    public Delimiters delimiters(String input){
        return new Delimiters(input, DEFAULT_DELIMITERS);
    }

    public Operator operator(String input){
        return new Adder(classifier(input));
    }

}
