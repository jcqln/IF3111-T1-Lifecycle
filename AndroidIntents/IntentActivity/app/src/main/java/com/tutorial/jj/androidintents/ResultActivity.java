package com.tutorial.jj.androidintents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ResultActivity extends ActionBarActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_result);
 String extraValue = (String) getIntent().getExtras().get("textValue");
 TextView view = (TextView) findViewById(R.id.displayintentextra);
 view.setText(extraValue);
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

 @Override
 public void finish() {
 Intent intent = new Intent();
 EditText retval = (EditText) findViewById(R.id.returnValue);
 String returnValue = retval.getText().toString();
 intent.putExtra("returnValue",returnValue);
 setResult(RESULT_OK, intent);
 super.finish();
 }
}