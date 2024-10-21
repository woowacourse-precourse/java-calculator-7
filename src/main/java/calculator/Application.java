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
}

