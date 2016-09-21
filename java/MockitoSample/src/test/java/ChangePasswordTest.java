import cl.mockito.sample.User;
import cl.mockito.sample.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChangePasswordTest {

    private UserDao userDao;

    @Before
    public void init(){

        userDao = mock(UserDao.class);

    }


    @Test
    public void testFindUserByName(){

        User user = new User("carlos", "12345");
        when(userDao.findByName("carlos")).thenReturn(user);

        String newPassword = "646383";
        user.changePassword(newPassword);

        assertTrue(user.checkPassword(newPassword));

    }

    @Test
    public void testFindAllUsers(){

        List<User> users = new ArrayList<User>();
        User user;

        for(int i=0; i<5;i++){
            user = new User("nombre"+i, "1234"+i);
            users.add(user);
        }

        when(userDao.getAll()).thenReturn(users);

        assertEquals(userDao.getAll().size(),5);

    }

    @Test
    public void test(){
        boolean isOk = true;
        when(userDao.findByName("")).thenThrow(new IllegalArgumentException());

        try{
            userDao.findByName("");
        }catch (IllegalArgumentException ex){
            isOk = false;
            assertTrue(true);
        }

        if(isOk){
            fail();
        }
    }

}
