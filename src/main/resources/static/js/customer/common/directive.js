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
/*xueyouApp.directive('footerHeight', function () {
	return {
		restrict: 'AE',
		link: function(scope, element, attrs) {
			element.bind('focus', function() {
				debugger;
				var $this = element;
				$this.height("200px");
				
            });
    }
  };
});
*/