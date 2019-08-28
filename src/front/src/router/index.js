import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../layout/Layout'
import Episode from "../components/gallery/Episode";
import ImageItems from "../components/gallery/ImageItems";
import GuestBook from '../components/GuestBook'

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        component: Layout,
        children: [
            {
                path: 'episode/:id',
                component: Episode,
            },
            {
                path: 'images/:id',
                component: ImageItems,
            },
            {
                path: 'guestbook',
                component: GuestBook
            },
        ]
    },

];

const router = new VueRouter({
    routes
});

export default router

