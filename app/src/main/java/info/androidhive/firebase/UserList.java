package info.androidhive.firebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SAURAV on 10/1/2017.
 */

public class UserList extends ArrayAdapter<User> {

    private Activity context;
    private List<User> UserList;

    public UserList(Activity context, List<User> personList) {
        super(context, R.layout.list_layout, personList);
        this.context = context;
        this.UserList = personList;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textView_name = (TextView) listViewItem.findViewById(R.id.textView_name);
        TextView textView_email = (TextView) listViewItem.findViewById(R.id.textView_email);
        TextView textView_phonenumber = (TextView) listViewItem.findViewById(R.id.textView_phonenumber);
        TextView textView_bloodgroup = (TextView) listViewItem.findViewById(R.id.textView_bloodgroup);

        User user = UserList.get(position);

        textView_name.setText(user.getName());
        textView_email.setText(user.getEmail());
        textView_phonenumber.setText(user.getPhone_no());
        textView_bloodgroup.setText(user.getBloodgroup());

        return listViewItem;
    }
}