package katas;

import java.util.List;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6{

    public static String execute(){
        
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().map(movie -> movie.getBoxarts()).flatMap(t -> t.stream()).reduce((box1, box2) -> {
            Integer sizeBox1 = box1.getWidth().intValue() * box1.getHeight().intValue();
            Integer sizeBox2 = box2.getWidth().intValue() * box2.getHeight().intValue();
            return sizeBox1 > sizeBox2 ? box1 : box2;
        }).map(box -> box.getUrl()).get();

    }

    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}