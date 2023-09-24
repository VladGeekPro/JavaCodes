public class StudentController {
   private Student model;
   private StudentView view;


   public StudentController(Student model, StudentView view){
      this.model = model;
      this.view = view;
   }

   // We can delete setters and getters because they are already present in objects that we created, such as Student and StudenView

   public void updateView(){				
      view.printStudentDetailsInTable(model.getName(), model.getRollNum());
   }	
}