package com.guppy.gallery.endpoint.guestbook.service;

import com.guppy.gallery.domain.GuestBook;
import com.guppy.gallery.endpoint.guestbook.controller.dto.GuestBookDto;
import com.guppy.gallery.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public String saveGuestBook(GuestBookDto dto) {
        GuestBook entity = guestBookRepository.save(GuestBook.builder()
                .content(dto.getContent())
                .build());

        return entity.getId();
    }

    public Page<GuestBookDto> getGuestBooks(Pageable pageable) {
        Page<GuestBook> guestBookPage = guestBookRepository.findAll(pageable);

        List<GuestBookDto> guestBookDtos = guestBookPage.getContent().stream()
                .map(it -> GuestBookDto.builder()
                        .content(it.getContent())
                        .createdDate(it.getCreatedDate())
                        .build())
                .collect(toList());

        return new PageImpl<>(guestBookDtos, pageable, guestBookPage.getTotalElements());

    }
}
