package calculator.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void addAll로_공백의_합산한_결과를_얻으면_0을반환한다() {
        String formulaPart = "";
        Separators separators = new Separators("//*\\n");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo("0");
    }

    @Test
    void addAll로_양의정수들을_합산한_결과를_얻는다() {
        String formulaPart = "1,2,3,4";
        Separators separators = new Separators("//*\\n1,2,3,4");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @Test
    void addAll로_양의실수들을_합산한_결과를_얻는다() {
        String formulaPart = "1.2,3.4";
        Separators separators = new Separators("//*\\n1.2,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(1.2D + 3.4D));
    }

    @Test
    void addAll로_공백과_양의정수를_합산한_결과를_얻는다() {
        String formulaPart = ",,,1";
        Separators separators = new Separators("//*\\n,,,1");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo("1");
    }

    @Test
    void addAll로_공백과_양의실수를_합산한_결과를_얻는다() {
        String formulaPart = ",,,1,2.3";
        Separators separators = new Separators("//*\\n,,,1,2.3");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo("3.3");
    }

    @Test
    void addAll로_공백과_양의정수와_양의실수들을_합산한_결과를_얻는다() {
        String formulaPart = ",,,1,3.4";
        Separators separators = new Separators("//*\\n,,,1,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(1D + 3.4D));
    }

    @Test
    void addAll로_양의정수와_양의실수들을_합산한_결과를_얻는다() {
        String formulaPart = "1,3.4";
        Separators separators = new Separators("//*\\n1,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(1D + 3.4D));
    }

    @Test
    void addAll로_온점커스텀구분자로인해_양의실수들을_양의정수로헤아려_합산한_결과를_얻는다() {
        String formulaPart = "1.2,3.4";
        Separators separators = new Separators("//.\\n1.2,3.4");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(1 + 2 + 3 + 4));
    }

    @Test
    void addAll로_숫자커스텀구분자로인해_양의정수들을_구분하여_합산한_결과를_얻는다() {
        String formulaPart = "11233";
        Separators separators = new Separators("//2\\n11233");
        Numbers actual = new Numbers(formulaPart, separators);
        assertThat(actual.addAll()).isEqualTo(String.valueOf(11 + 33));
    }

    @Test
    void addAll로_매우_큰_수의_합산한_결과를_얻는다() {
        BigDecimal bigNumber = BigDecimal.ONE; // 2^100000
        for (int i = 0; i < 100000; i++) {
            bigNumber = bigNumber.multiply(BigDecimal.TWO);
        }

        String formulaPart = bigNumber + "," + bigNumber + "," + bigNumber;
        Separators separators = new Separators(formulaPart);
        Numbers actual = new Numbers(formulaPart, separators);

        assertThat(actual.addAll())
                .isEqualTo(
                        new BigDecimal(bigNumber.toString())
                                .multiply(new BigDecimal(3L))
                                .toString()
                );
    }

    @Test
    void 생성시_널파라미터를_넘기면_예외발생한다() {
        assertThatThrownBy(() -> new Numbers(null, new Separators("")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers("", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성시_숫자커스텀구분자로인해_정수부를_잃은_양의실수들의_합산결과에서_예외발생한다() {
        String formulaPart = "1.2";
        Separators separators = new Separators("//1\\n1.2");
        assertThatThrownBy(() -> new Numbers(formulaPart, separators))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성시_숫자커스텀구분자로인해_소수부를_잃은_양의실수들의_합산결과에서_예외발생한다() {
        String formulaPart = "1.2";
        Separators separators = new Separators("//2\\n1.2");
        assertThatThrownBy(() -> new Numbers(formulaPart, separators))
                .isInstanceOf(IllegalArgumentException.class);
    }

}