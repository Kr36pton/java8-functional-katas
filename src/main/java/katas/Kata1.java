package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;
/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1{

    @SuppressWarnings("rawtypes")

    public static List<Map> execute(){
        
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream().map(t -> ImmutableMap.of("id", t.getId(), "title", t.getTitle())).collect(Collectors.toList());

    }

    public static void main(String[] args)
    {

        System.out.println(execute());
    }
}