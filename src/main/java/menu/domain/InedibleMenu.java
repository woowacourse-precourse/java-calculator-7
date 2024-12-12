package menu.domain;

import java.util.List;
import menu.util.Exception;

public class InedibleMenu {
    private List<String> menus;

    public InedibleMenu(List<String> menus) {
        validateMenuAmount(menus);
        this.menus = menus;
    }

    private void validateMenuAmount(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.INEDIBLE_MENU_AMOUNT_OVER_RANGE);
        }
    }
}
