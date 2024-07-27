package threading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfAsyncTasks {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Create a list of Completable

        List<CompletableFuture<String>> futureList = IntStream.range(1, 6)
                .mapToObj( i-> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(10000 - i* 1000L); // latency of the task
                        return "Task " + i + " Completed";
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executorService)).collect(Collectors.toUnmodifiableList());
//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));

        //all completable future gets executed
        futureList.forEach(stringCompletableFuture -> {
            try {
                System.out.println(stringCompletableFuture.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
