package calculator.model;

import java.util.ArrayList;

public class CalculationModel {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private ArrayList<Character> separate = new ArrayList<>();

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public void parseInput(String input){
        if(input == null || input.isEmpty()){
            numbers.add(0);
            return;
        }
        String substr = input;

        //커스텀 구분자인지 확인
        boolean custom = false;
        int end = -1;
        if(input.contains("//")) {
            int idx = input.indexOf("//") + 2;
            for (int i = idx; i < input.length() - 1; i++) {
                if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                    end = i;
                    custom = true;
                    break;
                }
            }

            // "//"로 시작하지만 "\n"이 없음
            if (!custom) {
                throw new IllegalArgumentException("잘못된 입력: '//'로 시작하지만 '\n'으로 끝나지 않습니다.");
            } else if (custom && idx == end) {
                throw new IllegalArgumentException("잘못된 입력: 커스텀 구분자가 존재하지 않습니다.");
            }

            //커스텀구분자 넣기
            separate.add(input.charAt(idx));
        }

        //구분자 제외하고 숫자만 추출
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[,:");
        for(Character c : separate){
            stringBuilder.append(c);
        }
        stringBuilder.append("]");

        //커스텀구분자
        if(custom){
            //커스텀구분자 지정 구문 제외하고 새로 String 구성
            substr = input.substring(end+2);
        }
        String[] token = substr.split(stringBuilder.toString());

        for (String s : token) {
            if (!s.isEmpty()) {
                try {
                    int num = Integer.parseInt(s);

                    if(num < 0){
                        throw new IllegalArgumentException("잘못된 입력: 음수가 포함되었습니다.");
                    }

                    numbers.add(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력: 숫자가 아닙니다.");
                }
            }
        }
    }
}
