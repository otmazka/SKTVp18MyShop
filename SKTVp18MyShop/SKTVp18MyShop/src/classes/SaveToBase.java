package classes;

import entity.Buyer;
import entity.History;
import entity.Product;
import interfaces.Saveble;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveToBase implements Saveble {

    EntityManager em;
    EntityTransaction tx;

    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18MyShopPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public void saveProducts(List<Product> listProducts) {
        List<Product> listProductsSaved = loadProducts();
        tx.begin();
            for(int i=0; i<listProducts.size();i++){
                if(listProductsSaved.contains(listProducts.get(i))
                        && !listProductsSaved.get(i).equals(listProducts.get(i))){
                    em.merge(listProducts.get(i));
                }else{
                    em.persist(listProducts.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Product> loadProducts() {
        return em.createQuery("SELECT p FROM Product p")
                .getResultList();
    }

    @Override
    public void saveBuyers(List<Buyer> listBuyers) {
        List<Buyer> listBuyersSaved = loadBuyers();

        tx.begin();
            for(int i=0; i<listBuyers.size();i++){
                if(listBuyersSaved.contains(listBuyers.get(i))
                        && !listBuyersSaved.get(i).equals(listBuyers.get(i))){
                    em.merge(listBuyers.get(i));
                }else{
                    em.persist(listBuyers.get(i));
                }
            }
        tx.commit();
    }

    @Override
    public List<Buyer> loadBuyers() {
        return em.createQuery("SELECT b FROM Buyer b")
                .getResultList();
    }

    @Override
    public void saveHistories(List<History> listHistories) {
        List<History> listHistoriesSaved = null;
        
            for(int i=0; i<listHistories.size();i++){
                listHistoriesSaved = loadHistories();
                tx.begin();
                    if(listHistoriesSaved.contains(listHistories.get(i))){
                        if(!listHistoriesSaved.get(i).equals(listHistories.get(i))){
                            em.merge(listHistories.get(i).getProduct());
                            em.merge(listHistories.get(i));
                        }
                    }else{
                        em.persist(listHistories.get(i));  
                        em.merge(listHistories.get(i).getProduct());
                    }
                tx.commit();
            }
        
    }
    @Override
   public List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }
}