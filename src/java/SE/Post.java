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
public class Post {
    private String Title;
    private String Para;

    public void setPara(String Para) {
        this.Para = Para;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPara() {
        return Para;
    }

    public String getTitle() {
        return Title;
    }
    
}
