import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. Isn't it nice out today?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello,%s.Lovely to saa you", name);
        
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "it is currently " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1) {
            return ("Right away, sir. She certainly isn't sophisticated enough for that."); // if(conversation.contain("Alexis"))
        }
        else if(conversation.indexOf("Alfred") > -1) {
            return ("At your service. As you wish, naturally.");
        }
        else {
            return ("Right.And with that I shall retire");
        }
    }

    public String guestGreeting(String name, String dayPeriod) {
        return "Good " + dayPeriod + "," + name +  ".Lovely to see you.";
    }
}