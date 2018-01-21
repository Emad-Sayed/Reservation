/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import DB.DB_;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Manager extends Person {
    
    public boolean AddPost(Post P) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> newPost = new HashMap<String, String>();
        newPost.put("CONTENT_NAME", "0");
        newPost.put("CONTENT_VALUE", P.getTitle());
        DB.Insert("posts", newPost);
        newPost = new HashMap<String, String>();
        newPost.put("CONTENT_NAME", "1");
        newPost.put("CONTENT_VALUE", P.getPara());
        DB.Insert("posts", newPost);
        return true;
    }
    
    public Post SearchPost(String Title) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        result = DB.Select("ID", "posts", "CONTENT_VALUE='" + Title + "'");
        try {
            int Title_ID = Integer.parseInt(result.get(0).get("ID"));
            int Para_ID = Title_ID + 1;
            result = DB.Select("CONTENT_VALUE", "posts", "ID=" + Para_ID);
            String Para = result.get(0).get("CONTENT_VALUE");
            Post P = new Post();
            P.setPara(Para);
            P.setTitle(Title);
            return P;
        } catch (Exception E) {
        }
        return null;
    }
    
    public boolean DeletePost(String Title) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        result = DB.Select("ID", "posts", "CONTENT_VALUE='" + Title + "'");
        try {
            int Title_ID = Integer.parseInt(result.get(0).get("ID"));
            int Para_ID = Title_ID++;
            DB.Delete("posts", "ID=" + Title_ID);
            DB.Delete("posts", "ID=" + Para_ID);
            return true;
        } catch (Exception E) {
            
        }
        return false;
        
    }

    public int AddBranch(Branch B) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> H = new HashMap();
        H.put("name", B.getName());
        H.put("CATEGORY_ID", "" + B.getCategory_ID());
        H.put("Director", B.getDirector());
        H.put("phone", B.getPhone());
        H.put("Description", B.getDescription());
        int Flag = DB.Insert("branches", H);
        return Flag;
    }

    public int AddCategory(Category C) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        HashMap<String, String> H = new HashMap();
        H.put("CATEGORY_NAME", C.getName());
        int Flag = -1;
        Flag = DB.Insert("category", H);
        return Flag;
    }    

    public int AddEmploye(Employee E) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> Result = DB.Select("ID", "employee_branch", "Branch_ID=" + E.getBranchID());
        if (!Result.isEmpty()) {
            return -1;
        }
        HashMap<String, String> Values = new HashMap();
        Values.put("mail", E.getEmail());
        Values.put("password", E.getPassword());
        Values.put("fname", E.getFname());
        Values.put("lname", E.getLname());
        Values.put("phone", E.getPhone());        
        Values.put("TYPE_ID", "3");
        
        int flag = DB.Insert("user_", Values);
        Values = new HashMap();
        Values.put("Emp_ID", "" + flag);
        Values.put("Branch_ID", "" + E.getBranchID());
        DB.Insert("employee_branch", Values);
        return flag;
    }

    public Employee SearchEmployee(int ID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> Result = DB.Select("*", "user_", "ID='" + ID + "'");
        if (Result.size() == 0) {
            return null;
        }
        Employee E = new Employee();
        E.setFname(Result.get(0).get("fname"));
        E.setLname(Result.get(0).get("lname"));
        E.setPassword(Result.get(0).get("password"));
        E.setEmail(Result.get(0).get("mail"));
        E.setPhone(Result.get(0).get("phone"));
        int Emp_ID = Integer.parseInt(Result.get(0).get("ID"));
        Result = DB.Select("Branch_ID", "employee_branch", "Emp_ID=" + Emp_ID);        
        try {
            E.setBranchID(Integer.parseInt(Result.get(0).get("Branch_ID")));
        } catch (Exception Exc) {
            return null;
        }
        return E;
    }
    
    public Branch SearchBranch(String Name) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> Result = DB.Select("*", "branches", "name='" + Name + "'");
        if (Result.size() == 0) {
            return null;
        }
        Branch B = new Branch();
        B.setName(Result.get(0).get("name"));
        B.setDescription(Result.get(0).get("Description"));
        B.setPhone(Result.get(0).get("phone"));
        B.setDirector(Result.get(0).get("Director"));
        B.setCategory_ID(Integer.parseInt(Result.get(0).get("CATEGORY_ID")));
        return B;
    }    

    public static void main(String[] args) throws SQLException {
        Sys S = Sys.GetSystem();
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        Employee E = new Employee();
        E.setFname("");
        E.setFname("");
        E.setLname("");
        E.setPhone("");
        E.setPassword("");
        E.setSecretWord("");
        E.setEmail("");
        E.setType(3);
        E.setUserID(5);
        E.setBranchID(1);
        Manager M = new Manager();
        System.out.println(M.AddEmploye(E));
    }
    
}
