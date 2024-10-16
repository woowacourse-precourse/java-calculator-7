package calculator;

import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.factory.DelimiterHandlerFactory;

import java.util.List;

public class Calculator {
    private DelimiterHandlerFactory factory;

    public Calculator(DelimiterHandlerFactory factory) {
        this.factory = factory;
    }

    public Integer sum(String str) {
        DelimiterHandler handler = factory.getHandler(str);

        List<String> split = handler.split(str);
        int ret = 0;
        for (String s : split) {
            if(s.contains("-")) throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
            ret += Integer.parseInt(s);
        }
        return ret;
    }
}
