<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-add',
        text: "添加",
        handler: function () {
            $("#dd").dialog("open");
        }
    }, '-', {
        iconCls: 'icon-edit',
        text: "修改",
        handler: function () {
            /*将选中行变为可编辑*/
            var row = $("#dg").edatagrid("getSelected");
            if (row == null) {
                alert("请选中行")
            } else {
                $("#dg").edatagrid("editRow", $("#dg").edatagrid("getRowIndex", row))
            }
        }
    }, '-', {
        iconCls: 'icon-remove',
        text: "删除",
        handler: function () {
            var row = $("#dg").edatagrid("getSelected");
            if (row==null){
                alert("请选中行")
            }else {
                $('#dg').edatagrid('destroyRow');
            }

        }
    }, '-', {
        iconCls: 'icon-save',
        text: "保存",
        handler: function () {
            $("#dg").edatagrid("saveRow")
        }
    }, '-', {
        iconCls: 'icon-save',
        text: "自定义导出",
        handler: function () {
            $("#custom_dialog").dialog("open")
        }
    }, '-', {
        iconCls: 'icon-save',
        text: "自定义导入",
        handler: function () {
            $("#inport_dialog").dialog("open")
        }
    }]
    $("#btn").click(function () {
//   提交form表单
        var titles = $("#customer_cc").combotree("getText");
        var value = $("#customer_cc").combotree("getValues");
        var c = "";
        $.each(value, function (index, title) {
            if (index != value.length - 1) {
                c += title + ",";
            } else {
                c += title;
            }
        })
        $('#customer_form').form('submit', {
            queryParams: {"titles": titles, "fields": c},
            url:"${pageContext.request.contextPath}/poi/customerExport.do"
        });
    })




    $(function () {
        $("#dg").edatagrid({

            singleSelect:false,
            url: "${pageContext.request.contextPath}/picture/show.do",
            method:"post",
            striped:true,
            updateUrl: "${pageContext.request.contextPath}/picture/update.do",
            destroyUrl:"${pageContext.request.contextPath}/picture/delete.do",
            columns: [[
                {field:'id',title:'图片ID',width:50,align:'center'/*,checkbox:true*/},
                {field:'title',title:'图片名称',width:50,align:'center'},
                {field:'imgPath',title:'图片路径',width:50,align:'center'},
                {field:'pdesc',title:'图片描述',width:50,align:'center'},
                {field:'status',title:'图片状态',width:50,align:'center',
                    editor: {
                        type: 'text',
                        options: {required: true}
                    }
                },
                {field:'pdate',title:'最后修改时间',width:50,align:'center'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                console.log(rowData.imgPath);
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片描述: ' + rowData.pdesc + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })




    })
    function submit() {
        $('#ff').form('submit', {
            url: "${pageContext.request.contextPath}/picture/add.do",

        })
    }
</script>


<table id="dg"></table>

<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:500px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                    $('#ff').form('submit', {
                     url:'${pageContext.request.contextPath}/picture/add.do',
                    success:function(data){
                          $('#dd').dialog('close');
                           $('#dg').edatagrid('reload')

                    }
                 })
				}
			},{
				text:'关闭',
				handler:function(){
				$('#dd').dialog('close');
				}
			}]">

    <form id="ff" method="post" enctype="multipart/form-data">
        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="title"  required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'图片名称'" style="width:100%;height: 100%">
        </div>

        <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
            <input name="pdesc" required="true" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'图片描述'" style="width:100%;height: 100%">
        </div>
        <div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
                <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;text-align: center;">
                    <span style="line-height: 40px;display: block;font-size: 14px">状&nbsp;&nbsp;态:</span>
                </span>
            <span style="height: 100%;width: 48%;display: inline-block;margin: 0;padding: 0;float: right">
                    <input class="easyui-switchbutton" name="status" data-options="onText:'yes',offText:'no',handleWidth:50,handleText:'状态'" style="width:100%;height: 100%">
                </span>
        </div>
        <%--<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input id="pdate" required="true"   class="easyui-datebox" data-options="prompt:'最后修改时间'" style="width:100%;height: 100%">
        </div>--%><%--name="pdate"--%>
        <div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
            <input name="img" required="true"  class="easyui-filebox"  style="width:100%;height: 100%">
        </div>
    </form>

</div>

<div id="custom_dialog" class="easyui-dialog" title="自定义导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="customer_form" method="post">
        <select id="customer_cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'${pageContext.request.contextPath}/json/comboTree.json',required:true,checkbox:true,onlyLeafCheck:true,multiple:true"></select>
    </form>


    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导出</a>

</div>


<div id="inport_dialog" class="easyui-dialog" title="自定义导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="inport_form" method="post">
        <select id="inport_cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'${pageContext.request.contextPath}/json/comboTree.json',required:true,checkbox:true,onlyLeafCheck:true,multiple:true"></select>
    </form>


    <a id="inport_btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导入</a>

</div>


