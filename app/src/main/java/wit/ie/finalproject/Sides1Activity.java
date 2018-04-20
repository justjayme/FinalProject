package wit.ie.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


//This is the sides1activity which changes content for the first sides entry


public class Sides1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.content_sides1);
    }
}


