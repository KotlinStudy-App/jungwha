package com.jungwha.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
data class Memo(var no:Long?, var content:String, var datetime:Long)

class SqliteHelper(context: Context, name:String, version:Int)
    :SQLiteOpenHelper(context, name, null, version){

    override fun onCreate(db: SQLiteDatabase?) { //파일이 생성되어있지 않을때 호출
        val create = "create table memo (`no` integer primary key, context text, datetime integer)" //memo라는 table을 생성해라 //`` = 예약어가 아닌 글자라는것을 표현
        db?.execSQL(create)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // SqliteHelper()의 생성자를 호출할때 기존 데이터베이스와 ver을 비교해서 더 높으면 호출
    }
    //데이터 입력함수
    fun insertMemo(memo:Memo){
        //db 가져오기
        val wd = writableDatabase
        // Memo를 입력 타입으로 변환
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        //db에 넣기
        wd.insert("memo", null, values)
        //db 닫기
        wd.close()
    }

    //데이터 조회함수
    fun selectMemo():MutableList<Memo>{
        val list = mutableListOf<Memo>()
        val select = "select * from memo" //memo 테이블에서 모든것 (no, context, datetime)
        val rd = readableDatabase
        val cursor = rd.rawQuery(select, null)
        while(cursor.moveToNext()){
            val no = cursor.getLong(cursor.getColumnIndex("no"))// 몇번째 열을 가져올 것인지 //no가있는 0번째
            val content = cursor.getString(cursor.getColumnIndex("content"))
            val datetime = cursor.getLong(cursor.getColumnIndex("datetime"))

            val memo = Memo(no, content, datetime)
            list.add(memo)
        }
        cursor.close()
        rd.close()
        return list
    }
    //데이터 수정함수
    fun updateMemo(memo:Memo){
        val wd = writableDatabase

        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        wd.update("memo", values, "no = ${memo.no}", null)

    //데이터 삭제함수
    fun deletMemo(memo:Memo){
        val delete = "delete from memo where no = ${memo.no}"
        val wd = writableDatabase
        wd.execSQL(delete)
        wd.delete("memo", "no = ${memo.no})", null) //함수로 처리하기
        wd.close()

    }

    }
}