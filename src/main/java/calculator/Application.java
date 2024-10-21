package calculator;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.service.DelimiterService;
import calculator.service.NumberService;
import calculator.util.StringUtil;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        DelimiterService delimiterService = DelimiterService.getInstance();
        NumberService numberService = NumberService.getInstance();
        Delimiter delimiter = new Delimiter();
        Number number = new Number();

        String str = Console.readLine();

        String customDelimiter = StringUtil.extractCustomDelimiter(str);
        if (customDelimiter != null) {
            delimiterService.addCustomDelimiter(customDelimiter, delimiter);
        }

        str = StringUtil.extractString(str);
        numberService.addNumbers(str, delimiter, number);

        System.out.println("delimiter.toString() = " + delimiter.toString());
        number.print();
        System.out.println("결과 : " + str);
    }
}
