 /**
  * 封装公共alert、confirm消息
  * author:liguangqiang
  * alert使用方式：
  *     四个选项都是可选参数
  *	    Message.alert(
  *			  {
  *			    msg: '内容',
  *			    title: '标题',
  *			    btnok: '确定',
  *			    btncl:'取消'
  *		      },
  *		      'success'
  *	    );
  * 
  * confirm使用方式：
  *   如需增加回调函数，后面直接加 .on( function(e){} );
  *	  点击"确定" e: true
  *	  点击"取消" e: false
  *	  Message.confirm(
  *		  {
  *		    msg: "是否删除角色？"
  *		  })
  *		 .on( function (e) {
  *		    alert("返回结果：" + e);
  *	   }); 
  */
 window.Message = function (){
    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
    var alr = $("#alert_dialog");
    var ahtml = alr.html();
    /**
     * alert消息封装
     * options:提醒消息对象依次包含提醒标题(title)、提醒内容(content)、ok按钮名称、cancel按钮名称(alert消息时不显示)
     * type:提醒消息类型
     */
    var _alert = function (options,type,WindowResizer) {
	      alr.html(ahtml);	// 复原
	      $("#dialog_ok_button").removeClass('btn-success').addClass('btn-primary');
	      $("#dialog_cancel_button").hide();
	      //设置窗口样式
	      if(type == null || type == '' || type == undefined || type == 'success'){
	    	  $("#dialog_header").removeClass("dialog_warn,dialog_error").addClass("dialog_success");
	      }else if(type == 'warn'){
	    	  $("#dialog_header").removeClass("dialog_success,dialog_error").addClass("dialog_warn");
	      }else if(type == 'error'){
	    	  $("#dialog_header").removeClass("dialog_warn,dialog_success").addClass("dialog_error");
	      }else{
	    	  $("#dialog_header").removeClass("dialog_warn,dialog_error").addClass("dialog_success");
	      }
	      //设置窗口大小
	      if(WindowResizer == null || WindowResizer == '' || WindowResizer == undefined ){
	    	  $('#alert_dialog').removeClass("bs-example-modal-lg").addClass("bs-example-modal-sm");
	    	  $('#modal_dialog').removeClass("modal-lg").addClass("modal-sm");
	      }else if(WindowResizer == 'big'){
	    	  $('#alert_dialog').removeClass("bs-example-modal-sm").addClass("bs-example-modal-lg");
	    	  $('#modal_dialog').removeClass("modal-sm").addClass("modal-lg");	    	  
	      }else if(WindowResizer == 'general'){
	    	  $('#alert_dialog').removeClass("bs-example-modal-sm,bs-example-modal-lg");
	    	  $('#modal_dialog').removeClass("modal-sm,modal-lg");	    	  	    	  
	      }else{
	    	  $('#alert_dialog').removeClass("bs-example-modal-lg").addClass("bs-example-modal-sm");
	    	  $('#modal_dialog').removeClass("modal-lg").addClass("modal-sm");
	      }
	      _dialog(options);
	      return {
		        on: function (callback) {
			          if (callback && callback instanceof Function) {
			        	  $("#dialog_ok_button").click(function () { callback(true) });
			          }
		        }
	      };
    };

    var _confirm = function (options) {
      alr.html(ahtml); // 复原
      $("#dialog_ok_button").removeClass('btn-primary').addClass('btn-success');
      $("#dialog_cancel_button").show();
      _dialog(options);

      return {
        on: function (callback) {
          if (callback && callback instanceof Function) {
        	  $("#dialog_ok_button").click(function () { callback(true) });
        	  $("#dialog_cancel_button").click(function () { callback(false) });
          }
        }
      };
    };

    var _dialog = function (options) {
	      var ops = {
	        msg: "提示内容",
	        title: "操作提示",
	        btnok: "确定",
	        btncl: "取消"
	      };
	
	      $.extend(ops, options);
	      var html = alr.html().replace(reg, function (node, key) {
	         return {
		          Title: ops.title,
		          Message: ops.msg,
		          BtnOk: ops.btnok,
		          BtnCancel: ops.btncl
	         }[key];
	      });
	      
	      alr.html(html);
	      alr.modal({
	        width: 500,
	        backdrop: 'static'
	      });
	    }
	    return {
	      alert: _alert,
	      confirm: _confirm
	    }
  }();

  /**
   * 判断数组中是否包含元素
   */
  Array.prototype.contains = function(e)  
  {  
	  for(i=0;i<this.length;i++)  
	  {  
		  if(this[i] == e)  
		  return true;  
	  }  
	  return false;  
  }  
  
  /**
   * 添加toggle方法。jquery 1.9 以上（含）去除了toggle方法
   */
  $.fn.toggle = function( fn ) {
	    var args = arguments,
	            guid = fn.guid || jQuery.guid++,
	            i = 0,
	            toggler = function( event ) {
	                var lastToggle = ( jQuery._data( this, "lastToggle" + fn.guid ) || 0 ) % i;
	                jQuery._data( this, "lastToggle" + fn.guid, lastToggle + 1 );
	                event.preventDefault();
	                return args[ lastToggle ].apply( this, arguments ) || false;
	            };

	    toggler.guid = guid;
	    while ( i < args.length ) {
	        args[ i++ ].guid = guid;
	    }
	    return this.click( toggler );
	}