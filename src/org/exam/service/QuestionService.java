package org.exam.service;
import org.exam.helper.PathHelper;
import org.exam.model.QuestionModel;
import java.io.*;
import java.util.*;
import org.exam.repository.QuestionRepository;
public class QuestionService 
{
	QuestionRepository qRepo=new QuestionRepository();
	SubjectService ss=new SubjectService();
	public boolean isAddQuestion(QuestionModel qModel,String subName)
	{
		return qRepo.isAddQuestion(qModel,subName);
	}
	public boolean createFiles()
	{
		try
		{
			String path="C:\\java project\\Question Bank";
			File f=new File(path);
			if(!f.exists())
			{
				f.mkdir();
			}
			List<String> subList=ss.getAllSubject();
			if(subList!=null)
			{
				for(String subName:subList)
				{
					f=new File(path+"\\"+subName+".csv");
					if(!f.exists())
					{
						f.createNewFile();
					}	
				}
			}
			else
			{
				System.out.println("Subject not found");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return true;
	}
	
	public boolean uploadBulkQuestion(String subName)
	{
		boolean b=this.createFiles();
		if(b)
		{
			File f=new File("C:\\java project\\Question Bank");
			File []fileList=f.listFiles();
			boolean flag=false;
			for(File file:fileList)
			{
				if(file.isFile())
				{
					int index=file.toString().indexOf(subName);
					if(index!=-1)
					{
						flag=true;
						break;
					}
				}
			}
			if(flag)
			{
				try
				{
					FileReader fr=new FileReader(PathHelper.filepath+"\\"+subName+".csv");
					BufferedReader br=new BufferedReader(fr);
					String question;
					flag=false;
					while((question=br.readLine())!=null)
					{
						String qwithop[]=question.split(",");
						flag=qRepo.uploadBulkQuestion(qwithop,subName);
					}
				}
				catch(Exception e)
				{
					System.out.println("error is"+e);
				}
			}
			else
			{
				System.out.println("\nSubject file not found");
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}
