package calculator.repository.separator;

import calculator.utils.SeparatorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 구분자와 관련된 리포지토리
 *
 * 구분자의 저장과 관리를 맡음
 * 싱글톤으로 설계됨
 */
public class SeparatorRepositoryImpl implements SeparatorRepository {

    /**
     * 싱글톤 객체
     */
    private static final SeparatorRepository instance = new SeparatorRepositoryImpl();

    private final List<Character> separators = new ArrayList<>();

    /**
     * 외부의 생성자 호출을 막음
     * 외부에서는 getInstance을 통해 접근해야함
     */
    private SeparatorRepositoryImpl() {};

    /**
     * 구분자의 모음을 리스트로 반환
     *
     * @return 구분자의 모음을 리스트로 반환
     */
    @Override
    public List<Character> getSeparators() {
        return new ArrayList<>(separators);
    }

    /**
     *구분자를 포함한 줄을 입력 받아 저장
     * 검증 기능을 사용하여 올바른 형식인지 확인
     *
     * @param separatorLine //를 포함한 전체 줄 입력을 받는다
     */
    @Override
    public void saveSeparator(final String separatorLine) {
        String separator = SeparatorUtils.removePrefixAndPostfix(separatorLine);
        char separatorChar = SeparatorUtils.StringToChar(separator);

        separators.add(separatorChar);
    }

    /**
     * 싱글톤 객체 반환
     *
     * @return SeparatorRepositoryImpl에 대한 싱글톤 객체 반환
     */
    public static SeparatorRepository getInstance() {
        return instance;
    }

    /**
     * TEST를 위한 clear메서드
     */
    @Override
    public void clearAll() {
        separators.clear();
    }
}