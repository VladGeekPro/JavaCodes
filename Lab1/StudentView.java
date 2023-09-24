import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentView{ 
   
   public void printStudentDetailsInTable(String name, String rollNum) {
      class InfoTable{
         private JFrame frame;
         
         InfoTable(String name, String rollNum ) {   
         frame = new JFrame();
         frame.setTitle("Student Info");
         
         Object[] columnNames = {"Name", "Roll Number"};
         Object[][] tableData = { {name ,rollNum} };
         JTable studentInfoJTable = new JTable(tableData, columnNames);
         studentInfoJTable.setBounds(30, 40, 200, 300);

         JScrollPane scrollPane = new JScrollPane(studentInfoJTable);
         frame.add(scrollPane);
         frame.setSize(200, 250);
         //Added closer operation if user presses X, to close the frame
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         }
      }
   new InfoTable(name, rollNum);      
   }
   
}



// import javax.swing.JFrame;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;

// public class StudentView {
//    public void printStudentDetailsInTable(String studentName, String studentRollNo){
//       class InfoTable {
//          JFrame frame;

//          InfoTable(String studentName, String studentRollNo) {
//             frame = new JFrame();
//             frame.setTitle("Student Info");
//             Object[] columnNames = {"Name",
//                     "Roll Number"};
//             Object[][] tableData = {
//                     {studentName, studentRollNo}
//             };

//             JTable studentInfoTable = new JTable(tableData, columnNames);
//             studentInfoTable.setBounds(30, 40, 200, 300);


//             JScrollPane scrollPane = new JScrollPane(studentInfoTable);
//             frame.add(scrollPane);
//             frame.setSize(500, 200);
//             frame.setVisible(true);
//          }
//       }
//       new InfoTable(studentName, studentRollNo);
//    }
// }
