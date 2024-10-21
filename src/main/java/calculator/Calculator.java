package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Calculator {
    private String inputValue;
    private Integer result = 0;
    private String delimiters = ":|,";

    Calculator() {
    }

    public void createInputValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputValue = Console.readLine();
    }

    private String[] splitNums() {
        return this.inputValue.split(delimiters);
    }

    private ArrayList<Integer> toInteger(String[] stringNums) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (String n : stringNums) {
            nums.add(Integer.parseInt(n));
        }

        return nums;
    }
}
