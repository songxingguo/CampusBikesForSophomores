package com.cp.model;

public class Module {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.parent_code
     *
     * @mbggenerated
     */
    private String parentCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.has_child
     *
     * @mbggenerated
     */
    private Byte hasChild;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.icon_url
     *
     * @mbggenerated
     */
    private String iconUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.id
     *
     * @return the value of module.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.id
     *
     * @param id the value for module.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.code
     *
     * @return the value of module.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.code
     *
     * @param code the value for module.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.parent_code
     *
     * @return the value of module.parent_code
     *
     * @mbggenerated
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.parent_code
     *
     * @param parentCode the value for module.parent_code
     *
     * @mbggenerated
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.has_child
     *
     * @return the value of module.has_child
     *
     * @mbggenerated
     */
    public Byte getHasChild() {
        return hasChild;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.has_child
     *
     * @param hasChild the value for module.has_child
     *
     * @mbggenerated
     */
    public void setHasChild(Byte hasChild) {
        this.hasChild = hasChild;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.name
     *
     * @return the value of module.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.name
     *
     * @param name the value for module.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.url
     *
     * @return the value of module.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.url
     *
     * @param url the value for module.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.icon_url
     *
     * @return the value of module.icon_url
     *
     * @mbggenerated
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.icon_url
     *
     * @param iconUrl the value for module.icon_url
     *
     * @mbggenerated
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }
}