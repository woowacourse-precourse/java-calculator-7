package calculator.parser;

import java.util.List;

public interface DataParser {

    boolean isSupport(String inputData);

    List<Integer> parseData(String inputData);

}
