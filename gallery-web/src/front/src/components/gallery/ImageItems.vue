<template>
    <carousel style="margin-top: -20px"
            :scrollperPage="true"
            :per-page="1"
            :centerMode="true"
            :navigateTo="[$route.params.imageId, true]"
            :paginationEnabled="true"
            paginationPosition="top"
            :paginationPadding="5"
            :paginationSize="5"
            paginationColor="#909399"
            paginationActiveColor="#F56C6C"
            :minSwipeDistance=70
            :mouse-drag="true"
            :maxPaginationDotCount="5"
            @page-change="onPageChange"
    >
        <slide v-for="item in images">
            <div class="image">
                <el-image :src="item.src"
                          v-bind:class="{desktop : isDesktop}"
                          fit="scale-down">
                    <div slot="error" class="image-slot">
                        <i class="el-icon-picture-outline"></i>
                    </div>
                </el-image>
            </div>
            <el-divider></el-divider>
            <div>
                <el-badge :value="item.likeCount" :max="99">
                    <el-tooltip class="item"
                                effect="light"
                                :content="getRandomLikeContents()"
                                :hide-after=2000
                                placement="right-start">

                        <el-image src="https://d2i2o4t1c9odyj.cloudfront.net/flower_image.png"
                                  style="width:25px;height:25px"
                                  class="infinite_rotating_logo"
                                  @click="saveData(item.index)"
                        />
                    </el-tooltip>
                </el-badge>
                <div style="margin-top: 15px">
                    <span class="tag" v-for="hashTag in item.hashTags">
                        {{hashTag}}
                    </span>
                </div>
                <div class="tip">
                    <p>{{item.description}}</p>
                </div>
            </div>
            <div style="float: right;">
                <el-button icon="el-icon-back" circle size='mini' @click="back"></el-button>
            </div>
        </slide>
    </carousel>
</template>

<script>
    import {Carousel, Slide} from 'vue-carousel-guppy';

    export default {
        components: {
            Carousel,
            Slide
        },
        name: "ImageItems",
        data() {
            return {
                likeContents : [
                    '사진 예뻐요!',
                    '보기 좋아요!',
                    '행복하세요!',
                    '예뻐 보여요!',
                    '잘 어울려요!',
                    '행복한 신혼되세요!',
                ],
                loading: true,
                images: [],
                isDesktop: false,
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

            saveData(itemIndex) {
                this.loading = true;
                this.$store.dispatch('saveEpisodeDetail', {
                    episodeId : this.$route.params.episodeId,
                    imageId : itemIndex
                }).then(() => {
                    this.fetchData();
                });
            },

            onPageChange (currentPage) {
                this.$router.push({
                    path : '/episode/' + this.$route.params.episodeId + '/images/' + currentPage
                })
            },

            getRandomLikeContents () {
                return this.likeContents[Math.floor(Math.random() * this.likeContents.length)];
            },
            back () {
                this.$router.push({
                    path : '/episode/' + this.$route.params.episodeId
                })
            },
            isMobileAgent () {
                return /iPhone|iPod|Android/i.test(navigator.userAgent);

            },
            determineImageUrl() {
                if (this.isMobileAgent ()) {
                    this.url = this.mobileImageUrl;
                    this.isDesktop = false;
                    return;
                }

                this.url = this.desktopImageUrl;
                this.isDesktop = true;
            }

        },

        beforeRouteUpdate(to, from, next) {
            next();
            this.fetchData();
            this.determineImageUrl();
        },

        mounted() {
            this.fetchData();
            this.determineImageUrl();
        },
    }
</script>

<style scoped>
    .desktop {
        width: 60%;
        height: 100%;
    }

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

    .infinite_rotating_logo{
        animation: rotate_image 5s linear infinite;
        transform-origin: 50% 50%;
    }

    @keyframes rotate_image{
        100% {
            transform: rotate(360deg);
        }
    }
</style>