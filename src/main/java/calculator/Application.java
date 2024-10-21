package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 기능 0. 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            // 기능 1. 연산자 세트 생성 (만약 //로 시작하고 \n으로 종료되지 않을 경우 에러처리)
            Set<Character> setOperator = generateOperatorSet(input);
            if (setOperator == null) {
                throw new IllegalArgumentException();
            }
            // 기능 2. 문자열 파싱 전처리 : 시작점 잡기
            int startParsingIdx = 0;
            if (input.startsWith("//")) {
                startParsingIdx = input.indexOf("\\n") + 2;
            }
            // 기능 3. 문자열 파싱 (만약 유효하지 않은 연산자가 들어있을 경우 에러처리)
            int totalSum = parsingString(input, setOperator, startParsingIdx);
            if (totalSum == -1) {
                throw new IllegalArgumentException();
            }
            // 기능 4. 결과 출력
            System.out.println("결과 : " + totalSum);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 기능 1: 연산자 세트 생성
    public static Set<Character> generateOperatorSet(String word) {
        Set<Character> setOperator = new HashSet<>();
        setOperator.add(',');
        setOperator.add(':');

        if (word.startsWith("//")) {
            int idxNextLine = word.indexOf("\\n");
            if (idxNextLine == -1) {
                return null;
            }
            for (int i = 2; i < idxNextLine; i++) {
                setOperator.add(word.charAt(i));
            }
        }
        return setOperator;
    }

    // 기능 2: 문자열 파싱
    public static int parsingString(String input, Set<Character> setOperator, int startIdx) {
        int idx = startIdx;
        int curNum = 0;
        int totalSum = 0;

        while (idx < input.length()) {
            char currentChar = input.charAt(idx);

            if (setOperator.contains(currentChar)) {
                totalSum += curNum;
                curNum = 0;
            } else if (Character.isDigit(currentChar)) {
                curNum = curNum * 10 + Character.getNumericValue(currentChar);
            } else {
                return -1; // 에러 발생 시 -1 반환
            }
            idx++;
        }
        // curNum에 값이 남아있을 경우 처리
        if (curNum > 0) {
            totalSum += curNum;
        }
        // 결과 반환
        return totalSum;
    }
}