<template>
    <div v-loading="loading">
        <el-carousel indicator-position="none" arrow='always'
                     :autoplay="false"
                     :height=carouselHeight
        >
            <el-carousel-item v-for="item in episode.images">
                <div v-if="item.idx === 0">
                    <div style="font-size: 18px;">
                        {{item.episodeName}}
                    </div>
                    <br>
                    <div style="font-size: 14px;">
                        {{item.episodeDescription}}
                    </div>
                    <br>
                    <el-row :gutter="20">
                        <el-col :span="6">
                            <el-image src="https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg" fit="fill">
                                <div slot="error" class="image-slot">
                                    <i class="el-icon-picture-outline"></i>
                                </div>
                            </el-image>
                        </el-col>
                        <el-col :span="6">
                            <el-image src="https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com" fit="fill">
                                <div slot="error" class="image-slot">
                                    <i class="el-icon-picture-outline"></i>
                                </div>
                            </el-image>


                        </el-col>
                        <el-col :span="6">

                        </el-col>
                        <el-col :span="6">

                        </el-col>
                    </el-row>
                </div>
                <div v-else>
                    <div class="image">
                        <el-image :src="item.src" fit="fill">
                            <div slot="error" class="image-slot">
                                <i class="el-icon-picture-outline"></i>
                            </div>
                        </el-image>
                    </div>
                    <el-divider></el-divider>
                    <div>
                        <div class="item">{{item.idx}}번째, 사진</div>
                        <div class="tip">
                            <p>{{item.description}}</p>
                        </div>
                    </div>
                </div>
            </el-carousel-item>
        </el-carousel>
    </div>
</template>

<script>
    export default {
        name: "gallery",
        data() {
            return {
                loading: true,
                episode : {},
                episodes: [
                    {
                        episodeId: '1',
                        episodeName: '에피소드 1',
                        episodeDescription: '첫번째 에피소드 <br> 이야기가 시작되었습니다...<Br> 재밌는 관람되세요',
                        images: [
                            {
                                idx: 0,
                                episodeName: '에피소드 1',
                                episodeDescription: '첫번째 에피소드 이야기가 시작되었습니다.'
                            },
                            {
                                idx: 1,
                                src: 'https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                                description: '구피 에피소드가 시작되었습니다.'
                            },
                            {
                                idx: 2,
                                src: 'https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg',
                                description: '구피 에피소드가 시작되었습니다.'
                            }
                        ]
                    },

                    {
                        episodeId: '2',
                        episodeName: '에피소드 2',
                        episodeDescription: '두번째 에피소드',
                        images: [
                            {
                                idx: 0,
                                episodeName: '에피소드 2',
                                episodeDescription: '두번째 에피소드 이야기가 시작되었습니다.'
                            },
                            {
                                idx: 1,
                                src: 'https://scontent-icn1-1.cdninstagram.com/vp/0cb1aed7cadd01b43c7f8d65798e5069/5D9E4489/t51.2885-15/e35/s1080x1080/61732892_117967372786017_8100812512451939522_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                                description: '구피 에피소드가 시작되었습니다.'
                            },
                            {
                                idx: 2,
                                src: 'https://scontent-icn1-1.cdninstagram.com/vp/d5070ec5a98e443a164c42d7d736c756/5D8E4EA5/t51.2885-15/e35/c180.0.1080.1080/s480x480/60112483_291828271705444_7181663474819714157_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                                description: '구피 에피소드가 시작되었습니다.'
                            }
                        ]
                    }
                ],
                srcs : [
                    'https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                    'https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg',
                ],
                carouselHeight : undefined,
            }
        },


        methods: {
            isMobileAgent () {
                return /iPhone|iPod|Android/i.test(navigator.userAgent);

            },

            resizeLayout() {
                if (this.isMobileAgent ()) {
                    this.carouselHeight = window.innerHeight + 150 + 'px';
                    return;
                }
                this.carouselHeight = window.innerHeight + 300 + 'px';
            },

            fetchData(episodeId) {
                this.loading = true;
                // TODO : API 호출
                this.episode = this.episodes[episodeId - 1];
                setTimeout(() => {
                    this.resizeLayout();
                    this.loading =false;
                }, 500);
            },

            prev() {
                console.log('prev');
                // this.setActiveItem(this.activeIndex - 1);
            },

            next() {
                console.log('next');
                // this.setActiveItem(this.activeIndex + 1);
            },
        },

        beforeRouteUpdate (to, from, next) {
            next();
            this.fetchData(this.$route.params.id);
        },

        created() {
            this.fetchData(this.$route.params.id);
        },

    }

</script>

<style>
    .el-carousel__arrow{
        top: 30% !important;
    }

    .image {
        text-align: center;
    }
    .tip {
        padding: 5px 15px;
        opacity: 0.8;
        background-color: #fffff;
        border-radius: 4px;
        border-left: 5px solid #F56C6C;
        margin: 10px 0;
        font-size: 12px;
        line-height: 2.0em;
    }
    .item {
        opacity: 0.8;
        color: #F56C6C;
        font-size: 13px;
        line-height: 1.5em;
    }


</style>