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

    // 커스텀 구분자가 위치하는 인덱스 (커스텀 구분자는 입력 문자열에서 세 번째 위치에 있음)
    private static final int INDEX_OF_CUSTOM_SEPARATOR = 2;

    // 커스텀 구분자를 등록하는 헤더의 길이
    private static final int LENGTH_OF_CUSTOM_SEPARATOR_HEADER = 5;


    /**
     * 입력에서 커스텀 구분자가 있는지 확인합니다.
     * @param input 사용자 입력 문자열
     * @return 커스텀 구분자가 있는 경우 true, 그렇지 않으면 false
     */
    @Override
    public boolean checkCustomSeparator(String input) {
        if(input.length() < LENGTH_OF_CUSTOM_SEPARATOR_HEADER){
            return false;
        }
        if (!input.startsWith("//")){
            return false;
        }
        if (!input.startsWith("\\n",INDEX_OF_CUSTOM_SEPARATOR+1)){
            return false;
        }
        return true;
    }

    /**
     * 커스텀 구분자를 반환합니다.
     * @param input 사용자 입력 문자열
     * @return 커스텀 구분자 또는 기본 구분자 반환
     */
    @Override
    public String getSeparator(String input) {
        String separator = DEFAULT_SEPARATOR;

        if (checkCustomSeparator(input)) {
            char customSeparator = input.charAt(INDEX_OF_CUSTOM_SEPARATOR);
            if (META_CHARACTERS.indexOf(customSeparator) < 0) {
                separator = DEFAULT_SEPARATOR + "|" + customSeparator;
            } else {
                separator = DEFAULT_SEPARATOR + "|" + "\\" + customSeparator;
            }
        }
        return separator;
    }

    /**
     * 구분자를 기준으로 문자열을 분리합니다.
     * @param input 사용자 입력 문자열
     * @param separator 구분자
     * @return 구분자로 분리된 문자열 배열
     */
    @Override
    public String[] splitBySeparator(String input, String separator) {
        try {
            return input.split(separator);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }
}
