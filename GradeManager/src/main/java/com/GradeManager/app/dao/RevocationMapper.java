package com.GradeManager.app.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.GradeManager.app.bean.Revocation;

@Repository
@Mapper

public interface RevocationMapper {
List<Revocation> getRevocation();
List<Revocation> getRevocation1();
Revocation getRevocationReason(int  revocationId);
int getCount();
int getCount1();
int  updateRevocation(@Param("revocationId")int revocationId,@Param("revocationReply")String revocationReply);
}
