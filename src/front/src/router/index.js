import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../layout/Layout'
import GuestBook from '../components/GuestBook'
import Gallery from "../components/Gallery";

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        component: Layout,
        children: [
            {
                path: 'episode/:id',
                component: Gallery
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

