package com.example.myapplicationxxx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


        public TextView pregunta;
        public Button btn1;
        public Button btn2;
        public Button btn3;
        public Button btn4;
        public TextView tt;

        public String correcto ;
        public int tam ;
        public int puntos;
        public ArrayList<String> pending = new ArrayList<String>();
        public Intent tosend;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second);

            pregunta = (TextView)findViewById(R.id.pre);
            btn1 = (Button)findViewById(R.id.button2);
            btn2 = (Button)findViewById(R.id.button3);
            btn3 = (Button)findViewById(R.id.button4);
            btn4 = (Button)findViewById(R.id.button5);
            tt = (TextView)findViewById(R.id.textView3);

             Intent prev = getIntent();
             Bundle b  = prev.getExtras();

            try {
                tam =  Integer.parseInt(prev.getStringExtra("tam"));
                tam = tam -1;
                String  values = prev.getStringExtra("h"+tam);
                String[] value = values.split(",");
                //ArrayList<String> value = prev.getStringArrayListExtra("hpta");
                correcto = value[4];
                pregunta.setText(value[value.length -1]);


                tt.setText("for2");
            int random = (int)(Math.random() * 3 );
            btn1.setText(value[random % 3].replace("\"", "").replace("[", "").replace("]", ""));
            btn2.setText(value[(random + 1) % 3].replace("\"", "").replace("[", "").replace("]", ""));
            btn3.setText(value[(random + 2) % 3].replace("\"", "").replace("[", "").replace("]", ""));
            btn4.setText(value[(random + 3) % 3].replace("\"", "").replace("[", "").replace("]", ""));
                   tt.setText( "");

                for (int i = 0 ; i < tam ; i++){

                    String valuesb = prev.getStringExtra("h"+i);
                    tosend.putExtra("h"+i, valuesb);
                    pending.add(valuesb);
                    tt.setText("for"+ tam);
                }
                tosend.putExtra("tam", tam);
            }catch (Exception e ){
                //tt.setText(e.toString() );
            }





        }

        public void tomar(View v) {
            if (v.getId() == btn1.getId()){
                if ( btn1.getText().equals(correcto) ){
                  puntos = puntos + 1;
                }
            }else if (v.getId() == btn2.getId()){
                if ( btn2.getText().equals(correcto) ){
                    puntos = puntos + 1;
                }
            }else if (v.getId() == btn3.getId()){
                if ( btn3.getText().equals(correcto) ){
                    puntos = puntos + 1;
                }
            }else if (v.getId() == btn4.getId()){
                if ( btn4.getText().equals(correcto) ){
                    puntos = puntos + 1;
                }
            }




        }
}
