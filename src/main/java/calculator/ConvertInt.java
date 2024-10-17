package calculator;
public class ConvertInt {
	public static int convertInt(String num)
	{
		try {
			return Integer.parseInt(num); // 문자열을 int로 변환
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 입력");
		}
		/*
		 * 24.10.18
		 * MAX_INT 를 넘는 값에서 오버플로우 발생 확인 수정 또는 직접 구현 필요해보임
		 */
	}
}
