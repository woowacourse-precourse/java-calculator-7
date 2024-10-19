package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
            int result = 0;

            extractDelimiter(input);
            ArrayDeque<String> splitNumberArr = splitNumbers(input);

            if(isValidString(splitNumberArr)){
                result = calculateNumbers(extractedNumArr);
            };

            printResult(result);
        }

        private void printResult(int result) {
        }

        private int calculateNumbers(ArrayList<Integer> extractedNumArr) {
            return 0;
        }

        private boolean isValidString(ArrayDeque<String> splitNumberArr) {
            return true;
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

        // 문자열로부터 양수 추출
        public ArrayDeque<String> splitNumbers(String input){
            // 구분자를 정의하려고 할때 사이에 숫자가 껴있을 수 있으므로 기본 구분자 콜론(:)으로 처리
            // 이스케이프 문자가 주어진 경우에도 콜론(:)으로 처리
            String slicedString = input.replaceAll("//(.*?)\\\\n|\\\\s|\\\\t|\\\\r|\\\\f",":");

            ArrayDeque<String> splitStringDeq = new ArrayDeque<>();

            // 다듬은 문자열이 없을 경우 빈 Deque를 반환
            if(slicedString.isEmpty()){
                return splitStringDeq;
            }

            // Deque를 통한 BFS
            splitStringDeq.add(slicedString);

            int i = delimiterArr.size()-1;

            while(i>=0 && !splitStringDeq.isEmpty()) {
                int arrSize = splitStringDeq.size();
                for(int j=0;j< arrSize;j++){
                    String element = splitStringDeq.pollFirst();

                    // 구분자를 포함하고 있을 경우
                    if(element.contains(delimiterArr.get(i))){
                        // split하여 deque에 저장
                        splitStringDeq.addAll(List.of(element.split(delimiterArr.get(i))));
                        continue;
                    }
                    splitStringDeq.add(element);
                }
                // 다음 구분자로 넘어간다
                i--;
            }
            return splitStringDeq;
        }


    }
}
