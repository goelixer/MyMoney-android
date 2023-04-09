package com.saberix.mymoney;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isAirplaneModeOn(context.getApplicationContext())) {
            new AlertDialog.Builder(context)
                    .setTitle("Network Connection Lost!")
                    .setIcon(R.drawable.ic_baseline_signal_wifi_off_24)
                    .setPositiveButton("Ok",null)
                    .show();
        } else {
            Toast.makeText(context, "Connection established", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}