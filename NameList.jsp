<%@ page contentType="text/html; charset=Windows-31J"%>
<%@ page import="java.util.ArrayList,sweets.*"%>
<%
request.setCharacterEncoding("Windows-31J");
String name = request.getParameter("name");
SweetsDAO dao = new SweetsDAO();
ArrayList<SweetsDTO> dtoAr = dao.getListByName(name);
dao.close();
%>
<head>
  <meta charset="Windows-31J">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>結果リスト一覧</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="group1">
    <div class="box1">
      <div class="key_words">
        <p>検索文字列：</p>
        <p style="color: #333;"><%= name %></p>
      </div>
      <hr>
      <div class="product_list">
        <%if(dtoAr != null && ! dtoAr.isEmpty()){ %>
          <table>
            <tr id="cate"><th>商品名</th><th>店名</th></tr>
            <%for(SweetsDTO a : dtoAr){%>
              <tr>
                <td>
                  <a href="ItemDetail.jsp?id=<%=a.getProductId()%>" class="widelink"><%= a.getProductName() %></a>
                </td>
                <td>
                  <%= a.getShopName() %>
                </td>
              </tr>
            <%}%>
          </table>
        <%}else{%>
          <p>対象データが存在していません。</p>
          <input type="button" value="戻る" style="height: 35px" onclick="location.href='NameInput.jsp'">
        <%}%>
      </div><!-- product_list -->
    </div><!-- box1 -->
  </div><!-- .group1 -->
</body>
</html>