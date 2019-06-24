package com.awl.jspbook.ch04;

import java.io.*;

public class AlbumInfo implements Serializable {
  private String bgColor;
  private String textColor;
  private String name;
  private int year;
  private String artist;
  private String tracks[];


  public String getBgColor() {return bgColor;}
  public void setBgColor(String bgColor) {this.bgColor = bgColor;}

  public String getTextColor() {return textColor;}
  public void setTextColor(String textColor) {this.textColor = textColor;}


  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int getYear() {return year;}
  public void setYear(int year) {this.year = year;}

  public String getArtist() {return artist;}
  public void setArtist(String artist) {this.artist = artist;}

  public String[] getTracks() {return tracks;}
  public void setTracks(String tracks[]) {this.tracks = tracks;}

  public static void main(String argv[]) throws Exception {
    AlbumInfo a = new AlbumInfo();
    a.setBgColor(argv[1]);
    a.setTextColor(argv[2]);
    a.setName(argv[3]);
    a.setYear(Integer.parseInt(argv[4]));
    a.setArtist(argv[5]);

    String tmp[] = new String[argv.length-6];
    for(int i=6;i<argv.length;i++) tmp[i-6] = argv[i];

    a.setTracks(tmp);
    ObjectOutputStream o = new ObjectOutputStream(
			       new FileOutputStream(argv[0]));
    o.writeObject(a);
    o.close();
  }
}
