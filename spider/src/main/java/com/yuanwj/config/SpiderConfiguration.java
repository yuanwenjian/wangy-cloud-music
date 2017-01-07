package com.yuanwj.config;

import com.yuanwj.ItemPipeline.ItemPipeLineImpl;
import com.yuanwj.core.Splider;
import com.yuanwj.core.SpliderImpl;
import com.yuanwj.download.DownloadImpl;
import com.yuanwj.download.Downloader;
import com.yuanwj.model.MusicList;
import com.yuanwj.model.Song;
import com.yuanwj.model.User;
import com.yuanwj.queue.RequestQueue;
import com.yuanwj.queue.RequestQueueImpl;
import com.yuanwj.repository.MusicListRepository;
import com.yuanwj.repository.SongRepository;
import com.yuanwj.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.inject.Inject;

/**
 * Created by yuanwj on 2017/1/4.
 */
@Configuration
@EnableScheduling
public class SpiderConfiguration implements InitializingBean{

    public static final Logger LOG= LoggerFactory.getLogger(SpiderConfiguration.class);

    @Inject
    private UserRepository userRepository;

    @Inject
    private MusicListRepository musicListRepository;

    @Inject
    private SongRepository songRepository;

    @Inject
    private Splider splider;
    @Bean
    public RequestQueue requestQueue(){
        LOG.debug("创建requestQueue队列");
        return new RequestQueueImpl();
    }

    @Bean
    public Downloader downloader(){
        LOG.debug("创建downloader");
        return new DownloadImpl();
    }

    public void afterPropertiesSet() throws Exception{
        splider.addItemPipeline(new ItemPipeLineImpl<>(MusicList.class, musicListRepository));
        splider.addItemPipeline(new ItemPipeLineImpl<>(Song.class, songRepository));
        splider.addItemPipeline(new ItemPipeLineImpl<>(User.class, userRepository));
        LOG.debug("将ItemPipeLine添加到splider中");
    }






}
