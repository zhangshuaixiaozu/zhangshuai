package com.GradeManager.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Revocation;

import com.GradeManager.app.dao.RevocationMapper;
import com.GradeManager.app.service.RevocationService;
@Service
@Transactional
public class RevocationServiceImpl implements RevocationService {

	@Autowired
	private RevocationMapper rev;
	@Override
	public List<Revocation> getRevocation() {
		// TODO Auto-generated method stub	
		return rev.getRevocation();
	}
	@Override
	public List<Revocation> getRevocation1() {
		// TODO Auto-generated method stub
		return rev.getRevocation1();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return rev.getCount();
	}
	@Override
	public int getCount1() {
		// TODO Auto-generated method stub
		return rev.getCount1();
	}
	@Override
	public Revocation getRevocationReason(int revocationId) {
		// TODO Auto-generated method stub
		return rev.getRevocationReason(revocationId);
	}
	@Override
	public boolean updateRevocation(int revocationId, String revocationReply) {
		// TODO Auto-generated method stub
		return rev.updateRevocation(revocationId, revocationReply)>0;
	}

}
