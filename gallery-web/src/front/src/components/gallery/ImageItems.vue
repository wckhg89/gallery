<template>
    <carousel :per-page="1"
              :centerMode="false"
              :navigateTo="parseInt($route.params.imageId)"
              :paginationEnabled="true"
              paginationActiveColor="#F56C6C"
              paginationColor="#909399"
              paginationPosition="bottom-overlay"
              :mouse-drag="true">
        <slide v-for="item in images">
            <div class="image">
                <el-image :src="item.src"
                          :imageHeight="carouselHeight"
                          fit="fill">
                    <div slot="error" class="image-slot">
                        <i class="el-icon-picture-outline"></i>
                    </div>
                </el-image>
            </div>
            <div>
                <span class="tag" v-for="hashTag in item.hashTags">
                    {{hashTag}}
                </span>
            </div>
            <el-divider></el-divider>
            <div>
                <div class="item">{{item.index + 1}}번째, 사진</div>
                <div class="tip">
                    <p>{{item.description}}</p>
                </div>
            </div>
        </slide>
    </carousel>
</template>

<script>
    import {Carousel, Slide} from 'vue-carousel';

    export default {
        components: {
            Carousel,
            Slide
        },
        name: "ImageItems",
        data() {
            return {
                loading: true,
                images: [],
                carouselHeight: undefined
            }
        },
        methods: {
            fetchData() {
                this.loading = true;
                this.$store.dispatch('getEpisodeDetail', this.$route.params.episodeId).then(() => {
                    this.images = this.$store.state.episode.detail.images;
                });

                setTimeout(() => {
                    this.loading = false;
                }, 500);
            },
        },

        beforeRouteUpdate(to, from, next) {
            next();
            this.fetchData();
        },

        mounted() {
            this.fetchData();
        },
    }
</script>

<style scoped>
    .image {
        text-align: center;
    }

    .tip {
        padding: 10px 15px;
        opacity: 0.8;
        background-color: #ffffff;
        border-radius: 4px;
        border-left: 5px solid #F56C6C;
        margin: 10px 0;
        font-size: 12px;
        line-height: 2.0em;
    }

    .tag {
        color: #F56C6C;
        font-size: 13px;
    }

    .item {
        opacity: 0.8;
        color: #F56C6C;
        font-size: 13px;
        line-height: 1.5em;
    }
</style>