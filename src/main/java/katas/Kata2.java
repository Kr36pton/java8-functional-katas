package katas;

import java.util.List;
import java.util.stream.Collectors;

import model.Movie;
import util.DataUtil;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2
{
    public static List<Integer> execute()
    {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().filter(movie -> movie.getRating().equals(5.0)).map(movie -> movie.getId()).collect(Collectors.toList());
    }

    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}