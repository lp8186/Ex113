package com.example.ex113;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * @author Liad Peretz
 * @version 1.0
 * @since 16/12/20
 * Short description- Credits.
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * OnCreateOptionsMenu
     * Short descriptions- "Calls" the options menu.
     * <p>
     *    Menu menu
     * @param menu the menu
     * @return true if it worked.
     */
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * OnOptionsItemSelected
     * Short description- Finishes the activity and returns to the main activity.
     * <p>
     *      MenuItem item
     * @param item the selected item
     * @return true if it worked.
     */
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if (id==R.id.main)
            finish();
        return true;
    }
}