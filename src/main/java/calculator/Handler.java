package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Handler {

    public List<Integer> inputHandler(String input) {
        List<String> split;
        if (indicateCustom(input)) {
            String custom = makeCustomSeparator(input);
            split = splitter(input, custom);
        } else {
            split = splitter(input);
        }
        validInput(split);
        return transToInt(split);
    }

    public int sumCalculator(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private boolean indicateCustom(String input) {
        if (input.contains("//") || input.contains("\n")) {
            return true;
        } else {
            return false;
        }
    }

    private String makeCustomSeparator(String input) throws IllegalArgumentException {
        String custom = input.substring(2, input.indexOf("\\"));
        if (custom.equals("")) {
            throw new IllegalArgumentException("커스텀 구분자 선언이 잘못되었습니다.");
        }
        return custom;
    }

    private List<String> splitter(String input) {
        StringTokenizer st = new StringTokenizer(input, ",|:");
        List<String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }

        return result;
    }

    private List<String> splitter(String input, String custom) {
        String message = input.substring(input.indexOf("n") + 1, input.length());
        StringTokenizer st = new StringTokenizer(message, ",:" + custom);
        List<String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }
자
    private void validInput(List<String> split) throws IllegalArgumentException {
        try {
            for (int i = 0; i < split.size(); i++) {
                int argument = Integer.parseInt(split.get(i));
                if (argument <= 0) {
                    throw new NumberFormatException("입력 숫자는 양수이어야 합니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    private List<Integer> transToInt(List<String> split) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < split.size(); i++) {
            result.add(Integer.parseInt(split.get(i)));
        }
        return result;
    }
}
