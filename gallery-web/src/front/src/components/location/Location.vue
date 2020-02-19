<template>
    <div class="block">
        만드는중...
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
