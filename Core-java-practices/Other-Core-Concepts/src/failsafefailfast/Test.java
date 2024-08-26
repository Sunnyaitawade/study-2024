package failsafefailfast;/**
 * @name Test
 * @author NSA Studios
 * @date 8/3/2024
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @name Test
 * @author NSA Studios
 * @date 8/3/2024
 */
public class Test {

    public static void main(String[] args) {
     List<ProductDetails> listOfProducts = new ArrayList<>();

        listOfProducts.add(new ProductDetails(1,300,4));
        listOfProducts.add(new ProductDetails(2,300,10));
        listOfProducts.add(new ProductDetails(3,300,13));
        listOfProducts.add(new ProductDetails(3,300,2));


    }
}
