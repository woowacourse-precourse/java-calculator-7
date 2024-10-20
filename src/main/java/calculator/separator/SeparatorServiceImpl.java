package calculator.separator;



/**
 * SeparatorService 인터페이스의 구현체
 * 커스텀 구분자 확인 및 문자열 분리를 위한 메서드를 구현합니다.
 */
public class SeparatorServiceImpl implements SeparatorService{

    // 기본 구분자 배열 (쉼표와 콜론을 기본 구분자로 설정)
    private static final String DEFAULT_SEPARATOR = ",|:";

    // 정규 표현식에서 사용하는 메타 문자 목록 (특수 문자를 구분자로 사용할 경우 이스케이프 처리를 위해 사용)
    private static final String META_CHARACTERS = "[](){}.*+?^$|\\";

    @Override
    public boolean checkCustomSeparator(String input) {
        return false;
    }

    @Override
    public String getSeparator(String input) {
        return null;
    }

    @Override
    public String[] splitBySeparator(String input, String separator) {
        return new String[0];
    }


}
