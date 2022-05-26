package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:
	@@ -50,14 +49,35 @@
    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10
{
    @SuppressWarnings(
    {
            "unused", "rawtypes"
    })
    public static List<Map> execute()
    {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        return lists.stream().map(list -> {

            Integer listId = (Integer) list.get("id");

            List<Map> movies = videos.stream().filter(t -> t.get("listId").equals(listId)).collect(Collectors.toList());

            List<Map> teste = movies.stream().map(m -> ImmutableMap.of("id", m.get("id"), "title", m.get("title"))).collect(Collectors.toList());

            return ImmutableMap.of("Name", list.get("name"), "videos", teste);

        }).collect(Collectors.toList());

    }

    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}