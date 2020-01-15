<template>
    <div class="image-div">
        <el-card :body-style="{ padding: '0px' }">
            <router-link to="/episode/2">
                <el-image class="image-item"
                          :src="url"
                          fit="fill"
                          :lazy=true>
                    <div slot="error" class="image-slot">
                        <i class="el-icon-picture-outline"></i>
                    </div>
                </el-image>
            </router-link>
        </el-card>
    </div>

</template>

<script>
    export default {
        name: "Main",
        data() {
            return {
                url: undefined,
                mobileImageUrl: 'https://pbs.twimg.com/media/DVjusPvU0AAMGbX.jpg',
                desktopImageUrl: 'https://post-phinf.pstatic.net/MjAxOTAzMTlfMTAg/MDAxNTUyOTg5NTUzNjMy.EtBilxTG3zh5354ed6Zokv9p1z6DyEpnA-P-G0DI9_Ug.yLCoGj8HYW2Knnce-j871DYhvS7dTL0w2RCRhnFX0A8g.JPEG/BBUU5kz-horz.jpg?type=w1200',
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
        margin: 10px 10% 10px 10%;

    }
    .image-item {
        width: 100%;
    }
</style>