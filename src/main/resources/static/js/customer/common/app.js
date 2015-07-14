/**
 * Created by Administrator on 15-1-28.
 */
'use strict';
var xueyouApp=angular.module('xueyouApp',['ui.router']);
xueyouApp.config(function($stateProvider,$urlRouterProvider){
	$urlRouterProvider.otherwise("/index");
    $stateProvider.
        state('index', {
            url: "/index",
            template:"indexsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
        }).
        state('cumtLrjExcelData001',{
            url:"/cumtLrjExcelData001",
            templateUrl:"templates/terminal/terminal-list.html",
            //controller:'terminalListCtrl'
        });
});

