package com.modernJava.aSmallDSLForTheLatestJavaAPI.jooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://chatgpt.com/c/670c8496-526c-8003-bc33-e818438a98d1

public class JOOQ {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection c = DriverManager.getConnection("jdbc:h2:file:./sql-goodies-with-mapping", "sa", "")) {
            DSLContext dsl = DSL.using(c);
            dsl.execute(
                    "CREATE TABLE IF NOT EXISTS BOOK (" +
                            "id INT PRIMARY KEY, " +
                            "title VARCHAR(100), " +
                            "author VARCHAR(100), " +
                            "published INT)"
            );
            System.out.println("BOOK 테이블이 생성되었습니다.");

//            dsl.insertInto(DSL.table("BOOK"), DSL.field("id"), DSL.field("title"), DSL.field("author"), DSL.field("published"))
//                    .values(1, "Book A", "Author A", 2000).execute();
//            System.out.println("Inserted book: " + "Author A");
//            dsl.insertInto(DSL.table("BOOK"), DSL.field("id"), DSL.field("title"), DSL.field("author"), DSL.field("published"))
//                    .values(2, "Book B", "Author B", 2000).execute();
//            System.out.println("Inserted book: " + "Author B");
//            dsl.insertInto(DSL.table("BOOK"), DSL.field("id"), DSL.field("title"), DSL.field("author"), DSL.field("published"))
//                    .values(3, "Book C", "Author C", 2000).execute();
//            System.out.println("Inserted book: " + "Author C");
//            dsl.insertInto(DSL.table("BOOK"), DSL.field("id"), DSL.field("title"), DSL.field("author"), DSL.field("published"))
//                    .values(4, "Book D", "Author D", 2000).execute();
//            System.out.println("Inserted book: " + "Author D");
//            dsl.insertInto(DSL.table("BOOK"), DSL.field("id"), DSL.field("title"), DSL.field("author"), DSL.field("published"))
//                    .values(5, "Book E", "Author E", 2000).execute();
//            System.out.println("Inserted book: " + "Author E");

            System.out.println("Reading all books:");
            Result<Record> result = dsl.select().from(DSL.table("BOOK")).fetch();
            for (Record record : result) {
                System.out.println("ID: " + record.getValue(DSL.field("ID")) +
                        ", Title: " + record.getValue(DSL.field("TITLE")) +
                        ", Author: " + record.getValue(DSL.field("AUTHOR")) +
                        ", Published: " + record.getValue(DSL.field("PUBLISHED")));
            }

//            dsl.update(DSL.table("BOOK"))
//                    .set(DSL.field("TITLE"), "Updated Book A")
//                    .where(DSL.field("ID").eq(1))
//                    .execute();
//            System.out.println("Updated book with ID: " + 1 + " to title: Updated Book A");
//
//            System.out.println("Reading all books:");
//            result = dsl.select().from(DSL.table("BOOK")).fetch();
//            for (Record record : result) {
//                System.out.println("ID: " + record.getValue(DSL.field("ID")) +
//                        ", Title: " + record.getValue(DSL.field("TITLE")) +
//                        ", Author: " + record.getValue(DSL.field("AUTHOR")) +
//                        ", Published: " + record.getValue(DSL.field("PUBLISHED")));
//            }

//            dsl.deleteFrom(DSL.table("BOOK"))
//                    .where(DSL.field("ID").eq(2))
//                    .execute();
//            System.out.println("Deleted book with ID: " + 2);
//            System.out.println("Reading all books:");
//            result = dsl.select().from(DSL.table("BOOK")).fetch();
//            for (Record record : result) {
//                System.out.println("ID: " + record.getValue(DSL.field("ID")) +
//                        ", Title: " + record.getValue(DSL.field("TITLE")) +
//                        ", Author: " + record.getValue(DSL.field("AUTHOR")) +
//                        ", Published: " + record.getValue(DSL.field("PUBLISHED")));
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
