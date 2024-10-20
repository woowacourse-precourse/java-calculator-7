package calculator.caulculatorApplication.domain.parser;

import calculator.caulculatorApplication.domain.common.PositiveNumbersTest;
import java.util.List;

public interface NumberParserTest {
    PositiveNumbersTest parseNumbers(List<String> numberStrings);

}
