package katas;

import java.util.List;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5{

    public static Double execute(){
        
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().reduce((movie1, movie2) -> movie1.getRating() > movie2.getRating() ? movie1 : movie2).map(movie -> movie.getRating()).get();

    }
    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}