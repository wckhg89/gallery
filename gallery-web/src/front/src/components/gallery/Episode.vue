<template>
    <div :v-loading=loading>
        <Waterfall :gutterWidth="10" :minCol="1" :maxCol="5" :gutterHeight="10">
            <WaterfallItem v-for="item in episode.images" :key="item.idx" :width="250" class="item fadeIn animated">
                <router-link :to="item.imagePath">
                    <img :src="item.src" alt="이미지 없음">
                </router-link>
            </WaterfallItem>
        </Waterfall>
    </div>
</template>

<script>
    import _ from 'lodash';
    import {Waterfall, WaterfallItem} from 'vue2-waterfall';

    export default {
        name: "Episode",
        components: {
            Waterfall,
            WaterfallItem
        },
        data() {
            return {
                loading: true,
                episode : {
                    episodeId: '1',
                    episodeName: '에피소드 1',
                    episodeDescription: '첫번째 에피소드 이야기가 시작되었습니다... 재밌는 관람되세요',
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
                    ]
                },
            }
        },
        methods: {
            fetchData() {
                this.loading = true;
                // TODO : API 호출
                this.shuffle();
                setTimeout(() => {
                    this.loading =false;
                }, 500);
            },

            shuffle: function () {
                this.episode.images = _.shuffle(this.episode.images)
            }
        },

        beforeRouteUpdate (to, from, next) {
            next();
            this.fetchData();
        },

        mounted() {
            this.fetchData();
        },




    }
</script>

<style scoped>
    * {
        padding: 0;
        margin: 0;
    }
    .item img {
        border-radius: 5px;
        width: 100%;
        display: block;
        transition: transform .5s cubic-bezier(.55,0,.1,1);
    }
    @-webkit-keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 10;
        }
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 10;
        }
    }

    .animated {
        -webkit-animation-duration: 2s;
        animation-duration: 2s;
        -webkit-animation-fill-mode: both;
        animation-fill-mode: both;
        -webkit-animation-direction: normal;
        animation-direction: normal;
    }
    .fadeIn {
        -webkit-animation-name: fadeIn;
        animation-name: fadeIn;
    }
</style>