package com.yuanwj.ItemPipeline;

import com.yuanwj.core.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuanwj on 2017/1/6.
 */
public class ItemPipeLineImpl<Entity,Repository extends JpaRepository> implements ItemPipeLine {

    public static final Logger LOG= LoggerFactory.getLogger(ItemPipeLineImpl.class);
    private final Class<Entity> entiry;

    private final Repository repository;

    public ItemPipeLineImpl(Class<Entity> entiry, Repository repository) {
        this.entiry = entiry;
        this.repository = repository;
    }

    @Override
    public void save(Result result) {
        if (result.getEntity()!=null){
            for (Object entity:result.getEntity()){
                if (entiry.isInstance(entity)){
                    repository.save(entity);
                    LOG.debug("保存{}实体类",entity.getClass().getSimpleName());
                }
            }
        }
    }
}
