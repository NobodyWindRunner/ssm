/**
 * Created by rgy19_000 on 2014/8/13.
 */
$(function () {
    $(".l-btn-left").css("line-height","30px");
    tabClose();
    tabCloseEven();
    openPwd();

    $('#editpass').click(function() {
        $('#w').window('open');
    });
})
function addTab(subtitle,url){
    if(!$('#tabs').tabs('exists',subtitle)){
        $('#tabs').tabs('add',{
            title:subtitle,
            content:createFrame(url),
            closable:true,
            width:$('#mainPanle').width()-10,
            height:$('#mainPanle').height()-26
        });
    }else{
        $('#tabs').tabs('select',subtitle);
    }
    tabClose();
}

function createFrame(url)
{
    var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    return s;
}

function tabClose()
{
    /*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function(){
        var subtitle = $(this).children("span").text();
        $('#tabs').tabs('close',subtitle);
    })

    $(".tabs-inner").bind('contextmenu',function(e){
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY,
        });

        var subtitle =$(this).children("span").text();
        $('#mm').data("currtab",subtitle);

        return false;
    });
}
//绑定右键菜单事件
function tabCloseEven()
{
    //关闭当前
    $('#mm-tabclose').click(function(){
        var currtab_title = $('#mm').data("currtab");
        $('#tabs').tabs('close',currtab_title);
    })
    //全部关闭
    $('#mm-tabcloseall').click(function(){
        $('.tabs-inner span').each(function(i,n){
            var t = $(n).text();
            $('#tabs').tabs('close',t);
        });
    });
    //关闭除当前之外的TAB
    $('#mm-tabcloseother').click(function(){
        var currtab_title = $('#mm').data("currtab");
        $('.tabs-inner span').each(function(i,n){
            var t = $(n).text();
            if(t!=currtab_title)
                $('#tabs').tabs('close',t);
        });
    });
    //关闭当前右侧的TAB
    $('#mm-tabcloseright').click(function(){
        var nextall = $('.tabs-selected').nextAll();
        if(nextall.length==0){
            return false;
        }
        nextall.each(function(i,n){
            var t=$('a:eq(0) span',$(n)).text();
            $('#tabs').tabs('close',t);
        });
        return false;
    });
    //关闭当前左侧的TAB
    $('#mm-tabcloseleft').click(function(){
        var prevall = $('.tabs-selected').prevAll();
        if(prevall.length==0){
            return false;
        }
        prevall.each(function(i,n){
            var t=$('a:eq(0) span',$(n)).text();
            $('#tabs').tabs('close',t);
        });
        return false;
    });

    //退出
    $("#mm-exit").click(function(){
        $('#mm').menu('hide');
    })
}

//设置窗口
function openPwd() {
    $('#w').window({
        title: '修改密码',
        width: 300,
        modal: true,
        shadow: true,
        closed: true,
        height: 160,
        resizable:false
    });
}

//关闭窗口
function closeWin() {
    $('#w').window('close');
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
    $.messager.alert(title, msgString, msgType);
}



