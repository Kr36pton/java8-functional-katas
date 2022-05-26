package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;

import model.Bookmark;
import model.Movie;
import util.DataUtil;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8{

    @SuppressWarnings("rawtypes")

    public static List<Map> execute(){
        
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        return StreamUtils.zip(movies.stream(), bookMarks.stream(), (movie, book) -> ImmutableMap.of("videoId", movie.getId(), "bookmarkId", book.getId()))
                .collect(Collectors.toList());

    }

    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}