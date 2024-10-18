package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.run();

    }

    // 문자열 덧셈기 클래스 정의
    public static class StringCalculator{
        // 구분자를 담을 문자 배열 (구분자가 문자열일 수 있는 경우의 수 고려)
        ArrayList<String> delimiterArr;
        ArrayList<Integer> extractedNumArr;

        // 생성자
        public StringCalculator(){
            this.delimiterArr = new ArrayList<>();
            this.extractedNumArr = new ArrayList<>();

            // 기본 구분자
            this.delimiterArr.add(":");
            this.delimiterArr.add(",");
        }

        public void run(){
            String input = getInput();
            int result = 0;

            extractDelimiter(input);

            ArrayDeque<String> splitNumberArr = splitNumbers(input);

            if(isValidString(splitNumberArr)){
                result = calculateNumbers(extractedNumArr);
            };

            printResult(result);
        }

        // 입력
        public String getInput(){
            // 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            return Console.readLine();
        }

        // 문자열 유효성 검사
        public boolean isValidString(ArrayDeque<String> splitStringDeq){
            try{
                int arrSize = splitStringDeq.size();
                for (int i = 0; i < arrSize; i++) {
                    String s = splitStringDeq.pollFirst();
                    if (s.isEmpty()) {
                        continue;
                    }
                    if(s.matches("\\d+")){
                        extractedNumArr.add(Integer.parseInt(s));
                    }else{
                        throw new IllegalArgumentException();
                    }
                }
            } catch (Exception e) {
                throw e;
            }

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
        public ArrayDeque<String> splitNumbers(String input){
            // 구분자를 정의하려고 할때 사이에 숫자가 껴있을 수도 있음
            String slicedString = input.replaceAll("//(.*?)\\\\n",":");
            ArrayDeque<String> splitStringDeq = new ArrayDeque<>();

            if(slicedString.isEmpty()){
                return splitStringDeq;
            }

            splitStringDeq.add(slicedString);

            try {
                int i = delimiterArr.size()-1;
                // 넓이우선이네
                while(i>=0 && !splitStringDeq.isEmpty()) {
                    int arrSize = splitStringDeq.size();
                    for(int j=0;j< arrSize;j++){
                        String 덩어리 = splitStringDeq.pollFirst();
                        덩어리 = 덩어리.trim();
                        if(덩어리.contains(delimiterArr.get(i))){
                            splitStringDeq.addAll(List.of(덩어리.split(delimiterArr.get(i))));
                            continue;
                        }
                        splitStringDeq.add(덩어리);
                    }
                    i--;
                }
                return splitStringDeq;
            } catch (Exception e) {
                throw e;
            }
        }

        // 계산
        public int calculateNumbers(ArrayList<Integer> extractedNumbers){
            int result = 0;
            for(int n:extractedNumbers){
                result+=n;
            }
            return result;
        }

        // 출력
        public void printResult(int result){
            System.out.println("결과 : "+result);
        }
    }
}
