package GMR_Back.gmr.model.repository;

import GMR_Back.gmr.model.entity.User;
import java.util.*;

public interface UserRepository {
    User findById(Long id);
    List<User> findAll();
    void insert(User user);
    void deleteById(Long id);
}
