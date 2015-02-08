package com.tutorial.jj.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends ActivityTracer {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }

 public void nextPage(View view) {
 Intent intent = new Intent(this, SecondActivity.class);
 startActivity(intent);
 }

}