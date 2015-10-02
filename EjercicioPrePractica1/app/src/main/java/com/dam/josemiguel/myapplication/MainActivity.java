package com.dam.josemiguel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button miBoton;
    private RadioButton boton1;
    private RadioButton boton2;
    private RadioButton boton3;
    private CheckBox checkB1;
    private CheckBox checkB2;
    private ListView lView;
    private String listViewText;
    final String[] datos={"Patata","Agustin","Javi","Alcachofa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewText="Ninguno";
        miBoton= (Button) findViewById(R.id.button);
        boton1=(RadioButton) findViewById(R.id.radioButton);
        boton2=(RadioButton) findViewById(R.id.radioButton2);
        boton3=(RadioButton) findViewById(R.id.radioButton3);
        checkB1=(CheckBox) findViewById(R.id.checkBox1);
        checkB2=(CheckBox) findViewById(R.id.checkBox2);
        miBoton.setOnClickListener(this);
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,datos);
        lView= (ListView) findViewById(R.id.listView);

        lView.setAdapter(adaptador);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                listViewText=a.getItemAtPosition(position).toString();
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
        String radioGroup="";
        if(boton1.isChecked())
        {
            radioGroup="RadioButton 1";
        }
        else
        {
            if(boton2.isChecked())
            {
                radioGroup="RadioButton 2";
            }
            else
            {
                if(boton3.isChecked()) {
                    radioGroup = "RadioButton 3";
                }
                else
                {
                    radioGroup="Ninguno";
                }
            }
        }
        String checkBox1="",checkBox2="";
        if(checkB1.isChecked())
        {
            checkBox1="Pulsado";
        }
        else
        {
            checkBox1="No pulsado";
        }

        if(checkB2.isChecked())
        {
            checkBox2="Pulsado";
        }
        else
        {
            checkBox2="No pulsado";
        }
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putString("radioGroup",radioGroup);
        bundle.putString("checkBox1",checkBox1);
        bundle.putString("checkBox2",checkBox2);
        bundle.putString("listView",listViewText);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
