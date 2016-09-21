package cl.mockito.sample;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    User findByName(String name);
}
