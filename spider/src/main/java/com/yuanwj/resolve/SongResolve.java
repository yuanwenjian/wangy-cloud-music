package com.yuanwj.resolve;

import com.yuanwj.core.Request;
import com.yuanwj.core.Result;
import com.yuanwj.model.Song;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanwj on 2017/1/7.
 */
public class SongResolve implements ResolveResponse {
    public static final Logger LOG= LoggerFactory.getLogger(SongResolve.class);

    @Override
    public Result resolve(Document document,Request request) {
        LOG.debug("解析歌曲html");
        Result result=new Result();
        Element element=document.select(".cnt").get(0);
        Element divElement=element.getElementsByTag("div").get(0);
        Element emElement=divElement.getElementsByTag("div").get(0);
        Element em=emElement.getElementsByTag("em").get(0);
        String name=em.text();
        Element aElement=emElement.getElementsByTag("a").get(0);
        String mvPath=aElement.attr("href");

        Element artistEle=element.select("p>span").get(0);
        Element albumEle=element.select("p>a").get(0);

        String artist=artistEle.text();
        String url=artistEle.getElementsByTag("a").get(0).attr("href");
        String album=albumEle.text();
        String ablumUrl=albumEle.attr("href");

        Element songEle=document.select("#lyric-content").get(0);
        String  songId=songEle.attr("data-song-id");


        Song song=new Song();
        song.setMusicListId(request.getParam());
        song.setName(name);
        song.setMvUrl(Request.BASEURL + mvPath);
        song.setArtist(artist);
        song.setUrl(Request.BASEURL+"/song?id="+songId);
        song.setAlbumUrl(Request.BASEURL + ablumUrl);
        song.setAlbum(album);
        List<Song> songs=new ArrayList<>();
        songs.add(song);
        result.setEntity(songs);
        return result;
    }
}
