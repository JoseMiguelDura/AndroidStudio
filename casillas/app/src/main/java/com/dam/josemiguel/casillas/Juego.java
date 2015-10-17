package com.dam.josemiguel.casillas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Juego extends AppCompatActivity {

    private TextView tEjeX;
    private TextView tEjeY;
    private TextView tTramas;
    private TextView tOpcion;
    private TextView tSonido;
    private TextView tVibracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tEjeX=(TextView)findViewById(R.id.textView3);
        tEjeY=(TextView)findViewById(R.id.textView4);
        tTramas=(TextView)findViewById(R.id.textView5);
        tOpcion=(TextView)findViewById(R.id.textView6);
        tSonido=(TextView)findViewById(R.id.textView7);
        tVibracion=(TextView)findViewById(R.id.textView8);
        Bundle bundle=this.getIntent().getExtras();

        tEjeX.setText(bundle.getString("ejeX"));
        tEjeY.setText(bundle.getString("ejeY"));
        tTramas.setText(bundle.getString("tramas"));
        tOpcion.setText(bundle.getString("opcion"));
        tVibracion.setText(bundle.getString("vibracion"));
        tSonido.setText(bundle.getString("sonido"));
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
