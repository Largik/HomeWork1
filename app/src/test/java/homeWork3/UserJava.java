package homeWork3;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class UserJava {
    @NotNull
    private final Lazy startTime$delegate;
    private final int id;
    @NotNull
    private final String name;
    private final int age;
    @NotNull
    private final TypeJava type;

    @NotNull
    public final String getStartTime() {
        Lazy var1 = this.startTime$delegate;
        Object var3 = null;
        return (String)var1.getValue();
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getAge() {
        return this.age;
    }

    @NotNull
    public final TypeJava getType() {
        return this.type;
    }

    public static void ageCheck(@NotNull UserJava $this$ageCheck) throws Throwable {
        Intrinsics.checkNotNullParameter($this$ageCheck, "$this$ageCheck");
        if ($this$ageCheck.getAge() < 19) {
            throw new Exception("Error!!!! \n Пользователь " + $this$ageCheck.getName() + " по id(" + $this$ageCheck.getId() + ") не старше 18 лет(" + $this$ageCheck.getAge() + ')');
        }
    }

    public UserJava(int id, @NotNull String name, int age, @NotNull TypeJava type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.startTime$delegate = LazyKt.lazy((Function0)null);
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.age;
    }

    @NotNull
    public final TypeJava component4() {
        return this.type;
    }

    @NotNull
    public final UserJava copy(int id, @NotNull String name, int age, @NotNull TypeJava type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new UserJava(id, name, age, type);
    }

    // $FF: synthetic method
    public static UserJava copy$default(UserJava var0, int var1, String var2, int var3, TypeJava var4, int var5, Object var6) {
        if ((var5 & 1) != 0) {
            var1 = var0.id;
        }

        if ((var5 & 2) != 0) {
            var2 = var0.name;
        }

        if ((var5 & 4) != 0) {
            var3 = var0.age;
        }

        if ((var5 & 8) != 0) {
            var4 = var0.type;
        }

        return var0.copy(var1, var2, var3, var4);
    }

    @NotNull
    public String toString() {
        return "UserJava(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", type=" + this.type + ")";
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int hashCode() {
        int var10000 = Integer.hashCode(this.id) * 31;
        String var10001 = this.name;
        var10000 = ((var10000 + (var10001 != null ? var10001.hashCode() : 0)) * 31 + Integer.hashCode(this.age)) * 31;
        TypeJava var1 = this.type;
        return var10000 + (var1 != null ? var1.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof UserJava) {
                UserJava var2 = (UserJava)var1;
                if (this.id == var2.id && Intrinsics.areEqual(this.name, var2.name) && this.age == var2.age && Intrinsics.areEqual(this.type, var2.type)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
