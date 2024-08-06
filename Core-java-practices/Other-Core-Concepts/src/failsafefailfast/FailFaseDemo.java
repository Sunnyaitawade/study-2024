package failsafefailfast;/**
 * @name FailFaseDemo
 * @author NSA Studios
 * @date 8/3/2024
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @name FailFaseDemo
 * @author NSA Studios
 * @date 8/3/2024
 */
public class FailFaseDemo {

    public static void main(String[] args) {
        showDemoFailFastException();
    }

    public static void showDemoFailFastException(){

        ArrayList<String> listOfName = new ArrayList<>();
        listOfName.add("Sunny");
        listOfName.add("Amit");


        listOfName.stream().forEach(
                s -> {
                    System.out.println("s");
                    listOfName.add(s.substring(2));
                }
        );

    }
}
