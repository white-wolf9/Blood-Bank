package info.androidhive.firebase;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dialog extends AppCompatActivity {

    Button button_call,button_sms,button_email,button_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Bundle bundle= getIntent().getExtras();
        button_call= (Button) findViewById(R.id.button_call);
        button_sms= (Button) findViewById(R.id.button_sms);
        button_email= (Button) findViewById(R.id.button_email);
        button_map= (Button) findViewById(R.id.button_map);

        final String phone_no=bundle.getString("phone_no");
        final String email= bundle.getString("email");
        final String address= bundle.getString("address");

        button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query="+address);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);
            }
        });
        button_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:"+ email);
                intent.setData(uri);
                intent.putExtra("subject", "my subject");
                intent.putExtra("body", "my message");
                startActivity(intent);
            }
        });
        button_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phone_no));
                startActivity(intent);
            }
        });
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "tel:" + phone_no.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
