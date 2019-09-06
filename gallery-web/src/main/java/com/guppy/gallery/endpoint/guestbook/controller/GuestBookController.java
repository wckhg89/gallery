package com.guppy.gallery.endpoint.guestbook.controller;

import com.guppy.gallery.endpoint.guestbook.controller.dto.GuestBookDto;
import com.guppy.gallery.endpoint.guestbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbooks")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @PostMapping("")
    public ResponseEntity<String> postGuestBook (@RequestBody GuestBookDto body) {
        return ResponseEntity.ok(guestBookService.saveGuestBook(body));
    }

    @GetMapping()
    public ResponseEntity<Page<GuestBookDto>> getGuestBook (@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(guestBookService.getGuestBooks(pageable));
    }


}
