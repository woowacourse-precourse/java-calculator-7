package calculator.service;

import java.util.List;

public class CalculatorService {

    /**
     * 입력된 문자열이 기본 구분자([,:])를 사용하는지 또는 커스텀 구분자를 사용하는지 확인한 후, 해당 구분자를 기준으로 문자열을 분리하여 배열로 반환합니다.
     *
     * @param line 사용자가 입력한 문자열
     * @return 분리된 숫자 리스트
     */
    public List<Integer> paresInput(String line) {
        return List.of();
    }

    /**
     * 파라미터로 전달된 문자열 배열에서 각 요소를 숫자로 변환할 수 있다면, values 리스트에 Int 타입으로 변환한 후 추가합니다. 만약 숫자로 변환할 수 없는 값이 있을 경우,
     * NumberFormatException이 발생하며, 이를 IllegalArgumentException으로 변환해 예외를 던집니다.
     *
     * @param parts 구분자를 통해 분리된 문자열 배열(숫자)
     * @return 숫자 리스트
     */
    public List<Integer> convertToNumbers(String[] parts) {
        return List.of();
    }

    /**
     * 숫자 리스트의 합계를 반환
     */
    public int calculateSum(List<Integer> values) {
        return values.stream().mapToInt(value -> value).sum();
    }
}
