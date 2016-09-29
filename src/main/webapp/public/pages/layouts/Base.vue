<template>
    <div class="main" >
        <div class="top-bar">
            <top-bar></top-bar>
        </div>
        <div class="content">
            <div class="left-bar ng-cloak sidebar-container collapsible-sidebar">
                <left-bar></left-bar>
        </div>
        <div class="right-bar ng-cloak" >
            <div>
                <content-component></content-component>
            </div>
        </div>
    </div>

    </div>
</template>
<style>

</style>
<script>
    import LeftBar from './LeftBar.vue';
    import TopBar from './TopBar.vue';

    var vuename = window.vuewname || 'auth/SignIn.vue';

    export default{
        data(){
            return{
                msg:'hello vue'
            }
        },
        components:{
            'content-component': require('../'+ vuename),
            LeftBar, TopBar
        }

    }
</script>
