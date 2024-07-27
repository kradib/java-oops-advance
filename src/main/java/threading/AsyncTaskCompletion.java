package threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class AsyncTaskCompletion {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //you need userDetails & userOrders
        //you make a call for userDetails //2 seconds
        //you make a call for userOrders // 3 seconds

        //call for user details from a thread at x timestamp
        //call for user Orders from another thread at the he same timestamp x

        //how long you need to wait ? now only 3 seconds because both is happening async way

        CompletableFuture<String> userDetailsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "User: name = Savvy, address = xyz";
        });

        CompletableFuture<String> userOrderFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Order: order1, order2, order3";
        });

        CompletableFuture<String> combinedFuture = userDetailsFuture.thenCombine(userOrderFuture,
                (userDetails, userOrder) -> userDetails + " " + userOrder);

        System.out.println(combinedFuture.get());

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        CompletableFuture<String> userDetailsFutureWithExecutorService = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "User: name = Savvy, address = xyz";
        }, executorService);

        CompletableFuture<String> userOrderFutureExecutorService = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Order: order1, order2, order3";
        }, executorService);

        CompletableFuture<String> combinedFutureWithExecutorService = userDetailsFutureWithExecutorService.thenCombine(userOrderFutureExecutorService,
                (userDetails, userOrder) -> userDetails + " " + userOrder);

        System.out.println(combinedFutureWithExecutorService.get());

        executorService.shutdown();






    }


}
