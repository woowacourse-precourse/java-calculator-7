package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        private String inputString;

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
                String input = getInput();
                extractDelimiter(input);
                if(isValidString(input)){
//                    calculateNumbers();
                };
        }

        // 입력
        public String getInput(){
            // 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            inputString = Console.readLine();
            return inputString;
        }

        // 문자열 유효성 검사
        public boolean isValidString(String input){

            // 구분자를 정의하려고 할때 사이에 숫자가 껴있을 수도 있음
            String slicedString = input.replaceAll("//(.*?)\\\\n",":");

            if(slicedString.isEmpty()){
                return true;
            }

            Deque<String> splitStringDeq = new ArrayDeque<>();
            splitStringDeq.add(slicedString);

            // 입력 값이 숫자, 구분자를 제외한 문자를 포함하는지
            try {
                int i = delimiterArr.size()-1;
                // 깊이우선탐색
                while(i>=0 && !splitStringDeq.isEmpty()) {
                    String 덩어리 = splitStringDeq.pollFirst();
                    if(덩어리.isEmpty()){
                        continue;
                    // 덩어리가 숫자로만 이루어져있으면
                    }else{
                        덩어리 = 덩어리.trim();
                    }

                    if(덩어리.matches("\\d+")){
                        // 숫자 배열에 추가
                        extractedNumArr.add(Integer.parseInt(덩어리));
                        continue;
                    }else if(덩어리.contains(delimiterArr.get(i))){
                        splitStringDeq.addAll(List.of(덩어리.split(delimiterArr.get(i))));
                    }else{
                        // 찾는 구분자는 없지만 숫자로만 이루어진 것은 아닐 때
                        splitStringDeq.add(덩어리);
                        i--;
                    }
                }

                // 구분자 검사를 끝냈음에도 문자가 남아있다면 예외 처리
                if(!splitStringDeq.isEmpty()){
                    throw new IllegalArgumentException("Invalid Input");
                }

            } catch (Exception e) {
                System.err.println(e);
            }
            System.out.println(extractedNumArr.toString());
            return true;
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

        // 문자열로부터 양수 추출
        public void extractNumbers(){
            // 유효 검사 통과한 문자열에서 숫자 추출

            // 덧셈 -> calculateNumbers()
        }

        // 계산
        public void calculateNumbers(ArrayList<Integer> extractedNumbers){

        }

        // 출력
        public void printResult(){
            // 출력
        }
    }
}
