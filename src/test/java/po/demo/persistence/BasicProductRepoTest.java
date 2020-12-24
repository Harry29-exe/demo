package po.demo.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class BasicProductRepoTest {

    private SessionFactory sessionFactory;

    @BeforeAll
    public void init() {
        Configuration config = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://ec2-54-246-67-245.eu-west-1.compute.amazonaws.com:5432/de70v6uesk4fuv");
        properties.put(Environment.USER, "zccupplccthenr");
        properties.put(Environment.PASS, "f0ee20cb1a9ae74373abb656c2b492832e7de2301fbc6a663fae002f1963bb11");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");


        config.setProperties(properties);
        config.addAnnotatedClass(Product.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    @Test
    void getProducts() {
    }

    @Test
    void testGetProducts() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void removeProduct() {
    }
}
