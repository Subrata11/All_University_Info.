
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdulsalam
 */
public class XMLProcessor {

    private Document doc;
    private File file;

    public XMLProcessor(File file) {
        open(file);
    }

    public void addContact(Contact c) {
        try {
            //find last id
            List nodes = XPath.selectNodes(doc.getRootElement(), "//contact[@id]");
            Iterator it = nodes.iterator();
            int lastid = 0;

            while (it.hasNext()) {
                Element e = (Element) it.next();
                String id = e.getAttributeValue("id");
                lastid = Integer.parseInt(id);
            }

            int newid = ++lastid;

            Element contact = new Element("contact");
            contact.setAttribute("id", String.valueOf(newid));
            doc.getRootElement().addContent(contact);
            addNode(contact, "title", c.getTitle());
            addNode(contact, "forename", c.getForename());
            addNode(contact, "surname", c.getSurname());
            addNode(contact, "gender", c.getGender());
            addAddressNode(contact, c.getHomeAddress(), "Home");
            addPhoneNode(contact, c.getPhone());
            addAddressNode(contact, c.getCorrespondingAddress(), "Corresponding");
            addNode(contact, "email", c.getEmail());
            addNode(contact, "photo", c.getPhotoURL());
            addNode(contact, "webpage", c.getWebpage());

        } catch (JDOMException ex) {
            Logger.getLogger(XMLProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addAddressNode(Element e, Address address, String type) throws JDOMException {
        Element el = new Element("address");
        el.setAttribute("type", type);
        e.addContent(el);
        addNode(el, "line1", address.getLine1());
        addNode(el, "line2", address.getLine2());
        addNode(el, "city", address.getCity());
        addNode(el, "postcode", address.getPostcode());
        addNode(el, "country", address.getCountry());
    }

    private void addPhoneNode(Element e, Phone phone) {
        addNode(e, "phone", "");
        Element n = e.getChild("phone");
        addNode(n, "landline", phone.getLandline());
        addNode(n, "mobile", phone.getMobile());
    }

    private void addNode(Element parent, String child, String text) {
        Element node = new Element(child);
        node.setText(text);
        parent.addContent(node);
        save();
    }

    public void saveEdit(Contact c) {
        try {
            List node = XPath.selectNodes(doc.getRootElement(), "//contact[@id='" + c.getID() + "']");
            Iterator i = node.iterator();
            Element e = (Element) i.next();
            e.getChild("title").setText(c.getTitle());
            e.getChild("forename").setText(c.getForename());
            e.getChild("surname").setText(c.getSurname());
            e.getChild("gender").setText(c.getGender());
            List homeNode = XPath.selectNodes(e, "//contact[@id='" + c.getID() + "']/address[@type='Home']");
            Iterator ai = homeNode.iterator();
            Element ae = (Element) ai.next();
            ae.getChild("line1").setText(c.getHomeAddress().getLine1());
            ae.getChild("line2").setText(c.getHomeAddress().getLine2());
            ae.getChild("city").setText(c.getHomeAddress().getCity());
            ae.getChild("postcode").setText(c.getHomeAddress().getPostcode());
            ae.getChild("country").setText(c.getHomeAddress().getCountry());

            List phoneNode = XPath.selectNodes(e, "//contact[@id='" + c.getID() + "']/phone']");
            Iterator pi = phoneNode.iterator();
            Element pe = (Element) pi.next();
            pe.getChild("landline").setText(c.getPhone().getLandline());
            pe.getChild("mobile").setText(c.getPhone().getMobile());

            List corresNode = XPath.selectNodes(e, "//contact[@id='" + c.getID() + "']/address[@type='Corresponding']");
            Iterator bi = corresNode.iterator();
            Element be = (Element) bi.next();
            be.getChild("line1").setText(c.getCorrespondingAddress().getLine1());
            be.getChild("line2").setText(c.getCorrespondingAddress().getLine2());
            be.getChild("city").setText(c.getCorrespondingAddress().getCity());
            be.getChild("postcode").setText(c.getCorrespondingAddress().getPostcode());
            be.getChild("country").setText(c.getCorrespondingAddress().getCountry());

            e.getChild("email").setText(c.getEmail());
            e.getChild("photo").setText(c.getPhotoURL());
            e.getChild("webpage").setText(c.getWebpage());

            save();
        } catch (JDOMException ex) {
        }
    }

    public void deleteContact(Contact c) {
        try {
            List node = XPath.selectNodes(doc.getRootElement(), "//contact[@id='" + c.getID() + "']");
            Iterator i = node.iterator();
            Element e = (Element) i.next();
            Element parent = e.getParentElement();
            parent.removeContent(e);
            save();
            JOptionPane.showMessageDialog(null, c.getForename() + " " + c.getSurname() + " has been deleted");
        } catch (JDOMException ex) {
            JOptionPane.showMessageDialog(null, "Error occured contact not deleted");
        }
    }

    public void deleteContact(String id) {
    }

    public Contact[] getAllContacts() {
        Vector contacts = new Vector();
        try {

            List nodes = XPath.selectNodes(doc.getRootElement(), "//contact");
            Iterator it = nodes.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                //getting values
                String id = e.getAttributeValue("id");
                String title = e.getChildText("title");
                String forename = e.getChildText("forename");
                String surname = e.getChildText("surname");
                String gender = e.getChildText("gender");
                String email = e.getChildText("email");
                String photo = e.getChildText("photo");
                String webpage = e.getChildText("webpage");
                //phone
                String landline = e.getChild("phone").getChildText("landline");
                String mobile = e.getChild("phone").getChildText("mobile");
                //homeaddress
                List homeNode = XPath.selectNodes(e, "//contact[@id='" + e.getAttributeValue("id") + "']/address[@type='Home']");
                Iterator ai = homeNode.iterator();
                Element ae = (Element) ai.next();
                String homeAddressLine1 = ae.getChildText("line1");
                String homeAddressLine2 = ae.getChildText("line2");
                String homeAddressCity = ae.getChildText("city");
                String homeAddressPostcode = ae.getChildText("postcode");
                String homeAddressCountry = ae.getChildText("country");
                //homeaddress
                List corresNode = XPath.selectNodes(e, "//contact[@id='" + e.getAttributeValue("id") + "']/address[@type='Corresponding']");
                Iterator bi = corresNode.iterator();
                Element be = (Element) bi.next();
                String corresAddressLine1 = be.getChildText("line1");
                String corresAddressLine2 = be.getChildText("line2");
                String corresAddressCity = be.getChildText("city");
                String corresAddressPostcode = be.getChildText("postcode");
                String corresAddressCountry = be.getChildText("country");

                Phone phone = new Phone(landline, mobile);
                Address homeAddress = new Address(homeAddressLine1, homeAddressLine2, homeAddressCity, homeAddressPostcode, homeAddressCountry);
                Address correspondingAddress = new Address(corresAddressLine1, corresAddressLine2, corresAddressCity, corresAddressPostcode, corresAddressCountry);
                Contact c = new Contact(id, title, forename, surname, gender, homeAddress, phone, email, correspondingAddress, photo, webpage);

                contacts.add(c);
            }

        } catch (JDOMException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        //loading to contact array
        Contact contactlist[] = new Contact[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            contactlist[i] = (Contact) contacts.elementAt(i);
        }

        return contactlist;
    }

    public Contact getContact(String cid) {
        try {
            Contact c;
            List nodes = XPath.selectNodes(doc.getRootElement(), "//contact[@id='" + cid + "']");
            Iterator it = nodes.iterator();
            if (it.hasNext()) {
                Element e = (Element) it.next();
                //getting values
                String id = e.getAttributeValue("id");
                String title = e.getChildText("title");
                String forename = e.getChildText("forename");
                String surname = e.getChildText("surname");
                String gender = e.getChildText("gender");
                String email = e.getChildText("email");
                String photo = e.getChildText("photo");
                String webpage = e.getChildText("webpage");
                //phone
                String landline = e.getChild("phone").getChildText("landline");
                String mobile = e.getChild("phone").getChildText("mobile");
                //homeaddress
                List homeNode = XPath.selectNodes(e, "//contact[@id='" + cid + "']/address[@type='Home']");
                Iterator ai = homeNode.iterator();
                Element ae = (Element) ai.next();
                String homeAddressLine1 = ae.getChildText("line1");
                String homeAddressLine2 = ae.getChildText("line2");
                String homeAddressCity = ae.getChildText("city");
                String homeAddressPostcode = ae.getChildText("postcode");
                String homeAddressCountry = ae.getChildText("country");
                //homeaddress
                List corresNode = XPath.selectNodes(e, "//contact[@id='" + cid + "']/address[@type='Corresponding']");
                Iterator bi = corresNode.iterator();
                Element be = (Element) bi.next();
                String corresAddressLine1 = be.getChildText("line1");
                String corresAddressLine2 = be.getChildText("line2");
                String corresAddressCity = be.getChildText("city");
                String corresAddressPostcode = be.getChildText("postcode");
                String corresAddressCountry = be.getChildText("country");

                Phone phone = new Phone(landline, mobile);
                Address homeAddress = new Address(homeAddressLine1, homeAddressLine2, homeAddressCity, homeAddressPostcode, homeAddressCountry);
                Address correspondingAddress = new Address(corresAddressLine1, corresAddressLine2, corresAddressCity, corresAddressPostcode, corresAddressCountry);
                c = new Contact(id, title, forename, surname, gender, homeAddress, phone, email, correspondingAddress, photo, webpage);

                return c;

            } else {
                JOptionPane.showMessageDialog(null, "Contact not found");
            }

        } catch (JDOMException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return null;
    }

    public String getText(Object o) {

        return "";
    }

    public void open(File _file) {
        file = _file;
        try {
            SAXBuilder builder = new SAXBuilder();
            doc = builder.build(file);
            System.out.println("XML file opened: " + _file.getName());
        } catch (JDOMException jde) {
            jde.printStackTrace();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

        public Contact[] findContacts(String search) {
        Vector contacts = new Vector();
        try {

            List nodes = XPath.selectNodes(doc.getRootElement(), "//contact[surname='"+search+"' or forename='"+search+"' or title='"+search+"' or email='"+search+"']");
            Iterator it = nodes.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                //getting values
                String id = e.getAttributeValue("id");
                String title = e.getChildText("title");
                String forename = e.getChildText("forename");
                String surname = e.getChildText("surname");
                String gender = e.getChildText("gender");
                String email = e.getChildText("email");
                String photo = e.getChildText("photo");
                String webpage = e.getChildText("webpage");
                //phone
                String landline = e.getChild("phone").getChildText("landline");
                String mobile = e.getChild("phone").getChildText("mobile");
                //homeaddress
                List homeNode = XPath.selectNodes(e, "//contact[@id='" + e.getAttributeValue("id") + "']/address[@type='Home']");
                Iterator ai = homeNode.iterator();
                Element ae = (Element) ai.next();
                String homeAddressLine1 = ae.getChildText("line1");
                String homeAddressLine2 = ae.getChildText("line2");
                String homeAddressCity = ae.getChildText("city");
                String homeAddressPostcode = ae.getChildText("postcode");
                String homeAddressCountry = ae.getChildText("country");
                //homeaddress
                List corresNode = XPath.selectNodes(e, "//contact[@id='" + e.getAttributeValue("id") + "']/address[@type='Corresponding']");
                Iterator bi = corresNode.iterator();
                Element be = (Element) bi.next();
                String corresAddressLine1 = be.getChildText("line1");
                String corresAddressLine2 = be.getChildText("line2");
                String corresAddressCity = be.getChildText("city");
                String corresAddressPostcode = be.getChildText("postcode");
                String corresAddressCountry = be.getChildText("country");

                Phone phone = new Phone(landline, mobile);
                Address homeAddress = new Address(homeAddressLine1, homeAddressLine2, homeAddressCity, homeAddressPostcode, homeAddressCountry);
                Address correspondingAddress = new Address(corresAddressLine1, corresAddressLine2, corresAddressCity, corresAddressPostcode, corresAddressCountry);
                Contact c = new Contact(id, title, forename, surname, gender, homeAddress, phone, email, correspondingAddress, photo, webpage);

                contacts.add(c);
            }

        } catch (JDOMException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        //loading to contact array
        Contact contactlist[] = new Contact[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            contactlist[i] = (Contact) contacts.elementAt(i);
        }

        return contactlist;
    }

    public void save() {
        try {
            XMLOutputter xmlo = new XMLOutputter();
            xmlo.output(doc, new FileOutputStream(file));
        } catch (java.io.FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
