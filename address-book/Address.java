/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulsalam
 */
public class Address {
   // this(address.getLine1(), address.getLine2(), address.getCity(),address.getPostcode(), address.getCountry());
    private String line1,line2,city,postcode,country;

    public Address(){

    }

    public Address(String line1, String line2, String city, String postcode, String country){
        this.line1=line1;
        this.line2=line2;
        this.city=city;
        this.postcode=postcode;
        this.country=country;
    }

    public String getLine1(){
        return line1;
    }

    public String getLine2(){
        return line2;
    }

    public String getCity(){
        return city;
    }

    public String getPostcode(){
        return postcode;
    }

    public String getCountry(){
        return country;
    }

    public void setLine1(String line1){
        this.line1=line1;
    }

    public void setLine2(String line2){
        this.line2=line2;
    }

    public void setCity(String city){
        this.city=city;
    }

    public void setPostcode(String postcode){
        this.postcode=postcode;
    }

    public void setCountry(String country){
        this.country=country;
    }
}
