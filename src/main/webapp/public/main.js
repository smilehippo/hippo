import Vue from 'vue'
import Element from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import './assets/css/style.less'
//import App from './App.vue'
//var App = require('./App.vue'); // 返回的是一个组件，必须注册才能使用

//new Vue({
//  el: '#app',
//  render: h => h(App)
//});


Vue.use(Element);


new Vue({
  el: '#app',
  //render: h => {
  //  return h(App);
  //}
  render: h => {
    //var App = require('./App.vue');
    ////var App = require('' + pagename);
    //var pagename = window.vuewname || 'App';
    //var App = require('./' + pagename + '.vue');   // 一定要这样的结构,参考webpack dynamic require
    //console.log(App);
    //
    //var SignIn = require('./pages/auth/SignIn.vue')
    ////import App from './App.vue';
    //return h(App)

    var BaseVue = require('./pages/layouts/Base.vue');
    return h(BaseVue);
  }
});
