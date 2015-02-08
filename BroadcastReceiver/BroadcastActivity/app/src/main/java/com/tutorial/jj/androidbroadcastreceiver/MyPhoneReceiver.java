package com.tutorial.jj.androidbroadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.telephony.TelephonyManager;
import android.content.BroadcastReceiver;

public class MyPhoneReceiver extends BroadcastReceiver {

 @Override
 public void onReceive(Context context, Intent intent) {
 Bundle extras = intent.getExtras();
 if(extras != null) {
 String state = extras.getString(TelephonyManager.EXTRA_STATE);
 Log.w("MY DEBUG TAG", state);
 if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
 String phoneNumbers = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
 Log.w("MY_DEBUG_TAG",phoneNumbers);
 }
 }
 }
}