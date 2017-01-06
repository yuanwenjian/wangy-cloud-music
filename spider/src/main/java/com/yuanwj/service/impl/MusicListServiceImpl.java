package com.yuanwj.service.impl;

import com.yuanwj.model.MusicList;
import com.yuanwj.repository.MusicListRepository;
import com.yuanwj.service.MusicListService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by bmk on 17-1-6.
 */
@Service
public class MusicListServiceImpl implements MusicListService{

    @Inject
    private MusicListRepository musicListRepository;
    @Override
    public List<MusicList> findAll() {
        List<MusicList> lists=musicListRepository.findAll();
        return null;
    }
}
