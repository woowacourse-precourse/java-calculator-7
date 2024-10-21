package inspector;

public class InspectorSelector { //문자열의 시작 문자에 따라 다른 클래스를 호출하는 팩토리 패턴
    public static ContentInspector selection(String originalContent) {
        //커스텀 구분자를 구분하기 위해서 맨 앞의 문자를 비교하여 다른 클래스를 호출한다.
        if (originalContent.startsWith("/")) {
            return new CustomInspector(originalContent);
        } else {
            return new DefaultInspector(originalContent);
        }
    }
}
