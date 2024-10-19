package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.run();
    }

    public static class StringCalculator {
        // 구분자를 담을 문자 배열 (구분자가 문자열일 수 있는 경우의 수 고려)
        ArrayList<String> delimiterArr;
        ArrayList<Integer> extractedNumArr;

        // 생성자
        public StringCalculator() {
            this.delimiterArr = new ArrayList<>();
            this.extractedNumArr = new ArrayList<>();

            // 기본 구분자
            this.delimiterArr.add(":");
            this.delimiterArr.add(",");
        }

        public void run() {
            String input = getInput();

            extractDelimiter(input);
        }

        // 입력
        public String getInput(){
            // 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            return Console.readLine();
        }

        // 문자열로부터 구분자 추출
        public ArrayList<String> extractDelimiter(String input){
            // 패턴 객체 생성
            Pattern pattern = Pattern.compile("//(.*?)\\\\n+");
            // 객체 필터링 후 Matcher 객체 생성
            Matcher matcher = pattern.matcher(input);

            // 커스텀 구분자 0개 이상일 가능성 있음 -> 반복문
            // 일치할 경우 추출하여 delimiterArr에 추가
            while (matcher.find()) {
                String cleanDelimiter = matcher.group().replaceAll("//|\\\\n","");
                delimiterArr.add(cleanDelimiter);
            }
            return delimiterArr;

        }


    }
}
