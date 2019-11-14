package cn.springmvc.dao;

import cn.springmvc.model.TestResultDetail;
import cn.springmvc.model.TestResultDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestResultDetailMapper {
    long countByExample(TestResultDetailCriteria example);

    int deleteByExample(TestResultDetailCriteria example);

    int deleteByPrimaryKey(String resultDetailId);

    int insert(TestResultDetail record);

    int insertSelective(TestResultDetail record);

    List<TestResultDetail> selectByExample(TestResultDetailCriteria example);

    TestResultDetail selectByPrimaryKey(String resultDetailId);

    int updateByExampleSelective(@Param("record") TestResultDetail record, @Param("example") TestResultDetailCriteria example);

    int updateByExample(@Param("record") TestResultDetail record, @Param("example") TestResultDetailCriteria example);

    int updateByPrimaryKeySelective(TestResultDetail record);

    int updateByPrimaryKey(TestResultDetail record);
    
    void batchInsert(List<TestResultDetail> list);
    
}