package katas;

import java.util.List;
import java.util.stream.Collectors;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3
{
    public static List<Integer> execute()
    {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().map(t -> t.getVideos()).flatMap(t -> t.stream()).map(t -> t.getId()).collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        System.out.println(execute());

    }
}
