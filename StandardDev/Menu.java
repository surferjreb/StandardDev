import java.util.*;

public class Menu {
    private int MAX_MENU = 7;
    protected ComputeDev compute;

    public void printMenu(){
        Scanner input = new Scanner(System.in);
        int selection;
        boolean quit = false;

        while(!quit) {

                System.out.println("Pick your choice from the menu: ");
                System.out.println("0 to Enter your numbers: ");
                System.out.println("1 to print List of numbers.");
                System.out.println("2 to Find Mean.");
                System.out.println("3 to Find Median.");
                System.out.println("4 to Find Mode.");
                System.out.println("5 to Find all three.");
                System.out.println("6 to Find Standard Deviation.");
                System.out.println("7 to quit.");
                System.out.println("Enter your selection: ");

                selection = input.nextInt();

                if (selection <= MAX_MENU) {
                   quit = menuSelection(selection);
                }
                else{
                    System.out.println("Error: Use 0 - 7 to select a menu item.");

                }

        }


}

    private boolean menuSelection(int input){
        Scanner userInput = new Scanner(System.in);
        boolean quit = false;


        switch(input){
            case 0:
                int amount;
                System.out.println("Enter the amount of numbers to be entered: ");
                amount = userInput.nextInt();
                compute = new ComputeDev(amount);
                compute.createNumArray();
                break;

            case 1:
                compute.printArrayValues();
                break;

            case 2:
                compute.calculateMean();
                break;

            case 3:
                compute.calMedian();
                break;

            case 4:
                compute.calcMode();
                break;

            case 5:
                compute.calculateMean();
                compute.calMedian();
                compute.calcMode();
                break;

            case 6:
                compute.standardDeviation();
                break;

            case 7:
                quit = true;
                return quit;


        }

        return quit;
    }
}
