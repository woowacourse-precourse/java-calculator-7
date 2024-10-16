package calculator.delimiter.handler.impl;

import calculator.delimiter.handler.DelimiterHandler;

import java.util.ArrayList;
import java.util.List;

public class NoDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) {
        return new ArrayList<>();
    }

    @Override
    public boolean isSupport(String str) {
        return true;
    }
}
