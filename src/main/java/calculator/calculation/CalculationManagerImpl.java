package calculator.calculation;

import calculator.repository.number.NumberRepository;
import calculator.repository.separator.SeparatorRepository;

import java.util.List;

/**
 * 계산과 관련된 객체
 */
public class CalculationManagerImpl implements CalculationManager {

    private final NumberRepository numberRepository;

    public CalculationManagerImpl(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    /**
     * 숫자 리포지토리에 값을 꺼내와 덧셈을 한다
     * @return 덧셈의 결과
     */
    @Override
    public int doAdd() {
        List<Integer> numberList = numberRepository.getNumbers();

        return numberList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
