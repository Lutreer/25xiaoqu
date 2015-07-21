/**
 * Created by lxuidesigner@gmail.com 2015-07-15.
 */
'use strict';
var cumtControllers=angular.module('cumtControllers',['cumtServices']);
/**
 * 
 */
cumtControllers.controller('cumtExcelDataCtrl',['$scope','$upload','cumtExcelDataFactory',function($scope,$upload,cumtExcelDataFactory){
	$scope.randomError=true;
	$scope.noFileError=false;
	
	
	/**
	 * 赋值modifyDate
	 */
	$scope.datetimeModel = function(){
		$scope.modifyDate = $("#dtp_input").val();
	}
	
	/**
	 * 随机数大小验证
	 */
	$scope.randomValid = function() {
		$scope.randomError=true;
		if($scope.randomMin != undefined && $scope.randomMax != undefined){
			if(($scope.randomMax-$scope.randomMin)<0) {
				$scope.randomError=true;
			}else{
				$scope.randomError=false;
			}
		}
	}
	/**
	 * 关闭nofile alert
	 */
	$scope.noFileErrorClose = function() {
		$scope.noFileError=false;
	}
	
	/**
	 * 上传文件
	 */
	 $scope.uploadExcel=function(myFile){
		 $scope.noFileError=false;
		 
		 var paramData={modifyDate:$scope.modifyDate,randomMin:$scope.randomMin,randomMax:$scope.randomMax};
         if(myFile!=null){
             $scope.upload=$upload.upload({
                 url:'/cumt/lrjexceldata',
                 method:'POST',
                 header:{
                     "Content-Type":"multipart/form-data"
                 },
                 fields:{params:JSON.stringify(paramData)},
                 file:myFile
             }).success(function(data,status){
                     if(status==200){
                    	 $scope.filePath = data.errorMessage;
                     }else{
                    	 $scope.ExpError = data.errorMessage;
                     }
                 }).error(function(data){
                 })
         }else{
        	 $scope.noFileError=true;
        	 return;
         }
     };
}]);