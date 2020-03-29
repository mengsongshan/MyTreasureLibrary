package com.water.music.entity.userinfo;

public
class Contract {
    private long id;
    private String phone;
    private String fixPhone;
    private String mail;
    private String fax;
    private String extension;

    public
    long getId() {
        return id;
    }

    public
    void setId(long id) {
        this.id = id;
    }


    public
    String getPhone() {
        return phone;
    }

    public
    void setPhone(String phone) {
        this.phone = phone;
    }

    public
    String getFixPhone() {
        return fixPhone;
    }

    public
    void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone;
    }

    public
    String getMail() {
        return mail;
    }

    public
    void setMail(String mail) {
        this.mail = mail;
    }

    public
    String getFax() {
        return fax;
    }

    public
    void setFax(String fax) {
        this.fax = fax;
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
        return "Contract{" + "phone='" + phone + '\'' + ", fixPhone='" + fixPhone + '\'' + ", mail='" + mail + '\'' + ", fax='" + fax + '\'' + ", extension='" + extension + '\'' + '}';
    }
}
