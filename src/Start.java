import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        while(true)
        {
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to Update Student Details");
            System.out.println("Press 5 to Exit App");

            int choice=Integer.parseInt(br.readLine());

            if(choice==1)
            {
                //add student
                System.out.println("Enter Student Name:");
                String name=br.readLine();
                System.out.println("Enter Student Phone:");
                String phone = br.readLine();
                System.out.println("Enter Student City:");
                String city=br.readLine();

                //create student object to store student
                Student st=new Student(name,phone,city);
                System.out.println();
                boolean answer=StudentDao.insertStudentToDB(st);
                if(answer)
                {
                    System.out.println("Student is added Successfully...");
                }
                else
                {
                    System.out.println("Something went wrong try again....");
                }

                System.out.println(st);
            }
            else if(choice ==2)
            {
                //delete student
                System.out.println("Enter Student Id to Delete: ");
                int sId= Integer.parseInt(br.readLine());
                boolean answer = StudentDao.deleteStudent(sId);
                if(answer)
                {
                    System.out.println("Deleted Successfully...");
                }
                else
                {
                    System.out.println("Something went wrong try again....");
                }

            }
            else if(choice == 3)
            {
                //display student
                StudentDao.showAllStudents();
            }
            else if(choice==4)
            {
                //update
                System.out.println("Enter Student Id to Update: ");
                int sId= Integer.parseInt(br.readLine());
                System.out.println("Enter Student Name to Update: ");
                String sName= br.readLine();
                System.out.println("Enter Student Phone to Update: ");
                String sPhone= br.readLine();
                System.out.println("Enter Student City to Update: ");
                String sCity= br.readLine();

                boolean answer = StudentDao.updateStudent(sId,sName,sPhone,sCity);
                if(answer)
                {
                    System.out.println("Updated Successfully...");
                }
                else
                {
                    System.out.println("Something went wrong try again....");
                }
            }
            else if(choice==5)
            {
                //exit
                break;
            }
            else
            {
                //if nothing is encountered the loop will run continuously
            }
        }
        System.out.println("Thank You for using my application.....");
        System.out.println("See you soon....Bye Bye");
    }
}
