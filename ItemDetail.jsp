<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="java.util.ArrayList,sweets.*"%>
<%
request.setCharacterEncoding("Windows-31J");
int productId = Integer.parseInt(request.getParameter("id"));
SweetsDAO dao = new SweetsDAO();
SweetsDTO dto = dao.getDataById(productId);
dao.close();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="Windows-31J">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>検索結果</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="group2">
    <div class="inner">
      <p class="product_name">ID:<%=productId%>　商品名：<%=dto.getProductName()%></p>
      <div class="area">
        <div class="product_img">
          <img src="sweets_img/<%=dto.getProductImg()%>" alt="<%=dto.getProductName()%>">
        </div><!-- priduct_img -->
        <div class="product">
          <p><%=dto.getLot()%>個/<%=dto.getProductPrice()%>円</p>
        </div><!-- product -->
      </div><!-- area -->
      <div class="shop_text">
        <p>取扱店：<%=dto.getShopName()%></p>
        <p>場所：<%=dto.getStationName()%></p>
      </div><!-- shop_text -->
    </div><!-- .inner -->
  </div><!-- .group2 -->
</body>
</html>