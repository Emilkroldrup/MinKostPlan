package minkostplan.application.entity;

import java.util.List;

public class Image {
  
  private String fileName;
  private String url;
  private List<Image> images;


public Image(String fileName, String url) {
    this.fileName = fileName;
    this.url = url;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Image> getImages() {
    return this.images;
}

public void setImages(List<Image> images) {
    this.images = images;
}
  
  
  @Override
    public String toString() {
        return "Image{" +
        ", fileName=" + fileName +
        ", url='" + url +
        ", images=" + images +
        '\'' +
        '}';
  }
}