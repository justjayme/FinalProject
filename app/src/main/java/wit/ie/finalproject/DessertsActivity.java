package wit.ie.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

//This is the DessertsActivity which changes content and has buttons to view a dinner recipe


public class DessertsActivity extends AppCompatActivity {
    ImageButton desserts1button;
    DessertsDatabaseHelper desserrtsmDatabaseHelper;
    private Button dessertsbtnAdd, dessertsbtnViewData;
    private EditText dessertseditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.content_desserts);

        desserts1button = (ImageButton) findViewById(R.id.desserts1button);
        desserts1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Dinner1Activity.class);
                view.getContext().startActivity(Intent);
            }
        });


       dessertseditText = (EditText) findViewById(R.id.dessertseditText);
        dessertsbtnAdd = (Button) findViewById(R.id.dessertsbtnAdd);
        dessertsbtnViewData = (Button) findViewById(R.id.dessertsbtnView);
        desserrtsmDatabaseHelper = new DessertsDatabaseHelper(this);

        dessertsbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = dessertseditText.getText().toString();
                if (dessertseditText.length() != 0) {
                    AddData(newEntry);
                    dessertseditText.setText("");
                } else {
                    toastMessage("You must put something in the dessert notes!");
                }

            }
        });

        dessertsbtnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DessertsActivity.this, DessertsListDataActivity.class);
                startActivity(intent);

            }
        });


    }


    public void AddData(String newEntry) {
        boolean insertData = desserrtsmDatabaseHelper.addData(newEntry);

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
