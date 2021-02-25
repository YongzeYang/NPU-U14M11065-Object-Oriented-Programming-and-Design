/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

/**
 * This class implements a method that obtains a XML
 * representation of a {@link OrderManager} object.
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see OrderFormatter
 * @see OrderManager
 * @see Order
 * @see Item
 */
public class XMLOrderFormatter implements OrderFormatter{

    /* Line separator */
    private final static String NEW_LINE = System.getProperty("line.separator");

    /* single instance of this class */
    static private XMLOrderFormatter singletonInstance = null;

    /**
     * Obtains the single instance of class
     * <code>XMLOrderFormatter</code>
     *
     * @return the single instance of class
     *         <code>XMLOrderFormatter</code>
     */  
    static public XMLOrderFormatter getSingletonInstance() {

        if (singletonInstance == null) {
            singletonInstance = new XMLOrderFormatter();
        }

        return singletonInstance;
    }

    /*
     * The constructor is declared private so other classes cannot
     * create an instance of this class.
     */
    private XMLOrderFormatter() {

    }    

    @Override
    public String formatOrders(OrderManager orderManager) {
        String out = "<Order List>" + NEW_LINE;

        out += "  <small-order>" + NEW_LINE;
        for(SmallOrder order : orderManager.getSmallOrders()){
            out += "    <order code=\"" +order.getCode() +"\" date=\"" + order.getDate() + "\" profit = \"" + order.getTotalProfit() + "\">"
                +NEW_LINE;
            out += "      <Item>" + NEW_LINE;
            out += "        <Product code = \"" + order.getItem().getProduct().getCode() + "\">" + "</Product>"+ NEW_LINE;
            out += "        <quantity = \"" + order.getItem().getQuantity() + "\">" + "</quantity>"+ NEW_LINE;
            out += "      </Item>" + NEW_LINE;
        }
        out += "  </small-order>" + NEW_LINE;

        out += "  <bulk-order>" + NEW_LINE;
        for(BulkOrder order : orderManager.getBulkOrders()){
            out += "    <order code=\"" +order.getCode() +"\" date=\"" + order.getDate() + "\" profit = \"" + order.getTotalProfit() + "\">"
                +NEW_LINE;
            out += "      <Item>" + NEW_LINE;
            for(Item item : order.getItems()){
                out += "        <Product code = \"" + item.getProduct().getCode() + "\">" + "</Product>"+ NEW_LINE;
                out += "        <quantity = \"" + item.getQuantity() + "\">" + "</quantity>"+ NEW_LINE;
            }
            out += "      </Item>" + NEW_LINE;
            out += "    </order>" + NEW_LINE;
        }
        out += "  </bulk-order>" + NEW_LINE;

        out += "</Order List>" + NEW_LINE;
        
        return out;
    }
    
}
/*!End Snippet:file*/