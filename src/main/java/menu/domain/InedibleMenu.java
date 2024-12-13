package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.util.Exception;

public class InedibleMenu {
    private List<String> menus = new ArrayList<>();

    public InedibleMenu() {
    }

    public boolean isEdibleMenu(String menu) {
        if (menus.contains(menu)) {
            return true;
        }
        return false;
    }

    public void setEdibleMenu(List<String> menus) {
        if (!(menus.size() == 1 && menus.get(0).equals(""))) {
            validateMenuAmount(menus);
            validateInedibleMenu(menus);
        }
        this.menus = menus;
    }

    private void validateMenuAmount(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException(Exception.ERROR + Exception.INEDIBLE_MENU_AMOUNT_OVER_RANGE);
        }
    }

    private void validateInedibleMenu(List<String> menus) {
        for (String menu : menus) {
            if (!Menu.isInMenu(menu)) {
                throw new IllegalArgumentException(Exception.ERROR + Exception.NOT_EXIST_MENU);
            }
        }
    }
}
