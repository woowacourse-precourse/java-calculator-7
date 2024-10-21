package calculator;

public class StringSplitter {
	// 입력 문자열을 구분자를 통해 분리하는 메서드
    public String[] split(String input, String delimiters) {
    	// 구분자를 정규식 패턴으로 감싸서 여러 구분자를 처리할 수 있도록 함
    	String regex = "[" + delimiters + "]";
    	String withoutDelimiters = input.replaceAll(regex, "");
    	
    	if(withoutDelimiters.trim().isEmpty())
    		throw new IllegalArgumentException("유효한 숫자가 포함되어 있지 않습니다.");
    	
    	String[] tokens = input.split(delimiters, -1);
    	
    	for(String token : tokens) {
    		if (token.trim().isEmpty()) {
    			throw new IllegalArgumentException("빈 문자열 또는 공백이 포함되어 있습니다.");
    		}
    	}
    	// 유요한 문자열 배열 반환
        return tokens;
    }
}
