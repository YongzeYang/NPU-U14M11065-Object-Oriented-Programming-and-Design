/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

import java.util.*;

/**
 * This class models an Order. It has :
 * <ol>
 * <li>the code of the Order, a <code>Product</code></li>
 * <li>the date of the Order, a <code>int</code></li>
 * <li>the cost of the Order, a <code>int</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 */
public class Order {
    /* the code of the Order */
    private String code;

    /* the date of the Order */
    private String date;

    /* the cost of the Order */
    private double cost;
    
    /**
     * Construct a <code>Order</code> object.
     */
    public Order() {
    }

    /**
     * Construct a <code>Order</code> object.
     * 
     * @param code the product of the Order
     * @param date the quantity of the Order
     * @param cost the quantity of the Order
     */
    public Order(String code, String date, double cost) {
        this.code = code;
        this.date = date;
        this.cost = cost;
    }

    /**
     * Returns the code.
     * 
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Reset code.
     * 
     * @param code new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns date.
     * 
     * @return date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Reset date.
     * 
     * @param date new date
     */
    public void setDate(String date) {
        this.date = date;
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
     * Reset cost
     * 
     * @param cost new cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }


    /**
     * Returns <code>true</code> if this Order is equal to the argument
     * 
     * @param o  object with which this Order is compared.
     * @return  <code>true</code> if this Order is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(code, order.code) && Objects.equals(date, order.date) && cost == order.cost;
    }

    /**
     * Returns the string representation of this Order.
     *
     * @return  the string representation of this Order.
     */
    @Override
    public String toString() {
        return 
            "code:'" + getCode() + "'" +
            ", date:'" + getDate() + "'" +
            ", cost:'CNY" + getCost() + "'";
    }

}
/*!End Snippet:file*/