package calculator;

import calculator.domain.Delimiter;
import calculator.service.DelimiterService;
import calculator.util.StringUtil;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        DelimiterService delimiterService = DelimiterService.getInstance();
        Delimiter delimiter = new Delimiter();

        String str = Console.readLine();

        String customDelimiter = StringUtil.extractCustomDelimiter(str);
        if (customDelimiter != null) {
            delimiterService.addCustomDelimiter(customDelimiter, delimiter);
        }

        System.out.println("delimiter.toString() = " + delimiter.toString());
        System.out.println("결과 : " + str);
    }
}
