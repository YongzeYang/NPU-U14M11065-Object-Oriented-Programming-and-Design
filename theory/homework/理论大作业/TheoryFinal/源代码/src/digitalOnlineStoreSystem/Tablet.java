/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

/**
 * This class models a Laptop. It extends {@link Product} and
 * adds the following information:
 * <ol>
 * <li>the cpu of the tablet, a <code>String</code></li>
 * <li>the size of the tablet, a <code>String</code></li>
 * <li>the disk of the tablet, a <code>String</code></li>
 * <li>the weight of the tablet, a <code>double</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Tablet extends Product {

    /* the cpu of the tablet */
    private String cpu;

    /* the size of the tablet */
    private double size;

    /* the disk of the tablet */
    private String disk;

    /* the weight of the tablet */
    private double weight;

    /**
     * Construct a <code>Laptop</code> object.
     * 
     * @param code the code of the tablet
     * @param brand the brand of the tablet
     * @param cost the cost of the tablet
     * @param price the price of the tablet
     * @param cpu the cpu of the tablet
     * @param size the size of the tablet
     * @param disk the disks of the tablet
     * @param weight the weight of the tablet
     */
    public Tablet(String code, String brand, double cost, double price,String cpu, double size, String disk, double weight) {
        super(code, brand, cost, price);
        this.cpu = cpu;
        this.size = size;
        this.disk = disk;
        this.weight = weight;
    }

    /**
     * Returns the cpu of the tablet.
     * 
     * @return cpu of the tablet
     */
    public String getCpu() {
        return this.cpu;
    }

    /**
     * Resets the cpu of the tablet.
     * 
     * @param cpu new cpu of the tablet
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Returns size.
     * 
     * @return size
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Resets size.
     * 
     * @param size new size
     */
    public void setSize(double size) {
        this.size = size;
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
     * Return weight.
     * 
     * @return weight
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Reset weight.
     * 
     * @param weight new weight
     */    
    public void setWeight(double weight) {
        this.weight = weight;
    }


    /**
     * Returns the string representation of this tablet.
     *
     * @return  the string representation of this tablet.
     */
    @Override
    public String toString() {
        return "Tablet:   " + 
            super.toString() +
            " cpu:'" + getCpu() + "'" +
            ", size:'" + getSize() + "inch(es)'" +
            ", disk:'" + getDisk() + "'" +
            ", weight:'" + getWeight() + "kg'" ;
    }
}
/*!End Snippet:file*/