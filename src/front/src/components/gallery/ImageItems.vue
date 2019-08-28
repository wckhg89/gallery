<template>
    <el-carousel indicator-position="none" arrow='always' ref='carousel'
                 :autoplay="false"
                 :height=carouselHeight
                 :v-loading=loading
    >
        <el-carousel-item v-for="item in images">
            <div>
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
</template>

<script>
    export default {
        name: "ImageItems",
        data() {
            return {
                loading: true,
                images: [
                    {
                        idx: 0,
                        imagePath: '/images/0',
                        src: 'https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
                    {
                        idx: 1,
                        imagePath: '/images/1',
                        src: 'https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
                    {
                        idx: 2,
                        imagePath: '/images/2',
                        src: 'https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
                    {
                        idx: 3,
                        imagePath: '/images/3',
                        src: 'https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
                    {
                        idx: 4,
                        imagePath: '/images/4',
                        src: 'https://scontent-icn1-1.cdninstagram.com/vp/1782fdd7bc3f6439466d7fa737a8d83e/5D79BD3D/t51.2885-15/sh0.08/e35/c241.0.958.958/s640x640/62488373_344306422940407_669355289448940413_n.jpg?_nc_ht=scontent-icn1-1.cdninstagram.com',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
                    {
                        idx: 5,
                        imagePath: '/images/5',
                        src: 'https://cdn.crowdpic.net/detail-thumb/thumb_d_DD777EE609B31484BA8CB75F19EA6BBF.jpg',
                        description: '구피 에피소드가 시작되었습니다.'
                    },
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
                setTimeout(() => {
                    this.resizeLayout();
                    this.loading =false;
                }, 500);
            },

            setActiveItem(idx) {
                this.$refs.carousel.setActiveItem(idx);
            }
        },


        beforeRouteUpdate (to, from, next) {
            console.log('beforeRouteUpdate');
            next();
            this.fetchData();
        },


        mounted() {
            this.fetchData();
        },

        // 절대로 값 변경 노우노
        updated() {
            console.log('updated', this.$refs);
            this.setActiveItem(this.$route.params.id);
        }


    }
</script>

<style scoped>
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