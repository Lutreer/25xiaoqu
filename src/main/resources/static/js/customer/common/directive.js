/**
 * 侧边导航
 * 
 */
xueyouApp.directive('applist', function () {
    return {
    	restrict:"E",
    	transclude:true,
    	replace:true,
    	templateUrl:"templates/commonTemplate/app-list.html"
    };
});
/*myApp.directive('validFile', function () {
    return {
        require: 'ngModel',
        link: function (scope, el, attrs, ngModel) {
            ngModel.$render = function () {
                ngModel.$setViewValue(el.val());
            };

            el.bind('change', function () {
                scope.$apply(function () {
                    ngModel.$render();
                });
            });
        }
    };
});*/
/*xueyouApp.directive('datetimepicker', function () {
	return {
		restrict: 'ngModel',
		link: function(scope, element, attrs,ngModel) {
			element.bind('change', function() {
				debugger
				 ngModel.$setViewValue($("#dtp_input").val());
            });
    }
  };
});*/
/*xueyouApp.directive('datetimepicker', function() {
	  return {
	    require: 'ngModel',
	    link: function(scope, element, attr, ngModel) {
	      $(element).datepicker({
	        onSelect: function(dateText) {
	          scope.$apply(function() {
	            ngModel.$setViewValue(dateText);
	          });
	        }
	      });
	    }
	  };
	});*/
