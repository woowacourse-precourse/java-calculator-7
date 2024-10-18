package calculator.model;

import calculator.domain.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ExtractorTest {
    Storage storage;
    Extractor extractor;

    @BeforeEach
    void init() {
        storage = new Storage();
        extractor = new Extractor();
    }

    @Test
    void 커스텀구분자_X_숫자추출() {
        //given
        String input = "1,2:3";
        List<String> expectedList = Arrays.asList("1", "2", "3");
        List<String> resultList = new ArrayList<>();

        //when
        extractor.execute(input, storage);
        for (Candidate c : storage.getNumberCandidates()) {
            resultList.add(c.getCandidate());
        }

        //then
        assertThat(resultList).containsAll(expectedList);
    }

    @Test
    void 커스텀구분자_O_커스텀구분자가한개() {
        //given
        String input = "//-\\n1,2:3-4";
        List<String> expectedList = Arrays.asList("1", "2", "3", "4");
        List<String> resultList = new ArrayList<>();

        //when
        extractor.execute(input, storage);
        for (Candidate c : storage.getNumberCandidates()) {
            resultList.add(c.getCandidate());
        }

        //then
        assertThat(resultList).containsAll(expectedList);
    }

    @Test
    void 커스텀구분자_O_커스텀구분자가여러개() {
        //given
        String input = "//-\\n//=\\n1,2:3-4=5";
        List<String> expectedList = Arrays.asList("1", "2", "3", "4", "5");
        List<String> resultList = new ArrayList<>();

        //when
        extractor.execute(input, storage);
        for (Candidate c : storage.getNumberCandidates()) {
            resultList.add(c.getCandidate());
        }

        //then
        assertThat(resultList).containsAll(expectedList);
    }

    @Test
    void 커스텀구분자_O_구분자선언이끝나지않음() {
        //given
        String input = "//-1,2:3-4";

        //when

        //then
        assertThatThrownBy(() -> extractor.execute(input, storage))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀구분자_O_구분자가존재하지않음() {
        //given
        String input = "//\\n1,2:3-4";

        //when

        //then
        assertThatThrownBy(() -> extractor.execute(input, storage))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

