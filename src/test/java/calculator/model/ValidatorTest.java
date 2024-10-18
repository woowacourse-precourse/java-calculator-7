package calculator.model;

import calculator.domain.Candidate;
import calculator.domain.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    Validator validator;
    Storage storage;

    @BeforeEach
    void init() {
        validator = new Validator();
        storage = new Storage();
    }

    @Test
    void 입력_예외_발생_X_숫자() {
        //given
        String input = "1,2:3";
        List<Candidate> candidates = storage.getNumberCandidates();

        //when

        //then
        assertThatCode(() -> validator.execute(input, candidates))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력_예외_발생_X_커스텀구분자() {
        //given
        String input = "//=\\n1,2:3";
        List<Candidate> candidates = storage.getNumberCandidates();

        //when

        //then
        assertThatCode(() -> validator.execute(input, candidates))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력_예외_발생_O_문자로시작() {
        //given
        String input = "=1,2:3";
        List<Candidate> candidates = storage.getNumberCandidates();

        //when

        //then
        assertThatThrownBy(() -> validator.execute(input, candidates))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_예외_발생_X() {
        //given
        String input = "1,2";
        List<Candidate> candidates = storage.getNumberCandidates();
        candidates.add(new Candidate("1"));
        candidates.add(new Candidate("2"));

        //when

        //then
        assertThatCode(() -> validator.execute(input, candidates))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자_예외_발생_O_음수포함() {
        //given
        String input = "1,2";
        List<Candidate> candidates = storage.getNumberCandidates();
        candidates.add(new Candidate("-1"));
        candidates.add(new Candidate("2"));

        //when

        //then
        assertThatThrownBy(() -> validator.execute(input, candidates))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_예외_발생_O_문자포함() {
        //given
        String input = "1,2";
        List<Candidate> candidates = storage.getNumberCandidates();
        candidates.add(new Candidate("=1+"));
        candidates.add(new Candidate("2"));

        //when

        //then
        assertThatThrownBy(() -> validator.execute(input, candidates))
                .isInstanceOf(IllegalArgumentException.class);
    }
}