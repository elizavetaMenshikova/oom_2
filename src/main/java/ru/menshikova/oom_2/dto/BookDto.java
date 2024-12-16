package ru.menshikova.oom_2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {
    private UUID id;
    private String name;
}