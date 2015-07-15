/**
 * Created by lxuidesigner@gmail.com 2015-07-15.
 */
'use strict';
var cumtService=angular.module('cumtServices',['ngResource']);
var cumtUrl = '/';
cumtService.factory('cumtExcelDataFactory',function($resource){
   var cumtExcelDataFactory;
   cumtExcelDataFactory=$resource(cumtUrl,{},{

    });
    return cumtExcelDataFactory;
});