<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/29/2023
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tờ khai y tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form:form modelAttribute="person" action="/create" method="post">
    <div class="head">
        <div><h2>tờ khai y tế</h2></div>
        <div><p1>đây là tài liệu quan trọng</p1></div>
        <div><p2>khuyến cáo: khai báo thông tin sai</p2></div>
        <p>${mess}</p>
        <a href="/list">xem thông tin khai báo</a>
    </div>
    <div class="container">
        <div class="mb-1 row">
            <div class="col-sm-12">
                <label>họ tên</label>
                <input class="form-control" type="text" name="ten" placeholder="nhập họ và tên">
<%--                <form:input path="hoTen" />--%>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-sm-4">
                <label>năm sinh</label>
                <input class="form-control" type="text" name="namSinh">
            </div>
            <div class="col-sm-4">
                <label>giới tính</label>
                <input class="form-control" type="text" name="gioiTinh">
<%--                <form:select path="gioiTinh" items="${gioiTinh}"/>--%>
            </div>
            <div class="col-sm-4">
                <label>quốc tịch</label>
                <input class="form-control" type="text" name="quocTich">
            </div>
        </div>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>số hộ chiếu hoặc số CMND hoặc giấy thông hành</label>
                <input class="form-control" type="text" name="CMND">
            </div>
        </div>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>thông tin đi lại</label><br>
                <input type="radio" name="phuongTien" value="tauBay">tàu bay
                <input type="radio" name="phuongTien" value="tauThuyen">tàu thuyền
                <input type="radio" name="phuongTien" value="oTo">ô tô
                <input type="radio" name="phuongTien" value="khac">khác (ghi rõ)
            </div>
        </div>
        <div class="ms-2 row">
            <div class="col-sm-6">
                <label>số hiệu phương tiện</label>
                <input class="form-control" type="text"  placeholder="VD123" name="soPhuongTien">
            </div>
            <div class="col-sm-6">
                <label>số ghế</label>
                <input class="form-control" type="text" name="soGhe">
            </div>
        </div>
        <div class="ms-6 row">
            <div class="col-sm-2">
                <label>ngày khởi hành</label>
                <input class="form-control" type="text" name="ngayKH">
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="thangKH">
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="namKH">
            </div>
            <div class="col-sm-2">
                <label>ngày kết thúc</label>
                <input class="form-control" type="text" name="ngayKT">
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="thangKT">
            </div>
            <div class="col-sm-2">
                <input class="form-control" type="text" name="nameKT">
            </div>
        </div>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>trong vòng 14 ngày qua</label>
                <input class="form-control" type="text" name="denTinhTP">
            </div>
        </div>
        <div class="mb-3 row">
            <label>địa chỉ liên lạc</label>
            <div class="col-sm-4">
                <label>tỉnh/thành</label>
                <input class="form-control" type="text" name="tinhThanh">
            </div>
            <div class="col-sm-4">
                <label>quận/huyện</label>
                <input class="form-control" type="text" name="quanHuyen">
            </div>
            <div class="col-sm-4">
                <label>phường/xã</label>
                <input class="form-control" type="text" name="phuongXa">
            </div>
        </div>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>địa chỉ nơi ở</label>
                <input class="form-control" type="text" name="diaChi">
            </div>
        </div>
        <div class="ms-2 row">
            <div class="col-sm-6">
                <label>điện thoại</label>
                <input class="form-control" type="text" name="sdt">
            </div>
            <div class="col-sm-6">
                <label>email</label>
                <input class="form-control" type="text" name="email">
            </div>
        </div>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>trong vòng 14 ngày qua</label>
            </div>
        </div>
        <table class="table">
            <thead class="table-light">
            <tr>
                <th>triệu chứng</th>
                <th>có</th>
                <th>không</th>
                <th>triệu chứng</th>
                <th>có</th>
                <th>không</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>sốt</td>
                <td><input type="radio" name="sot" value="yes"></td>
                <td><input type="radio" name="sot" value="no"></td>
                <td>nôn/buồn nôn</td>
                <td><input type="radio" name="buonNon" value="yes"></td>
                <td><input type="radio" name="buonNon" value="no"></td>
            </tr>
            </tbody>
        </table>
        <div class="ms-1 row">
            <div class="col-sm-12">
                <label>lịch sử phơi nhiễm</label>
            </div>
        </div>
        <table class="table">
            <thead class="table-light">
            <tr>
                <th></th>
                <th>có</th>
                <th>không</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>đến trang trại chăn nuôi</td>
                <td><input type="radio" name="tiepXucDongVat" value="yes"></td>
                <td><input type="radio" name="tiepXucDongVat" value="no"></td>
            </tr>
            <tr>
                <td>tiếp xúc gần với người bệnh</td>
                <td><input type="radio" name="tiepXucnCoV" value="yes"></td>
                <td><input type="radio" name="tiepXucnCoV" value="no"></td>
            </tr>
            </tbody>
        </table>
        <div class="ms-1 row">
            <input type="submit" value="gửi tờ khai">
        </div>
    </div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
