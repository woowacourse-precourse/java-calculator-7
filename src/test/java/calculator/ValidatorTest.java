package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void 구분자_검증_확인() {

        String 구분자 = "//; \n1;2;3\n";

        List<Character> result = List.of(';',' ');

        List<String> inputDataList = splitInputString(구분자);

        if(validDelimiters(구분자)) {

            assertThat(findDelimiters(inputDataList)).isEqualTo(result);
        }
    }

    @Test
    void 입력값_검증() {

        String input = "1,2:3\n";

        List<Character> delimiters = List.of(',', ':');
        List<Integer> expected = List.of(1, 2, 3);

        List<String> inputDataList = splitInputString(input);

        if(validDelimiters(input)) {

            delimiters = findDelimiters(inputDataList);
        }

        List<Integer> result =  findNumbers(inputDataList.get(0), delimiters);
        assertThat(result).isEqualTo(expected);
    }

    private List<Integer> findNumbers(String inputNumberData, List<Character> delimiters) {

        List<String> stringNumberList = new ArrayList<>(List.of(inputNumberData));
        for (Character delimiter : delimiters) {
            stringNumberList = splitNumber(stringNumberList, delimiter);
        }
        return parseIntFromString(stringNumberList);
    }

    private List<Integer> parseIntFromString(List<String> stringNumberList) {

        List<Integer> intNumberList = new ArrayList<>();
        stringNumberList.forEach(i -> {
            intNumberList.add(Integer.parseInt(i));
        });
        return intNumberList;
    }

    private List<String> splitNumber(List<String> inputNumberData, Character delimiters) {

        List<String> stringNumberList = new ArrayList<>();
        inputNumberData.forEach(i -> {
            stringNumberList.addAll(splitString(i, delimiters.toString()));
        });
        return stringNumberList;
    }

    private Boolean validDelimiters(String inputData) {

        return inputData.contains("//");
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

        isNullDelimiters(splitSlash);

        return splitSlash.get(2).chars().mapToObj(c -> (char) c).toList();
    }

    private List<String> splitString(String input, String regex) {

        return Arrays.stream(input.split(regex)).toList();
    }

    private void isNullDelimiters(List<String> splitSlash) {

        if(splitSlash.size() != 4 || splitSlash.get(2).isEmpty()) {

            throw new IllegalStateException("입력이 잘못되었습니다. 다시 입력해주세요.\n");
        }
    }
}