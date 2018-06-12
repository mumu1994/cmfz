<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">

    $(function () {
        $("#log").datagrid({

            singleSelect:false,
            url: "${pageContext.request.contextPath}/log/show.do",
            method:"post",
            striped:true,
            columns: [[
                {field:'id',title:'ID',width:50,align:'center'/*,checkbox:true*/},
                {field:'t_name',title:'管理员名字',width:50,align:'center'},
                {field:'t_thing',title:'事件内容',width:50,align:'center'},
                {field:'t_time',title:'事件时间',width:50,align:'center'},
                {field:'t_result',title:'事件状态',width:50,align:'center'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5

        })
    })

</script>


<table id="log"></table>



