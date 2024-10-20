package calculator.separator;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorsTest {

    @DisplayName("구분자를 기준으로 문자열을 나눈다.")
    @Test
    void split() {
        //given
        Separators separators = new Separators(Set.of(
                new Separator(','),
                new Separator('?'),
                new Separator(':'),
                new Separator('*'),
                new Separator('+'),
                new Separator('-'),
                new Separator('/'),
                new Separator('$'),
                new Separator('%'),
                new Separator('!'),
                new Separator('@'),
                new Separator('^'),
                new Separator(' ')
        ));
        String str = "1,2?3:4*5+6-7/8$9%10!11@12^13 14";

        //when
        List<String> result = separators.split(str);

        //then
        Assertions.assertThat(result)
                .isEqualTo(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"));
    }
}