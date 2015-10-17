package com.dam.josemiguel.casillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SeekBar elemX;
    private SeekBar elemY;
    private SeekBar tramas;
    private Button boton;
    private RadioGroup rGroup;
    private CheckBox sonido;
    private CheckBox vibracion;
    private TextView textX;
    private TextView textY;
    private TextView textTramas;
    private int progX;
    private int progY;
    private int tram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textX=(TextView)findViewById(R.id.textViewX);
        textY=(TextView)findViewById(R.id.textView);
        textTramas=(TextView) findViewById(R.id.textView2);
        progX=3;
        progY=3;
        tram=2;

        elemX=(SeekBar) findViewById(R.id.seekBar);
        elemY=(SeekBar) findViewById(R.id.seekBar2);
        tramas=(SeekBar) findViewById(R.id.seekBar3);
        boton=(Button) findViewById(R.id.button);
        rGroup=(RadioGroup) findViewById(R.id.rGroup);
        rGroup.clearCheck();
        rGroup.check(R.id.radioButton);
        sonido=(CheckBox) findViewById(R.id.checkBox);
        vibracion=(CheckBox) findViewById(R.id.checkBox2);
        boton.setOnClickListener(this);

        elemX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progX = progress + 3;
                textX.setText("Número elementos en eje X:" + progX);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        elemY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progY=progress+3;
                textY.setText("Número elementos en eje Y:"+progY);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tramas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tram=progress+2;
                textTramas.setText("Número tramas:"+tram);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,Juego.class);
        Bundle bundle=new Bundle();
        bundle.putString("ejeX", "El número de columnas es " + progX);
        bundle.putString("ejeY","El número de filas es "+progY);
        bundle.putString("tramas","El número de opciones es "+tram);
        int idSelecc=rGroup.getCheckedRadioButtonId();
        switch (idSelecc) {
            case R.id.radioButton:
                bundle.putString("opcion","Se mostrarán colores");
                break;
            case R.id.radioButton2:
                bundle.putString("opcion","Se mostrarán números");
                break;
        }

        if(sonido.isChecked())
        {
            bundle.putString("sonido","El sonido esta activado");
        }
        else
        {
            bundle.putString("sonido","El sonido no esta activado");
        }

        if(vibracion.isChecked())
        {
            bundle.putString("vibracion","La vibracion esta activada");
        }
        else
        {
            bundle.putString("vibracion","La vibracion no esta activada");
        }

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
