
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdulsalam Umar
 */
public class AddressBook extends JFrame {

    //GUI
    JPanel mainFrame;
    PairContainer title, forename, surname, gender, email, webpage;
    AddressContainer homeAddress, correspondingAddress;
    PhoneContainer phone;
    JTable list;
    DefaultTableModel Model;
    //
    private XMLProcessor xmlprocessor;

    public AddressBook(XMLProcessor xmlp) {
        super("1057988's Address Book");
        xmlprocessor = xmlp;

        mainFrame = new JPanel();

        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.add(displayHome());
        //add(displayHome());
        add(mainFrame);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (d.getWidth() / 2) - 250, (int) (d.getHeight() / 2) - 250);
        setLayout(new GridLayout(1, 1));
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //display home page
    private JPanel displayHome() {
        JPanel p = new JPanel();
        JButton add = new JButton("Add a contact");// creat add button
        JButton view = new JButton("View a contact");// create view button
        JButton search = new JButton("Search");
        JButton all = new JButton("Show all");
        JPanel contactListPane = new JPanel();
        //JList contactlist;
        JPanel srch = new JPanel();
        final JTextField srchtext = new JTextField();
        srch.setBorder(BorderFactory.createTitledBorder("Search contact list by Forename, surname or email"));
        srch.setLayout(null);
        srch.setBounds(20, 20, 400, 60);
        srchtext.setBounds(20, 20, 250, 25);
        srch.add(srchtext);
        srch.add(search);

        Contact[] contacts = xmlprocessor.getAllContacts();
        //contactlist = new JList(contacts);
        Vector titleVec = new Vector();
        String title[] = {"ID", "Title", "Forename", "Surname"};

        Vector contactlist = new Vector();

        for (int i = 0; i < contacts.length; i++) {
            Vector contact = new Vector();
            Contact c = contacts[i];
            contact.add(c.getID());
            contact.add(c.getTitle());
            contact.add(c.getForename());
            contact.add(c.getSurname());
            contactlist.add(contact);
        }
        titleVec.addAll(Arrays.asList(title));
        Model = new DefaultTableModel(contactlist, titleVec);
        list = new JTable();
        list.setModel(Model);
        list.setDragEnabled(false);
        JScrollPane js = new JScrollPane(list);
        js.setBorder(BorderFactory.createTitledBorder("Contact list"));
        js.setBackground(Color.gray);
        //contactlist.addListSelectionListener(this);
        contactListPane.setLayout(new GridLayout(1, 1));
        contactListPane.setBounds(20, 130, 380, 300);
        contactListPane.add(js);

        add.addActionListener(new ActionListener() {  // add a contact listener

            public void actionPerformed(ActionEvent e) {
                mainFrame.removeAll();
                mainFrame.add(addContactDisplay(new Contact(), true));
                mainFrame.validate();
                mainFrame.repaint();
            }
        });
        add.setBounds(20, 90, 120, 25);

        view.addActionListener(new ActionListener() {  //view listener

            public void actionPerformed(ActionEvent e) {
                try {
                    int x = list.getSelectedRow();
                    int y = 0;
                    String s = String.valueOf(list.getModel().getValueAt(x, y));
                    mainFrame.removeAll();
                    mainFrame.add(addContactDisplay(xmlprocessor.getContact(s), false));
                    mainFrame.validate();
                    mainFrame.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Select a contact from the list");
                }
            }
        });
        view.setBounds(150, 90, 120, 25);

        search.addActionListener(new ActionListener() {  //search listener

            public void actionPerformed(ActionEvent e) {
                if (!srchtext.getText().equals("")) {
                    Contact[] contacts = xmlprocessor.findContacts(srchtext.getText());
                    Vector titleVec = new Vector();
                    String title[] = {"ID", "Title", "Forename", "Surname"};

                    Vector contactlist = new Vector();

                    for (int i = 0; i < contacts.length; i++) {
                        Vector contact = new Vector();
                        Contact c = contacts[i];
                        contact.add(c.getID());
                        contact.add(c.getTitle());
                        contact.add(c.getForename());
                        contact.add(c.getSurname());
                        contactlist.add(contact);
                    }
                    System.out.println(contactlist);
                    titleVec.addAll(Arrays.asList(title));
                    Model = new DefaultTableModel(contactlist, titleVec);
//                    list = new JTable();
                    list.setModel(Model);
//                    list.revalidate();
//                    js.revalidate();
                    list.addNotify();
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a search string");
                }
            }
        });
        search.setBounds(280, 20, 100, 25);

        all.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Contact[] contacts = xmlprocessor.getAllContacts();
                Vector titleVec = new Vector();
                String title[] = {"ID", "Title", "Forename", "Surname"};

                Vector contactlist = new Vector();

                for (int i = 0; i < contacts.length; i++) {
                    Vector contact = new Vector();
                    Contact c = contacts[i];
                    contact.add(c.getID());
                    contact.add(c.getTitle());
                    contact.add(c.getForename());
                    contact.add(c.getSurname());
                    contactlist.add(contact);
                }
                System.out.println(contactlist);
                titleVec.addAll(Arrays.asList(title));
                Model = new DefaultTableModel(contactlist, titleVec);
                list.setModel(Model);
                list.addNotify();
            }
        });
        all.setBounds(280, 90, 120, 25);

        p.setLayout(null);
        p.add(add);
        p.add(view);
        p.add(all);
        p.add(srch);
        p.add(contactListPane);
        p.setPreferredSize(new Dimension(400, 400));

        return p;
    }

    private JPanel addContactDisplay(Contact _contact, final Boolean b) {
        final Contact contact = _contact;
        JPanel p = new JPanel();
        JPanel content = new JPanel();
        title = new PairContainer("Title", contact.getTitle());
        forename = new PairContainer("forename", contact.getForename());
        surname = new PairContainer("surname", contact.getSurname());
        //gender
        gender = new PairContainer("Gender", contact.getGender());
        phone = new PhoneContainer(contact.getPhone());
        email = new PairContainer("Email", contact.getEmail());
        webpage = new PairContainer("Web Page", contact.getWebpage());
        homeAddress = new AddressContainer(contact.getHomeAddress());
        correspondingAddress = new AddressContainer(contact.getCorrespondingAddress());

        content.setLayout(new GridLayout(6, 1, 0, 5));
        content.setBounds(20, 20, 200, 170);
        content.setBorder(BorderFactory.createTitledBorder("Details"));
        content.add(title);
        content.add(forename);
        content.add(surname);
        content.add(gender);
        //content.add(phone);
        content.add(email);
        content.add(webpage);

        phone.setBounds(20, 190, 200, 70);
        phone.setBorder(BorderFactory.createTitledBorder("Phone lines"));

        homeAddress.setBounds(20, 260, 200, 150);
        homeAddress.setBorder(BorderFactory.createTitledBorder("Home Address"));

        correspondingAddress.setBounds(240, 260, 200, 150);
        correspondingAddress.setBorder(BorderFactory.createTitledBorder("Corresponding Address"));

        JButton save = new JButton("Save");
        save.setBounds(20, 420, 100, 30);
        save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //save contact
                contact.setTitle(title.getValue());
                contact.setGender(gender.getValue());
                contact.setForename(forename.getValue());
                contact.setSurname(surname.getValue());
                contact.setHomeAddress(homeAddress.getValue());
                contact.setPhone(phone.getValue());
                contact.setEmail(email.getValue());
                contact.setCorrespondingAddress(correspondingAddress.getValue());
                contact.setWebpage(webpage.getValue());
                if (b) {
                    xmlprocessor.addContact(contact);
                    JOptionPane.showMessageDialog(null, "New contact saved!");
                    mainFrame.removeAll();
                    mainFrame.add(addContactDisplay(contact, false));
                    mainFrame.validate();
                    mainFrame.repaint();
                } else {
                    xmlprocessor.saveEdit(contact);
                    JOptionPane.showMessageDialog(null, "Changes saved!");
                }

            }
        });
        JButton cancel = new JButton("Cancel");
        if (!b) {
            cancel.setText("Back home");
        }
        cancel.setBounds(140, 420, 100, 30);
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainFrame.removeAll();
                mainFrame.add(displayHome());
                mainFrame.validate();
                mainFrame.repaint();
            }
        });

        JButton delete = new JButton("Delete");
        delete.setBounds(250, 420, 100, 30);
        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                xmlprocessor.deleteContact(contact);
                mainFrame.removeAll();
                mainFrame.add(displayHome());
                mainFrame.validate();
                mainFrame.repaint();
            }
        });

        JButton upload = new JButton("Upload Picture");
        upload.setBounds(280, 210, 120, 25);
        upload.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    contact.setPhotoURL(chooser.getSelectedFile().getAbsolutePath());
                    System.out.println(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        if (contact.getPhotoURL() != null && !contact.getPhotoURL().equals("")) {
            try {
                Image temp = new ImageIcon(contact.getPhotoURL()).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                JLabel picture = new JLabel(new ImageIcon(temp));
                picture.setBounds(250, 20, 180, 180);
                p.add(picture);
            } catch (Exception e) {
            }
        } else {
            try {
                Image temp = new ImageIcon(
                        getClass().getResource("blank.png")).getImage().getScaledInstance(180, 180,
                        Image.SCALE_SMOOTH);
                JLabel picture = new JLabel(new ImageIcon(temp));
                picture.setBounds(250, 20, 180, 180);
                p.add(picture);
            } catch (Exception e) {
            }
        }

        p.add(content);
        p.add(phone);
        p.add(homeAddress);
        p.add(save);
        p.add(cancel);
        if (!b) {
            p.add(delete);
        }
        p.add(upload);
        p.add(correspondingAddress);
        p.setLayout(null);
        p.setPreferredSize(new Dimension(400, 400));

        return p;
    }

    public static void main(String args[]) {
        try {
            String filename = "AddressBookData.xml";
            File sourceXML = new File(filename);
            if (sourceXML.createNewFile()) {
                FileWriter fw = new FileWriter(sourceXML);
                fw.write("<?xml version='1.0' encoding='UTF-8'?>" + "<contactlist nextid='1'></contactlist>");
                fw.close();
            }
            //File sourceXML = new File(filename);
            XMLProcessor xmlp = new XMLProcessor(sourceXML);
            AddressBook ab = new AddressBook(xmlp);
        } catch (IOException ex) {
            Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class AddressContainer extends JPanel {

        private PairContainer line1, line2, city, postcode, country;

        public AddressContainer(Address address) {
            this(address.getLine1(), address.getLine2(), address.getCity(),
                    address.getPostcode(), address.getCountry());
        }

        public AddressContainer(String _line1, String _line2, String _city,
                String _postcode, String _country) {
            this.line1 = new PairContainer("Line1", _line1);
            this.line2 = new PairContainer("Line2", _line2);
            this.city = new PairContainer("City", _city);
            this.postcode = new PairContainer("Postcode", _postcode);
            this.country = new PairContainer("Country", _country);

            setLayout(new GridLayout(5, 1, 0, 5));

            add(line1);
            add(line2);
            add(city);
            add(postcode);
            add(country);
        }

        public Address getValue() {
            Address address = new Address(line1.getValue(), line2.getValue(),
                    city.getValue(), postcode.getValue(), country.getValue());
            return address;
        }

        public void setValue(Address address) {
            line1.setValue(address.getLine1());
            line2.setValue(address.getLine2());
            city.setValue(address.getCity());
            postcode.setValue(address.getPostcode());
            country.setValue(address.getCountry());
        }

        public void setEditable(boolean b) {
            line1.setEditable(b);
            line2.setEditable(b);
            city.setEditable(b);
            postcode.setEditable(b);
            country.setEditable(b);
            revalidate();
        }
    }

    class PhoneContainer extends JPanel {

        private PairContainer landline, mobile;

        public PhoneContainer(Phone phone) {
            this(phone.getLandline(), phone.getMobile());
        }

        public PhoneContainer(String _landline, String _mobile) {
            this.landline = new PairContainer("Landline", _landline);
            this.mobile = new PairContainer("Mobile", _mobile);

            setLayout(new GridLayout(2, 1, 0, 5));

            add(landline);
            add(mobile);
        }

        public Phone getValue() {
            Phone phone = new Phone(landline.getValue(), mobile.getValue());
            return phone;
        }

        public void setValue(Phone phone) {
            landline.setValue(phone.getLandline());
            mobile.setValue(phone.getMobile());

        }

        public void setEditable(boolean b) {
            landline.setEditable(b);
            mobile.setEditable(b);
            revalidate();
        }
    }

    class PairContainer extends JPanel {

        private String label = "";
        private String value = "";
        private JTextField textfield;

        public PairContainer(String _label, String _value) {
            label = _label;
            value = _value;
            setLayout(new GridLayout(1, 2));
            add(new JLabel(label));
            add(textfield = new JTextField(value));
        }

        public void setEditable(boolean b) {
            textfield.setEditable(b);
            revalidate();
        }

        public void setValue(String _value) {
            textfield.setText(_value);
        }

        public String getValue() {
            return textfield.getText();
        }
    }
}
