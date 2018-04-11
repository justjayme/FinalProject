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

public class SidesEditDataActivity extends AppCompatActivity {

    private static final String TAG = "SidesEditDataActivity";

    private Button sidesbtnSave,sidesbtnDelete;
    private EditText sides;

    SidesDatabaseHelper sidesmDatabaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sides_edit_data_layout);
        sidesbtnSave = (Button) findViewById(R.id.sidesbtnSave);
        sidesbtnDelete = (Button) findViewById(R.id.sidesbtnDelete);
        sides = (EditText) findViewById(R.id.sides);
        sidesmDatabaseHelper = new SidesDatabaseHelper(this);

        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        sides.setText(selectedName);

        sidesbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = sides.getText().toString();
                if(!item.equals("")){
                    sidesmDatabaseHelper.updateName(item,selectedID,selectedName);
                }else{
                    toastMessage("You must enter a name");
                }
            }
        });

        sidesbtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sidesmDatabaseHelper.deleteName(selectedID,selectedName);
                sides.setText("");
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