package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String inputValue;
    private Integer result = 0;
    private String delimiters = ":|,";
    private final String REGEX = "//(.*?)\\n(.*)";
    private final String RESULT_MESSAGE = "결과: ";

    Calculator() {
    }

    public void createInputValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputValue = Console.readLine();
    }

    private String[] splitNums() {
        setCustomDelimiter(); // 커스텀 구분자 설정 추가
        return this.inputValue.split(delimiters);
    }

    private ArrayList<Integer> toInteger(String[] stringNums) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (String n : stringNums) {
            nums.add(Integer.parseInt(n));
        }

        return nums;
    }

    private Boolean isEmpty() {
        return this.inputValue.isEmpty();
    }

    private Boolean isCustomDelimiters(String inputValue) {
        return inputValue.startsWith("//");
    }

    private void addCustomDelimiters(String customDm) {
        this.delimiters += "|" +  customDm;
    }

    private String getCustomDelimiters(String inputValue) {
        Pattern pattern = Pattern.compile(REGEX);

        String value = inputValue.replace("\\n", "\n");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            throw new IllegalStateException("BAD REQUEST");
        }

        this.inputValue = matcher.group(2);
        return matcher.group(1);
    }

    private void setCustomDelimiter() {
        if (isCustomDelimiters(this.inputValue)) {
            String customDm = getCustomDelimiters(this.inputValue);
            addCustomDelimiters(customDm);
        }
    }

    private Integer addNums(ArrayList<Integer> nums) {
        for (Integer n : nums) {
            this.result += n;
        }
        return result;
    }

    public String calculate() {
        createInputValue();
        if (isEmpty()) {
            return RESULT_MESSAGE + this.result;
        }
        String[] stringNums = splitNums();
        ArrayList<Integer> nums = toInteger(stringNums);
        this.result = addNums(nums);
        return RESULT_MESSAGE + this.result;
    }
}
