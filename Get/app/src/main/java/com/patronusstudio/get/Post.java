package com.patronusstudio.get;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    private int kullanıcı_id;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String baslik;

    @SerializedName("body")
    private String icerik;

    public int getKullanıcı_id() {
        return kullanıcı_id;
    }

    public void setKullanıcı_id(int kullanıcı_id) {
        this.kullanıcı_id = kullanıcı_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
