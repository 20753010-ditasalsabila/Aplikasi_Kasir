package com.example.aplikasikasir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String usernamekey = username.getText().toString();
        String passwordkey = password.getText().toString();

        if (usernamekey.equals("admin") && passwordkey.equals("admin")) {
            Toast.makeText(getApplicationContext(), "LOGIN BERHASIL", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, TransaksiMenu.class);
            MainActivity.this.startActivity(intent);
            finish();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Username atau Password Yang Anda Masukan Salah")
                    .setNegativeButton("Retry", null).create().show();
        }
    }
}