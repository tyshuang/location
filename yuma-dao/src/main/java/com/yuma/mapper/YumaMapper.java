package com.yuma.mapper;

import com.yuma.pojo.Yuma;
import com.yuma.pojo.YumaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YumaMapper {
    int countByExample(YumaExample example);

    int deleteByExample(YumaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Yuma record);

    int insertSelective(Yuma record);

    List<Yuma> selectByExample(YumaExample example);

    Yuma selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Yuma record, @Param("example") YumaExample example);

    int updateByExample(@Param("record") Yuma record, @Param("example") YumaExample example);

    int updateByPrimaryKeySelective(Yuma record);

    int updateByPrimaryKey(Yuma record);
}