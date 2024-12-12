package menu.service;

import menu.domain.Menu;
import menu.domain.Recommendation;

public class RecommendationService {
    private Recommendation recommendation;

    public RecommendationService(Recommendation recommendation) {
        this.recommendation = recommendation;
    }

    public void recommendationMenu() {
        while (!recommendation.isCompleteRecommendation()) {
            recommendationOneCycle();
        }
    }

    private void recommendationOneCycle() {
        String category = randomCategory();
        recommendation.addRecommendMenu(category);
    }

    private String randomCategory() {
        while (true) {
            try {
                String category = Menu.randomCategory();
                recommendation.addCategory(category);
                return category;
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
