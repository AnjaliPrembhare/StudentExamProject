package org.exam.repository;
import org.exam.model.SubjectModel;
import java.util.*;
public class SubjectRepository extends DBconfig
{
	List<String> list=new ArrayList<String>();
	public boolean isAddSubject(SubjectModel model)
	{
		try
		{
			stmt=conn.prepareStatement("insert into subject values('0',?)");
			stmt.setString(1, model.getName());
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
	public boolean isSubjectPresent(String subName)
	{
		try
		{
			stmt=conn.prepareStatement("Select * from subject where Subjectname=?");
			stmt.setString(1, subName);
			rs=stmt.executeQuery();
			return rs.next();
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public List<String> getAllSubject()
	{
		try
		{
			stmt=conn.prepareStatement("select Subjectname from Subject");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString("subjectname"));
			}
			return list.size()>0?list:null;
	    }
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
		
	}
}
