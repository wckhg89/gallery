<template>
    <div class="image-div">
        <router-link to="/episode/1">
            <el-image class="image-item"
                      :src="url"
                      fit="fill"
                      :lazy=true>
                <div slot="error" class="image-slot">
                    <i class="el-icon-picture-outline"></i>
                </div>
            </el-image>
        </router-link>
    </div>

</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                url: undefined,
                mobileImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img.jpg',
                desktopImageUrl: 'https://d2i2o4t1c9odyj.cloudfront.net/main_img.jpg',
            }
        },
        methods: {
            isMobileAgent () {
                return /iPhone|iPod|Android/i.test(navigator.userAgent);

            },
            determineImageUrl() {
                if (this.isMobileAgent ()) {
                    this.url = this.mobileImageUrl;
                    return;
                }

                this.url = this.desktopImageUrl;
            }
        },
        mounted() {
            this.determineImageUrl();
        },
    }
</script>

<style scoped>
    .image-div {
        text-align: center;
        margin: 20px 10% 50px 10%;
    }
    .image-item {
        /*width: 100%;*/
    }
</style>