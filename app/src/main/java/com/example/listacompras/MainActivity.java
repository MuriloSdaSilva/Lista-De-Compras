package com.example.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdiciona;
    private ListView listaCompra;

    SQLiteDatabase bd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaCompra = findViewById( R.id.listaCompra);


        criarBd();
        listasDados();


    }

    public void criarBd(){
        bd = openOrCreateDatabase( "compras", MODE_PRIVATE, null );

        String cmd;

        cmd = "CREATE TABLE IF NOT EXISTS compras ";
        cmd = cmd + "( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, marca VARCHAR, quantidade VARCHAR)";

        bd.execSQL( cmd );
    }

    @SuppressLint("Range")
    public void listasDados(){
        try{
            bd = openOrCreateDatabase( "compras", MODE_PRIVATE, null );
            Cursor cursor = bd.rawQuery("SELECT id, nome, marca, quantidade FROM compras", null);

            ArrayList<String> linhas = new ArrayList<String>();

            ArrayAdapter adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1, android.R.id.text1, linhas
            );
            listaCompra.setAdapter(adapter);
            cursor.moveToFirst();
            while(cursor!=null){
                linhas.add(cursor.getString(1) + " " + cursor.getString(2) +  " "  + cursor.getString(3));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void irTelarAdicionar(View view){
        Intent intent1 = new Intent(getApplicationContext(), TelaAdd.class);
        startActivity(intent1);
    }


}