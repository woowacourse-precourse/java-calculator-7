package calculator.plusCalculator;

import java.util.ArrayList;
import java.util.List;

public interface PlusCalculatorInterface {

    // 구분자 리스트
    List<String> separators = new ArrayList<>();

    /**
     * 계산기 작동 메서드
     *
     * @return int
     */
    public int run(String input);

    /**
     * 커스텀 구분자를 찾는 메서드
     *
     * @return 커스텀 구분자를 제외한 String
     */
    public String findCustomSeparator(String input);

    /**
     * 커스텀 구분자가 있는지 검사하는 메서드
     *
     * @return boolean
     */
    public boolean hasCustomSeparator(String input);

    /**
     * 맨 앞 커스텀 구분자를 추출하여 빼 separators에 저장하고, 커스텀 구분자를 뺸 문자열을 반환하는 메서드
     *
     * @return 맨 앞의 커스텀 구분자를 뺀 문자열
     */
    public String extractCustomSeparator(String input);

    /**
     * 구분자로 split하여 숫자 추출
     *
     * @return 문자열에서 숫자를 모은 List<Integer>
     */
    public List<Integer> extractNumbers(String input);

    /**
     * ,, 같은 중복 구분자를 처리하기 위한 separators 정렬 메서드
     */
    public void sortSeparatorsSizeDesc();

    /**
     * split에 사용할 구분자 문자열을 만드는 메서드
     *
     * @return 구분자 문자열 String
     */
    public String getSeparatorsSplitRegex();

    /**
     * String을 Integer로 변환해 반환 parseInt로 변환 실패하거나, 음수가 나오면 예외 처리
     *
     * @return Integer
     */
    public Integer extractNumber(String numberString);

    /**
     * 숫자 계산
     *
     * @return Integer
     */
    public Integer calculate(List<Integer> integerNumbers);

}
