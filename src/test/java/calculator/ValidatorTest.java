package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private CalculatorParamDomain domain;
    private Validator validator;

    @BeforeEach
    void 테스트_전_세팅() {
        this.domain = CalculatorParamDomain.of();
        this.validator = Validator.of();
    }

    @Test
    void 구분자_검증_확인() {
        String 구분자 = "//; \n1;2;3\n";

        List<Character> result = List.of(';',' ');

        List<String> inputDataList = splitInputString(구분자);

        if(validator.validDelimiters(구분자)) {
            domain.changeUserDelimiters(findDelimiters(inputDataList));
            assertThat(domain.getDelimiters()).isEqualTo(result);
        }
    }

    @Test
    void 입력값_검증() {
        String input = "1,2:3\n";

        List<Integer> expected = List.of(1, 2, 3);

        List<String> inputDataList = splitInputString(input);

        if(validator.validDelimiters(input)) {
            domain.changeUserDelimiters(findDelimiters(inputDataList));
        }

        List<Integer> result = findNumbers(inputDataList.get(0), domain.getDelimiters());
        assertThat(result).isEqualTo(expected);
    }

    private List<Integer> findNumbers(String inputNumberData, List<Character> delimiters) {
        List<String> stringNumberList = new ArrayList<>(List.of(inputNumberData));
        for (Character delimiter : delimiters) {
            stringNumberList = splitNumber(stringNumberList, delimiter);
        }
        domain.splitStringNumbers(stringNumberList);
        domain.parseUserNumbers(validator.tryParseInteger(domain.getStringNumbers()));
        return domain.getNumbers();
    }

    private List<String> splitNumber(List<String> inputNumberData, Character delimiters) {
        List<String> stringNumberList = new ArrayList<>();
        inputNumberData.forEach(i -> {
            stringNumberList.addAll(splitString(i, delimiters.toString()));
        });
        return stringNumberList;
    }

    private List<String> splitInputString(String inputData) {
        List<String> splitEnter = splitString(inputData, "\n");
        List<String> splitSlash = new ArrayList<>();

        splitEnter.forEach(o -> {
            splitSlash.addAll(splitString(o, "/"));
        });
        return splitSlash;
    }

    private List<Character> findDelimiters(List<String> splitSlash) {
        validator.isNullDelimiters(splitSlash);

        return splitSlash.get(2).chars().mapToObj(c -> (char) c).toList();
    }

    private List<String> splitString(String input, String regex) {
        return Arrays.stream(input.split(regex)).toList();
    }
}