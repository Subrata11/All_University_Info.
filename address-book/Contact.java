/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulsalam
 */
public class Contact {
    private String id,title,forename,surname,gender,email,photoURL,webpage;
    private Phone phone;
    private Address homeAddress,correspondingAddress;

    public Contact(){
        phone=new Phone();
        homeAddress=new Address();
        correspondingAddress=new Address();
    }

    public Contact(String id, String title, String forename, String surname, String gender, Address homeAddress, Phone phone, String email, Address correspondingAddress, String photoURL, String webpage){
        this.id=id;
        this.title=title;
        this.forename=forename;
        this.surname=surname;
        this.gender=gender;
        this.homeAddress=homeAddress;
        this.phone=phone;
        this.email=email;
        this.correspondingAddress=correspondingAddress;
        this.photoURL=photoURL;
        this.webpage=webpage;
    }//end constructor

    public Contact( String title, String forename, String surname, String gender, Address homeAddress, Phone phone, String email, Address correspondingAddress, String photoURL, String webpage){
        this.title=title;
        this.forename=forename;
        this.surname=surname;
        this.gender=gender;
        this.homeAddress=homeAddress;
        this.phone=phone;
        this.email=email;
        this.correspondingAddress=correspondingAddress;
        this.photoURL=photoURL;
        this.webpage=webpage;
    }//end constructor

    public Contact(String id, String title, String forename, String surname, String gender, String homeLine1, String homeLine2, String homeCity, String homePostcode, String homeCountry, Phone phone, String email, String correspondingLine1, String correspondingLine2, String correspondingCity, String correspondingPostcode, String correspondingCountry, String photoURL, String webpage){
        this.id=id;
        this.title=title;
        this.forename=forename;
        this.surname=surname;
        this.gender=gender;
        this.phone=phone;
        //String homeLine1, String homeLine2, String homeCity, String homePostcode, String homeCountry
        //this.landline=landline;
        //this.mobile=mobile;
        this.email=email;
        //String correspondingLine1, String correspondingLine2, String correspondingCity, String correspondingPostcode, String correspondingCountry
        this.photoURL=photoURL;
        this.webpage=webpage;
    }

    public String getID(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getForename(){
        return forename;
    }

    public String getSurname(){
        return surname;
    }

    public String getGender(){
        return gender;
    }

    public Address getHomeAddress(){
        return homeAddress;
    }

    public Phone getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public Address getCorrespondingAddress(){
        return correspondingAddress;
    }

    public String getPhotoURL(){
        return photoURL;
    }

    public String getWebpage(){
        return webpage;
    }

    public void setID(String id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setForename(String forename){
        this.forename=forename;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public void setHomeAddress(Address address){
        this.homeAddress=address;
    }

    public void setPhone(Phone phone){
        this.phone=phone;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setCorrespondingAddress(Address address){
        this.correspondingAddress=address;
    }

    public void setPhotoURL(String photoUrl){
        this.photoURL=photoUrl;
    }

    public void setWebpage(String webpage){
        this.webpage=webpage;
    }
}
