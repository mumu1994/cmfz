<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">


    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('userMap'));

    option = {
        title : {
            text: '持明法洲App用户分布图',
            subtext: '2017年6月15日 最新数据',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['男','女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        series : [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                mapLocation: {
                    x: 'left'
                },
                selectedMode : 'multiple',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                }

            }, {
                name: '女',
                type: 'map',
                mapType: 'china',
                mapLocation: {
                    x: 'left'
                },
                selectedMode : 'multiple',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },

           }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    function a(data){
        var ret = [];
        for(var k in data){
            ret.push({name:k,value:data[k].nnum});
        }
        return ret;
    }
    $(function(){
        $.post("${pageContext.request.contextPath }/user/queryByProM.do",function(result){
            console.log(result);
            console.log(result.nnum);
            console.log(a(result));
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name:'男',
                    type:'map',
                    mapType: 'china',
                    mapLocation: {
                        x: 'left'
                    },
                    selectedMode : 'multiple',
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    data:[a(result)]

                }]
            })
        },"json");


            $.post("${pageContext.request.contextPath }/user/queryByProF.do",function(result){
                console.log(result);
                console.log(result.nnum);
                console.log(a(result));
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption({
                    series: [{
                        // 根据名字对应到相应的系列
                        name:'女',
                        type:'map',
                        mapType: 'china',
                        mapLocation: {
                            x: 'left'
                        },
                        selectedMode : 'multiple',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:[a(result)]

                    }]
                })
            },"json");
        })







</script>

<div id="userMap" style="width: 600px;height: 400px;"></div>