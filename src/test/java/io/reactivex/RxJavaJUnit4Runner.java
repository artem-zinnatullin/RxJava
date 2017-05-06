package io.reactivex;

import com.sun.istack.internal.NotNull;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class RxJavaJUnit4Runner extends Runner {

    private final Class<?> testClass;
    
    public RxJavaJUnit4Runner(@NotNull Class<?> testClass) {
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return null;
    }

    @Override
    public void run(RunNotifier notifier) {

    }
}
