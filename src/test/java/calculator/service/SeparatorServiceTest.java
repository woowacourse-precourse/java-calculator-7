package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.entity.IndexQueue;
import calculator.entity.Num;
import calculator.entity.NumList;
import calculator.entity.Separator;
import calculator.entity.SeparatorSet;
import calculator.service.impl.SeparatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorServiceTest {

    private final SeparatorService separatorService = new SeparatorServiceImpl();

    @Test
    @DisplayName("구분자 확인 테스트1 : 기본")
    void checkCustomSeparator1() {
        // given
        String input = "//5\\n//6\\n";

        SeparatorSet expected = new SeparatorSet();
        expected.addSeparator(new Separator("5"));
        expected.addSeparator(new Separator("6"));

        SeparatorSet result = separatorService.getCustomSeparators(input);

        assertThat(result).isEqualTo(expected);

    }

    @Test
    @DisplayName("구분자 인덱스 테스트1 : 기본")
    void testGetAllCustomSepIdx1() {
        // given
        String input = "//5\\n//6\\n";

        IndexQueue expected = new IndexQueue();
        expected.offer(2);
        expected.offer(7);

        // when
        IndexQueue result = separatorService.getAllCustomSepIdx(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀문자 분리 테스트1 : 기본")
    void testRefineString1() {
        // given
        String input = "//u\\n//x\\n1,2,3,4,5";
        IndexQueue idxQueue = new IndexQueue();
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
        NumList expect = new NumList();
        expect.addNum(new Num(1));
        expect.addNum(new Num(2));
        expect.addNum(new Num(3));
        expect.addNum(new Num(4));
        expect.addNum(new Num(5));

        SeparatorSet separatorSet = new SeparatorSet();

        // when
        String regex = separatorSet.toRegexString();
        NumList result = separatorService.separateNum(input, regex);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("문자열 분리 테스트2 : 특수문자 처리")
    void testSeparateNum2() {
        //given
        String input = "1?2,3.4\\5";
        NumList expect = new NumList();
        expect.addNum(new Num(1));
        expect.addNum(new Num(2));
        expect.addNum(new Num(3));
        expect.addNum(new Num(4));
        expect.addNum(new Num(5));

        SeparatorSet separatorSet = new SeparatorSet();
        separatorSet.addSeparator(new Separator("?"));
        separatorSet.addSeparator(new Separator("."));
        separatorSet.addSeparator(new Separator("\\"));

        // when

        String regex = separatorSet.toRegexString();
        NumList result = separatorService.separateNum(input, regex);

        assertThat(result).isEqualTo(expect);
    }

}
