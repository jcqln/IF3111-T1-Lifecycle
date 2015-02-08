package com.tutorial.jj.browseractivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.webkit.WebView;
import android.widget.TextView;

import static android.os.StrictMode.ThreadPolicy;


public class BrowserActivity extends ActionBarActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
 .permitAll().build();
 StrictMode.setThreadPolicy(policy);

 setContentView(R.layout.activity_browser);
 Intent intent = getIntent();
 TextView text = (TextView) findViewById(R.id.textView);
 WebView web = (WebView) findViewById(R.id.webView);
 String action = intent.getAction();
 if(action.equals(Intent.ACTION_VIEW) == false) {
 throw new RuntimeException("Should not happen");
 }
 Uri data = intent.getData();

 URL url;
 try {
 url = new URL(data.getScheme(),data.getHost(),data.getPath());
 web.loadUrl(String.valueOf(url));
 BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
 String line = "";
// while((line = rd.readLine())!= null) {
// text.append(line);
// }
 }
 catch (MalformedURLException e) {
 e.printStackTrace();
 }
 catch (IOException e) {
 e.printStackTrace();
 }
 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 // Inflate the menu; this adds items to the action bar if it is present.
 getMenuInflater().inflate(R.menu.menu_browser, menu);
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