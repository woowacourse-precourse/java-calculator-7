package calculator.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler implements InputHandlerImpl {
    @Override
    public List<Long> inputProcessor() {
        //입력
        System.out.println("덧셈할 문자열을 입력해 주세요");
        Scanner sc = new Scanner(System.in);
        InputDto inputDto = new InputDto(sc.next());
        sc.close();

        //구분자 처리
        String convertedInput = convertInput(inputDto.getInput());
        //숫자 처리
        return getNumbers(convertedInput);
    }

    @Override
    public String convertInput(String input) {
        if(!input.startsWith("//")) return input;

        String separator = getSeparator(input);
        return input.substring(separator.length()+4).replace(separator, ",");
    }

    private String getSeparator(String input) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = input.substring(2).split("");

        int idx = 0;
        while(true) {
            if(strArr[idx].equals("\\") && strArr[idx+1].equals("n")) {
                break;
            }
            sb.append(strArr[idx++]);
        }

        return sb.toString();
    }

    @Override
    public List<Long> getNumbers(String input) {

        List<Long> numbers = new ArrayList<>();

        String[] splitInput = input.split("[,;]");
        for(String str : splitInput) {
            if(str.isEmpty()) continue;
            if(!isValidate(str)) throw new IllegalArgumentException("올바르지 않은 입력입니다");
            numbers.add(Long.parseLong(str));
        }

        return numbers;
    }

    private boolean isValidate(String str) {
        String REGEXP_ONLY_NUM = "^[\\d*$]";

        //숫자인지 검사
        if(!str.matches(REGEXP_ONLY_NUM)) return false;

        //Long 범위 검사
        try {
            //음수면 false
            return Long.parseLong(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}