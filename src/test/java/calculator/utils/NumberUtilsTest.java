package calculator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
public class NumberUtilsTest {

    @Test
    void 정상_문자열이_들어오면_정상_작동() {
        List<Character> separators = createSeparatorList();
        List<String> normalStrings = createNormalStrings();

        //normalStrings에 매핑되는 숫자 리스트들이 포함되어있음
        List<List<Integer>> expected = mappedToNormalStrings();

        List<List<Integer>> parsedNumbers = normalStrings.stream()
                .map(
                        (normalString) -> NumberUtils.parseNumbers(normalString, separators)
                ).toList();

        Assertions.assertEquals(expected, parsedNumbers);
    }


    /**
     * 잘못된 형식의 구분자를 포함한 숫자열이 오면 IllegalArgumentException이 발생하는가?
     *
     * 잘못된 형식의 문자열 추가: createIllegalStrings 에서 추가가능하다
     */
    @Test
    void 잘못된_형식의_문자열은_예외가_발생() {

        List<Character> separators = createSeparatorList();
        //여러개의 잘못된 형식의 문자열을 사용해 테스트
        List<String> illegalStrings = createIllegalStrings();

        int totalErrors = illegalStrings.size();

        int ErrorCount = 0;


        for (String illegalString: illegalStrings) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> {
                        NumberUtils.parseNumbers(illegalString, separators);
                    });
            ErrorCount++;
        }

        Assertions.assertEquals(
                totalErrors,
                ErrorCount,
                "에러가 모든 illegal String에 대해 발생해야함");

    }

    @Test
    void 빈_문자열은_0으로_치환() {

        List<Character> separators = createSeparatorList();

        //빈 문자열을 포함한 문자열
        String s = "5::10";
        List<Integer> expected = List.of(5, 0, 10);

        List<Integer> numbers = NumberUtils.parseNumbers(s, separators);

        Assertions.assertEquals(expected, numbers);
    }

    @Test
    void 빈_문자열이_들어오면_0만_담은_리스트를_반환() {
        List<Character> separators = createSeparatorList();

        //빈 문자열
        String s = "";

        //expected
        List<Integer> expected = new ArrayList<>();
        expected.add(0);

        List<Integer> numbers = NumberUtils.parseNumbers(s, separators);

        Assertions.assertEquals(expected, numbers);
    }

    @Test
    void 마지막_문자가_빈문자일때_제대로_작동하는지_확인() {
        List<Character> separators = createSeparatorList();

        //마지막 문자가 빈 문자열
        String s = "55:";
        List<Integer> expected = List.of(55,0);

        List<Integer> numbers = NumberUtils.parseNumbers(s, separators);

        Assertions.assertEquals(expected, numbers);
    }

    /**
     * 올바른 형식의 문자열을 반환
     *
     * 주의
     * 해당 문자열에 대한 expected 리스트는 mappedToNormalStrings 메서드를 통해 호출
     * 따라서 테스트 케이스 추가를 위해서는 mappedToNormalStrings에 올바른 쌍을 추가해줘야한다
     *
     * @return 올바른 형식의 문자열들을 담은 리스트
     */
    private List<String> createNormalStrings() {
        List<String> normalStrings = new ArrayList<>();
        normalStrings.add("5");
        normalStrings.add("10:4");
        normalStrings.add("5:44,35");
        normalStrings.add("10,3,4,97");
        normalStrings.add("5:");
        normalStrings.add("10,,");

        return normalStrings;
    }

    /**
     * @return createNormalStrings에서 리턴하는 String에 메핑되는 숫자들
     */
    private List<List<Integer>> mappedToNormalStrings() {
        List<List<Integer>> normalParsedNumbers = new ArrayList<>();
        normalParsedNumbers.add(List.of(5));
        normalParsedNumbers.add(List.of(10, 4));
        normalParsedNumbers.add(List.of(5, 44, 35));
        normalParsedNumbers.add(List.of(10, 3, 4, 97));
        normalParsedNumbers.add(List.of(5, 0));
        normalParsedNumbers.add(List.of(10,0,0));

        return normalParsedNumbers;
    }

    /**
     * 잘못된 형식의 문자열을 반환
     * @return 잘못된 형식의 문자열들을 담은 리스트
     */
    private static List<String> createIllegalStrings() {

        List<String> illegalStrings = new ArrayList<>();
        illegalStrings.add("1,2d");
        illegalStrings.add("2,3d\t");
        illegalStrings.add("3,4d");
        illegalStrings.add("4,5d::");

        return illegalStrings;
    }

    /**
     * 구분자를 담은 리스트를 반환
     * @return 구분자를 담은 리스트
     */
    private static List<Character> createSeparatorList() {
        //기본 구분자 사용
        List<Character> separators = new ArrayList<>();
        separators.add(':');
        separators.add(',');

        return separators;
    }
}
