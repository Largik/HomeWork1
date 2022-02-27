package homeWork3;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class ActionJava {
    private ActionJava() {
    }

    // $FF: synthetic method
    public ActionJava(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Registration extends ActionJava {
        @NotNull
        public static final Registration INSTANCE;

        public Registration() {
            super(null);
        }

        static {
            ActionJava.Registration var0 = new ActionJava.Registration();
            INSTANCE = var0;
        }
    }

    public static final class Login extends ActionJava {
        @NotNull
        private final UserJava userJava;

        @NotNull
        public UserJava getUser() {
            return this.userJava;
        }

        public Login(@NotNull UserJava userJava) {
            Intrinsics.checkNotNullParameter(userJava, "userJava");
            this.userJava = userJava;
        }
    }

    public static final class Logout extends ActionJava {
        @NotNull
        public static final ActionJava.Logout INSTANCE;

        public Logout() {
            super(null);
        }

        static {
            ActionJava.Logout var0 = new ActionJava.Logout();
            INSTANCE = var0;
        }
    }
}

