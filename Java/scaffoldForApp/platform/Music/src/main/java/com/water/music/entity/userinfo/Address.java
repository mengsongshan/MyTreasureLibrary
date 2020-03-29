package com.water.music.entity.userinfo;

public
class Address {
    private int id;
    private String country;
    private String province;
    private String city;
    private String region;
    private String town;
    private String village;
    private String extension;

    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }

    public
    String getCountry() {
        return country;
    }

    public
    void setCountry(String country) {
        this.country = country;
    }

    public
    String getProvince() {
        return province;
    }

    public
    void setProvince(String province) {
        this.province = province;
    }

    public
    String getCity() {
        return city;
    }

    public
    void setCity(String city) {
        this.city = city;
    }

    public
    String getRegion() {
        return region;
    }

    public
    void setRegion(String region) {
        this.region = region;
    }

    public
    String getTown() {
        return town;
    }

    public
    void setTown(String town) {
        this.town = town;
    }

    public
    String getVillage() {
        return village;
    }

    public
    void setVillage(String village) {
        this.village = village;
    }

    public
    String getExtension() {
        return extension;
    }

    public
    void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public
    String toString() {
        return "Address{" + "id=" + id + ", country='" + country + '\'' + ", province='" + province + '\'' + ", city='" + city + '\'' + ", region='" + region + '\'' + ", town='" + town + '\'' + ", village='" + village + '\'' + ", extension='" + extension + '\'' + '}';
    }
}
