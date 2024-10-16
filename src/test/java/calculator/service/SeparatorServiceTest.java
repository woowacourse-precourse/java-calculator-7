package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.entity.Num;
import calculator.entity.Separator;
import calculator.service.impl.SeparatorServiceImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorServiceTest {

    private final SeparatorService separatorService = new SeparatorServiceImpl();

    @Test
    @DisplayName("구분자 확인 테스트1 : 기본")
    void checkCustomSeparator1() {
        // given
        String input = "//5\\n//6\\n";

        Set<Separator> expected = new HashSet<>();
        expected.add(new Separator("5"));
        expected.add(new Separator("6"));

        Set<Separator> customSeparators = separatorService.getCustomSeparators(input);

        assertThat(customSeparators).containsAll(expected);

    }

    @Test
    @DisplayName("구분자 인덱스 테스트1 : 기본")
    void testGetAllCustomSepIdx1() {
        // given
        String input = "//5\\n//6\\n";

        Queue<Integer> expected = new PriorityQueue<>();
        expected.offer(2);
        expected.offer(7);

        // when
        Queue<Integer> result = separatorService.getAllCustomSepIdx(input);

        // then
        assertThat(result).containsAll(expected);
    }

    @Test
    @DisplayName("커스텀문자 분리 테스트1 : 기본")
    void testRefineString1() {
        // given
        String input = "//u\\n//x\\n1,2,3,4,5";
        Queue<Integer> idxQueue = new PriorityQueue<>();
        idxQueue.offer(0);
        idxQueue.offer(5);

        String expected = "ux1,2,3,4,5";

        // when
        String result = separatorService.refineString(input, idxQueue);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 분리 테스트1 : 기본")
    void testSeparateNum1() {
        //given
        String input = "1,2,3,4,5";
        List<Num> expect = new ArrayList<>();
        expect.add(new Num(1));
        expect.add(new Num(2));
        expect.add(new Num(3));
        expect.add(new Num(4));
        expect.add(new Num(5));
        Set<Separator> separatorSet = new HashSet<>();

        // when
        List<Num> result = separatorService.separateNum(input,
            Separator.getAllSeparators(separatorSet));

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("문자열 분리 테스트2 : 특수문자 처리")
    void testSeparateNum2() {
        //given
        String input = "1?2,3.4\\5";
        List<Num> expect = new ArrayList<>();
        expect.add(new Num(1));
        expect.add(new Num(2));
        expect.add(new Num(3));
        expect.add(new Num(4));
        expect.add(new Num(5));
        Set<Separator> separatorSet = new HashSet<>();
        separatorSet.add(new Separator("?"));
        separatorSet.add(new Separator("."));
        separatorSet.add(new Separator("\\"));

        // when
        List<Num> result = separatorService.separateNum(input,
            Separator.getAllSeparators(separatorSet));

        assertThat(result).isEqualTo(expect);
    }

}
