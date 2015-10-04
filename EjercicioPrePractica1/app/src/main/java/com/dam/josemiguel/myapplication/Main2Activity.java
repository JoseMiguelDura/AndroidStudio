package com.dam.josemiguel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=(TextView) findViewById(R.id.textView);
        tv2=(TextView) findViewById(R.id.textView2);
        tv3=(TextView) findViewById(R.id.textView3);
        tv4=(TextView) findViewById(R.id.textView4);
        tv5=(TextView) findViewById(R.id.textView6);
        Bundle bundle=this.getIntent().getExtras();
        tv1.setText(bundle.getString("radioGroup")+":RadioGroup");
        tv2.setText(bundle.getString("checkBox1")+":CheckBox1");
        tv3.setText(bundle.getString("checkBox2")+":CheckBox2");
        tv4.setText(bundle.getString("listView")+":ListView");
        tv5.setText(bundle.getString("seekBar")+":SeekBar");


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
