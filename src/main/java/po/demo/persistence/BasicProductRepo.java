package po.demo.persistence;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BasicProductRepo implements ProductRepo {

    private final SessionFactory sessionFactory;

    public BasicProductRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getProducts() {
        EntityManager em = sessionFactory.createEntityManager();
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p",
                Product.class);
        List<Product> products = null;

        try {
            products = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return products != null && products.size() > 0 ? products : null;
    }

    @Override
    public List<Product> getProducts(int amount) {
//        List<Product> products = this.getProducts();
//
//        if (products == null || products.size() == 0)
//            return null;
//        else if (products.size() > amount)
//            return products.subList(0, amount);
//        else
//            return products;
        EntityManager em = sessionFactory.createEntityManager();
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p",
                Product.class);
        query.setMaxResults(amount);
        List<Product> products = null;

        try {
            products = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return products != null && products.size() > 0 ? products : null;
    }

    @Override
    public Product getProduct(int id) {
        EntityManager em = sessionFactory.createEntityManager();
        Product product = null;

        try {
            product = em.find(Product.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return product;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProduct(int id) {

    }
}
