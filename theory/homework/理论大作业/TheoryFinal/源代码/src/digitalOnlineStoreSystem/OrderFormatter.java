/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

/**
 * This interface defines a method that obtains a string
 * representation of a {@link OrderManager} object.
 *
 * @author yongze_yang(2019302768)
 * @version  1.0.0
 * @see OrderManager
 */
public interface OrderFormatter {

    /**
     * Obtains the string representation of the order catalog.
     *
     * @param orderManager  the order catalog.
     * @return  the string representation of the specified
     *          {@link OrderManager} object.
     */
    String formatOrders(OrderManager orderManager);
}
/*!End Snippet:file*/