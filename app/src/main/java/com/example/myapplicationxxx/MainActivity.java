package com.example.myapplicationxxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    public EditText text;
    public LinkedList<Item> preguntas = new LinkedList<Item>();
    public Button btn;
    public TextView txt;
    private int current = 0;
    public String var = "";
    public String salida = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In World of Warcraft lore, who was first to have the title &quot;The Ashbringer&quot;?\",\"correct_answer\":\"Alexandros Mograine\",\"incorrect_answers\":[\"Tirion Fordring\",\"Arthas Menethil\",\"Uther the Lightbringer\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In WarioWare: Smooth Moves, which one of these is NOT a Form?\",\"correct_answer\":\"The Hotshot\",\"incorrect_answers\":[\"The Discard\",\"The Elephant\",\"The Mohawk\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"This weapon in Counter-Strike: Global Offensive does not exist in real life.\",\"correct_answer\":\"M4A4\",\"incorrect_answers\":[\"AWP\",\"M4A1\",\"MP9\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which of these characters was almost added into Super Smash Bros. Melee, but not included as the game was too far in development?\",\"correct_answer\":\"Solid Snake\",\"incorrect_answers\":[\"Pit\",\"Meta Knight\",\"R.O.B.\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What level do you have to be to get a service medal on CS:GO?\",\"correct_answer\":\"40\",\"incorrect_answers\":[\"50\",\"30\",\"20\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In &quot;Call Of Duty: Zombies&quot;, completing which map&#039;s easter egg will reward you with the achievement, &quot;Time Travel Will Tell&quot;?\",\"correct_answer\":\"Shangri-La\",\"incorrect_answers\":[\"Ascension\",\"Moon\",\"Die Rise\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which character does the player play as in the video game &quot;Bastion&quot;?\",\"correct_answer\":\"The Kid\",\"incorrect_answers\":[\"Rucks\",\"Zulf\",\"Zia\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In Portal, what color is the Intelligence Core?\",\"correct_answer\":\"Blue\",\"incorrect_answers\":[\"Purple\",\"Red\",\"Orange\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which Sonic the Hedgehog game introudced Knuckles the Echidna?\",\"correct_answer\":\"Sonic the Hedgehog 3\",\"incorrect_answers\":[\"Sonic the Hedgehog 2\",\"Sonic &amp; Knuckles\",\"Sonic Adventure\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Who is credited with having created the world&#039;s first video game Easter Egg?\",\"correct_answer\":\"Warren Robinett\",\"incorrect_answers\":[\"Julius Smith\",\"Will Crowther\",\"Don Woods\"]}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        txt = (TextView)findViewById(R.id.textView);
    }


    public void jugar(View v) {

        String json = text.getText().toString();

        if ( json.length() == 0 ){ // para el parcial
            json = salida;
        }

        try {
            JSONObject reader = new JSONObject(json);
            String q = "[";
            String q1 = "]";

            JSONArray items = reader.getJSONArray("results");
            for (int i = 0; i < items.length(); i++) {
                JSONObject c = items.getJSONObject(i);
                String category = c.getString("category");
                String type = c.getString("type");
                String difficulty = c.getString("difficulty");
                String question = c.getString("question");
                String correct_answer = c.getString("correct_answer");
                String nn = c.getString("incorrect_answers");
                String[] mal = nn.split(",");//c.getString("incorrect_answers").split(",");

                Item s = new  Item(category, type, difficulty, question, correct_answer, mal);
                preguntas.add(s);
            }

            txt.setText(preguntas.size()+"");

        }catch(Exception e ){
            txt.setText("Ese Json esta podrido" + e.toString());
        }
        String salvavidas = "";
        try{
            Intent preguntasI = new Intent(this,SecondActivity.class);
            current = preguntas.size();
            for (int i = 0; i < preguntas.size(); i++ ){
                ArrayList<String> tose = new ArrayList<String>() ;
                Bundle b = new Bundle();



                salvavidas = "";
                for(int h = 0; h < preguntas.get(i).getMal().length; h++){
                    tose.add( preguntas.get(i).getMal()[h]);
                    salvavidas = salvavidas +preguntas.get(i).getMal()[h]+",";
                }
                tose.add(preguntas.get(i).getCorrect());
                tose.add(preguntas.get(i).getQuestion());
                salvavidas = salvavidas
                        + preguntas.get(i).getCorrect()+ "," +preguntas.get(i).getQuestion()
                ;
                // b.putStringArray( "key", tose);
                //preguntasI.putStringArrayListExtra("hpta", tose);
                preguntasI.putExtra("h"+i, salvavidas);


            }
            preguntasI.putExtra("tam", current+"");
            startActivity(preguntasI);

        }catch(Exception d){
            txt.setText("Ese Intent esta podrido" + d.toString());
        }

    }
}
