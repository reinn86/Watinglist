<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body style="width: 100%;">
        <%= request.getContextPath() %>
        
        <div style="margin-bottom: 10px; width:50%;height: 800px; float: left; overflow: scroll;">
            <table border="solid" style="text-align: center; width: 100%;">
                <thead style="width: 100%;">
                    <tr>
                        <th>予約番号</th>
                        <th>注文個数</th>
                        <th>調理完了</th>
                    </tr>
                </thead>
                <tbody>
                    <%= application.getAttribute("orderListHtml") %>
                </tbody>
            </table>
        </div>
        <!-- <%= application.getAttribute("orderListHtml") %> -->
        <div style="width:50%; float: right;">
            <!-- 追加 -->
            <form action="" method="post">
                <p>
                    <label>予約追加:
                        <input type="text" name="append" placeholder="注文する個数">
                        <input type="submit" name="append" value="追加">
                    </label>
                </p>
            </form>
            
            <!-- 調理完了 -->
            <form action="" method="post">
                <p>
                    <label>調理完了:
                        <input type="text" name="complate" placeholder="調理完了番号">
                        <input type="submit" name="complate" value="調理完了！">
                    </label>
                </p>
            </form>

            <!-- 完了-->
            <form action="" method="post">
                <p>
                    <label>受け取り済み:
                        <input type="text" name="cancel" placeholder="受け取り済み番号">
                        <input type="submit" name="cancel" value="完了">
                    </label>
                </p>
            </form>
        
            <!-- キャンセル -->
            <form action="" method="post">
                <p>
                    <label>キャンセル:
                        <input type="text" name="cancel" placeholder="キャンセル番号">
                        <input type="submit" name="cancel" value="キャンセル" style="background-color: RED;">
                    </label>
                </p>
            </form>
            <!-- トップページに戻る -->
            <form action="" method="post" style="float: right; width: auto; margin-right: 1rem;">
                <input type="submit" name="home" value="トップページ">
            </form>
        </div>
    </body>

    </html>