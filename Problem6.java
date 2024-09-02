import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static void main(String[] args) {
     
        long startTime = System.nanoTime();
        
        Integer valueResult = IntStream.range(1, 101).boxed().toList()
        .stream()
        .collect(
            Collectors.teeing(
                Collectors.reducing(0, x -> x * x, Integer::sum),
                Collectors.reducing(0, Integer::sum),
            (x, y) -> ((y*y) - x)));
    
        System.out.println(valueResult);
            
        long end = System.nanoTime();
            
        long duration = end - startTime;

        System.out.println("tempo de execução: " + duration/1000000 + "ms");
    
    }


    private static double difference(double a, double b) {
        return b - a;
    }
    
}
