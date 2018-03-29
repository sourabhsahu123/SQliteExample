package uiwidget.com.dbexample;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context con;
    EditText edtUserName,edtPassword;
    DBHelper db;
    Button btnSave;
    ListView lv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con=this;
        edtUserName=(EditText)findViewById(R.id.username);
        edtPassword=(EditText)findViewById(R.id.password);
        btnSave=(Button)findViewById(R.id.btnSave);
        db =new DBHelper(con);
        lv = (ListView)findViewById(R.id.myUsersListView);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.insertUser(edtUserName.getText().toString(),edtPassword.getText().toString());

                Cursor c = db.getAllUsers();
                ArrayList<String>strArr= new ArrayList<String>();
                if(c!=null)
                {
                    while (c.moveToNext())
                    {
                        strArr.add(c.getString(c.getColumnIndex("USERNAME")));

                    }
                }

                ArrayAdapter<String> ar = new ArrayAdapter<String>(con,R.layout.support_simple_spinner_dropdown_item,strArr);
                lv.setAdapter(ar);
            }
        });

    }
}
