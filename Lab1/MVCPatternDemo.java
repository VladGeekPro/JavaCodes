public class MVCPatternDemo{
   public static void main(String[] args) {
      Student model = new Student("Vlad", "10");

      StudentView view = new StudentView(); 

      StudentController controller = new StudentController(model, view);

      controller.updateView();

      //Update name
      StudentController controller2 = new StudentController(new Student("Vlad ^__^", model.getRollNum()), view); 

      controller2.updateView();


      
      
   }
}



























// public class MVCPatternDemo {
//    public static void main(String[] args) {

//       //fetch student record based on his roll no from the database
//       Student model  = retrieveStudentFromDatabase();

//       //Create a view : to write student details
//       StudentView view = new StudentView();

//       StudentController controller = new StudentController(model, view);

//       controller.updateView();

//       //update model data
//       controller.setStudentName("John");

//       controller.updateView();
//    }



//    private static Student retrieveStudentFromDatabase(){
//       Student student = new Student();
//       student.setName("Robert");
//       student.setRollNo("10");
//       return student;
//    }
// }
