package menu.service;

import menu.domain.Category;
import menu.domain.Recommend;

public class RecommendService {
    public void recommendMenu(Recommend recommend) {
        String category = Category.randomCategory();
        if (recommend.isCategoryAmountOverThree(category)) {
            return;
        }
        recommend.addCategory(category);
        for (String coach : recommend.getCoach()) {
            String menu = null;
            while (true) {
                menu = Category.recommendMenu(category);
                if (!recommend.getInedible().get(coach).contains(menu)) {
                    break;
                }
            }
            recommend.getInedible().get(coach).add(menu);
        }
    }
}
