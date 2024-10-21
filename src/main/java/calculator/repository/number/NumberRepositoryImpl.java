package calculator.repository.number;

import calculator.repository.separator.SeparatorRepository;
import calculator.repository.separator.SeparatorRepositoryImpl;
import calculator.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자와 관련된 리포지토리
 *
 * 숫자의 저장과 관리를 맡음
 */
public class NumberRepositoryImpl implements NumberRepository {

    /**
     * 싱글톤 객체
     */
    private static NumberRepository instance;

    private final List<Integer> numbers = new ArrayList<>();

    private final SeparatorRepository separatorRepository;

    /**
     * 외부의 생성자 호출을 막음
     * 외부에서는 getInstance을 통해 접근해야함
     *
     * SeparatorRepository가 필요하기 때문에 생성자에서 초기화
     */
    private NumberRepositoryImpl(SeparatorRepository separatorRepository) {
        this.separatorRepository = separatorRepository;
    };

    /**
     * 숫자의 모음을 리스트로 반환
     * @return 숫자의 모음을 리스트로 반환
     */
    @Override
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    /**
     * 숫자 문자열에서 구분자를 기준으로 숫자를 분리하고 저장한다
     *
     * @param numberIncludeSeparator 구분자를 포함한 문자열 형태의 숫자
     */
    @Override
    public void saveNumbers(final String numberIncludeSeparator) {
        List<Character> separators = separatorRepository.getSeparators();

        List<Integer> numberList = NumberUtils.parseNumbers(numberIncludeSeparator, separators);

        //저장소에 저장
        numbers.addAll(numberList);
    }

    /**
     * 싱글톤 객체 반환
     *
     * @param separatorRepository
     * instance가 초기화 되지 않았다면 separatorRepository를 이용해 초기화
     * instance가 이미 초기화되었다면 separatorRepository를 사용하지 않음
     *
     * @return NumberRepositoryImpl에 대한 싱글톤 객체 반환
     */
    public static NumberRepository getInstance(SeparatorRepository separatorRepository) {
        if(instance == null) {
            instance = new NumberRepositoryImpl(separatorRepository);
        }
        return instance;
    }

    /**
     * TEST를 위한 clear메서드
     */
    public void clearAll() {
        numbers.clear();
    }
}
