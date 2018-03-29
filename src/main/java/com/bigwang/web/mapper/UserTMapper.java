package com.bigwang.web.mapper;

import com.bigwang.web.model.UserT;
import com.bigwang.web.model.UserTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTMapper {
    /**
     * countByExample
     */
    int countByExample(UserTExample example);

    /**
     * deleteByExample
     */
    int deleteByExample(UserTExample example);

    /**
     * deleteByPrimaryKey
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert
     */
    int insert(UserT record);

    /**
     * insertSelective
     */
    int insertSelective(UserT record);

    /**
     * selectByExample
     */
    List<UserT> selectByExample(UserTExample example);

    /**
     * selectByPrimaryKey
     */
    UserT selectByPrimaryKey(Integer id);

    /**
     * updateByExampleSelective
     */
    int updateByExampleSelective(@Param("record") UserT record, @Param("example") UserTExample example);

    /**
     * updateByExample
     */
    int updateByExample(@Param("record") UserT record, @Param("example") UserTExample example);

    /**
     * updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(UserT record);

    /**
     * updateByPrimaryKey
     */
    int updateByPrimaryKey(UserT record);
}