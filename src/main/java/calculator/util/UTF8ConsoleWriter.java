package calculator.util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/*
 * intelli j 한글 깨짐 현상에 대해
 * 검색으로 찾아볼 수 있는 방법으로 시도해봤으나 해결이 되지않았습니다.
 * 시도 방법으로는 파일 인코딩, VM Option 설정, JDK 재설치 등..
 * JAVA 18 이후 전체적으로 UTF-8이 기본 문자셋이 되었지만 System.IO 부분은 예외가 된 것이 원인인가 생각이 됩니다.
 * 현재로서는 이 방법으로 밖에 해결이 되지않아 해당 클래스를 과제에 포함하게 되었습니다.
 * 해당 내용 관련해서 피드백 주시면 많이 배울 수 있을 것 같습니다.
 */
public class UTF8ConsoleWriter {

	private UTF8ConsoleWriter() {
	}

	private static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8),
		true);

	public static void print(String s) {
		out.print(s);
	}

	public static void println(String s) {
		out.println(s);
	}

	public static void flush() {
		out.flush();
	}
}
