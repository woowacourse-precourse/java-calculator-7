package calculator.service;

import calculator.domain.Delimiter;

public class DelimiterService {

    private static final DelimiterService instance = new DelimiterService();

    public static DelimiterService getInstance() {
        return instance;
    }

    public void addCustomDelimiter(String customDelimiter, Delimiter delimiter) {
        delimiter.add(customDelimiter);
    }
}
