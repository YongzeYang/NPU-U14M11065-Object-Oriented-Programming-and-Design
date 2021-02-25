/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

/**
 * This class implements a method that obtains a HTML
 * representation of a {@link OrderManager} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see OrderManager
 * @see OrderFormatter
 * @see Order
 * @see Item
 */
public class HTMLOrderFormatter implements OrderFormatter{

    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");

    /* single instance of this class */
    static private HTMLOrderFormatter singletonInstance = null;

    /**
     * Obtains the single instance of class
     * <code>HTMLOrderFormatter</code>
     *
     * @return the single instance of class
     *         <code>HTMLOrderFormatter</code>
     */ 
    static public HTMLOrderFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            singletonInstance = new HTMLOrderFormatter();
        }

        return singletonInstance;
    }

    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private HTMLOrderFormatter(){

    }

    /**
     * Obtains a HTML representation of the order list.
     *
     * @param orderManager  the order manager.
     * @return  a HTML representation of the specified
     *          {@link OrderManager} object.
     */    
    @Override
    public String formatOrders(OrderManager orderManager) {
        
        String out = "<html>"
                + NEW_LINE
                + "  <body>"
                + NEW_LINE 
                + "    <center><h1>ORDER LIST</h1></center>"
                + NEW_LINE
                + "    <hr>"
                + NEW_LINE
                + "    <center><h1>small-orders</h1></center>"
                + NEW_LINE;

        for(SmallOrder order : orderManager.getSmallOrders()) {
            out += "    <hr>"
                + NEW_LINE
                + "    <h4>" + order.getCode() + " " + order.getDate() + " CNY" +order.getTotalProfit() + "</h4>"
                + NEW_LINE
                + "      <blockquote>" + order.getItem().getProduct().getCode() + " " + order.getItem().getQuantity() + "</blockquote>"
                + NEW_LINE;
        }

            out+= "    <hr>"
                + NEW_LINE
                + "    <center><h1>bulk-orders</h1></center>"
                + NEW_LINE;

        for(BulkOrder order : orderManager.getBulkOrders()) {
            out += "    <hr>"
                + NEW_LINE
                + "    <h4>" + order.getCode() + " " + order.getDate() + " CNY" +order.getTotalProfit() + "</h4>"
                + NEW_LINE;
            
            out += "      <blockquote>" + NEW_LINE;

            for(Item item : order.getItems()) {
                out += "         "
                        +item.getProduct().getCode() + " " + item.getQuantity() +"<br>" 
                        +NEW_LINE;
            }
            out += "      </blockquote>" 
                        + NEW_LINE;
        }

        out += "  </body>" 
            + NEW_LINE 
            + "</html>";
        return out;
    }
    
}
/*!End Snippet:file*/