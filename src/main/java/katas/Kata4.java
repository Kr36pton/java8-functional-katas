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
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4
{
    @SuppressWarnings("rawtypes")
    public static List<Map> execute()
    {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Movie> movies = movieLists.stream().map(t -> t.getVideos()).flatMap(t -> t.stream()).collect(Collectors.toList());

        return movies.stream().map(movie -> {

            BoxArt box = movie.getBoxarts().stream().filter(b -> b.getHeight() == 200 && b.getWidth() == 150).findAny().get();

            return ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", box.getUrl());

        }).collect(Collectors.toList());

    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}