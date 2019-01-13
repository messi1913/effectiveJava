package study.effectivejava.item2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor  @NoArgsConstructor
public class NutritionFacts {

    @Builder.Default private int servingSize = 10;
    private int calories;
    private int sodium;
    private int carbohydrate;

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = NutritionFacts.builder()
                .calories(100)
                .carbohydrate(10)
                .sodium(10)
                .build();


        System.out.println(nutritionFacts.calories);

    }
}
