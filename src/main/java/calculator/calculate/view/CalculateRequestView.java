package calculator.calculate.view;

import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.util.CalculateRequestParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculateRequestView {

    private static final String CALCULATE_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    public static CalculateRequestDTO request() {
        System.out.println(CALCULATE_REQUEST_MESSAGE);

        String userInput = Console.readLine();
        Console.close(); // 이곳에서만 사용하고 재사용하지 않는다고 가정하여 사용 후 바로 종료

        List<Integer> parsedNumbers = CalculateRequestParser.parsingRequest(userInput, DEFAULT_DELIMITERS);

        return new CalculateRequestDTO(parsedNumbers);
    }
}
