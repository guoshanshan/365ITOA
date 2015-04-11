package com.yfann.web.model;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Simon on 2015/4/2.
 */
public class User {
    private String id;
    private String userId;
    private String userName;
    private String departId;
    private String password;
    private Date birthday;
    private String sex;
    private String idcardNumber;
    private String education;
    private String foreignCountrie;
    private String graduateSchool;
    private String phoneNumber;
    private String ip;
    private String countrie;
    private String provinceAndCity;
    private String address;
    private String zipCode;
    private String email;
    private String qq;
    private byte[] headImg;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcardNumber() {
        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {
        this.idcardNumber = idcardNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getForeignCountrie() {
        return foreignCountrie;
    }

    public void setForeignCountrie(String foreignCountrie) {
        this.foreignCountrie = foreignCountrie;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountrie() {
        return countrie;
    }

    public void setCountrie(String countrie) {
        this.countrie = countrie;
    }

    public String getProvinceAndCity() {
        return provinceAndCity;
    }

    public void setProvinceAndCity(String provinceAndCity) {
        this.provinceAndCity = provinceAndCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (countrie != null ? !countrie.equals(user.countrie) : user.countrie != null) return false;
        if (departId != null ? !departId.equals(user.departId) : user.departId != null) return false;
        if (education != null ? !education.equals(user.education) : user.education != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (foreignCountrie != null ? !foreignCountrie.equals(user.foreignCountrie) : user.foreignCountrie != null)
            return false;
        if (graduateSchool != null ? !graduateSchool.equals(user.graduateSchool) : user.graduateSchool != null)
            return false;
        if (!Arrays.equals(headImg, user.headImg)) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (idcardNumber != null ? !idcardNumber.equals(user.idcardNumber) : user.idcardNumber != null) return false;
        if (ip != null ? !ip.equals(user.ip) : user.ip != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (provinceAndCity != null ? !provinceAndCity.equals(user.provinceAndCity) : user.provinceAndCity != null)
            return false;
        if (qq != null ? !qq.equals(user.qq) : user.qq != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (zipCode != null ? !zipCode.equals(user.zipCode) : user.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (departId != null ? departId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (idcardNumber != null ? idcardNumber.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (foreignCountrie != null ? foreignCountrie.hashCode() : 0);
        result = 31 * result + (graduateSchool != null ? graduateSchool.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (countrie != null ? countrie.hashCode() : 0);
        result = 31 * result + (provinceAndCity != null ? provinceAndCity.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (headImg != null ? Arrays.hashCode(headImg) : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
