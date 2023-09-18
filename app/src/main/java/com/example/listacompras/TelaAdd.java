package com.example.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaAdd extends AppCompatActivity {

    private EditText nome;
    private EditText marca;
    private EditText quantidade;

    private Button buttonInsere;

    private ListView listaCompra;

    private ArrayList<String> listaDeCompra = new ArrayList<>();

    SQLiteDatabase bd;
    ArrayAdapter<String> adaptador;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_add);

        nome = findViewById( R.id.editName);
        marca = findViewById( R.id.textMarca );
        quantidade = findViewById( R.id.textQuantidade );
        buttonInsere = findViewById( R.id.buttonInsere );
        listaCompra = findViewById( R.id.listaCompra );


        buttonInsere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });


    }
    public void cadastrar(){
        if(!TextUtils.isEmpty(nome.getText().toString()) || !TextUtils.isEmpty(marca.getText().toString()) || !TextUtils.isEmpty(quantidade.getText().toString())){
            bd = openOrCreateDatabase( "compras", MODE_PRIVATE, null );
            String sql = "INSERT INTO compras (nome, marca, quantidade) values (?,?,?)";
            SQLiteStatement stmt = bd.compileStatement(sql);
            stmt.bindString(1, nome.getText().toString());
            stmt.bindString(2, marca.getText().toString());
            stmt.bindString(3, quantidade.getText().toString());
            stmt.executeInsert();
            bd.close();
        }
    }




    public void voltarTela(View view){
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);
    }


}