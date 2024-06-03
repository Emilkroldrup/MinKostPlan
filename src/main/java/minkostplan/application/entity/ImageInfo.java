package minkostplan.application.entity;

public class ImageInfo {
    
  private String name;
  private String url;

  public ImageInfo(String name, String url) {
    this.name = name;
    this.url = url;
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
        return "ImageInfo{" +
                "name=" + name +
                '\'' +
                "Url='" + url + 
                '}';
    }
}
