package calculator.model;

import java.util.ArrayList;

public class CalculationModel {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public void parseInput(String input) {
        if(input == null || input.isEmpty()) {
            numbers.add(0);
            return;
        }

        String[] parsedResult = extractCustomSeparator(input);
        String substr = parsedResult[1];
        String regex = parsedResult[0];

        parseNumbers(substr, regex);
    }

    private String[] extractCustomSeparator(String input) {
        //커스텀 구분자라면
        if(input.contains("//")) {
            int customIndexStart = input.indexOf("//") + 2;
            int customIndexEnd = input.indexOf("\\n",customIndexStart);

            if(customIndexEnd == -1){
                throw new IllegalArgumentException("잘못된 입력: '//'로 시작하지만 '\\n'으로 끝나지 않습니다.");
            }
            else if(customIndexEnd == customIndexStart){
                throw new IllegalArgumentException("잘못된 입력: 커스텀 구분자가 존재하지 않습니다.");
            }

            //커스텀구분자 넣기
            char customSeparator = input.charAt(customIndexStart);
            String regex = "[" + customSeparator + ",:]";
            String substr = input.substring(customIndexEnd + 2);
            return new String[] {regex,substr};
        } else {
            return new String[] {"[,:]", input};
        }
    }

    private void parseNumbers(String input, String regex) {
        String[] tokens = input.split(regex);
        for (String token : tokens) {
            if (isInvalidToken(token)) {
                throw new IllegalArgumentException("잘못된 입력: 공백이나 잘못된 값이 포함되어 있습니다.");
            }

            try {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력: 음수가 포함되었습니다.");
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력: 잘못된 구분자 혹은 숫자가 아닌 값이 포함되었습니다.");
            }

        }
    }

    private boolean isInvalidToken(String token) {
        return token == null || token.trim().isEmpty();
    }
}
