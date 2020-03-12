<template>
    <div>
        <div class="image-div">
            <router-link to="/episode/1">
                <el-image class="image-item"
                          v-bind:class="{desktop : isDesktop}"
                          :src="url"
                          fit="fill"
                          :lazy=true>
                    <div slot="error" class="image-slot">
                        <i class="el-icon-picture-outline"></i>
                    </div>
                </el-image>
            </router-link>
            <div class="text-div" style="font-size: 20px; margin-bottom: 15px;">
                강홍구 <p style="font-size: 9px; display: inline-block;">그리고</p> 최지현
            </div>
        </div>
        <div class="text-div" style="font-size: 13px; margin-bottom: 15px;">
            2020년 4월 12일 오후 2시
        </div>
        <div class="text-div" style="font-size: 13px; margin-bottom: 8px;">
            남산예술원 웨딩홀
        </div>
    </div>
</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                url: undefined,
                mobileImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img_gallery.jpeg',
                desktopImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img_gallery.jpeg',
                isDesktop: false,
            }
        },
        methods: {
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
        mounted() {
            this.determineImageUrl();
        },
    }
</script>

<style scoped>
    .desktop {
        width: 35%;
        height: 50%;
    }
    .image-div {
        text-align: center;
        margin: 0px 10% 35px 10%;
    }
    .text-div {
        font-size: 14px;
        font-weight: bold;
        text-align: center;
        color: #F56C6C;

    }
</style>