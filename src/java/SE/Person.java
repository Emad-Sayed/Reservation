/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

import java.util.HashMap;

/**
 *
 * @author emad
 */
public class Person {
    private int UserID;
    private int Type;
    private String Fname;
    private String Lname;
    private String Email;
    private String Password;
    private String SecretWord;
    private String Phone;

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
      

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setSecretWord(String SecretWord) {
        this.SecretWord = SecretWord;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getEmail() {
        return Email;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getPassword() {
        return Password;
    }

    public String getSecretWord() {
        return SecretWord;
    }

    public int getType() {
        return Type;
    }

    public int getUserID() {
        return UserID;
    }

    public String getPhone() {
        return Phone;
    }
    
    public boolean UpdateProfile(HashMap<String,String> P)
    {
        return false;
    }
    public boolean ChnagePassword(String OldPass,String NewPass)
    {
        return false;
    }
}
