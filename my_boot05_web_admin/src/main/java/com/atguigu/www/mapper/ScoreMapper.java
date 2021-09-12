package com.atguigu.www.mapper;

import com.atguigu.www.bean.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface ScoreMapper {

    @Select("select * from score_ex where s_id =#{s_id}")
    Score getScoreById(Integer s_id);

    @Insert("insert into score_ex(`s_id`,`c_id`,`s_score`) values(#{sId},#{cId},#{sScore})")
    public void insertScore(Score scoore);
}
