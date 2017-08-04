package com.example.abdul_wahab.sharedpreferencesummer17;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.etInput);
        btnSave = (Button) findViewById(R.id.btnSave);



        //Singleton Design Pattern
        final SharedPreferences sp = getSharedPreferences("mysettings", MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = etInput.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("input", input);
                editor.commit();
            }
        });


        String s = sp.getString("input", null);
        if (s == null) {
            etInput.setText("First time login");
        } else {
            etInput.setText(s);
        }


    }
}
