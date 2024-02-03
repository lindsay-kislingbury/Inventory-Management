import java.util.List;
import java.util.ArrayList;

class Store {
    private List<Product> inventory;

    public Store() {
        inventory = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    public double calculateTotalValue() {
        double total = 0.0;

        for (Product product : inventory) {
            total += product.getPrice() * product.getQuantity();
        }

        return total;
    }

    public int calculateTotalNumberOfProducts() {
        int total = 0;

        for (Product product : inventory) {
            total += product.getQuantity();
        }

        return total;
    }

    public Product searchProductByName(String name) {
        for (Product product : inventory) {
            if (product.getName().equals(name)) {
                return product;
            }
        }

        return null;
    }

    public List<Product> getAllProducts() {
        return inventory;
    }

}
