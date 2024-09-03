import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;

public class Problem8 {

   public static void main(String[] args) {
    String number = "73167176531330624919225119674426574742355349194934\r\n" + //
                "96983520312774506326239578318016984801869478851843\r\n" + //
                "85861560789112949495459501737958331952853208805511\r\n" + //
                "12540698747158523863050715693290963295227443043557\r\n" + //
                "66896648950445244523161731856403098711121722383113\r\n" + //
                "62229893423380308135336276614282806444486645238749\r\n" + //
                "30358907296290491560440772390713810515859307960866\r\n" + //
                "70172427121883998797908792274921901699720888093776\r\n" + //
                "65727333001053367881220235421809751254540594752243\r\n" + //
                "52584907711670556013604839586446706324415722155397\r\n" + //
                "53697817977846174064955149290862569321978468622482\r\n" + //
                "83972241375657056057490261407972968652414535100474\r\n" + //
                "82166370484403199890008895243450658541227588666881\r\n" + //
                "16427171479924442928230863465674813919123162824586\r\n" + //
                "17866458359124566529476545682848912883142607690042\r\n" + //
                "24219022671055626321111109370544217506941658960408\r\n" + //
                "07198403850962455444362981230987879927244284909188\r\n" + //
                "84580156166097919133875499200524063689912560717606\r\n" + //
                "05886116467109405077541002256983155200055935729725\r\n" + //
                "71636269561882670428252483600823257530420752963450";
      
       /*         
      // Primeiro quebrei a string de 1000 digitos em 1 array de inteiros com cada um deles
      int[] digits = number.chars()
        .filter(Character::isDigit)
        .map(Character::getNumericValue)
        .toArray();
      
      // Depois criei uma lista de Streams com os 13 digitos aninhados, ou seja eu fiz n listas comtendo os 13 digitos
       List<IntStream> substreams = IntStream.range(0, digits.length - 12)
        .mapToObj(i -> Arrays.stream(digits, i, i + 13))
        .collect(Collectors.toList());

        // Depois eu peguei a lista de Streams , e rodei um map para cada Stream , cada stream continha 13 digitos que foram aninhados antes, e rodei um reduce para multiplicar todos os digitos
        // depois tendo em mãos uma lista de inteiros eu rodei um max que retorna o maior valor entre eles. 
        System.err.println(substreams
            .stream()
            .mapToInt(stream -> stream.reduce(1,(x, y) -> x * y))
            .max());
        */

        // Aqui eu faço isso tudo de uma vez, um ponto que não me agrada é o fato de ter que converter a string em array de inteiros 2 vezes uma apenas para pegar o lan
        long startTime = System.nanoTime();

        int value = IntStream.range(0,
                        1000 - 12)
            .mapToObj(i -> Arrays.stream(number.chars()
                .map(Character::getNumericValue)
                .toArray(), i, i + 13))
            .collect(Collectors.toList())
            .stream()
            .mapToInt(stream -> stream.reduce(1,(x, y) -> x * y))
            .max()
            .orElse(0);

        System.out.println(value);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration/1000000 + " ms");

    }
}
