package org.exam.client;
import java.util.*;
import org.exam.model.ExamModel;
import org.exam.model.QuestionModel;
import org.exam.model.ScheduleModel;
import org.exam.model.SubjectModel;
import org.exam.service.ExamService;
import org.exam.service.QuestionService;
import org.exam.service.SubjectService;
public class ExamClientApp {
	public static void main(String[] args) {
		SubjectService sv=new SubjectService();
		QuestionService qService=new QuestionService();
		ExamService examService=new ExamService();
		do
		{
			System.out.println("1:Add New Subject");
			System.out.println("2:Add Single Question");
			System.out.println("3:Add Bulk Question");
			System.out.println("4:Add Exam");
			System.out.println("5:Create Exam Schedule");
			System.out.println("Enter your choice");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice)
			{
			    case 1:
			    	sc.nextLine();
			    	System.out.println("Enter the subject name");
			    	String subName=sc.nextLine();
			    	SubjectModel model=new SubjectModel();
			    	model.setName(subName);
			    	int result=sv.addSubject(model);
			    	if(result==1)
			    	{
			    		System.out.println("Subject Added Successfully...............");
			    	}
			    	else if(result==-1)
			    	{
			    		System.out.println("Subject is already present\n");
			    	}
			    	else
			    	{
			    		System.out.println("Some Problem is there..................");
			    	}
			    	break;
			   case 2:
			    	sc.nextLine();
			    	System.out.println("Enter the question");
			    	String question=sc.nextLine();
			    	System.out.println("Enter the first option");
			    	String op1=sc.nextLine();
			    	System.out.println("Enter the second option");
			    	String op2=sc.nextLine();
			    	System.out.println("Enter the third option");
			    	String op3=sc.nextLine();
			    	System.out.println("Enter the fourth option");
			    	String op4=sc.nextLine();
			    	System.out.println("Enter the option as answer");
			    	int ans=sc.nextInt();
			    	sc.nextLine();
			    	System.out.println("Enter the subject name");
			    	subName=sc.nextLine();
			    	QuestionModel qModel=new QuestionModel(question,op1,op2,op3,op4,ans);
			    	boolean b=qService.isAddQuestion(qModel,subName);
			    	if(b)
			    	{
			    		System.out.println("Question added successsfully.............");
			    	}
			    	else	
			    	{
			    		System.out.println("Some problem is there................");
			    	}
			    	break;
			  case 3:
				   sc.nextLine();
				   System.out.println("Enter subject name for store bulk question");
				   String subname=sc.nextLine();
				   qService.uploadBulkQuestion(subname);   
				   break;
			  case 4:
				   sc.nextLine();
				   System.out.println("Enter exam name,total marks and passing marks");
				   String examName=sc.nextLine();
				   int totalMarks=sc.nextInt();
				   int passMarks=sc.nextInt();
				   ExamModel examModel=new ExamModel(examName,totalMarks,passMarks);
				   result=examService.isAddExam(examModel);
				   String str=(result==1)?("Exam Added Successfully............"):(result==-1)?("Exam Already present"):("\nExam not added...");
				   System.out.println(str);
				   break;
			    case 5:
			       sc.nextLine();
			       List<ExamModel> list=examService.getAllExams();
			       System.out.println("Hey user you have list of exams and select one for schedule");
			       System.out.println("=================================================================");
			       for(ExamModel m:list)
			       {
			    	  System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getTotalMarks()+"\t"+m.getPassingMarks());
			       }
			       System.out.println("=================================================================");
			       System.out.println("Enter exam name for schedule");
			       examName=sc.nextLine();
			       ExamModel emodel=examService.getExamIdByName(examName);
			       if(emodel!=null)
			       {
			    	   System.out.println("Enter exam date,starttime and endtime");
			    	   String dateFormate=sc.nextLine();
			    	   Date d1=new Date(dateFormate);
			    	   String startTime=sc.nextLine();
			    	   String endTime=sc.nextLine();
			    	   ScheduleModel smodel=new ScheduleModel();
			    	   smodel.setExamDate(d1);
			    	   smodel.setStartTime(startTime);
			    	   smodel.setEndTime(endTime);
			    	   smodel.setExamId(emodel.getId());
			    	   emodel.setScheduleModel(smodel);
			    	   System.out.println("Enter subject name for exam");
			    	   subName=sc.nextLine();
			    	   b=examService.isSetSchedule(emodel,subName);
			    	   if(b)
			    	   {
			    		   System.out.println("Exam Schedule Successfully................");
			    	   }
			    	   else
			    	   {
			    		   System.out.println("Exam Not Schedule");
			    	   }
			       }
			       else
			       {
			    	   System.out.println("Enter correct exam name");
			       }
				   break;
			    default:
			    	System.out.println("Wrong choice");
			    	break;
			}
			
		}
		while(true);
	}

}
