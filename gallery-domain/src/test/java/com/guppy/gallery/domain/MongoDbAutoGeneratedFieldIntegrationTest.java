package com.guppy.gallery.domain;

import com.guppy.gallery.repository.EpisodeRepository;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.SocketUtils;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MongoDbAutoGeneratedFieldIntegrationTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    private MongodExecutable mongodExecutable;

    @AfterEach
    void clean() {
        mongodExecutable.stop();
    }

    @BeforeEach
    void setup() throws Exception {
        String ip = "localhost";
        int randomPort = SocketUtils.findAvailableTcpPort();

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(ip, randomPort, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
//        mongoTemplate = new MongoTemplate(new MongoClient(ip, randomPort), "test");
    }

    @Test
    void givenEpisodeObject_whenSave_thenCreateNewEpisode(){
        // Given
        Episode episode = Episode.builder()
                .episodeName("첫번째 에피소드")
                .episodeDescription("구피 첫번째 에피소드")
                .build();

        // When
        episodeRepository.save(episode);

        // Then
        assertThat(episodeRepository.findAll().size()).isGreaterThan(0);
    }

}
