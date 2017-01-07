package com.yuanwj.repository;

import com.yuanwj.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuanwj on 2017/1/7.
 */
public interface SongRepository extends JpaRepository<Song,Long> {
}
