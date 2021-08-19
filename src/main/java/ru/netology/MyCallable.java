package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int Count;

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(2000);
        return Thread.currentThread().getName();
    }
}
