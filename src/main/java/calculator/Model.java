package calculator;

//model class
public class Model {
	
	//user의 input이 커스텀구분자인지 아닌지 확인해주는 boolean 반환 메서드
	public boolean isCustomSeperator(String inputData) {
		return (inputData.startsWith("//")&&inputData.contains("\\n"));
	}
		
	//isCustomSeperator가 true면 calculateCustom 실행, 아니면 calculateNormal 실행하여 answer 반환
	public int RunCalculator(String inputData) {
		int answer;
		if (isCustomSeperator(inputData)) {
			answer = calculateCustom(inputData);
		}
		else {
			answer = calculateNormal(inputData);
		}
		return answer;
	}
	
	
	//커스텀 구분자가 있다고 했을 때 연산 
	public int calculateCustom(String inputData) {
		int answer = 0;
		int findIdx = inputData.indexOf("\\n");
		String Divide = inputData.substring(2,findIdx);
		
		try {
			int int_Divide = Integer.parseInt(Divide);
			throw new IllegalArgumentException("잘못된 형식입니다.(구분자는 숫자 대신 문자로 설정해야 합니다.)");
		}
		catch (NumberFormatException e) {
		}
		
		String[] StrArr_Custom;
		try{
			String Str_Custom = inputData.substring(findIdx+2);
			StrArr_Custom = Str_Custom.split(java.util.regex.Pattern.quote(Divide));
		}
		catch(java.util.regex.PatternSyntaxException e) {
			throw new IllegalArgumentException("잘못된 형식입니다(커스텀 구분자 입력 가이드를 다시 확인하세요.)");
		};
		for (String s:StrArr_Custom) {
			if (s.isEmpty()) {
				s = "0";
			}
			int int_s;
			try {
				int_s = Integer.parseInt(s);
			}
			catch(NumberFormatException e) {
				throw new IllegalArgumentException("잘못된 형식입니다.(문자 대신 양수를 입력하세요)");
			}
			if (int_s < 0) {
				throw new IllegalArgumentException("잘못된 형식입니다.(음수 대신 양수를 입력하세요)");
			}
			answer += int_s;
		}
		return answer;
	}
	
	//커스텀 구분자가 없을 때 연산
	public int calculateNormal(String inputData) {
		int answer = 0;
		String[] StrArr_Normal = inputData.split(",|:");
		
		for (String s:StrArr_Normal) {
			if (s.isEmpty()) {
				s = "0";
			}
			int int_s;
			try {
				int_s = Integer.parseInt(s);
			}
			catch(NumberFormatException e) {
				throw new IllegalArgumentException("잘못된 형식입니다.(문자 대신 양수를 입력하세요)");
			}
			if (int_s < 0) {
				throw new IllegalArgumentException("잘못된 형식입니다.(음수 대신 양수를 입력하세요)");
			}
			answer += int_s;
		}
		return answer;
	}

}
