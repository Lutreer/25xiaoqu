/**
 * 侧边导航
 * 
 */
xueyouApp.directive('leftnav', function () {
    return {
    	restrict:"E",
    	transclude:true,
    	replace:true,
    	templateUrl:"templates/commonTemplate/left-nav.html"
    };
});
xueyouApp.directive('footerHeight', function () {
	return {
		restrict: 'A',
		link: function(scope, element, attrs) {
			element.bind('focus', function() {
				var $this = element;
				$this.height("200px");
				
            });
    }
  };
});
