package com.alexanderbelldev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {


        // stream of, sorted + find first
        Stream.of("Ava","Aneri","Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //stream from array, sort, filter + print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
        Arrays.stream(names)	// same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        //average squares of int array
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);


        //stream from list, filter + print
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        // stream rows from text file, sort, filter + print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();


        //stream rows from text file and save to list
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
                     .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(System.out::println);


        //stream rows from csv file and count
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length ==3)
                .count();
        System.out.println("row count " + rowCount);
        rows1.close();
    }

    public void intArray(){
        // int stream printing range
        IntStream.range(1,10)
                .forEach(System.out::println);

        // int stream with a skip i.e. skip first 5 elements
        IntStream.range(1,10)
                .skip(5)
                .forEach(System.out::println);

        // int stream with sum (will sum 1 -5)
        System.out.println(IntStream.range(1,5)
                .sum());
    }
}
