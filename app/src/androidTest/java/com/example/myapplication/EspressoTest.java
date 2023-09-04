package com.example.myapplication;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testEditTextAndButtonInteraction() {

        // Ingresa texto en el EditText
        Espresso.onView(withId(R.id.editText)).perform(ViewActions.typeText("Hello, Espresso!"));

        // Cierra el teclado virtual
        Espresso.closeSoftKeyboard();

        // Haz clic en el botón
        Espresso.onView(withId(R.id.button)).perform(ViewActions.click());

        // Verifica que el texto esperado se muestre en un TextView
        Espresso.onView(withId(R.id.textView))
                .check(ViewAssertions.matches(withText("Hello, Espresso!")));
    }
}