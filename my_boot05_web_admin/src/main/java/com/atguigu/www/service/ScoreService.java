package com.atguigu.www.service;

import com.atguigu.www.bean.Score;

public interface ScoreService {
    Score getScoreById(Integer sId);

    void insertScore(Score scoore);
}
