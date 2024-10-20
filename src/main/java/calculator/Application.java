package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInputText = readLine(); //구현 요구 사항중 해당 라이브러리만을 사용하여 구현해야 하는 항목 충족
        try {
            if (userInputText == null || userInputText.trim().isEmpty()) {
                throw new IllegalArgumentException("입력한 값이 없습니다.확인 후 다시 입력해주세요");
            }
            String[] textValues = splitText(userInputText);
            int[] sumValues = checkValue(textValues);
            int result = sumValue(sumValues);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
            throw e;
        }
    }

    public static String[] splitText(String text) { //입력받은 문자열을 구분자로 나눠주는 메서드
        int firstGubunja = text.split("//").length;
        int secondGubunja = text.split("\\\\n").length;
        if (firstGubunja > 1 && secondGubunja > 1) {//커스텀 구분자 오류 분기처리
            String[] textSplitFirst = text.split("//");
            String[] textSplitSecond = textSplitFirst[1].split("\\\\n");
            String gubunja = textSplitSecond[0];
            return textSplitSecond[1].split(gubunja);
        } else if (firstGubunja > 1 && secondGubunja == 1) {
            throw new IllegalArgumentException("입력된 구분자가 잘못 입력되었습니다.확인 후 다시 입력해주세요");
        } else if (firstGubunja == 1 && secondGubunja > 1) {
            throw new IllegalArgumentException("입력된 구분자가 잘못 입력되었습니다.확인 후 다시 입력해주세요");
        } else {
            return text.split("[:,]");
        }
    }

    public static int[] checkValue(String[] textValues) { //문자열을 배열로 나눈후 값에 대한 오류를 체크 하는 함수(형변환 포함)
        int[] values = new int[textValues.length];
        for (int i = 0; i < textValues.length; i++) {
            try {
                int parseIntVal = Integer.parseInt(textValues[i].trim());
                if (parseIntVal <= 0) {
                    throw new IllegalArgumentException("양수의 정수를 입력하셔야 합니다.확인 후 다시 입력해주세요.");
                } else {
                    values[i] = parseIntVal;
                }
            } catch (NumberFormatException e) {//형변환 에러 분기처리
                throw new IllegalArgumentException("숫자가 아닌 문자 또는 빈칸을 같이 입력하셨습니다.확인 후 다시 입력해주세요.");
            }
        }
        return values;
    }


    public static int sumValue(int[] values) { //형변환까지 완료한 값들을 덧셈계산해주는 메서드
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }


}
