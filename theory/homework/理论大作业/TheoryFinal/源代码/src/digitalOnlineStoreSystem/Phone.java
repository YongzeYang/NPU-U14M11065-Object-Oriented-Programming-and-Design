/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;
import java.util.*;

/**
 * This class models a Phone. It extends {@link Product} and
 * adds the following information:
 * <ol>
 * <li>the cpu of the phone, a <code>String</code></li>
 * <li>the ram of the phone, a <code>String</code></li>
 * <li>the disk of the phone, a <code>String</code></li>
 * <li>the pixel of the phone, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Phone extends Product{
    
    /* the cpu of the phone */
    private String cpu;

    /* the ram of the phone */    
    private String ram;

    /* the disk of the phone */    
    private String disk;

    /* the pixel of the phone */    
    private String pixel;


    /**
     * Construct a <code>Phone</code> object.
     * 
     * @param code the code of the phone
     * @param brand the brand of the phone
     * @param cost the cost of the phone
     * @param price the price of the phone
     * @param cpu the cpu of the phone
     * @param ram the ram of the phone
     * @param disk the disk of the phone
     * @param pixel the pixel of the phone
     */
    public Phone(String code, String brand, double cost, double price,String cpu, String ram, String disk, String pixel) {
        super(code, brand, cost, price);
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.pixel = pixel;
    }

    /**
     * Returns the cpu of the phone.
     * 
     * @return cpu of the phone
     */
    public String getCpu() {
        return this.cpu;
    }

    /**
     * Resets the cpu of the phone.
     * 
     * @param cpu new cpu of the phone
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Returns the ram of the phone.
     * 
     * @return ram of the phone
     */
    public String getRam() {
        return this.ram;
    }

    /**
     * Reset ram.
     * 
     * @param ram new ram
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Return disk.
     * 
     * @return disk
     */
    public String getDisk() {
        return this.disk;
    }

    /**
     * Reset disk.
     * 
     * @param disk new disk
     */
    public void setDisk(String disk) {
        this.disk = disk;
    }

    /**
     * Returns pixel.
     * 
     * @return pixel
     */
    public String getPixel() {
        return this.pixel;
    }

    /**
     * Resets pixel.
     * 
     * @param pixel new pixel
     */
    public void setPixel(String pixel) {
        this.pixel = pixel;
    }

    /**
     * Returns <code>true</code> if this phone is equal to the argument
     * 
     * @param o  object with which this phone is compared.
     * @return  <code>true</code> if this phone is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals(cpu, phone.cpu) && Objects.equals(ram, phone.ram) && Objects.equals(disk, phone.disk) && Objects.equals(pixel, phone.pixel);
    }


    /**
     * Returns the string representation of this phone.
     *
     * @return  the string representation of this phone.
     */
    @Override
    public String toString() {
        return "Phone:   " + 
            super.toString() +
            " cpu:'" + getCpu() + "'" +
            ", ram:'" + getRam() + "'" +
            ", disk:'" + getDisk() + "'" +
            ", pixel:'" + getPixel() + "'";
    }

}
/*!End Snippet:file*/