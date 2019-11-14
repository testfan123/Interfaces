package cn.springmvc.dao;

import cn.springmvc.model.TParmeters;
import cn.springmvc.model.TParmetersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TParmetersMapper {
    long countByExample(TParmetersCriteria example);

    int deleteByExample(TParmetersCriteria example);

    int deleteByPrimaryKey(String uid);

    int insert(TParmeters record);

    int insertSelective(TParmeters record);

    List<TParmeters> selectByExample(TParmetersCriteria example);

    TParmeters selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") TParmeters record, @Param("example") TParmetersCriteria example);

    int updateByExample(@Param("record") TParmeters record, @Param("example") TParmetersCriteria example);

    int updateByPrimaryKeySelective(TParmeters record);

    int updateByPrimaryKey(TParmeters record);
}