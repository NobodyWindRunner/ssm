package com.zjr.entity;

public class Teacher {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_teacher.id
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_teacher.teaName
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    private String teaname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column db_teacher.teaClass
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    private String teaclass;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_teacher.id
     *
     * @return the value of db_teacher.id
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_teacher.id
     *
     * @param id the value for db_teacher.id
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_teacher.teaName
     *
     * @return the value of db_teacher.teaName
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public String getTeaname() {
        return teaname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_teacher.teaName
     *
     * @param teaname the value for db_teacher.teaName
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column db_teacher.teaClass
     *
     * @return the value of db_teacher.teaClass
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public String getTeaclass() {
        return teaclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column db_teacher.teaClass
     *
     * @param teaclass the value for db_teacher.teaClass
     *
     * @mbggenerated Mon Dec 25 10:31:24 CST 2017
     */
    public void setTeaclass(String teaclass) {
        this.teaclass = teaclass == null ? null : teaclass.trim();
    }
}