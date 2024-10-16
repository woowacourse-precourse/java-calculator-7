package calculator;

public class Helper {
    public Helper() {
        System.out.println("- 더할 숫자를 기본 구분자 ',' 또는 ':' 를 사이에 넣어 입력해주세요");
        System.out.println("  ex) 입력: 3:3 or 3,3 or 1,2:3");
        System.out.println("      출력: 6\n");
        System.out.println("- 기본 구분자 외 커스텀 구분자의 등록이 가능하며 1개까지 저장됩니다.");
        System.out.println("  최초 입력과 변경은 //구분자\\n의 형식으로 입력합니다.");
        System.out.println("  ex) 커스텀 구분자'\\' 등록");
        System.out.println("      입력: //\\\\n3\\2\\4");
        System.out.println("      출력: 9\n");
        System.out.println("- 커스텀 구분자는 '.', '-(마이너스)', 공백 입력은 불가능합니다.");
    }
}
