package com.yuanwj.model;


import javax.persistence.*;

/**
 * Created by bmk on 17-1-5.
 */
@Entity
@Table(name = "t_music_list")
public class MusicList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
