package calculator.repository.number;

import calculator.Constants;
import calculator.repository.separator.SeparatorRepository;
import calculator.repository.separator.SeparatorRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumberRepositoryTest {

    private final SeparatorRepository separatorRepository = SeparatorRepositoryImpl.getInstance();
    private final NumberRepository numberRepository = NumberRepositoryImpl.getInstance(separatorRepository);


    public NumberRepositoryTest() {
        separatorRepository.clearAll();
        //기본 구분자 추가
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_1);
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_2);
    }

    @BeforeEach
    void setUp() {
        numberRepository.clearAll();
    }

    /**
     * NumbersUtilsTest에서 자세한 단위테스트를 진행함
     * NumberRepository에 정상적으로 저장되는지 확인하는 통합테스트
     */
    @Test
    void 숫자가_정상적으로_저장되는가() {
        String number1 = "55:";
        String number2 = "55:4";
        String number3 = "3";

        List<Integer> expected = List.of(55,0,55,4,3);

        numberRepository.saveNumbers(number1);
        numberRepository.saveNumbers(number2);
        numberRepository.saveNumbers(number3);

        List<Integer> numberList = numberRepository.getNumbers();

        Assertions.assertEquals(numberList.size(), 5);
        Assertions.assertEquals(expected, numberList);
    }
}
