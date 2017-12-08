package sustainableapps.coursera.org.loginactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class LoginActivity extends Activity {

    /**
     * Debugging tag used by the Android logger.
     * In the code I had to shove Lod.d's into try / catch,
     * so that UnitTest could get around them and not give an error.
     */
    public static final String TAG = LoginActivity.class.getName();


    /**
     * Hook method called when a new instance of Activity is created.
     *
     * @param savedInstanceState **A Bundle object that contains the state
     *                           of the user interface stored in the last call
     *                           of the onSaveInstanceState handler.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // ============= CHECKING PASSWORD =============

    /**
     * The method returns true if the password length is > 8.
     *
     * @param pass **This is parameter passed to the method as a string with a password.
     * @return true/false
     */
    public boolean passwordLength(String pass){
        try {
            Log.d(TAG, "=== passwordLength checking ===");
        } catch (Exception e) {
            // Ignore
        }
        return (pass.length() > 8);
    }

    /**
     * The method returns true if the password contains all spaces.
     *
     * @param pass1 **This is parameter passed to the method as a string with a password.
     * @return true/false
     */
    public boolean isPassAllSpaces(String pass1){
        try {
            Log.d(TAG, "=== isPassAllSpaces checking ===");
        } catch (Exception e) {
            // Ignore
        }

        return (pass1.replace(" ", "").equals(""));
    }

    // ============= CHECKING EMAIL ADDRESS =============
    /**
     * This method checks if the provided string represents a
     * valid email address and returns true if it is.
     *
     * @param email **This is parameter passed to the method as a string with a email.
     * @return true/false
     */
    public boolean isAtSignInEmailAddress(String email) {
        try {
            Log.d(TAG, "=== isAtSignInEmailAddress checking ===");
        } catch (Exception e) {
            // Ignore
        }

        return email.contains("@");
    }

    /**
     * This method returns true if the length of the local part of an email address,
     * which is the part that comes before "@" in the address,
     * is more >= 1.
     *
     * @param email **This is parameter passed to the method as a string with a email.
     * @return true/false
     */
    public boolean isOneCharBeforeAt(String email){
        int start = email.indexOf("@");

        try {
            Log.d(TAG, "=== isOneCharBeforeAt checking ===");
        } catch (Exception e) {
            // Ignore
        }

        String localPart = email.substring(0, start);
        return (localPart.length() >= 1);
    }

    /**
     * This method returns true if email address has at least 3 characters,
     * including a "." after the "@" sign.
     *
     * @param email **This is parameter passed to the method as a string with a email.
     * @return true/false
     */
    public boolean isThreeCharAfterAtSign(String email){
        int middle = email.indexOf("@");
        String endPart = email.substring(middle+1);
        try {
            Log.d(TAG, "=== isThreeCharAfterAtSign checking ===");
        } catch (Exception e) {
            // Ignore
        }

        return (endPart.length() >=3 && endPart.contains("."));
    }

    /**
     * The method shows toast in the center of display.
     * @param toastString **This is parameter passed to the method
     *                    as a string with a toast message..
     */
    public void showToast(final String toastString){
        Context context = LoginActivity.this;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toastString, duration);

        // This parameter allows to show toast in the center of display
        // (not at the bottom of the display).
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        try {
            Log.d(TAG, toastString);
        } catch (Exception e) {
            // Ignore
        }

        toast.show();
    }

    /**
     * The method is called by pressing the Login button.
     * It checks EMAIL and PASSWORD and call showToast
     * to display appropriate message.
     *
     * @param view **This is View object which represents
     *             the basic building block for user interface components.
     */
    public void onLoginButtonClick(View view) {

        Log.d(TAG, "=== BUTTON PRESSED   ===");

        EditText emailView = findViewById(R.id.email);
        String EMAIL = emailView.getText().toString();
        Log.d(TAG, "=== got Email ===");

        EditText passwordView = findViewById((R.id.password));
        String PASSWORD = passwordView.getText().toString();
        Log.d(TAG, "=== got Password ===");

        if (!isAtSignInEmailAddress(EMAIL) ||
                !isOneCharBeforeAt(EMAIL) ||
                !isThreeCharAfterAtSign(EMAIL)) {
            showToast(getResources().getString(R.string.addrInvalid));
        } else if (!isPassAllSpaces(PASSWORD) && passwordLength(PASSWORD)) {
            showToast(getResources().getString(R.string.success));
        } if (isPassAllSpaces(PASSWORD)) {
            showToast(getResources().getString(R.string.passInavlid));
        } if (!passwordLength(PASSWORD)) {
            showToast(getResources().getString(R.string.tooShort));
        }
    }
}