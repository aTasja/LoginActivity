package sustainableapps.coursera.org.loginactivity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginActivityTest {
    private LoginActivity loginActivity = new LoginActivity();

    @Test
    public void validAtSign() throws Exception{
        assertEquals(true, loginActivity.isAtSignInEmailAddress("a_tasja@mail.ru"));
    }

    @Test
    public void invalidAtSign() throws Exception{
        assertFalse(loginActivity.isAtSignInEmailAddress("a_tasja_mail.ru"));
    }

    @Test
    public void validStartOfEmail() throws Exception{
        assertTrue(loginActivity.isOneCharBeforeAt("a_tasja@mail.ru"));
    }

    @Test
    public void invalidStartOfEmail() throws Exception{
        assertFalse(loginActivity.isOneCharBeforeAt("@mail.ru"));
    }

    @Test
    public void validEndOfEmail() throws Exception{
        assertTrue(loginActivity.isThreeCharAfterAtSign("a_tasja@mail.ru"));
    }

    @Test
    public void endOfEmailWithoutDot() throws Exception{
        assertFalse(loginActivity.isThreeCharAfterAtSign("a_tasja@mail_ru"));
    }

    @Test
    public void endOfEmailLengthLess3() throws Exception{
        assertFalse(loginActivity.isThreeCharAfterAtSign("a@to"));
    }

    @Test
    public void validPassLength() throws Exception{
        assertTrue(loginActivity.passwordLength("19withlove76"));
    }
    @Test
    public void invalidPassLength() throws Exception{
        assertFalse(loginActivity.passwordLength("12we"));
    }
    @Test
    public void passNotAllSpaces() throws Exception{
        assertFalse(loginActivity.isPassAllSpaces("123 vbg5"));
    }
    @Test
    public void passAllSpaces() throws Exception{
        assertTrue( loginActivity.isPassAllSpaces("    "));
    }
}