package web.DAO;

import web.models.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers ();
    User getUserById (Long id);
    void saveUser (User user);
    void updateUser (Long id, User updatedUser);
    void deleteUser (Long id);
}
