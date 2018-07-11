package com.jiangjian.learning.hibernate.embeded;

import com.jiangjian.learning.hibernate.SessionUtil;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setAuthor("姜健");
        book.setTitle("hibernate 入门");
        Country china = new Country("中国");
        SessionUtil.persist(china);

        Country english = new Country("英国");
        SessionUtil.persist(english);
        book.setEbookPublisher(new Publisher("机械出版社", china));
        book.setPaperBackPublisher(new Publisher("翻译出版社", english));
        SessionUtil.persist(book);

        SessionUtil.sessionFactory.close();
    }
}
