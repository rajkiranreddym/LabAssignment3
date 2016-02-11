package com.example.rajkiranreddym.signup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText lastname;
    private static EditText firstname;
    private static EditText email;
    private static EditText password;
    private static Button image;
    private static Button signup;
    private static Button gallery;
    private static ImageView imageView;
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lastname = (EditText) findViewById(R.id.editText_lastname);
        firstname = (EditText) findViewById(R.id.editText_firstname);
        email = (EditText) findViewById(R.id.editText_email);
        password = (EditText) findViewById(R.id.editText_password);
        image = (Button) findViewById(R.id.button_image);
        signup = (Button) findViewById(R.id.button_signup);
        gallery = (Button) findViewById(R.id.button_gallery);
        userImage = (ImageView)findViewById(R.id.imgView);



    }
    public void onClickbutton_image(View v) {
        //This code redirects to the photo activity.
        Intent redirect = new Intent(MainActivity.this, PhotoActivity.class);
        startActivity(redirect);
    }
    public void onClickbutton_gallery(View v) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
// Start the Intent
        startActivity(galleryIntent);

    }


    // signup.setOnClickListener(new View.OnClickListener() {

    public void onClickbutton_signup(View v) {
        lastname.getText().toString();
        firstname.getText().toString();
        email.getText().toString();
        password.getText().toString();

        Toast.makeText(MainActivity.this, "" +
                        "account created",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
        }
    }///else {
    //  Toast.makeText(MainActivity.this, "Username and password incorrect", Toast.LENGTH_SHORT).show();


   // @Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
