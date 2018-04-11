package wit.ie.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//This class is used to edit data entered into the SQLITE database via the shopping list

public class DessertsEditDataActivity extends AppCompatActivity {

    private static final String TAG = "DessertsEditDataActivity";

    private Button dessertsbtnSave,dessertsbtnDelete;
    private EditText desserts;

    DessertsDatabaseHelper dessertsmDatabaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desserts_edit_data_layout);
        dessertsbtnSave = (Button) findViewById(R.id.dessertsbtnSave);
        dessertsbtnDelete = (Button) findViewById(R.id.dessertsbtnDelete);
        desserts = (EditText) findViewById(R.id.desserts);
        dessertsmDatabaseHelper = new DessertsDatabaseHelper(this);

        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        desserts.setText(selectedName);

        dessertsbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = desserts.getText().toString();
                if(!item.equals("")){
                    dessertsmDatabaseHelper.updateName(item,selectedID,selectedName);
                }else{
                    toastMessage("You must enter a name");
                }
            }
        });

        dessertsbtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dessertsmDatabaseHelper.deleteName(selectedID,selectedName);
                desserts.setText("");
                toastMessage("removed from database");
            }
        });

    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}