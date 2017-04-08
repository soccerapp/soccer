package net.ddns.wizards.soccer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Goles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goles);
    }

    public void principal (View view){
        Intent i = new Intent(this, principal.class);
        startActivity(i);
        finish();
    }
}