/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.nhomLCHN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableContent {
    public static void main(String[] args) {
        Connection con = null;
        Statement sttm = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SQLiteLCHN.db");
            sttm =con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS NoiDung (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	sender text NOT NULL,\n"
                + "	receiver text NOT NULL,\n"
                + "     type    text NOT NULL,\n"
                + "     content text NOT NULL,\n"
                + "     inComeTime text  NOT NULL,\n "
                + "     isDeliver text NOT NULL"
                + ");";
            sttm.executeUpdate(sql);
            System.out.println("Tao Database Thanh Cong");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}