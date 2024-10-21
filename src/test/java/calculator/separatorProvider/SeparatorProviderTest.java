package calculator.separatorProvider;

import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SeparatorProviderTest {

    @Test
    void 추출할_커스텀구분자가_없다면_기본_구분자를_반환한다() {
        //given
        SeparatorProviderImpl sut = new SeparatorProviderImpl();

        //when
        Set<Character> result = sut.getSeparator("");

        //then
        Assertions.assertThat(result).containsExactlyInAnyOrder(':', ',');
    }

    @Test
    void 추출할_커스텀구분자가_있다면_추출한다() {
        //given
        SeparatorProviderImpl sut = new SeparatorProviderImpl();

        //when
        Set<Character> result = sut.getSeparator(";");

        //then
        Assertions.assertThat(result).containsExactly(';');
    }

    @Test
    void 추출할_커스텀구분자가_여러개_있다면_모두_추출한다() {
        //given
        SeparatorProviderImpl sut = new SeparatorProviderImpl();

        //when
        Set<Character> result = sut.getSeparator(";^&");

        //then
        Assertions.assertThat(result).containsExactlyInAnyOrder(';', '^', '&');
    }
}