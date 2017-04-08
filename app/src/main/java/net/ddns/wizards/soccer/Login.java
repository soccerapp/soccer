package net.ddns.wizards.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login1();
    }

    public void principal (View view) {
        Intent i = new Intent(this, principal.class);
        startActivity(i);
        finish();
    }

    public void login1() {

        Button Login = (Button) findViewById(R.id.btn2);
        Login.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText user=(EditText) findViewById(R.id.editText);
                String usuario = user.getText().toString();
                EditText pass=(EditText) findViewById(R.id.editText2);
                String password = pass.getText().toString();
                String user_stored="wizards";
                String pass_stored="wizards";


                if (usuario.equals(user_stored) & password.equals(pass_stored)){

                    findViewById(R.id.badLog).setVisibility(View.INVISIBLE);
                    change_activity();

                }

                else {
                    findViewById(R.id.badLog).setVisibility(View.VISIBLE);

                }
            }

        });
    }

    public void change_activity () {
        Intent myIntent = new Intent(getApplicationContext(), MenuAdministrador.class);
        startActivity(myIntent);
    }
}