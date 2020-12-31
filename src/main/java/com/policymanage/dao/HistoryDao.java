package com.policymanage.dao;

import com.policymanage.activiti.entity.History;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao {
    @Select("select * from act_hi_actinst")
    public List<History> findAll();

    @Select("select * from act_hi_actinst where ASSIGNEE_ = #{ASSIGNEE_}")
    public List<History> findByName(String ASSIGNEE_);
}
