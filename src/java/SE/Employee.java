/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import DB.DB_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emad
 */
public class Employee extends Person {

    private int BranchID;



    public void setBranchID(int BranchID) {
        this.BranchID = BranchID;
    }

    public int getBranchID() {
        return BranchID;
    }

    public int AddTime(String Start, String End) 
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> R = DB.Select("ID", "branches_time", "branch_id=" + this.getBranchID());
        if (R == null || R.isEmpty()) 
        {
            HashMap<String, String> H = new HashMap();
            H.put("branch_id", "" + this.getBranchID());
            H.put("time_from", Start);
            H.put("time_to", End);
            H.put("Open_Flag", "1");

            return DB.Insert("branches_time", H);
        } 
        else
        {
            DB.Update("branches_time", "time_from='" + Start + "'" + " , time_to='" + End + "'", "branch_id=" + this.getBranchID());
            return -1;
        }
    }
    public boolean ClearList()
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        return DB.Delete("arrange","branch_id="+this.getBranchID());
    }
    public ArrayList<User>GetList()
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<User> users=new ArrayList<>();
        HashMap<Integer,User>Arr=new HashMap<>();
        ArrayList<HashMap<String,String>> Result=DB.Select("*","arrange","branch_id="+this.getBranchID());
        ArrayList<HashMap<String,String>> Result2=DB.Select("*","special_arrange","branch_id="+this.getBranchID());        
        
        for(int i=0;i<Result.size();i++)
        {
            User U=new User();
            ArrayList<HashMap<String,String>>R=DB.Select("*","user_","ID="+Result.get(i).get("user_id"));
            U.setFname(R.get(0).get("fname"));
            U.setLname(R.get(0).get("lname"));
            U.setEmail(R.get(0).get("mail"));
            U.setUserID(Integer.parseInt(R.get(0).get("ID")));
            Arr.put(Integer.parseInt(Result.get(i).get("user_number")), U);
        }
        for(int i=0;i<Result2.size();i++)
        {
            User U=new User();
            ArrayList<HashMap<String,String>>R=DB.Select("*","user_","ID="+Result2.get(i).get("user_id"));
            U.setFname(R.get(0).get("fname"));
            U.setLname(R.get(0).get("lname"));
            U.setEmail(R.get(0).get("mail"));
            U.setUserID(Integer.parseInt(R.get(0).get("ID")));
            Arr.put(Integer.parseInt(Result2.get(i).get("user_number")), U);
        }        

        int MaxSpecial=DB.SelectMax("special_arrange","user_number","branch_id="+this.getBranchID());
        int MaxArrange=DB.SelectMax("arrange","user_number","branch_id="+this.getBranchID());
        int Max_Iterator;
        if(MaxArrange>MaxSpecial)
            Max_Iterator=MaxArrange;
        else
            Max_Iterator=MaxSpecial;
        for(int i=0;i<=Max_Iterator;i++)
        {
            if(Arr.get(i)!=null)
                users.add(Arr.get(i));
        }
        return users;
    }
    public boolean DeleteTop()
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        int Min_Arrange=DB.SelectMin("arrange","user_number","branch_id="+this.getBranchID());
        int Min_Special_Arrange=DB.SelectMin("special_arrange","user_number","branch_id="+this.getBranchID());
        System.out.println(Min_Special_Arrange);
        if(Min_Arrange==0)
            Min_Arrange=10000;
        if(Min_Special_Arrange==0)
            Min_Special_Arrange=10000;
        if(Min_Arrange<Min_Special_Arrange)
            DB.Delete("arrange", "branch_id="+this.getBranchID()+" and user_number="+Min_Arrange);
        else if(Min_Special_Arrange<Min_Arrange)
            DB.Delete("special_arrange", "branch_id="+this.getBranchID()+" and user_number="+Min_Special_Arrange);
        return true;
    }
}
