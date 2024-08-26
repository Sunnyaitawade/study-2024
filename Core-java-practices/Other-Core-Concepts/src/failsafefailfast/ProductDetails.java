package failsafefailfast;/**
 * @name ProductDetails
 * @author NSA Studios
 * @date 8/3/2024
 */

import jdk.jfr.DataAmount;

/**
 * @name ProductDetails
 * @author NSA Studios
 * @date 8/3/2024
 */


public class ProductDetails {

    private int productId;

    public ProductDetails(int productId, int productPrice, int soldOutCount) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.soldOutCount = soldOutCount;
    }

    private int productPrice;
    private int soldOutCount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getSoldOutCount() {
        return soldOutCount;
    }

    public void setSoldOutCount(int soldOutCount) {
        this.soldOutCount = soldOutCount;
    }
}
