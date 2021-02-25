/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

import java.util.*;

/**
 * Maintains the information of a bulk order for order manager.
 * Contains a collection of {@link Item} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Order
 * @see Item
 */
public class BulkOrder extends Order  {

    /* Collection of <code>Item</code> objects.*/
    private ArrayList<Item> items;

    /**
     * Constructs an empty bulk order.
     * 
     * @param code initial code
     * @param date initial date 
     * @param cost initial cost
     */
    public BulkOrder(String code, String date, double cost)  {
        super(code, date, cost);
        items = new ArrayList<Item>();
    }

    /**
     * Get the collection of <code>Item</code>
     * 
     * @return the collection {@link ArrayList} of {@link Item}
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Add an item to the bulk order.
     * 
     * @param item the item added
     */
    public void addItem(Item item)  {

        items.add(item);
    }

    /**
     * Remove an item from the order.
     * 
     * @param item the item removed
     */
    public void removeItem(Item item)  {

        items.remove(item);
    }

    /**
     * Get the number of items of the bulk order.
     * 
     * @return the number of items
     */
    public int getNumberOfItems()  {

        return items.size();
    }

    /**
     * Get the <code>Product</code> by its code.
     * 
     * @param code the code of the product
     * @return the Product of with the code
     */
    public Product getProduct(String code)  {

        for(Item item:items)  {
            if(item.getProduct().getCode().equals(code)) 
                return item.getProduct();
        }
        return null;
    }

    /**
     * Get the <code>Product</code> by its eposition.
     * 
     * @param index the position of the product
     * @return the Product of with that index
     */
    public Product getProduct(int index)  {

        int count = 1;

        for(Item item:items)  {
            if(count==index) return item.getProduct();
            count++;    
        }
        return null;
    }

    /**
     * Return the total profit of the order.
     * 
     * @return the total profit
     */
    public double getTotalProfit()  {
        double profit = 0;
        for(Item item : items)  {
            profit += item.getQuantity() * item.getProduct().getProfit();
        }
        return profit - this.getCost();
    }

    /**
     * Returns the string representation of this bulk order.
     *
     * @return  the string representation of this bulk order.
     *
     */
    public String toString() {

        String st = ""; int i = 1;
        for(Item item : items) {
            st += "    item " + i +": " + "code:'" + item.getProduct().getCode()+ "', quantity:'" + item.getQuantity() + "'\n";
            i++;
        }
        return super.toString() + ", " +
                "totalProfit:'CNY" + getTotalProfit() + "'" + "\n" + st;
    }
}
/*!End Snippet:file*/

