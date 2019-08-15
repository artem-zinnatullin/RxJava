package io.reactivex.rxjava3.internal.rxjava2interop;

import io.reactivex.rxjava3.Observable;
import io.reactivex.rxjava3.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Has to be a separate class to hide RxJava2 from ClassLoader in case it's not on classpath.
 */
public class RxJava3To2Interop {

    private RxJava3To2Interop() {
        throw new IllegalStateException("No instances please!");
    }

    public static <T> io.reactivex.Observable<T> v3ObservableToV2(final Observable<T> v3Observable) {
        // TODO proper impl.
        return io.reactivex.Observable.create(new io.reactivex.ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(final io.reactivex.ObservableEmitter<T> emitter) throws Exception {
                v3Observable.subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(final Disposable d) {
                        // TODO proper disposable impl.
                        emitter.setDisposable(io.reactivex.disposables.Disposables.fromRunnable(new Runnable() {
                            @Override
                            public void run() {
                                d.dispose();
                            }
                        }));
                    }

                    @Override
                    public void onNext(T t) {
                        emitter.onNext(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        emitter.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        emitter.onComplete();
                    }
                });
            }
        });
    }
}
