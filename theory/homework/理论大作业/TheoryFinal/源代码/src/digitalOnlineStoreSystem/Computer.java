/*!Begin Snippet:file*/
 
package digitalOnlineStoreSystem;

import java.util.*;

/**
 * This class models a Computer. It extends {@link Product} and
 * adds the following information:
 * <ol>
 * <li>the cpu of the computer, a <code>String</code></li>
 * <li>the gpu of the computer, a <code>String</code></li>
 * <li>the ram of the computer, a <code>String</code></li>
 * <li>the disk of the computer, a <code>String</code></li>
 * </ol>
 *
 * @author YangYongze(id:2019302768)
 * @version  1.1.0
 * @see Product
 */
public class Computer extends Product   {
    
    /* the cpu of the computer */
    private String cpu;

    /* the gpu of the computer */
    private String gpu;

    /* the ram of the computer */
    private String ram;

    /* the disk of the computer */
    private String disk;

    /**
     * Construct a <code>Computer</code> object.
     * 
     * @param code the code of the computer
     * @param brand the brand of the computer
     * @param cost the cost of the computer
     * @param price the price of the computer
     * @param cpu the cpu of the computer
     * @param gpu the gpu of the computer
     * @param ram the ram of the computer
     * @param disk the disks of the computer
     */
    public Computer(String code, String brand, double cost, double price, 
                    String cpu, String gpu, String ram, String disk)  {
        super(code, brand, cost, price);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.disk = disk;        
    }

    /**
     * Returns the cpu of the computer.
     * 
     * @return cpu of the computer
     */
    public String getCpu() {
        return this.cpu;
    }

    /**
     * Resets the cpu of the computer.
     * 
     * @param cpu new cpu of the computer
     */
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    /**
     * Returns the gpu of the computer.
     * 
     * @return gpu of the computer
     */
    public String getGpu() {
        return this.gpu;
    }

    /**
     * Resets the gpu of the computer.
     * 
     * @param gpu new gpu of th computer.
     */
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    /**
     * Returns the ram of the computer.
     * 
     * @return ram of the computer
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
     * Returns <code>true</code> if this computer is equal to the argument
     * 
     * @param o  object with which this computer is compared.
     * @return  <code>true</code> if this computer is equal to
     *          the argument; <code>false</code> otherwise.       
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Computer)) {
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(cpu, computer.cpu) && Objects.equals(gpu, computer.gpu) 
                && Objects.equals(ram, computer.ram) && Objects.equals(disk, computer.disk);
    }

    /**
     * Returns the string representation of this computer.
     *
     * @return  the string representation of this computer.
     */
    @Override
    public String toString() {
        return "Computer:   " + 
            super.toString()+
            " cpu:'" + getCpu() + "'" +
            ", gpu:'" + getGpu() + "'" +
            ", ram:'" + getRam() + "'" +
            ", disk:'" + getDisk() + "'" ;
    }
}
/*!End Snippet:file*/