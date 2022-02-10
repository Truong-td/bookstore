package com.truongtd.bookstore.domain.model;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {

    private Long id;

    private String title;

    private String name;

    private Date createdAt;

    private Date updatedAt;
}
