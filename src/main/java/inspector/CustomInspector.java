package inspector;

import static exceptHandler.ExceptHandler.detectCustomSeparatorFormat;

import java.util.regex.Pattern;

public class CustomInspector extends ContentInspector {
    protected String originalContent; //원래 입력받은 문자열
    private String convertedContent; //커스텀 구분자를 위한 구문을 제거한 이후의 문자열
    private String separator = ",|:";

    public CustomInspector(String originalContent) {
        this.originalContent = originalContent;
        findCustomSeparator();
    }

    //커스텀 구분자를 추가하기 위한 메서드
    private void findCustomSeparator() {
        String separatorPrefix = originalContent.substring(0, 2); //커스텀 구분자를 추가하는 구문의 접두어 '//'를 추출
        String separatorSuffix = originalContent.substring(3, 5); //커스텀 구분자를 추가하는 구문의 접사어 '\n'을 추출
        detectCustomSeparatorFormat(separatorPrefix, separatorSuffix); // 두 구분자의 형식이 맞는지 검사
        separatorRegistration(); //커스텀 구분자를 맞게 추출했다면, 이를 구분자에 추가하기 위한 메서드 호출
        convertedContent = convertContentFromOriginal(originalContent);
        inspecting(separator, convertedContent);
    }


    private void separatorRegistration() {
        String addendsSeparator = Pattern.quote(originalContent.substring(2, 3));
        separator = separator.concat("|" + addendsSeparator); //concat은 String 라이브러리의 문자열을 합치는 메서드이다.
    }

    private String convertContentFromOriginal(String originalContent) {
        return originalContent.substring(5); //커스텀 구분자를 위한 구문 뒤의 인덱스는 5로 시작하기에 substring메서드로 자름.
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public String getConvertedContent() {
        return convertedContent;
    }
}
