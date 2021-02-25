/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

import java.util.*;

/**
 * This class models an Device. It extends {@link Product} and
 * adds the following information:
 * <ol>
 * <li>the type of the device, a <code>String</code></li>
 * <li>the usage of the device, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Device extends Product {

    /* the type of the device */
    private String type;

    /* the usage of the device */
    private String usage;

    /**
     * Construct a <code>Device</code> object.
     * 
     * @param code the code of the device
     * @param brand the brand of the device
     * @param cost the cost of the device
     * @param price the price of the device
     * @param type the type of the device
     * @param usage the usage of the device
     */
    public Device(String code, String brand, double cost, double price, String type, String usage) {
        super(code, brand, cost, price);
        this.type = type;
        this.usage = usage;
    }

    /**
     * Returns the type of the device.
     * 
     * @return type of the device
     */    
    public String getType() {
        return this.type;
    }

    /**
     * Resets the type of the device.
     * 
     * @param type new type of the device
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the usage of the device.
     * 
     * @return usage of the device
     */
    public String getUsage() {
        return this.usage;
    }

    /**
     * Resets the usage of the device.
     * 
     * @param usage new usage of th device.
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * Returns <code>true</code> if this device is equal to the argument
     * 
     * @param o  object with which this device is compared.
     * @return  <code>true</code> if this device is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Device)) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(type, device.type) && Objects.equals(usage, device.usage);
    }

    /**
     * Returns the string representation of this device.
     *
     * @return  the string representation of this device.
     */
    @Override
    public String toString() {
        return "Device:   " + 
            super.toString() +
            " type:'" + getType() + "'" +
            ", usage:'" + getUsage() + "'" ;
    
    }
}
/*!End Snippet:file*/