 import java.util.Scanner;

public class ComputeDev {

    private Numbers myNum;
    private int index;


    ComputeDev(int index) {
        myNum = new Numbers(index);
        this.index = index;

    }

    //get array of numbers
    void createNumArray(double[] userNumbers) {

        myNum.setNum(userNumbers);               

        }

    public void arrangeNumbers() {
        double temp = 0;
        double[] userNums = myNum.getAllNums();
        
        for (int i = 0; i < index; i++) {

            for (int j = 0; j < index; j++) {
                if (userNums[i] < userNums[j]) {
                    temp = userNums[i];
                    userNums[i] = userNums[j];
                    userNums[j] = temp;

                }

            }

        }
        
        myNum.setNum(userNums);
    }//end arrangeNumbers

    double calculateMean() {
        double sum = 0;
        double mean = 0;

        
        for (int i = 0; i < index; i++) {
            sum += myNum.getNum(i);

        }

        mean = sum / index;

        return mean;

    }

    public double calMedian() {
        double temp;
        Double temp2;
        Double myIndex = new Double(index);
        double tempA;
        double tempB;

        int median;
        int medianIndex;

        arrangeNumbers();

        if (index % 2 > 0) {
            temp = myIndex / 2;
            temp += .5;
            temp2 = new Double(temp);
            median = temp2.intValue();

            return myNum.getNum(median);

        } else if (index % 2 == 0) {
            temp2 = myIndex/2; 
            medianIndex = temp2.intValue();
            tempA = myNum.getNum(medianIndex);
            medianIndex++;
            
            tempB = myNum.getNum(medianIndex);

            tempB = tempA + tempB;

            tempB = tempB / 2;

            return tempB;

        }

        return -1;
    }

    //write function to get mode
    public double calcMode() {

        double[] temp;
        temp = new double[index];

        for (int i = 0; i < index; i++) {

            for (int j = 0; j < index; j++) {
                if (myNum.getNum(i) == myNum.getNum(j)) {
                    temp[i] += 1;
                }//end if
            }//end for

        }//end for
        
        temp = sortArray(temp);

        return getModeValue(temp);
       // return 0;
    }


    public double standardDeviation() {
        double mean;
        double someOfSquares = 0;
        double square = 0;
        double quotient = 0;
        double[] temp2 = new double[index];
        Double myIndex = new Double(index);
        double stdDeviation = 0;

        mean = calculateMean();
        //Subtracts the mean and gets squares.
        for (int i = 0; i < index; i++) {
            square = (myNum.getNum(i) - mean)*(myNum.getNum(i) - mean);
            temp2[i] = square;
        }
        
        //Sums the Squares
        for (int b = 0; b < temp2.length; b++) {
            someOfSquares += temp2[b];
        }

        quotient = someOfSquares / myIndex;

        stdDeviation = Math.sqrt(quotient);

        return stdDeviation;

    }

    private double getModeValue(double[] temp){
        double temp2;
        for (int i = 0; i < temp.length; i++) {

            for (int j = (index-1); j > 0; j--) {

                if (temp[i] >= temp[j]) {
                    temp2 = temp[i];
                    if(temp2 >= temp[(temp.length - 1)]) {
                        return myNum.getNum(i);
                    }
                }

            }

        } 
        return -1;
    }

    private double[] sortArray(double[] temp){
        double temp3;
        
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (temp[i] < temp[j]) {
                    temp3 = temp[i];
                    temp[i] = temp[j];
                    temp[j] = temp3;
                }
            }
        }
        return temp;
    }
//----------------------------------------------------
   void printArrayValues(){
      
      for(double value: myNum.getAllNums()){
         System.out.print(value+", ");
      }
      
      System.out.println();
   }
}//end class
