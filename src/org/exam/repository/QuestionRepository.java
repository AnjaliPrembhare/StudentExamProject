package org.exam.repository;
import org.exam.model.QuestionModel;
public class QuestionRepository extends DBconfig{
	private int questionId;
	private int getQuestionId()
	{
		try {
			stmt=conn.prepareStatement("select max(Qid)from question");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				questionId=rs.getInt(1);
			}
			++questionId;
		}
		catch(Exception ex)
		{
			System.out.println("error is"+ex);
			return 0;
		}
		return questionId;
	}
	public int getSubjectIdByName(String name)
	{
		try {
			stmt=conn.prepareStatement("select sid from subject where subjectName =?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is"+ex);
			return 0;
		}
	}
	public boolean isAddQuestion(QuestionModel qModel,String subName)
	{
		try {
		int Qid=this.getQuestionId();
			if(Qid!=0) {
			stmt=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
			stmt.setInt(1,Qid);
			stmt.setString(2, qModel.getQuestion());
			stmt.setString(3, qModel.getOp1());
			stmt.setString(4, qModel.getOp2());
			stmt.setString(5, qModel.getOp3());
			stmt.setString(6, qModel.getOp4());
			stmt.setInt(7, qModel.getAns());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				int Sid=this.getSubjectIdByName(subName);
				if(Sid!=-1 ) {
					stmt=conn.prepareStatement("insert into subjectquestionjoin values(?,?)");
					stmt.setInt(1, Qid);
					stmt.setInt(2, Sid);
					return stmt.executeUpdate()>0?true:false;
				}
			else if(Sid==-1){
				System.out.println("subject  not found");
				return false;
			}
			else {
				System.out.println("some problem is there");
				return false;
			}
			}
			
		}
			else {
				return false;
			}
			}
		catch(Exception ex)
		{
			return false;
		}
		return true;
	}
	public boolean uploadBulkQuestion(String question[],String subName) {
		try {
		int Qid=this.getQuestionId();
			if(Qid!=0) {
			stmt=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
			stmt.setInt(1, Qid);
			stmt.setString(2,question[0]);
			stmt.setString(3, question[1]);
			stmt.setString(4, question[2]);
			stmt.setString(5, question[3]);
			stmt.setString(6, question[4]);
			stmt.setInt(7, Integer.parseInt(question[5].trim()));
			int value=stmt.executeUpdate();
			if(value>0)
			{
				int Sid=this.getSubjectIdByName(subName);
				if(Sid!=-1 ) {
					stmt=conn.prepareStatement("insert into subjectquestionjoin values(?,?)");
					stmt.setInt(1, Qid);
					stmt.setInt(2, Sid);
					return stmt.executeUpdate()>0?true:false;
				}
			else if(Sid==-1){
				System.out.println("subject  not found");
				return false;
			}
			else {
				System.out.println("some problem is there");
				return false;
			}
			}
			else {
				return false;
			}
		}
			else {
				return true;
			}
			}
		catch(Exception ex)
		{
			return false;
		}
	
	}
}