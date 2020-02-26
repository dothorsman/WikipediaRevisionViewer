package model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Article
{
    String title;
    String revisions; ///Each revision has a user & a timestamp

    public Article(String title, String revisions) {
        this.title = title;
        this.revisions = revisions;
    }

    public String getTitle() { return title; }
    public String getRevisions() { return revisions; }


}
