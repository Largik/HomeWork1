package homeWork3;

import kotlin.math.MathKt;

public interface IPublicationJava {
    double getPrice();

    int getWordCount();

    String getType();

    default void formattedPrint() {
        String var1 = "-----------------------------------\n"
                + "Тип: " + this.getType() + "; \n"
                + "Количество слов: " + this.getWordCount() + "; \n"
                + "Цена: " + (double) MathKt.roundToInt(this.getPrice() * 100.0D) / 100.0D + " руб. \n"
                + "-----------------------------------\n";
        System.out.println(var1);
    }
}
