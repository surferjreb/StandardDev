public class Numbers {

    private double[] num;
    private int maxIndex;

    public Numbers(int index) {
        this.maxIndex = index;
        this.num = new double[maxIndex];
    }

    double getNum(int index) {
        return num[index];
    }
    
    double[] getAllNums(){
      return num;
    }

    void setNum(double[] num) {
        this.num = num;
    }
    
    int getMaxIndex(){
         return maxIndex;
    }
    
    public static void main(String[] args){
      
      
      double[] userInput = {20, 10, 5, 15};
      
      Numbers myNums = new Numbers(userInput.length);
      
      myNums.setNum(userInput);
      
      for(int i = 0; i < myNums.getMaxIndex(); i++){
         System.out.println(i+": "+ myNums.getNum(i));
      }
      
    }
}//end class
