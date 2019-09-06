package com.guppy.gallery.repository;

import com.guppy.gallery.domain.GuestBook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestBookRepository extends MongoRepository<GuestBook, String> {
}
