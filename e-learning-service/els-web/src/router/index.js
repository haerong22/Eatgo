import {createRouter, createWebHistory} from 'vue-router'
import LoginPage from "@/pages/LoginPage.vue";
import CoursePage from "@/pages/CoursePage.vue";
import PurchasePage from "@/pages/PurchasePage.vue";
import CourseDetailPage from "@/pages/CourseDetailPage.vue";

const routes = [
    {path: '/', component: LoginPage},
    {path: '/courses', component: CoursePage},
    {path: '/course/:id', component: CourseDetailPage},
    {path: '/purchase/:id', component: PurchasePage},
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;