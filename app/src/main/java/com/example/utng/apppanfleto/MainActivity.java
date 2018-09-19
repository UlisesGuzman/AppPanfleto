package com.example.utng.apppanfleto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista;
        ArrayAdapter<String> adaptador;
        lista = (ListView)findViewById(R.id.list_main);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        lista.setAdapter(adaptador);
        adaptador.add(getResources().getString(R.string.temas));
        adaptador.add(getResources().getString(R.string.activs));
        adaptador.add(getResources().getString(R.string.eval));
        adaptador.add(getResources().getString(R.string.progress));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int opcion = position;
                Toast.makeText(getApplicationContext(), "Opción ..." + opcion, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ContenidoActivity.class);
                intent.putExtra("OPCIÓN", opcion);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Asociar con el menu xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ContenidoActivity.class);
        switch (item.getItemId()){
            case R.id.itmTemas:
                Toast.makeText(this, "Temas del lenguaje", Toast.LENGTH_LONG).show();
                intent.putExtra("OPCIÓN", 0);
                startActivity(intent);
                finish();
                return true;

            case R.id.itmActivs:
                Toast.makeText(this, "Activiades de Aprendizaje", Toast.LENGTH_LONG).show();
                intent.putExtra("OPCIÓN", 1);
                startActivity(intent);
                finish();
                return true;

            case R.id.itmEval:
                Toast.makeText(this, "Evaluaciones", Toast.LENGTH_LONG).show();
                intent.putExtra("OPCIÓN", 2);
                startActivity(intent);
                finish();
                return true;

            case R.id.itmProgress:
                Toast.makeText(this, "Progreso del usuario", Toast.LENGTH_LONG).show();
                intent.putExtra("OPCIÓN", 3);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
