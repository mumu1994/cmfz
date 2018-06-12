<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">



    var myChart = echarts.init(document.getElementById('user1'));

    var option = {
        title:{
            text:'持明法洲App活跃用户'
        },
        tooltip:{},   /*提示框*/
        legend:{
            data:['活跃用户']
        },    //图例

        xAxis:{
            data:["7天","14天","21天","28天"]
        },
        yAxis:{},

    }
    myChart.setOption(option);

    $.post("${pageContext.request.contextPath }/user/query.do",function(data){
        console.log(data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                type:'bar',
                data: data
            }]
        });
    },"json");



</script>

<div id="user1" style="width: 600px;height: 400px;"></div>