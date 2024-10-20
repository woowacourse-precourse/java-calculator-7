package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionsTest {

    @Test
    void joinToString_테스트() {
        // given
        List<String> strings = List.of("a", "b" ,"c");
        List<Integer> integers = List.of(1, 2, 3);
        // when
        String stringsJoinToString = Collections.joinToString(strings);
        String integersJoinToString = Collections.joinToString(integers, ", ");
        // then
        assertThat(stringsJoinToString).isEqualTo("abc");
        assertThat(integersJoinToString).isEqualTo("1, 2, 3");
    }

}
