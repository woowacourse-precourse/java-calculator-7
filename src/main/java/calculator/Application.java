package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.init();

    }

    // 문자열 덧셈기 클래스 정의
    public static class StringCalculator{
        // input 문자열을 담을 변수
        String inputString;

        // 추출한 int형 숫자를 담을 숫자 배열
        ArrayList<Integer> extractedNumArr;

        // 구분자를 담을 문자 배열 (구분자가 문자열일 수 있는 경우의 수 고려)
        ArrayList<String> delimiterArr;

        // 생성자
        public StringCalculator(){
            this.delimiterArr = new ArrayList<>();
            this.extractedNumArr = new ArrayList<>();

            // 기본 구분자
            this.delimiterArr.add(":");
            this.delimiterArr.add(",");
        }

        public void init(){
            getInput();
        }

        // 입력
        public void getInput(){
            // 입력 받기

            // 유효성 검사 -> isValidString()

        }

        // 문자열 유효성 검사
        public void isValidString(){

            // 커스텀 구분자 저장

            // slicing

            // 입력 값이 숫자, 구분자를 제외한 문자를 포함하는지

                // 유효하면 숫자 추출 -> extractNumbers()

                // 유효하지 않으면 IllegalArgumentException 발생
                    // try-catch
        }

        // 문자열로부터 구분자 추출
        public void extractDelimiter(){
            // 패턴 객체 생성

            // 객체 필터링 후 Matcher 객체 생성

            // 일치할 경우 추출하여 delimiterArr에 추가
        }

        // 문자열로부터 양수 추출
        public void extractNumbers(){
            // 유효 검사 통과한 문자열에서 숫자 추출

            // 덧셈 -> calculateNumbers()
        }

        // 계산
        public void calculateNumbers(){
            // for문을 돌면서 숫자 덧셈
            // 결과 반환 -> printResult()
        }

        // 출력
        public void printResult(){
            // 출력
        }
    }
}
