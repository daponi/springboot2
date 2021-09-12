package com.atguigu.www.service.impl;

import com.atguigu.www.bean.Score;
import com.atguigu.www.mapper.ScoreMapper;
import com.atguigu.www.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public Score getScoreById(Integer sId) {
         return scoreMapper.getScoreById(sId);
    }

    @Override
    public void insertScore(Score scoore) {
        scoreMapper.insertScore(scoore);
    }
}
