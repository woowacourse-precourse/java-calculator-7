package calculator.parser;

import calculator.dto.Data;

public interface DataParser {

    boolean isSupport(String inputData);

    Data parseData(String inputData);
}
