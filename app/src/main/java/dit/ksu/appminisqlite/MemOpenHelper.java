package dit.ksu.appminisqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MemOpenHelper extends SQLiteOpenHelper{
    public static final String DBNAME = "my_calandburn.db";
    private static final int DBVERSION = 1;
    private static final String MEMORY_TABLE = "create table tbmemory (_idinteger primary key, " +
            "title text, " +
            "detail text, " +
            "date text);";
    private static final String ACCOUT_TABLE = "create table tbaccout(_id integerprimary key, " +
            "name text, " +
            "balance text, " +
            "date text);";
    private SQLiteDatabase writeSQLite, readSQLite;
    public static final String TBMEMORY = "tbmemory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_DATE = "date";
    public MemOpenHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        writeSQLite = this.getWritableDatabase();
        readSQLite = this.getReadableDatabase();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MEMORY_TABLE);
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('title1','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อ เรื่อง','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('title2','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อ เรื่อง2','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อ เรื่อง3','รายละเอียด', '30-07-2017');");
    }

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public long AddmemoryActivty(String strTitle, String strDetail, String strDate) {
        ContentValues objvalue = new ContentValues();
        objvalue.put(COLUMN_TITLE, strTitle);
        objvalue.put(COLUMN_DETAIL, strDetail);
        objvalue.put(COLUMN_DATE, strDate);
        return writeSQLite.insert(TBMEMORY, null, objvalue);
    }
}


