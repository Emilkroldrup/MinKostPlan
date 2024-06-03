package minkostplan.application.entity;

public class ImageRecipeInfo {
  
  private int recipeid;
  private String name;
  private String url;


  public ImageRecipeInfo(int recipeid, String name, String url) {
    this.recipeid = recipeid;
    this.name = name;
    this.url = url;
  }

  public ImageRecipeInfo(String name, String url) {
    this.name = name;
    this.url = url;
  }

public int getRecipeid() {
    return recipeid;
  }

  public void setRecipeid(int recipeid) {
    this.recipeid = recipeid;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  
  @Override
    public String toString() {
        return "ImageRecipeInfo{" +
        "recipeid=" + recipeid +
        ", name=" + name +
        ", url='" + url + '\'' +
        '}';
  }
}