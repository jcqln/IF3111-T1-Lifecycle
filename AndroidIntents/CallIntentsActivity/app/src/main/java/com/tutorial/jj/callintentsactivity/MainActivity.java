ppackage com.tutorial.jj.callintentsactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Spinner spinner = (Spinner) findViewById(R.id.spinner);
 ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.daftar_intents,R.layout.support_simple_spinner_dropdown_item);
 spinner.setAdapter(arrayAdapter);
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

 public void triggerIntent(View view) {
 Spinner spinner = (Spinner) findViewById(R.id.spinner);
 int selection = spinner.getSelectedItemPosition();
 Intent intent = null;
 switch (selection) {
 case 0: {
 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://informatika.stei.itb.ac.id/~rinaldi.munir/Kriptografi/2014-2015/kripto14-15.htm"));
 break;
 }
 case 1: {
 intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(62)123456"));
 break;
 }
 case 2: {
 intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(62)123456"));
 break;
 }
 case 3: {
 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
 break;
 }
 case 4: {
 intent = new Intent(Intent.ACTION_VIEW, (Uri.parse("geo:0,0?q=query")));
 break;
 }
 case 5: {
 intent = new Intent("android.media.action.IMAGE_CAPTURE");
 break;
 }
 case 6: {
 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
 break;
 }
 case 7: {
 intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
 break;
 }
 }
 if (intent!=null) {
 startActivity(intent);
 }
 }
}