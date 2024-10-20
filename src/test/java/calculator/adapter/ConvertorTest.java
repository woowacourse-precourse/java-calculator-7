package calculator.adapter;

import calculator.application.Delimiter;
import calculator.application.DelimiterList;
import calculator.domain.Number;
import calculator.domain.NumberList;
import calculator.util.RandomSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;

class ConvertorTest extends RandomSupport {
    private static final Convertor CONVERTOR = new Convertor();

    @Nested
    class 올바른_문자열과_구분자는 {
        @Test
        void 변환에_성공할_것이다() {
            final var value = "1'2:3";
            final var expectedNumberList = new NumberList(List.of(
                Number.of(1),
                Number.of(2),
                Number.of(3)
            ));

            final var numberList = CONVERTOR.convertToNumberList(value, DelimiterList.from(Set.of(
                Delimiter.from("'"),
                Delimiter.from(":")
            )));

            assertAll(
                () -> Assertions.assertThat(numberList).isEqualTo(expectedNumberList)
            );
        }
    }

    @Nested
    class 숫자가_아닌_문자열과_구분자는 {
        @Test
        void 변환에_예외가_발생할_것이다() {
            final var value = "1'invalid:3";

            assertAll(
                () -> Assertions.assertThatThrownBy(() -> CONVERTOR.convertToNumberList(value, DelimiterList.from(Set.of(
                        Delimiter.from("'"),
                        Delimiter.from(":")
                    ))))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}