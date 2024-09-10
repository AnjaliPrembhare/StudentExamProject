package org.exam.service;
import org.exam.model.SubjectModel;
import java.util.*;
import org.exam.repository.SubjectRepository;
public class SubjectService 
{
	SubjectRepository subRepo=new SubjectRepository();
	public int addSubject(SubjectModel model)
	{
		return (subRepo.isSubjectPresent(model.getName()))?-1:subRepo.isAddSubject(model)?1:0;
	}
	public List<String> getAllSubject()
	{
		return this.subRepo.getAllSubject();
	}
}
