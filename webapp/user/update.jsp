<jsp:include page="../common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" id="main">
    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>이름</th> <th>패스워드</th> <th>이메일</th> <th></th>
                </tr>
                </thead>
                <tbody>
                    <form action="/user/update" method="POST">
                        <tr>
                            <input type="hidden" name="userId" value="${user.userId}" />
                            <td><input type="text" name="name" value="${user.name}"></td>
                            <td><input type="text" name="password" value="${user.password}"></td>
                            <td><input type="text" name="email" value="${user.email}"></td>
                            <td><button type="submit" class="btn btn-success">수정</button>
                            </td>
                        </tr>
                    </form>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- script references -->
<script src="../js/jquery-2.2.0.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>
