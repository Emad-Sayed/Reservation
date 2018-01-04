/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_ {

    private Connection DB_Access;
    private static DB_ Controller = null;

    private DB_() {
    }

    public static DB_ Get_DB_controller() {
        if (Controller == null) {
            Controller = new DB_();
        }
        return Controller;
    }

    public void Connect() {
        try {//192.186.5.1
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            DB_Access = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation?zeroDateTimeBehavior=convertToNull", "root", "");

        } catch (Exception x) {
            System.err.println(x.getMessage());
        }
    }

    public void Close() {
        try {
            if (!DB_Access.isClosed()) {
                DB_Access.close();
                //System.out.println("CloseDB Done");
            }
        } catch (SQLException ex) {
            System.out.println("Error in function close DB");
        }
    }

    public ArrayList<HashMap<String, String>> Select(String FieldName, String TableName, String Condetion) {
        ArrayList<HashMap<String, String>> Result = new ArrayList<>();
        String Query = "SELECT " + FieldName + " FROM " + TableName + " WHERE " + Condetion;
        System.out.println(Query);
        try {
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            ResultSet ResultSet = pre.executeQuery();
            while (ResultSet.next()) {
                HashMap<String, String> row = new HashMap<>();
                ResultSetMetaData r = ResultSet.getMetaData();
                for (int i = 1; i <= r.getColumnCount(); i++) {
                    row.put(r.getColumnName(i), "" + ResultSet.getString(i));
                }
                Result.add(row);
            }
            return Result;
        } catch (Exception e) {
            
            System.out.println(e+" this Queryyyyy"+Query);
        }
        return null;
    }

    public boolean Delete(String TableName, String condition) {
        String Query = "DELETE FROM " + TableName + " WHERE " + condition;
        System.out.println(Query);
        try {
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            pre.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public boolean Update(String TableName, String FieldName, String Condition) {
        String Query = "UPDATE " + TableName + " set " + FieldName + " WHERE " + Condition;
        System.out.println(Query);
        try {
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            pre.executeUpdate(Query);

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    //Emad
    public int Insert(String TableName, HashMap<String, String> values) {
        String key = "";
        String value = "";
        ResultSet rs = null;
        for (Map.Entry<String, String> entry : values.entrySet()) {
            key += entry.getKey() + ",";
            value += "?" + ",";
        }
        String Attributes = "";
        String Values = "";
        for (int i = 0; i < key.length() - 1; i++) {
            Attributes += key.charAt(i);
        }
        for (int i = 0; i < value.length() - 1; i++) {
            Values += value.charAt(i);
        }
        Attributes = "(" + Attributes + ")";
        Values = "(" + Values + ")";
        String Query = "INSERT INTO " + TableName + " " + Attributes + " VALUES " + Values + " ";
        try {
            System.out.println(Query);

            PreparedStatement pre = DB_Access.prepareStatement(Query, Statement.RETURN_GENERATED_KEYS);
            int counter = 0;
            for (Map.Entry<String, String> entry : values.entrySet()) {
                pre.setString(++counter, entry.getValue());
            }
            pre.executeUpdate();
            rs = pre.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return -1;
    }

    public int SelectMax(String TableName, String IDNAME,String Condition) {

        String Query = "SELECT MAX(" + IDNAME + "" + ") FROM " + TableName +" WHERE "+Condition;
        System.out.println(Query);
        try {
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public int SelectMin(String TableName, String IDNAME,String Condition)
    {
        String Query = "SELECT MIN(" + IDNAME + "" + ") FROM " + TableName +" WHERE "+Condition;
        System.out.println(Query);
        try {
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public String CurTime() {
        try {
            String Query = "SELECT CURTIME()";
            PreparedStatement pre = DB_Access.prepareStatement(Query);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return result.getTime(1).toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB_.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }      
    
}
