package calculator;

import calculator.model.DelimiterManagerImpl;

public class Application {
    public static void main(String[] args) {

        DelimiterManagerImpl delimiterManagerImpl = new DelimiterManagerImpl();
        delimiterManagerImpl.init();
    }
}
