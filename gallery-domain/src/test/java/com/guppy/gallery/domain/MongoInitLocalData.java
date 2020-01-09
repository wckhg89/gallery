package com.guppy.gallery.domain;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guppy.gallery.repository.EpisodeRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MongoInitLocalData {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    void insertLocalData() throws JsonProcessingException {
        // Given
        Episode episode1 = Episode.builder()
                .episodeName("에피소드 1")
                .episodeDescription("첫번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 첫번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 1, 두번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 세번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 네번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 다섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 여섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 일곱번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 여덟번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 1, 아홉번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build()

                ))
                .build();

        Episode episode2 = Episode.builder()
                .episodeName("에피소드 2")
                .episodeDescription("두번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 첫번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 2, 두번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 세번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 네번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 다섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 여섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 일곱번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 여덟번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 2, 아홉번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build()

                ))
                .build();

        Episode episode3 = Episode.builder()
                .episodeName("에피소드 3")
                .episodeDescription("세번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 첫번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 3, 두번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 세번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 네번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 다섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 여섯번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 일곱번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 여덟번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build(),
                        Episode.Image.builder()
                                .src("http://img.asiatoday.co.kr/file/2019y/12m/18d/20191218000648094_1576619551_1.jpg?1576619551")
                                .description("에피소드 3, 아홉번째 사진")
                                .hashTags(Lists.newArrayList("#펭하", "펭수", "펭성"))
                                .build()

                ))
                .build();
        // When
        episodeRepository.save(episode1);
        episodeRepository.save(episode2);
        episodeRepository.save(episode3);

        // Then
        List<Episode> all = episodeRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(all);
        System.out.println(s);
        assertThat(all).isNotEmpty();
    }
}
