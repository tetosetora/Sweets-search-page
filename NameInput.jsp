<%@ page contentType="text/html; charset=Windows-31J"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="Windows-31J">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>検索フォーム</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="group1">
    <div class="inner">
      <div class="search_box">
        <form action="NameList.jsp" method="post">
          <p class="input_text">名前（の一部）を入力してください</p>
          <input type="search" name="name" required placeholder="キーワードを入力"  style="height: 35px">
          <input type="submit" name="submit" value="検索" style="height: 35px">
        </form>
      </div><!-- search_box -->
    </div><!-- .inner -->
  </div><!-- .group1 -->
</body>
</html>