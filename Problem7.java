import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Problem7 {
    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        List<Integer> result = IntStream.rangeClosed(1, Integer.MAX_VALUE)
            .filter(num -> Math.sqrt(num) - (int) Math.sqrt(num) != 0.0 && num != 1 && !notPrimo(num, (int) Math.sqrt(num)))
            .limit(10002)
            .boxed()
            .collect(Collectors.toList());

        System.out.println(result.get(10001));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration/1000000);
    }


    private static boolean notPrimo(int num, int sqrt){
        return IntStream.rangeClosed(2, sqrt)
            .anyMatch(x -> num % x == 0);
    } 
}

