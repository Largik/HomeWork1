package homeWork3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;

public final class MainJava {
    @NotNull
    private static final AuthCallbackJava authCallback = (new AuthCallbackJava() {
        public void authSuccess() {
            String var1 = "Пользователь успешно авторизован!";
            System.out.println(var1);
        }

        public void authFailed() {
            String var1 = "Пользователь не прошел авторизацию!";
            System.out.println(var1);
        }
    });

    public static void buy(IPublicationJava publication) {
        if (publication != null) {
            double price = publication.getPrice() * 100.0D;
            String var6 = "The purchase is complete. The purchase amount was " + (double) MathKt.roundToInt(price) / 100.0D + '\n';
            System.out.println(var6);
        }
    }

    @NotNull
    public static AuthCallbackJava getAuthCallback() {
        return authCallback;
    }


    public static void auth(@NotNull Runnable updateCache, @NotNull UserJava userJava) throws Throwable {
        Intrinsics.checkNotNullParameter(updateCache, "updateCache");
        Intrinsics.checkNotNullParameter(userJava, "userJava");

        try {
            UserJava.ageCheck(userJava);
            getAuthCallback().authSuccess();
            updateCache.run();
        } catch (Exception var4) {
            getAuthCallback().authFailed();
            updateCache.run();
            throw var4;
        }
    }

    public void doAction(@NotNull ActionJava action) throws Throwable {
        Intrinsics.checkNotNullParameter(action, "action");
        String var2;
        if (action instanceof ActionJava.Registration) {
            var2 = "Регистрация прошла успешно!\n";
            System.out.println(var2);
        } else if (action instanceof ActionJava.Login) {
            var2 = "Пользователь вошел!\n";
            System.out.println(var2);
            UserJava userJava$iv = ((ActionJava.Login) action).getUser();

            auth(this::updateCache, userJava$iv);
        } else if (action instanceof ActionJava.Logout) {
            var2 = "Пользователь вышел!\n";
            System.out.println(var2);
        }

    }

    public void updateCache() {
        System.out.println("Кэш обновлен!\n");
    }

    // $FF: synthetic method
    public void main(String[] var0) {

        BookJava book1 = new BookJava(Random.Default.nextDouble(10.01D, 5000.01D), Random.Default.nextInt(50, 14000));
        book1.formattedPrint();

        BookJava book2 = new BookJava(Random.Default.nextDouble(10.01D, 5000.01D), Random.Default.nextInt(50, 14000));
        book2.formattedPrint();

        MagazineJava magazine = new MagazineJava(Random.Default.nextDouble(10.01D, 500.01D), Random.Default.nextInt(50, 1400));
        magazine.formattedPrint();


        System.out.println(book1.equals(book2));
        System.out.println(book1 == book2);

        BookJava bookNull = null;
        buy(book1);
        buy(bookNull);


        int x = Random.Default.nextInt(1, 1000);
        int y = Random.Default.nextInt(1, 1000);
        Operational sum = (num1, num2) -> x + y;
        String var7 = "Сумма произвольных чисел " + x + " и " + y + ": " + (sum.calculate(x, y)) + '\n';
        System.out.println(var7);

        System.out.println("\n-------------------------------------------\n\n");


        UserJava userJava1 = new UserJava(1, "first user", 20, TypeJava.FULL);

        try {
            String var8 = "Создан пользователь: " + userJava1.getStartTime();
            System.out.println(var8);

            Thread.sleep(1000L);

            var8 = "После ожидания: " + userJava1.getStartTime() + '\n';
            System.out.println(var8);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<UserJava> users = new ArrayList<>();

        users.add(new UserJava(2, "second user", 17, TypeJava.DEMO));
        users.add(new UserJava(3, "third user", 21, TypeJava.FULL));
        users.add(new UserJava(4, "fourth user", 15, TypeJava.DEMO));

        String var9 = "Список пользователей: \n";
        System.out.println(var9);
        for (UserJava item : users) {
            System.out.println(item);
        }

        LinkedList<String> usersName = users.stream()
                .map(UserJava::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("\nПервый пользователь: " + usersName.getFirst() + ";\n");
        System.out.println("Последний пользователь: " + usersName.getLast() + ".\n");

        try {
            doAction(new ActionJava.Registration());
            doAction(new ActionJava.Login(userJava1));
            doAction(new ActionJava.Logout());
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }
}

interface Operational {
    int calculate(int x, int y);
}
