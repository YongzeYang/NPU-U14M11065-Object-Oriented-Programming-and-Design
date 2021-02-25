/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

import java.util.ArrayList;

/**
 * Maintains the information of a product catalog for system.
 * Contains a collection of {@link Product} objects.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see Product
 */
public class ProductCatalog  {

    /* Collection of <code>product</code> objects.*/
    private ArrayList<Product> products;

    /**
     * Constructs an empty product catalog.
     */    
    public ProductCatalog()  {

        products = new ArrayList<Product>();
    }

    /**
     * Add an product to the product catalog.
     * 
     * @param product the product added
     */
    public void addProduct(Product product)  {

        products.add(product);
    }

    /**
     * Remove an product to the product catalog.
     * 
     * @param product the product removed
     */  
    public void removeProduct(Product product)  {

        products.remove(product);
    }

    /**
     * Returns specific product via index.
     * 
     * @param index index of product 
     * @return specific product or <code>null</code> if does not exist.
     */
    public Product getProduct(int index)  {

        int count = 1;

        for(Product product:products)  {
            if(count == index) return product;
            count++;
        }

        return null;
    }


    /**
     * Returns number of Products.
     * 
     * @return number of Products.
     */
    public int getNumberOfProducts()  {

        return products.size();
    }

    /**
     * Returns specific product via code.
     * 
     * @param code code of the product
     * @return specific product or <code>null</code> if does not exist.
     */
    public Product getProduct(String code)  {

        for(Product product:products)  {
            
            if(product.getCode().equals(code)) return product;
        }

        return null;
    }

    /**
     * Get the collection of <code>Product</code>
     * 
     * @return the collection {@link ArrayList} of {@link Product}
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

}
/*!End Snippet:file*/