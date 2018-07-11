package com.jiangjian.learning.hibernate.customebasictype;

import com.jiangjian.learning.hibernate.SessionUtil;
import org.hibernate.engine.jdbc.ClobProxy;

import java.time.Period;
import java.util.BitSet;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class ConfigCustomBitSetTypeDemo {
    public static void main(String[] args) {

        Product product = new Product( );
        product.setId(new Random().nextInt());
        product.setType(PhoneType.LAND_LINE);
        product.setGender(Gender.FEMALE);
        //To persist such an entity, you have to create a Clob using the ClobProxy Hibernate utility:
        product.setWarranty(ClobProxy.generateProxy("My product warrantly"));
        product.setNationalCharData("这是中文，this is english");
        product.setDate(new Date());
        product.setUuid(UUID.randomUUID());
        product.setSpan(Period.ofYears(3).plusMonths(1L));
        BitSet bitSet = BitSet.valueOf( new long[] {1, 2, 3} );
        product.setBitSet( bitSet );

        SessionUtil.persist(product);
    }
}
