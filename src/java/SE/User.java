/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import DB.DB_;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class User extends Person {

    public int GetNumber(String BranchName) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        Sys S = Sys.GetSystem();
        int Branch_ID = S.GetBranchID(BranchName);
        ArrayList<HashMap<String, String>> R = DB.Select("user_number", "arrange", "user_id=" + this.getUserID() + " and branch_id=" + Branch_ID);
        if (!R.isEmpty()) {
            return Integer.parseInt(R.get(0).get("user_number"));
        }
        R = DB.Select("user_number", "special_arrange", "user_id=" + this.getUserID() + " and branch_id=" + Branch_ID);
        if(!R.isEmpty())
        {
            return Integer.parseInt(R.get(0).get("user_number"));
        }

        String Current_Time = DB.CurTime();
        if (S.CheckTimeIn(Branch_ID, Current_Time) == false) // el m3ad el by7gz feh f el range wla la2
        {
            return -1;//Time Not Avilable
        }
                //law awl Wa7ed
        R=DB.Select("*","special_arrange","1");
        HashMap<String, String> In = new HashMap();        
        if(R.isEmpty())
        {
        In.put("user_id", "" + this.getUserID());
        In.put("branch_id", "" + Branch_ID);
        In.put("branch_time_id", R.get(0).get("ID"));
        In.put("user_number", "" + 1);
        DB.Insert("arrange", In);    
        return 1;
        }
        R = DB.Select("ID", "branches_time", "branch_id=" + Branch_ID);
        In.put("user_id", "" + this.getUserID());
        In.put("branch_id", "" + Branch_ID);
        In.put("branch_time_id", R.get(0).get("ID"));
        int LastPerson = DB.SelectMax("arrange", "user_number", "branch_id=" + Branch_ID);// a5er wa7ed 3leh el dor
        int MyNumber = LastPerson+1;
        //Check el Rkm dh mwgod f el Gdwl el Special wla la2
        //h3od adwr 3la rkm msh mwgod f gdw el special        
        while(true)
        {
         R = DB.Select("ID", "special_arrange", "branch_id=" + Branch_ID+" and user_number="+MyNumber);
         if(R.isEmpty())
         break;
         else
             MyNumber = MyNumber+1;
        }
        In.put("user_number", "" + MyNumber);
        DB.Insert("arrange", In);
        return MyNumber;
    }
    public int GetSpecificNumber(String BranchName,int SelectedNumber)
    {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        Sys S = Sys.GetSystem();
        int Branch_ID = S.GetBranchID(BranchName);
        ArrayList<HashMap<String, String>> R = DB.Select("user_number", "arrange", "user_id=" + this.getUserID() + " and branch_id=" + Branch_ID);
        if (!R.isEmpty()) {
            return Integer.parseInt(R.get(0).get("user_number"));
        }
        R = DB.Select("user_number", "special_arrange", "user_id=" + this.getUserID() + " and branch_id=" + Branch_ID);
        if(!R.isEmpty())
        {
            return Integer.parseInt(R.get(0).get("user_number"));
        }

        String Current_Time = DB.CurTime();
        if (S.CheckTimeIn(Branch_ID, Current_Time) == false) // el m3ad el by7gz feh f el range wla la2
        {
            return -1; //Time Not Avilable
        }
        R = DB.Select("ID", "branches_time", "branch_id=" + Branch_ID);
        HashMap<String, String> In = new HashMap();
        In.put("user_id", "" + this.getUserID());
        In.put("branch_id", "" + Branch_ID);
        In.put("branch_time_id", R.get(0).get("ID"));
        int LastPerson = DB.SelectMax("arrange", "user_number", "branch_id=" + Branch_ID);// a5er wa7ed 3leh el dor
         R = DB.Select("ID", "special_arrange", "branch_id=" + Branch_ID+" and user_number="+SelectedNumber); // el rkm dh mwgod wla la2
        if(LastPerson>SelectedNumber||!R.isEmpty())
            return -2; // Number Not Avialable
        In.put("user_number", "" + SelectedNumber);
        DB.Insert("special_arrange", In);        
        return SelectedNumber;
    }
    public int GetCurrentNumber(String BranchName) {
        Sys S = Sys.GetSystem();

        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int Branch_ID = S.GetBranchID(BranchName);
        return DB.SelectMin("arrange", "user_number", "branch_id=" + Branch_ID);
    }

    public boolean DeleteNumber(String BranchName) {
        Sys S = Sys.GetSystem();

        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int Branch_ID = S.GetBranchID(BranchName);
        return DB.Delete("arrange", "user_id=" + this.getUserID() + " and branch_id=" + Branch_ID);
    }
}
