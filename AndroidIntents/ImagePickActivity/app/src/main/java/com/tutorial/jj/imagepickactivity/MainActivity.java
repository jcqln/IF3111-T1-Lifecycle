package com.tutorial.jj.imagepickactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends ActionBarActivity {
 private static final int REQUEST_CODE = 1;
 private Bitmap bitmap;
 private ImageView imageView;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 imageView = (ImageView) findViewById(R.id.result);
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
 return true;
 }

 return super.onOptionsItemSelected(item);
 }

 public void pickImage(View view) {
 Intent intent = new Intent();
 intent.setType("image/*");
 intent.setAction(Intent.ACTION_GET_CONTENT);
 intent.addCategory(Intent.CATEGORY_OPENABLE);
 startActivityForResult(intent, REQUEST_CODE);
 }

 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 InputStream inputStream = null;
 if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
 if(bitmap != null) {
 bitmap.recycle();
 }
 try {
 inputStream = getContentResolver().openInputStream(data.getData());
 bitmap = BitmapFactory.decodeStream(inputStream);
 imageView.setImageBitmap(bitmap);
 if(inputStream != null) {
 inputStream.close();
 }
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 }
}