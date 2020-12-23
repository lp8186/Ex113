package com.example.ex113;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Liad Peretz
 * @version 1.0
 * @since 16 /12/20 Short description- Practice for Internal Files.
 */
public class MainActivity extends AppCompatActivity {


    EditText text1;
    TextView summary;
    String line,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1= (EditText) findViewById(R.id.text1);
        summary= (TextView) findViewById(R.id.summary);

        try {
            FileInputStream fis= openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();

            line = br.readLine();
            while (line != null) {
                sb.append(line+'\n');
                line = br.readLine();
            }
            summary.setText(sb.toString());
            text= sb.toString();
            isr.close();


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        summary.setText(text);



    }

    /**
     * Save
     * Short descriptions- Saves the written information.
     * <p>
     *     View view
     * @param view the view
     */
    public void save(View view) {
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(text+'\n'+text1.getText().toString());
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text= text+'\n'+text1.getText().toString();
        summary.setText(text);
    }

    /**
     * Reset
     * Short descriptions- Cleans the TextView.
     * <p>
     *     View view
     * @param view the view
     */
    public void reset(View view) {
        summary.setText("");
        text= "";
    }

    /**
     * Exit
     * Short descriptions- Saves the written information and closes the app.
     * <p>
     *     View view
     * @param view the view
     */
    public void exit(View view) {
        save(view);
        finish();
    }

    /**
     * OnCreateOptionsMenu
     * Short descriptions- "Calls" the options menu.
     * <p>
     *    Menu menu
     * @param menu the menu
     * @return true if it worked.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * OnOptionsItemSelected
     * Short description- Starts the credits activity.
     * <p>
     *     MenuItem item
     * @param item the selected item
     * @return true if it worked.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.credits){
            Intent si = new Intent(this, Credits.class);
            startActivity(si);}
        return true;
    }
}