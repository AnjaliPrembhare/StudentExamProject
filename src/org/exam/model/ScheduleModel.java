package org.exam.model;
import java.util.Date;
public class ScheduleModel 
{
    private int schId;
    private int examId;
    private Date examDate;
	private String startTime, endTime;
	
	public ScheduleModel(){
		
	}
    public ScheduleModel(Date examDate,String startTime,String endTime,int examId)
    {
    	this.examDate=examDate;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.examId=examId;
    }
	public int getSchId() {
		return schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
