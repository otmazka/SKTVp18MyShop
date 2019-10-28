package interfaces;

import entity.Product;
import entity.History;
import entity.Buyer;
import java.util.List;

/**
 *
 * @author user
 */
public interface Saveble {
    public void saveProducts(List<Product> listProducts);
    public List<Product> loadProducts();
    public void saveBuyers(List<Buyer> listBuyers);
    public List<Buyer> loadBuyers();
    public void saveHistories(List<History> listHistories);
    public List<History> loadHistories();
}