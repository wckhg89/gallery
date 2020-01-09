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
                <div class="item">
                    #일상 #몰랏 #펭하
                </div>
                <el-divider></el-divider>
                <div>
                    <div class="item">{{item.index}}번째, 사진</div>
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
                images: [],
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

            fetchData() {
                this.loading = true;
                this.$store.dispatch('getEpisodeDetail', this.$route.params.episodeId).then(() => {
                    this.images = this.$store.state.episode.detail.images;
                });

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
            next();
            this.fetchData();
        },

        mounted() {
            this.fetchData();
        },

        updated() {
            this.setActiveItem(this.$route.params.imageId);
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