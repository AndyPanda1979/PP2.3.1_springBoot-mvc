package web.DAO;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List <User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User proxyUser = entityManager.find(User.class, id);
        entityManager.remove(proxyUser);
    }
}
