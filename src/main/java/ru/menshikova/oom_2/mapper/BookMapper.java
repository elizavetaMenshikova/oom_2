package ru.menshikova.oom_2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.menshikova.oom_2.dto.BookDto;
import ru.menshikova.oom_2.entity.Book;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    BookDto map(Book book);
}