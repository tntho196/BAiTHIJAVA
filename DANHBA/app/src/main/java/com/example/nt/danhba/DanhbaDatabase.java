package com.example.nt.danhba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NT on 6/14/2017.
 */

public class DanhbaDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // ten csdl
    private  static  final  String DATABASE_NAME ="DataDanhBa";
    // ten bang
    private  static  final  String  TABLE_DB = "TDANHBA";
    // các trường trong bảng
    private static  final String KEY_ID ="MaDB";
    private static  final String KEY_TEN="Ten";
    private static  final String KEY_SDT="SDT";
    private static  final String KEY_GIOITINH="GioiTinh";


    private Context context;
    public DanhbaDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context=context;
    }

    // truy vấn tạo bảng, sửa xóa.....

    public  void QueryData (String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    // tao bang

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DANHBA_TABLE = "CREATE TABLE " + TABLE_DB +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TEN + " TEXT,"
                + KEY_SDT  + " TEXT,"
                + KEY_GIOITINH + " INTEGER" + ")";
        db.execSQL(CREATE_DANHBA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void ThemCV(danhba Cv)
    {
        SQLiteDatabase  db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_TEN,Cv.getMten());
        values.put(KEY_SDT,Cv.getMsdt());
        values.put(KEY_GIOITINH,Cv.getGioitinh());


        db.insert(TABLE_DB,null,values);

        db.close();
    }

    // dua cong viec vao listview
    public List<danhba> getAllDanhba()
    {
        List<danhba> danhbaList = new ArrayList<>();
        String selectQuery=" SELECT * FROM "+ TABLE_DB;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                danhba danhba =new danhba();
                danhba.setMmadb(cursor.getInt(0));
                danhba.setMten(cursor.getString(1));
                danhba.setMsdt(cursor.getString(2));
                danhba.setGioitinh(cursor.getInt(3));

                danhbaList.add(danhba);

            }while (cursor.moveToNext());
        }
        db.close();
        return danhbaList;
    }

    public int updatedanhba (danhba DanhBa)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(KEY_TEN,DanhBa.getMten());
        values.put(KEY_SDT,DanhBa.getMsdt());
        values.put(KEY_GIOITINH,DanhBa.getGioitinh());

        return db.update(TABLE_DB,values, KEY_ID + "=?", new String[] {String.valueOf(DanhBa.getMmadb())});
    }
    // xoa mot cong viec
    public  void deleteCongViec(danhba congViec)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DB, KEY_ID + " =?",new String[] {String.valueOf(congViec.getMmadb())});
    }
}
