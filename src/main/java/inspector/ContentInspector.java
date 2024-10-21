package inspector;

import static exceptHandler.ExceptHandler.detectContentForamt;

public abstract class ContentInspector {

    //문자열을 검사하는 메서드
    protected void inspecting(String separator, String content) {
        String contentRegex = getContentRegex(separator);
        detectContentForamt(contentRegex, content); //정규 표현식을 통해 문자열에 잘못된 구분자가 있는 지 검사함.
    }

    //구분자를 정규 표현식 형태로 바꾸는 메서드
    private String getContentRegex(String parsingSeparator) {
        return "^(" + parsingSeparator + "|[0-9])*$";
    }

    public abstract String getSeparator();

    public abstract String getConvertedContent();
}
