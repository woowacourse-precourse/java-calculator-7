package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Parser {
    private final HashSet<Character> separators;
    private final List<Integer> nums;

    Parser() {
        separators = new HashSet<>(Arrays.asList(',', ':'));
        nums = new ArrayList<>();
    }

    public void parse(String inputString) {
        char[] inputArray = inputString.toCharArray();
        int index = 0;
        boolean onCalOperating = false;
        while (index < inputArray.length) {
            char curChar = inputArray[index];

            Validator.checkChar(curChar, separators);
            if (Character.isDigit(curChar)) {
                index = parseNumber(curChar, index, inputArray);
                onCalOperating = true;
                continue;
            }

            if (curChar == '/') {
                index = addSeparator(index, inputArray, onCalOperating);
                continue;
            }

            if (separators.contains(curChar)) {
                Validator.checkUsingSeparator(index, inputArray);
                index++;
                continue;
            }
        }
    }

    private int parseNumber(char curChar, int index, char[] inputArray) {
        String numStr = "";
        numStr += curChar;
        index++;
        while (index < inputArray.length && Character.isDigit(inputArray[index])) {
            numStr += inputArray[index];
            index++;
        }
        nums.add(Integer.parseInt(numStr));
        return index;
    }

    public List<Integer> getNums() {
        return nums;
    }

    private int addSeparator(int index, char[] inputArray, boolean onCalOperating) {
        if (onCalOperating) {
            throw new IllegalArgumentException("구분자 추가는 문자열 앞에서 이루어져야한다");
        }

        index++;
        if (inputArray[index] != '/') {
            throw new IllegalArgumentException("'/'다음에는 '/'가 입력되야 한다");
        }

        index++;
        char separator = inputArray[index];
        if (Character.isDigit(separator) || separator == 'n' || separator == '/'
                || separator == '\\') {
            throw new IllegalArgumentException("숫자와 알파벳 n, 문자 '/', 문자 '\\' 는 구분자가 될 수 없다");
        }
        separators.add(separator);

        index++;
        if (inputArray[index] != '\\') {
            throw new IllegalArgumentException("커스텀 구분자 입력 후에는 '\\' 가 입력되어야 한다");
        }
        index++;

        if (inputArray[index] != 'n') {
            throw new IllegalArgumentException("'\\'가 입력된 후에는 'n'이 입력되어야 한다");
        }
        index++;
        return index;
    }

}
