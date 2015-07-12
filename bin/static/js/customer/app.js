/**
 * Created by Administrator on 15-1-28.
 */
'use strict';
var xueyouApp=angular.module('xueyouApp',['ui.router']);
xueyouApp.config(function($stateProvider,$urlRouterProvider){
    $stateProvider.
        state('index', {
            url: "/index",
            template:"index",
        }).
        state('all',{
            url:"/all",
            template:"all",
            //controller:'terminalListCtrl'
        });
});

