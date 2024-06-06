package minkostplan.application.entity;

import java.util.List;

public class ImageInfo {
  
  private String fileName;
  private String url;
  private List<ImageInfo> images;


public ImageInfo(String fileName, String url) {
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

  public List<ImageInfo> getImages() {
    return this.images;
}

public void setImages(List<ImageInfo> images) {
    this.images = images;
}
  
  
  @Override
    public String toString() {
        return "ImageRecipeInfo{" +
        ", fileName=" + fileName +
        ", url='" + url +
        ", images=" + images +
        '\'' +
        '}';
  }
}