package inspector;

import static exceptHandler.ExceptHandler.detectCustomSeparatorFormat;

import java.util.regex.Pattern;

public class CustomInspector extends ContentInspector {
    protected String originalContent;
    private String convertedContent;
    private String separator = ",|:";

    public CustomInspector(String originalContent) {
        this.originalContent = originalContent;
        findCustomSeparator();
    }

    private void findCustomSeparator() {
        String separatorPrefix = originalContent.substring(0, 2);
        String separatorSuffix = originalContent.substring(3, 5);
        detectCustomSeparatorFormat(separatorPrefix, separatorSuffix);
        separatorRegistration();
        convertedContent = convertContentFromOriginal(originalContent);
        inspecting(separator, convertedContent);
    }


    private void separatorRegistration() {
        String addendsSeparator = Pattern.quote(originalContent.substring(2, 3));
        separator = separator.concat("|" + addendsSeparator);
    }

    private String convertContentFromOriginal(String originalContent) {
        return originalContent.substring(5);
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
