package com.GradeManager.app.service;
import java.util.List;
import com.GradeManager.app.bean.Revocation;
public interface RevocationService {
	List<Revocation> getRevocation();
	List<Revocation> getRevocation1();
	int getCount();
	int getCount1();
	Revocation getRevocationReason(int  revocationId);
	boolean  updateRevocation(int revocationId,String revocationReply);
}