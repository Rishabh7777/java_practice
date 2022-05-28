package mobile_phone;

public class Main {
    public static void main(String[] args) {
        MobilePhone obj = new MobilePhone();
        System.out.println(obj.addNewContact(new Contact("oliver", "778899")));
        System.out.println(obj.addNewContact(new Contact("oliver", "778899")));
    }
}
