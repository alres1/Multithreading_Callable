package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Callable<String> callable = new MyCallable();
        List<Future<String>> list = new ArrayList<>();

        for(int i=0; i< 10; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }

        for(Future<String> ft : list) {
            try {
                System.out.println(ft.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Пул закрыт.");

    }
}
