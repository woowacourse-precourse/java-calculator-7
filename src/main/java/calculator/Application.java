package calculator;

import calculator.dto.CSFResult;
import calculator.function.Calculator;
import calculator.function.Checker;
import calculator.function.CustomSeparatorFinder;
import calculator.function.Parser;

import java.util.List;
import java.util.Optional;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = readLine();

        String separator = ",:";
        CustomSeparatorFinder customSeparatorFinder = new CustomSeparatorFinder(s);
        CSFResult csfResult = customSeparatorFinder.execute();
        separator += csfResult.getCustomSeparator().map(String::valueOf).orElse("");
        s = csfResult.getResult();

        Parser parser = new Parser(s, separator);
        List<String> integerList = parser.execute();

        Checker checker = new Checker(integerList, separator);
        checker.execute();


        String result = new Calculator(integerList).execute();
        System.out.println("결과 : " + result);
    }
}
