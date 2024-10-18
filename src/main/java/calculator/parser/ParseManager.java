package calculator.parser;

import calculator.dto.Data;
import java.util.ArrayList;
import java.util.List;

public class ParseManager {

    private final List<DataParser> parsers = new ArrayList<>();
    private static final String NOT_FOUND_DATA_PARSER_ERROR_MESSAGE = "해당 문자열을 처리할 수 있는 파서가 존재하지 않습니다.";

    public ParseManager() {
        this.parsers.add(new DefaultDataParser());
        this.parsers.add(new CustomDataParser());
    }

    public Data parseData(String inputData) {

        DataParser targetParser = null;
        for (DataParser dataParser : parsers) {
            if (dataParser.isSupport(inputData)) {
                targetParser = dataParser;
                break;
            }
        }

        if (targetParser == null) {
            throw new IllegalArgumentException(NOT_FOUND_DATA_PARSER_ERROR_MESSAGE);
        }

        return targetParser.parseData(inputData);
    }
}
