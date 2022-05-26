package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.InterestingMoment;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9
{
    public static List<Map> execute()
    {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Movie> movies = movieLists.stream().flatMap(t -> t.getVideos().stream()).collect(Collectors.toList());

        return movies.stream().map(t -> {

            BoxArt smallestBox = t.getBoxarts().stream().reduce((box1, box2) -> {

                Integer sizeBox1 = box1.getHeight().intValue() * box1.getWidth().intValue();
                Integer sizeBox2 = box2.getHeight().intValue() * box2.getWidth().intValue();

                return sizeBox1 < sizeBox2 ? box1 : box2;
            }).get();

            InterestingMoment im = t.getInterestingMoments().stream().filter(moment -> moment.getType().equals("Middle")).findFirst().get();

            return ImmutableMap.of("id", t.getId(), "title", t.getTitle(), "time", im.getTime(), "boxart", smallestBox.getUrl());

        }).collect(Collectors.toList());

    }

    public static void main(String[] args)
    {
        System.out.println(execute());

    }
}