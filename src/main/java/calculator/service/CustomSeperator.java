package calculator.service;

import static calculator.global.Seperator.CUSTOM;

public class CustomSeperator {
    private int custom_start_index = -1;
    private int custom_last_index = -1;

    public void updateCustomSeperator(String input) {

        getCustomSeperatorIndex(input);

        if (existCustomSeperator()) {
            String customSeperator = input.substring(custom_start_index, custom_last_index);
            CUSTOM.updateCustomSeperator(customSeperator);
        }
    }

    private void getCustomSeperatorIndex(String input) {
        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == '/' && input.charAt(i + 1) == '/') {
                this.custom_start_index = i + 2;
            }

            if (input.charAt(i) == '\\' && input.charAt(i + 1) == 'n') {
                this.custom_last_index = i;
            }
        }
    }

    private boolean existCustomSeperator() {

        if (this.custom_start_index != -1 && this.custom_last_index != -1) {
            return true;
        }
        return false;
    }
}
