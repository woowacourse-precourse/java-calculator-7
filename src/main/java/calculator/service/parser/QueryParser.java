package calculator.service.parser;

import calculator.dto.Query;
import calculator.service.HeaderUtils;

public class QueryParser implements Parser<String, Query> {
    @Override
    public Query parser(String input) throws IllegalArgumentException {
        String[] transformed = input.transform(this::splitByNewLine);
        return new Query(transformed[0], transformed[1]);
    }

    private String[] splitByNewLine(String input) {
        String[] result = new String[2];

        if (HeaderUtils.hasCustomDelimiter(input)) {
            String header = HeaderUtils.extractHeader(input);
            result[0] = header;
            result[1] = input.substring(header.length());
            return result;
        }

        result[1] = input;
        return result;
    }
}
