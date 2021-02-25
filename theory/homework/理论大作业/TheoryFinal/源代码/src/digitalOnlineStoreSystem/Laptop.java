/*!Begin Snippet:file*/

package digitalOnlineStoreSystem;

import java.util.*;

/**
 * This class models a Laptop. It extends {@link Product} and
 * adds the following information:
 * <ol>
 * <li>the cpu of the laptop, a <code>String</code></li>
 * <li>the gpu of the laptop, a <code>String</code></li>
 * <li>the ram of the laptop, a <code>String</code></li>
 * <li>the disk of the laptop, a <code>String</code></li>
 * <li>the weight of the laptop, a <code>double</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Laptop extends Product{

    /* the cpu of the laptop */
    private String cpu;

    /* the gpu of the laptop */
    private String gpu;

    /* the ram of the laptop */
    private String ram;

    /* the disk of the laptop */
    private String disk;

    /* the weight of the laptop */
    private double weight;


    /**
     * Construct a <code>Laptop</code> object.
     * 
     * @param code the code of the laptop
     * @param brand the brand of the laptop
     * @param cost the cost of the laptop
     * @param price the price of the laptop
     * @param cpu the cpu of the laptop
     * @param gpu the gpu of the laptop
     * @param ram the ram of the laptop
     * @param disk the disks of the laptop
     * @param weight the weight of the laptop
     */
    public Laptop(String code, String brand, double cost, double price,String cpu, String gpu, String ram, String disk, double weight) {
        super(code, brand, cost, price);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.disk = disk;
        this.weight = weight;
    }

    /**
     * Returns the cpu of the laptop.
     * 
     * @return cpu of the laptop
     */
    public String getCpu() {
        return this.cpu;
    }

    /**
     * Resets the cpu of the laptop.
     * 
     * @param cpu new cpu of the laptop
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Returns the gpu of the laptop.
     * 
     * @return gpu of the laptop
     */
    public String getGpu() {
        return this.gpu;
    }

    /**
     * Resets the gpu of the laptop.
     * 
     * @param gpu new gpu of th laptop.
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     * Returns the ram of the laptop.
     * 
     * @return ram of the laptop
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
     * Returns <code>true</code> if this laptop is equal to the argument
     * 
     * @param o  object with which this laptop is compared.
     * @return  <code>true</code> if this laptop is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Objects.equals(cpu, laptop.cpu) && Objects.equals(gpu, laptop.gpu) && Objects.equals(ram, laptop.ram) && Objects.equals(disk, laptop.disk) && weight == laptop.weight;
    }


    /**
     * Returns the string representation of this laptop.
     *
     * @return  the string representation of this laptop.
     */
    @Override 
    public String toString() {
        return "Laptop:   " + 
            super.toString() +
            " cpu:'" + getCpu() + "'" +
            ", gpu:'" + getGpu() + "'" +
            ", ram:'" + getRam() + "'" +
            ", disk:'" + getDisk() + "'" +
            ", weight:'" + getWeight() + "kg'" ;
    }
}
/*!End Snippet:file*/