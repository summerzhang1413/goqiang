<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.insertmanager.mName.value == ""){
                    alert("请填写管理员名！！！");
                    insertmanager.mName.focus();
                    return false;
                }
                if(document.insertmanager.mPwd.value ==  ""){
                    alert("请填写密码！！！")
                    insertmanager.mPwd.focus();
                    return false;
                }
                if(document.insertmanager.mPwd.value != document.insertmanager.mPwd2.value){
                    alert("密码不一致！！！");
                    insertmanager.mPwd.focus();
                    return false;
                }
                document.insertmanager.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="admintop.jsp"%>
        <br>
        <form name="insertmanager" action="<c:url value="/managerpage/insert"/>" method="post">
            <div style="text-align:center;">
                <table style="margin:auto; width:40%;" >
                    <tr >
                        <td align="left">管理员ID：</td>
                        <td align="left">
                            <input type="text" name="mName" >
                        </td>
                    </tr>
                    <tr >
                        <td align="left">管理员级别：</td>
                        <td align="left"><input type="radio" name="mLevel" value="1" checked>普通管理员</td>
                        <td align="left"><input type="radio" name="mLevel" value="0" >超级管理员</td>
                    </tr>
                    <tr >
                        <td align="left">管理员密码：</td>
                        <td align="left"><input type="password" name="mPwd"></td>
                    </tr>
                    <tr >
                        <td align="left">确认密码：</td>
                        <td align="left"><input type="password" name="mPwd2"></td>
                    </tr>
                    <tr align="center" >
                        <td align="left"><input type="button" value="提交" onclick="check()"></td>
                        <td align="left"><input type="reset" value="重置"></td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
