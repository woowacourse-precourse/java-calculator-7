package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 입력 문자열에서 커스텀 구분자를 추출해 숫자를 분리하는 클래스입니다.
 * <br>기본적으로 입력 문자열에서 구분자 사이의 빈 공간도 0으로 포함시키도록 구분합니다.
 */
public class NumbersParser {
    
    private static final Pattern areaDividePattern = Pattern.compile("^(?://([^0-9]*)\\\\n)?(.*)");
    private String separatorArea = null;
    private String numberArea = null;

    static final String defaultSeparators = ",:";
    private HashSet<Character> separatorSet = null;
    private int[] numbers;
    
    /**
     * 입력 문자열에서 커스텀 구분자를 추출해 숫자를 분리하는 클래스입니다.
     * <br>기본적으로 입력 문자열에서 구분자 사이의 빈 공간도 0으로 포함시키도록 구분합니다.
     * @param input 커스텀 구분자를 포함한 입력 문자열입니다.
     * @exception IllegalArgumentException 입력 문자열이 null 이거나, 커스텀 구분자 서식이 잘못되었거나,
     * 커스텀 구분자로 등록되지 않은 문자가 사용되는 경우 발생합니다.
     */
    public NumbersParser(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        setAreaByPattern(input);
        separatorSet = parseSeparator(defaultSeparators + separatorArea);
        numbers = parseNumber(separatorSet, numberArea);
    }
    
    private void setAreaByPattern(String input) {
        Matcher matchResult = areaDividePattern.matcher(input);
        if (!matchResult.matches()) {
            throw new IllegalArgumentException();
        }
        
        separatorArea = (matchResult.group(1) == null ? "" : matchResult.group(1)); 
        numberArea = (matchResult.group(2) == null ? "" : matchResult.group(2));
    }
    
    private HashSet<Character> parseSeparator(String separators) {
        separatorSet = new HashSet<Character>(separators.length());
        
        for (int i = 0; i < separators.length(); i++) {
            separatorSet.add(separators.charAt(i));
        }
        
        return separatorSet;
    }
    
    private int[] parseNumber(HashSet<Character> separatorSet, String input) {
        int num = 0;
        List<Integer> numList = new ArrayList<Integer>(20);
        
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                num = 10*num + Character.digit(input.charAt(i), 10);
            }
            else if (separatorSet.contains(input.charAt(i))) {
                numList.add(num);
                num = 0;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        numList.add(num);
        
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }
        return result;
    }
    
    /**
     * 구분자로 분리된 숫자 배열을 반환합니다.
     * <br>기본적으로 입력 문자열에서 구분자 사이의 빈 공간도 0으로 포함시키도록 구분합니다.
     * @return 구분자로 분리된 숫자들의 배열
     */
    public int[] getNumbers() {
        return numbers.clone();
    }
}
