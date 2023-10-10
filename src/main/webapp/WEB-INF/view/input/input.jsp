<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>順番待ち確認システム</title>
</head>
<body>
    <div style="margin-bottom: 10px;">
        予約追加:<input type="button" value="追加">
    </div>
    <div style="margin-bottom: 10px;">
        <form>
            受け取り完了:<input type="text">
            <input type="button" value="受け取り完了">    
        </form>
    </div>
    <div style="margin-bottom: 10px;">
        <form>
            キャンセル:<input type="text">
            <input type="button" value="キャンセル">    
        </form>
    </div>
    <div style="margin-bottom: 10px;">
        <table style="text-align: center;">
            <!-- <caption>順番待ちリスト</caption> -->
            <thead>
                <tr><th>予約番号</th></tr>
            </thead>
            <tbody>
             <tr><td>1</td></tr>
             <tr><td>2</td></tr>
            </tbody>
        </table>
    </div>
	<form action="" method="post">
	<input type="submit" name="home" value="トップページ">
	</form>
</body>
</html>