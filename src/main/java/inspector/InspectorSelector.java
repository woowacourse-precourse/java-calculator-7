package inspector;

public class InspectorSelector { //팩토리 패턴
    public static ContentInspector selection(String inputContent) {
        if (inputContent.startsWith("/")) {
            return new CustomInspector(inputContent);
        } else {
            return new DefaultInspector(inputContent);
        }
    }
}
