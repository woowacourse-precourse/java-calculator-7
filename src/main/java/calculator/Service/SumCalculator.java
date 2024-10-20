package calculator.Service;

import calculator.DTO.StringCalculatorDTO;
import java.util.List;

public class SumCalculator {
    // 넘겨받은 List<String>에서 숫자를 추출하고 합계를 구해 inputDTO에 설정하는 메서드
    public void sum(StringCalculatorDTO inputDTO) {
        List<String> detachedInputList = inputDTO.getDetachedInput();
        int sum = 0;  // 최종 합계를 저장할 변수

        // 리스트의 각 문자열을 순회하며 숫자 추출 및 합산
        for (String element : detachedInputList) {
            try {
                // 문자열을 정수로 변환 후 합산
                int number = Integer.parseInt(element.trim());
                if (number < 1) {
                    // 0 또는 음수가 입력된 경우
                    throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식 (0 or 음수):" + element);
                }
                sum += number;
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 경우 (구분자 이외의 문자가 존재하는 경우)
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식 (구분자 이외의 문자):" + element);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.exit(1);  // 프로그램 종료
            }
        }

        inputDTO.setSum(sum); // 합계를 inputDTO에 설정
    }
}