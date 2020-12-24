package po.demo.persistence;

import org.hibernate.SessionFactory;


import javax.persistence.*;
import java.util.List;
import java.util.Random;

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
        EntityManager em = sessionFactory.createEntityManager();
        Random random = new Random();

        try {
            boolean exists = true;
            while (exists) {
                exists = false;
                product.setId(random.nextInt());

                try {
                    em.persist(product);
                } catch (EntityExistsException eee) {
                    exists = true;
                }
            }
        } catch (Exception ex){
            throw new PersistenceException();
        }
    }

    @Override
    public void removeProduct(int id) {
        EntityManager em = sessionFactory.createEntityManager();

        try {
            Product product = em.find(Product.class, id);
            if(product != null)
                em.remove(product);
            else
                throw new EntityNotFoundException();
        } catch (Exception ex) {
            throw new PersistenceException();
        }
    }
}
