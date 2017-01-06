package com.yuanwj.repository;

import com.yuanwj.model.MusicList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bmk on 17-1-5.
 */
public interface MusicListRepository extends JpaRepository<MusicList,String> {
}
