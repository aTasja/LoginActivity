package sustainableapps.coursera.org.loginactivity;

import android.support.test.espresso.assertion.ViewAssertions.*;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class implements espresso tests of the app.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule <>(LoginActivity.class);

    @Before
    public void setUp(){
        mActivityRule.getActivity();
    }

    @Test
    public void testPasswordLengthRuleTriggersErrorMsg() {
            onView(withId(R.id.email)).perform(typeText("afrrfa@mafffl.fffu"));
            onView(withId(R.id.password)).perform(typeText("abc"));
            onView(withId(R.id.button)).perform(click());

            onView(withText(R.string.tooShort)).inRoot(new ToastMatcher())
                    .check(matches(withText("The provided password is too short")));
    }

    @Test
    public void testPasswordPassAllSpacesTriggersErrorMsg() {
        onView(withId(R.id.email)).perform(typeText("adea@mdfd.ee"));
        onView(withId(R.id.password)).perform(typeText("         "));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.passInavlid)).inRoot(new ToastMatcher())
                .check(matches(withText("The provided password is invalid")));
    }

    @Test
    public void testEmailAtRuleTriggersErrorMsg() {
        onView(withId(R.id.email)).perform(typeText("efeffdfamadel.ff"));
        onView(withId(R.id.password)).perform(typeText("1234 56789"));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.addrInvalid)).inRoot(new ToastMatcher())
                .check(matches(withText("Invalid email address")));
    }

    @Test
    public void testEmailBeforeAtRuleTriggersErrorMsg() {
        onView(withId(R.id.email)).perform(typeText("@effe.efu"));
        onView(withId(R.id.password)).perform(typeText("12345678qwEE"));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.addrInvalid)).inRoot(new ToastMatcher())
                .check(matches(withText("Invalid email address")));
    }

    @Test
    public void testEmailAfterAtRuleTriggersErrorMsg() {
        onView(withId(R.id.email)).perform(typeText("lknlncf@.u"));
        onView(withId(R.id.password)).perform(typeText("123456789abc"));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.addrInvalid)).inRoot(new ToastMatcher())
                .check(matches(withText("Invalid email address")));
    }

    @Test
    public void testEmailAfretAdDotRuleTriggersErrorMsg() {
        onView(withId(R.id.email)).perform(typeText("ajjj@mailru"));
        onView(withId(R.id.password)).perform(typeText("ab12FGRttyyao"));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.addrInvalid)).inRoot(new ToastMatcher())
                .check(matches(withText("Invalid email address")));
    }

    @Test
    public void testLoginSuccessRule() {
        onView(withId(R.id.email)).perform(typeText("g@mhhhhl.rtr"));
        onView(withId(R.id.password)).perform(typeText("ajbjscbjJHJKJBbc"));
        onView(withId(R.id.button)).perform(click());

        onView(withText(R.string.success)).inRoot(new ToastMatcher())
                .check(matches(withText("Login success")));
    }

}
