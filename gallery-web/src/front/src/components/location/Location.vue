<template>
    <div class="block">
        <a href="https://d2i2o4t1c9odyj.cloudfront.net/location.jpeg" target="_blank">
            <el-image src="https://d2i2o4t1c9odyj.cloudfront.net/location.jpeg"/>
        </a>
        <el-divider/>
        <el-alert
                style="margin-bottom: 15px"
                title="지하철 이용시"
                type="info"
                description="6호선 한강진역 : 1번 출구 반대방향 - 도보 7분거리 / 1번출구 - 예식 1시간전 셔틀버스 운행 (10 ~ 15분 간격)"
                :closable="false"
                show-icon>
        </el-alert>

        <el-alert
                style="margin-bottom: 15px"
                title="버스 이용시"
                type="info"
                description="장충단길 입구 하차 - 간선 402, 405 (광화문 - 장지도 방향, 142, 420, 407 / 남산예술원 하차 - 402, 405 / 한강진역 하차 - 간선 110, 405 / 서울시 중부 기술 교육원 블루스퀘어 하차 - 간선 142, 144, 402, 407"
                :closable="false"
                show-icon>
        </el-alert>

        <el-alert
                style="margin-bottom: 15px"
                title="자가용 이용시"
                type="info"
                description="경부고속도로 - 한남대교에서 오실경우 : 경부고속도로 - 한남대교 - 한남5거리 - 북한남 삼거리 - 다산로에서 U턴 - 소월길 (하얏트 방향) - 남산맨션 바로 옆 남산예술원 웨딩홀"
                :closable="false"
                show-icon>
        </el-alert>

        <el-alert
                style="margin-bottom: 15px"
                title="주차안내"
                type="info"
                description="200여대 주차 가능"
                :closable="false"
                show-icon>
        </el-alert>
    </div>
</template>

<script>
    export default {
        name: 'Location',
        data() {
            return {
                guestBooks : [],
                loading: false
            }
        },
        computed: {

        },
        methods: {
            mounted() {
            },

            beforeRouteUpdate(to, from, next) {
                next();
            },
        }
    }
</script>

<style>
</style>
