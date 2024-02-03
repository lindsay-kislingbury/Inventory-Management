import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // Add initial products
        store.addProduct(new Electronics("iPhone", 999.99, 10, "Apple", "iPhone 15 Pro"));
        store.addProduct(new Electronics("Pixel", 699.99, 20, "Google", "Pixel 8"));
        store.addProduct(new Fruit("apple", 0.99, 100, LocalDate.now().plusDays(7)));
        store.addProduct(new Fruit("banana", 0.75, 200, LocalDate.now().plusDays(5)));
        store.addProduct(new Fruit("orange", 0.50, 300, LocalDate.now().minusDays(3)));

        // Menu
        while (true) {
            System.out.println("--------------------");
            System.out.println("this is a new test message!");
            System.out.println("Welcome to Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Calculate Total Inventory Value");
            System.out.println("4. Calculate Total Number of Products");
            System.out.println("5. Print Details of a Product");
            System.out.println("6. Check if a Fruit is Expired");
            System.out.println("7. View All Products");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Add Product
                    System.out.println("Enter Product Type (1. Electronics, 2. Fruit)");
                    int productType = scanner.nextInt();
                    System.out.println("Enter Product Name");
                    String name = scanner.next();
                    System.out.println("Enter Product Price");
                    double price = scanner.nextDouble();
                    System.out.println("Enter Product Quantity");
                    int quantity = scanner.nextInt();
                    if (productType == 1) {
                        System.out.println("Enter Manufacturer");
                        String manufacturer = scanner.next();
                        System.out.println("Enter Model");
                        String model = scanner.next();
                        store.addProduct(new Electronics(name, price, quantity, manufacturer, model));
                    } else if (productType == 2) {
                        System.out.println("Enter Expiry Date (YYYY-MM-DD)");
                        String expiryDate = scanner.next();
                        store.addProduct(new Fruit(name, price, quantity, LocalDate.parse(expiryDate)));
                    }
                    break;
                case 2: // Remove Product
                    System.out.println("Enter Product Name");
                    String productName = scanner.next();
                    Product productToRemove = store.searchProductByName(productName);
                    if (productToRemove != null) {
                        store.removeProduct(productToRemove);
                    } else {
                        System.out.println("Product Not Found");
                    }
                    break;
                case 3: // Calculate Total Inventory Value
                    System.out.println("Total Inventory Value: $");
                    System.out.printf(".2%f", store.calculateTotalValue());
                    break;
                case 4:
                    System.out.println("Total Number of Products: " + store.calculateTotalNumberOfProducts());
                    break;
                case 5: // Print Details of a Product
                    System.out.println("Enter Product Name");
                    String name1 = scanner.next();
                    Product productToShow = store.searchProductByName(name1);
                    if (productToShow != null) {
                        productToShow.print();
                    } else {
                        System.out.println("Product Not Found");
                    }
                    break;
                case 6: // Check if a Fruit is Expired
                    System.out.println("Enter Product Name");
                    String name2 = scanner.next();
                    Product productToCheck = store.searchProductByName(name2);
                    if (productToCheck != null) {
                        if (productToCheck instanceof Fruit) {
                            Fruit fruit = (Fruit) productToCheck;
                            if (fruit.isExpired()) {
                                System.out.println("Product is Expired");
                            } else {
                                System.out.println("Product is not Expired");
                            }
                        } else {
                            System.out.println("Product is not a Fruit");
                        }
                    } else {
                        System.out.println("Product Not Found");
                    }
                    break;
                case 7: // View All Products
                    for (Product product : store.getAllProducts()) {
                        product.print();
                    }
                    break;
                case 0: // Exit
                    System.exit(0);
            }

        }
    }
}