import java.util.stream.IntStream;

public class Problem5 {
    public static void main(String[] args) {
        
        int result = IntStream.rangeClosed(2050, Integer.MAX_VALUE)
            .map(num -> num*20)
            .filter(num -> isDivisivel(num))
            .findFirst().orElseThrow();

        System.out.println(result);
    }

    private static boolean isDivisivel(int num){
        return IntStream.rangeClosed(1, 20)
            .allMatch(x -> num % x == 0);
    }    
}