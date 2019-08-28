package com.guppy.gallery.repository;

import com.guppy.gallery.domain.Episode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EpisodeRepository extends MongoRepository<Episode, Long> {
}
