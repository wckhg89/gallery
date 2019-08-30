package com.guppy.gallery.domain;


import com.guppy.gallery.repository.EpisodeRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Disabled
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MongoInitLocalData {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    void insertLocalData() {
        // Given
        Episode episode1 = Episode.builder()
                .episodeName("에피소드 1")
                .episodeDescription("첫번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 첫번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 1, 두번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1a454fa086b52c8bc5705cfc1febcb12/5E163841/t51.2885-15/e35/67265894_2196419753813842_3309289979546300510_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 세번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 네번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 다섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/d65ded423b55bc8273a8414a4a3203e8/5E0EF7A6/t51.2885-15/e35/c0.135.1080.1080a/s480x480/67116427_464279264425410_5842404989653491596_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 여섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 일곱번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 여덟번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/09159b3aa95ac5494fb3c3083d61de00/5DF4F9A4/t51.2885-15/e35/c181.0.718.718a/s480x480/52136347_407321186745294_5370537407788102545_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 1, 아홉번째 사진")
                                .build()

                ))
                .build();

        Episode episode2 = Episode.builder()
                .episodeName("에피소드 2")
                .episodeDescription("두번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 첫번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 2, 두번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1a454fa086b52c8bc5705cfc1febcb12/5E163841/t51.2885-15/e35/67265894_2196419753813842_3309289979546300510_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 세번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 네번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 다섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/d65ded423b55bc8273a8414a4a3203e8/5E0EF7A6/t51.2885-15/e35/c0.135.1080.1080a/s480x480/67116427_464279264425410_5842404989653491596_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 여섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 일곱번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 여덟번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/09159b3aa95ac5494fb3c3083d61de00/5DF4F9A4/t51.2885-15/e35/c181.0.718.718a/s480x480/52136347_407321186745294_5370537407788102545_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 2, 아홉번째 사진")
                                .build()

                ))
                .build();

        Episode episode3 = Episode.builder()
                .episodeName("에피소드 3")
                .episodeDescription("세번째, 에피소드")
                .images(Lists.newArrayList(
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 첫번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg")
                                .description("에피소드 3, 두번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/1a454fa086b52c8bc5705cfc1febcb12/5E163841/t51.2885-15/e35/67265894_2196419753813842_3309289979546300510_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 세번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 네번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 다섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/d65ded423b55bc8273a8414a4a3203e8/5E0EF7A6/t51.2885-15/e35/c0.135.1080.1080a/s480x480/67116427_464279264425410_5842404989653491596_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 여섯번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 일곱번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/cb54b55381e62a36bf087b96185a7004/5DFBBA8A/t51.2885-15/e35/c180.0.720.720a/s480x480/66802926_1619524424850511_1511894292999927730_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 여덟번째 사진")
                                .build(),
                        Episode.Image.builder()
                                .src("https://scontent-icn1-1.cdninstagram.com/vp/09159b3aa95ac5494fb3c3083d61de00/5DF4F9A4/t51.2885-15/e35/c181.0.718.718a/s480x480/52136347_407321186745294_5370537407788102545_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com")
                                .description("에피소드 3, 아홉번째 사진")
                                .build()

                ))
                .build();
        // When
        episodeRepository.save(episode1);
        episodeRepository.save(episode2);
        episodeRepository.save(episode3);

        // Then
    }
}
