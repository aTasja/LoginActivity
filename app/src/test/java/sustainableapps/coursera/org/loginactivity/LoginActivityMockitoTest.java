package sustainableapps.coursera.org.loginactivity;

///////// This test is not suitable for the app.///////////

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityMockitoTest {

    @Mock
    private LoginActivity loginActivity;

    @Before
    public void setUp(){
        loginActivity = new LoginActivity();
    }

    @Test
    public void rightEmailAndPassword() throws Exception{
        //loginActivity.getEmail("a_tasja@mail.ru");
        //loginActivity.getPassword("123456789");

    }
}
