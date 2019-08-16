package io.reactivex.internal.rxjava3interop;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxJava2To3Interop {

    public static <T> io.reactivex.rxjava3.Observable<T> v2ObservableToV3(final Observable<T> v2Observable) {
        // TODO proper impl.
        return io.reactivex.rxjava3.Observable.create(new io.reactivex.rxjava3.ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(final io.reactivex.rxjava3.ObservableEmitter<T> emitter) throws Throwable {
                v2Observable.subscribeWith(new Observer<T>() {
                    @Override
                    public void onSubscribe(final Disposable d) {
                        emitter.setDisposable(io.reactivex.rxjava3.disposables.Disposables.fromRunnable(new Runnable(){
                            @Override
                            public void run() {
                                d.dispose(); // TODO port disposable properly.
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
