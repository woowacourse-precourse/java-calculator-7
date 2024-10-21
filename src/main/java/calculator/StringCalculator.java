package calculator;
public class StringCalculator {
    static String[] separator = {",", ":"}; //일반 구분자
    public int inputString(String str) {
        // null 혹은 빈 문자열을 입력할 경우 0을 반환
        if (str == null || str.isBlank()) {
            return 0;
        }
        if (str.length() == 1) {
            // 구분자 없이 숫자만 입력할 경우, 해당 숫자를 반환
            if (Character.isDigit(str.charAt(0))) {
                return str.charAt(0) - '0';
            }
            // 입력 불가능한 문자
            throw new RuntimeException("입력이 불가능한 문자가 포함되어있습니다.");
        }
        // 최대 100자로 제한
        if (str.length() > 100) {
            throw new RuntimeException("입력은 최대 100자까지 가능합니다.");
        }
        int result = 0;

        // 커스텀 구분자 지정한 경우
        if (str.charAt(0) == '/') { //커스텀 입력한다의 신호 : /입력
            String customSeparator = String.valueOf(str.charAt(2)); // 입력 문자열의 세 번째 문자(구분자가 '//'여서 3번째 문자)

            String input = str.substring(5);
            String[] numbers1 = input.split(customSeparator);
            for (String number : numbers1) {
                if (number.length() > 1) {
                    checkValidNumber(number);
                }
                result += Integer.parseInt(number);
            }
        }

        // 일반 구분자 ","  ":"
        if (str.charAt(0) != '/') {
            String[] numbers1 = str.split(separator[0]);
            for (String number : numbers1) {
                // 구분자가 ,가 아닌 경우
                if (number.length() > 1) {
                    // 콜론 구분자로 구분
                    String[] splited = number.split(separator[1]);

                    for (String num : splited) {
                        // 모든 기본 구분자로도 문자가 다 분리되지 않은 경우
                        if (num.length() > 1) {
                            checkValidNumber(num);  //입력 양식 확인
                        }
                        // 다른 기본 구분자로 분리된 경우, 분리된 숫자 합산
                        result += Integer.valueOf(num);
                    }
                }
                // 분리된 숫자 합하기
                if (number.length() == 1) {
                    result += Integer.parseInt(number);
                }
            }
        }
        return result;
    }

    public void checkValidNumber(String num) {
        int value = 0;

        try {
            value = Integer.parseInt(num);
        } catch (Exception e) {
            throw new RuntimeException("입력이 불가능한 문자가 포함되어있습니다.구분자와 양수로 구성된 문자열을 입력해야 합니다.");
        }

        if (value < 0) throw new RuntimeException("양수를 입력해야 합니다.");
    }
}