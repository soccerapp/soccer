package net.ddns.wizards.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Reglamento2 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglamento2);

        imageView = (ImageView)findViewById(R.id.imageView1);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();
    }

    public void principal(View view) {
        Intent i = new Intent(this, principal.class);
        startActivity(i);
        finish();
    }
}
