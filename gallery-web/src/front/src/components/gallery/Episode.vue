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
    import {Waterfall, WaterfallItem} from 'vue2-waterfall';
    import _ from 'lodash';

    export default {
        name: "Episode",
        components: {
            Waterfall,
            WaterfallItem
        },
        data() {
            return {
                loading: true,
                episode : {},
            }
        },
        methods: {
            fetchData() {
                this.loading = true;
                this.$store.dispatch('getEpisode', this.$route.params.id).then(() => {
                    this.episode = this.$store.state.episode.episode;
                }).then(() => {
                    this.episode.images = _.shuffle(this.episode.images);
                });
                setTimeout(() => {
                    this.loading =false;
                }, 500);
            },
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
        -webkit-animation-duration: 3s;
        animation-duration: 3s;
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