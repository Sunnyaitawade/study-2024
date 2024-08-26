import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author NSA Studios
 * @name ${NAME}
 * @date 8/6/2024
 */

public class Main {
    public static void main(String[] args) {

         System.out.println("Hello world!");

       String sampleoutput =  Arrays.asList("aallianana","allyanna")
                .stream().map(s -> {
                    if(s.startsWith("aa")) {
                         return s + " :"+ s.chars().distinct().count();

                    }
                    return null;
                }).collect(Collectors.joining(","));

        System.out.println(sampleoutput);

    }
}