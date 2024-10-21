package calculator.Service;

import calculator.DTO.StringCalculatorDTO;
import java.util.List;

public class SumCalculator {
    // 넘겨받은 List<String>에서 숫자를 추출하고 합계를 구해 inputDTO에 설정하는 메서드
    public void sum(StringCalculatorDTO inputDTO) {
        // 빈 문자열이 넘어왔을 때 (입력: "\n" => 변환: " "), 변환된 문자열을 처리하는 코드
        if (inputDTO.getInput().trim().isEmpty()) {
            inputDTO.setSum(0); // 빈 문자열일 경우 합계를 0으로 설정
            return;
        }

        List<String> detachedInputList = inputDTO.getDetachedInput();
        int sum = 0;  // 최종 합계를 저장할 변수

        // 리스트의 각 문자열을 순회하며 숫자 추출 및 합산
        for (String element : detachedInputList) {
            try {
                if (element == null || element.trim().isEmpty()) {
                    continue;
                }
                // 문자열을 정수로 변환 후 합산
                int number = Integer.parseInt(element.trim());
                if (number <= 0) {
                    // 0 또는 음수가 입력된 경우
                    throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식 (0 or 음수):" + element);
                }
                sum += number;
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 경우 (구분자 이외의 문자가 존재하는 경우)
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식 (구분자 이외의 문자):" + element);
            }
        }

        inputDTO.setSum(sum); // 합계를 inputDTO에 설정
    }
}