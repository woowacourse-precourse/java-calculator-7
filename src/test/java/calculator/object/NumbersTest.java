package calculator.object;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void addAll로_공백의_합산한_결과를_얻으면_0을반환한다() {
        String formulaPart = "";
        Separators separators = new Separators("//*\\n");
        Numbers actual = new Numbers(formulaPart, separators);
        Assertions.assertThat(actual.addAll()).isEqualTo("0");
    }

    @Test
    void addAll로_양의정수들을_합산한_결과를_얻는다() {
        String formulaPart = "1,2,3,4";
        Separators separators = new Separators("//*\\n1,2,3,4");
        Numbers actual = new Numbers(formulaPart, separators);
        Assertions.assertThat(actual.addAll()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @Test
    void addAll로_양의실수들을_합산한_결과를_얻는다() {
        String formulaPart = "1.2,3.4";
        Separators separators = new Separators("//*\\n1.2,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        Assertions.assertThat(actual.addAll()).isEqualTo(String.valueOf(1.2D + 3.4D));
    }

    @Test
    void addAll로_커스텀구분자로인해_양의실수들을_양의정수로헤아려_합산한_결과를_얻는다() {
        String formulaPart = "1.2,3.4";
        Separators separators = new Separators("//.\\n1.2,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        Assertions.assertThat(actual.addAll()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

}