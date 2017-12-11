package com.example.taruc.lab41sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private ImageView imageViewProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Linking UI to program
        textViewName = (TextView)findViewById(R.id.textViewname);
        imageViewProfile = (ImageView)findViewById(R.id.imageViewProfile);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected  void onResume(){
        super.onResume();
        loadPref();
    }

    private void loadPref() {
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String name = mySharedPreferences.getString("name_text", getString(R.string.pref_default_display_name));
        int gender = Integer.parseInt(mySharedPreferences.getString("gender_list",""));
        if(gender==1){
            textViewName.setText("MR. "+name);
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else if(gender==0){
            textViewName.setText("MS. "+name);
            imageViewProfile.setImageResource(R.drawable.female);
        }
        else {
            textViewName.setText("" + name);
            imageViewProfile.setImageResource(R.drawable.profile);
        }
    }
}
