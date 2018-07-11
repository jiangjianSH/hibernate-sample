package com.jiangjian.learning.hibernate.generatedproperties;

import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Person")
public class Person {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName1;

    private String middleName2;

    private String middleName3;

    private String middleName4;

    private String middleName5;
//
//    @Generated( value = GenerationTime.ALWAYS )
//    @Column(columnDefinition =
//            "AS CONCAT(" +
//                    "	COALESCE(firstName, ''), " +
//                    "	COALESCE(' ' + middleName1, ''), " +
//                    "	COALESCE(' ' + middleName2, ''), " +
//                    "	COALESCE(' ' + middleName3, ''), " +
//                    "	COALESCE(' ' + middleName4, ''), " +
//                    "	COALESCE(' ' + middleName5, ''), " +
//                    "	COALESCE(' ' + lastName, '') " +
//                    ")")
//    private String fullName;

    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;


    @FunctionCreationTimestamp
    @Column(name = "databaseTime")
    private Date databaseTime;

    @Column(name = "pswd")
    @ColumnTransformer(
            read = "pswd",
            write = "?"
    )
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName1() {
        return middleName1;
    }

    public void setMiddleName1(String middleName1) {
        this.middleName1 = middleName1;
    }

    public String getMiddleName2() {
        return middleName2;
    }

    public void setMiddleName2(String middleName2) {
        this.middleName2 = middleName2;
    }

    public String getMiddleName3() {
        return middleName3;
    }

    public void setMiddleName3(String middleName3) {
        this.middleName3 = middleName3;
    }

    public String getMiddleName4() {
        return middleName4;
    }

    public void setMiddleName4(String middleName4) {
        this.middleName4 = middleName4;
    }

    public String getMiddleName5() {
        return middleName5;
    }

    public void setMiddleName5(String middleName5) {
        this.middleName5 = middleName5;
    }

//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDatabaseTime() {
        return databaseTime;
    }

    public void setDatabaseTime(Date databaseTime) {
        this.databaseTime = databaseTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}