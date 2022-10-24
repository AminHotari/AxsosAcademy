public class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();

        String testBasicGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String testAlexis = alfredBot.respondBeforeAlexis("Alexis! Play some low-fi beats.");
        String testAlfred = alfredBot.respondBeforeAlexis("I can't find my yo-yo.Maybe Alfred will know where it is.");
        String testNoRelevant = alfredBot.respondBeforeAlexis("Maybe that's what Batman is about. Not winning. But failing.");
        String testGuestGreeting1 = alfredBot.guestGreeting("Beth Kane" , "Morning");

        System.out.println(testBasicGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(testAlexis);
        System.out.println(testAlfred);
        System.out.println(testNoRelevant);
        System.out.println(testGuestGreeting1);
    }
}