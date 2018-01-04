/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import DB.DB_;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author emad
 */
public class Sys {

    static private Sys Sys = null;

    private Sys() {
    }

    static public Sys GetSystem() {
        if (Sys == null) {
            Sys = new Sys();
            return Sys;
        } else {
            return Sys;
        }
    }

 /*   public boolean FileUpload(String Path, FileItemStream item) {
        File f = new File(Path + File.separator + "image");
        if (!f.exists()) {
            f.mkdir();
        }
        try {
            File SavedFile = new File(f.getAbsolutePath() + File.separator + item.getName());
            FileOutputStream fos = new FileOutputStream(SavedFile);
            try {
                InputStream is = item.openStream();
                int x = 0;
                byte[] b = new byte[1024];
                while ((x = is.read(b)) != -1) {
                    fos.write(b, 0, x);
                }
                fos.flush();
                fos.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Sys.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
        }
        return false;
    }
*/
    public int Login(String Mail, String Password) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int UserID = -1;
        ArrayList<HashMap<String, String>> H = null;
        HashMap<String, String> Result = new HashMap<>();
        H = DB.Select("ID", "user_", "mail='" + Mail + "' and password='" + Password + "'");
        if (H.size() > 0) {
            for (int i = 0; i < H.size(); i++) {
                for (Map.Entry<String, String> entry : H.get(i).entrySet()) {
                    Result.put(entry.getKey(), entry.getValue());
                }
            }
            System.out.println(Result);
            UserID = Integer.parseInt(Result.get("ID"));
        }
        return UserID;
    }

    public int GetUserType(int ID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        int UserType = -1;
        ArrayList<HashMap<String, String>> H = null;
        HashMap<String, String> Result = new HashMap<>();
        H = DB.Select("TYPE_ID", "user_", "ID=" + ID);
        if (H.size() > 0) {
            for (int i = 0; i < H.size(); i++) {
                for (Map.Entry<String, String> entry : H.get(i).entrySet()) {
                    Result.put(entry.getKey(), entry.getValue());
                }
            }
            UserType = Integer.parseInt(Result.get("TYPE_ID"));
        }
        return UserType;
    }

    public ArrayList<HashMap<String, String>> LoadTitles() {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = null;
        HashMap<String, String> Result = new HashMap();
        H = DB.Select("CONTENT_VALUE", "posts", "CONTENT_NAME=0");
        return H;
    }

    public ArrayList<HashMap<String, String>> LoadPara() {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = null;
        HashMap<String, String> Result = new HashMap();
        H = DB.Select("CONTENT_VALUE", "posts", "CONTENT_NAME=1");
        return H;
    }

    public HashMap<String, String> LoadCategory() {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = null;
        HashMap<String, String> Result = new HashMap();
        H = DB.Select("CATEGORY_NAME", "category", "1");
        for (int i = 0; i < H.size(); i++) {
            for (Map.Entry<String, String> entry : H.get(i).entrySet()) {
                Result.put("" + i, entry.getValue());
            }
        }
        return Result;
    }

    public HashMap<String, String> LoadBrunches(String Cat_Name) {
        int Cat_ID = -1;
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = new ArrayList<>();
        HashMap<String, String> Result = new HashMap();
        H = DB.Select("ID", "category", "CATEGORY_NAME='" + Cat_Name + "'");
        for (int i = 0; i < H.size(); i++) {
            for (Map.Entry<String, String> entry : H.get(i).entrySet()) {
                Cat_ID = Integer.parseInt(entry.getValue());
            }
        }
        H = DB.Select("name", "branches", "CATEGORY_ID=" + Cat_ID);
        for (int i = 0; i < H.size(); i++) {
            for (Map.Entry<String, String> entry : H.get(i).entrySet()) {
                Result.put("" + i, entry.getValue());
            }
        }
        return Result;
    }

    public void LoadAboutUsContent() {

    }

    public boolean AddImage(String FilePath, int ImageID) {
        int width = 892;
        int hieght = 418;
        BufferedImage image = null;
        File F = null;
        try {
            F = new File(FilePath);
            image = new BufferedImage(width, hieght, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(F);
            System.out.println("Reading Complited");
        } catch (Exception E) {
            System.out.println("Reading Error");
            return false;
        }
        try {
            F = new File("web\\2.jpg");
            ImageIO.write(image, "jpg", F);
            System.out.println("Writing Complited");
        } catch (Exception E) {
            System.out.println("Writing Error");
        }
        return false;
    }

    public User LoadUserData(int ID) {
        User U = new User();
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = new ArrayList();
        H = DB.Select("*", "user_", "ID=" + ID);
        U.setUserID(Integer.parseInt(H.get(0).get("ID")));
        U.setEmail(H.get(0).get("mail"));
        U.setFname(H.get(0).get("fname"));
        U.setLname(H.get(0).get("lname"));
        U.setPassword(H.get(0).get("password"));
        U.setSecretWord(H.get(0).get("SECRET_WORD"));
        U.setType(Integer.parseInt(H.get(0).get("TYPE_ID")));
        return U;
    }

    public Manager LoadManagerData(int ID) {
        Manager M = new Manager();
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = new ArrayList();
        H = DB.Select("*", "user_", "ID=" + ID);
        M.setUserID(Integer.parseInt(H.get(0).get("ID")));
        M.setEmail(H.get(0).get("mail"));
        M.setFname(H.get(0).get("fname"));
        M.setLname(H.get(0).get("lname"));
        M.setPassword(H.get(0).get("password"));
        M.setSecretWord(H.get(0).get("SECRET_WORD"));
        M.setType(Integer.parseInt(H.get(0).get("TYPE_ID")));
        return M;
    }

    public Employee LoadEmployeeData(int ID) {
        Employee E = new Employee();
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> H = new ArrayList();
        H = DB.Select("*", "user_", "ID=" + ID);
        E.setUserID(Integer.parseInt(H.get(0).get("ID")));
        E.setEmail(H.get(0).get("mail"));
        E.setFname(H.get(0).get("fname"));
        E.setLname(H.get(0).get("lname"));
        E.setPassword(H.get(0).get("password"));
        E.setSecretWord(H.get(0).get("SECRET_WORD"));
        E.setType(Integer.parseInt(H.get(0).get("TYPE_ID")));
        H = DB.Select("Branch_ID", "employee_branch", "Emp_ID=" + ID);
        E.setBranchID(Integer.parseInt(H.get(0).get("Branch_ID")));
        return E;
    }

    public int GetCategoryID(String Name) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
        result = DB.Select("ID", "category", "CATEGORY_NAME='" + Name + "'");
        try {
            int ID = Integer.parseInt(result.get(0).get("ID"));
            return ID;
        } catch (Exception E) {

        }
        return -1;
    }

    public int GetBranchID(String Branch) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> R = DB.Select("ID", "branches", "name='" + Branch + "'");
        try
        {
        return Integer.parseInt(R.get(0).get("ID"));
        }
        catch(Exception E)
        {
            return -1;
        }
    }

    public String GetBranchName(int ID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> R = DB.Select("name", "branches", "ID=" + ID);
        return R.get(0).get("name");
    }

    public String GetCategoryName(int ID) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> R = DB.Select("CATEGORY_NAME", "category", "ID=" + ID);
        return R.get(0).get("CATEGORY_NAME");
    }

    public boolean CheckTimeIn(int BranchID, String Time) {
        DB_ DB = DB_.Get_DB_controller();
        DB.Connect();
        ArrayList<HashMap<String, String>> R = DB.Select("*", "branches_time", "branch_id=" + BranchID);
        try {
            String From_Time = R.get(0).get("time_from");
            String To_Time = R.get(0).get("time_to");
        } catch (Exception E) {
            return false;
        }

        R = DB.Select("*", "branches_time", "branch_id=" + BranchID + " and time_from<'" + Time + "' and time_to>'" + Time + "'");
        if (R.size() == 0) {
            return false;
        }
        return true;
    }
    public int GetEmployeeID(String BranchName)
    {
        DB_ DB=DB_.Get_DB_controller();
        DB.Connect();
        int BranchID=this.GetBranchID(BranchName);
        if(BranchID==-1)
            return -1;
        ArrayList<HashMap<String, String>> R = DB.Select("*", "employee_branch", "Branch_ID=" + BranchID);
        return Integer.parseInt(R.get(0).get("Emp_ID"));

    }
}
//SELECT * FROM `branches_time` WHERE time_from <"20:22:22" and time_to>"20:22:22" and branch_id=1
