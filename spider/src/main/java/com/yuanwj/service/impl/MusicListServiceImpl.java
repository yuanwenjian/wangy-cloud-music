package com.yuanwj.service.impl;

import com.yuanwj.config.SpliderConfiguration;
import com.yuanwj.model.MusicList;
import com.yuanwj.repository.MusicListRepository;
import com.yuanwj.service.MusicListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by bmk on 17-1-6.
 */
@Service
public class MusicListServiceImpl implements MusicListService{

    public static final Logger LOG= LoggerFactory.getLogger(MusicListServiceImpl.class);

    @Inject
    private MusicListRepository musicListRepository;

    @Inject
    private SpliderConfiguration configuration;
    @Override
    public List<MusicList> findAll() {
        LOG.debug("查询音乐列表");
        List<MusicList> lists=musicListRepository.findAll();
        String path=configuration.getFilePath();
        return null;
    }
}
