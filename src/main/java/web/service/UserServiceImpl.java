package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.models.User;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    final
    UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List <User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void saveUser(User user) { userDAO.saveUser(user); }

    @Override
    public void updateUser(Long id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }
}
