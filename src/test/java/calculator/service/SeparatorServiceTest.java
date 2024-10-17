package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.entity.Index;
import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.Num;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
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
        Input input = new Input("//5\\n//6\\n");

        SeparatorSet expected = new SeparatorSet();
        expected.addSeparator(new Separator("5"));
        expected.addSeparator(new Separator("6"));

        // when
        SeparatorSet result = separatorService.getCustomSeparators(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자 인덱스 테스트1 : 기본")
    void testGetAllCustomSepIdx1() {
        // given
        Input input = new Input("//5\\n//6\\n");

        IndexQueue expected = new IndexQueue();
        expected.offer(new Index(0));
        expected.offer(new Index(5));

        // when
        IndexQueue result = separatorService.getAllCustomSepIdx(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀문자 분리 테스트1 : 기본")
    void testRefineString1() {
        // given
        Input input = new Input("//u\\n//x\\n1,2,3,4,5");
        IndexQueue idxQueue = new IndexQueue();
        idxQueue.offer(new Index(0));
        idxQueue.offer(new Index(5));

        RefinedInput expected = new RefinedInput("ux1,2,3,4,5");

        // when
        RefinedInput result = separatorService.refineInput(input, idxQueue);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 분리 테스트1 : 기본")
    void testSeparateNum1() {
        //given
        RefinedInput input = new RefinedInput("1,2,3,4,5");
        NumList expect = new NumList();
        expect.addNum(new Num(1));
        expect.addNum(new Num(2));
        expect.addNum(new Num(3));
        expect.addNum(new Num(4));
        expect.addNum(new Num(5));

        SeparatorSet separatorSet = new SeparatorSet();

        // when
        RegexStr regexStr = separatorSet.toRegexStr();
        NumList result = separatorService.separateNum(input, regexStr);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("문자열 분리 테스트2 : 특수문자 처리")
    void testSeparateNum2() {
        //given
        RefinedInput input = new RefinedInput("1?2,3.4\\5");
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
        RegexStr regexStr = separatorSet.toRegexStr();
        NumList result = separatorService.separateNum(input, regexStr);


        // then
        assertThat(result).isEqualTo(expect);
    }

}
