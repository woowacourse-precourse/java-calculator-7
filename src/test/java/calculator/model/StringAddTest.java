package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddTest {

    StringAdd stringAdd;

    @BeforeEach
    public void setup(){
        stringAdd = new StringAdd();
    }

    @Test
    public void 아무것도_입력하지_않았을_경우(){
        assertThat(0).isEqualTo(stringAdd.add(""));
    }

    @Test
    public void 하나의_숫자만_입력_했을_경우(){
        assertThat(5).isEqualTo(stringAdd.add("5"));
    }

    @Test
    public void 두_개의_숫자를_입력_했을_경우(){
        assertThat(9).isEqualTo(stringAdd.add("5,4"));
    }

    @Test
    public void 여러_개의_숫자를_입력_했을_경우(){
        assertThat(15).isEqualTo(stringAdd.add("5,4,3,2,1"));
    }

    @Test
    public void 커스텀_구분자를_입력_했을_경우(){
        assertThat(6).isEqualTo(stringAdd.add("//;\\n1;2;3"));
    }

}