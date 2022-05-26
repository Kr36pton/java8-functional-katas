package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:
	@@ -56,15 +57,47 @@
    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11
{
    @SuppressWarnings(
    {
            "unused", "rawtypes"
    })
    public static List<Map> execute()
    {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();

        return lists.stream().map(list -> {

            Integer listId = (Integer) list.get("id");

            List<Map> videosDataStructure = videos.stream().filter(t -> t.get("listId").equals(listId)).collect(Collectors.toList());

            List<Map> finalResult = videosDataStructure.stream().map(v -> {

                Integer videoId = (Integer) v.get("id");

                Map boxArt = boxArts.stream().filter(b -> b.get("videoId").equals(videoId)).findFirst().get();

                Map bookmark = bookmarkList.stream().filter(bml -> bml.get("videoId").equals(videoId)).findFirst().get();

                return ImmutableMap.of("id", v.get("id"), "title", v.get("title"), "time", bookmark.get("time"), "boxart", boxArt.get("url"));

            }).collect(Collectors.toList());

            return ImmutableMap.of("Name", list.get("name"), "videos", finalResult);

        }).collect(Collectors.toList());

    }

    public static void main(String[] args)
    {

        System.out.println(execute());

    }
}