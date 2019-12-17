import java.util.*;

public class Menu {
    private int MAX_MENU = 7;
    protected ComputeDev compute;

    public void printMenu(){
        Scanner input = new Scanner(System.in);
        String selection;
        boolean quit = false;
        
         try{
         
             System.out.println("Enter your numbers to be entered: \nPlease seperate with a space\n"+
                                    "i.e.: \"20 25 10 5\"");
             System.out.print("Enter Numbers: ");
             temp = userInput.nextLine();
             userNums = parseUserInput(temp);  
             numberAmount = userNums.length;
                
             compute = new ComputeDev(numberAmount);
             compute.createNumArray(userNums);
                

            while(!quit) {

                displayMenu();

                selection = input.nextLine();

                if (!checkQuit(selection)) {
                     if(checkInput(selection)){
                        menuSelection(selection);
                     }
                   
                  }
                  else{
                     quit = true;
                  }
                

            }//end while

         }//end try
         catch(Exception e){
            e.printStackTrace();
         }
}

    private boolean menuSelection(String selection){
        Scanner userInput = new Scanner(System.in);
        boolean quit = false;
        int numberAmount = 0;
        String temp;  
        double[] userNums;
        int input = Integer.parseInt(selection);
        
        switch(input){
            
            case 1:
                compute.printArrayValues();
                break;

            case 2:
                System.out.print("***Mean: ");
                System.out.print(compute.calculateMean()+"\n\n\n");
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
    }//end method
//--------------------------------------------------
   private void displayMenu(){
      
      System.out.println("***Pick your choice from the menu: ***");
        System.out.println("--------------------------------------");
          System.out.println();
          System.out.println("\t1 to print List of numbers.");
          System.out.println("\t2 to Find Mean.");
          System.out.println("\t3 to Find Median.");
          System.out.println("\t4 to Find Mode.");
          System.out.println("\t5 to Find all three.");
          System.out.println("\t6 to Find Standard Deviation.");
          System.out.println("\t7 to quit.\n");
          
          System.out.println("\t\tEnter your selection: ");
   } 
//--------------------------------------------------

   private boolean checkInput(String selection) throws InputMismatchException {
      
      try{
      
         int temp = Integer.parseInt(selection);
         
         if(temp >= 1 && temp <= 7)
            return true;
            
         }
         catch(Exception e){
            throw new InputMismatchException("Error: Please, select 1 thru 7..");
         }
         
         return false; 
   }   
//--------------------------------------------------
   private boolean checkQuit(String selection){
      
         selection = selection.toLowerCase();
         
         if(selection.equals("quit"))
            return true;
       
         return false;
   }
//--------------------------------------------------
   private double[] parseUserInput(String input){
      
      int index = input.length();
      String[] temp = new String[index];
      double[] userNumbers;
       
      temp = input.split(" ");
      userNumbers = new double[temp.length];
      
      for(int i = 0; i < temp.length; i++){
         userNumbers[i] = Double.valueOf(temp[i]);
      }
      
      return userNumbers;
      
         
   }         
//--------------------------------------------------
   public static void main(String[] args){
   
   
   }    
    
}//end class
