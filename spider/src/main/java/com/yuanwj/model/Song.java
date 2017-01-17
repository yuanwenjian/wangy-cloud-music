package com.yuanwj.model;

import javax.persistence.*;

/**
 * Created by yuanwj on 2017/1/6.
 */
@Entity
@Table(name = "t_song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String url;

    private String name;

    private String artist;

    @Column(name = "album_url")
    private String albumUrl; //专辑url

    private String album;

    @Column(name = "mv_url")
    private String mvUrl;

    @Column(name = "music_list_id")
    private String musicListId;

//    @Column(name = "img_path")
//    private String imgPath;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getMvUrl() {
        return mvUrl;
    }

    public void setMvUrl(String mvUrl) {
        this.mvUrl = mvUrl;
    }

//    public String getImgPath() {
//        return imgPath;
//    }
//
//    public void setImgPath(String imgPath) {
//        this.imgPath = imgPath;
//    }


    public String getMusicListId() {
        return musicListId;
    }

    public void setMusicListId(String musicListId) {
        this.musicListId = musicListId;
    }
}
