<template>
    <div class="main" >
        <div class="top-bar">
            <div>Top Bar</div>
        </div>
        <div class="content">
            <div class="left-bar ng-cloak sidebar-container collapsible-sidebar">
                <div>Left Bar</div>
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
    var vuename = window.vuewname || 'auth/SignIn.vue';

    export default{
        data(){
            return{
                msg:'hello vue'
            }
        },
        components:{
            'content-component': require('../'+ vuename)
        }

    }
</script>
