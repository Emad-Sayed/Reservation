/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE;

/**
 *
 * @author emad
 */
public class Branch {
    private String Name;
    private String Director;
    private String Phone;
    private String Description;
    private int Category_ID;

    public void setCategory_ID(int Category_ID) {
        this.Category_ID = Category_ID;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDirector(String ManagerName) {
        this.Director = ManagerName;
    }

    public void setPhone(String ManagerPhone) {
        this.Phone = ManagerPhone;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCategory_ID() {
        return Category_ID;
    }

    public String getDescription() {
        return Description;
    }

    public String getDirector() {
        return Director;
    }

    public String getPhone() {
        return Phone;
    }

    public String getName() {
        return Name;
    }
    
}
