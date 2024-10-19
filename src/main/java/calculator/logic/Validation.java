package calculator.logic;

import static calculator.logic.CustomChecker.isCustom;

public class Validation {

    public static void execution(String str) {
        if(isCustom(str)) {
            checkCustomVal(str);
        } else {
            checkNormalVal(str);
        }
    }

    private static void checkNormalVal(String str) {

        String[] numbers = Delimiter.doNormalDelimiter(str);

        if(!(checkInteger(numbers[0]))) {
            throw new IllegalArgumentException("일반 입력의 경우에는 첫번째 수는 숫자이어야합니다");
        }

        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number); // 문자열을 정수로 변환, getInt랑 다ㅇ
                if (num < 0) {
                    throw new IllegalArgumentException("입력값 중 음수가 있습니다");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다");
            }
        }
    }

    // 커스텀 문자로 숫자가 들어온 경우
    private static void checkCustomVal(String str) {
      String[] numbers = Delimiter.doCustomDelimiter(str);

        if((checkInteger(CustomChecker.getCustom(str)))){
            throw new IllegalArgumentException("커스텀 값으로 숫자는 입력할 수 없습니다.");
        }

      for(String number : numbers) {

          if(Integer.parseInt(number) < 0) {
              throw new IllegalArgumentException("커스텀 입력 값 중 음수가 있습니다.");

                 }
            }
        }

    private  static boolean checkInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }


}
