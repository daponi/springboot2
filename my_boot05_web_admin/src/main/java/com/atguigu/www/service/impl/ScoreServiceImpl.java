package com.atguigu.www.service.impl;

import com.atguigu.www.bean.Score;
import com.atguigu.www.mapper.ScoreMapper;
import com.atguigu.www.service.ScoreService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    Counter counter;
    public ScoreServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.getScoreById.count");
    }

    @Override
    public Score getScoreById(Integer sId) {
        counter.increment();
        return scoreMapper.getScoreById(sId);
    }

    @Override
    public void insertScore(Score scoore) {
        scoreMapper.insertScore(scoore);
    }
}
