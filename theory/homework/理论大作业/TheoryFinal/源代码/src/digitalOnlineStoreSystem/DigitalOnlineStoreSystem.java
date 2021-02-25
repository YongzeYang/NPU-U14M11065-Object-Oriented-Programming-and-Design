/*!Begin Snippet:file*/
package digitalOnlineStoreSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 * This class implements a digital online store system.
 *
 * @author YangYongze(id:2019302768)
 * @version 1.1.0
 * @see BulkOrder
 * @see Computer
 * @see Device
 * @see Item
 * @see Laptop
 * @see Order
 * @see OrderManager
 * @see Phone
 * @see Product
 * @see ProductCatalog
 * @see SmallOrder
 * @see Tablet
 * @see OrderFormatter
 * @see HTMLOrderFormatter
 * @see XMLOrderFormatter
 * @see PlainTextOrderFormatter
 */
public class DigitalOnlineStoreSystem {
    
    private static BufferedReader stdIn =
            new  BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new  PrintWriter(System.out, true);
    private static PrintWriter  stdErr = new  PrintWriter(System.err, true);

    private ProductCatalog productCatalog;
    private OrderManager orderManager;
    private OrderFormatter orderFormatter;

	/**
	 * Loads the information of the product catalog and the order manager and starts
	 * the application.
	 *
	 * @param args String arguments. Not used.
	 * @throws IOException if io error exists.
     * @throws ParseException if parse error exists.
	 */
    public static void main(String[] args) throws IOException, ParseException {
        
        DigitalOnlineStoreSystem app = new DigitalOnlineStoreSystem();

        app.run();
                
    }

    /**
	 * Presents the user with a menu of options and processes the selection.
     * 
     * @throws IOException if there are errors in the input.
	 */
    private void run() throws IOException {

        int choice = getChoice();

        while (choice != 0)  {

            if (choice == 1)  {
                addProduct();
            } else if (choice == 2)  {
                addOrder();
            } else if (choice == 3)  {
                displayProduct();
            } else if (choice == 4)  {
                displayOrder();
            } else if (choice == 5)  {
                displayProductCatalog();
            } else if (choice == 6)  {
                displayOrders();
            } else if (choice == 7)  {
                exportOrders();
            }

            choice = getChoice();
        }
    
    }

    /**
	 * Presents the user with a menu of options and processes the selection.
     * 
     * @throws IOException if there are errors in the input.
     * @return the number user typed.
	 */
    private int getChoice() throws IOException  {
        int input;

        do  {
            try  {
                stdErr.println();
                stdErr.print("[0]  Quit\n"
                        + "[1]  Add product\n"
                        + "[2]  Add orders\n"
                        + "[3]  Display product by code\n"
                        + "[4]  Display order by code\n"
                        + "[5]  Display product catalog\n"
                        + "[6]  Display order catalog\n"
                        + "[7]  Export order list\n"
                        + "choice> ");
                stdErr.flush();

                input = Integer.parseInt(stdIn.readLine());

                stdErr.println();

                if (0 <= input && 7 >= input)  {
                    break;
                } else {
                    stdErr.println("Invalid choice:  " + input);
                }
            } catch (NumberFormatException nfe)  {
                stdErr.println(nfe);
            }
            
        }  while(true);

        return input;
    }

    /**
     * Display sub-menu of adding a product and get user's choice.
     * 
     * @throws IOException
    */
    private void addProduct() throws IOException {
        try  {
            stdErr.println();
            stdErr.print("[0]  Quit\n"
                    + "[1]  Computer\n"
                    + "[2]  Laptop\n"
                    + "[3]  Tablet\n"
                    + "[4]  Phone\n"
                    + "[5]  Device\n"
                    + "choice> ");
            stdErr.flush();
            
            int input = Integer.parseInt(stdIn.readLine());

            stdErr.println();

            if (0 <= input && 5 >= input)  {
                readProduct(input);
            } else {
                stdErr.println("Invalid choice:  " + input);
            }
        } catch (NumberFormatException nfe)  {
            stdErr.println(nfe);
        }
    }

    /**
     * Add product by user's choice and gives user format and a sample. 
     * 
     * @param choice type of the product
     */
    private void readProduct (int choice) {
        try {
            switch(choice){
                case(1):
                    System.out.println("Format: Code_Brand_Cost_Price_CPU_GPU_RAM_DISK.");
                    System.out.println("Sample: C01_Lenovo_15999.0_18999.0_intel-i9_RTX3090s_32G_2TSSD");
                    System.out.print(">");
                    productCatalog = addProductByToken(new StringTokenizer(stdIn.readLine(), "_"), productCatalog);
                    break;
                case(2):
                    System.out.println("Format: Code_Brand_Cost_Price_CPU_GPU_RAM_DISK_Weight.");
                    System.out.println("Sample: L01_Huawei_5699.0_6599.0_AMD-R7_UHD630_8G_1TSSD_1.7");
                    System.out.print(">");
                    productCatalog = addProductByToken(new StringTokenizer(stdIn.readLine(), "_"), productCatalog);
                    break;
                case(3):
                    System.out.println("Format: Code_Brand_Cost_Price_CPU_Size_DISK_Weight.");
                    System.out.println("Sample: T01_Apple_6299.0_7199.0_A12_10.5_256G_0.7");
                    System.out.print(">");
                    productCatalog = addProductByToken(new StringTokenizer(stdIn.readLine(), "_"), productCatalog);
                    break;
                case(4):
                    System.out.println("Format: Code_Brand_Cost_Price_CPU_Ram_DISK_CameraPixel.");
                    System.out.println("Sample: P01_Huawei_3000.0_3299.0_Kirin_12G_256G_50M");
                    System.out.print(">");
                    productCatalog = addProductByToken(new StringTokenizer(stdIn.readLine(), "_"), productCatalog);
                    break;
                case(5):
                    System.out.println("Format: Code_Brand_Cost_Price_Type_Usage.");
                    System.out.println("Sample: D01_Apple_3299.0_3999.0_watch_wearing");
                    System.out.print(">");
                    productCatalog = addProductByToken(new StringTokenizer(stdIn.readLine(), "_"), productCatalog);
                    break;                
            }
        } catch(IOException e) {
            stdErr.println("Invalid input!");
        }
    }

    /**
     * Display sub-menu of adding an order and get user's choice.
     * 
     * @throws IOException
     */
    private void addOrder() throws IOException {
        try  {
            stdErr.println();
            stdErr.print("[0]  Quit\n"
                    + "[1]  Small order\n"
                    + "[2]  Bulk order\n"
                    + "choice> ");
            stdErr.flush();
            
            int input = Integer.parseInt(stdIn.readLine());

            stdErr.println();

            if (0 <= input && 2 >= input)  {
                readOrder(input);
            } else {
                stdErr.println("Invalid choice:  " + input);
            }
        } catch (NumberFormatException ioe)  {
            stdErr.println("Invalid input!");
        }
    }

    /**
     * Add order to order manager by user's choice.
     * 
     * @param input type of the order
     */
    private void readOrder(int input) {
        try{
            switch(input) {
                case(1) :
                System.out.println("Format: Code_Date_Cost_ProductCode_ProductQuantity.");
                System.out.println("Sample: S0001_1-10_25.0_C01_1");
                System.out.print(">");
                orderManager = addOrderByToken(new StringTokenizer(stdIn.readLine(), "_"), orderManager, productCatalog);
                break;
                case(2) :
                System.out.println("Format: Code_Date_Cost_ProductCode1_ProductQuantity1_ProductCode2_ProductQuantity2_..._ProductCodeN_ProductQuantityN.");
                System.out.println("Sample: B0001_5-23_256.0_C05_1_T01_6_D03_8_L02_4_L04_2");
                System.out.print(">");
                orderManager = addOrderByToken(new StringTokenizer(stdIn.readLine(), "_"), orderManager, productCatalog);
                break;
            }
        } catch (IOException ioe)  {
            stdErr.println("Invalid input!");
        }
    }

    /**
     * Display <code>Product</code> by code.
     */
    private void displayProduct()  {
        stdErr.println("Please enter the code of the Product.");
        stdErr.print(">");
        stdErr.flush();
        try {
            int flag = 0;
            String code = stdIn.readLine();
            for(Product product : productCatalog.getProducts()) {
                if(product.getCode().equals(code))  {
                    stdErr.println(product.toString());
                    flag = 1;
                }
            }
            if(flag!=1) stdErr.println("The Product of " + code + " does not exist!");
        } catch (IOException e) {
            stdErr.println("Invalid input!");
        }
    }

    /**
     * Display <code>Order</code> by code.
     */
    private void displayOrder()  {
        stdErr.println("Please enter the code of the Order.");
        stdErr.print(">");
        stdErr.flush();
        try {
            int flag = 0;
            String code = stdIn.readLine();
            for(Order order : orderManager.getBulkOrders()) {
                if(order.getCode().equals(code))  {
                    stdErr.println(order.toString());
                    flag = 1;
                }
            }
            for(Order order : orderManager.getSmallOrders()) {
                if(order.getCode().equals(code))  {
                    stdErr.println(order.toString());
                    flag = 1;
                }
            }
            if(flag!=1) stdErr.println("The Product of " + code + " does not exist!");
        } catch (IOException e) {
            stdErr.println("Invalid input!");
        }
    }


    /**
     * Display the catalog of all <code>Products</code>.
     */
    private void displayProductCatalog ()  {

        if(productCatalog.getNumberOfProducts() > 0)  {
            for(Product product:productCatalog.getProducts())
                stdOut.println(product.toString());

        } else {
            stdErr.println("None product exists!");
        }
             
    }

    /**
     * Display the catalog of all <code>Orders</code>.
     */    
    private void displayOrders()  {
        if(orderManager.getSmallOrders().size() + orderManager.getBulkOrders().size() > 2) {
            for(Order order:orderManager.getSmallOrders())
                stdOut.println(order.toString());
                stdOut.println("\n");
            for(Order order:orderManager.getBulkOrders())
                stdOut.println(order.toString());
        } else {
            stdErr.println("None product exists!");
        }
    }

    /**
     * Display the sub-menu of exporting order list.
     * @throws IOException
     */
    private void exportOrders() throws IOException {
        int input;
        try {
            stdErr.println();
            stdErr.print("[0]  Quit\n" + 
                         "[1]  Display Plain Text\n" + 
                         "[2]  Display HTML\n" + 
                         "[3]  Display XML\n" + 
                         "choice> ");
            stdErr.flush();

            input = Integer.parseInt(stdIn.readLine());

            stdErr.println();

            if (0 <= input && 3 >= input) {
                generateFile(input);
            } else {
                stdErr.println("Invalid choice:  " + input);
            }
        } catch (NumberFormatException nfe) {
            stdErr.println("Invalid input");
        }
    }

    /**
     * Set formatter and generate the file of formatter by input type.
     * 
     * @param input the type of output file
     */
    private void generateFile(int input) {
        FileWriter fw = null;
        String filename = "";

        switch(input) {
            case(1) :
                setOrderFormatter(PlainTextOrderFormatter.getSingletonInstance());
                filename = "total-orders.dat";
                break;
            case(2) :
                setOrderFormatter(HTMLOrderFormatter.getSingletonInstance());
                filename = "total-orders.html";
                break;
            case(3) :
                setOrderFormatter(XMLOrderFormatter.getSingletonInstance());
                filename = "total-orders.xml";
                break;
        }

        try {
			fw = new FileWriter(filename);
            fw.write(orderFormatter.formatOrders(orderManager));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
    }

    /**
     * Set the <code>OrderFormatter</code> of the system.
     * 
     * @param orderFormatter the new OrderFormatter
     */
    private void setOrderFormatter(OrderFormatter orderFormatter) {

        this.orderFormatter = orderFormatter;
    }


    /**
     * Constructs a <code>digitalOnlineStoreSystem</code> object. Initiallize 
     * product catalog and order manager.
     * 
     * @throws IOException if io error exists.
     * @throws ParseException if parse error exists.
     */
    public DigitalOnlineStoreSystem() throws IOException, ParseException {
        productCatalog = loadProduct();
        orderManager = loadOrder(productCatalog);
    }

    /**
     * Add a <code>Product</code> to product catalog.
     * Use <code>StringTokenizer</code> to seperate arguments.
     * 
     * @param line the line that need to be tokenized
     * @param productCatalog the product catalog of the system
     * @return productCatalog after adding the product
     */
    private static ProductCatalog addProductByToken(StringTokenizer line, ProductCatalog productCatalog)  {
        
        String code = line.nextToken();

        switch(code.charAt(0)) {
            case 'C':
                if(line.countTokens() == 7) 
                    productCatalog.addProduct(new Computer(code, line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        Double.parseDouble(line.nextToken()),
                                                        line.nextToken(), line.nextToken(), 
                                                        line.nextToken(), line.nextToken()));
                else System.out.println("Invalid input!");
                break;

            case 'L':
                if(line.countTokens() == 8) 
                    productCatalog.addProduct(new Laptop(code, line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        Double.parseDouble(line.nextToken()),
                                                        line.nextToken(), line.nextToken(), 
                                                        line.nextToken(), line.nextToken(),
                                                        Double.parseDouble(line.nextToken())));
                else System.out.println("Invalid input!");
                break;

            case 'T':
                if(line.countTokens() == 7) 
                    productCatalog.addProduct(new Tablet(code, line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        Double.parseDouble(line.nextToken()),
                                                        line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        line.nextToken(), 
                                                        Double.parseDouble(line.nextToken())));
                else System.out.println("Invalid input!");
                break;

            case 'P':
                if(line.countTokens() == 7) 
                    productCatalog.addProduct(new Phone(code, line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        Double.parseDouble(line.nextToken()),
                                                        line.nextToken(), line.nextToken(), 
                                                        line.nextToken(), line.nextToken()));
                else System.out.println("Invalid input!");
                break;

            case 'D':
                if(line.countTokens() == 5) 
                    productCatalog.addProduct(new Device(code, line.nextToken(), 
                                                        Double.parseDouble(line.nextToken()), 
                                                        Double.parseDouble(line.nextToken()),
                                                        line.nextToken(), line.nextToken()));
                else System.out.println("Invalid input!");
                break;

            default :
                System.out.println("Invalid input!");
                break;
        }
        return productCatalog;
    }

    /**
     * Add a <code>Order</code> to Order Manager.
     * Use <code>StringTokenizer</code> to seperate arguments.
     * 
     * @param line the line that need to be tokenized
     * @param OrderManager the order manager of the system
     * @param productCatalog the product catalog of the system
     * @return productCatalog after adding the product
     */
    private static OrderManager addOrderByToken(StringTokenizer line, OrderManager orderManager, ProductCatalog productCatalog) {
        String code = line.nextToken();

        switch(code.charAt(0)) {
            case 'S':
            if(line.countTokens() == 4) 
                orderManager.addSmallOrder(new SmallOrder(code, line.nextToken(),
                                            Double.parseDouble(line.nextToken()),
                                            new Item(productCatalog.getProduct(line.nextToken()), 
                                                Integer.parseInt(line.nextToken()))));
            else System.out.println("Invalid input!");
            break;

            case 'B':
            if(line.countTokens() >= 4) {
                orderManager.addBulkOrder(new BulkOrder(code, line.nextToken(),
                                            Double.parseDouble(line.nextToken())));
                while(line.hasMoreTokens()) {
                    orderManager.getBulkOrder(code).addItem(new Item(
                        productCatalog.getProduct(line.nextToken()), Integer.parseInt(line.nextToken())));
                }
            } else System.out.println("Invalid input!");
            break;


            default :
                System.out.println("Invalid input!");
                break;

        }

        return orderManager;
    }

    /**
     * Load initial Products form original file.
     * 
     * @return Product Catalog after loading
     * @throws ParseException
     */
    private static ProductCatalog loadProduct() throws ParseException  {

        ProductCatalog productCatalog = new ProductCatalog();
        
        FileReader fr = null;
        BufferedReader br = null;

        String fileName = "resources\\products.dat";

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String str = "";

            while ((str = br.readLine())!= null){

                StringTokenizer line = new StringTokenizer(str,"_");
                addProductByToken(line, productCatalog);

                }
            

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                br.close();
                fr.close();
            } catch(IOException e)  {
                e.printStackTrace();
            }
        }
        
        return productCatalog;
        
    }

    /**
     * Load initial Orders form .dat file.
     * 
     * @param productCatalog the product catalog of the system
     * @return the order manager after loading
     * @throws ParseException
     */
    private static OrderManager loadOrder(ProductCatalog productCatalog) throws ParseException  {

        OrderManager orderManager = new OrderManager();

        FileReader fr = null;
        BufferedReader br = null;

        String fileName = "resources\\orders.dat";

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String str = "";

            while ((str = br.readLine())!= null){

                StringTokenizer line = new StringTokenizer(str,"_");
                addOrderByToken(line, orderManager, productCatalog);
                
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                br.close();
                fr.close();
            } catch(IOException e)  {
                e.printStackTrace();
            }
        }

        return orderManager;

    }

}

/*!End Snippet:file*/
