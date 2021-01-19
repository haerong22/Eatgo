<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="${pageContext.request.contextPath}/user?cmd=join" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input name="username" type="text" class="form-control" placeholder="Enter username" id="username" required>
        </div>

        <div class="form-group">
            <label for="pwd">Password:</label>
            <input name="password" type="password" class="form-control" placeholder="Enter password" id="pwd" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input name="email" type="email" class="form-control" placeholder="Enter email" id="email" required>
        </div>
        <div class="d-flex justify-content-end">
            <button type="button" class="btn btn-info" onclick="goPopup()">주소검색</button>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input name="address" type="text" class="form-control" placeholder="Enter address" id="address" required readonly>
        </div>

        <button type="submit" class="btn btn-primary">회원가입 완료</button>
    </form>
</div>
<script>

    function goPopup(){
        const pop = window.open("/jspblog/user/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
    }

    function jusoCallBack(roadFullAddr){
        const addressEl = document.querySelector("#address");
        addressEl.value = roadFullAddr;
    }

</script>
</body>
</html>