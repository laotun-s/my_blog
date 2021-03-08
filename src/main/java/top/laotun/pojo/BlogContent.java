package top.laotun.pojo;

import java.sql.Timestamp;

public class BlogContent {

  private long id;
  private long postAuthor;
  private java.sql.Timestamp postDate;
  private java.sql.Timestamp postModified;
  private String postContent;
  private String postContentFiltered;
  private String postTitle;
  private String postName;
  private String guid;
  private String postClassify;
  private long postClick;

  public BlogContent() {
  }

  public BlogContent(long id, long postAuthor, Timestamp postDate, Timestamp postModified, String postContent, String postContentFiltered, String postTitle, String postName, String guid, String postClassify, long postClick) {
    this.id = id;
    this.postAuthor = postAuthor;
    this.postDate = postDate;
    this.postModified = postModified;
    this.postContent = postContent;
    this.postContentFiltered = postContentFiltered;
    this.postTitle = postTitle;
    this.postName = postName;
    this.guid = guid;
    this.postClassify = postClassify;
    this.postClick = postClick;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPostAuthor() {
    return postAuthor;
  }

  public void setPostAuthor(long postAuthor) {
    this.postAuthor = postAuthor;
  }


  public java.sql.Timestamp getPostDate() {
    return postDate;
  }

  public void setPostDate(java.sql.Timestamp postDate) {
    this.postDate = postDate;
  }


  public java.sql.Timestamp getPostModified() {
    return postModified;
  }

  public void setPostModified(java.sql.Timestamp postModified) {
    this.postModified = postModified;
  }


  public String getPostContent() {
    return postContent;
  }

  public void setPostContent(String postContent) {
    this.postContent = postContent;
  }


  public String getPostContentFiltered() {
    return postContentFiltered;
  }

  public void setPostContentFiltered(String postContentFiltered) {
    this.postContentFiltered = postContentFiltered;
  }


  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }


  public String getPostName() {
    return postName;
  }

  public void setPostName(String postName) {
    this.postName = postName;
  }


  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }


  public String getPostClassify() {
    return postClassify;
  }

  public void setPostClassify(String postClassify) {
    this.postClassify = postClassify;
  }


  public long getPostClick() {
    return postClick;
  }

  public void setPostClick(long postClick) {
    this.postClick = postClick;
  }

  @Override
  public String toString() {
    return "BlogContent{" +
            "id=" + id +
            ", postAuthor=" + postAuthor +
            ", postDate=" + postDate +
            ", postModified=" + postModified +
            ", postContent='" + postContent + '\'' +
            ", postContentFiltered='" + postContentFiltered + '\'' +
            ", postTitle='" + postTitle + '\'' +
            ", postName='" + postName + '\'' +
            ", guid='" + guid + '\'' +
            ", postClassify='" + postClassify + '\'' +
            ", postClick=" + postClick +
            '}';
  }
}
