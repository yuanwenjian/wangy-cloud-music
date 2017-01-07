package com.yuanwj.service.impl;

import com.yuanwj.config.CloudMusicConfiguration;
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
    private CloudMusicConfiguration configuration;
    @Override
    public List<MusicList> findAll() {
        List<MusicList> lists=musicListRepository.findAll();
        String path=configuration.getFilePath();
        LOG.debug("当前路径为{}",path);
        return null;
    }
}
