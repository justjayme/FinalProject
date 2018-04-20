package wit.ie.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

//This is the DinnerActivity which changes content and has a button to view a dinner recipe


public class SidesActivity extends AppCompatActivity {
    ImageButton sides1button;
    SidesDatabaseHelper sidesmDatabaseHelper;
    private Button sidesbtnAdd, sidesbtnViewData;
    private EditText sideseditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.content_sides);

        sides1button = (ImageButton) findViewById(R.id.sides1button);
        sides1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Sides1Activity.class);
                view.getContext().startActivity(Intent);
            }
        });


        sideseditText = (EditText) findViewById(R.id.sideseditText);
        sidesbtnAdd = (Button) findViewById(R.id.sidesbtnAdd);
        sidesbtnViewData = (Button) findViewById(R.id.sidesbtnView);
        sidesmDatabaseHelper = new SidesDatabaseHelper(this);

        sidesbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = sideseditText.getText().toString();
                if (sideseditText.length() != 0) {
                    AddData(newEntry);
                    sideseditText.setText("");
                } else {
                    toastMessage("You must put something in the breakfast notes!");
                }

            }
        });

        sidesbtnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SidesActivity.this, SidesListDataActivity.class);
                startActivity(intent);

            }
        });


    }


    public void AddData(String newEntry) {
        boolean insertData = sidesmDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }






}
