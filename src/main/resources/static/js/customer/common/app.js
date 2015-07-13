/**
 * Created by Administrator on 15-1-28.
 */
'use strict';
var xueyouApp=angular.module('xueyouApp',['ui.router','ui.bootstrap']);
xueyouApp.config(function($stateProvider,$urlRouterProvider){
	$urlRouterProvider.otherwise("/index");
    $stateProvider.
        state('index', {
            url: "/index",
            template:"indexsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
        }).
        state('all',{
            url:"/all",
            template:"all",
            //controller:'terminalListCtrl'
        });
});

