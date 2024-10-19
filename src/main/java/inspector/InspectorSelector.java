package inspector;

public class InspectorSelector { //팩토리 패턴
    public static ContentInspector selection(String originalContent) {
        if (originalContent.startsWith("/")) {
            return new CustomInspector(originalContent);
        } else {
            return new DefaultInspector(originalContent);
        }
    }
}
