

public class Student {
   //I added final to make fields safer and ensure that once values are set, they will not be changed 
   private final String name;
   private final String rollNum;
   
   //Instead of setters, I added constructor initialization. It makes the class more self-contained and immutable
   public Student( String name, String rollNum){
      this.name = name;
      this.rollNum = rollNum;
   }

   public String getRollNum() {
      return rollNum;
   } 
    
   public String getName() {
      return name;
   }
   
   
}
