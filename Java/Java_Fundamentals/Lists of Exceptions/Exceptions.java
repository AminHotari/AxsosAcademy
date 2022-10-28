import java.util.ArrayList;

public class Exceptions {
    public void exceptions(){
        ArrayList<Object> list = new ArrayList<Object>();       
        list.add("13");
        list.add("hello world");
        list.add(48);
        list.add("Goodbye World");

        for(int i = 0; i < list.size(); i++) {
            try {
                Integer castedValue = (Integer) list.get(i);
            } 
            catch(Exception e ) {
                System.out.println("Wrong");
            }
        }
    }

}



