package com.jiangjian.learning.hibernate.columntransformer;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Savings")
@TypeDef(
        name = "monetaryAmount",
        defaultForType = MonetaryAmount.class,
        typeClass = MonetaryAmountUserType.class
)
public class Savings {

    @Id
    private Long id;

    /**
     * TODO: 现在不生效，后面需要查明
     */
    @Type(type = "monetaryAmount")
    @Columns(columns = {
            @Column(name = "money"),
            @Column(name = "currency")
    })
    @ColumnTransformer(
            forColumn = "money",
            read = "money / 100",
            write = "? * 100"
    )
    private MonetaryAmount wallet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MonetaryAmount getWallet() {
        return wallet;
    }

    public void setWallet(MonetaryAmount wallet) {
        this.wallet = wallet;
    }
}