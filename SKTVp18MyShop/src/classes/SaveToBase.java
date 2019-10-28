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

        for (int i = 0; i < listProducts.size(); i++) {
            if (listProductsSaved.contains(listProducts.get(i))
                    && !listProductsSaved.get(i).equals(listProducts.get(i))) {
                tx.begin();
                em.merge(listProducts.get(i));
                tx.commit();
            } else if (listProducts.get(i).getId() == null) {
                tx.begin();
                em.persist(listProducts.get(i));
                tx.commit();
            } else {
                continue;
            }
        }
    }

    @Override
    public List<Product> loadProducts() {
        return em.createQuery("SELECT p FROM Book p")
                .getResultList();
    }

    @Override
    public void saveBuyers(List<Buyer> listBuyers) {
        List<Buyer> listBuyersSaved = loadBuyers();

        for(int i=0; i<listBuyers.size();i++){
            if(listBuyersSaved.contains(listBuyers.get(i))
                    && !listBuyersSaved.get(i).equals(listBuyers.get(i))){
                tx.begin();
                em.merge(listBuyers.get(i));
                tx.commit();
                continue;
            }
        }

    }

    @Override
    public List<Buyer> loadBuyers() {
        return em.createQuery("SELECT b FROM Reader b")
                .getResultList();
    }

    void saveHistory(List<History> listHistories) {
      
        for (History delHistory : listHistories) {
            int flag = 0;
            for (int i = 0; i < listHistories.size(); i++) {
                if (delHistory.getBuyer().equals(listHistories.get(i).getBuyer())) {
                    if (delHistory.getProduct().getId() == listHistories.get(i).getProduct().getId()) {
                        flag++;
                    }
                    
                }
            }
            if (flag > 1) {
                break;
            }
        }
        List<History> listHistoriesSaved = loadHistories();
        History newHistory = null;
        History editHistory = null;
       
        int i = 0;
        for (History h : listHistories) {
            if (!listHistoriesSaved.contains(h) && h.getId() == null) {
                newHistory = h;
                break;
            }
            if (listHistoriesSaved.contains(h) && !listHistoriesSaved.get(i).equals(h)) {
                editHistory = h;
                break;
            }
            
            i++;
        }
        if (newHistory != null) {
            tx.begin();
            em.persist(newHistory);
            em.flush();
            em.merge(newHistory.getProduct());
            tx.commit();
        }
        if (editHistory != null) {
            tx.begin();
            em.merge(editHistory);
            em.merge(editHistory.getProduct());
            tx.commit();
        }
        
    }

    @Override
    public List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }

    @Override
    public void saveHistories(List<History> listHistories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}