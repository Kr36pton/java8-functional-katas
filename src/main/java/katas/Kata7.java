package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7
{
    public static List<Map> execute()
    {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Movie> movies = movieLists.stream().map(t -> t.getVideos()).flatMap(t -> t.stream()).collect(Collectors.toList());

        return movies.stream().map(t -> {

            BoxArt smallestBox = t.getBoxarts().stream().reduce((box1, box2) -> {

                Integer sizeBox1 = box1.getHeight().intValue() * box1.getWidth().intValue();
                Integer sizeBox2 = box2.getHeight().intValue() * box2.getWidth().intValue();

                return sizeBox1 < sizeBox2 ? box1 : box2;
            }).get();

            return ImmutableMap.of("id", t.getId(), "title", t.getTitle(), "boxart", smallestBox.getUrl());

        }).collect(Collectors.toList());

    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}