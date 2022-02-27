package homeWork3;

import org.jetbrains.annotations.NotNull;

public class MagazineJava implements IPublicationJava {
    private final double price;
    private final int wordCount;

    public double getPrice() {
        return this.price;
    }
    public int getWordCount() {
        return this.wordCount;
    }

    @NotNull
    public String getType() {
        return "Magazine";
    }

    public MagazineJava(double price, int wordCount) {
        this.price = price;
        this.wordCount = wordCount;
    }
}
