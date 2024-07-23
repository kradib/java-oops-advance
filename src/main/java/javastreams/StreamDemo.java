package javastreams;

import optional.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        List<Integer> idList = List.of(4, 5, 6, 7); // immutable list gets created


        for (Integer integer : idList) {
            userList.add(new User(integer, "name" + integer));
        }

        Stream<User> userStream = Stream.empty();

        Collection<String> userCollection = Set.of("a", "b", "c");

        Stream<String> stringStream = userCollection.stream();

        List<User> newUserList = idList.stream()
                .map(x -> new User(x, "name" + x))
                .collect(Collectors.toUnmodifiableList());
        //[10, 10, 10, 10]

        Stream<Integer> generatedStream = Stream.generate(() -> 10).limit(10);
        List<Integer> one2Ten = Stream.iterate(1, n -> n*2).limit(10).collect(Collectors.toUnmodifiableList());
        System.out.println(one2Ten);

        IntStream intStream = IntStream.range(1, 10);
        //List<Integer> oneToTen = intStream.boxed().collect(Collectors.toUnmodifiableList());
        List<User> newUserListWithIntStream = intStream.boxed()
                .map(x -> new User(x, "name" + x))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(newUserListWithIntStream);


        //lambda is basically anonymous function

    }

    private String f(int x) {

        //
        return String.valueOf(x);
    }



}
