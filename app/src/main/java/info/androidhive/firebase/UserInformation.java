package info.androidhive.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SAURAV on 10/2/2017.
 */

public class UserInformation extends AppCompatActivity {

    //View Objects
    Button button_submit;
    EditText editText_name;
    EditText editText_number;
    EditText editText_addline1;
    EditText editText_addline2;
    EditText editText_dob;
    Spinner spinner_bloodgroup;
    EditText editText_gender;


    //Firebase Authentication Object
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    //Reference to the Firebase Database
    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        //Initializing the Firebase Authentication Object and the firebaseUser
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseUser= firebaseAuth.getCurrentUser();

        if(firebaseAuth.getCurrentUser()!=null){
            Toast.makeText(this,"Logged In as "+firebaseUser.getEmail(),Toast.LENGTH_LONG).show();
        }

        mRootReference=FirebaseDatabase.getInstance().getReference();

        // Displaying toolbar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Link to the activity.
        button_submit= (Button) findViewById(R.id.button_submit);
        editText_name= (EditText) findViewById(R.id.editText_name);
        editText_number= (EditText) findViewById(R.id.editText_number);
        editText_addline1= (EditText) findViewById(R.id.editText_addline1);
        editText_addline2= (EditText) findViewById(R.id.editText_addline2);
        editText_dob= (EditText) findViewById(R.id.editText_dob);
        spinner_bloodgroup= (Spinner) findViewById(R.id.spinner_bloodgroup);
        editText_gender= (EditText) findViewById(R.id.editText_gender);


        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String that stores the name of the user
                String name=editText_name.getText().toString();
                //String that stores the phone number of the user
                String number=editText_number.getText().toString();
                //String that stores the Address of the user
                String addressline1=editText_addline1.getText().toString();
                String addressline2=editText_addline2.getText().toString();
                String addressline=addressline1+" "+addressline2;
                //String that stores the date of birth of the user
                String dob=editText_dob.getText().toString();
                //String that stores the blood group of the user
                String bloodgroup=spinner_bloodgroup.getSelectedItem().toString();
                //String that stores the email of the user
                String email=firebaseUser.getEmail();
                //String that stores the gender of the user
                String sex=editText_gender.getText().toString();

                //Creates a new object of class User and assigns all the data recieved from the Account holder
                User user=new User(name,email,number,addressline,bloodgroup,dob,sex);
                //Gets a unique Id and enters all the values into the NoSQL Database under the Unique Id
                mRootReference.child(firebaseUser.getUid()).setValue(user);
            }
        });
    }
}
