package org.exam.service;
import java.util.*;

import org.exam.model.ExamModel;
import org.exam.model.ScheduleModel;
import org.exam.repository.ExamRepository;
public class ExamService 
{
	ExamRepository examRepo=new ExamRepository();
	public int isAddExam(ExamModel model)
	{
		return (examRepo.isExamPresent(model.getName()))?-1:(examRepo.isAddExam(model))?1:0;
	}
	public List<ExamModel> getAllExams()
	{
		return examRepo.getAllExams();
	}
	public ExamModel getExamIdByName(String name)
	{
		return examRepo.getExamIdByName(name);
	}
	public boolean isSetSchedule(ExamModel model,String subName)
	{
		Date d=new Date();
		String []s=d.toLocaleString().split(",");
		String dsplit[]=s[0].split("-");
		ScheduleModel smodel=model.getScheduleModel();
		Date userDate=smodel.getExamDate();
		String userDateArr[]=userDate.toLocaleString().split(",");
		String userDates[]=userDateArr[0].split("-");
		if(Integer.parseInt(userDates[2])>=Integer.parseInt(dsplit[2])&& userDates[1].equals(dsplit[1]))
		{
			if(Integer.parseInt(userDates[0])>=Integer.parseInt(dsplit[0]))
			{
				System.out.println("You can schedule exam");
				//boolean b=examRepo.isSetSchedule(model);
				//return b?true:false;
				return examRepo.isSetSchedule(model,subName)?true:false;
			}
			else
			{
				System.out.println("You may be insert date before system");
			}
		}
		else
		{
			System.out.println("You may be insert previous year or may be previous month");
		}
		//System.out.println(s[0]);
		//System.out.println(d.toLocaleString());
		return false;
	}
}
