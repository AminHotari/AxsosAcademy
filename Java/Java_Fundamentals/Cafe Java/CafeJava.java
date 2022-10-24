public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 4;
        double lattePrice = 3;
        double cappuccinoPrice = 4.5;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1); // Welcome Cindhuri

        System.out.println(customer1 + pendingMessage); // Cindhuri order

        if (isReadyOrder4){
            System.out.println(generalGreeting + customer4 + readyMessage); //Noah order
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        else {
            System.out.println(generalGreeting + customer4 + pendingMessage);
        }

        System.out.println(generalGreeting + customer2 + displayTotalMessage + lattePrice * 2); //Sam order

        if (isReadyOrder2){
            System.out.println(generalGreeting + customer2 + readyMessage); // another required
        }
        else {
            System.out.println(generalGreeting + customer2 + pendingMessage);
        }

        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice)); // Jimmy 
    }

}