package calculator.utils;

import calculator.domain.Candidate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void 후보_존재_O() {
        //given
        List<Candidate> list = new ArrayList<>();
        list.add(new Candidate("1"));
        list.add(new Candidate("2"));

        //when
        List<Integer> result = Converter.candidateToInt(list);

        //then
        Assertions.assertThat(result).contains(1, 2);
    }

    @Test
    void 후보_존재_X_빈리스트_반환() {
        //given
        List<Candidate> list = new ArrayList<>();

        //when
        List<Integer> result = Converter.candidateToInt(list);

        //then
        Assertions.assertThat(result.size()).isEqualTo(0);
    }
}
