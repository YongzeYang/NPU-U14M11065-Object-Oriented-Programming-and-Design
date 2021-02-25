/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

import java.util.*;

/**
 * This class models a Laptop. It has: 
 * <ol>
 * <li>the code of the product, a <code>String</code></li>
 * <li>the brand of the product, a <code>String</code></li>
 * <li>the cost of the product, a <code>double</code></li>
 * <li>the price of the product, a <code>double</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Product {
    /* the code of the product */
    private String code;

    /* the brand of the product */
    private String brand;

    /* the cost of the product */
    private double cost;

    /* the price of the product */
    private double price;

    /**
     * Constructs an empty object.
     */
    public Product() {
    }

    /**
     * Construct a <code>Laptop</code> object.
     * 
     * @param code the code of the product
     * @param brand the brand of the product
     * @param cost the cost of the product
     * @param price the price of the product
     */    
    public Product(String code, String brand, double cost, double price) {
        this.code = code;
        this.brand = brand;
        this.cost = cost;
        this.price = price;
    }

    /**
     * Returns code.
     * 
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Resets code.
     * 
     * @param code new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns brand.
     * 
     * @return brand
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Resets brand.
     * 
     * @param brand new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Returns cost.
     * 
     * @return cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Resets cost.
     * 
     * @param cost new cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns price.
     * 
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Resets price.
     * 
     * @param price new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns <code>true</code> if this product is equal to the argument
     * 
     * @param o  object with which this product is compared.
     * @return  <code>true</code> if this product is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(code, product.code) && Objects.equals(brand, product.brand) && cost == product.cost && price == product.price;
    }

    /**
     * Returns profit.
     * 
     * @return profit
     */
    public double getProfit()  {
        
        return price - cost;
    }

    /**
     * Returns the string representation of this product.
     *
     * @return  the string representation of this product.
     */    
    public String toString() {
        return             
        " code:'" + getCode() + "'" +
        ", brand:'" + getBrand() + "'" +
        ", cost:'CNY" + getCost() + "'" +
        ", price:'CNY" + getPrice() + "'" ;
    }

}
/*!End Snippet:file*/