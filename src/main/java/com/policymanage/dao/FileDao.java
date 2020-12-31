package com.policymanage.dao;

import com.policymanage.entity.File;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FileDao {
    /*查询所有*/
    @Select("select * from file")
    @Results(id = "fileMap", value = {
            @Result(column = "f_id", property = "fileId"),
            @Result(column = "f_dutyofficer", property = "fileDutyofficer"),
            @Result(column = "f_response", property = "fileResponse"),
            @Result(column = "f_title", property = "fileTitle"),
            @Result(column = "f_time", property = "fileTime"),
            @Result(column = "f_path", property = "filePath")
    })
    public List<File> findAll();

    /*添加档案信息*/
    @Insert("insert into file(f_id, f_dutyofficer, f_response, f_title, f_time) values(#{fileId}, #{fileDutyofficer}, #{fileResponse}, #{fileTitle}, #{fileTime})")
    @ResultMap(value = "fileMap")
    public void insertFile(File file);

    /*根据ID查询*/
    @Select("select * from file where f_id = #{fileId}")
    @ResultMap(value = "fileMap")
    public File findById(Integer fileId);

    /*更新*/
    @Update("update file set f_dutyofficer = #{fileDutyofficer}, f_response = #{fileResponse}, f_title = #{fileTitle}, f_time = #{fileTime}, f_path = #{filePath} where f_id = #{fileId}")
    @ResultMap(value = "fileMap")
    public void updateFile(File file);

    /*通过ID更新评估上传附件的Path*/
    @Update("update file set f_path = #{filePath} where f_id = #{fileId}")
    @ResultMap(value = "fileMap")
    public void updatePathById(@Param("filePath") String filePath, @Param("fileId") Integer fileId);

    /*根据ID删除*/
    @Delete("delete from file where f_id = #{fileId}")
    @ResultMap(value = "fileMap")
    public void deleteFile(Integer fileId);

    /*根据责任人查询*/
    @Select("select * from file where f_dutyofficer like concat('%',#{fileDutyofficer},'%')")
    @ResultMap(value = "fileMap")
    public List<File> findByDutyofficer(String fileDutyofficer);

    /*根据责任处室查询*/
    @Select("select * from file where f_response like concat('%',#{fileResponse},'%')")
    @ResultMap(value = "fileMap")
    public List<File> findByResponse(String fileResponse);

    /*根据题名查询*/
    @Select("select * from file where f_title like concat('%',#{fileTitle},'%')")
    @ResultMap(value = "fileMap")
    public List<File> findByTitle(String fileTitle);

    /*根据题名查询*/
    @Select("select * from file where f_time = #{fileTime}")
    @ResultMap(value = "fileMap")
    public List<File> findByTime(Date fileTime);
}
