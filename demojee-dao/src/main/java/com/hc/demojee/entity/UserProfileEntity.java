package com.hc.demojee.entity;

import java.util.Date;

public class UserProfileEntity {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 是否医生
     */
    private Boolean isDoctor;

    /**
     * 姓名助记词
     */
    private String mnemonic;

    /**
     * 用户姓-英文
     */
    private String familyName;

    /**
     * 用户名-英文
     */
    private String givenName;

    /**
     * 用户姓-中文
     */
    private String familyNameCn;

    /**
     * 用户名-中文
     */
    private String givenNameCn;

    /**
     *  证件类型： 1：身份证 2：护照
     */
    private Integer idType;

    /**
     * 身份证号码
     */
    private String idNo;

    /**
     * 护照
     */
    private String passport;

    /**
     * 出生日期
     */
    private Date dob;

    /**
     * 性别M男F女0其他
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 办公电话
     */
    private String telephone;

    /**
     * 微信号
     */
    private String weichatNo;

    /**
     * 头像文件ID
     */
    private Long headFileId;

    /**
     * 擅长
     */
    private String skill;

    /**
     * 职称
     */
    private String professional;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 是否有打疫苗资质，1是0否
     */
    private Integer printVaccine;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建日期
     */
    private Date createOn;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 
     */
    private Date modifyOn;

    /**
     * 
     */
    private Long modifyBy;

    /**
     * 姓名拼音
     */
    private String py;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic == null ? null : mnemonic.trim();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName == null ? null : givenName.trim();
    }

    public String getFamilyNameCn() {
        return familyNameCn;
    }

    public void setFamilyNameCn(String familyNameCn) {
        this.familyNameCn = familyNameCn == null ? null : familyNameCn.trim();
    }

    public String getGivenNameCn() {
        return givenNameCn;
    }

    public void setGivenNameCn(String givenNameCn) {
        this.givenNameCn = givenNameCn == null ? null : givenNameCn.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport == null ? null : passport.trim();
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getWeichatNo() {
        return weichatNo;
    }

    public void setWeichatNo(String weichatNo) {
        this.weichatNo = weichatNo == null ? null : weichatNo.trim();
    }

    public Long getHeadFileId() {
        return headFileId;
    }

    public void setHeadFileId(Long headFileId) {
        this.headFileId = headFileId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getPrintVaccine() {
        return printVaccine;
    }

    public void setPrintVaccine(Integer printVaccine) {
        this.printVaccine = printVaccine;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(Date modifyOn) {
        this.modifyOn = modifyOn;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py == null ? null : py.trim();
    }
}