package info.androidhive.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonorList extends AppCompatActivity {

    ListView listView_User;
    List<User> userList;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        listView_User= (ListView)findViewById(R.id.listView_User);
        userList= new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                    User user =userSnapshot.getValue(User.class);
                    userList.add(user);
                }

                final UserList adapter=new UserList(DonorList.this, userList);
                listView_User.setAdapter(adapter);

                listView_User.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent myIntent= new Intent(getApplicationContext(), Dialog.class);
                        String phone_no=adapter.getItem(i).getPhone_no();
                        String email=adapter.getItem(i).getEmail();;
                        String address=adapter.getItem(i).getAddress();
                        Bundle bundle= new Bundle();
                        bundle.putString("phone_no",phone_no);
                        bundle.putString("email",email);
                        bundle.putString("address",address);
                        myIntent.putExtras(bundle);
                        startActivity(myIntent);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
