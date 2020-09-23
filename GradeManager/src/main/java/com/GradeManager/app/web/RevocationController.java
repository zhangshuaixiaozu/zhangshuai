package com.GradeManager.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GradeManager.app.bean.Revocation;
import com.GradeManager.app.service.RevocationService;



@RestController
public class RevocationController {
	@Autowired
	private RevocationService rev;
	@RequestMapping("revocation/getRevocation")
	public List<Revocation> getRevocation()
	{
		return rev.getRevocation();
	}
	@RequestMapping("revocation/getRevocation1")
	public List<Revocation> getRevocation1()
	{
		return rev.getRevocation1();
	}

	@RequestMapping("revocation/getCount")
	public int getCount()
	{
		return rev.getCount();
	}
	
	@RequestMapping("revocation/getCount1")
	public int getCount1()
	{
		return rev.getCount1();
	}
	
	@RequestMapping("revocation/getRevocationReason")
	public Revocation getRevocationReason(int revocationId)
	{
		return rev.getRevocationReason(revocationId);
	}
	
	@RequestMapping("revocation/updateRevocation")
	public boolean  updateRevocation(int revocationId,String revocationReply){
		return  rev.updateRevocation(revocationId, revocationReply);
	}
}
