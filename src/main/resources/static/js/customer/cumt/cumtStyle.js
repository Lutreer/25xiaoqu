/**
 * Created by lxuidesigner@gmail.com 2015-07-15.
 */
$('#form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 0,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
});/*.on("hide",function(){
	   var $this = $(this);
	   var _this = this;
	   debugger;
	   scope.$apply(function(){
	       scope[$this.attr('ng-model')] = _this.value;
	   });
});*/