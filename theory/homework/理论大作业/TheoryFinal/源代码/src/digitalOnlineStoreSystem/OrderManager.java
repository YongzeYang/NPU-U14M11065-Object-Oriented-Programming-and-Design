/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

import java.util.*;

/**
 * Maintains the information of a order manager for system.
 * Contains a collection of {@link SmallOrder} and {@link BulkOrder} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see SmallOrder
 * @see BulkOrder
 */
public class OrderManager {

    /* Collection of <code>SmallOrder</code> objects.*/
    private ArrayList<SmallOrder> smallOrders;

    /* Collection of <code>BulkOrder</code> objects.*/
    private ArrayList<BulkOrder> bulkOrders;

    /**
     * Constructs an empty order manager.
     */
    public OrderManager()  {
        smallOrders = new ArrayList<SmallOrder>();
        bulkOrders = new ArrayList<BulkOrder>();
    }


    /**
     * Add an small order to the order manager.
     * 
     * @param smallOrder the smallOrder added
     */
    public void addSmallOrder(SmallOrder smallOrder)  {

        smallOrders.add(smallOrder);
    }

    /**
     * Add an bulk order to the order manager.
     * 
     * @param bulkOrder the bulkOrder added
     */
    public void addBulkOrder(BulkOrder bulkOrder)  {

        bulkOrders.add(bulkOrder);
    }
    
    /**
     * Remove an small order to the order manager.
     * 
     * @param smallOrder the smallOrder removed
     */   
    public void removeSmallOrder(SmallOrder smallOrder)  {

        smallOrders.remove(smallOrder);
    }

    /**
     * Remove an bulk order to the order manager.
     * 
     * @param bulkOrder the bulkOrder removed
     */
    public void removeBulkOrder(BulkOrder bulkOrder)  {

        bulkOrders.remove(bulkOrder);
    }

    /**
     * Returns specific BulkOrder via code.
     * @param code the code of the bulk order
     * @return specific BulkOrder or <code>null</code> if does not exist.
     */
    public BulkOrder getBulkOrder(String code){
        for(BulkOrder bulkOrder : bulkOrders)
            if(bulkOrder.getCode().equals(code)) return bulkOrder;
        return null;
    }

    /**
     * Returns specific SmallOrder via code.
     * 
     * @param code the code of the small order
     * @return specific SmallOrder or <code>null</code> if does not exist.
     */
    public SmallOrder getSmallOrder(String code){
        for(SmallOrder smallOrder : smallOrders)
            if(smallOrder.getCode().equals(code)) return smallOrder;
        return null;
    }

    /**
     * Get the collection of <code>SmallOrder</code>
     * 
     * @return the collection {@link ArrayList} of {@link SmallOrder}
     */
    public ArrayList<SmallOrder> getSmallOrders() {
        return smallOrders;
    }

    /**
     * Get the collection of <code>BulkOrder</code>
     * 
     * @return the collection {@link ArrayList} of {@link BulkOrder}
     */
    public ArrayList<BulkOrder> getBulkOrders() {
        return bulkOrders;
    }
}
/*!End Snippet:file*/