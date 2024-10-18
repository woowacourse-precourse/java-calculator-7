package calculator.parser;

import calculator.dto.Data;
import java.util.ArrayList;
import java.util.List;

public class ParseManager {

    private final List<DataParser> parsers = new ArrayList<>();

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
            throw new IllegalArgumentException();
        }

        return targetParser.parseData(inputData);
    }
}
