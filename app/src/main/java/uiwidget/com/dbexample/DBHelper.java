package uiwidget.com.dbexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by pc on 29-03-2018.
 */

public class DBHelper extends SQLiteOpenHelper {


    SQLiteDatabase db;
    int version =1;
    String create_query ="CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,PASSWORD TEXT)";
    public  DBHelper(Context con){
        super(con,"user.db",null,1);
        db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        db = sqLiteDatabase;
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor getAllUsers()
    {
        Cursor c=null;
        try {
             c = db.query("USER", new String[]{"USERNAME"}, null, null, null, null, null);
        }
        catch (Exception ee)
        {
            Log.e("DBHELPER",ee.toString());

        }
        return c;
        }

        public void inserFullUser(User u )
        {
            ContentValues cv = new ContentValues();
          //  cv.put("USERNAME",u.getfName());
            cv.put("PASSWORD",u.getAddress());
            try {
                db.insert("USER", "", cv);
            }
            catch (Exception ee)
            {
                Log.e("DbhELPER",ee.toString());
            }
        }
    public  void insertUser(String username,String password)
    {
        ContentValues cv = new ContentValues();
        cv.put("USERNAME",username);
        cv.put("PASSWORD",password);
        try {
            db.insert("USER", "", cv);
        }
        catch (Exception ee)
        {
            Log.e("DbhELPER",ee.toString());
        }
    }
}
