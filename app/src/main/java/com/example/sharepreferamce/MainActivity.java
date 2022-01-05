package com.example.sharepreferamce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.LInearlayoutid);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.RedColor){
                linearLayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
                storeColor(getResources().getColor(R.color.purple_200));
            }else if(item.getItemId() == R.id.GreenColorone){
                linearLayout.setBackgroundColor(getResources().getColor(R.color.teal_200));
                storeColor(getResources().getColor(R.color.teal_200));
            }else if(item.getItemId() == R.id.Blueolorone){
                linearLayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
                storeColor(getResources().getColor(R.color.purple_200));
            }
        return super.onOptionsItemSelected(item);
    }

    public  void storeColor(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("Selected_color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("MyColor",color);
        editor.commit();
    }

    public int loadColor (){
        SharedPreferences sharedPreferences = getSharedPreferences("Selected_color", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("MyColor",getResources().getColor(R.color.purple_200));
        return selectedColor ;
    }
}