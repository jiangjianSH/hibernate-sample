package com.jiangjian.learning.hibernate.customebasictype;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Clob;
import java.time.Period;
import java.util.BitSet;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Product")
public class Product {

    @Id
    private Integer id;

    @Type( type = "bitset" )
    private BitSet bitSet;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phone_type")
    private PhoneType type;

    @Convert( converter = GenderConverter.class )
    public Gender gender;

    @Lob
    private Clob warranty;


    @Lob
    @Nationalized
    private String nationalCharData;

    private UUID uuid;

    @Temporal(TemporalType.TIME)
    private Date date;

    @Convert(converter = PeriodConverter.class)
    private Period span;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BitSet getBitSet() {
        return bitSet;
    }

    public void setBitSet(BitSet bitSet) {
        this.bitSet = bitSet;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Clob getWarranty() {
        return warranty;
    }

    public void setWarranty(Clob warranty) {
        this.warranty = warranty;
    }

    public String getNationalCharData() {
        return nationalCharData;
    }

    public void setNationalCharData(String nationalCharData) {
        this.nationalCharData = nationalCharData;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Period getSpan() {
        return span;
    }

    public void setSpan(Period span) {
        this.span = span;
    }
}