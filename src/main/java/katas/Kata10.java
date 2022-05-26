package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableMap;
import util.DataUtil;
/*
    Goal: Create a datastructure from the given data:
    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:
    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]
    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10{

    @SuppressWarnings({"rawtypes"})

    public static List<Map> execute(){
        
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        return lists.stream().map(list -> {
            Integer listId = (Integer) list.get("id");
            List<Map> finalResult = videos.stream().filter(t -> t.get("listId").equals(listId))
                    .map(m -> ImmutableMap.of("id", m.get("id"), "title", m.get("title"))).collect(Collectors.toList());
            return ImmutableMap.of("Name", list.get("name"), "videos", finalResult);
        }).collect(Collectors.toList());
    }
    public static void main(String[] args)
    {
        System.out.println(execute());
    }
}