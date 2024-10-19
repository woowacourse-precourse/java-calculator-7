package calculator.splitprocess;
import java.util.Arrays;
import calculator.view.InputView;
// 문자열을 커스텀구문자도 생각해서 변수로 받도록 지정하고 split해주는 기능만 구현
// 리턴값은 분리된 숫자를 출력
public class StringSplitter {
    public static int[] splitString(String input, String delimiter){

        String[] parts= input.split(delimiter);

        int[] numbers=Arrays.stream(parts)
                .filter(StringSplitter::isNumeric)
                .mapToInt(Integer::parseInt)
                .toArray();

        //유효한 숫자가 없는 경우 예외 발생(형식을 지키지 않으면 유효한 숫자가 없음)
        if(numbers.length==0){
            throw new IllegalArgumentException("형식이 잘못됐습니다.");
        }
        //음수가 포함된 경우 예외 발생
        for (int number : numbers) {
            if (number<0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
//;\n1;2;3
        return numbers;
    }
    // 문자열이 숫자인지 확인하는 메서드
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
