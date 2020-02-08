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
        </div>
        <div class="text-div">
            4月 12日
        </div>
    </div>
</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                url: undefined,
                // mobileImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img.jpg',
                mobileImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img_gallery.jpeg',
                desktopImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img_gallery.jpeg',
                // desktopImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/desktop_main_img.jpeg',
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
        margin: 20px 10% 35px 10%;
    }
    .text-div {
        font-size: 14px;
        font-weight: bold;
        text-align: center;
        color: #F56C6C;
    }
</style>