package calculator.parser;

import calculator.dto.Data;

public class CustomDataParser implements DataParser {
    @Override
    public boolean isSupport(String inputData) {
        return false;
    }

    @Override
    public Data parseData(String inputData) {
        return null;
    }
}
