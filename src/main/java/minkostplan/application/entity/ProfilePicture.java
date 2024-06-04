package minkostplan.application.entity;

public class ProfilePicture {
    private int userid;
    private String filename;
    private String url;

    public ProfilePicture(String filename, String url) {
        this.filename = filename;
        this.url = url;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ProfilePicture{" +
        "userid=" + userid +
        ", filename=" + filename +
        ", url='" + url + '\'' +
        '}';
    }

}
