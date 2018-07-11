package com.jiangjian.learning.hibernate.customebasictype;

import javax.persistence.AttributeConverter;
import java.time.Period;

public class PeriodConverter implements AttributeConverter<Period, String> {
    @Override
    public String convertToDatabaseColumn(Period attribute) {
        return attribute.toString();
    }

    @Override
    public Period convertToEntityAttribute(String dbData) {
        return Period.parse( dbData );
    }
}
