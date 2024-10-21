package calculator.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListValidatorTest {

    @Test
    @DisplayName("음수가 list에 들어있으면 IllegalArgumentException을 던진다")
    void 음수_리스트_판별() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(-1L);
        Assertions.assertThatThrownBy(() -> {
            ListValidator.validatePositiveNumberList(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 list에 들어있으면 IllegalArgumentException을 던진다")
    void 양수_리스트_판별() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(0L);
        Assertions.assertThatThrownBy(() -> {
            ListValidator.validatePositiveNumberList(list);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}