import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // Use correct XML layout name

        btnPermissions = findViewById(R.id.btnPermissions);

        btnPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                        Manifest.permission.READ_SMS,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    }, 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Optionally handle the results here
    }
}
package com.eduspy.systemservice  // ← Isko aapke package name se replace karein

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPermissions = findViewById(R.id.btnPermissions);

        btnPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{
                                Manifest.permission.READ_SMS,
                                Manifest.permission.READ_CONTACTS,
                                Manifest.permission.READ_CALL_LOG,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.INTERNET
                        },
                        1);
            }
        });
    }
}
