package com.yuanwj.repository;

import com.yuanwj.model.MusicList;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by bmk on 17-1-5.
 */
public interface MusicListRepository extends PagingAndSortingRepository<MusicList,String> {
}
