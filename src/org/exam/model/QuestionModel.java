package org.exam.model;
public class QuestionModel 
{
	private int id;
	private String question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private int ans;
	public QuestionModel() {
		
	}
	public QuestionModel(String question,String op1,String op2,String op3,String op4,int ans)
	{
		this.question=question;
		this.op1=op1;
		this.op2=op2;
		this.op3=op3;
		this.op4=op4;
		this.ans=ans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	
	
	
}
