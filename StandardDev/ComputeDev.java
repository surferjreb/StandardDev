import java.util.Scanner;

public class ComputeDev {

    private Numbers myNumber[];
    private int index;


    ComputeDev(int index) {
        myNumber = new Numbers[index];
        this.index = index;

    }

    //Build array of numbers
    public void createNumArray() {

        Scanner input = new Scanner(System.in);
        double value = 0;


            System.out.println("Enter your numbers: ");

            for (int i = 0; i < index; i++) {

                value = input.nextDouble();
                myNumber[i].setNum(value);
                input.nextLine();
                 }

        }






    public void printArrayValues() {

        for (int x = 0; x < index; x++) {
            System.out.print(myNumber[x].getNum() + " ");
        }
    }

    public void arrangeNumbers() {
        double temp = 0;

        for (int i = 0; i < index; i++) {

            for (int j = 0; j < index; j++) {
                if (myNumber[i].getNum() < myNumber[j].getNum()) {
                    temp = myNumber[i].getNum();
                    myNumber[i].setNum(myNumber[j].getNum());
                    myNumber[j].setNum(temp);

                }

            }

        }
    }

    public double calculateMean() {
        double temp = 0;

        for (int i = 0; i < index; i++) {
            temp += myNumber[i].getNum();

        }

        temp = temp / index;

        return temp;

    }

    public double calMedian() {
        double temp;
        double myIndex = (double) index;
        double tempA;
        double tempB;

        int mean;

        arrangeNumbers();

        if (index % 2 > 0) {
            temp = myIndex / 2;
            temp += .5;
            mean = (int) temp;

            return myNumber[mean].getNum();

        } else if (index % 2 == 0) {
            temp = (myIndex / 2);
            tempA = myNumber[(int) temp].getNum();
            temp++;
            tempB = myNumber[(int) temp].getNum();

            tempB = tempA + tempB;

            tempB = tempB / 2;

            return tempB;

        }

        return -1;
    }

    //write function to get mode
    public double calcMode() {

        double[] temp;


        temp = new double[(myNumber.length)];
        //index2 = (int) ((((double) index) / 2) + .5);
        // index3 = index2;

        for (int i = 0; i < index; i++) {

            for (int j = 0; j < index; j++) {
                if (myNumber[i].getNum() == myNumber[j].getNum()) {
                    temp[i] += 1;
                }

            }

        }
        sortArray(temp);

        return getModeValue(temp);
       // return 0;
    }


    public double standardDeviation() {
        double temp;
        double someOfSquares = 0;
        double temp3 = 0;
        double[] temp2 = new double[index];


        temp = calculateMean();
        //Subtracts the mean from each value.
        for (int i = 0; i < index; i++) {
            temp2[i] = myNumber[i].getNum() - temp;
        }
        //Squares each of the values
        for (int a = 0; a < temp2.length; a++) {
            temp2[a] = Math.pow(temp2[a], 2);
        }
        //Sums the values
        for (int b = 0; b < temp2.length; b++) {
            someOfSquares += temp2[b];
        }

        temp3 = someOfSquares / temp2.length;

        temp3 = Math.sqrt(temp3);

        return temp3;

    }

    private double getModeValue(double[] temp){
        double temp2;
        for (int i = 0; i < temp.length; i++) {

            for (int j = (index-1); j > 0; j--) {

                if (temp[i] >= temp[j]) {
                    temp2 = temp[i];
                    if(temp2 >= temp[(temp.length - 1)]) {
                        return myNumber[i].getNum();
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

}
