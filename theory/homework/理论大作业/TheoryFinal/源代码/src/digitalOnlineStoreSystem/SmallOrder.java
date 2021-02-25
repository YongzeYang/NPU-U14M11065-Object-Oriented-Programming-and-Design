/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

/**
 * Maintains the information of a small order for order manager.
 * Contains an {@link Item} object.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Order
 * @see Item
 */
public class SmallOrder extends Order{
    /* an item */
    private Item item;
    
    /**
     * Constructs an empty small order.
     */
    public SmallOrder() {
    }

    /**
     * Constructs an empty small order.
     * 
     * @param item initial item
     */
    public SmallOrder(Item item) {
        this.item = item;
    }

    /**
     * Constructs an empty small order.
     * 
     * @param code initial code
     * @param date initial date 
     * @param cost initial cost
     * @param item initial item
     */    
    public SmallOrder(String code, String date, double cost, Item item)  {
        
        super(code, date, cost);
        this.item = item;
    }

    /**
     * Returns item.
     * 
     * @return item
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Resets item.
     * 
     * @param item new item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Returns the string representation of this small order.
     *
     * @return  the string representation of this small order.
     *
     */
    @Override
    public String toString() {
        return  super.toString() + ", " +
                "totalProfit:'CNY" + getTotalProfit() + "', " +
                "item-code:'" + getItem().getProduct().getCode() +"', " + 
                "quantity:'" + getItem().getQuantity() + "'";

    }

    /**
     * Return the total profit of the order.
     * 
     * @return the total profit
     */
    public double getTotalProfit()  {
        return item.getQuantity() * item.getProduct().getProfit() - this.getCost();
    }
    
}
/*!End Snippet:file*/