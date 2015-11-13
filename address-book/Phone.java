/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axu088
 */
public class Phone {
    String landline,mobile;

    public Phone(){
        
    }

    public Phone(String landline,String mobile){
        this.landline=landline;
        this.mobile=mobile;
    }

    public String getLandline(){
        return landline;
    }

    public String getMobile(){
        return mobile;
    }

    public void setLandline(String landline){
        this.landline=landline;
    }

    public void setMobile(String mobile){
        this.mobile=mobile;
    }
}
