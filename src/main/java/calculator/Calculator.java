package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.exception.ErrorCode.*;

public class Calculator {
    private String inputValue;
    private Integer result = 0;
    private String delimiters = ":|,";
    private final String REGEX = "//(.*?)\\n(.*)";
    private final String RESULT_MESSAGE = "결과 : ";

    Calculator() {
    }

    public void createInputValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputValue = Console.readLine();

        if (!inputValue.contains(",") && !inputValue.contains(":")
                && !(inputValue.contains("//") && inputValue.contains("\\n"))) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }

        if (!inputValue.matches(".*\\d.*")) {
            throw new IllegalArgumentException(MISSING_NUMBER.getMessage());
        }
    }

    private String[] splitNums() {
        setCustomDelimiter(); // 커스텀 구분자 설정 추가
        return inputValue.split(delimiters);
    }

    private ArrayList<Integer> toInteger(String[] stringNums) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (String n : stringNums) {
            try {
                nums.add(Integer.parseInt(n));
            } catch (Exception e) {
                throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
            }
        }

        return nums;
    }

    private Boolean isEmpty() {
        return inputValue.isEmpty();
    }

    private Boolean isCustomDelimiters(String inputValue) {
        return inputValue.startsWith("//");
    }

    private void addCustomDelimiters(String customDm) {
        delimiters += "|" +  customDm;
    }

    private String getCustomDelimiters(String inputValue) {
        Pattern pattern = Pattern.compile(REGEX);

        String value = inputValue.replace("\\n", "\n");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER.getMessage());
        }

        this.inputValue = matcher.group(2);
        return matcher.group(1);
    }

    private void setCustomDelimiter() {
        if (isCustomDelimiters(inputValue)) {
            String customDm = getCustomDelimiters(inputValue);
            addCustomDelimiters(customDm);
        }
    }

    private Integer addNums(ArrayList<Integer> nums) {
        for (Integer n : nums) {
            if (n <= 0) {
                throw new IllegalArgumentException(NON_POSITIVE_VALUE.getMessage());
            }
            result += n;
        }
        return result;
    }

    public String calculate() {
        createInputValue();
        if (isEmpty()) {
            return RESULT_MESSAGE + result;
        }
        String[] stringNums = splitNums();
        ArrayList<Integer> nums = toInteger(stringNums);
        result = addNums(nums);
        return RESULT_MESSAGE + result;
    }
}
