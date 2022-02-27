package homeWork3;

import com.test.homework1.Book;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class BookJava implements IPublicationJava {
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
        int var1 = this.getWordCount();
        String var10000;
        if (1 <= var1) {
            if (1000 >= var1) {
                var10000 = "Flash Fiction";
                return var10000;
            }
        }

        if (1001 <= var1) {
            if (7500 >= var1) {
                var10000 = "Short Story";
                return var10000;
            }
        }

        var10000 = "Novel";
        return var10000;
    }

    public BookJava(double price, int wordCount) {
        this.price = price;
        this.wordCount = wordCount;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Book &&
                ((Book)other).getPrice() == this.getPrice() &&
                ((Book)other).getWordCount() == this.getWordCount();
    }
}
