/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

/**
 * This class implements a method that obtains a plain text
 * representation of a {@link OrderManager} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see OrderManager
 * @see OrderFormatter
 * @see Order
 */
public class PlainTextOrderFormatter implements OrderFormatter{

    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");

    /* single instance of this class */
    static private PlainTextOrderFormatter singletonInstance = null;

    /**
     * Obtains the single instance of class
     * <code>PlainTextOrderFormatter</code>
     *
     * @return the single instance of class
     *         <code>PlainTextOrderFormatter</code>
     */  
    static public PlainTextOrderFormatter getSingletonInstance(){
        if(singletonInstance == null) {
            singletonInstance = new PlainTextOrderFormatter();
        }

        return singletonInstance;
    }

    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private PlainTextOrderFormatter() {

    }

    /**
     * Obtains a text representation of the order catalog.
     *
     * @param orderManager  the order catalog.
     * @return  a text representation of the specified
     *          {@link OrderFormatter} object.
     */    
    @Override
    public String formatOrders(OrderManager orderManager) {
        String out = "SMALL ORDERS" + NEW_LINE;

        for(Order order : orderManager.getSmallOrders())
            out += order.toString() +  NEW_LINE;
        
        out += NEW_LINE + NEW_LINE + "BULK ORDERS" + NEW_LINE;
        
        for(Order order : orderManager.getBulkOrders())
            out += order.toString() +  NEW_LINE;
        
        return out;
    }
    
}
