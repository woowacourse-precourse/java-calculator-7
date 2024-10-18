package calculator.splitprocess;
import java.util.Arrays;
import calculator.view.InputView;
// 문자열을 커스텀구문자도 생각해서 변수로 받도록 지정하고 split해주는 기능만 구현
// 리턴값은 분리된 숫자를 출력
public class StringSplitter {
    public static int[] splitString(InputView inputView, String delimiter){
        String input = inputView.printInputMessage();

        String[] parts= input.split(delimiter);
        return Arrays.stream(parts)
                .filter(StringSplitter::isNumeric)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    // 문자열이 숫자인지 확인하는 메서드
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
