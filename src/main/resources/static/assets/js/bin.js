// 设置jQuery Ajax全局错误catch
$.ajaxSetup({
    type: "POST",
    error: function (jqXHR, textStatus, errorThrown) {
        switch (jqXHR.status) {
            case(500):
                errorCheckOnOffLine(true,jqXHR,"500");
                break;
            case(400):
                errorCheckOnOffLine(true,jqXHR,"400");
                break;
            case(401):
                errorCheckOnOffLine(true,jqXHR,"401");
                break;
            case(403):
                errorCheckOnOffLine(true,jqXHR,"403");
                break;
            case(404):
                errorCheckOnOffLine(false,jqXHR,"404");
                break;
            case(408):
                errorCheckOnOffLine(false,jqXHR,"408");
                break;
            case(518):
                errorCheckOnOffLine(false,jqXHR,"518");
                break;
            case(501):
                errorCheckOnOffLine(false,jqXHR,"501");
                break;
            case(200):
                errorCheckOnOffLine(false,jqXHR,"200");
                break;
            default:
                error();
        }
        $.AMUI.progress.done();
    }
});

/**
 * 执行错误提示
 * @param mode 为true时 在线提示错误
 * @param jqXHR
 * @param code
 */
function errorCheckOnOffLine(mode,jqXHR,code) {
    if (jqXHR.status == 500){
        alert("挂了,挂了,朕的服务挂了,大清亡了!");
        return;
    }
    if (jqXHR.status == 200 && jqXHR.responseText.indexOf("登录页面")){
        $('#alert-modal').on('closed.modal.amui', function(){
            $(this).off("closed.modal.amui");
            parent.location.reload();
        });
        alert("登录已失效,请重新登陆!");
        return;
    }
    if(mode){
        window.location.href = "/error/"+code;
        return;
    }
    if((typeof(jqXHR.responseJSON)!= 'undefined')){
        window.location.href = "/error/"+code;
    }else{
        error();
    }
}

/**
 * 跳转地址
 * @param url
 */
function goUrl(url) {
    window.open(url);
}

/**
 * Http get html 请求
 * @param url 请求地址
 * @param param 请求参数
 * @param completeHandler 回调函数
 */
function doGetHtml(url,param,completeHandler) {
    $.ajax({
        url:url,
        type:"GET",//请求方式
        dataType:"html",//返回参数的类型
        contentType:"utf-8",//发送请求的编码方式
        data:param,
        success:function (data) {//请求成功后调用的函数
            completeHandler(data);
        }
    })
}

/**
 * 菜单点击事件
 */
$('body').on('click','.doc-directory li a',function () {
    addIndex(this);
    let $url = $(this).attr('data-url');
    routingPage($url)
    $('#sidebar').offCanvas('close');
});

function addIndex(target) {
    let $allMenu = $('.doc-directory li a');
    $.each($allMenu,function (i,e) {
        if ($(e).hasClass('active'))
            $(e).removeClass('active');
    });
    $(target).addClass('active');
}

/**
 * 文档内跳转页面
 * @param $url
 */
function routingPage($url) {
    let $header = $url.substr($url.lastIndexOf('/')+1,1);
    let $version= $('.doc-directory').attr('data-version');
    doGetHtml($url,{},function(res){
        $('.doc-content').empty().prepend(res);
    });
    doGetHtml('/'+$version+'/header/'+$header,{},function(res){
        $('header').empty().prepend(res);
    });
    document.body.scrollTop = document.documentElement.scrollTop = 0;
}

/**
 * 统一的弹框提示
 */
function alert(message){
    $(".alert-modal-message").html(message);
    $(".alert-modal-title").html("提示");
    $(".alert-modal-button").html("好哒");
    $('#alert-modal').modal('open');
}

/**
 * 加载动画
 */
function loadingModal() {
    $('#loading-modal').modal('open');
}

/**
 * 结束加载动画
 */
function cloasloadingModal() {
    $('#loading-modal').modal('close');
}