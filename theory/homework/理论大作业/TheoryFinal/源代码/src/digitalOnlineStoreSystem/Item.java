/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;
import java.util.*;

/**
 * This class models an Item. It has :
 * <ol>
 * <li>the product of the item, a <code>Product</code></li>
 * <li>the quantity of the item, a <code>int</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Item {
    
    /* the product of the item */
    private Product product;

    /* the quantity of the item */
    private int quantity;

    /**
     * Construct a <code>Item</code> object.
     * 
     * @param product the product of the item
     * @param quantity the quantity of the item
     */
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Returns the Product of the item.
     * 
     * @return Product of the item
     */    
    public Product getProduct() {
        return this.product;
    }

    /**
     * Resets the Product of the item.
     * 
     * @param product new Product of the item
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the quantity of the item.
     * 
     * @return quantity of the item
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Resets the quantity of the item.
     * 
     * @param quantity new quantity of th item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns <code>true</code> if this item is equal to the argument
     * 
     * @param o  object with which this item is compared.
     * @return  <code>true</code> if this item is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(product, item.product) && quantity == item.quantity;
    }

    /**
     * Returns the string representation of this item.
     *
     * @return  the string representation of this item.
     */
    @Override
    public String toString() {
        return "{" +
            " product='" + getProduct() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }

}
/*!End Snippet:file*/