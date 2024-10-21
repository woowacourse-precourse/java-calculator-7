package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddingMachineTest {

    @Test
    void 빈_리스트를_받는다() {
        // given
        List<Integer> empty_list = new ArrayList<>();
        AddingMachine addingMachine = new AddingMachine(empty_list);

        // when
        long result = addingMachine.addNumbers();

        // then
        assertThat(result).isEqualTo(0);
    }
}
