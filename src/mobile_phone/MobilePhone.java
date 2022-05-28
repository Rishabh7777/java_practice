package mobile_phone;

import java.util.ArrayList;

public class MobilePhone {
    private final ArrayList<Contact> myContacts;

    public MobilePhone() {
        myContacts = new ArrayList<>();
    }

    private int findContact(Contact contact) {
        String name = contact.getName();
        for(int i=0; i<myContacts.size(); i++) {
            if(myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String name) {
        for(int i=0; i<myContacts.size(); i++) {
            if(myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact previous, Contact now) {
        if(findContact(previous) == -1) {
            return false;
        }
        int index = findContact(previous);
        myContacts.add(index, now);
        myContacts.remove(index+1);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if(findContact(contact) == -1) {
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    public Contact queryContact(String name) {
        for(Contact i: myContacts) {
            if(i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i=0; i<myContacts.size(); i++) {
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> "
                    + myContacts.get(i).getPhoneNumber());
        }
    }
}