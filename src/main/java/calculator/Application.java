package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력받은 문자열 한 글자씩 검사해서 그게 숫자나 구분자가 아니거나 구분자가 2개 이상 연속으로 나오면 IllegalArgumentException 던지기 - isValidInput 메서드

        // 1. 커스텀 구분자가 있는 경우
        //    해당 커스텀 구분자를 indexers에 추가
        //    isValidInput 메서드 실행해서 입력받은 문자열이 정상적인지 체크 -> 유효성 검사
        //    문자열이 정상적인 입력이면 입력받은 문자열을 구분자로 구분하여 숫자들의 합산을 출력
        // 2. 커스텀 구분자가 없는 경우
        //    isValidInput 메서드 실행해서 입력받은 문자열이 정상적인지 체크 -> 유효성 검사
        //    문자열이 정상적인 입력이면 입력받은 문자열을 구분자로 구분하여 숫자들의 합산을 출력

        List<Character> indexers = new ArrayList<>(); // 구분자들을 저장할 ArrayList 생성
        indexers.add(','); // 기본 구분자 추가
        indexers.add(':'); // 기본 구분자 추가

        String str = Console.readLine(); // 문자열 입력받기

        // 커스텀 구분자가 있는 경우, 커스텀 구분자를 indexers에 추가하기
        if (str.startsWith("//")) { // 커스텀 구분자 확인
            char customIndexer = str.charAt(2); // 세 번째 문자(커스텀 구분자)를 추출
            indexers.add(customIndexer); // 커스텀 구분자 추가

            // 문자열의 본문을 추출 (커스텀 구분자 이후의 부분)
            str = str.substring(str.indexOf("n") + 1);
        }
        ValidateInput.isValidInput(str, indexers); // 문자열 유효성 검사, 유효하지 않은 문자열이 들어오면 프로그램 종료

        // 입력받은 문자열을 숫자들만 떼어놓기 위한 정규 표현식 생성
        StringBuilder regex = new StringBuilder("["); // 정규 표현식 시작
        for (char index : indexers) {
            regex.append(index); // 구분자를 추가
        }
        regex.append("]"); // 정규 표현식 종료

        int sum = 0;
        for (String token : str.split(regex.toString())) { // 동적으로 생성한 정규 표현식 사용
            if (!token.isEmpty()) { // 빈 문자열인지 확인
                int number = Integer.parseInt(token); // 문자열을 숫자로 변환
                sum += number; // 합계에 더하기
            }
        }

        System.out.println("결과 : " + sum);
    }
}
