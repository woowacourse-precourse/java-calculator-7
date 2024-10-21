package parser;

public class ContentParser {
    private String separator;

    public ContentParser(String separator) {
        this.separator = separator;
    }

    public String[] parse(String targetContent) {
        return targetContent.split(separator); //split은 정규 표현식을 통해 문자열을 배열로 나누는 String 라이브러리의 메서드이다.
    }
}
