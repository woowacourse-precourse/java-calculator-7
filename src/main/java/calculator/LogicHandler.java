package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicHandler {


    public LogicHandler() {
    }

    // 입력받은 문자열 구분하기
    public List<String> splitInputString(String customSplitter, String inputString) {
        StringBuilder sb = new StringBuilder();
        sb.append(customSplitter);
        sb.append("|,|:");

        return new ArrayList<>(Arrays.asList(inputString.split(sb.toString())));
    }

    // 빈 칸이 있다면 0으로 간주하여 제외하기
    public void removeEmpty(List<String> inputString) {
        inputString.removeIf(str -> str == null || str.isEmpty());
    }

    // 정수 이외 다른 문자 (음수, 0, 특수문자) 가 있다면 예외 발생
    public void checkInputString(List<String> inputString) {
        for (String i : inputString) {
            if (!i.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            if (Integer.parseInt(i) <= 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 검사가 끝난 문자열 계산 및 출력
    public void printResult(List<String> inputString) {
        List<Integer> result = new ArrayList<>();
        for (String i : inputString) {
            result.add(Integer.parseInt(i));
        }
        System.out.println("결과 : " + result.stream().mapToInt(Integer::intValue).sum());
    }
}
