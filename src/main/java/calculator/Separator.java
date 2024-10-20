package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    List<Character> params;
    List<Integer> nums;

    public Separator() {
        params = new ArrayList<>();
        params.add(',');
        params.add(':');
        nums = new ArrayList<>();
    }

    public void makeNumsAndParams(String input) {
        checkParams(input);
        List<Integer> extractedNumbers = extractNumbers(input);
        saveNums(extractedNumbers);
    }

    private void checkParams(String input) {
        String processedString = checkNewParam(input);
        //허용된 파라미터로만 이루어졌는지 체크
        for (char ch : processedString.toCharArray()) {
            if (!Character.isDigit(ch)){
                if (!params.contains(ch)){
                    throw new IllegalArgumentException();
                }
            }
        }


    }

    private String checkNewParam(String input) {
        if (input.startsWith("//")){
            addParam(input.charAt(2));
            System.out.println("input = " + input);
            return input.substring(5);
        }
        return input;
    }

    public List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber.append(ch);
            }
            else{
                if (!currentNumber.isEmpty()) {
                    numbers.add(Integer.parseInt(String.valueOf(currentNumber)));
                    currentNumber.setLength(0);
                }
            }
        }

        if (!currentNumber.isEmpty()) {
            numbers.add(Integer.parseInt(String.valueOf(currentNumber)));
        }

        return numbers;
    }
    private void addParam(Character param) {
        params.add(param);
    }

    public List<Integer> getNums() {
        return nums;
    }

    private void saveNums(List<Integer> inputs){
        nums.addAll(inputs);
    }

}
