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


public class DinnerActivity extends AppCompatActivity {
    ImageButton dinner1button;
    DinnerDatabaseHelper dinnnermDatabaseHelper;
    private Button dinnerbtnAdd, dinnerbtnViewData;
    private EditText dinnereditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.content_dinner);

        dinner1button = (ImageButton) findViewById(R.id.dinner1button);
        dinner1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Dinner1Activity.class);
                view.getContext().startActivity(Intent);
            }
        });


        dinnereditText = (EditText) findViewById(R.id.dinnereditText);
        dinnerbtnAdd = (Button) findViewById(R.id.dinnerbtnAdd);
        dinnerbtnViewData = (Button) findViewById(R.id.dinnerbtnView);
        dinnnermDatabaseHelper = new DinnerDatabaseHelper(this);

        dinnerbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = dinnereditText.getText().toString();
                if (dinnereditText.length() != 0) {
                    AddData(newEntry);
                    dinnereditText.setText("");
                } else {
                    toastMessage("You must put something in the dinner notes!");
                }

            }
        });

        dinnerbtnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DinnerActivity.this, DinnerListDataActivity.class);
                startActivity(intent);

            }
        });


    }


    public void AddData(String newEntry) {
        boolean insertData = dinnnermDatabaseHelper.addData(newEntry);

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
